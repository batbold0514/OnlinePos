package mn.infosystems.callcenter.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.callcenter.enums.OperatorStatus;
import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.Image;
import mn.infosystems.callcenter.model.Messages;
import mn.infosystems.callcenter.model.Role;
import mn.infosystems.callcenter.model.Users;
import mn.infosystems.callcenter.service.ImageService;
import mn.infosystems.callcenter.service.RoleService;
import mn.infosystems.callcenter.service.SsmLoggerService;
import mn.infosystems.callcenter.service.UsersService;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
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
		ModelDriven<Users>, ServletRequestAware ,SessionAware{

	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	private UsersService usersService;
	private RoleService roleService;
	private List<Users> usersList;
	private int usersHash;
	private String confirmPwd;
	private String roleString;
	private SsmLoggerService ssm = new SsmLoggerService();
	private HttpServletRequest request;
	private String statusString;
	private Map<String, Object> session;
	/*
	 * Start image fields
	 * */
	private List<File> files = new ArrayList<File>();
	private List<String> imFileName = new ArrayList<String>();
	private List<String> imContentType = new ArrayList<String>();
	private List<Image> imageList = new LinkedList<Image>();
	public ImageService imageService;
	/*
	 * enD imgae fields
	 * */
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
		this.usersList = usersService.getUsersByStatys(0l);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "usersListInActive", results = { @Result(name = "success", type = "tiles", location = "/users-list-inactive.tiles") })
	public String listInactive() {
		this.usersList = usersService.getUsersByStatys(1l);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "get-userList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/user-list-result.jsp") })
	public String getList() throws Exception {
		this.usersList = usersService.getUsersByStatys(0l);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "get-userList-ajax-inactive", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/user-list-result.jsp") })
	public String getListInactive() throws Exception {
		this.usersList = usersService.getUsersByStatys(1l);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
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
				if (user.getSenior_id() == null
						|| !roleString.equals("operator")) {
					user.setSenior_code(null);
					user.setSenior_id(null);
				} else {
					user.setSenior_code(usersService.get(user.getSenior_id())
							.getCode());
				}
				if (user.getStatus() == null)
					user.setStatus(OperatorStatus.NONE);
				if (statusString.equals("1"))
					user.setLoginStatus(StatusEnum.inActive);
				else
					user.setLoginStatus(StatusEnum.active);
				user.setRole(roleService.getRole(roleString));
				user.setPwd(MD5(user.getPwd()));
				imageList = (List<Image>) session.get("imageList");
				user.setImageOfList(imageList);
				usersService.saveOrUpdate(user);
				request.setAttribute("successUser", "true");
				ssm.logInfo(user);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("userName", "Unique");
		}
		return INPUT;
	}

	
	@Action(value = "save-user-ajax-inactive", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/user-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/user-result.jsp") })
	public String saveInactive() throws Exception {
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
				if (user.getSenior_id() == null
						|| !roleString.equals("operator")) {
					user.setSenior_code(null);
					user.setSenior_id(null);
				} else {
					user.setSenior_code(usersService.get(user.getSenior_id())
							.getCode());
				}
				if (user.getStatus() == null)
					user.setStatus(OperatorStatus.NONE);
				if (statusString.equals("1"))
					user.setLoginStatus(StatusEnum.inActive);
				else
					user.setLoginStatus(StatusEnum.active);
				user.setRole(roleService.getRole(roleString));
				user.setPwd(MD5(user.getPwd()));
				usersService.saveOrUpdate(user);
				request.setAttribute("successUser", "true");
				ssm.logInfo(user);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("userName", "Unique");
		}
		return INPUT;
	}
	@SkipValidation
	@SuppressWarnings("unchecked")
	@Action(value = "images-edit-save", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp") })
	public String saveImagesAction() throws IOException {
		try {
			if (files.size() <= 0) {
				request.setAttribute("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}

			String filePathd = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\uploads";
			String filePath = "c:/temp/";
			imageList = (List<Image>) session.get("imageList");
			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).length() > 5500000) {
					request.setAttribute("imageResult",  Messages.getString("maxSizeLimitError"));
					return INPUT;
				}
				Image image = new Image();
				String name = imFileName.get(i);
				image.setName(name);
				image.setContentType(imContentType.get(i));
				image.setIsMain(false);
				File fileToCreate = new File(filePath, name);
				FileUtils.copyFile(files.get(i), fileToCreate);
				File fileToCreated = new File(filePathd, name);
				FileUtils.copyFile(files.get(i), fileToCreated);
				imageService.saveOrUpdate(image);
				imageList.add(image);
			}
			session.put("imageList", imageList);
			request.setAttribute("imageResult", "success");
			return SUCCESS;
		} catch (Exception e) {
			request.setAttribute("imageResult", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}
	
	@SkipValidation
	@Action(value = "images-save", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp") })
	public String ImagesaveAction() {
		try {
			if (files.size() <= 0) {
				request.setAttribute("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}

			String filePathd = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\uploads";
			String filePath = "c:/temp/";
			imageList = new LinkedList<Image>();
			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).length() > 5500000) {
					request.setAttribute("imageResult",  Messages.getString("maxSizeLimitError"));
					return INPUT;
				}
				Image image = new Image();
				String name = imFileName.get(i);
				image.setName(name);
				image.setContentType(imContentType.get(i));
				if (i == 0) {
					image.setIsMain(true);
				} else {
					image.setIsMain(false);
				}
				File fileToCreate = new File(filePath, name);
				FileUtils.copyFile(files.get(i), fileToCreate);
				File fileToCreated = new File(filePathd, name);
				FileUtils.copyFile(files.get(i), fileToCreated);
				imageService.saveOrUpdate(image);
				imageList.add(image);
			}
			session.put("imageList", imageList);
			request.setAttribute("imageResult", "success");
			return SUCCESS;
		} catch (Exception e) {
//			request.setAttribute("imageResult", Messages.getString("somethingWrong"));
			request.setAttribute("imageResult", e.toString());
			return ERROR;
		}
	}
	@SkipValidation
	@Action(value = "image-list", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/users/ajax-image-list-response.jsp")
	})
	public String imageList(){
		return SUCCESS;
	}
	@SkipValidation
	@Action(value = "setId-image-list", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/users/ajax-image-list-response.jsp")
	})
	public String imageList2(){
		imageList = usersService.get(user.getId()).getImageOfList();
		session.put("imageList", imageList);
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "new-image-list", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/users/ajax-image-list-tiles.jsp")
	})
	public String nweImageList(){
		imageList = usersService.get(user.getId()).getImageOfList();
		session.put("imageList", imageList);
		return SUCCESS;
	}
	@SkipValidation
	@Action(value = "delete-pm-images", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/users/ajax-image-list-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp") })
	public String deleteImagesAction() {
		try {
			if (user.getId() == null || user.getId() == 0l) {
				addFieldError("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}

			String[] imageIds = request.getParameterValues("imageIds[]");
			if (imageIds == null || imageIds.length <= 0) {
				addFieldError("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}

			Users u = new Users();
			u = usersService.get(user.getId());
			if (u == null) {
				addFieldError("imageResult", Messages.getString("wrongIdError"));
				return INPUT;
			}
			String filePathd = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\uploads";
			String filePath = "c:/temp/";
			for (int j = 0; j < imageIds.length; j++) {
				Long imageId = 0l;
				try {
					imageId = Long.parseLong(imageIds[j]);
				} catch (NumberFormatException e) {
					addFieldError("imageResult",
							Messages.getString("numberIdError"));
					return INPUT;
				}

				Image image = new Image();
				image = imageService.get(imageId);
				if (image == null) {
					addFieldError("imageResult",
							Messages.getString("wrongIdError"));
					return INPUT;
				}

				for (int i = 0; i < u.getImageOfList().size(); i++) {
					if (u.getImageOfList().get(i).getId() == image.getId()) {
						u.getImageOfList().remove(i);
						imageService.delete(image);
						FileUtils.deleteQuietly(new File(filePath + "\\"
								+ image.getName()));
						FileUtils.deleteQuietly(new File(filePathd + "\\"
								+ image.getName()));
						break;
					}
				}
				
				usersService.saveOrUpdate(u);
			}
			session.put("imageList", u.getImageOfList());
			return SUCCESS;
		} catch (Exception e) {
			addFieldError("imageResult", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}
		
	@SkipValidation
	@Action(value = "set-main-image-pm", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/users/ajax-image-list-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax/users/ajax-error-response.jsp") })
	public String setMainImageAction() {
		try {
			if (user.getId() == null || user.getId() == 0l) {
				addFieldError("id", Messages.getString("emptyError"));
				return INPUT;
			}
			String imageId = (String) request.getParameter("imageId");
			if (imageId == null || imageId.trim().equals("")) {
				addFieldError("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}
			Users u = new Users();
			u = usersService.get(user.getId());
			if (u == null) {
				addFieldError("imageResult", Messages.getString("wrongIdError"));
				return INPUT;
			}
			Long imageIdLong = 0l;
			try {
				imageIdLong = Long.parseLong(imageId);
			} catch (NumberFormatException e) {
				addFieldError("imageResult", Messages.getString("numberIdError"));
				return INPUT;
			}
			
			Image image = new Image();
			image = imageService.get(imageIdLong);
			if (image == null) {
				addFieldError("imageResult", Messages.getString("wrongIdError"));
				return INPUT;
			}
			for (int i = 0; i < u.getImageOfList().size(); i++) {
				if (u.getImageOfList().get(i).getId() == image.getId()) {
					u.getImageOfList().get(i).setIsMain(true);
				}else{
					u.getImageOfList().get(i).setIsMain(false);
				}
			}
			session.put("imageList", u.getImageOfList());
			return SUCCESS;
		} catch (Exception e) {
			addFieldError("imageResult", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}
	
	public StatusEnum[] getStatuses() {
		return StatusEnum.values();
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

	public List<Users> getSenoiorops() {
		return usersService.getSeniorOperators();
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}

	public void setImageService(final ImageService imageService) {
		this.imageService = imageService;
	}
	public List<File> getIm() {
		return files;
	}
	public void setIm(List<File> Im) {
		this.files = Im;
	}
	public List<String> getImFileName() {
		return imFileName;
	}
	public void setImFileName(List<String> imFileName) {
		this.imFileName = imFileName;
	}
	public List<String> getImContentType() {
		return imContentType;
	}
	public void setImContentType(List<String> imContentType) {
		this.imContentType = imContentType;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
