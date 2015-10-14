package mn.infosystems.estimator.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.estimator.model.CarFactory;
import mn.infosystems.estimator.model.CarMark;
import mn.infosystems.estimator.model.CarPrice;
import mn.infosystems.estimator.model.Employee;
import mn.infosystems.estimator.service.CarFactoryService;
import mn.infosystems.estimator.service.CarMarkService;
import mn.infosystems.estimator.service.CarPriceService;
import mn.infosystems.estimator.service.EmployeeService;
import mn.infosystems.estimator.service.EstimaterStaticFunctions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class CarPriceAction extends ActionSupport implements Preparable,
		ModelDriven<CarPrice>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private CarPriceService carPriceService;
	private CarFactoryService carFactoryService;
	private CarMarkService carMarkService;
	private EmployeeService employeeService;
	private CarPrice carPrice = new CarPrice();
	private List<CarPrice> carPriceList;
	private int carPricehash;
	private HttpServletRequest request;
	private List<CarMark> carMarkList;
	/*
	 * start saearchfield
	 * */
	private String startDate = EstimaterStaticFunctions.dateToStr(new Date());
	private String endDate = EstimaterStaticFunctions.dateToStr(new Date());
	private String factorySearch;
	private String markSearch;
	private String date1;
	private String date2;
	/*
	 * end search field
	 * */
	/*
	 * start extra field
	 * */
	private String dateStr = EstimaterStaticFunctions.dateToStr(new Date());
	private String factoryStr;
	private String markStr;
	private String empStr;
	/*
	 * end extra field
	 * */
	
	@Action(value="search-carprice",results={@Result(name="success",location="/WEB-INF/content/ajax/carprice/car-price-list.jsp")})
	public String search(){
		try{
			startDate = startDate.trim().equals("")?"1000-01-01":startDate;
			endDate = endDate.trim().equals("")?"3000-01-01":endDate;
			factorySearch = (factorySearch==null ||  factorySearch.equals(""))?"%":factorySearch;
			markSearch = (markSearch==null || markSearch.equals(""))?"%":markSearch;
			date1 = date1.trim().equals("")?"0":date1;
			date2 = date2.trim().equals("")?"3000":date2;
			this.carPriceList =  carPriceService.getPriceList(startDate, endDate, date1, date2, factorySearch, markSearch);
		}catch(Exception e){
			this.carPriceList = new LinkedList<CarPrice>();
		}
		return SUCCESS;
	}
	
	@Action(value="car-price-mark",results={@Result(name="success",location="/WEB-INF/content/ajax/carprice/mark-result.jsp")})
	public String cahnge_mark(){
		this.carMarkList = carMarkService.getMarkForFactory(factorySearch);
		return SUCCESS;
	}
	
	@Action(value="car-price-dialog-mark",results={@Result(name="success",location="/WEB-INF/content/ajax/carprice/mark-result-dialog.jsp")})
	public String cahnge_mark1(){
		this.carMarkList = carMarkService.getMarkForFactory(factoryStr);
		return SUCCESS;
	}
	
	@Action(value="car-price",results={@Result(name="success",type="tiles",location="/car-price.tiles")})
	public String list(){
		this.carPriceList = carPriceService.findAll();
		return SUCCESS;
	}
	
	@Action(value="car-price-list",results={@Result(name="success",location="/WEB-INF/content/ajax/carprice/car-price-list.jsp")})
	public String list_ajax(){
		this.carPriceList = carPriceService.findAll();
		return SUCCESS;
	}
	
	@Action(value="save-car-price",results={@Result(name="success",location="/WEB-INF/content/ajax/carprice/car-price-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/carprice/car-price-result.jsp")})
	public String save(){
		if(carPrice!=null && carPrice.hashCode()!=carPricehash){
			if(factoryStr!=null) carPrice.setFactory(carFactoryService.get(Long.parseLong(factoryStr)));
			if(markStr!=null) carPrice.setMark(carMarkService.get(Long.parseLong(markStr)));
			if(empStr!=null) carPrice.setEstimator(employeeService.get(Long.parseLong(empStr)));
			carPrice.setDate(EstimaterStaticFunctions.strToDate(dateStr));
			carPriceService.saveOrUpdate(carPrice);
			request.setAttribute("carPriceSuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public List<CarFactory> getFactories(){
		return carFactoryService.findAll();
	}
	
	public List<CarMark> getMarks(){
		return carMarkService.findAll();
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@VisitorFieldValidator(appendPrefix = false, message = "")
	public CarPrice getModel() {
		return carPrice;
	}

	public void prepare() throws Exception {
		if (carPrice != null && carPrice.getId() != null) {
			this.carPrice = carPriceService.get(carPrice.getId());
			this.carPricehash = carPrice.hashCode();
		}
	}

	public CarPrice getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(CarPrice carPrice) {
		this.carPrice = carPrice;
	}

	public List<CarPrice> getCarPriceList() {
		return carPriceList;
	}

	public void setCarPriceService(final CarPriceService carPriceService) {
		this.carPriceService = carPriceService;
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
	
	public List<Employee> getEmps(){
		return employeeService.findAll();
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFactorySearch() {
		return factorySearch;
	}

	public void setFactorySearch(String factorySearch) {
		this.factorySearch = factorySearch;
	}

	public String getMarkSearch() {
		return markSearch;
	}

	public void setMarkSearch(String markSearch) {
		this.markSearch = markSearch;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
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

	public String getEmpStr() {
		return empStr;
	}

	public void setEmpStr(String empStr) {
		this.empStr = empStr;
	}

	public List<CarMark> getCarMarkList() {
		return carMarkList;
	}
	
}
