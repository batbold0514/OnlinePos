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

import mn.chinbat.surgery.enums.PaymentMethod;

@Entity
@Table(name = "payment")
@NamedQueries({
		@NamedQuery(name = "Payment.getLast", query = "select p from Payment p order by id desc limit 1"),
		@NamedQuery(name = "Payment.getLastDate", query = "select p from Payment p order by savedDate desc limit 1"),
		@NamedQuery(name = "Payment.getDate", query = "select p from Payment p where p.date like :date"),
		@NamedQuery(name = "Payment.getDayBalanceWithDoctor", query = "select p from Payment p where p.date between :date1 and :date2 and p.paymentMethod like :method and p.user like :user and p.doctor.id like :doctorID"),
		@NamedQuery(name = "Payment.getDayBalance", query = "select p from Payment p where p.date between :date1 and :date2 and p.paymentMethod like :method and p.user like :user"),
		@NamedQuery(name = "Payment.getUsers", query = "select p.user from Payment p group by p.user"),
		@NamedQuery(name = "Payment.getValueForDocrtor", query = "select sum(value) from Payment p where doctor.id like :id and date between :date1 and :date2"),
		@NamedQuery(name = "Payment.getValueForDocrtorAndPatient", query = "select sum(value) from Payment p where doctor.id like :id and patient.id like :pId and date between :date1 and :date2"),
		@NamedQuery(name = "Payment.getDirectValue", query = "select sum(p.value) from Payment p where patient.id in (select patient.id from DoctorSession ds where ds.date between :date1 and :date2 and ds.doctor.id = :doctorID) and p.date between :date1 and :date2 and p.doctor.id = :doctorID"),
		@NamedQuery(name = "Payment.getDirectPayments", query = "select p from Payment p where p.patient.id not in (select ds.patient.id from DoctorSession ds where ds.date between :date1 and :date2 and ds.doctor.id = :doctorID) and p.date between :date1 and :date2 and p.doctor.id = :doctorID"),
		@NamedQuery(name = "Payment.bestValues", query = "select sum(p.value) from Payment p where p.date between :date1 and :date2 group by p.patient.id order by sum(p.value) desc"),
		@NamedQuery(name = "Payment.bestPatients", query = "select p.patient from Payment p where p.date between :date1 and :date2 group by p.patient.id order by sum(p.value) desc"),
		})
public class Payment {
	private Long id;
	private PaymentMethod paymentMethod;
	private int value;
	private String description;
	private String paymentNumber;
	private Date date = new Date();
	private boolean printed;
	private Patient patient;
	private Date savedDate = new Date();
	private String user;
	private Doctor doctor;

	public Payment() {
	}

	public Payment(PaymentMethod paymentMethod, int value, String description) {
		this.paymentMethod = paymentMethod;
		this.value = value;
		this.description = description;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPrinted() {
		return printed;
	}

	public void setPrinted(boolean printed) {
		this.printed = printed;
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

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getSavedDate() {
		return savedDate;
	}

	public void setSavedDate(Date savedDate) {
		this.savedDate = savedDate;
	}

	@ManyToOne
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
