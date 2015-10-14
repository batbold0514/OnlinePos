package mn.chinbat.surgery.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.Payment;
import mn.chinbat.surgery.model.PrinterMiddleModel;
import mn.chinbat.surgery.model.ServicePrice;
import mn.chinbat.surgery.model.SessionPayment;
import mn.chinbat.surgery.service.DoctorSessionService;
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
public class SessionPaymentAction extends ActionSupport implements Preparable,
		ModelDriven<SessionPayment>,SessionAware {

	private static final long serialVersionUID = 1L;
	private SessionPaymentService spService;
	private Patient patient = new Patient();
	private SessionPayment sp = new SessionPayment();
	private DoctorSessionService doctorSessionService;
	private PaymentService paymentService;
	private int spHash;
	private DoctorSession doctorSession = new DoctorSession();
	private Payment payment = new Payment();
	private List<SessionPayment> listSp;
	private List<DoctorSession> doctorSessionList;
	private List<Payment> paymentList;
	private int firstValue;
	private int lastValue;
	private int allValue;
	private Map<String,Object> map;
	
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public SessionPayment getModel() {
		return sp;
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

	@Action(value = "spList", results = { @Result(name = "success", type = "tiles", location = "/sessionPayment.tiles") })
	public String list() {
		this.listSp = spService.findAll();
		return SUCCESS;
	}

	@Action(value = "spSession", results = { @Result(name = "success", location = "session", type = "redirectAction", params = {
			"model.id", "${id}" }) })
	public String save() {
		doctorSession = doctorSessionService.getLastAdd();
		sp = spService.getSpExistPatient(doctorSession.getPatient()
				.getId());
		if (sp == null) {
			List<DoctorSession> list = new LinkedList<DoctorSession>();
			List<Payment> listp = new LinkedList<Payment>();
			list.add(doctorSession);
			sp = new SessionPayment(doctorSession.getPatient());
			sp.setListOfSession(list);
			sp.setListOfPayment(listp);
			patient = doctorSession.getPatient();
		} else {
			patient = doctorSession.getPatient();
			List<DoctorSession> list = sp.getListOfSession();
			list.add(doctorSession);
			sp.setListOfSession(list);
		}
		doctorSession.setSum(doctorSessionService
				.calculateDrSessionSum(doctorSession.getListOfService()));
		sp.setDeference(calculate());
		if (sp.getDeference() >= 0) {
			sp.setListOfSession(spService.setAllPaid(sp.getListOfSession()));
		}
		sp.setLastActionDate(doctorSession.getDate());
		spService.saveOrUpdate(sp);
		return SUCCESS;
	}
	
	@Action(value = "spSession1", results = { @Result(name = "success", location = "session", type = "redirectAction", params = {
			"model.id", "${id}" }) })
	public String editSession() throws Exception{
		Long dsID = (Long) map.get("DocrtorSessionID");
		doctorSession = doctorSessionService.get(dsID);
		sp = spService.getSpExistPatient(doctorSession.getPatient()
				.getId());
		doctorSession.setSum(doctorSessionService
				.calculateDrSessionSum(doctorSession.getListOfService()));
		sp.setDeference(calculate());
		if (sp.getDeference() >= 0) {
			sp.setListOfSession(spService.setAllPaid(sp.getListOfSession()));
		}
		sp.setLastActionDate(doctorSession.getDate());
		spService.saveOrUpdate(sp);
		map.remove("DocrtorSessionID");
		return SUCCESS;
	}
	
	// @Action(value = "spPayment", results = { @Result(name = "success",
	// location = "session1", type = "redirectAction", params = {
	// "model.id", "${id,patient.id}" }) })
	/*@Action(value = "spPayment", results = { @Result(name = "success", location = "../print-session-payment.jsp") })
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
		if (sp.getDeference() <= 0) {
			sp.setListOfSession(spService.setAllPaid(sp.getListOfSession()));
		}
		setAllValue(calcAllValue());
		setLastValue(sp.getDeference());
		sp.setLastActionDate(payment.getDate());
		spService.saveOrUpdate(sp);
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
*/
	@Action(value = "print", results = { @Result(name = "success", location = "session1", type = "redirectAction", params = {
			"model.id", "${id,patient.id}" }) })
	public String print() {
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
				list1.add(pmm);
			}
		}
		return list1;
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

}
