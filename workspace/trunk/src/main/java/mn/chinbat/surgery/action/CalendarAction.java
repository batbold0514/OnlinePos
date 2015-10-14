package mn.chinbat.surgery.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mn.chinbat.surgery.model.Appointment;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.service.AppointmentService;
import mn.chinbat.surgery.service.DoctorService;
import mn.chinbat.surgery.service.PatientService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class CalendarAction extends ActionSupport implements
		ModelDriven<Appointment>, Preparable, SessionAware {

	private static final long serialVersionUID = 1L;
	private DoctorService doctorService;
	private PatientService patientService;
	private String doctorList;
	private String doctorStatusList;
	private List<Doctor> listDoctor;
	private int size;
	private Date calDate;
	private int size1;
	private Map<String, Object> m;
	private Appointment appointment = new Appointment();

	public Long getCalDate() {
		Date d1 = (Date) m.get("caldate");
		if (d1 == null) {
			calDate = new Date();
		} else {
			calDate = d1;
		}
		return calDate.getTime();
	}

	private AppointmentService appointmentService;

	public void setAppointmentService(
			final AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public List<Patient> getListPatient() {
		return patientService.findAll();
	}

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
	}

	@Override
	@Action(value = "calendar", results = { @Result(name = "success", type = "tiles", location = "/calendar.tiles") })
	@SkipValidation
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "menu", results = { @Result(name = "success", type = "redirectAction", location = "calendar") })
	@SkipValidation
	public String execute1() throws Exception {
		return SUCCESS;
	}

	public String getDoctorList() {
		doctorList = "'";
		List<Doctor> list = doctorService.getNormalDoctors();
		for (int i = 0; i != list.size(); i++)
			if (i != list.size() - 1) {
				doctorList = doctorList.concat(list.get(i).getName() + " ");
				doctorList = doctorList.concat(list.get(i).getId() + " ");
			} else {
				doctorList = doctorList.concat(list.get(i).getName() + " ");
				doctorList = doctorList.concat(list.get(i).getId() + "'");
			}
		if (list.size() == 0)
			doctorList += "noDoctor'";
		return doctorList;
	}

	public void setDoctorList(final String doctorList) {
		this.doctorList = doctorList;
	}

	public int getSize() {
		size = doctorService.getNormalDoctors().size();
		return size;
	}

	public void setSize(final int size) {
		this.size = size;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(final Appointment appointment) {
		this.appointment = appointment;
	}

	public Appointment getModel() {
		return appointment;
	}

	public void prepare() throws Exception {
		if ((appointment != null) && (appointment.getId() != null)) {
			this.appointment = appointmentService.get(appointment.getId());
			appointment.hashCode();
		}

	}

	public List<Doctor> getListDoctor() {
		listDoctor = doctorService.findAll();
		return listDoctor;
	}

	public String getDoctorStatusList() {
		doctorStatusList = "'";
		List<Doctor> list = doctorService.getNormalDoctors();
		size1 = 0;
		for (int i = 0; i != list.size(); i++)
			if (i != (list.size() - 1)
					&& !list.get(i).getStatus()
							.equals(Messages.getString("Doctor.normal"))) {
				size1++;
				doctorStatusList = doctorStatusList.concat(i + " ");
			} else if (!list.get(i).getStatus()
					.equals(Messages.getString("Doctor.normal"))) {
				doctorStatusList = doctorStatusList.concat(Integer.toString(i));
				size1++;
			}
		doctorStatusList = doctorStatusList.concat("'");
		return doctorStatusList;
	}

	public void setDoctorStatusList(String doctorStatusList) {
		this.doctorStatusList = doctorStatusList;
	}

	public int getSize1() {
		return size1;
	}

	public void setSize1(int size1) {
		this.size1 = size1;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

}
