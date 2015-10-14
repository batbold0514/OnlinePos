package mn.chinbat.surgery.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity()
@Table(name = "doctorSession")
@NamedQueries({
		@NamedQuery(name = "DoctorSession.searchSession", query = ""
				+ "select e from DoctorSession e where e.patient.id like :id"),
		@NamedQuery(name = "DoctorSession.getLastAdd", query = "select ds from DoctorSession ds order by id desc limit 1"),
		@NamedQuery(name = "Session.getByYearAndMonth", query = "select ds from DoctorSession ds where date between :date1 and :date2 and paid like 'true' order by doctor.id"),
		@NamedQuery(name = "Session.getByYearAndMonthForDegfim", query = "select ds from DoctorSession ds where date between :date1 and :date2 order by doctor.id"),
		@NamedQuery(name = "Session.getByYearAndMonthWithDoctor", query = "select ds from DoctorSession ds where date between :date1 and :date2 and paid like 'true' and ds.doctor.id = :id order by doctor.id"),
		@NamedQuery(name = "Session.getByYearAndMonthWithDoctorForDegfim", query = "select ds from DoctorSession ds where date between :date1 and :date2 and ds.doctor.id = :id order by doctor.id"),
		@NamedQuery(name = "Session.getByYearAndMonthPaidFalse", query = "select ds from DoctorSession ds where date between :date1 and :date2 and paid like 'false' order by doctor.id"),
		@NamedQuery(name = "Session.getByYearAndMonthWithDoctorPaidFalse", query = "select ds from DoctorSession ds where date between :date1 and :date2 and paid like 'false' and ds.doctor.id = :id order by doctor.id"),
		@NamedQuery(name = "Session.example", query = "select ds.doctor from DoctorSession ds"),
		@NamedQuery(name = "Session.ServicePrice", query = "select ds.listOfService from DoctorSession ds where date between :date1 and :date2"),
		@NamedQuery(name = "Session.ServicePriceWithDoctor", query = "select ds.listOfService from DoctorSession ds where date between :date1 and :date2 and ds.doctor.id = :id"),
		@NamedQuery(name = "Session.getSumOfPaidTrue", query = "select sum(ds.sum) from DoctorSession ds where paid like 'true' and date between :date1 and :date2 and ds.doctor.id = :id"),
		@NamedQuery(name = "Session.getSumOfPaidFalse", query = "select sum(ds.sum) from DoctorSession ds where paid like 'false' and date between :date1 and :date2 and ds.doctor.id = :id"),
		@NamedQuery(name = "Session.getSumOfSessionForDoctor",query = "select sum(ds.sum) from DoctorSession ds where date between :date1 and :date2 and doctor.id = :id")})
public class DoctorSession {
	private Long id;
	private Doctor doctor;
	private Patient patient;
	private Date date = new Date();
	private List<ServicePrice> listOfService;
	private List<Diagnosis> listOfDiagnosis;
	private boolean paid = false;
	private int sum;
	private String note;

	public DoctorSession() {
	}

	@ManyToOne
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToMany
	public List<ServicePrice> getListOfService() {
		return listOfService;
	}

	public void setListOfService(List<ServicePrice> listOfService) {
		this.listOfService = listOfService;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Column(length = 1024)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	@ManyToMany
	public List<Diagnosis> getListOfDiagnosis() {
		return listOfDiagnosis;
	}

	public void setListOfDiagnosis(List<Diagnosis> listOfDiagnosis) {
		this.listOfDiagnosis = listOfDiagnosis;
	}

}
