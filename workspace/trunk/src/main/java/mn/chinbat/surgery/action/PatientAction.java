package mn.chinbat.surgery.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.chinbat.surgery.enums.Sex;
import mn.chinbat.surgery.model.Address;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.PatientWithAge;
import mn.chinbat.surgery.model.SessionPayment;
import mn.chinbat.surgery.service.AddressService;
import mn.chinbat.surgery.service.DoctorSessionService;
import mn.chinbat.surgery.service.PatientService;
import mn.chinbat.surgery.service.PaymentService;
import mn.chinbat.surgery.service.SessionPaymentService;
import mn.chinbat.surgery.service.SsmLoggerService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class PatientAction extends ActionSupport implements Preparable,
		ModelDriven<Patient>, SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private PatientService patientService;
	private SessionPaymentService spService;
	private Patient patient = new Patient();
	private List<Patient> patientList;
	private List<PatientWithAge> patientAgeList;
	private List<SessionPayment> listOfSessionPayments;
	private int patientHash;
	private Map<String, Object> m;
	private String patientid;
	private Date date = changeDayByOne(new Date());
	private Date secondDate = new Date();
	private Date checkDate = minusTreeDays(new Date());
	private SsmLoggerService ssm = new SsmLoggerService();
	private AddressService addressService;
	private HttpServletRequest request;
	private String addId;
	private String addressCity;
	private String addressDestrict;
	private String addressSection;
	private String addressApartment;
	
	

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addressId) {
		this.addId = addressId;
		Long dd = null;
		if(addressId == null || addressId.equals("")){
			 dd = addressService.save(new Address());
		}
		else{
			dd= Long.parseLong(addressId);
		}
		this.patient.setAddress(addressService.get(dd));
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		if(addressCity != null)
		this.patient.getAddress().setCity(addressCity);
		this.addressCity = addressCity;
	}

	public String getAddressDestrict() {
		return addressDestrict;
	}

	public void setAddressDestrict(String addressDestrict) {
		if(addressDestrict != null)
		this.patient.getAddress().setDestrict(addressDestrict);
		this.addressDestrict = addressDestrict;
	}

	public String getAddressSection() {
		return addressSection;
	}

	public void setAddressSection(String addressSection) {
		if(addressSection != null)
		this.patient.getAddress().setSection(addressSection);
		this.addressSection = addressSection;
	}

	public String getAddressApartment() {
		return addressApartment;
	}

	public void setAddressApartment(String addressApartment) {
		if(addressApartment != null)
		this.patient.getAddress().setApartment(addressApartment);
		this.addressApartment = addressApartment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getSecondDate() {
		return secondDate;
	}

	public void setSecondDate(Date secondDate) {
		this.secondDate = secondDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setDoctorSessionService(
			final DoctorSessionService doctorSessionService) {
	}

	public void setPaymentService(final PaymentService paymentService) {
	}

	public void setSpService(final SessionPaymentService spService) {
		this.spService = spService;
	}

	public void setAddressService(final AddressService addressService) {
		this.addressService = addressService;
	}

	public List<SessionPayment> getListOfSessionPayments() {
		return listOfSessionPayments;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public List<PatientWithAge> getPatientAgeList() {
		return patientAgeList;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public Sex[] getSexs() {
		return Sex.values();
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Patient getModel() {
		return patient;
	}

	public void prepare() throws Exception {
		if (patient != null && patient.getId() != null) {
			this.patient = patientService.get(patient.getId());
			this.patientHash = patient.hashCode();
		}
	}

	@Action(value = "search", results = { @Result(name = "success", type = "tiles", location = "/search-list.tiles") })
	@SkipValidation
	public String search() throws Exception {
		patientList = patientService.search(patient.getRegNumber(),
				patient.getLastName(), patient.getFirstName(),
				patient.getPhone(), patient.getCardNumber());
		patientAgeList = new LinkedList<PatientWithAge>();

		for (int i = 0; i < patientList.size(); i++) {
			PatientWithAge patientWithAge = new PatientWithAge(
					patientList.get(i));
			patientWithAge.setAge(patientService.getAge(patientList.get(i)
					.getBirthday()));
			patientAgeList.add(patientWithAge);
		}
		return SUCCESS;
	}

	@Override
	@SkipValidation
	@Action(value = "linkPatient", results = { @Result(name = "success", type = "tiles", location = "/patient.tiles") })
	public String execute() throws Exception {
		m.put("newCardNumber", patientService.newCardNumber());
		return SUCCESS;
	}

	@Action(value = "savePatient", results = {
			@Result(name = "success", location = "showPatient", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/patient.tiles") })
	public String save() throws Exception {
		try {
			if (patient != null && patient.hashCode() != patientHash) {
				boolean check = false;
				if (!patient.getCardNumber().matches("\\d+")) {
					addFieldError("cardNumber",
							Messages.getString("cardNumber"));
					check = true;
				}
				if (patientService.hasConjuctiopn(patient.getId(),
						patient.getRegNumber())) {
					addFieldError("regNumber",
							Messages.getString("PatientAction.1"));
					check = true;
				}
				if (!SessionInterceptor.isValid()) {
					return ERROR;
				}
				if (!patient.getRegNumber().matches(
						Messages.getString("Patient.useg"))
						&& !patient.getRegNumber().equals("")) {
					addFieldError("regNumber",
							Messages.getString("notRegNumber"));
					check = true;
				}
				if (check)
					return INPUT;
				patient.setMobil_1(patient.getMobil_1());
				patient.setMobil_2(patient.getMobil_2());
				patient.setPhone(patient.getPhone());
				patientService.saveOrUpdate(patient);
				ssm.logInfo(patient);
				return SUCCESS;
			}
		} catch (ConstraintViolationException e) {
			addFieldError("mobile1", Messages.getString("PatientAction.3"));
		} catch (NullPointerException e) {
			addFieldError("mobile1", Messages.getString("PatientAction.5"));
		} catch (Exception e) {
			addFieldError("regNumber", Messages.getString("PatientAction.7"));
		}
		return INPUT;
	}

	@Action(value = "ajax-save-patient", results = {
			@Result(name = "input", location = "/WEB-INF/content/ajax-patient/patient-result.jsp"),
			@Result(name = "success", location = "/WEB-INF/content/ajax-patient/patient-result.jsp") })
	public String saveAjax() throws Exception {
		try {
			if (patient != null && patient.hashCode() != patientHash) {
				boolean check = false;
				if (patient.getFirstName().equals("")) {
					addFieldError("firstName", Messages.getString("inputEmpty"));
					check = true;
				}
				if (patient.getLastName().equals("")) {
					addFieldError("lastName", Messages.getString("inputEmpty"));
					check = true;
				}
				if (!patient.getCardNumber().matches("\\d+")) {
					addFieldError("cardNumber",
							Messages.getString("cardNumber"));
					check = true;
				}
				if (patientService.hasConjuctiopn(patient.getId(),
						patient.getRegNumber())) {
					addFieldError("regNumber",
							Messages.getString("PatientAction.1"));
					check = true;
				}
				if (!SessionInterceptor.isValid()) {
					return ERROR;
				}
				if (!patient.getRegNumber().matches(
						Messages.getString("Patient.useg"))
						&& !patient.getRegNumber().equals("")) {
					addFieldError("regNumber",
							Messages.getString("notRegNumber"));
					check = true;
				}
				if (check)
					return INPUT;
				Long addressId = addressService.save(patient.getAddress());
				patient.setAddress(addressService.get(addressId));
				patient.setMobil_1(patient.getMobil_1());
				patient.setMobil_2(patient.getMobil_2());
				patient.setPhone(patient.getPhone());
				patientService.saveOrUpdate(patient);
				ssm.logInfo(patient);
				request.setAttribute("patientSuccess", SUCCESS);
				m.put("patientID", patient.getId());
				m.put("id", patient);
				return SUCCESS;
			}
		} catch (ConstraintViolationException e) {
			addFieldError("mobile1", Messages.getString("PatientAction.3"));
		} catch (NullPointerException e) {
			addFieldError("mobile1", Messages.getString("PatientAction.5"));
		} catch (Exception e) {
			addFieldError("regNumber", Messages.getString("PatientAction.7"));
		}
		return INPUT;
	}

	@SkipValidation
	@Action(value = "patient-show-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-patient/patient-show-ajax.jsp") })
	public String patient() throws Exception {
		this.patient = patientService.get((Long) m.get("patientID"));
		m.remove("patientID");
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "session", results = { @Result(name = "success", location = "showPatient", type = "redirectAction", params = {
			"model.id", "${patient.id}" }) })
	public String Session() {
		patient = (Patient) getSession().get("id");
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "session2", results = { @Result(name = "success", location = "showPatient", type = "redirectAction", params = {
			"model.id", "${patient.id}" }) })
	public String Session2() {
		patient = (Patient) getSession().get("id");
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "session1", results = { @Result(name = "success", location = "showPatient", type = "redirectAction", params = {
			"model.id", "${patient.id}" }) })
	public String Session1() {
		patient = (Patient) getSession().get("id");
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "back", results = { @Result(name = "success", location = "showPatient", type = "redirectAction", params = {
			"model.id", "${patient.id}" }) })
	public String Back() {
		patient = patientService.searchById(patient.getId()).get(0);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "backCal", results = {
			@Result(name = "success", location = "showPatient", type = "redirectAction", params = {
					"model.id", "${patient.id}" }),
			@Result(name = "input", location = "calendar", type = "redirectAction") })
	public String BackCal() {
		// patientid = patientid.trim();
		if (patientid == null || patientid.equals("")) {
			return INPUT;
		} else {
			patient = patientService.searchById(Long.parseLong(patientid)).get(
					0);
			return SUCCESS;
		}

	}

	@SkipValidation
	@Action(value = "history", results = { @Result(name = "success", type = "tiles", location = "/history.tiles") })
	public String History() {
		if (patient.getId() != null)
			listOfSessionPayments = spService.getSpDeferenceDateRange(
					patient.getId(), date, secondDate);
		else {
			listOfSessionPayments = spService.getSpDeferenceDateRange(
					(Long) m.get("patientid"), date, secondDate);
			m.remove("patientid");
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "historyRange", results = { @Result(name = "success", type = "tiles", location = "/history.tiles") })
	public String HistoryRange() {
		patient = (Patient) m.get("id");
		listOfSessionPayments = spService.getSpDeferenceDateRange(
				patient.getId(), date, secondDate);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "showPatient", results = { @Result(name = "success", type = "tiles", location = "/patient-show.tiles") })
	public String show() throws Exception {
		patientList = patientService.search(patient.getRegNumber(),
				patient.getLastName(), patient.getFirstName(),
				patient.getPhone(), patient.getCardNumber());

		/*
		 * patient = patientService.get(patient.getId()); patientList.clear();
		 * patientList.add(patient);
		 */
		listOfSessionPayments = spService.getSpNonDeference(patient.getId());
		m.put("id", patient);
		m.put("patientList", patientList);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "calendarShow", results = { @Result(name = "success", type = "redirectAction", location = "calendar") })
	public String show1() throws Exception {
		m.put("id", patient);
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public void setSession(Map<String, Object> m) {
		this.m = m;
	}

	public int getAge() {
		int age = patientService.getAge(patient.getBirthday());

		assert age >= 0 : "age >= 0";
		return age;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	private Date changeDayByOne(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	private Date minusTreeDays(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE) - 3);
		return cal.getTime();
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getBirthdayStr() {
		if (patient.getBirthday() == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(patient.getBirthday());
	}

	public void setBirthdayStr(String birthdayStr) {
		this.patient.setBirthday(stringToDate(birthdayStr));
	}

	public void setDateStr(String dateStr) {
		this.date = stringToDate(dateStr);
	}

	public String getDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public void setSecondDateStr(String secondDateStr) {
		this.secondDate = stringToDate(secondDateStr);
	}

	public String getSecondDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(secondDate);
	}

	private Date stringToDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!str.equals(""))
				date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
