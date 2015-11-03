package mn.infosystems.mobile.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.mobile.model.Messages;
import mn.infosystems.mobile.model.Role;
import mn.infosystems.mobile.model.Users;
import mn.infosystems.mobile.service.MobileLoggerService;
import mn.infosystems.mobile.service.RoleService;
import mn.infosystems.mobile.service.UsersService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
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
		ModelDriven<Users>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	private UsersService usersService;
	private RoleService roleService;
	private List<Users> usersList;
	private int usersHash;
	private String confirmPwd;
	private String roleString;
	private HttpServletRequest request;
	private String statusString;

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
	@Action(value = "usersList", results = { @Result(name = "success", type = "tiles", location = "/users-list.tiles") })
	public String list() throws Exception {
		this.usersList = usersService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "get-userList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/user-list-result.jsp") })
	public String getList() throws Exception {
		this.usersList = usersService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-user-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/user-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/user-result.jsp") })
	public String save2() throws Exception {
		try {
			if (user != null && user.hashCode() != usersHash) {
				boolean check = false;
				if (usersService.hasUser(user.getUserName(), user.getId())) {
					addFieldError("userName", Messages.getString("User.name"));
					check = true;
				}
				if (roleString.equals("")) {
					addFieldError("roleString", Messages.getString("User.role"));
					check = true;
				}
				if (user.getCode().equals("")) {
					addFieldError("code", Messages.getString("User.code"));
					check = false;
				}
				if (!user.getPwd().trim().equals(confirmPwd.trim())) {
					addFieldError("pwd", Messages.getString("User.password"));
					check = true;
				}
				if (check)
					return INPUT;
				user.setRole(roleService.getRole(roleString));
				user.setPwd(MD5(user.getPwd()));
				usersService.saveOrUpdate(user);
				request.setAttribute("successUser", "true");
				MobileLoggerService.writeLog(user);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("userName", "Unique");
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

}
