package mn.chinbat.surgery.model;

import java.util.Date;

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
import javax.validation.constraints.NotNull;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity()
// @Table(name = "patient", uniqueConstraints = @UniqueConstraint(columnNames =
// "regNumber", name = "regNumber"))
@Table(name = "patient")
@NamedQueries({
		@NamedQuery(name = "Patient.search", query = ""
				+ "select e from Patient e where e.regNumber like :reg and e.cardNumber like :cardNumber and "
				+ "UPPER(e.lastName) like UPPER(:last) and UPPER(e.firstName) like UPPER(:first) and (e.phone like :phone or e.mobil_1 like :phone or e.mobil_2 like :phone)"),
		@NamedQuery(name = "Patient.searchId", query = "select e from Patient e where e.id = :id"),
		@NamedQuery(name = "Patient.regNumber", query = "select e from Patient e where e.regNumber like :reg"),
		@NamedQuery(name = "Patient.checkReg", query = "select p from Patient p where regNumber like :reg and id<>:id"),
		@NamedQuery(name = "Patient.cardNumber", query = "select p from Patient p where cardNumber like :cardNumber"),
		@NamedQuery(name = "Patient.checkCardNumber", query = "select p from Patient p where cardnumber like :cardNumber and id<>:id"),
		@NamedQuery(name = "Pateint.lastCardNumber",query = "select p.cardNumber from Patient p order by cardNumber desc limit 1")})
public class Patient {
	private Long id;
	// @Column(unique = true, length = 10, name = "regNumber")
	private String regNumber;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String sex;
	@NotNull
	private String phone;
	@NotNull
	private String mobil_1;
	@NotNull
	private String mobil_2;
	private String cardNumber;
	private String occupation;
	private Address address;

	public Patient() {

	}

	public Patient(Long id, String regNumber, String firstName,
			String lastName, String sex, String phone, String mobil_1,
			String mobil_2) {
		this.id = id;
		this.regNumber = regNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		// this.Birthday = birthday;
		this.sex = sex;
		this.phone = phone;
		this.mobil_1 = mobil_1;
		this.mobil_2 = mobil_2;
	}

	// @RequiredStringValidator(key = "validation.register")
	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		// regNumber= regNumber.toUpperCase();
		// regNumber = checkReg(regNumber);
		this.regNumber = regNumber;
	}

	@RequiredStringValidator(key = "validation.required")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@RequiredStringValidator(key = "validation.required")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		phone = checkPhone(phone);
		this.phone = phone;
	}

	public String getMobil_1() {
		return mobil_1;
	}

	public void setMobil_1(String mobil_1) {
		mobil_1 = checkPhone(mobil_1);
		this.mobil_1 = mobil_1;
	}

	public String getMobil_2() {
		return mobil_2;
	}

	public void setMobil_2(String mobil_2) {
		mobil_2 = checkPhone(mobil_2);
		this.mobil_2 = mobil_2;
	}

	public String checkReg(String s) {
		if (s.indexOf("%") != -1)
			return s;
		return s.matches(Messages.getString("Patient.useg")) ? s : null;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	@ManyToOne
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private String checkPhone(String number) {
		if (number.equals(""))
			return "";
		return number.matches("\\d{8}|\\d{6}") ? number : "";
	}

}
