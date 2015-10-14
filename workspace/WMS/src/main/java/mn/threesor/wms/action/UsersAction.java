package mn.threesor.wms.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.Role;
import mn.threesor.wms.model.Users;
import mn.threesor.wms.service.RoleService;
import mn.threesor.wms.service.UsersService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class UsersAction extends ActionSupport implements Preparable,
		ModelDriven<Users> {

	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	private UsersService usersService;
	private RoleService roleService;
	private List<Users> usersList;
	private int usersHash;
	private String confirmPwd = "";
	private String roleString;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Users getModel() {
		return user;
	}

	public void prepare() throws Exception {
		if (user != null && user.getId() != null) {
			this.user = usersService.get(user.getId());
			this.usersHash = user.hashCode();
		}
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public void setRoleService(final RoleService roleService) {
		this.roleService = roleService;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	@SkipValidation
	@Action(value = "userInput", results = { @Result(name = "success", type = "tiles", location = "/users.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "userEditt", results = { @Result(name = "success", type = "tiles", location = "/user-edit.tiles") })
	public String execute1() throws Exception {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "usersList", results = { @Result(name = "success", type = "tiles", location = "/users-list.tiles") })
	public String list() throws Exception {
		this.usersList = usersService.findAll();
		return SUCCESS;
	}

	@Action(value = "userSave", results = {
			@Result(name = "success", type = "redirectAction", location = "usersList", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/users.tiles") })
	public String save() throws Exception {
		try {
			if (user != null && user.hashCode() != usersHash) {
				if (usersService.hasUser(user.getUserName())) {
					addFieldError("userName", Messages.getString("User.name"));
					return INPUT;
				}
				user.setRole(roleService.getRole(roleString));
				if (user.getPwd() == null || confirmPwd == null) {
					addFieldError("pwd",
							Messages.getString("confirmPwdErrorNull"));
					addFieldError("confirmPwd",
							Messages.getString("confirmPwdErrorNull"));
					return INPUT;
				}
				if (confirmPwd.equals("") && user.getPwd().equals("")) {
					addFieldError("confirmPwd",
							Messages.getString("confirmPwdError"));
					addFieldError("pwd", Messages.getString("confirmPwdError"));
					return INPUT;
				}
				if (user.getPwd().equals(confirmPwd)) {
					user.setPwd(MD5(user.getPwd()));
					usersService.saveOrUpdate(user);
					return SUCCESS;
				} else
					addFieldError("pwd", Messages.getString("User.password"));
				return INPUT;
			}
		} catch (Exception e) {
			addFieldError("userName", "Exception : " + e);
		}
		return INPUT;
	}

	@SkipValidation
	@Action(value = "userEdit", results = {
			@Result(name = "success", type = "redirectAction", location = "usersList", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/user-edit.tiles") })
	public String edit() throws Exception {
		if (user != null && user.hashCode() != usersHash) {
			user.setPwd(checkPwd(user.getPwd()));
			if (usersService.hasUser(user.getUserName(), user.getId())) {
				addFieldError("userName", Messages.getString("User.name"));
				return INPUT;
			}
			if (user.getPwd() == null) {
				addFieldError("pwd", Messages.getString("confirmPwdErrorNull"));
				return INPUT;
			}
			if (confirmPwd == null) {
				addFieldError("confirmPwd",
						Messages.getString("confirmPwdErrorNull"));
				return INPUT;
			}
			if (!user.getPwd().equals("") && user.getPwd().equals(confirmPwd)) {
				user.setPwd(MD5(user.getPwd()));
				user.setRole(roleService.getRole(roleString));
				usersService.saveOrUpdate(user);
				return SUCCESS;
			} else {
				addFieldError("pwd", Messages.getString("User.password"));
				return INPUT;
			}
		}
		return INPUT;
	}

	public List<Role> getRoles() {
		return roleService.findAll();
	}

	public int getUsersHash() {
		return usersHash;
	}

	public void setUsersHash(int usersHash) {
		this.usersHash = usersHash;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(final Users user) {
		this.user = user;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		confirmPwd = confirmPwd.matches("[A-Za-zА-Яа-яӨөҮүЁё0-9]{4,64}") ? confirmPwd
				: null;
		this.confirmPwd = confirmPwd;
	}

	private static String convertedToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < data.length; i++) {
			int halfOfByte = (data[i] >>> 4) & 0x0F;
			int twoHalfBytes = 0;

			do {
				if ((0 <= halfOfByte) && (halfOfByte <= 9)) {
					buf.append((char) ('0' + halfOfByte));
				}

				else {
					buf.append((char) ('a' + (halfOfByte - 10)));
				}

				halfOfByte = data[i] & 0x0F;

			} while (twoHalfBytes++ < 1);
		}
		return buf.toString();
	}

	private static String MD5(String text) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] md5 = new byte[64];
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md5 = md.digest();
		return "MD5:" + convertedToHex(md5);
	}

	@RequiredStringValidator(key = "validation.role")
	public String getRoleString() {
		return roleString;
	}

	public void setRoleString(String roleString) {
		this.roleString = roleString;
	}

	private String checkPwd(String pwd) {
		return pwd.matches("[A-Za-zА-Яа-яӨөҮүЁё0-9]{4,64}") ? pwd : pwd;
	}
}