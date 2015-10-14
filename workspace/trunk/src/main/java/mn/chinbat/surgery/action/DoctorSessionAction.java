package mn.chinbat.surgery.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.chinbat.surgery.model.Diagnosis;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.ServicePrice;
import mn.chinbat.surgery.service.DiagnosisService;
import mn.chinbat.surgery.service.DoctorService;
import mn.chinbat.surgery.service.DoctorSessionService;
import mn.chinbat.surgery.service.PatientService;
import mn.chinbat.surgery.service.ServicePriceService;
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
public class DoctorSessionAction extends ActionSupport implements Preparable,
		ModelDriven<DoctorSession>, SessionAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoctorSessionService doctorSessionService;
	private ServicePriceService servicePriceService;
	private DoctorSession doctorSession = new DoctorSession();
	private List<DoctorSession> doctorSessionList;
	private PatientService patientService;
	private int doctorSessionHash;
	private DoctorService doctorService;
	private Long id;
	private Patient patient = new Patient();
	private String userId;
	private Map<String, Object> map;
	private DiagnosisService diagnosisService;
	private HttpServletRequest request;
	private SsmLoggerService ssm = new SsmLoggerService();
	private String dateStr = dateToString(new Date());
	private List<Integer> priceCount = new ArrayList<Integer>();

	public List<Integer> getPriceCount() {
		return priceCount;
	}

	public void setPriceCount(List<Integer> priceCount) {
		this.priceCount = priceCount;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public DoctorSession getDoctorSession() {
		return doctorSession;
	}

	public void setDoctorSession(final DoctorSession doctorSession) {
		this.doctorSession = doctorSession;
	}

	public void setDiagnosisService(final DiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}

	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public void setServicePriceService(ServicePriceService servicePriceService) {
		this.servicePriceService = servicePriceService;
	}

	public List<DoctorSession> getDoctorSessionList() {
		return doctorSessionList;
	}

	public void setDoctorSessionService(
			DoctorSessionService doctorSessionService) {
		this.doctorSessionService = doctorSessionService;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public DoctorSession getModel() {
		return doctorSession;
	}

	public void prepare() throws Exception {
		if (doctorSession != null && doctorSession.getId() != null) {
			this.doctorSession = doctorSessionService
					.get(doctorSession.getId());
			this.doctorSessionHash = doctorSession.hashCode();
		}
	}

	@Override
	@SkipValidation
	@Action(value = "linkSession", results = { @Result(name = "success", type = "tiles", location = "/doctorSession.tiles") })
	public String execute() throws Exception {
		map.put("doctor", doctorService.getDoctorWithUser(userId));
		// doctorWithUser = doctorService.getDoctorWithUser(userId);
		return SUCCESS;
	}

	@Action(value = "sessionNextEdit", results = {
			@Result(name = "success", type = "tiles", location = "/doctorSessionNextEdit.tiles", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/doctorSession.tiles") })
	public String nextEdit() throws Exception {
		try {
			if (doctorSession.hashCode() != doctorSessionHash) {
				if (doctorSession.getDoctor().getId() == null) {
					addFieldError(
							"doctor.id",
							Messages.getString("DoctorSessionAction.CheckDoctor"));
					return INPUT;
				}
				if (doctorSession.getListOfService().size() != 0) {
//					doctorSession.setPatient(patientService.searchById(id).get(0));
					doctorSession.setDate(stringToDate(dateStr));
					// doctorSessionService.saveOrUpdate(doctorSession);
					List<ServicePrice> spriceList = doctorSession
							.getListOfService();
					List<ServicePrice> spriceList2 = new ArrayList<ServicePrice>();
					for (ServicePrice sPrice : spriceList) {
						spriceList2
								.add(servicePriceService.get(sPrice.getId()));
					}
					doctorSession.setListOfService(spriceList2);
					map.put("doctorSession", doctorSession);
					ssm.logInfo(doctorSession, sessionListToString(),
							diagnosisListToString(), doctorofDoctorSession());
					return SUCCESS;
				}
				addFieldError("listOfService.id",
						Messages.getString("DoctorSessionAction.CheckSession"));
			}
		} catch (Exception e) {
			// addFieldError("doctor.id",
			// Messages.getString("DoctorSessionAction.CheckDoctor"));
			addFieldError("doctor.id", "Excepion is : " + e);
		}
		return INPUT;
	}
	@Action(value = "sessionNext", results = {
			@Result(name = "success", type = "tiles", location = "/doctorSessionNext.tiles", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/doctorSession.tiles") })
	public String next() throws Exception {
		try {
			if (doctorSession.hashCode() != doctorSessionHash) {
				if (doctorSession.getDoctor().getId() == null) {
					addFieldError(
							"doctor.id",
							Messages.getString("DoctorSessionAction.CheckDoctor"));
					return INPUT;
				}
				if (doctorSession.getListOfService().size() != 0) {
					doctorSession.setId(null);
					doctorSession.setPatient(patientService.searchById(id).get(
							0));
					doctorSession.setDate(stringToDate(dateStr));
					// doctorSessionService.saveOrUpdate(doctorSession);
					List<ServicePrice> spriceList = doctorSession
							.getListOfService();
					List<ServicePrice> spriceList2 = new ArrayList<ServicePrice>();
					for (ServicePrice sPrice : spriceList) {
						spriceList2
								.add(servicePriceService.get(sPrice.getId()));
					}
					doctorSession.setListOfService(spriceList2);
					map.put("doctorSession", doctorSession);
					ssm.logInfo(doctorSession, sessionListToString(),
							diagnosisListToString(), doctorofDoctorSession());
					return SUCCESS;
				}
				addFieldError("listOfService.id",
						Messages.getString("DoctorSessionAction.CheckSession"));
			}
		} catch (Exception e) {
			// addFieldError("doctor.id",
			// Messages.getString("DoctorSessionAction.CheckDoctor"));
			addFieldError("doctor.id", "Excepion is : " + e);
		}
		return INPUT;
	}
	@Action(value = "servicePriceCountNew", results = {
			@Result(name = "success", location = "spSession", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/doctorSessionNext.tiles") })
	public String saveAdmin() throws Exception {
		try {
			doctorSession = (DoctorSession) map.get("doctorSession");
			List<ServicePrice> priceTemp = new ArrayList<ServicePrice>();
			int i = 0;
			for (Integer priceCountd : priceCount) {
				for (int j = 0; j < priceCountd; j++) {
					priceTemp.add(doctorSession.getListOfService().get(i));
				}
				i++;
			}
			doctorSession.setListOfService(priceTemp);
			doctorSessionService.saveOrUpdate(doctorSession);
			map.put("DocrtorSessionID", doctorSession.getId());
				return SUCCESS;
		} catch (Exception e) {
			// addFieldError("doctor.id",
			// Messages.getString("DoctorSessionAction.CheckDoctor"));
			addFieldError("doctor.id", "Excepion is : " + e);
		}
		return INPUT;
	}
	@Action(value = "servicePriceCount", results = {
			@Result(name = "success", location = "spSession1", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/doctorSessionNext.tiles") })
	public String save() throws Exception {
		try {
			doctorSession = (DoctorSession) map.get("doctorSession");
			id = doctorSession.getPatient().getId();
			List<ServicePrice> priceTemp = new ArrayList<ServicePrice>();
			int i = 0;
			for (Integer priceCountd : priceCount) {
				for (int j = 0; j < priceCountd; j++) {
					priceTemp.add(doctorSession.getListOfService().get(i));
				}
				i++;
			}
			doctorSession.setListOfService(priceTemp);
			doctorSessionService.saveOrUpdate(doctorSession);
			map.put("DocrtorSessionID", doctorSession.getId());
			return SUCCESS;
		} catch (Exception e) {
			// addFieldError("doctor.id",
			// Messages.getString("DoctorSessionAction.CheckDoctor"));
			addFieldError("doctor.id", "Excepion is : " + e);
		}
		return INPUT;
	}

	@Action(value = "saveSession", results = {
			@Result(name = "success", location = "spSession", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/doctorSession.tiles") })
	public String countSave() throws Exception {
		try {
			if (doctorSession.hashCode() != doctorSessionHash) {
				if (doctorSession.getDoctor().getId() == null) {
					addFieldError(
							"doctor.id",
							Messages.getString("DoctorSessionAction.CheckDoctor"));
					return INPUT;
				}
				if (doctorSession.getListOfService().size() != 0) {
					// doctorSession.setPatient(patientService.search(patientid,
					// null, null, null).get(0));
					doctorSession.setId(null);
					doctorSession.setPatient(patientService.searchById(id).get(
							0));
					doctorSession.setDate(stringToDate(dateStr));
					doctorSessionService.saveOrUpdate(doctorSession);
					ssm.logInfo(doctorSession, sessionListToString(),
							diagnosisListToString(), doctorofDoctorSession());
					return SUCCESS;
				}
				addFieldError("listOfService.id",
						Messages.getString("DoctorSessionAction.CheckSession"));
			}
		} catch (Exception e) {
			addFieldError("doctor.id", "Excepion is : " + e);
		}
		return INPUT;
	}

	@Action(value = "editDiagnosis", results = { @Result(name = "success", type = "tiles", location = "/doctorSessionEdit.tiles") })
	public String edit() throws Exception {
		Long modelId = Long.parseLong(request.getParameter("model.id").trim());
		this.id = doctorSessionService.get(modelId).getPatient().getId();
		this.dateStr = dateToString(doctorSessionService.get(modelId).getDate());
		map.put("listOfDiagnosis", doctorSessionService.get(modelId)
				.getListOfDiagnosis());
		map.put("listOfService", doctorSessionService.get(modelId)
				.getListOfService());
		return SUCCESS;
	}

	@Action(value = "editSession", results = { @Result(name = "success", type = "redirectAction", location = "history", params = {
			"model.id", "${id,patient.id}" }) })
	public String editSession() throws Exception {
		DoctorSession ds = doctorSessionService.get(doctorSession.getId());
		ds.setNote(doctorSession.getNote());
		ds.setListOfDiagnosis((doctorSession.getListOfDiagnosis()));
		doctorSessionService.saveOrUpdate(ds);
		doctorSession.setListOfService(ds.getListOfService());
		map.put("DocrtorSessionID", doctorSession.getId());
		ssm.logInfo(doctorSession, sessionListToString(),
				diagnosisListToString(), doctorofDoctorSession());
		map.put("patientid", ds.getPatient().getId());
		setPatient(ds.getPatient());
		map.remove("listOfDiagnosis");
		return SUCCESS;
	}

	@Action(value = "editDoctorSession", results = { @Result(name = "success", type = "tiles", location = "/editDoctorSession.tiles") })
	public String editDoctorSession() throws Exception {
		Long modelId = Long.parseLong(request.getParameter("model.id").trim());
		this.id = doctorSessionService.get(modelId).getPatient().getId();
		this.dateStr = dateToString(doctorSessionService.get(modelId).getDate());
		map.put("listOfDiagnosis", doctorSessionService.get(modelId)
				.getListOfDiagnosis());
		map.put("listOfService", doctorSessionService.get(modelId)
				.getListOfService());
		return SUCCESS;
	}

	@Action(value = "editDoctorSessionNext", results = {
			@Result(name = "success", location = "spSession1", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/doctorSession.tiles") })
	public String editDoctorSessionNext() throws Exception {
		
		if (request.isUserInRole("user-role")) {
			if(doctorSession.getListOfService() == null || doctorSession.getListOfService().isEmpty()){
				@SuppressWarnings("unchecked")
				List<ServicePrice> list = (List<ServicePrice>) map.get("listOfService");
				doctorSession.setListOfService(list);
			}
		}
		try {
			if (doctorSession.hashCode() != doctorSessionHash) {
				if (doctorSession.getDoctor().getId() == null) {
					addFieldError(
							"doctor.id",
							Messages.getString("DoctorSessionAction.CheckDoctor"));
					return INPUT;
				}
				if (doctorSession.getListOfService().size() != 0) {
					/*
					 * doctorSessionService.calculateDrSessionSum(doctorSession
					 * .getListOfService());
					 */
					doctorSessionService.saveOrUpdate(doctorSession);
					map.put("DocrtorSessionID", doctorSession.getId());
					ssm.logInfo(doctorSession, sessionListToString(),
							diagnosisListToString(), doctorofDoctorSession());
					return SUCCESS;
				}
				addFieldError("listOfService.id",
						Messages.getString("DoctorSessionAction.CheckSession"));
			}
		} catch (Exception e) {
			addFieldError("doctor.id", "Excepion is : " + e);
		}
		return INPUT;
	}

	public List<Doctor> getDoctors() {
		List<Doctor> list = new LinkedList<Doctor>();
		list.addAll(doctorService.getNormalDoctors());
		return list;
	}

	public List<ServicePrice> getPrices() {
		return servicePriceService.searchActive("1");
	}

	public List<Diagnosis> getDiagnosisList() {
		return diagnosisService.findAll();
	}

	public void setSession(Map<String, Object> session) {
		this.map = session;
	}

	public Map<String, Object> getSession() {
		return map;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	private String sessionListToString() {
		String servicePrice = "";
		for (ServicePrice sp : doctorSession.getListOfService()) {
			ServicePrice spp = servicePriceService.get(sp.getId());
			servicePrice += "^" + spp.getCode() + "." + spp.getName() + "."
					+ spp.getPrice() + "^";
		}
		return servicePrice;
	}

	private String diagnosisListToString() {
		String diagnoses = "";
		for (Diagnosis d : doctorSession.getListOfDiagnosis()) {
			Diagnosis dd = diagnosisService.get(d.getId());
			diagnoses += "^" + dd.getCode() + "." + dd.getName() + "^";
		}
		return diagnoses;
	}

	private String doctorofDoctorSession() {
		Doctor d = doctorService.get(doctorSession.getDoctor().getId());
		return d.getFamilyName() + "." + d.getName();
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	private String dateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
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
