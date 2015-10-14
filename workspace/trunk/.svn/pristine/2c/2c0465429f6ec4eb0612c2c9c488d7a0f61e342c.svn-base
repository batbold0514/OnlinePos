package mn.chinbat.surgery.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.chinbat.surgery.enums.enumDoctors;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.Users;
import mn.chinbat.surgery.service.DoctorService;
import mn.chinbat.surgery.service.SsmLoggerService;
import mn.chinbat.surgery.service.UsersService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class DoctorAction extends ActionSupport implements Preparable,
		ModelDriven<Doctor>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private DoctorService doctorService;
	private Doctor doctor = new Doctor();
	private int doctorHash;
	private List<Doctor> doctorList;
	private UsersService usersService;
	private String doctorUserString;
	private SsmLoggerService ssm = new SsmLoggerService();
	private HttpServletRequest request;
	private String doctorUserStringHid;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Doctor getModel() {
		return doctor;
	}

	public String getDoctorUserStringHid() {
		return doctorUserStringHid;
	}

	public void setDoctorUserStringHid(String doctorUserStringHid) {
		this.doctorUserStringHid = doctorUserStringHid;
	}

	public void prepare() throws Exception {
		if ((doctor != null) && (doctor.getId() != null)) {
			this.doctor = doctorService.get(doctor.getId());
			this.doctorHash = doctor.hashCode();
			doctorUserString = "" + doctor.getDoctorUser().getId();
		}
	}

	@Action(value = "doctors", results = { @Result(name = "success", type = "tiles", location = "/doctor-list.tiles") })
	@SkipValidation
	public String list() throws Exception {
		this.doctorList = doctorService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "doctor-edit", results = { @Result(name = "success", type = "tiles", location = "/doctor-edit.tiles") })
	public String execute1() throws Exception {
		return SUCCESS;
	}

	@Action(value = "save-doctor-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-doctor/ajax-doctor-add.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-doctor/ajax-doctor-add.jsp") })
	public String saveAjax() throws Exception {
		// try {
		if (doctor != null && doctor.hashCode() != doctorHash) {
			if (doctorService.hasConjuctiopn(doctor.getId(),
					doctor.getRegistrationNumber())) {
				addFieldError("registrationNumber",
						Messages.getString("DoctorAction.1"));
				return SUCCESS;
			}
			if (doctorUserString.equals("")) {
				if (doctor.getId() == null)
					doctor.setDoctorUser(null);
				else {
					if (!doctorUserStringHid.equals(""))
						doctor.setDoctorUser(usersService
								.getUser(doctorUserStringHid));
					else
						doctor.setDoctorUser(null);
				}
			} else
				doctor.setDoctorUser(usersService.get(Long
						.parseLong(doctorUserString)));
			doctor.setMobile1(doctor.getMobile1());
			doctor.setMobile2(doctor.getMobile2());
			doctor.setPhoneNumber(doctor.getPhoneNumber());
			doctorService.saveOrUpdate(doctor);
			request.setAttribute("doctorSuccess", true);
			ssm.logInfo(doctor);
			return SUCCESS;
		}
		// } catch (ConstraintViolationException e) {
		// addFieldError("mobile1", Messages.getString("PatientAction.8"));
		// } catch (NullPointerException e) {
		// addFieldError("mobile1", Messages.getString("PatientAction.8"));
		// } catch (Exception e) {
		// addFieldError("registrationNumber",
		// Messages.getString("DoctorAction.7"));
		// return SUCCESS;
		// }
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "get-doctorList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-doctor/ajax-doctor-list.jsp") })
	public String getList() throws Exception {
		this.doctorList = doctorService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "get-select-doctorList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-doctor/ajax-select-doctor.jsp") })
	public String getselectList() throws Exception {
		return SUCCESS;
	}

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public enumDoctors[] getStatuss() {
		return enumDoctors.values();
	}

	public String getDoctorUserString() {
		return doctorUserString;
	}

	public void setDoctorUserString(String doctorUserString) {
		this.doctorUserString = doctorUserString;
	}

	public List<Users> getUsersList() {
		return usersService.getUserNotInDoctor();
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
