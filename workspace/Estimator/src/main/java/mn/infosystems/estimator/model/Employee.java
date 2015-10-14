package mn.infosystems.estimator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import mn.infosystems.estimator.enums.EmployeeStatus;

@Entity
@Table(name = "employee")
@NamedQueries({@NamedQuery(name="Employee.getActive",query="select e from Employee e where status = :status")})
public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String regNumber;
	private EmployeeStatus status;
	private Users user;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}
	
	@ManyToOne
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
