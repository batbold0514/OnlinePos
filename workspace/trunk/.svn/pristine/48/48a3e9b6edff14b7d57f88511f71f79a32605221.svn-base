package mn.chinbat.surgery.action;

import java.util.List;
import java.util.Map;

import mn.chinbat.surgery.model.Appointment;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.SessionPayment;
import mn.chinbat.surgery.service.AppointmentService;
import mn.chinbat.surgery.service.DoctorService;
import mn.chinbat.surgery.service.PatientService;
import mn.chinbat.surgery.service.SessionPaymentService;

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
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class AppointmentAction extends ActionSupport implements Preparable,
		ModelDriven<Appointment>, SessionAware {

	private static final long serialVersionUID = 1L;
	private AppointmentService appointmentService;

	private Appointment appointment = new Appointment();
	private List<Appointment> list;
	private int empHash;
	private String patientid;
	private PatientService patientService;
	private String active;
	private DoctorService doctorService;
	private Map<String, Object> m;
	private SessionPaymentService spService;
	

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	public void setSpService(final SessionPaymentService spService) {
		this.spService = spService;
	}

	public void setAppointmentService(
			final AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(final Appointment appointment) {
		this.appointment = appointment;
	}

	public List<Appointment> getList() {
		return list;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Appointment getModel() {
		return appointment;
	}

	public void prepare() throws Exception {
		if ((appointment != null) && (appointment.getId() != null)) {
			this.appointment = appointmentService.get(appointment.getId());
			this.empHash = appointment.hashCode();
		}
	}

	@Override
	@SkipValidation
	@Action(value = "appointment", results = { @Result(name = "success", type = "tiles", location = "/appointment.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "saveAppointment", results = {
			@Result(name = "success", location = "calendar", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/appointment.tiles") })
	public String save() throws Exception {
		patientid = patientid.trim();
		if (patientid.equals("") || patientid == null || patientid.equals(null)) {
			appointment.setPatientid(null);
		} else {
			List<Patient> list = patientService.searchById(Long
					.parseLong(patientid.trim()));
			appointment.setPatientid(appointment.getPatientid().trim());
			if (active.equals("1")) {
				appointment.setPatient(list.get(0));
				@SuppressWarnings("unchecked")
				List<SessionPayment> Listsp =  spService.getCurrentSession().getNamedQuery("Sp.Deference").setLong("id", appointment.getPatient().getId()).list();
				if(!Listsp.isEmpty()){
					appointment.setSp_Deference(Listsp.get(0).getDeference());
//					JOptionPane.showMessageDialog(null, Listsp.get(0).getDeference());
				}else{
					appointment.setSp_Deference(0);
				}
			} else {
				appointment.setPatient(null);
			}
		

		}
		Long l = (long) appointment.getResourceId();
		appointment.setDoctor(doctorService.get(l));
		if (appointment.hashCode() != empHash) {
			m.put("caldate", appointment.getBegin());
			appointmentService.saveOrUpdate(appointment);
		}
		return SUCCESS;
	}
	@Action(value = "updateAppointment", results = {
			@Result(name = "success", location = "calendar", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/appointment.tiles") })
	public String update() throws Exception {
		m.put("caldate", appointment.getBegin());
		appointmentService.updateAppointment(appointment.getTime(),
				appointment.getDuration(), appointment.getResourceId(),
				appointment.getId());
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "deleteAppointment", results = {
			@Result(name = "success", location = "calendar", type = "redirectAction"),
			@Result(name = "input", type = "tiles", location = "/appointment.tiles") })
	public String delete() throws Exception {
		if (appointment.hashCode() != empHash) {
			m.put("caldate", appointment.getBegin());
			appointmentService.deleteAppointment(appointment.getId());
		}
		return SUCCESS;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}
}