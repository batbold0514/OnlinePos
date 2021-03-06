package mn.infosystems.estimator.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.estimator.enums.CarType;
import mn.infosystems.estimator.enums.Confirm;
import mn.infosystems.estimator.enums.CrashGrade;
import mn.infosystems.estimator.enums.EmployeeStatus;
import mn.infosystems.estimator.enums.EstimateMaterialEnum;
import mn.infosystems.estimator.enums.InsuranceType;
import mn.infosystems.estimator.model.BreakedPart;
import mn.infosystems.estimator.model.CarFactory;
import mn.infosystems.estimator.model.CarMark;
import mn.infosystems.estimator.model.Company;
import mn.infosystems.estimator.model.Cost;
import mn.infosystems.estimator.model.Customer;
import mn.infosystems.estimator.model.Defect;
import mn.infosystems.estimator.model.Employee;
import mn.infosystems.estimator.model.Image;
import mn.infosystems.estimator.model.Messages;
import mn.infosystems.estimator.service.BreakedPartService;
import mn.infosystems.estimator.service.CarFactoryService;
import mn.infosystems.estimator.service.CarMarkService;
import mn.infosystems.estimator.service.CompanyService;
import mn.infosystems.estimator.service.CostService;
import mn.infosystems.estimator.service.CustomerService;
import mn.infosystems.estimator.service.DefectService;
import mn.infosystems.estimator.service.EmployeeService;
import mn.infosystems.estimator.service.EstimaterStaticFunctions;
import mn.infosystems.estimator.service.ImageService;

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
@Namespaces(value = { @Namespace("/admin"),@Namespace("/user") ,@Namespace("/employee")})
public class CustomerAction extends ActionSupport implements Preparable,ModelDriven<Customer>,ServletRequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	private Customer customer = new Customer();
	private List<Customer> customerList;
	@SuppressWarnings("unused")
	private int customerHash;
	private CustomerService customerService;
	private CarFactoryService carFactoryService;
	private CarMarkService carMarkService;
	private EmployeeService employeeService;
	private DefectService defectService;
	private BreakedPartService breakedPartService;
	private CompanyService companyService;
	private HttpServletRequest request;
	private Map<String, Object> session;
	private List<CarMark> carmarkList;
	private String factoryStr;
	private String markStr;
	private CostService costService;
	/*
	 * Start image fields
	 * */
	private List<File> files = new ArrayList<File>();
	private List<String> imFileName = new ArrayList<String>();
	private List<String> imContentType = new ArrayList<String>();
	private List<Image> imageList = new LinkedList<Image>();
	public ImageService imageService;
	/*
	 * end image fields
	 * */
	/* 
	 * Start search fields
	 * */
	private String firstDate = EstimaterStaticFunctions.dateToStr(new Date());
	private String secondDate = EstimaterStaticFunctions.dateToStr(new Date()); 
	private String searchCnumber;
	private String searchCarFactory;
	private String searchCarMark;
	private String searchDate;
	/*
	 * End search fields 
	 * */
	/*
	 * Start id String
	 * */
	private String itypeStr;
	private String emp1Str;
	private String emp2Str;
	private String mainStr;
	private String carTypeStr;
	private List<String> brokePartList;
	private List<String> crashGradeList;
	private List<Defect> defectList = new LinkedList<Defect>();
	private String brokenPartStr;
	private String crashGradeStr;
	private String repairPriceStr;
	private String changePriceStr;
	private String companyStr;
	private String dateStr = EstimaterStaticFunctions.dateToStr(new Date());
	private String costName;
	private String cost;
	private List<Cost> costList = new LinkedList<Cost>();
	/*
	 * End id String
	 * */
	
	@Action(value="service-reg",results={@Result(name="success",type="tiles",location="/customers.tiles")})
	public String list(){
		this.customerList = customerService.findAll();
		this.carmarkList = carMarkService.findAll();
		defectList = new LinkedList<Defect>();
		session.put("defectList", defectList);
		costList = new LinkedList<Cost>();
		session.put("costList", costList);
		return SUCCESS;
	}
	
	@Action(value="search-customer-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/customer-list-ajax.jsp")})
	public String listAjax(){
		this.customerList = customerService.searchCustomer(firstDate, secondDate, searchCarFactory, searchCarMark, searchDate, searchCnumber);
		return SUCCESS;
	}
	@Action(value="confirm-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/customer-list-ajax.jsp")})
	public String confirm(){
		customer = customerService.get(customer.getId());
		customer.setConfirm(Confirm.approved);
		customerService.saveOrUpdate(customer);
		this.customerList = customerService.findAll();
		return SUCCESS;
	}
	@Action(value="customer-edit-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/customer-edit-ajax.jsp")})
	public String customer_edit_ajax(){
		customer = customerService.get(customer.getId());
		session.put("customer", customer);
		session.put("imageList", customer.getImageOfList());
		session.put("defectList", customer.getDefectList());
		session.put("costList", customer.getCostList());
		this.carmarkList = carMarkService.getMarkForFactory(customer.getCarFactory().getId().toString());
		return SUCCESS;
	}
	
	@Action(value="carmark-dialog-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/mark-dialog-ajax.jsp")})
	public String markDialogAjax(){
		this.carmarkList = carMarkService.getMarkForFactory(factoryStr);
		return SUCCESS;
	}
	@Action(value = "image-list", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/customer/ajax-image-list-response.jsp")
	})
	public String imageList(){
		return SUCCESS;
	}
	@Action(value = "new-image-list", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/customer/ajax-image-list-tiles.jsp")
	})
	public String nweImageList(){
		return SUCCESS;
	}
	@Action(value = "images-save", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/customer/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/customer/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax/customer/ajax-error-response.jsp") })
	public String ImagesaveAction() throws IOException {
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
				if(i!=0){
					image.setIsMain(false);
				}else{
					image.setIsMain(true);
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
			request.setAttribute("imageResult", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}
	@SuppressWarnings("unchecked")
	@Action(value = "save-images", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/customer/ajax-error-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/customer/ajax-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax/customer/ajax-error-response.jsp") })
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

	@Action(value = "delete-pm-images", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/customer/ajax-image-list-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/customer/ajax-image-input-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax/customer/ajax-error-response.jsp") })
	public String deleteImagesAction() {
		try {
			if (customer.getId() == null || customer.getId() == 0l) {
				addFieldError("id", Messages.getString("emptyError"));
				return INPUT;
			}

			String[] imageIds = request.getParameterValues("imageIds[]");
			if (imageIds == null || imageIds.length <= 0) {
				addFieldError("imageIds", Messages.getString("emptyError"));
				return INPUT;
			}

			Customer cust = new Customer();
			cust = customerService.get(customer.getId());
			if (cust == null) {
				addFieldError("id", Messages.getString("wrongIdError"));
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
					addFieldError("imageIds",
							Messages.getString("numberIdError"));
					return INPUT;
				}

				Image image = new Image();
				image = imageService.get(imageId);
				if (image == null) {
					addFieldError("imageIds",
							Messages.getString("wrongIdError"));
					return INPUT;
				}

				for (int i = 0; i < cust.getImageOfList().size(); i++) {
					if (cust.getImageOfList().get(i).getId() == image.getId()) {
						cust.getImageOfList().remove(i);
						imageService.delete(image);
						FileUtils.deleteQuietly(new File(filePath + "\\"
								+ image.getName()));
						FileUtils.deleteQuietly(new File(filePathd + "\\"
								+ image.getName()));
					}
				}
				session.put("imageList", cust.getImageOfList());
			}
			return SUCCESS;
		} catch (Exception e) {
			addFieldError("exception", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}
	
	
	@Action(value = "emptyList",results = {@Result(name="success",location="/WEB-INF/content/ajax/customer/customer-result.jsp")})
	public String emptyList(){
		imageList = new LinkedList<Image>();
		session.put("imageList", imageList);
		defectList = new LinkedList<Defect>();
		session.put("defectList", defectList);
		costList = new LinkedList<Cost>();
		session.put("costList", costList);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value="customer-save",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/customer-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/customer/customer-result.jsp")})
	public String customersave(){
		boolean check = true;
		try{
			imageList = (List<Image>) session.get("imageList");
			if(customer.getId() != null){
				Customer c = (Customer) session.get("customer");
				customer.setConfirm(c.getConfirm());
			}
			customer.setImageOfList(imageList);
			if(customer.getCnumber().equals("")){
				addFieldError("cnumber",  Messages.getString("inputEmpty"));
				addFieldError("cnumberEdit",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getColor().equals("")){
				addFieldError("color",  Messages.getString("inputEmpty"));
				addFieldError("colorEdit",  Messages.getString("inputEmpty"));
				check = false;
			}else{
				if(customer.getColor().matches("[0-9]{4}[А-ЯӨҮ]{3}")){
					addFieldError("color",  Messages.getString("cnumber"));
					check = false;
				}
			}
			if(customer.getVinNumber().equals("")){
				addFieldError("vinNumber",  Messages.getString("inputEmpty"));
				addFieldError("vinNumberEdit",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getOwnerName().equals("")){
				addFieldError("ownerName",  Messages.getString("inputEmpty"));
				addFieldError("ownerNameEdit",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getOwnerAddress().equals("")){
				addFieldError("ownerAddress",  Messages.getString("inputEmpty"));
				addFieldError("ownerAddressEdit",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getOwnerPhoneNumber().equals("")){
				addFieldError("ownerPhoneNumberEdit",  Messages.getString("inputEmpty"));
				addFieldError("ownerPhoneNumber",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getEstPoint().equals("")){
				addFieldError("estPointEdit",  Messages.getString("inputEmpty"));
				addFieldError("estPoint",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getMarketPrice().equals("")){
				addFieldError("marketPrice",  Messages.getString("inputEmpty"));
				addFieldError("marketPriceEdit",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getConsumer().equals("")){
				addFieldError("consumer",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getDefendant().equals("")){
				addFieldError("defendant",  Messages.getString("inputEmpty"));
				addFieldError("defendantEdit",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getAgentConsumer().equals("")){
				addFieldError("agentConsumerEdit",  Messages.getString("inputEmpty"));
				addFieldError("agentConsumer",  Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getEstimateMaterial().equals("")){
				addFieldError("estimateMaterial",  Messages.getString("inputEmpty"));
				addFieldError("estimateMaterialEdit",  Messages.getString("inputEmpty"));
			}
			if(companyStr.trim().equals("")){
				addFieldError("companyStrEdit", Messages.getString("inputEmpty"));
				addFieldError("companyStr", Messages.getString("inputEmpty"));
				check = false;
			}else{
				try{
					customer.setCompany(companyService.get(Long.parseLong(companyStr)));
				}catch(Exception e){
					addFieldError("companyStrEdit", e.getMessage());
					addFieldError("companyStr", e.getMessage());
					check = false;
				}
			}
			if(!itypeStr.equals("")){
				customer.setItype(InsuranceType.get(itypeStr));
			}else{
				addFieldError("itypeStr", Messages.getString("inputEmpty"));
				addFieldError("itypeStrEdit", Messages.getString("inputEmpty"));
				check = false;
			}
			if(dateStr.equals("")){
				addFieldError("dateStr", Messages.getString("inputEmpty"));
				addFieldError("dateStrEdit", Messages.getString("inputEmpty"));
				check = false;
			}else{
				customer.setDate(EstimaterStaticFunctions.strToDate(dateStr));
			}
			if(factoryStr.equals("")){
				addFieldError("factoryStr", Messages.getString("inputEmpty"));
				addFieldError("factoryStrEdit", Messages.getString("inputEmpty"));
				check = false;
			}else{
				try{
					customer.setCarFactory(carFactoryService.get(Long.parseLong(factoryStr)));
				}catch(Exception e){
					addFieldError("factoryStr", e.getMessage());
					addFieldError("factoryStrEdit", e.getMessage());
					check = false;
				}
			}
			if(markStr.equals("")){
				addFieldError("markStr", Messages.getString("inputEmpty"));
				addFieldError("markStrEdit", Messages.getString("inputEmpty"));
				check = false;
			}else{
				try{
					customer.setCarMark(carMarkService.get(Long.parseLong(markStr)));
				}catch(Exception e){
					addFieldError("markStrEdit", e.getMessage());
					addFieldError("markStr", e.getMessage());
					check = false;
				}
			}
			if(customer.getFactoryDate().equals("")){
				addFieldError("factoryDateEdit", Messages.getString("inputEmpty"));
				addFieldError("factoryDate", Messages.getString("inputEmpty"));
				check = false;
			}
			if(customer.getImportedDate().equals("")){
				addFieldError("importedDate", Messages.getString("inputEmpty"));
				addFieldError("importedDateEdit", Messages.getString("inputEmpty"));
				check = false;
			}
			if(emp1Str.equals("")){
				addFieldError("emp1Str", Messages.getString("inputEmpty"));
				addFieldError("emp1StrEdit", Messages.getString("inputEmpty"));
				check = false;
			}else{
				customer.setEmp1(employeeService.get(Long.parseLong(emp1Str)));
			}
			if(emp2Str.equals("")){
				addFieldError("emp2Str", Messages.getString("inputEmpty"));
				addFieldError("emp2StrEdit", Messages.getString("inputEmpty"));
				check = false;
			}else{
				customer.setEmp2(employeeService.get(Long.parseLong(emp2Str)));
			}
			if(mainStr.equals("")){
				addFieldError("mainStr", Messages.getString("inputEmpty"));
				addFieldError("mainStrEdit", Messages.getString("inputEmpty"));
				check = false;
			}else{
				customer.setMainEmp(employeeService.get(Long.parseLong(mainStr)));
			}
			if(carTypeStr.equals("")){
				addFieldError("carTypeStr", Messages.getString("inputEmpty"));
				addFieldError("carTypeStrEdit", Messages.getString("inputEmpty"));
				check = false;
			}else{
				customer.setCarType(CarType.get(carTypeStr));
			}
			if(!customer.getRegNumber().matches("[А-ЯӨҮ]{2}[0-9]{8}")){
				addFieldError("regnumber", Messages.getString("cnumber"));
				addFieldError("regnumberEdit", Messages.getString("cnumber"));
				check = false;
			}
			if(check){
				defectList = (List<Defect>) session.get("defectList");
				for(Defect d:defectList){
					defectService.saveOrUpdate(d);
				}
				customer.setDefectList(defectList);
				costList = (List<Cost>) session.get("costList");
				for(Cost c:costList){
					costService.saveOrUpdate(c);
				}
				customer.setCostList(costList);
				customerService.saveOrUpdate(customer);
				request.setAttribute("successMarkDialog", "true");
				return SUCCESS;
			}
			return INPUT;
		}catch(Exception e){
			addFieldError("mainStr", e.getMessage());
		}
		return INPUT;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value="addDefect-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/addfect-ajax.jsp")})
	public String addDefectAjax(){
		defectList = (List<Defect>) session.get("defectList");
		Defect d = new Defect();
		d.setBreakedPart(breakedPartService.get(Long.parseLong(brokenPartStr)));
		d.setCrashGrade(CrashGrade.get(crashGradeStr));
		if(changePriceStr.trim().equals("")){
			d.setChangePrice(0);
		}else{
			d.setChangePrice(Integer.parseInt(changePriceStr.replaceAll(" ", "")));
		}
		if(repairPriceStr.trim().equals("")){
			d.setRepairPrice(0);
		}else{
			d.setRepairPrice(Integer.parseInt(repairPriceStr.replaceAll(" ", "")));
		}
		defectList.add(d);
		session.put("defectList", defectList);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value="addDefect-ajax-edit",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/addfect-ajax-edit.jsp")})
	public String addDefectEditAjax(){
		defectList = (List<Defect>) session.get("defectList");
		Defect d = new Defect();
		d.setBreakedPart(breakedPartService.get(Long.parseLong(brokenPartStr)));
		d.setCrashGrade(CrashGrade.get(crashGradeStr));
		if(changePriceStr.trim().equals("")){
			d.setChangePrice(0);
		}else{
			d.setChangePrice(Integer.parseInt(changePriceStr.replaceAll(" ", "")));
		}
		if(repairPriceStr.trim().equals("")){
			d.setRepairPrice(0);
		}else{
			d.setRepairPrice(Integer.parseInt(repairPriceStr.replaceAll(" ", "")));
		}
		defectList.add(d);
		session.put("defectList", defectList);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Action(value="addCost-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/addCost-ajax.jsp")})
	public String addCostAjax(){
		costList = (List<Cost>) session.get("costList");
		Cost c = new Cost();
		c.setCost(Integer.parseInt(cost.replaceAll(" ", "")));
		c.setCostName(costName);
		costList.add(c);
		session.put("costList", costList);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Action(value="addCost-ajax-edit",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/addCost-ajax-edit.jsp")})
	public String addCostEditAjax(){
		costList = (List<Cost>) session.get("costList");
		Cost c = new Cost();
		c.setCost(Integer.parseInt(cost.replaceAll(" ", "")));
		c.setCostName(costName);
		costList.add(c);
		session.put("costList", costList);
		return SUCCESS;
	}
	@Action(value= "brokenPartChange" , results = {@Result(name = "success", location = "/WEB-INF/content/ajax/customer/brokenPartChange.jsp")})
	public String brokenPartChange(){
		if(breakedPartService.checkName(brokenPartStr)){
			BreakedPart b = new BreakedPart();
			b.setPartName(brokenPartStr);
			breakedPartService.save(b);
			session.put("brokenPartId", b.getId());
		}else{
			session.put("brokenPartId",breakedPartService.getBreakedPart(brokenPartStr).getId());
		}
		return SUCCESS;
	}
	@Action(value= "brokenPartChangeEdit" , results = {@Result(name = "success", location = "/WEB-INF/content/ajax/customer/brokenPartChangeEdit.jsp")})
	public String brokenPartChangeEdit(){
		if(breakedPartService.checkName(brokenPartStr)){
			BreakedPart b = new BreakedPart();
			b.setPartName(brokenPartStr);
			breakedPartService.save(b);
			session.put("brokenPartId", b.getId());
		}else{
			session.put("brokenPartId",breakedPartService.getBreakedPart(brokenPartStr).getId());
		}
		return SUCCESS;
	}
	public String getRepairPriceStr() {
		return repairPriceStr;
	}

	public void setRepairPriceStr(String repairPriceStr) {
		this.repairPriceStr = repairPriceStr;
	}

	public String getChangePriceStr() {
		return changePriceStr;
	}

	public void setChangePriceStr(String changePriceStr) {
		this.changePriceStr = changePriceStr;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Customer getModel() {
		return customer;
	}

	public void prepare() throws Exception {
		if(customer!=null && customer.getId()!=null){
			this.customer = customerService.get(customer.getId());
			this.customerHash = customer.hashCode();
		}
	}
	/*
	 * start enum list
	 * */
	public InsuranceType[] getItypes(){
		return InsuranceType.values();
	}
	
	public EstimateMaterialEnum[] getEstMaterials(){
		return EstimateMaterialEnum.values();
	}
	/*
	 * end enum list
	 * */
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setCarFactoryService(final CarFactoryService carFactoryService) {
		this.carFactoryService = carFactoryService;
	}

	public void setCarMarkService(final CarMarkService carMarkService) {
		this.carMarkService = carMarkService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDefectService(final DefectService defectService) {
		this.defectService = defectService;
	}
	public void setBreakedPartService(final BreakedPartService breakedPartService) {
		this.breakedPartService = breakedPartService;
	}

	public void setCompanyService(final CompanyService companyService) {
		this.companyService = companyService;
	}

	/*
	 * Start Getters List
	 * */
	public List<CarFactory> getFactories(){
		return carFactoryService.findAll();
	}
	
	public List<CarMark> getMarks(){
		return carMarkService.getMarkForFactory(searchCarFactory);
	}

	public List<CarMark> getCarmarkList() {
		return carmarkList;
	}
	
	public List<Employee> getEmployees(){
		return employeeService.getEmployees(EmployeeStatus.active.getId());
	}
	
	public CarType[] getCarTypes(){
		return CarType.values();
	}
	
	public List<BreakedPart> getBrokenParts(){
		return breakedPartService.findAll();
	}
	
	public CrashGrade[] getCrashGrades(){
		return CrashGrade.values();
	}
	
	public List<Company> getCompanies(){
		return companyService.findAll();
	}
	/*
	 * End Getter List
	 * */
	
	public String getFirstDate() {
		return firstDate;
	}


	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}


	public String getSecondDate() {
		return secondDate;
	}


	public void setSecondDate(String secondDate) {
		this.secondDate = secondDate;
	}


	public String getSearchCnumber() {
		return searchCnumber;
	}


	public void setSearchCnumber(String searchCnumber) {
		this.searchCnumber = searchCnumber;
	}


	public String getSearchCarFactory() {
		return searchCarFactory;
	}


	public void setSearchCarFactory(String searchCarFactory) {
		this.searchCarFactory = searchCarFactory;
	}


	public String getSearchCarMark() {
		return searchCarMark;
	}


	public void setSearchCarMark(String searchCarMark) {
		this.searchCarMark = searchCarMark;
	}


	public String getSearchDate() {
		return searchDate;
	}


	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public String getItypeStr() {
		return itypeStr;
	}

	public void setItypeStr(String itypeStr) {
		this.itypeStr = itypeStr;
	}

	public String getMarkStr() {
		return markStr;
	}

	public void setMarkStr(String markStr) {
		this.markStr = markStr;
	}

	public String getFactoryStr() {
		return factoryStr;
	}

	public void setFactoryStr(String factoryStr) {
		this.factoryStr = factoryStr;
	}

	public String getEmp2Str() {
		return emp2Str;
	}

	public void setEmp2Str(String emp2Str) {
		this.emp2Str = emp2Str;
	}

	public String getEmp1Str() {
		return emp1Str;
	}

	public void setEmp1Str(String emp1Str) {
		this.emp1Str = emp1Str;
	}


	public String getCarTypeStr() {
		return carTypeStr;
	}

	public void setCarTypeStr(String carTypeStr) {
		this.carTypeStr = carTypeStr;
	}

	public List<String> getBrokePartList() {
		return brokePartList;
	}

	public void setBrokePartList(List<String> brokePartList) {
		this.brokePartList = brokePartList;
	}

	public List<String> getCrashGradeList() {
		return crashGradeList;
	}

	public void setCrashGradeList(List<String> crashGradeList) {
		this.crashGradeList = crashGradeList;
	}

	public List<Defect> getDefectList() {
		return defectList;
	}

	public void setDefectList(List<Defect> defectList) {
		this.defectList = defectList;
	}

	public String getBrokenPartStr() {
		return brokenPartStr;
	}

	public void setBrokenPartStr(String brokenPartStr) {
		this.brokenPartStr = brokenPartStr;
	}

	public String getCrashGradeStr() {
		return crashGradeStr;
	}

	public void setCrashGradeStr(String crashGradeStr) {
		this.crashGradeStr = crashGradeStr;
	}

	public String getCompanyStr() {
		return companyStr;
	}

	public void setCompanyStr(String companyStr) {
		this.companyStr = companyStr;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}


	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}

	public String getMainStr() {
		return mainStr;
	}

	public void setMainStr(String mainStr) {
		this.mainStr = mainStr;
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

	public void setCostService(final CostService costService) {
		this.costService = costService;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}


	
	
}
