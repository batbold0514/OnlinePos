package mn.chinbat.surgery.model;

import java.util.Date;
import java.util.List;

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

@Entity
@Table(name = "sessionPayment")
@NamedQueries({
		@NamedQuery(name = "Sp.all", query = "select sp from SessionPayment sp"),
		@NamedQuery(name = "Sp.Deference", query = "select sp from SessionPayment sp where sp.patient.id like :id and deference <> 0"),
		@NamedQuery(name = "Sp.DeferenceDate", query = "select sp from SessionPayment sp where sp.patient.id like :id and deference = 0 and sp.lastActionDate between :start and :end"),
		@NamedQuery(name = "Sp.zeroDeference", query = "select sp from SessionPayment sp where sp.patient.id like :id and deference = 0 order by id desc"),
		@NamedQuery(name = "Sp.debt", query = "select sp from SessionPayment sp where deference < 0 and lastActionDate between :date1 and :date2"),
		@NamedQuery(name = "Sp.donation", query = "select sp from SessionPayment sp where deference > 0 and lastActionDate between :date1 and :date2") })
public class SessionPayment {
	private Long id;
	private List<DoctorSession> listOfSession;
	private List<Payment> listOfPayment;
	private Patient patient;
	private int deference;
	private Date lastActionDate;

	public SessionPayment() {
	}

	public SessionPayment(Patient patient) {
		this.patient = patient;
	}
	public SessionPayment(SessionPayment payment) {
		this.listOfSession = payment.getListOfSession();
		this.listOfPayment = payment.getListOfPayment();
		this.patient = payment.getPatient();
		this.deference = payment.getDeference();
		this.lastActionDate = payment.getLastActionDate();
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

	@ManyToMany
	public List<DoctorSession> getListOfSession() {
		return listOfSession;
	}

	public void setListOfSession(List<DoctorSession> listOfSession) {
		this.listOfSession = listOfSession;
	}

	@ManyToMany
	public List<Payment> getListOfPayment() {
		return listOfPayment;
	}

	public void setListOfPayment(List<Payment> listOfPayment) {
		this.listOfPayment = listOfPayment;
	}

	public int getDeference() {
		return deference;
	}

	public void setDeference(int deference) {
		this.deference = deference;
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getLastActionDate() {
		return lastActionDate;
	}

	public void setLastActionDate(Date lastActionDate) {
		this.lastActionDate = lastActionDate;
	}
}
