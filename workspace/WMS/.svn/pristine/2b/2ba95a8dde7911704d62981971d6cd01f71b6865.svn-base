package mn.threesor.wms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.wms.enums.EmployeeStatus;
import mn.threesor.wms.model.Employee;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.Occupation;
import mn.threesor.wms.service.EmployeeService;
import mn.threesor.wms.service.OccupationService;

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
		ModelDriven<Employee>, ServletRequestAware {
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;
	private Employee employee = new Employee();
	private List<Employee> empList;
	private int empHash;
	private OccupationService occupationService;
	private HttpServletRequest request;
	private String EmpPosition;

	public String getInit() {
		if (employee.getPosition() == null)
			return "";
		return "" + employee.getPosition().getId();
	}

	public void setEmpPosition(String empPosition) {
		if (!empPosition.equals(""))
			this.employee.setPosition(occupationService.get(Long
					.parseLong(empPosition)));
		else
			this.employee.setPosition(null);
		this.EmpPosition = empPosition;
	}

	public Long getEmpPosition() {
		if (!EmpPosition.equals(""))
			return Long.parseLong(EmpPosition);
		return -1l;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Employee getModel() {
		return employee;
	}

	public void prepare() throws Exception {
		if ((employee != null) && (employee.getId() != null)) {
			this.employee = employeeService.get(employee.getId());
			this.empHash = employee.hashCode();
		}
		EmpPosition = getInit();
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
	@Action(value = "employee-list", results = { @Result(name = "success", type = "tiles", location = "/employee-list.tiles") })
	public String list() throws Exception {
		this.empList = employeeService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-employee", results = {
			@Result(name = "success", type = "redirectAction", location = "employee-list"),
			@Result(name = "input", type = "tiles", location = "/employee.tiles") })
	public String save() throws Exception {
		try {
			if (employee != null && employee.hashCode() != empHash) {
				boolean check = false;
				if (employee.getPosition() == null) {
					addFieldError("empPosition",
							Messages.getString("EmpPosition"));
					check = true;
				}
				
				if(!employee.getCode().equals("") && employeeService.hasCodeConjuction(employee.getId(),employee.getCode())){
					addFieldError("code", Messages.getString("checkCode"));
					check = true;
				}

				if (employeeService.hasConjuction(employee.getId(),
						employee.getRegNumber())) {
					addFieldError("regNumber",
							Messages.getString("checkRegistration"));
					check = true;
				}

				if (!check) {
					employee.setPhone(employee.getPhone());
					employee.setEmail(employee.getEmail());
					employeeService.saveOrUpdate(employee);
					return SUCCESS;
				}
				return INPUT;
			}
		} catch (GenericJDBCException e) {
			addFieldError("phone", Messages.getString("phoneCheck"));
			return INPUT;
		} catch (NullPointerException e) {
			if (employee.getPhone() == null)
				addFieldError("phone", Messages.getString("phoneCheck"));
			if (employee.getEmail() == null)
				addFieldError("email", Messages.getString("emailCkeck"));
			return INPUT;
		} catch (Exception e) {
			addFieldError("regNumber", Messages.getString("checkRegistration"));
			return INPUT;
		}
		return INPUT;
	}

	public EmployeeStatus[] getStatuses() {
		return EmployeeStatus.values();
	}

	public List<Occupation> getEmployeePositions() {
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

	public void setBday(String bday) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!bday.equals(""))
				date = formatter.parse(bday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.employee.setBirthday(date);
	}

	public String getBday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		date = this.employee.getBirthday();
		if (date != null) {
			return formatter.format(date);
		}
		return null;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}
}