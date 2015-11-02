package mn.infosystems.callcenter.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.callcenter.enums.TaxpayerStatus;
import mn.infosystems.callcenter.model.AccountNumber;
import mn.infosystems.callcenter.model.CallCommitment;
import mn.infosystems.callcenter.model.CallCommitmentShow;
import mn.infosystems.callcenter.model.Calls;
import mn.infosystems.callcenter.model.Commitment;
import mn.infosystems.callcenter.model.ConnectedPerson;
import mn.infosystems.callcenter.model.Debt;
import mn.infosystems.callcenter.model.Messages;
import mn.infosystems.callcenter.model.Plan;
import mn.infosystems.callcenter.model.Reason;
import mn.infosystems.callcenter.model.ReturnReason;
import mn.infosystems.callcenter.model.TaxPayer;
import mn.infosystems.callcenter.model.TaxPayerReturn;
import mn.infosystems.callcenter.model.Users;
import mn.infosystems.callcenter.service.CallQuantityService;
import mn.infosystems.callcenter.service.CallService;
import mn.infosystems.callcenter.service.CommitmentService;
import mn.infosystems.callcenter.service.ConnectedPersonService;
import mn.infosystems.callcenter.service.DebtService;
import mn.infosystems.callcenter.service.PlanService;
import mn.infosystems.callcenter.service.ReasonService;
import mn.infosystems.callcenter.service.ReturnReasonService;
import mn.infosystems.callcenter.service.TaxPayerReturnService;
import mn.infosystems.callcenter.service.TaxPayerService;
import mn.infosystems.callcenter.service.UsersService;

import oracle.net.aso.i;

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

/**
 * @author Suld
 * @see Төлөвлөг удирдах класс
 * 
 */
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/operator"),
		@Namespace("/senior") })
public class PlanAction extends ActionSupport implements Preparable,
		ModelDriven<Plan>, SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private PlanService planService;
	private Date date = new Date();
	private String dateStr = dateToStr(new Date());
	private List<Plan> planList;
	private Plan plan = new Plan();
	@SuppressWarnings("unused")
	private int planHash;
	private List<CallCommitment> callCommitments ;
	private Map<String, Object> session;
	private CommitmentService commitmentService;
	private DebtService debtService;
	private HttpServletRequest request;
	private ReasonService reasonService;
	private String reason;
	private String userName;
	private UsersService usersService;
	private CallService callService;
	private ConnectedPersonService connectedPersonService;
	private String personIdString;
	private ReturnReasonService returnReasonService;
	private String returnReasonIdString;
	private TaxPayerReturnService taxPayerReturnService;
	private TaxPayerService taxPayerService;
	private int callCommitmentLocation;
	private int callCommitmentChildLocation;
	private String operatorCode;
	private CallQuantityService callQuantityService;
	private int callQuantity;
	private List<List<AccountNumber>> accounts;
	private List<CallCommitmentShow> callCommitmentShows = new LinkedList<CallCommitmentShow>();
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Plan getModel() {
		return plan;
	}

	public void prepare() throws Exception {
		if (plan != null && plan.getId() != null) {
			this.plan = planService.get(plan.getId());
			this.planHash = plan.hashCode();
		}
	}

	@Action(value = "day-plan", results = { @Result(name = "success", type = "tiles", location = "/day-plan.tiles") })
	public String dayplan() {
		
		date = stringToDate(dateStr);
		setPlanList(planService.getPlansOfDay(date));
		return SUCCESS;
	}
	@SkipValidation
	@Action(value="list-result-editOp-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/day-plan/day-plan-list-result.jsp")})
	public String list1() throws Exception{
		date = stringToDate(dateStr);
		setPlanList(planService.getPlansOfDay(date));
		return SUCCESS;
	}
	@Action(value="edit-operator-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/day-plan/day-plan-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/day-plan/day-plan-result.jsp")})
	public String save() throws Exception{
		plan = planService.get(plan.getId());
		if(operatorCode.equals("")){
			addFieldError("operatorCode", "operatorCode");
			return INPUT;
		}
		plan.setOperator(usersService.get(Long.parseLong(operatorCode)));
		request.setAttribute("successDayPlan", true);
		return SUCCESS;
	}
	@Action(value = "show-plan", results = { @Result(name = "success", type = "tiles", location = "/show-plan.tiles") })
	public String gotoPlan() {
		session.put("plan", plan);
		callQuantity = callQuantityService.get(0l).getCount();
		updateUser(plan.getTaxPayer().getRegNumber());
		callCommitments= new LinkedList<CallCommitment>();
		/*for(@SuppressWarnings("unused") Debt debt:plan.getTaxPayer().getActiveDebtList()){
			callCommitments.add(new CallCommitment());
		}*/
		accounts = new LinkedList<List<AccountNumber>>();
		boolean check =false;
		for(int i=0;i<plan.getTaxPayer().getActiveDebtList().size();i++){
			check = false;
			
			for(int j=0;j<callCommitments.size();j++){
				if(callCommitments.get(j).getListOfDebt().get(0).getType().getId().equals(plan.getTaxPayer().getActiveDebtList().get(i).getType().getId())){
					callCommitments.get(j).add(plan.getTaxPayer().getActiveDebtList().get(i));
					check=true;
					break;
				}
			}
			
			if(!check){
				CallCommitment commit = new  CallCommitment();
				commit.add(
						plan.getTaxPayer().getActiveDebtList().get(i));
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
		return SUCCESS;
	}
	@Action(value = "callCommitmentAdd",results={@Result(name = "success" ,location = "/WEB-INF/content/ajax/show-plan/callCommitmentAdd.jsp" )})
	public String callCommitmentAdd(){
		callCommitments.get(callCommitmentLocation).setListsize(callCommitments.get(callCommitmentLocation).getListsize()+1);
		List<Debt> list = new LinkedList<Debt>();
		plan = planService.get(Long.parseLong(request.getParameter("id")));
		for(Debt db:callCommitments.get(callCommitmentLocation).getListOfDebt()){
			for(Debt db1:plan.getTaxPayer().getActiveDebtList()){
				if(db1.getId().equals(db.getId())){
					list.add(db1);
					break;
				}
			}
		}
		list.add(list.get(callCommitmentChildLocation));
		callCommitments.get(callCommitmentLocation).add();
		callCommitments.get(callCommitmentLocation).setListOfDebt(list);
		session.put("callCommitmentLocation",callCommitmentLocation);
		session.put("callCommitments", callCommitments);
		return SUCCESS;
	}
	
	@Action(value = "callCommitmentRemove",results={@Result(name = "success" ,location = "/WEB-INF/content/ajax/show-plan/callCommitmentRemove.jsp" )})
	public String callCommitmentRemove(){
		callCommitments.get(callCommitmentLocation).setListsize(callCommitments.get(callCommitmentLocation).getListsize()-1);
		List<Debt> list = new LinkedList<Debt>();
		plan = planService.get(Long.parseLong(request.getParameter("id")));
		for(Debt db:callCommitments.get(callCommitmentLocation).getListOfDebt()){
			for(Debt db1:plan.getTaxPayer().getActiveDebtList()){
				if(db1.getId().equals(db.getId())){
					list.add(db1);
					break;
				}
			}
		}
		list.remove(callCommitmentChildLocation);
		callCommitments.get(callCommitmentLocation).remove(callCommitmentChildLocation);
		callCommitments.get(callCommitmentLocation).setListOfDebt(list);
		session.put("callCommitmentLocation",callCommitmentLocation);
		session.put("callCommitments", callCommitments);
		return SUCCESS;
	}
/*
	@Action(value = "show-plan1", results = { @Result(name = "success", type = "tiles", location = "/show-plan.tiles") })
	public String gotoPlan1() {
		this.plan = (Plan) session.get("plan");
		session.put("plan", plan);
		callQuantity = callQuantityService.get(0l).getCount();
		updateUser(plan.getTaxPayer().getRegNumber());
		callCommitments= new LinkedList<CallCommitment>();
		for(@SuppressWarnings("unused") Debt debt:plan.getTaxPayer().getActiveDebtList()){
			callCommitments.add(new CallCommitment());
		}
		session.put("callCommitments", callCommitments);
		return SUCCESS;
	}
*/
	private void updateUser(String regNumber) {
		Users user = usersService.getUser(request.getRemoteUser());
		user.setCallCompany(regNumber);
		usersService.saveOrUpdate(user);
	}

	/**
	 * @return Төлөв заасан тэмдэгт мөр
	 * @throws Exception
	 * @see Амлалтуудыг хадгална
	 */
	@Action(value = "save-commitment", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/show-plan/show-plan-call.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/show-plan/show-plan-call.jsp") })
	public String saveCommitment() throws Exception {
		int index = 0;
		int indexlist = 0;
		request.removeAttribute("successShowPlanCall");
		try {
			plan = planService.get(Long.parseLong(request.getParameter("id")));
			for (; index < callCommitments.size(); index++) {
					for(indexlist = 0;indexlist<=callCommitments.get(index).getListsize();indexlist++){
						List<Commitment> comList = new LinkedList<Commitment>();
						if( callCommitments.get(index).getCommitValues().get(indexlist).equals("")  && callCommitments.get(index).getCommitDates().get(indexlist).equals("")){
						}else{
							Commitment commit = new Commitment();
							commit.setGiveDate(new Date());
							commit.setDescription(callCommitments.get(index).getCommitDescriptions().get(indexlist));
							
							Debt debt = new Debt();
							for(Debt db:plan.getTaxPayer().getActiveDebtList()){
								if(db.getId().equals(callCommitments.get(index).getListOfDebt().get(indexlist).getId())){
									debt = db;
									break;
								}
							}
						if(callCommitments.get(index).getCommitValues().get(indexlist).trim().equals("")){
							addFieldError("errorCommitValues"+index+indexlist, Messages.getString("commitValues"));
							return INPUT;
						}
						try{
							commit.setValue(Double.parseDouble(callCommitments.get(index).getCommitValues().get(indexlist))); 
						}catch(NumberFormatException nfe){
							addFieldError("errorCommitValues"+index+indexlist, Messages.getString("notNumber"));
							return INPUT;
						}
						if(callCommitments.get(index).getCommitDates().get(indexlist).trim().equals("")){
							addFieldError("errorCommitDates"+index+indexlist, Messages.getString("commitDates"));
							return INPUT;
						}
						if(stringToDate(callCommitments.get(index).getCommitDates().get(indexlist)).before(new Date())){
							addFieldError("errorCommitDates"+index+indexlist, Messages.getString("commitDateAfter"));
							return INPUT;
						}
						if(stringToDate(callCommitments.get(index).getCommitDates().get(indexlist)).after(debt.getEndDate())){
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							addFieldError("errorCommitDates"+index+indexlist, format.format(debt.getEndDate()) + " " +Messages.getString("commitDateFuture"));
							return INPUT;
						}
						for(int j =indexlist+1;j<=callCommitments.get(index).getListsize();j++){
							if(debt.getId().equals(callCommitments.get(index).getListOfDebt().get(j).getId())&& callCommitments.get(index).getCommitDates().get(indexlist).equals(callCommitments.get(index).getCommitDates().get(j))){
								addFieldError("errorCommitDates"+index+indexlist, Messages.getString("commitDateUnique"));
								addFieldError("errorCommitDates"+index+j, Messages.getString("commitDateUnique"));
								return INPUT;
							};
						}
						commit.setPayDate(stringToDate(callCommitments.get(index).getCommitDates().get(indexlist)));
						commit.setDebt( debtService.get(callCommitments.get(index).getListOfDebt().get(indexlist).getId()));
						commit.setPayBalance(commit.getDebt().getBalance());
						commit = commitmentService.saveOrUpdate(commit);
						comList.add(commit);
						debt.getCommitments().addAll(comList);
						plan.setCall(true);
						
					}
				}
				
			}
			Calls call  = new Calls(reasonService.get(Long.parseLong(reason)),usersService.getUser(userName));
			call.setTaxPayer(plan.getTaxPayer());
			call.setFileName((String) session.get("filenames"));
			callService.callPlus(plan.getTaxPayer().getId(),callQuantityService.get(0l).getCount());
			callService.saveOrUpdate(call);
			plan.getTaxPayer().getCalls().add(call);
		} catch (Exception e) {
			addFieldError("errorCommitValues"+index+indexlist, e.toString());
			return INPUT;
			
		}
		request.setAttribute("successShowPlanCall", "true");
		return SUCCESS;
	}
	/**
	 * @return Төлөв заасан тэмдэгт мөр
	 * @throws Exception
	 * @see Амлалтуудыг хадгална
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "save-commitment-show", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/show-plan/show-plan-call-show.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/show-plan/show-plan-call-show.jsp") })
	public String saveCommitmentShow() throws Exception {
		int index = 0;
		request.removeAttribute("successShowPlanCall");
		try {
			plan = planService.get(Long.parseLong(request.getParameter("id")));
			List<CallCommitment> callCommitment = (List<CallCommitment>) session.get("callCommitments");
			for (; index < callCommitmentShows.size(); index++) {
				int i=0;
				double balance = 0;
					if(callCommitmentShows.get(index).getCommitDates().equals("") &&callCommitmentShows.get(index).getCommitValues().equals("")){
					}else{
						if(callCommitmentShows.get(index).getCommitValues().trim().equals("")){
							addFieldError("errorCommitShowValues"+index, Messages.getString("commitValues"));
							return INPUT;
						}
						try{
							balance = Double.parseDouble(callCommitmentShows.get(index).getCommitValues());
						}catch(NumberFormatException nfe){
							addFieldError("errorCommitShowValues"+index, Messages.getString("notNumber"));
							return INPUT;
						}
						if(callCommitmentShows.get(index).getCommitDates().trim().equals("")){
							addFieldError("errorCommitShowDates"+index, Messages.getString("commitDates"));
							return INPUT;
						}
						if(stringToDate(callCommitmentShows.get(index).getCommitDates()).before(new Date())){
							addFieldError("errorCommitShowDates"+index, Messages.getString("commitDateAfter"));
							return INPUT;
						}
						while(true){
							Commitment commit = new Commitment();
							commit.setGiveDate(new Date());
							for(int j=i+1;j<callCommitment.get(index).getListOfDebt().size();j++){
								if(callCommitment.get(index).getListOfDebt().get(i).getEndDate().before(callCommitment.get(index).getListOfDebt().get(j).getEndDate())){
									Debt d = callCommitment.get(index).getListOfDebt().get(i);
									callCommitment.get(index).getListOfDebt().set(i, callCommitment.get(index).getListOfDebt().get(j));
									callCommitment.get(index).getListOfDebt().set(j,d);
								}
							}
							Debt db =callCommitment.get(index).getListOfDebt().get(i);
							for(Debt debt:plan.getTaxPayer().getActiveDebtList()){
								if(debt.getId().equals(callCommitment.get(index).getListOfDebt().get(i).getId())){
									db = debt;
									break;
								}
							}
							if(stringToDate(callCommitmentShows.get(index).getCommitDates()).after(db.getEndDate())){
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
								addFieldError("errorCommitShowDates"+index, format.format(db.getEndDate()) + " " +Messages.getString("commitDateFuture"));
								return INPUT;
							}
							commit.setPayDate(stringToDate(callCommitmentShows.get(index).getCommitDates()));
							commit.setDebt(db);
							commit.setPayBalance(db.getBalance());
							if(db.getBalance() <= balance){
								commit.setValue(db.getBalance());
								balance-=db.getBalance();
							}else{
								commit.setValue(balance);
								balance = 0;
							}
							commit = commitmentService.saveOrUpdate(commit);
							db.getCommitments().add(commit);
							plan.setCall(true);
							i++;
							if(balance==0){
								break;
							}
							if(i>=callCommitment.get(index).getListOfDebt().size()){
								addFieldError("errorCommitShowValues"+index, Messages.getString("maxValues"));
								return INPUT;
							}
					}
				}
			}
			Calls call  = new Calls(reasonService.get(Long.parseLong(reason)),usersService.getUser(userName));
			call.setTaxPayer(plan.getTaxPayer());
			callService.callPlus(plan.getTaxPayer().getId(),callQuantityService.get(0l).getCount());
			callService.saveOrUpdate(call);
			plan.getTaxPayer().getCalls().add(call);
		} catch (Exception e) {
			addFieldError("errorCommitShowValues"+index, e.toString());
			return INPUT;
			
		}
		request.setAttribute("successShowPlanCall", "true");
		return SUCCESS;
	}
	/**
	 * @see шууд буцаах, тухайн татавар төлөгчрүү залгасан дуудлагыг хардгалаад, 
	 * татавар төлөгчийн статусыг идэвгүй болгоод, буцаах хүмүүсийн жагсаалтруу нэмнэ
	 * @return
	 */
	@Action(value = "returnTaxpayer", results = {
			@Result(name = "success", type = "redirectAction", location = "show-plan" ,params = {"model.id","${id}"}),
			@Result(name = "success1", type = "redirectAction", location = "userlogin") })
	public String returnTaxpayer() {
		try{
			Calls call = new Calls(reasonService.get(1l),
				usersService.getUser(request.getRemoteUser()));
		if (personIdString != null && !personIdString.equals("")) {
			call.setPerson(connectedPersonService.get(Long
					.parseLong(personIdString))); 
		}
		this.plan = planService.get(plan.getId());
		call.setTaxPayer(plan.getTaxPayer());
		callService.callPlus(plan.getTaxPayer().getId(),callQuantityService.get(0l).getCount());
		callService.saveOrUpdate(call);
		TaxPayer tp = plan.getTaxPayer();
		for(Debt db:tp.getActiveDebtList()){
			db.setStatus(TaxpayerStatus.INACTIVE);
			debtService.saveOrUpdate(db);
		};
		tp = taxPayerService.saveOrUpdate(tp);
		TaxPayerReturn tpr = new TaxPayerReturn();
		tpr.setDate(new Date());
		tpr.setOperator(usersService.getUser(request.getRemoteUser()));
		if(!returnReasonIdString.equals("")){
			tpr.setReason(returnReasonService.get(Long
					.parseLong(returnReasonIdString)));
		}
		tpr.setDebtOfList(tp.getActiveDebtList());
		taxPayerReturnService.saveOrUpdate(tpr);
		plan.getTaxPayer().getCalls().add(call);
		plan.setCall(true);
		planService.saveOrUpdate(plan);
		}catch(Exception e){
		}
		if (request.isUserInRole("operator")) {
			return "success1";
		}
		return SUCCESS;
	}

	public void setPlanService(final PlanService planService) {
		this.planService = planService;
	}

	public void setCommitmentService(final CommitmentService commitmentService) {
		this.commitmentService = commitmentService;
	}

	public void setConnectedPersonService(
			final ConnectedPersonService connectedPersonService) {
		this.connectedPersonService = connectedPersonService;
	}

	public void setDebtService(final DebtService debtService) {
		this.debtService = debtService;
	}

	public void setTaxPayerReturnService(
			final TaxPayerReturnService taxPayerReturnService) {
		this.taxPayerReturnService = taxPayerReturnService;
	}

	public void setTaxPayerService(final TaxPayerService taxPayerService) {
		this.taxPayerService = taxPayerService;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Plan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Plan> planList) {
		this.planList = planList;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
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

	private String dateToStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setReasonService(final ReasonService reasonService) {
		this.reasonService = reasonService;
	}

	public List<Reason> getReasonsList() {
		return reasonService.findAll();
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setCallService(final CallService callService) {
		this.callService = callService;
	}

	public void setReturnReasonService(
			final ReturnReasonService returnReasonService) {
		this.returnReasonService = returnReasonService;
	}

	public List<ConnectedPerson> getConnectedPeople() {
		return connectedPersonService.findAll();
	}

	public String getPersonIdString() {
		return personIdString;
	}

	public void setPersonIdString(String personIdString) {
		this.personIdString = personIdString;
	}

	public List<ReturnReason> getReasons() {
		return returnReasonService.findAll();
	}

	public String getReturnReasonIdString() {
		return returnReasonIdString;
	}

	public void setReturnReasonIdString(String returnReasonIdString) {
		this.returnReasonIdString = returnReasonIdString;
	}
	
	public List<CallCommitment> getCallCommitments() {
		return callCommitments;
	}

	public void setCallCommitments(List<CallCommitment> callCommitments) {
		this.callCommitments = callCommitments;
	}

	public int getCallCommitmentLocation() {
		return callCommitmentLocation;
	}

	public void setCallCommitmentLocation(int callCommitmentLocation) {
		this.callCommitmentLocation = callCommitmentLocation;
	}

	public int getCallCommitmentChildLocation() {
		return callCommitmentChildLocation;
	}

	public void setCallCommitmentChildLocation(int callCommitmentChildLocation) {
		this.callCommitmentChildLocation = callCommitmentChildLocation;
	}
	public List<Users> getOperators() {
		return usersService.getCallOperatorsOfSenior(request.getRemoteUser());
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public void setCallQuantityService(final CallQuantityService callQuantityService) {
		this.callQuantityService = callQuantityService;
	}

	public int getCallQuantity() {
		return callQuantity;
	}

	public void setCallQuantity(int callQuantity) {
		this.callQuantity = callQuantity;
	}

	public List<List<AccountNumber>> getAccounts() {
		return accounts;
	}

	public List<CallCommitmentShow> getCallCommitmentShows() {
		return callCommitmentShows;
	}

	
	
}
