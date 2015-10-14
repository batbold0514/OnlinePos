package mn.chinbat.surgery.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import mn.chinbat.surgery.enums.Customer;
import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.Payment;
import mn.chinbat.surgery.model.PaymentNumberCounter;
import mn.chinbat.surgery.model.SessionPayment;
import mn.chinbat.surgery.service.DoctorService;
import mn.chinbat.surgery.service.PatientService;
import mn.chinbat.surgery.service.PaymentNumberService;
import mn.chinbat.surgery.service.PaymentService;
import mn.chinbat.surgery.service.SessionPaymentService;
import mn.chinbat.surgery.service.SsmLoggerService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class PaymentAction extends ActionSupport implements Preparable,
		ModelDriven<Payment> {

	private static final long serialVersionUID = 1L;
	private PaymentService paymentService;
	private Payment payment = new Payment();
	private PaymentNumberService numberService;
	private PatientService patientService;
	private int paymentHash;
	private List<Payment> paymentList;
	private Long id;
	private SsmLoggerService ssm = new SsmLoggerService();
	private SessionPaymentService spService;
	private DoctorService doctorService;
	private String doctorID;

	public void prepare() throws Exception {
		if ((payment != null) && payment.getId() != null) {
			this.payment = paymentService.get(payment.getId());
			this.paymentHash = payment.hashCode();
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Payment getModel() {
		return payment;
	}

	@Override
	@SkipValidation
	@Action(value = "payment", results = { @Result(name = "success", type = "tiles", location = "/payment.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "payments", results = { @Result(name = "success", type = "tiles", location = "/payment-list.tiles") })
	@SkipValidation
	public String list() {
		this.paymentList = paymentService.findAll();
		return SUCCESS;
	}

	@Action(value = "savePayment", results = {
			@Result(name = "success", location = "spPayment", type = "redirectAction", params = {
					"model.id", "${id}" }),
			@Result(name = "input", type = "tiles", location = "/payment.tiles") })
	public String save() {
		if (payment != null && payment.hashCode() != paymentHash) {
			if (doctorID != null && doctorID.equals("")) {
				addFieldError("doctorID",
						Messages.getString("DoctorSessionAction.CheckDoctor"));
				return INPUT;
			}
			if (!payment.getPaymentMethod().equals(PaymentMethod.MONEY_BACK)
					&& payment.getValue() <= 0) {
				addFieldError("value",
						Messages.getString("PaymentAction.WrongValue"));
				return INPUT;
			}
			if (Messages.getCustomer("customer").trim()
					.equals(Customer.degfim.toString().trim())
					&& getDoctors() != null) {
				if (!payment.getPaymentMethod()
						.equals(PaymentMethod.MONEY_BACK)) {
					if (payment.getValue() > checkVal()) {
						addFieldError("value", "Мөнгөн дүн " + checkVal()
								+ " -аас дээш байж болохгүй");
						return INPUT;
					}
				} else {
					if (payment.getValue() > getDoctorSessionValue()) {
						addFieldError("value", "Мөнгөн дүн "
								+ getDoctorSessionValue()
								+ " -аас дээш байж болохгүй");
						return INPUT;
					}
				}
			}
			if (numberService.findAll().size() == 0)
				numberService.saveOrUpdate(new PaymentNumberCounter());
			PaymentMethod method = payment.getPaymentMethod();
			List<Patient> patientList = patientService.searchById(id);
			payment.setPatient(patientList.get(0));
			if (method.equals(PaymentMethod.MONEY_BACK)
					&& payment.getValue() > 0) {
				payment.setValue(payment.getValue() * (-1));
			}
			if (doctorID != null)
				payment.setDoctor(doctorService.get(Long.parseLong(doctorID)));
			payment.setPaymentNumber(numberService.getNextPaymentNumber(method));
			payment.setId(null);
			paymentService.saveOrUpdate(payment);
			ssm.logInfo(payment);
			return SUCCESS;
		}
		return INPUT;
	}

	@Action(value = "editPayment", results = {
			@Result(name = "success", location = "spPaymentEdit", type = "redirectAction", params = {
					"model.id", "${id,patient.id}" }),
			@Result(name = "input", type = "tiles", location = "/paymentEdit.tiles") })
	public String edit() {
		if (payment != null && payment.hashCode() != paymentHash) {
			PaymentMethod method = payment.getPaymentMethod();
			List<Patient> paymentList = patientService.searchById(payment
					.getPatient().getId());
			payment.setPatient(paymentList.get(0));
			payment.setPaymentNumber(numberService.getNextPaymentNumber(method));
			paymentService.update(payment);
			ssm.logInfo(payment);
			return SUCCESS;
		}
		return INPUT;
	}

	/*
	 * @Action(value = "print", results = { @Result(name = "success", location =
	 * "spPayment", type = "redirectAction", params = { "model.id",
	 * "${id,patient.id}" }) }) public String Print() { return SUCCESS; }
	 */

	public List<Doctor> getDoctors() {
		try {
			SessionPayment sp = spService.getSpExistPatient(id);
			if (sp == null)
				return null;
			List<Doctor> doctors = new LinkedList<Doctor>();
			List<DoctorSession> list = sp.getListOfSession();
			for (DoctorSession ds : list) {
				if (!doctors.contains(ds.getDoctor())) {
					doctors.add(ds.getDoctor());
				}
			}
			if (doctors.isEmpty())
				return null;
			else
				return doctors;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Doctor> getAllDoctors() {
		return doctorService.findAll();
	}

	public int checkVal() {
		Doctor doctor = doctorService.get(Long.parseLong(doctorID));
		SessionPayment sp = spService.getSpExistPatient(id);
		int sessionVal = 0;
		for (DoctorSession ds : sp.getListOfSession()) {
			if (ds.getDoctor().getId() == doctor.getId()) {
				sessionVal += ds.getSum();
			}
		}
		int paymentVal = 0;
		for (Payment p : sp.getListOfPayment()) {
			Doctor doctor1 = paymentService.get(p.getId()).getDoctor();
			if (doctor1 != null)
				if (doctor1.getId() == doctor.getId()) {
					paymentVal += p.getValue();
				}
		}
		return sessionVal - paymentVal;
	}

	private int getDoctorSessionValue() {
		int sessionVal = 0;
		Doctor doctor = doctorService.get(Long.parseLong(doctorID));
		SessionPayment sp = spService.getSpExistPatient(id);
		for (DoctorSession ds : sp.getListOfSession()) {
			if (ds.getDoctor().getId() == doctor.getId()) {
				sessionVal += ds.getSum();
			}
		}
		return sessionVal;
	}

	public void setPatientService(final PatientService patientService) {
		this.patientService = patientService;
	}

	public PaymentMethod[] getPaymentMethods() {
		return PaymentMethod.valuesWithoutAll();
	}

	public PaymentMethod[] getPaymentMethodsForUser() {
		return PaymentMethod.valuesForUserRole();
	}

	public void setPaymentService(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void setNumberService(final PaymentNumberService numberService) {
		this.numberService = numberService;
	}

	public void setSpService(final SessionPaymentService spService) {
		this.spService = spService;
	}

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (payment.getDate() == null)
			return null;
		return formatter.format(payment.getDate());
	}

	public void setDateString(String dateString) {
		payment.setDate(stringToDate(dateString));
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
