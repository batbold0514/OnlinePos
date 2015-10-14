package mn.chinbat.surgery.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

/**
 * Employee.
 */
@Entity()
@Table(name = "appointment")
@NamedQueries({
		@NamedQuery(name = Appointment.GET_BY_RANGE_QUERY_NAME, query = "select a from Appointment a where a.begin between :start and :end and a.doctor.status <>:fired"),
		@NamedQuery(name = "Appointment.getDurationOdDoctor", query = "select sum(duration) from Appointment where doctor.id = :id and begin between :date1 and :date2"),
		@NamedQuery(name = "update", query = "update Appointment set resourceId = :userId , time =:time , duration=:dur where  id=:id"),
		@NamedQuery(name = "delete", query = "delete from Appointment where  id=:id") })
public class Appointment extends IDEntity {

	public static final String GET_BY_RANGE_QUERY_NAME = "Appointment.getByRange";

	private Date begin = new Date();
	private int duration;
	private int resourceId;
	private String time;
	private Patient patient;
	private String patientid;
	private String title;
	private Doctor doctor;
	private int Sp_Deference;

	@ManyToOne
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Appointment() {
	}

	public Appointment(final Date begin, final int duration, final int userId) {
		this.begin = begin;
		this.duration = duration;
		this.setResourceId(userId);
	}

	@RequiredFieldValidator(key = "validation.required")
	@IntRangeFieldValidator(min = "1")
	@Column(nullable = false)
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if (duration % 10 == 4 || duration % 10 == 9)
			duration++;
		this.duration = duration;
	}

	@Column(nullable = false)
	@RequiredFieldValidator(key = "validation.required")
	public Date getBegin() {
		return begin;
	}

	public void setBegin(final Date begin) {
		this.begin = begin;
	}

	public String getTime() {
		time = "" + begin.getTime();
		return time;
	}

	public void setTime(String time) {
		Date time1 = new Date(Long.parseLong(time));
		Calendar timeCal = new GregorianCalendar();
		timeCal.setTime(time1);
		Calendar cal = new GregorianCalendar();
		cal.setTime(begin);
		cal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
		cal.set(Calendar.DATE, timeCal.get(Calendar.DATE));
		cal.set(Calendar.MONTH, timeCal.get(Calendar.MONTH));
		cal.set(Calendar.YEAR, timeCal.get(Calendar.YEAR));
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		setBegin(cal.getTime());
	}

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public int getSp_Deference() {
		return Sp_Deference;
	}

	public void setSp_Deference(int Sp_Deference) {
		this.Sp_Deference = Sp_Deference;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

}
