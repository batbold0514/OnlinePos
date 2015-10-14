package mn.threesor.tims.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.enums.EmployeeStatus;
import mn.threesor.tims.model.Employee;
import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.Occupation;
import mn.threesor.tims.model.Users;
import mn.threesor.tims.service.EmployeeService;
import mn.threesor.tims.service.OccupationService;
import mn.threesor.tims.service.UsersService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.exception.GenericJDBCException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class EmployeeAction extends ActionSupport implements Preparable,
		ModelDriven<Employee>,ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
	private Employee employee = new Employee();
	private List<Employee> empList;
	private int empHash;
	private Long positionString;
	private OccupationService occupationService;
	private UsersService usersService;
	private Long employeeUser;
	private HttpServletRequest request;
	private String birthString;
	
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Employee getModel() {
		return employee;
	}

	public Long getEmployeeUser() {
		return employeeUser;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public void setEmployeeUser(Long employeeUser) {
		this.employeeUser = employeeUser;
	}

	public List<Users> getEmpUsers() {
		return usersService.getEmpUser();
	}

	public void prepare() throws Exception {
		if ((employee != null) && (employee.getId() != null)) {
			this.employee = employeeService.get(employee.getId());
			this.empHash = employee.hashCode();
			this.positionString = employee.getPosition().getId();
			if(employee.getEmpUser()!=null)
			this.employeeUser = employee.getEmpUser().getId();
			else this.employeeUser = -1l;
		}
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setOccupationService(final OccupationService occupationService) {
		this.occupationService = occupationService;
	}

	@Override
	@SkipValidation
	@Action(value = "employee", results = { @Result(name = "success", type = "tiles", location = "/employee.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "employeeList", results = { @Result(name = "success", type = "tiles", location = "/employee-list.tiles") })
	public String list() throws Exception {
		this.empList = employeeService.findAll();
		return SUCCESS;
	}
	@SkipValidation
	@Action(value = "employee-list-ajax", results = { @Result(name = "success",  location = "/WEB-INF/content/ajax-employee/employee-list-ajax.jsp") })
	public String list1() throws Exception {
		this.empList = employeeService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-employee-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-employee/employee-add-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-employee/employee-add-ajax.jsp") })
	public String save() throws Exception {
		try {
			if (employee != null && employee.hashCode() != empHash) {
				Boolean cheak = true;
				if (positionString ==-1) {
					cheak = false;
					addFieldError("positionString",
							Messages.getString("positionHeader"));
				}
				
				if(!employee.getCode().equals("") && employeeService.hasCodeConjuction(employee.getId(),employee.getCode())){
					addFieldError("code", Messages.getString("checkCode"));
					cheak = false;
				}
				
				if (cheak) {
					if (employeeService.hasConjuction(employee.getId(),
							employee.getRegNumber())) {
						addFieldError("regNumber",
								Messages.getString("checkRegistration"));
						return INPUT;
					}
					employee.setBirthday(stringToDate(birthString));
					employee.setPosition(occupationService.get(positionString));
					employee.setPhone(employee.getPhone());
					employee.setEmail(employee.getEmail());
					if (employeeUser == -1) {
						employee.setEmpUser(null);
					} else
						employee.setEmpUser(usersService.get(employeeUser));
					employeeService.saveOrUpdate(employee);
					employeeService.log(employee, "saveOrUpdate");
					request.setAttribute("empSuccess", SUCCESS);
					return SUCCESS;
				}
			}
		} catch (GenericJDBCException e) {
			addFieldError("phone", Messages.getString("phoneCheck"));
		} catch (NullPointerException e) {
			if (employee.getPhone() == null)
				addFieldError("phone", Messages.getString("phoneCheck"));
			if (employee.getEmail() == null)
				addFieldError("email", Messages.getString("emailCkeck"));
		} catch (Exception e) {
			addFieldError("regNumber", Messages.getString("checkRegistration"));
		}
		return INPUT;
	}

	public EmployeeStatus[] getStatuses() {
		return EmployeeStatus.values();
	}

	public List<Occupation> getPositions() {
		return occupationService.findAll();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public Long getPositionString() {
		return positionString;
	}

	public void setPositionString(Long positionString) {
		this.positionString = positionString;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getBirthString() {
		return birthString;
	}

	public void setBirthString(String birthString) {
		this.birthString = birthString;
	}
	
	private Date stringToDate(String str){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!str.equals(""))
				date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
