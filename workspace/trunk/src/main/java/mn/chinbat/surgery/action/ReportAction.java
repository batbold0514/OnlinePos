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

import mn.chinbat.interceptor.SessionInterceptor;
import mn.chinbat.surgery.enums.Customer;
import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.model.BestCustomerModel;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.MonthBalanceModel;
import mn.chinbat.surgery.model.MonthMap;
import mn.chinbat.surgery.model.Payment;
import mn.chinbat.surgery.model.SessionPayment;
import mn.chinbat.surgery.service.DoctorService;
import mn.chinbat.surgery.service.DoctorSessionService;
import mn.chinbat.surgery.service.PaymentService;
import mn.chinbat.surgery.service.ServicePriceService;
import mn.chinbat.surgery.service.SessionPaymentService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class ReportAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private PaymentService paymentService;
	private DoctorSessionService doctorSessionService;
	private SessionPaymentService spService;
	private ServicePriceService servicePriceService;
	private DoctorService doctorService;
	private List<Payment> listPayment;
	private List<DoctorSession> listSession;
	private List<SessionPayment> listSp;
	private Payment payment = new Payment();
	private Date date = changeDayByOne(new Date());
	private Date secondDate = new Date();
	private String userOfBalance;
	private PaymentMethod paymentMethod;
	private int month = new GregorianCalendar().get(Calendar.MONTH) + 1;
	private int year = new GregorianCalendar().get(Calendar.YEAR);
	private int size;
	private Map<String, Object> m;
	private HttpServletRequest request;
	private List<MonthBalanceModel> listMonthBalance;
	private List<MonthBalanceModel> listMonthBalancePaidFalse;
	private List<MonthBalanceModel> listRecoupment;
	private int sum;
	private String doctorID = "-1";
	private int limit = 10;
	private List<BestCustomerModel> listBestCustomers;
	private List<String> listServicePrice;
	private List<MonthMap> listMonthMap;
	private List<MonthBalanceModel> listMonthBalanceModel;

	public void setPaymentService(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void setDoctorService(final DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public void setDoctorSessionService(
			final DoctorSessionService doctorSessionService) {
		this.doctorSessionService = doctorSessionService;
	}

	public void setSpService(final SessionPaymentService spService) {
		this.spService = spService;
	}

	public void setServicePriceService(
			final ServicePriceService servicePriceService) {
		this.servicePriceService = servicePriceService;
	}

	@Action(value = "dayBalance", results = {
			@Result(name = "success", type = "tiles", location = "/reportDayBalance.tiles"),
			@Result(name = "none", type = "tiles", location = "/reportDayBalanceDegfim.tiles"),
			@Result(name = "input", type = "redirectAction", location = "dayBalance") })
	public String dayBalance() {

		if (SessionInterceptor.isValid()) {
			if (paymentMethod == null)
				paymentMethod = PaymentMethod.ALL;
			m.put("paymentMethod", paymentMethod);
			setList(paymentService.getPaymentForDayBalance(date, secondDate,
					userOfBalance, paymentMethod,
					doctorService.get(Long.parseLong(doctorID))));
			if (Messages.getCustomer("customer").trim()
					.equals(Customer.degfim.toString().trim())) {
				return NONE;
			} else {
				return SUCCESS;
			}
		} else
			return ERROR;
	}

	@Action(value = "monthBalance", results = { @Result(name = "success", type = "tiles", location = "/reportMonthBalance.tiles") })
	public String monthBalance() {
		if (SessionInterceptor.isValid()) {
			m.put("date", date);
			m.put("secondDate", secondDate);
			if (getServletRequest().isUserInRole("user-role")
					&& !doctorSessionService.isDoctor(getServletRequest()
							.getRemoteUser())) {
				setListMonthBalance(new LinkedList<MonthBalanceModel>());
				setListMonthBalancePaidFalse(new LinkedList<MonthBalanceModel>());
				return SUCCESS;
			}
			if (getServletRequest().isUserInRole("user-role")) {
				List<MonthBalanceModel> list = doctorSessionService
						.getMonthBalance(date, secondDate, doctorSessionService
								.getDoctorWithUser(getServletRequest()
										.getRemoteUser()));
				setListMonthBalance(list);
				List<MonthBalanceModel> list1 = doctorSessionService
						.getMonthBalancePaidFalse(date, secondDate,
								doctorSessionService
										.getDoctorWithUser(getServletRequest()
												.getRemoteUser()));
				setListMonthBalancePaidFalse(list1);
				this.sum = 0;
				for (MonthBalanceModel mbm : list)
					this.sum += mbm.getTotalPrice();
				for (MonthBalanceModel mbm : list1)
					this.sum += mbm.getTotalPrice();
				return SUCCESS;
			} else {
				if (doctorID.equals("-1")) {
					List<MonthBalanceModel> list = doctorSessionService
							.getMonthBalance(date, secondDate, null);
					setListMonthBalance(list);
					List<MonthBalanceModel> list1 = doctorSessionService
							.getMonthBalancePaidFalse(date, secondDate, null);
					setListMonthBalancePaidFalse(list1);
					this.sum = 0;
					for (MonthBalanceModel mbm : list)
						this.sum += mbm.getTotalPrice();
					for (MonthBalanceModel mbm : list1)
						this.sum += mbm.getTotalPrice();
				} else {
					List<MonthBalanceModel> list = doctorSessionService
							.getMonthBalance(date, secondDate,
									doctorService.get(Long.parseLong(doctorID)));
					setListMonthBalance(list);
					List<MonthBalanceModel> list1 = doctorSessionService
							.getMonthBalancePaidFalse(date, secondDate,
									doctorService.get(Long.parseLong(doctorID)));
					setListMonthBalancePaidFalse(list1);
					this.sum = 0;
					for (MonthBalanceModel mbm : list)
						this.sum += mbm.getTotalPrice();
					for (MonthBalanceModel mbm : list1)
						this.sum += mbm.getTotalPrice();
				}
				return SUCCESS;
			}
		} else
			return ERROR;
	}

	@Action(value = "monthBalance1", results = { @Result(name = "success", type = "tiles", location = "/reportMonthBalance1.tiles") })
	public String monthBalance1() {
		if (SessionInterceptor.isValid()) {
			m.put("date", date);
			m.put("secondDate", secondDate);
			if (getServletRequest().isUserInRole("user-role")
					&& !doctorSessionService.isDoctor(getServletRequest()
							.getRemoteUser())) {
				setListMonthBalance(new LinkedList<MonthBalanceModel>());
				setListMonthBalancePaidFalse(new LinkedList<MonthBalanceModel>());
				return SUCCESS;
			}
			if (getServletRequest().isUserInRole("user-role")) {
				List<MonthBalanceModel> list = doctorSessionService
						.getMonthBalance(date, secondDate, doctorSessionService
								.getDoctorWithUser(getServletRequest()
										.getRemoteUser()));
				setListMonthBalance(list);
				List<MonthBalanceModel> list1 = doctorSessionService
						.getMonthBalancePaidFalse(date, secondDate,
								doctorSessionService
										.getDoctorWithUser(getServletRequest()
												.getRemoteUser()));
				setListMonthBalancePaidFalse(list1);
				this.sum = 0;
				for (MonthBalanceModel mbm : list)
					this.sum += mbm.getTotalPrice();
				for (MonthBalanceModel mbm : list1)
					this.sum += mbm.getTotalPrice();
				return SUCCESS;
			} else {
				if (doctorID.equals("-1")) {
					List<MonthBalanceModel> list = doctorSessionService
							.getMonthBalance(date, secondDate, null);
					setListMonthBalance(list);
					List<MonthBalanceModel> list1 = doctorSessionService
							.getMonthBalancePaidFalse(date, secondDate, null);
					setListMonthBalancePaidFalse(list1);
					this.sum = 0;
					for (MonthBalanceModel mbm : list)
						this.sum += mbm.getTotalPrice();
					for (MonthBalanceModel mbm : list1)
						this.sum += mbm.getTotalPrice();
				} else {
					List<MonthBalanceModel> list = doctorSessionService
							.getMonthBalance(date, secondDate,
									doctorService.get(Long.parseLong(doctorID)));
					setListMonthBalance(list);
					List<MonthBalanceModel> list1 = doctorSessionService
							.getMonthBalancePaidFalse(date, secondDate,
									doctorService.get(Long.parseLong(doctorID)));
					setListMonthBalancePaidFalse(list1);
					this.sum = 0;
					for (MonthBalanceModel mbm : list)
						this.sum += mbm.getTotalPrice();
					for (MonthBalanceModel mbm : list1)
						this.sum += mbm.getTotalPrice();
				}
				return SUCCESS;
			}
		} else
			return ERROR;
	}

	@Action(value = "debtCustomers", results = { @Result(name = "success", type = "tiles", location = "/reportDebtCustomers.tiles") })
	public String debtCustomers() {
		if (SessionInterceptor.isValid()) {
			setListSp(spService.getDebtSessionPayment(date, secondDate));
			return SUCCESS;
		} else
			return ERROR;
	}

	@Action(value = "donationCustomers", results = { @Result(name = "success", type = "tiles", location = "/reportDonationCustomers.tiles") })
	public String donationCustomers() {
		if (SessionInterceptor.isValid()) {
			setListSp(spService.getDonationSessionPayment(date, secondDate));
			return SUCCESS;
		} else
			return ERROR;
	}

	@Action(value = "showDoctorOfMonthBalance", results = { @Result(name = "success", type = "tiles", location = "/reportMonthBalanceDoctor.tiles") })
	public String shotDoctorOfMonthBalance() throws Exception {
		m.remove("list1111");
		m.remove("list2222");
		m.remove("list3333");
		doctorID = request.getParameter("model");
		date = (Date) m.get("date");
		secondDate = (Date) m.get("secondDate");
		List<MonthBalanceModel> list = doctorSessionService
				.getMonthBalanceWithPatient(date, secondDate,
						doctorService.get(Long.parseLong(doctorID)));
		setListMonthBalance(list);
		List<MonthBalanceModel> list1 = doctorSessionService
				.getMonthBalancePaidFalseWithPatient(date, secondDate,
						doctorService.get(Long.parseLong(doctorID)));
		setListMonthBalancePaidFalse(list1);
		if (!list.isEmpty()) {
			listMonthMap = list.get(0).getPriceMapList();
		} else {
			if (!list1.isEmpty()) {
				listMonthMap = list1.get(0).getPriceMapList();
			} else {
				listMonthMap = new LinkedList<MonthMap>();
			}
		}
		listServicePrice = new LinkedList<String>();
		for (MonthMap mm : listMonthMap) {
			listServicePrice.add(mm.getSp().getCode());
		}
		this.sum = 0;
		for (MonthBalanceModel mbm : list)
			this.sum += mbm.getTotalPrice();
		for (MonthBalanceModel mbm : list1)
			this.sum += mbm.getTotalPrice();
		m.put("list1111", list);
		m.put("list2222", list1);
		m.put("list3333", listMonthMap);
		return SUCCESS;
	}

	@Action(value = "showDoctorOfMonthBalance1", results = { @Result(name = "success", type = "tiles", location = "/reportMonthBalanceDoctor1.tiles") })
	public String shotDoctorOfMonthBalance1() throws Exception {
		m.remove("list1111");
		m.remove("list2222");
		m.remove("list3333");
		doctorID = request.getParameter("model");
		date = (Date) m.get("date");
		secondDate = (Date) m.get("secondDate");
		m.put("doctorID", doctorID);
		List<MonthBalanceModel> list = doctorSessionService
				.getMonthBalanceWithPatient(date, secondDate,
						doctorService.get(Long.parseLong(doctorID)));
		setListMonthBalance(list);
		List<MonthBalanceModel> list1 = doctorSessionService
				.getMonthBalancePaidFalseWithPatient(date, secondDate,
						doctorService.get(Long.parseLong(doctorID)));
		setListMonthBalancePaidFalse(list1);
		if (!list.isEmpty()) {
			listMonthMap = list.get(0).getPriceMapList();
		} else {
			if (!list1.isEmpty()) {
				listMonthMap = list1.get(0).getPriceMapList();
			} else {
				listMonthMap = new LinkedList<MonthMap>();
			}
		}
		listServicePrice = new LinkedList<String>();
		for (MonthMap mm : listMonthMap) {
			listServicePrice.add(mm.getSp().getCode());
		}
		this.sum = 0;
		for (MonthBalanceModel mbm : list)
			this.sum += mbm.getTotalPrice();
		for (MonthBalanceModel mbm : list1)
			this.sum += mbm.getTotalPrice();
		setListRecoupment(doctorSessionService.getListOfRecoupment(date,
				secondDate, doctorService.get(Long.parseLong(doctorID))));
		m.put("list1111", list);
		m.put("list2222", list1);
		m.put("list3333", listMonthMap);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "servicePriceSearch", results = { @Result(name = "success", type = "tiles", location = "/reportMonthBalanceDoctor.tiles") })
	public String servicePrice() throws Exception {
		doctorID = request.getParameter("model");
		date = (Date) m.get("date");
		secondDate = (Date) m.get("secondDate");
		List<MonthBalanceModel> list = new LinkedList<MonthBalanceModel>();
		List<MonthBalanceModel> list1 = new LinkedList<MonthBalanceModel>();
		List<MonthBalanceModel> listt = (List<MonthBalanceModel>) m.get("list1111");
		List<MonthBalanceModel> listt1 =  (List<MonthBalanceModel>) m.get("list2222");
		for(MonthBalanceModel mbm:listt){
			MonthBalanceModel mmm = new MonthBalanceModel();
			mmm.setDirectValue(mbm.getDirectValue());
			mmm.setDoctor(mbm.getDoctor());
			mmm.setDuration(mbm.getDuration());
			mmm.setNumber(mbm.getNumber());
			mmm.setOrderNumber(mbm.getOrderNumber());
			mmm.setPaidValue(mbm.getPaidValue());
			mmm.setPatient(mbm.getPatient());
			mmm.setPriceMapList(mbm.getPriceMapList());
			mmm.setRecoupment(mbm.getRecoupment());
			mmm.setTotalPrice(mbm.getTotalPrice());
			list.add(mmm);
		}
		for(MonthBalanceModel mbm:listt1){
			MonthBalanceModel mmm = new MonthBalanceModel();
			mmm.setDirectValue(mbm.getDirectValue());
			mmm.setDoctor(mbm.getDoctor());
			mmm.setDuration(mbm.getDuration());
			mmm.setNumber(mbm.getNumber());
			mmm.setOrderNumber(mbm.getOrderNumber());
			mmm.setPaidValue(mbm.getPaidValue());
			mmm.setPatient(mbm.getPatient());
			mmm.setPriceMapList(mbm.getPriceMapList());
			mmm.setRecoupment(mbm.getRecoupment());
			mmm.setTotalPrice(mbm.getTotalPrice());
			list1.add(mmm);
		}
		this.listMonthMap = (List<MonthMap>) m.get("list3333");
		for (MonthBalanceModel mbm : list) {
			int totalPrice = 0;
			List<MonthMap> listmm = new LinkedList<MonthMap>();
			for (String sp : listServicePrice) {
				for (MonthMap mm : mbm.getPriceMapList()) {
					if (mm.getSp().getCode().equals(sp)) {
						listmm.add(mm);
						totalPrice += mm.getSp().getPrice() * mm.getCount();
						break;
					}
				}
			}
			mbm.setPriceMapList(listmm);
			mbm.setTotalPrice(totalPrice);
		}
		for (MonthBalanceModel mbm : list1) {
			int totalPrice = 0;
			List<MonthMap> listmm = new LinkedList<MonthMap>();
			for (String sp : listServicePrice) {
				for (MonthMap mm : mbm.getPriceMapList()) {
					if (mm.getSp().getCode().equals(sp)) {
						listmm.add(mm);
						totalPrice += mm.getSp().getPrice() * mm.getCount();
						break;
					}
				}
			}
			mbm.setPriceMapList(listmm);
			mbm.setTotalPrice(totalPrice);
		}

		setListMonthBalance(list);
		setListMonthBalancePaidFalse(list1);
		this.sum = 0;
		for (MonthBalanceModel mbm : list)
			this.sum += mbm.getTotalPrice();
		for (MonthBalanceModel mbm : list1)
			this.sum += mbm.getTotalPrice();

		// m.put("list3333", listMonthMap);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "servicePriceSearch1", results = { @Result(name = "success", type = "tiles", location = "/reportMonthBalanceDoctor1.tiles") })
	public String servicePrice1() throws Exception {
		doctorID = (String) m.get("doctorID");
		date = (Date) m.get("date");
		secondDate = (Date) m.get("secondDate");
		List<MonthBalanceModel> list = new LinkedList<MonthBalanceModel>();
		List<MonthBalanceModel> list1 = new LinkedList<MonthBalanceModel>();
		List<MonthBalanceModel> listt = (List<MonthBalanceModel>) m.get("list1111");
		List<MonthBalanceModel> listt1 =  (List<MonthBalanceModel>) m.get("list2222");
		for(MonthBalanceModel mbm:listt){
			MonthBalanceModel mmm = new MonthBalanceModel();
			mmm.setDirectValue(mbm.getDirectValue());
			mmm.setDoctor(mbm.getDoctor());
			mmm.setDuration(mbm.getDuration());
			mmm.setNumber(mbm.getNumber());
			mmm.setOrderNumber(mbm.getOrderNumber());
			mmm.setPaidValue(mbm.getPaidValue());
			mmm.setPatient(mbm.getPatient());
			mmm.setPriceMapList(mbm.getPriceMapList());
			mmm.setRecoupment(mbm.getRecoupment());
			mmm.setTotalPrice(mbm.getTotalPrice());
			list.add(mmm);
		}
		for(MonthBalanceModel mbm:listt1){
			MonthBalanceModel mmm = new MonthBalanceModel();
			mmm.setDirectValue(mbm.getDirectValue());
			mmm.setDoctor(mbm.getDoctor());
			mmm.setDuration(mbm.getDuration());
			mmm.setNumber(mbm.getNumber());
			mmm.setOrderNumber(mbm.getOrderNumber());
			mmm.setPaidValue(mbm.getPaidValue());
			mmm.setPatient(mbm.getPatient());
			mmm.setPriceMapList(mbm.getPriceMapList());
			mmm.setRecoupment(mbm.getRecoupment());
			mmm.setTotalPrice(mbm.getTotalPrice());
			list1.add(mmm);
		}
		this.listMonthMap = (List<MonthMap>) m.get("list3333");
		for (MonthBalanceModel mbm : list) {
			int totalPrice = 0;
			List<MonthMap> listmm = new LinkedList<MonthMap>();
			for (String sp : listServicePrice) {
				for (MonthMap mm : mbm.getPriceMapList()) {
					if (mm.getSp().getCode().equals(sp)) {
						listmm.add(mm);
						totalPrice += mm.getSp().getPrice() * mm.getCount();
						break;
					}
				}
			}
			mbm.setPriceMapList(listmm);
			mbm.setTotalPrice(totalPrice);
		}
		for (MonthBalanceModel mbm : list1) {
			int totalPrice = 0;
			List<MonthMap> listmm = new LinkedList<MonthMap>();
			for (String sp : listServicePrice) {
				for (MonthMap mm : mbm.getPriceMapList()) {
					if (mm.getSp().getCode().equals(sp)) {
						listmm.add(mm);
						totalPrice += mm.getSp().getPrice() * mm.getCount();
						break;
					}
				}
			}
			mbm.setPriceMapList(listmm);
			mbm.setTotalPrice(totalPrice);
		}

		setListMonthBalance(list);
		setListMonthBalancePaidFalse(list1);
		this.sum = 0;
		for (MonthBalanceModel mbm : list)
			this.sum += mbm.getTotalPrice();
		for (MonthBalanceModel mbm : list1)
			this.sum += mbm.getTotalPrice();
		setListRecoupment(doctorSessionService.getListOfRecoupment(date,
				secondDate, doctorService.get(Long.parseLong(doctorID))));
		// m.put("list3333", listMonthMap);
		return SUCCESS;
	}

	@Action(value = "bestCustomers", results = { @Result(name = "success", type = "tiles", location = "/best-customers.tiles") })
	public String bestCustomers() {
		setListBestCustomers(paymentService.getBestCustomers(date, secondDate,
				limit));
		return SUCCESS;
	}

	public void setDateStr(String date) {
		this.date = stringToDate(date);
	}

	public String getDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}

	public List<Payment> getList() {
		return listPayment;
	}

	public void setList(List<Payment> list) {
		this.listPayment = list;
	}

	public List<DoctorSession> getListSession() {
		return listSession;
	}

	public void setListSession(List<DoctorSession> listSession) {
		this.listSession = listSession;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int[] getMonths() {
		int[] mas = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		return mas;
	}

	public PaymentMethod[] getMethodList() {
		return PaymentMethod.values();
	}

	public String[] getUsersList() {
		return paymentService.getUsers();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<SessionPayment> getListSp() {
		return listSp;
	}

	public void setListSp(List<SessionPayment> listSp) {
		this.listSp = listSp;
	}

	public Date getSecondDate() {
		return secondDate;
	}

	public String getSecondDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(secondDate);
	}

	public void setSecondDateStr(String secondDate) {
		this.secondDate = stringToDate(secondDate);
	}

	public void setSecondDate(Date secondDate) {
		this.secondDate = secondDate;
	}

	public List<MonthBalanceModel> getListMonthBalance() {
		return listMonthBalance;
	}

	public void setListMonthBalance(List<MonthBalanceModel> listMonthBalance) {
		this.listMonthBalance = listMonthBalance;
	}

	public int getSize() {
		size = servicePriceService.findAll().size();
		return size;
	}

	public void setSize(int size) {

	}

	public void setPaymentMethod(String id) {
		paymentMethod = PaymentMethod.values()[Integer.parseInt(id)];
	}

	public String getUserOfBalance() {
		return userOfBalance;
	}

	public void setUserOfBalance(String userOfBalance) {
		this.userOfBalance = userOfBalance;
	}

	public void setSession(Map<String, Object> m) {
		this.m = m;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	private Date changeDayByOne(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public List<MonthBalanceModel> getListMonthBalancePaidFalse() {
		return listMonthBalancePaidFalse;
	}

	public void setListMonthBalancePaidFalse(
			List<MonthBalanceModel> listMonthBalancePaidFalse) {
		this.listMonthBalancePaidFalse = listMonthBalancePaidFalse;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public List<Doctor> getDoctors() {
		return doctorService.findAll();
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public List<MonthBalanceModel> getListRecoupment() {
		return listRecoupment;
	}

	public void setListRecoupment(List<MonthBalanceModel> listRecoupment) {
		this.listRecoupment = listRecoupment;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<BestCustomerModel> getListBestCustomers() {
		return listBestCustomers;
	}

	public void setListBestCustomers(List<BestCustomerModel> listBestCustomers) {
		this.listBestCustomers = listBestCustomers;
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

	public List<String> getListServicePrice() {
		return listServicePrice;
	}

	public void setListServicePrice(List<String> listServicePrice) {
		this.listServicePrice = listServicePrice;
	}

	public List<MonthMap> getListMonthMap() {
		return listMonthMap;
	}

	public void setListMonthMap(List<MonthMap> listMonthMap) {
		this.listMonthMap = listMonthMap;
	}

	public List<MonthBalanceModel> getListMonthBalanceModel() {
		return listMonthBalanceModel;
	}

	public void setListMonthBalanceModel(
			List<MonthBalanceModel> listMonthBalanceModel) {
		this.listMonthBalanceModel = listMonthBalanceModel;
	}

}
