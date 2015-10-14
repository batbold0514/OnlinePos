package mn.chinbat.surgery.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.Payment;
import mn.chinbat.surgery.model.PrinterMiddleModel;
import mn.chinbat.surgery.model.ServicePrice;
import mn.chinbat.surgery.model.SessionPayment;
import mn.chinbat.surgery.service.DoctorService;
import mn.chinbat.surgery.service.DoctorSessionService;
import mn.chinbat.surgery.service.PaymentNumberService;
import mn.chinbat.surgery.service.PaymentService;
import mn.chinbat.surgery.service.SessionPaymentService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class SessionPaymentActionB extends ActionSupport implements Preparable,
		ModelDriven<SessionPayment>, SessionAware {

	private static final long serialVersionUID = 1L;
	private SessionPaymentService spService;
	private Patient patient = new Patient();
	private SessionPayment sp = new SessionPayment();
	private DoctorSessionService doctorSessionService;
	private PaymentService paymentService;
	private PaymentNumberService numberService;
	private DoctorService doctorService;
	private int spHash;
	private DoctorSession doctorSession = new DoctorSession();
	private Payment payment = new Payment();
	private List<SessionPayment> listSp;
	private List<DoctorSession> doctorSessionList;
	private List<Payment> paymentList;
	private int firstValue;
	private int lastValue;
	private int allValue;
	private Map<String, Object> map;
	private String value;
	private String user;
	private String description;
	private String doctorID;
	private List<Doctor> doctorList;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public SessionPayment getModel() {
		return sp;
	}

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public void setNumberService(final PaymentNumberService numberService) {
		this.numberService = numberService;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void prepare() throws Exception {
		if (sp != null && sp.getId() != null) {
			this.sp = spService.get(sp.getId());
		}
	}

	// @Action(value = "spPayment", results = { @Result(name = "success",
	// location = "session1", type = "redirectAction", params = {
	// "model.id", "${id,patient.id}" }) })
	@Action(value = "spPayment", results = { @Result(name = "success", location = "../print-session-payment.jsp") })
	public String save1() {
		payment = paymentService.getLastAdd();
		patient = payment.getPatient();
		sp = spService.getSpExistPatient(payment.getPatient().getId());
		if (sp == null) {
			setFirstValue(0);
			List<Payment> list = new LinkedList<Payment>();
			List<DoctorSession> lists = new LinkedList<DoctorSession>();
			list.add(payment);
			sp = new SessionPayment(payment.getPatient());
			sp.setListOfPayment(list);
			sp.setListOfSession(lists);
		} else {
			setFirstValue(sp.getDeference());
			List<Payment> list = sp.getListOfPayment();
			list.add(payment);
			sp.setListOfPayment(list);
		}
		setDoctorSessionList(sp.getListOfSession());
		setPaymentList(sp.getListOfPayment());
		sp.setDeference(calculate());
		if (sp.getDeference() >= 0) {
			sp.setListOfSession(spService.setAllPaid(sp.getListOfSession()));
		}
		setAllValue(calcAllValue());
		setLastValue(sp.getDeference());
		sp.setLastActionDate(payment.getDate());
		spService.saveOrUpdate(sp);
		map.put("spSession", sp);
		map.put("paymentSession", payment);
		map.put("firstVal", firstValue);
		map.put("lastVal", lastValue);
		map.put("allVal", allValue);
		return SUCCESS;
	}

	@Action(value = "printsessionpayment", results = { @Result(name = "success", location = "../print-session-payment-patientshow.jsp") })
	public String printSessionPayemnt() {
		sp = spService.get(sp.getId());
		setDoctorSessionList(sp.getListOfSession());
		setPaymentList(sp.getListOfPayment());
		setAllValue(calcAllValue());
		setLastValue(sp.getDeference());
		map.put("spSession", sp);
		map.put("paymentSession", payment);
		map.put("firstVal", allValue);
		map.put("lastVal", lastValue);
		map.put("allVal", allValue);
		return SUCCESS;
	}

	@Action(value = "spPaymentEdit", results = { @Result(name = "success", location = "session2", type = "redirectAction", params = {
			"model.id", "${id,patient.id}" }) })
	// @Action(value ="spPayment",results =
	// {@Result(name="success",location="print-session-payment.jsp")})
	public String edit() {
		payment = paymentService.getLastUpdate();
		sp = spService.getSpExistPatient(payment.getPatient().getId());
		List<Payment> list = sp.getListOfPayment();
		for (int i = 0; i != list.size(); i++) {
			if (list.get(i).getId() == payment.getId()) {
				list.remove(i);
				break;
			}
		}
		patient = payment.getPatient();
		list.add(payment);
		sp.setListOfPayment(list);
		sp.setDeference(calculate());
		spService.saveOrUpdate(sp);
		return SUCCESS;
	}

	@Action(value = "print", results = { @Result(name = "success", location = "session1", type = "redirectAction", params = {
			"model.id", "${id,patient.id}" }) })
	public String print() {
		return SUCCESS;
	}

	@Action(value = "money_back", results = { @Result(name = "success", location = "/money-back.tiles", type = "tiles") })
	public String money_back() {
		this.sp = spService.get(sp.getId());
		doctorList = new LinkedList<Doctor>();
		for (DoctorSession ds : sp.getListOfSession()) {
			if (!doctorList.contains(ds.getDoctor())) {
				doctorList.add(ds.getDoctor());
			}
		}
		return SUCCESS;
	}

	@Action(value = "doMoney_back", results = {
			@Result(name = "success", location = "../print-session-payment-moneyback-history.jsp"),
			@Result(name = "input", type = "tiles", location = "/money-back.tiles") })
	public String doMoney_back() {
		if (doctorID != null && doctorID.equals("")) {
			addFieldError("doctorID",
					Messages.getString("DoctorSessionAction.CheckDoctor"));
			return INPUT;
		}
		this.sp = spService.get(sp.getId());
		map.put("patientid", sp.getPatient().getId());
		Payment p = new Payment();
		if (doctorID != null) {
			p.setDoctor(doctorService.get(Long.parseLong(doctorID)));
		}
		p.setDate(new Date());
		p.setValue((Integer.parseInt(value)) * (-1));
		p.setPatient(sp.getPatient());
		p.setPaymentMethod(PaymentMethod.MONEY_BACK);
		p.setSavedDate(new Date());
		p.setUser(user);
		p.setPaymentNumber(numberService
				.getNextPaymentNumber(PaymentMethod.MONEY_BACK));
		p.setDescription(description);
		payment = paymentService.saveOrUpdate(p);
		List<Payment> list = sp.getListOfPayment();
		list.add(p);
		sp.setListOfPayment(list);
		spService.saveOrUpdate(sp);
		setAllValue(calcAllValue());
		setLastValue(sp.getDeference());
		sp.setLastActionDate(payment.getDate());
		setDoctorSessionList(sp.getListOfSession());
		setPaymentList(sp.getListOfPayment());
		spService.saveOrUpdate(sp);
		map.put("spSession", sp);
		map.put("paymentSession", payment);
		map.put("firstVal", firstValue);
		map.put("lastVal", lastValue);
		map.put("allVal", allValue);
		return SUCCESS;
	}

	private int calculate() {
		int sessionPrice = 0;
		int paymentPrice = 0;
		for (DoctorSession ds : sp.getListOfSession()) {
			sessionPrice += ds.getSum();
		}
		for (Payment p : sp.getListOfPayment()) {
			paymentPrice += p.getValue();
		}
		return paymentPrice - sessionPrice;
	}

	public SessionPaymentService getSpService() {
		return spService;
	}

	public void setSpService(final SessionPaymentService spService) {
		this.spService = spService;
	}

	public SessionPayment getSessionPayment() {
		return sp;
	}

	public void setSessionPayment(SessionPayment sessionPayment) {
		this.sp = sessionPayment;
	}

	public DoctorSessionService getDoctorSessionService() {
		return doctorSessionService;
	}

	public void setDoctorSessionService(
			DoctorSessionService doctorSessionService) {
		this.doctorSessionService = doctorSessionService;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public int getSpHash() {
		return spHash;
	}

	public void setSpHash(int spHash) {
		this.spHash = spHash;
	}

	public DoctorSession getDoctorSession() {
		return doctorSession;
	}

	public void setDoctorSession(DoctorSession doctorSession) {
		this.doctorSession = doctorSession;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<SessionPayment> getListSp() {
		return listSp;
	}

	public void setListSp(List<SessionPayment> listSp) {
		this.listSp = listSp;
	}

	public List<DoctorSession> getDoctorSessionList() {
		return doctorSessionList;
	}

	private void setDoctorSessionList(List<DoctorSession> doctorSessionList) {
		this.doctorSessionList = doctorSessionList;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	private void setPaymentList(List<Payment> paymentList) {
		List<Payment> list = paymentList;
		this.paymentList = list;
	}

	public List<PrinterMiddleModel> getServiceList() {
		List<PrinterMiddleModel> list1 = new LinkedList<PrinterMiddleModel>();
		for (DoctorSession ds : doctorSessionList) {
			for (ServicePrice sp : ds.getListOfService()) {
				PrinterMiddleModel pmm = new PrinterMiddleModel();
				pmm.setDoctor(ds.getDoctor());
				pmm.setServicePrice(sp);
				pmm.setDate(ds.getDate());
				list1.add(pmm);
			}
		}
		return list1;
	}

	public List<Payment> getPayments() {
		return paymentList;
	}

	public int getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(int firstValue) {
		this.firstValue = firstValue;
	}

	public int getLastValue() {
		return lastValue;
	}

	public void setLastValue(int lastValue) {
		this.lastValue = lastValue;
	}

	public int getAllValue() {
		return allValue;
	}

	public void setAllValue(int allValue) {
		this.allValue = allValue;
	}

	private int calcAllValue() {
		int allValue = 0;
		if (doctorSessionList != null) {
			for (DoctorSession ds : doctorSessionList) {
				allValue += ds.getSum();
			}
		}
		return allValue;
	}

	public void setSession(Map<String, Object> session) {
		this.map = session;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

}
