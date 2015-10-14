package mn.chinbat.surgery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "Doctor", uniqueConstraints = @UniqueConstraint(columnNames = "registrationNumber", name = "registrationNumber"))
@NamedQueries({
		@NamedQuery(name = "Doctor.registration", query = "select d from Doctor d where registrationNumber like :name"),
		@NamedQuery(name = "Doctor.id", query = "select d from Doctor d where id = :id"),
		@NamedQuery(name = "Doctor.normal", query = "select d from Doctor d where d.status like :normal"),
		@NamedQuery(name = "Doctor.notNormal", query = "select d from Doctor d where d.status <>:fired"),
		@NamedQuery(name = "Doctor.checkReg", query = "select d from Doctor d where registrationNumber like :reg and id<>:id"),
		@NamedQuery(name = "Doctor.checkUser",query = "select d from Doctor d where doctorUser.id = :id"),
		@NamedQuery(name = "Doctor.getDoctorWithUser",query="select d from Doctor d where doctorUser.userName like :name")})
public class Doctor {
	private Long id;
	@Column(unique = true, length = 10, name = "registrationNumber")
	private String registrationNumber;
	private String name;
	private String familyName;
	private String status;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String mobile1;
	@NotNull
	private String mobile2;
	private Users doctorUser;

	public Doctor() {
	}

	public Doctor(String registrationNumber, String name, String familyName,
			String status, String phoneNumber, String mobile1, String mobile2) {
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.familyName = familyName;
		this.status = status;
		this.phoneNumber= phoneNumber;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
	}

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@RequiredStringValidator(key = "validation.register")
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		registrationNumber =registrationNumber.toUpperCase();
		registrationNumber = check(registrationNumber);
		this.registrationNumber = registrationNumber;
	}

	@RequiredStringValidator(key = "validation.required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@RequiredStringValidator(key = "validation.required")
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@RequiredStringValidator(key = "validation.required")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

//	@RequiredStringValidator(key = "validation.phone")
	public void setPhoneNumber(String phoneNumber) {
		phoneNumber = checkPhone(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	public String getMobile1() {
		return mobile1;
	}
//	@RequiredStringValidator(key = "validation.phone")
	public void setMobile1(String mobile1) {
		mobile1 = checkPhone(mobile1);
		this.mobile1 = mobile1;
	}
	
	public String getMobile2() {
		return mobile2;
	}

//	@RequiredStringValidator(key = "validation.phone")
	public void setMobile2(String mobile2) {
		mobile2 = checkPhone(mobile2);
		this.mobile2 = mobile2;
	}

	public String check(String s) {
		return s.matches(Messages.getString("Patient.useg")) ? s
				: null;
	}

	private String checkPhone(String number) {
		if(number.equals("")) return "";
		return number.matches("\\d{8}|\\d{6}") ? number : null;
	}
	
	@OneToOne
	public Users getDoctorUser() {
		return doctorUser;
	}

	public void setDoctorUser(Users doctorUser) {
		this.doctorUser = doctorUser;
	}

}
