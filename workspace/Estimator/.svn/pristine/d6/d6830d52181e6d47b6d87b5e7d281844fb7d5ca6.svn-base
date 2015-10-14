package mn.infosystems.estimator.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.estimator.model.CarFactory;
import mn.infosystems.estimator.model.CarMark;
import mn.infosystems.estimator.model.Employee;
import mn.infosystems.estimator.model.PartPrice;
import mn.infosystems.estimator.service.CarFactoryService;
import mn.infosystems.estimator.service.CarMarkService;
import mn.infosystems.estimator.service.EmployeeService;
import mn.infosystems.estimator.service.EstimaterStaticFunctions;
import mn.infosystems.estimator.service.PartPriceService;

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
public class PartPriceAction extends ActionSupport implements Preparable,
		ModelDriven<PartPrice>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private PartPrice partPrice = new PartPrice();
	private PartPriceService partPriceService;
	private CarFactoryService carFactoryService;
	private CarMarkService carMarkService;
	private EmployeeService employeeService;
	private List<PartPrice> partPriceList;
	private List<CarMark> carMarkList;
	private int partPriceHash;
	private HttpServletRequest request;

	private String startDate = EstimaterStaticFunctions.dateToStr(new Date());
	private String endDate = EstimaterStaticFunctions.dateToStr(new Date());
	private String date1;
	private String date2;
	private String factorySearch;
	private String markSearch;
	private String partNameSearch;
	
	private String factoryStr;
	private String markStr;
	private String empStr;
	private String dateStr = EstimaterStaticFunctions.dateToStr(new Date());
	
	
	@Action(value="part-price",results={@Result(name="success",type="tiles",location="/part-price.tiles")})
	public String list(){
		try{
			startDate = startDate.equals("")?"1000-01-01":startDate+" 00:00:00.000";
			endDate = endDate.equals("")?"3000-01-01":endDate+" 23:59:59.999";
			date1 = (date1==null || date1.equals(""))?"1000":date1;
			date2 = (date2==null || date2.equals(""))?"3000":date2;
			factorySearch = (factorySearch==null || factorySearch.equals(""))?"%":factorySearch;
			markSearch = (markSearch==null || markSearch.equals(""))?"%":markSearch;
			partNameSearch = (partNameSearch==null ||  partNameSearch.trim().equals(""))?"%":partNameSearch;
			this.partPriceList = partPriceService.getPartPrices(startDate, endDate, Integer.parseInt(date1), Integer.parseInt(date2), factorySearch, markSearch, partNameSearch);
		}catch(Exception e){
			this.partPriceList = partPriceService.findAll();
//			this.partPriceList = new LinkedList<PartPrice>();
		}
		startDate = dateStr;
		endDate = dateStr;
		return SUCCESS;
	}
	
	@Action(value="part-price-list",results={@Result(name="success",location="/WEB-INF/content/ajax/partprice/part-price-list.jsp")})
	public String list_ajax(){
		this.partPriceList = partPriceService.findAll();
		return SUCCESS;
	}
	
	@Action(value="search-partprice",results={@Result(name="success",location="/WEB-INF/content/ajax/partprice/part-price-list.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/partprice/part-price-list.jsp")})
	public String search(){
		try{
			startDate = startDate.equals("")?"1000-01-01":startDate+" 00:00:00.000";
			endDate = endDate.equals("")?"3000-01-01":endDate+" 23:59:59.999";
			date1 = date1.equals("")?"1000":date1;
			date2 = date2.equals("")?"3000":date2;
			factorySearch = (factorySearch==null || factorySearch.equals(""))?"%":factorySearch;
			markSearch = (markSearch==null || markSearch.equals(""))?"%":markSearch;
			partNameSearch = (partNameSearch.trim().equals(""))?"%":partNameSearch;
			this.partPriceList = partPriceService.getPartPrices(startDate, endDate, Integer.parseInt(date1), Integer.parseInt(date2), factorySearch, markSearch, partNameSearch);
		}catch(Exception e){
			this.partPriceList = new LinkedList<PartPrice>();
			return INPUT;
		}
		return SUCCESS;
	}
	
	@Action(value="part-price-save",results={@Result(name="success",location="/WEB-INF/content/ajax/partprice/part-price-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/partprice/part-price-result.jsp")})
	public String save(){
		if(partPrice!=null && partPrice.hashCode()!=partPriceHash){
			if(factoryStr!=null) partPrice.setPartFactory(carFactoryService.get(Long.parseLong(factoryStr)));
			if(markStr!=null) partPrice.setPartMark(carMarkService.get(Long.parseLong(markStr)));
			if(empStr!=null) partPrice.setEstimator(employeeService.get(Long.parseLong(empStr)));
			partPrice.setDate(EstimaterStaticFunctions.strToDate(dateStr));
			partPriceService.saveOrUpdate(partPrice);
			request.setAttribute("partPriceSuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@VisitorFieldValidator(appendPrefix = false, message = "")
	public PartPrice getModel() {
		return partPrice;
	}

	public void prepare() throws Exception {
		if (partPrice != null && partPrice.getId() != null) {
			this.partPrice = partPriceService.get(partPrice.getId());
			this.partPriceHash = partPrice.hashCode();
		}
	}
	
	public List<CarFactory> getFactories(){
		return carFactoryService.findAll();
	}
	
	public List<CarMark> getMarks(){
		return carMarkService.findAll();
	}

	public List<Employee> getEmps(){
		return employeeService.findAll();
	}
	
	public PartPrice getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(PartPrice partPrice) {
		this.partPrice = partPrice;
	}

	public List<PartPrice> getPartPriceList() {
		return partPriceList;
	}

	public List<CarMark> getCarMarkList() {
		return carMarkList;
	}

	public void setPartPriceService(final PartPriceService partPriceService) {
		this.partPriceService = partPriceService;
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

	public String getPartNameSearch() {
		return partNameSearch;
	}

	public void setPartNameSearch(String partNameSearch) {
		this.partNameSearch = partNameSearch;
	}

	public String getFactoryStr() {
		return factoryStr;
	}

	public void setFactoryStr(String factoryStr) {
		this.factoryStr = factoryStr;
	}

	public String getMarkStr() {
		return markStr;
	}

	public void setMarkStr(String markStr) {
		this.markStr = markStr;
	}

	public String getEmpStr() {
		return empStr;
	}

	public void setEmpStr(String empStr) {
		this.empStr = empStr;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	
	

}
