package mn.threesor.wms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import mn.threesor.wms.enums.EmployeeStatus;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "Employee", uniqueConstraints = @UniqueConstraint(columnNames = "regNumber", name = "regNumber"))
@NamedQueries({
		@NamedQuery(name = "Employee.findFirstName", query = "select emp from Employee emp where emp.firstName like :firstName"),
		@NamedQuery(name = "Employee.find", query = "select d from Employee d where regNumber like :reg and id<>:id"),
		@NamedQuery(name = "Employee.findRegnumber", query = "select e from Employee e where regNumber like :reg"),
		@NamedQuery(name = "Employee.normal", query = "select d from Employee d where status =:stat"),
		@NamedQuery(name = "Employee.checkCode",query = "select e from Employee e where code like :code"),
		@NamedQuery(name = "Employee.checkCodeAndId",query="select e from Employee e where code like :code and id <>:id")})
public class Employee {
	private Long id;
	@Column(unique = true, length = 10, name = "regNumber")
	private String regNumber;
	private String firstName;
	private String lastName;
	private Date birthday;
	private EmployeeStatus status;
	@NotNull
	private String phone;
	@NotNull
	private String email;
	private Occupation position;
	@NotNull
	private String code;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@RequiredStringValidator(key = "regNumberValidator")
	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		regNumber = regNumber.toUpperCase();
		regNumber = checkReg(regNumber);
		this.regNumber = regNumber;
	}

	@RequiredStringValidator(key = "employeeName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = checkName(firstName);
	}

	@RequiredStringValidator(key = "employeeName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = checkName(lastName);
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@ManyToOne
	public Occupation getPosition() {
		return position;
	}

	public void setPosition(Occupation position) {
		this.position = position;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		phone = checkPhone(phone);
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = checkEmail(email);
		this.email = email;
	}

	private String checkReg(String reg) {
		return reg.matches("[А-ЯӨҮ]{2}[0-9]{8}") ? reg : null;
	}

	private String checkPhone(String phone) {
		if (phone.equals(""))
			return "";
		return phone.matches("([1-9]{1}[0-9]{7})|([1-9]{1}[0-9]{5})") ? phone
				: null;
	}

	private String checkEmail(String email) {
		if (email.equals(""))
			return "";
		return email
				.matches("^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$") ? email
				: null;
	}

	private String checkName(String name) {
		return name.matches("[A-Za-zА-Яа-яӨөҮүЁё]{2,64}") ? name : null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
