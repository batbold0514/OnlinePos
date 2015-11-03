package mn.infosystems.estimator.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.estimator.enums.EmployeeStatus;
import mn.infosystems.estimator.model.Employee;
import mn.infosystems.estimator.model.Users;
import mn.infosystems.estimator.service.EmployeeService;
import mn.infosystems.estimator.service.EstimateLoggerService;
import mn.infosystems.estimator.service.UsersService;

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
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") ,@Namespace("/employee")})
public class EmployeeAction extends ActionSupport implements Preparable,
		ModelDriven<Employee>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Employee employee = new Employee();
	private EmployeeService employeeService;
	private UsersService usersService;
	private HttpServletRequest request;
	private int employeeHash;
	private List<Employee> employeeList;
	private String statusStr;
	private String userStr;
	private String empId;
	private List<Users> usersList;
	
	@SkipValidation
	
	@Action(value = "employee-list", results = { @Result(name = "success", type = "tiles", location = "/employee-list.tiles") })
	public String list() throws Exception{
		this.employeeList = employeeService.findAll();
		this.usersList = usersService.getUsersWhoNotEmployee();
		return SUCCESS;
	}
	

	@Action(value = "employeeList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/employee/employee-list.jsp") })
	public String list_ajax() {
		this.employeeList = employeeService.findAll();
		return SUCCESS;
	}

	@Action(value = "employee-save", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/employee/employee.jsp"),
			@Result(name = "success", location = "/WEB-INF/content/ajax/employee/employee.jsp") })
	public String save() {
		if (employee != null && employee.hashCode() != employeeHash) {
			if (statusStr.equals("0"))
				employee.setStatus(EmployeeStatus.active);
			else
				employee.setStatus(EmployeeStatus.incative);
			if(userStr.equals("")) employee.setUser(null);
			else employee.setUser(usersService.get(Long.parseLong(userStr)));
			employeeService.saveOrUpdate(employee);
			request.setAttribute("employeeSuccess", SUCCESS);
			EstimateLoggerService.writeLog(employee);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="user-list-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/employee/user-list.jsp")})
	public String list_user_ajax(){
		this.usersList = usersService.getUsersWhoNotEmployee();
		usersList.add(usersService.getUserByEmp(Long.parseLong(empId)));
		return SUCCESS;
	}
	
	public EmployeeStatus[] getEmployeeStatuses() {
		return EmployeeStatus.values();
	}
	
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Employee getModel() {
		return employee;
	}

	public void prepare() throws Exception {
		if (employee != null && employee.getId() != null) {
			this.employee = employeeService.get(employee.getId());
			this.employeeHash = employee.hashCode();
		}
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @param employeeService
	 *            the employeeService to set
	 */
	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}


	/**
	 * @return the employeeList
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	public String getUserStr() {
		return userStr;
	}


	public void setUserStr(String userStr) {
		this.userStr = userStr;
	}
	
	/*public List<Users> getUsers(){
		return usersService.getUsersWhoNotEmployee();
	}*/


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public List<Users> getUsersList() {
		return usersList;
	}

}
