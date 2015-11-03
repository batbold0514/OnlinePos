package mn.infosystems.estimator.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.estimator.model.Customer;
import mn.infosystems.estimator.model.Employee;
import mn.infosystems.estimator.model.EmployeeReportModel;
import mn.infosystems.estimator.service.CustomerService;
import mn.infosystems.estimator.service.EmployeeService;
import mn.infosystems.estimator.service.EstimaterStaticFunctions;
import mn.infosystems.estimator.service.PostgreConectionService;
import mn.infosystems.estimator.service.UsersService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/employee")})
public class ReportAction extends ActionSupport implements ServletRequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	@SuppressWarnings("unused")
	private List<Customer> list;
	private String firstDate = EstimaterStaticFunctions.dateToStr(new Date());
	private String secondDate = EstimaterStaticFunctions.dateToStr(new Date());
	private String empId;
	private String username;
	private EmployeeService employeeService;
	private UsersService usersService;
	private HttpServletRequest request;
	private List<EmployeeReportModel> empReportList;
	private Map<String, Object> session;
	
	@Action(value="emp-report",results={@Result(name="success",type="tiles",location="/emp-report.tiles")})
	public String empReport(){
		username = request.getRemoteUser();
		PostgreConectionService pcs = new PostgreConectionService();
		if(request.isUserInRole("admin-role")){
			this.empReportList = customerService.getEmployyReport(firstDate, secondDate, empId);
			
		}else{
			empId = usersService.getUser(username).getId().toString();
			this.empReportList = customerService.getEmployyReport(firstDate, secondDate, empId);
		}
		
		pcs.close();
		return SUCCESS;
	}
	@Action(value="emp-report-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/employee/emp-report.jsp")})
	public String empReportAjax(){
		username = request.getRemoteUser();
		session.put("firstDate", firstDate.replaceAll("-", "."));
		session.put("secondDate", secondDate.replaceAll("-", "."));
		PostgreConectionService pcs = new PostgreConectionService();
		if(request.isUserInRole("admin-role")){
			this.empReportList = customerService.getEmployyReport(firstDate, secondDate, empId);
			
		}else{
			empId = usersService.getUser(username).getId().toString();
			this.empReportList = customerService.getEmployyReport(firstDate, secondDate, empId);
		}
		 List<Customer> list = ( List<Customer>) customerService.getByDate(firstDate, secondDate, empId);
		Customer c = null;
		Long sum = 0l,sum1=0l;
		if(list != null && list.size()!=0){
			c = list.get(0);
			for(int i = 1;i<list.size();i++){
				sum = 0l;sum1=0l;
				if(c.getChangePrice() != null)
					sum =c.getChangePrice();
				if(c.getRepairPrice()!=null)
					sum+=c.getRepairPrice();
				if(list.get(i).getChangePrice() != null)
					sum1 =list.get(i).getChangePrice();
				if(list.get(i).getRepairPrice()!=null)
					sum1+=list.get(i).getRepairPrice();
				if( sum <  sum1){
					c = list.get(i);
				}
			}
		}
		session.put("customer", c);
		pcs.close();
		return SUCCESS;
	}
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

	public List<EmployeeReportModel> getEmpReportList() {
		return empReportList;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setSession(Map<String, Object> session) {
		this.session =session;
	}
	
}
