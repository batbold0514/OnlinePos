package mn.infosystems.mobile.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.mobile.enums.Category;
import mn.infosystems.mobile.model.Image;
import mn.infosystems.mobile.model.Messages;
import mn.infosystems.mobile.model.SoundFilePath;
import mn.infosystems.mobile.model.SubGroup;
import mn.infosystems.mobile.model.TeachingAid;
import mn.infosystems.mobile.model.TextUpload;
import mn.infosystems.mobile.model.VideoFilePath;
import mn.infosystems.mobile.service.ImageService;
import mn.infosystems.mobile.service.MobileStaticFunctions;
import mn.infosystems.mobile.service.SoundFilePathService;
import mn.infosystems.mobile.service.SubGroupService;
import mn.infosystems.mobile.service.TeachingAidService;
import mn.infosystems.mobile.service.TextUploadService;
import mn.infosystems.mobile.service.VideoFilePathService;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/") })
public class SubGroupAction extends ActionSupport implements ModelDriven<SubGroup>
,ServletRequestAware ,Preparable ,SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Map<String, Object> session;
	private SubGroup subGroup= new SubGroup();
	private List<SubGroup> sublist;
	@SuppressWarnings("unused")
	private int subHash;
	private SubGroupService subGroupService;
	private String categoryId;
	private String subGroupName;
	private String showlistStr;
	private TeachingAidService teachingAidService;
	private String aidName;
	private String aidDescription;
	private List<String> sounds;
	private List<String> videos ;
	private List<Image> textFiles;
	private List<Image> images;
	private SoundFilePathService soundFilePathService;
	private VideoFilePathService videoFilePathService;
	
	/*file upload*/
	private List<File> files = new ArrayList<File>();
	private List<String> imFileName = new ArrayList<String>();
	private List<String> imContentType = new ArrayList<String>();
	private List<Image> imageList = new LinkedList<Image>();
	private List<TextUpload> textFileList = new LinkedList<TextUpload>();
	public ImageService imageService;
	public TextUploadService textUploadService;
	/* */

	public void prepare() throws Exception {
		if(subGroup !=null && subGroup.getId()!=null){
			subGroup = subGroupService.get(subGroup.getId());
			subHash = subGroup.hashCode();
		}
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public SubGroup getModel() {
		return subGroup;
	}

	public List<SubGroup> getSublist() {
		return sublist;
	}

	public void setSubGroupService(final SubGroupService subGroupService) {
		this.subGroupService = subGroupService;
	}
	@Action(value = "removeTeachingAid", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/editTeachingAid.jsp")
	})
	public String removeTeachingAid(){
		subGroup = subGroupService.get(subGroup.getId());
		Long taId = Long.parseLong(request.getParameter("taId"));
		TeachingAid ta =null;
		List<TeachingAid> list = new LinkedList<TeachingAid>();
		for(int i = 0;i<subGroup.getListOfTeachingAid().size();i++){
			if(subGroup.getListOfTeachingAid().get(i).getId().equals(taId)){
				ta = subGroup.getListOfTeachingAid().get(i);
			}else{
				list.add(subGroup.getListOfTeachingAid().get(i));
			}
		}
		subGroup.setListOfTeachingAid(list);
		subGroupService.saveOrUpdate(subGroup);
		teachingAidService.delete(ta);
		return SUCCESS;
	}
	@Action(value = "editTeachingAid", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/editTeachingAid.jsp")
	})
	public String editShowTeachingAid(){
		TeachingAid ta = teachingAidService.get(Long.parseLong(request.getParameter("id")));
		session.put("teachingAid",ta);
		if(ta.getListOfvideo().isEmpty()){
			session.put("video", 0);
		}else{
			session.put("video", ta.getListOfvideo().size()-1);
		}
		if(ta.getListOfsounds().isEmpty()){
			session.put("sound", 0);
		}else{
			session.put("sound", ta.getListOfsounds().size()-1);
		}
		session.put("imageList", ta.getListOfImages());
		session.put("textFileList", ta.getListOfText());
		return SUCCESS;
	}
	@Action(value = "KeepingAndCredit" , results = {@Result(name = "success" , type ="tiles" , location = "/keepingAndCredit-list.tiles")})
	public String showSubGroups(){
		sublist = subGroupService.getListCategory(MobileStaticFunctions.KeepingAndCredit,MobileStaticFunctions.level);
		request.setAttribute("subGroupList", sublist);
		return SUCCESS;
	}
	@Action(value = "save-subgroup-ajax",results= {
		@Result(name = "success" ,location = "/WEB-INF/content/ajax-subGroup/subGroup-result.jsp"),	
		@Result(name = "input" ,location = "/WEB-INF/content/ajax-subGroup/subGroup-result.jsp")	
	})
	public String save_ajax(){
		subGroup.setCategory(Category.get(categoryId));
		subGroup.setSubGrouplevel(MobileStaticFunctions.level);
		subGroupService.saveOrUpdate(subGroup);
		request.setAttribute("categorySuccess", true);
		return SUCCESS;
	}
	
	@Action(value = "showTeachingAid", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/addTeachingAid.jsp")
	})
	public String showTeachingAid(){
		request.setAttribute("subGroup", subGroupService.get(Long.parseLong(request.getParameter("id"))));
//		sounds = new LinkedList<>();
		session.put("video", 0);
		session.put("sound", 0);
		session.put("imageList", new LinkedList<Image>());
		session.put("textFileList", new LinkedList<Image>());
		return SUCCESS;
	}
	@Action(value = "showSubGroup", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/addSubGroup.jsp")
	})
	public String showSubGroup(){
		request.setAttribute("subGroup", subGroupService.get(Long.parseLong(request.getParameter("id"))));
		return SUCCESS;
	}
	@Action(value = "addSubGroupAjax", results = {
			@Result(name = "success",location = "/WEB-INF/content/ajax-subGroup/subGroup-result.jsp")
	})
	public String addSubGroup(){
		subGroup.setCategory(Category.get(categoryId));
		List<SubGroup> oldSubGrouplist =subGroupService.getSubGroupList(subGroup.getId()); 
		List<TeachingAid> old = subGroupService.getTeachingAidList(subGroup.getId());
		SubGroup sg = new SubGroup();
		sg.setId(null);
		sg.setCategory(Category.get(categoryId));
		sg.setGroupName(subGroupName);
		subGroupService.save(sg);
		sg.setSubGrouplevel(subGroup.getSubGrouplevel()+1);
		subGroup.setListOfTeachingAid(old);
		oldSubGrouplist.add(sg);
		subGroup.setListOfSubGroup(oldSubGrouplist);
		subGroupService.saveOrUpdate(subGroup);
		request.setAttribute("categorySuccess", true);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value = "addTeachingAidAjax", results = {
			@Result(name = "success", location= "/WEB-INF/content/ajax-subGroup/subGroup-result.jsp")
	})
	public String addTeachingAid(){
		TeachingAid teachingAid = new TeachingAid();
		teachingAid.setLastUpdate(new Date());
		teachingAid.setWritten(new Date());
		teachingAid.setName(aidName);
		teachingAid.setDescription(aidDescription);
		List<Image> list = (List<Image>) session.get("imageList");
		teachingAid.setListOfImages(list);
		List<TextUpload> listTest =(List<TextUpload>) session.get("textFileList");
		teachingAid.setListOfText(listTest);
		List<VideoFilePath> listvideo = new  LinkedList<VideoFilePath>();
		for(String str:videos){
			if(!str.equals("")){
				VideoFilePath file = new VideoFilePath();
				file.setPath(str);
				videoFilePathService.saveOrUpdate(file);
				listvideo.add(file);
			}
		}
		teachingAid.setListOfvideo(listvideo);
		List<SoundFilePath> list1 = new  LinkedList<SoundFilePath>();
		for(String str:sounds){
			if(!str.equals("")){
				SoundFilePath file = new SoundFilePath();
				file.setPath(str);
				soundFilePathService.saveOrUpdate(file);
				list1.add(file);
			}
		}
		teachingAid.setListOfsounds(list1);
		teachingAidService.save(teachingAid);
		subGroup = subGroupService.get(subGroup.getId());
		subGroup.getListOfTeachingAid().add(teachingAid);
//		subGroupService.saveOrUpdate(subGroup);
		request.setAttribute("categorySuccess", true);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value = "editTeachingAidAjax", results = {
			@Result(name = "success", location= "/WEB-INF/content/ajax-subGroup/subGroup-result.jsp")
	})
	public String editTeachingAid(){
		TeachingAid teachingAid = teachingAidService.get(Long.parseLong(request.getParameter("id")));
		teachingAid.setLastUpdate(new Date());
		teachingAid.setName(aidName);
		teachingAid.setDescription(aidDescription);
		List<Image> list = (List<Image>) session.get("imageList");
		teachingAid.setListOfImages(list);
		List<TextUpload> listTest =(List<TextUpload>) session.get("textFileList");
		teachingAid.setListOfText(listTest);
		List<VideoFilePath> listvideo = new  LinkedList<VideoFilePath>();
		for(String str:videos){
			if(!str.equals("")){
				VideoFilePath file = new VideoFilePath();
				file.setPath(str);
				videoFilePathService.saveOrUpdate(file);
				listvideo.add(file);
			}
		}
		teachingAid.setListOfvideo(listvideo);
		List<SoundFilePath> list1 = new  LinkedList<SoundFilePath>();
		for(String str:sounds){
			if(!str.equals("")){
				SoundFilePath file = new SoundFilePath();
				file.setPath(str);
				soundFilePathService.saveOrUpdate(file);
				list1.add(file);
			}
		}
		teachingAid.setListOfsounds(list1);
		teachingAidService.saveOrUpdate(teachingAid);
//		subGroupService.saveOrUpdate(subGroup);
		request.setAttribute("categorySuccess", true);
		return SUCCESS;
	}
	@Action(value = "save-images", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp") })
	public String saveImagesAction() throws IOException {
		try {
			if (files.size() <= 0) {
				request.setAttribute("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}

			String filePathd = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\uploads";
			String filePath = System.getProperty("user.dir")+"/uploadImage";
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
	@SuppressWarnings("unchecked")
	@Action(value = "save-edit-images", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp") })
	public String saveEditImagesAction() throws IOException {
		try {
			if (files.size() <= 0) {
				request.setAttribute("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}

			String filePathd = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\uploads";
			String filePath = System.getProperty("user.dir")+"/uploadImage";
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
	@Action(value = "new-image-list", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/ajax-image-list-tiles.jsp")
	})
	public String newImageList(){
		return SUCCESS;
	}
	@Action(value = "save-textFile", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp") })
	public String saveTextFileAction() throws IOException {
		try {
			if (files.size() <= 0) {
				request.setAttribute("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}
			
			String filePathd = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\textFiles";
			String filePath = System.getProperty("user.dir")+"/uploadFile";
			textFileList = new LinkedList<TextUpload>();
			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).length() > 5500000) {
					request.setAttribute("imageResult",  Messages.getString("maxSizeLimitError"));
					return INPUT;
				}
				TextUpload textFile = new TextUpload();
				String name = imFileName.get(i);
				textFile.setName(name);
				textFile.setContentType(imContentType.get(i));
				File fileToCreate = new File(filePath, name);
				FileUtils.copyFile(files.get(i), fileToCreate);
				File fileToCreated = new File(filePathd, name);
				FileUtils.copyFile(files.get(i), fileToCreated);
				textUploadService.saveOrUpdate(textFile);
				textFileList.add(textFile);
			}
			session.put("textFileList", textFileList);
			request.setAttribute("imageResult", "success");
			return SUCCESS;
		} catch (Exception e) {
			request.setAttribute("imageResult", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}
	@SuppressWarnings("unchecked")
	@Action(value = "save-edit-textFile", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax-subGroup/ajax-error-response.jsp") })
	public String saveEditTextFileAction() throws IOException {
		try {
			if (files.size() <= 0) {
				request.setAttribute("imageResult", Messages.getString("emptyError"));
				return INPUT;
			}
			
			String filePathd = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\textFiles";
			String filePath = System.getProperty("user.dir")+"/uploadFile";
			textFileList = (List<TextUpload>) session.get("textFileList");
			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).length() > 5500000) {
					request.setAttribute("imageResult",  Messages.getString("maxSizeLimitError"));
					return INPUT;
				}
				TextUpload textFile = new TextUpload();
				String name = imFileName.get(i);
				textFile.setName(name);
				textFile.setContentType(imContentType.get(i));
				File fileToCreate = new File(filePath, name);
				FileUtils.copyFile(files.get(i), fileToCreate);
				File fileToCreated = new File(filePathd, name);
				FileUtils.copyFile(files.get(i), fileToCreated);
				textUploadService.saveOrUpdate(textFile);
				textFileList.add(textFile);
			}
			session.put("textFileList", textFileList);
			request.setAttribute("imageResult", "success");
			return SUCCESS;
		} catch (Exception e) {
			request.setAttribute("imageResult", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}
	@Action(value = "new-textFile-list", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/ajax-textFile-list.jsp")
	})
	public String newTextFileList(){
		return SUCCESS;
	}
	
	@Action(value = "addSound", results = {
			@Result(name = "success",location = "/WEB-INF/content/ajax-subGroup/addSoundList.jsp")
	})
	public String addSound(){
		session.put("sounds", sounds);
		int count = (Integer) session.get("sound");
		session.put("sound", count+1);
		return SUCCESS;
	}
	@Action(value = "addVideos", results = {
			@Result(name = "success",location = "/WEB-INF/content/ajax-subGroup/addVideoList.jsp")
	})
	public String addVideo(){
		session.put("videos", videos);
		int count = (Integer) session.get("video");
		session.put("video", count+1);
		return SUCCESS;
	}
	
	@Action(value = "editSubGroup", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/editSubGroup.jsp")
	})
	public String editShowSubGroup(){
		request.setAttribute("subGroup", subGroupService.get(Long.parseLong(request.getParameter("id"))));
		return SUCCESS;
	}
	@Action(value = "editSubGroupAjax", results = {
			@Result(name = "success",location = "/WEB-INF/content/ajax-subGroup/subGroup-result.jsp")
	})
	public String editSubGroupAjax(){
		subGroup = subGroupService.get(subGroup.getId());
		subGroup.setGroupName(subGroupName);
		subGroupService.saveOrUpdate(subGroup);
		request.setAttribute("categorySuccess", true);
		return SUCCESS;
	}
	@Action(value = "removeSubGroup", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-subGroup/subGroup-result.jsp")
	})
	public String removeSubGroup(){
		subGroup = subGroupService.get(Long.parseLong(request.getParameter("id")));
		subGroupService.delete(subGroup);
		return SUCCESS;
	}
	public Category[] getCategories(){
		return Category.values();
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getSubGroupName() {
		return subGroupName;
	}
	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}
	public String getShowlistStr() {
		return showlistStr;
	}
	public void setShowlistStr(String showlistStr) {
		this.showlistStr = showlistStr;
	}
	public void setTeachingAidService(final TeachingAidService teachingAidService) {
		this.teachingAidService = teachingAidService;
	}
	public String getAidName() {
		return aidName;
	}
	public void setAidName(String aidName) {
		this.aidName = aidName;
	}
	public String getAidDescription() {
		return aidDescription;
	}
	public void setAidDescription(String aidDescription) {
		this.aidDescription = aidDescription;
	}
	public List<Image> getTextFiles() {
		return textFiles;
	}
	public void setTextFiles(List<Image> textFiles) {
		this.textFiles = textFiles;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
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
	public List<String> getVideos() {
		return videos;
	}
	public void setVideos(List<String> videos) {
		this.videos = videos;
	}
	public List<String> getSounds() {
		return sounds;
	}
	public void setSounds(List<String> sounds) {
		this.sounds = sounds;
	}
	public void setSoundFilePathService(final SoundFilePathService soundFilePathService) {
		this.soundFilePathService = soundFilePathService;
	}
	public void setVideoFilePathService(final VideoFilePathService videoFilePathService) {
		this.videoFilePathService = videoFilePathService;
	}
	public void setTextUploadService(final TextUploadService textUploadService) {
		this.textUploadService = textUploadService;
	}
	public List<TextUpload> getTextFileList() {
		return textFileList;
	}
	public void setTextFileList(List<TextUpload> textFileList) {
		this.textFileList = textFileList;
	}
	
	

}
