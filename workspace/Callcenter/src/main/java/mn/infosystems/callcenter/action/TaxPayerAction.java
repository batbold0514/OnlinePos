package mn.infosystems.callcenter.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.callcenter.enums.CallStatus;
import mn.infosystems.callcenter.model.AccountNumber;
import mn.infosystems.callcenter.model.CallCommitment;
import mn.infosystems.callcenter.model.CallCommitmentShow;
import mn.infosystems.callcenter.model.CallIndex;
import mn.infosystems.callcenter.model.Calls;
import mn.infosystems.callcenter.model.Debtx;
import mn.infosystems.callcenter.model.PhoneNumber;
import mn.infosystems.callcenter.model.Plan;
import mn.infosystems.callcenter.model.TaxPayer;
import mn.infosystems.callcenter.model.Users;
import mn.infosystems.callcenter.service.CallIndexService;
import mn.infosystems.callcenter.service.CallQuantityService;
import mn.infosystems.callcenter.service.CallService;
import mn.infosystems.callcenter.service.DateIndexService;
import mn.infosystems.callcenter.service.DebtService;
import mn.infosystems.callcenter.service.DebtTypeService;
import mn.infosystems.callcenter.service.MoneyIndexService;
import mn.infosystems.callcenter.service.PhoneNumberService;
import mn.infosystems.callcenter.service.PlanService;
import mn.infosystems.callcenter.service.ReasonService;
import mn.infosystems.callcenter.service.TaxPayerService;
import mn.infosystems.callcenter.service.UsersService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/senior"),@Namespace("/operator")  })
public class TaxPayerAction extends ActionSupport implements SessionAware,ModelDriven<TaxPayer> ,Preparable,ServletRequestAware{

	private static final long serialVersionUID = 1L;
	private int limit = 50;
	private List<TaxPayer> taxpayerList;
	private TaxPayerService taxPayerService;
	private UsersService usersService;
	private List<String> opId;
	private List<Plan> planList;
	private PlanService planService;
	private Plan plan;
	private TaxPayer taxPayer = new TaxPayer();
	private Map<String, Object> session;
	private MoneyIndexService moneyIndexService;
	private DebtTypeService debtTypeService;
	private DateIndexService dateIndexService;
	private CallIndexService callIndexService;
	private int taxPayerHash;
	private HttpServletRequest request;
	private List<Debtx> listOfDebtx;
	private Date date = new Date();
	private Long autoOp = 1l;
	private int callQuantity;
	private int callIndex;
	private String startDate = dateToStr(endDate());
	private String endDate= dateToStr(new Date());
	private DebtService debtService;
	private int avgPay = 0;
	private String opModel;
	private int opIdChild;
	private String phoneNumber;
	private PhoneNumberService phoneNumberService;
	private CallQuantityService callQuantityService;
	private String userName;
	private CallService callService;
	private ReasonService reasonService;
	private List<List<AccountNumber>> accounts;
	private List<CallCommitment> callCommitments ;
	/**
	 * @see session-д байгаа planListSession-г устгаад tax-payer-list.jsp рүү шилжинэ
	 * @return Success
	 */
	@Action(value = "taxpayer-list", results = { @Result(name = "success", type = "tiles", location = "/tax-payer-list.tiles") })
	public String list_page() {
		session.remove("planListSession");
		return SUCCESS;
	}

	/**
	 * @see taxPayerService.getTaxPayer(limit,avgPay) ээр авсан татвар төлөгчдийн шагсаалтын төлөвлөгөөг үүсгэж tax-payer-list.jsp рүү очно
	 * @return Success
	 */
	@Action(value = "tax-payers", results = { @Result(name = "success", type = "tiles", location = "/tax-payer-list.tiles") })
	public String getList() {
		planList = new LinkedList<Plan>();
		opId = new LinkedList<String>();
		taxpayerList = taxPayerService.getTaxPayer(limit,avgPay);
		List<Users> userList = getOperators();
		if (autoOp == 1l && !userList.isEmpty()) {
			int length = userList.size();
			int index = 0;
			for (TaxPayer taxPeyer : taxpayerList) {
				plan = new Plan();
				plan.setCall(false);
				plan.setDate(new Date());
				plan.setTaxPayer(taxPeyer);
				opId.add(""+userList.get(index).getId());
				plan.setOperator(userList.get(index++));
				planList.add(plan);
				if(index >= length) index = 0;
				}
		} else {
			for (TaxPayer taxPayer : taxpayerList) {
				plan = new Plan();
				plan.setCall(false);
				plan.setDate(new Date());
				plan.setTaxPayer(taxPayer);
				planList.add(plan);
				opId.add("");
			}
		}
		session.put("planListSession", planList);
		session.put("opId", opId);
		return SUCCESS;
	}

	/**
	 * @see opId утгыг opModel утгаар сольно
	 * @return Success
	 */
	@SuppressWarnings("unchecked")
	@Action(value="changeOpId-ajax" , results= {@Result(name = "success", location="/WEB-INF/content/ajax/taxPayer/tax-payer-list-result.jsp")})
	public String changeOpId(){
		opId = (List<String>)  session.get("opId");
		opId.remove(opIdChild);
		opId.add(opIdChild,opModel);
		session.put("opId", opId);
		request.setAttribute("taxPayer-list-Success", true);
		return SUCCESS;
	}
	/**
	 * @see Төлөвлөгөөнд операторуудыг хуваарьлах day-plan үйлдлийг гүйцэтгэнэ
	 * @return Success
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "plan12", results = { @Result(name = "success", type = "redirectAction", location = "day-plan") })
	public String getPlan() throws Exception { 
		planList = (List<Plan>) session.get("planListSession");
		session.remove("planListSession");
		opId = (List<String>)  session.get("opId");
		session.remove("opId");
		int index = 0;
		for (Plan plan : planList) {
			if (opId.get(index).equals("")) {
				plan.setOperator(null);
			} else {
				plan.setOperator(usersService.get(Long.parseLong(opId
						.get(index))));
			}
			planService.saveOrUpdate(plan);
			index++;
		}
		return SUCCESS;
	}
	
	/**
	 * @see TaxPayer индекс нэг бүрчлэн харуулах
	 * @return Success
	 */
	@Action(value = "getTaxPayer",results={@Result(name = "success",location ="/WEB-INF/content/taxPayer.jsp")})
	public String show(){
		taxPayer = taxPayerService.get(Long.parseLong(request.getParameter("modelId")));
		listOfDebtx = taxPayerService.getDebtxList(taxPayer);
		if(listOfDebtx.size() !=0){
			callQuantity =  debtTypeService.getDebtMaxNumber(taxPayer.getId(),callQuantityService.get(0l).getCount());
			for(CallIndex call:callIndexService.findAll()){
				if(call.getCallQuantity() == callQuantity){
					callIndex = call.getCallIndex();
					break;
				}
			}
		}else{
			callIndex = 0;
			callQuantity = 0;
		}
		return SUCCESS;
	}

	/**
	 * @see Дуудлага хүлээн авах хүн хайх
	 * @return Success
	 */
	@Action(value = "search-ajax",results={@Result(name = "success",location ="/WEB-INF/content/ajax/taxPayer-search.jsp")})
	public String searchShow(){
		taxPayer = taxPayerService.getTaxPayer(request.getParameter("phoneNumber"));
		if(taxPayer != null){
			callQuantity = callQuantityService.get(0l).getCount();
			callCommitments= new LinkedList<CallCommitment>();
			accounts = new LinkedList<List<AccountNumber>>();
			boolean check =false;
			for(int i=0;i<taxPayer.getActiveDebtList().size();i++){
				check = false;
				
				for(int j=0;j<callCommitments.size();j++){
					if(callCommitments.get(j).getListOfDebt().get(0).getType().getId().equals(taxPayer.getActiveDebtList().get(i).getType().getId())){
						callCommitments.get(j).add(taxPayer.getActiveDebtList().get(i));
						check=true;
						break;
					}
				}
				
				if(!check){
					CallCommitment commit = new  CallCommitment();
					commit.add(
							taxPayer.getActiveDebtList().get(i));
					commit.setListsize(0);
					callCommitments.add(commit);
				}
			}
			for(CallCommitment cl:callCommitments){
				List<AccountNumber> list = new LinkedList<AccountNumber>();
				for(int i =0; i < cl.getListOfDebt().size();i++){
					for(AccountNumber anSub:cl.getListOfDebt().get(i).getListOfAccountNumber()){	
						check = false;
						for(AccountNumber an:list){
							if(an.getId().equals(anSub.getId())){
								check=true;
								break;
							}
						}
						if(!check){
							list.add(anSub);
						}
					}
				}
				accounts.add(list);
			}
			session.put("accounts", accounts);
			session.put("callCommitments", callCommitments);
			session.put("taxPayer",taxPayer);
			request.setAttribute("searchAjax", true);
		}
		return SUCCESS;
	}
	/**
	 * @see Дуудлага хүлээн авах хүн хайх
	 * @return Success
	 */
	@Action(value = "search-ajax-auto",results={@Result(name = "success",location ="/WEB-INF/content/ajax/taxPayer-search.jsp")})
	public String searchautoShow(){
		Users user = usersService.getUser(request.getRemoteUser());
		if(!user.getPhone().equals("") ){
			taxPayer = taxPayerService.getTaxPayer(user.getPhone());
			if(taxPayer != null){
				callQuantity = callQuantityService.get(0l).getCount();
				callCommitments= new LinkedList<CallCommitment>();
				accounts = new LinkedList<List<AccountNumber>>();
				boolean check =false;
				for(int i=0;i<taxPayer.getActiveDebtList().size();i++){
					check = false;
					
					for(int j=0;j<callCommitments.size();j++){
						if(callCommitments.get(j).getListOfDebt().get(0).getType().getId().equals(taxPayer.getActiveDebtList().get(i).getType().getId())){
							callCommitments.get(j).add(taxPayer.getActiveDebtList().get(i));
							check=true;
							break;
						}
					}
					
					if(!check){
						CallCommitment commit = new  CallCommitment();
						commit.add(
								taxPayer.getActiveDebtList().get(i));
						commit.setListsize(0);
						callCommitments.add(commit);
					}
				}
				for(CallCommitment cl:callCommitments){
					List<AccountNumber> list = new LinkedList<AccountNumber>();
					for(int i =0; i < cl.getListOfDebt().size();i++){
						for(AccountNumber anSub:cl.getListOfDebt().get(i).getListOfAccountNumber()){	
							check = false;
							for(AccountNumber an:list){
								if(an.getId().equals(anSub.getId())){
									check=true;
									break;
								}
							}
							if(!check){
								list.add(anSub);
							}
						}
					}
					accounts.add(list);
				}
				session.put("accounts", accounts);
				session.put("callCommitments", callCommitments);
				session.put("taxPayer",taxPayer);
				session.put("taxPayer",taxPayer);
				request.setAttribute("searchAjax", true);
			}
			return SUCCESS;
		}
		return SUCCESS;
	}
	/**
	 * @see Согогдсон татвар төлөгчид утасны дугаар нэмж оруулаад show-plan үйлдлийг гүйцэтгэнэ
	 * @return Success
	 */
	@Action(value="addPhoneNumber",results={@Result(name="success",type="redirectAction",location="show-plan" ,params = {"model.id","${id}"})})
	public String addPhoneNumber(){
		Plan plan = (Plan) session.get("plan");
		PhoneNumber phNumber = new PhoneNumber();
		phNumber.setNumber(phoneNumber);
		phNumber.setTaxPayer(taxPayer);
		phNumber = phoneNumberService.saveOrUpdate(phNumber);
		taxPayer = plan.getTaxPayer();
		List<PhoneNumber> listPhones = taxPayer.getPhones();
		listPhones.add(phNumber);
		Calls call  = new Calls(reasonService.get(1l),usersService.getUser(userName));
		call.setTaxPayer(plan.getTaxPayer());
		callService.saveOrUpdate(call);
		taxPayer.getCalls().add(call);
		taxPayer.setPhones(listPhones);
		taxPayerService.saveOrUpdate(taxPayer);
		return SUCCESS;
	}
	
	/**
	 * @see Татвар төлөгчийн үндсэн дуугаарыг солино
	 * @return Success
	 * 
	 */
	@Action(value="changeMainNumber",results={@Result(name="success",location="/WEB-INF/content/ajax/user-list-result.jsp")})
	public String changeMainNumber(){
		Plan plan = (Plan) session.get("plan");
		taxPayer = plan.getTaxPayer();
		taxPayer.setPhoneNumber(phoneNumber);
		taxPayerService.saveOrUpdate(taxPayer);
		plan.setTaxPayer(taxPayer);
		planService.saveOrUpdate(plan);
		session.put("plan", plan);
		return SUCCESS;
	}
	
/*	@Action(value="call-x-lite",results={@Result(name="success",location="/WEB-INF/content/ajax/user-list-result.jsp")})
	public String call(){
//		String callNumber =  "801" + ((Plan)session.get("plan")).getTaxPayer().getPhoneNumber();
		String number = ((Plan)session.get("plan")).getTaxPayer().getRegNumber();
		ProcessBuilder procecc = new ProcessBuilder("C:/Program Files/CounterPath/X-Lite/X-Lite.exe","sip:102");
		try {
			procecc.start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return SUCCESS;
	}
	*/
	
	/**
	 * @see Сонгсодсон татавар төлөгчрүү е-мэйл илгээнэ
	 * @return Success
	 */
	@Action(value="send-email",results={@Result(name="success",location="/WEB-INF/content/ajax/user-list-result.jsp")})
	public String sendEmail(){
		EmailSwingWorker email = new EmailSwingWorker(((Plan)session.get("plan")).getTaxPayer());
		email.execute();
		return SUCCESS;
	}
	
	public List<Users> getOperators() {
		return usersService.getCallOperatorsOfSenior(request.getRemoteUser());
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<TaxPayer> getTaxpayerList() {
		return taxpayerList;
	}

	public void setTaxpayerList(List<TaxPayer> taxpayerList) {
		this.taxpayerList = taxpayerList;
	}

	public void setTaxPayerService(final TaxPayerService taxPayerService) {
		this.taxPayerService = taxPayerService;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public void setPlanService(final PlanService planService) {
		this.planService = planService;
	}
	
	public void setPhoneNumberService(final PhoneNumberService phoneNumberService) {
		this.phoneNumberService = phoneNumberService;
	}

	public List<String> getOpId() {
		return opId;
	}

	public void setOpId(List<String> opId) {
		this.opId = opId;
	}

	public List<Plan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Plan> planList) {
		this.planList = planList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setMoneyIndexService(final MoneyIndexService moneyIndexService) {
		this.moneyIndexService = moneyIndexService;
	}

	public void setDebtTypeService(final DebtTypeService debtTypeService) {
		this.debtTypeService = debtTypeService;
	}

	public void setDateIndexService(final DateIndexService dateIndexService) {
		this.dateIndexService = dateIndexService;
	}

	public TaxPayer getModel() {
		return taxPayer;
	}
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void prepare() throws Exception {
		if(taxPayer!=null && taxPayer.getId()!=null){
			taxPayer = taxPayerService.get(taxPayer.getId());
			taxPayerHash = taxPayer.hashCode();
		}
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request =request;
	}

	public TaxPayer getTaxPayer() {
		return taxPayer;
	}

	public void setTaxPayer(TaxPayer taxPayer) {
		this.taxPayer = taxPayer;
	}

	public List<Debtx> getListOfDebtx() {
		return listOfDebtx;
	}

	public Long getAutoOp() {
		return autoOp;
	}

	public void setAutoOp(Long autoOp) {
		this.autoOp = autoOp;
	}

	public void setCallIndexService(final CallIndexService callIndexService) {
		this.callIndexService = callIndexService;
	}

	public int getCallQuantity() {
		return callQuantity;
	}

	public void setCallQuantity(int callQuantity) {
		this.callQuantity = callQuantity;
	}

	public int getCallIndex() {
		return callIndex;
	}

	public void setCallIndex(int callIndex) {
		this.callIndex = callIndex;
	}


	private Date endDate(){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	private String dateToStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public void setDebtService(final DebtService debtService) {
		this.debtService = debtService;
	}
	
	public int getAvgPay() {
		return avgPay;
	}

	public void setAvgPay(int avgPay) {
		this.avgPay = avgPay;
	}

	public String getOpModel() {
		return opModel;
	}

	public void setOpModel(String opModel) {
		this.opModel = opModel;
	}

	public int getOpIdChild() {
		return opIdChild;
	}

	public void setOpIdChild(int opIdChild) {
		this.opIdChild = opIdChild;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setCallQuantityService(final CallQuantityService callQuantityService) {
		this.callQuantityService = callQuantityService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCallService(final CallService callService) {
		this.callService = callService;
	}

	public void setReasonService(final ReasonService reasonService) {
		this.reasonService = reasonService;
	}
	
	
	
	
	
}
