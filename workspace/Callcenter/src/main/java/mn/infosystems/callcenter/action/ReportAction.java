package mn.infosystems.callcenter.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import mn.infosystems.callcenter.model.CallProcess;
import mn.infosystems.callcenter.model.Calls;
import mn.infosystems.callcenter.model.Commitment;
import mn.infosystems.callcenter.model.ConnectedPerson;
import mn.infosystems.callcenter.model.ConnectedPersonReport;
import mn.infosystems.callcenter.model.Debt;
import mn.infosystems.callcenter.model.DebtType;
import mn.infosystems.callcenter.model.Reason;
import mn.infosystems.callcenter.model.TaxPayer;
import mn.infosystems.callcenter.model.TaxPayerReturn;
import mn.infosystems.callcenter.model.Users;
import mn.infosystems.callcenter.service.CallService;
import mn.infosystems.callcenter.service.CommitmentService;
import mn.infosystems.callcenter.service.ConnectedPersonService;
import mn.infosystems.callcenter.service.DebtService;
import mn.infosystems.callcenter.service.DebtTypeService;
import mn.infosystems.callcenter.service.ReasonService;
import mn.infosystems.callcenter.service.TaxPayerService;
import mn.infosystems.callcenter.service.UsersService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Dell
 * @see Тайлангууд
 */
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/operator"),
		@Namespace("/senior") })
public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private CallService callService;
	private ReasonService reasonService;
	private UsersService usersService;
	private DebtService debtService;
	private TaxPayerService taxPayerService;
	private DebtTypeService debtTypeService;
	private CommitmentService commitmentService;

	private List<ConnectedPersonReport> conPersonReports;
	private List<CallProcess> callProcessList;
	private List<Calls> callList;
	private List<Commitment> commitmentList;
	private String startDateString = dateToStr(new Date());
	private String endDateString = dateToStr(new Date());
	private String operatorIdString = "%";
	private String reasonIdString = "%";
	private int callDuration = 0;
	private List<TaxPayerReturn> listOfReturnReportDebt;
	private ConnectedPersonService connectedPersonService;

	private List<Debt> debtList;
	private String debtCreateDateRange;
	private String debtPayDateRange;
	private String debtTypeString = "%";
	private String taxPayerString = "%";
	private Boolean allShow = true;
	private String connectedPersonString = "%";

	private String soundfile;

	@Action(value = "process-report", results = { @Result(name = "success", type = "tiles", location = "/call-process-report.tiles") })
	public String workReport() throws Exception {
		callProcessList = callService
				.getProcess(startDateString, endDateString,reasonIdString);
		return SUCCESS;
	}

	@Action(value = "connected-person-report", results = { @Result(name = "success", type = "tiles", location = "/connected-person-report.tiles") })
	public String connectedPersonReport() throws Exception {
		conPersonReports = callService.getConnectedPerson(startDateString,
				endDateString,connectedPersonString);
		return SUCCESS;
	}

	@Action(value = "call-report", results = { @Result(name = "success", type = "tiles", location = "/calls-report.tiles") })
	public String callReport() throws Exception {
		callList = callService.getCalls(startDateString, endDateString,
				callDuration, operatorIdString, reasonIdString);
		callProcessList = callService
				.getProcessGroup(startDateString, endDateString,reasonIdString);
		return SUCCESS;
	}

	@Action(value = "return-report", results = { @Result(name = "success", type = "tiles", location = "/return-report.tiles") })
	public String returnReport() {
		listOfReturnReportDebt = debtService.getRepurnReport(startDateString,
				endDateString,operatorIdString);
		return SUCCESS;
	}

	@Action(value= "commitment-report",results = {@Result(name = "success", type = "tiles",location = "/commitment-report.tiles")})
	public String commitmentReport(){
		commitmentList = commitmentService.getByDate(startDateString, endDateString);
		return SUCCESS;
	}
	
	@Action(value = "debt-report-pre", results = { @Result(name = "success", type = "tiles", location = "/debt-report.tiles") })
	public String debtReportPre() throws Exception {
		return SUCCESS;
	}

	@Action(value = "debt-report", results = { @Result(name = "success", type = "tiles", location = "/debt-report.tiles") })
	public String debtReport() throws Exception {
		debtList = debtService.getDebtReportList(debtCreateDateRange,
				debtPayDateRange, debtTypeString, taxPayerString);
		return SUCCESS;
	}


	public void setCallService(final CallService callService) {
		this.callService = callService;
	}

	public void setDebtTypeService(final DebtTypeService debtTypeService) {
		this.debtTypeService = debtTypeService;
	}

	public void setReasonService(ReasonService reasonService) {
		this.reasonService = reasonService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setDebtService(DebtService debtService) {
		this.debtService = debtService;
	}

	public void setTaxPayerService(TaxPayerService taxPayerService) {
		this.taxPayerService = taxPayerService;
	}

	public List<Calls> getCallList() {
		return callList;
	}

	public void setCallList(List<Calls> callList) {
		this.callList = callList;
	}

	public String getOperatorIdString() {
		return operatorIdString;
	}

	public void setOperatorIdString(String operatorIdString) {
		this.operatorIdString = operatorIdString;
	}

	public String getReasonIdString() {
		return reasonIdString;
	}

	public void setReasonIdString(String reasinIdString) {
		this.reasonIdString = reasinIdString;
	}

	/*
	 * private Date stringToDate(String str) { SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date date = null; try { if
	 * (!str.equals("")) date = formatter.parse(str); } catch (ParseException e)
	 * { e.printStackTrace(); } return date; }
	 */

	public List<Users> getOperators() {
		return usersService.getOperators();
	}

	public List<Reason> getReasons() {
		return reasonService.findAll();
	}

	public List<DebtType> getDebtTypes() {
		return debtTypeService.findAll();
	}

	public List<TaxPayer> getAllTaxPayers() {
		return taxPayerService.findAll();
	}

	private String dateToStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

	public int getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	public String getDebtPayDateRange() {
		return debtPayDateRange;
	}

	public void setDebtPayDateRange(String debtPayDateRange) {
		this.debtPayDateRange = debtPayDateRange;
	}

	public String getDebtCreateDateRange() {
		return debtCreateDateRange;
	}

	public void setDebtCreateDateRange(String debtCreateDateRange) {
		this.debtCreateDateRange = debtCreateDateRange;
	}

	public String getDebtTypeString() {
		return debtTypeString;
	}

	public void setDebtTypeString(String debtTypeString) {
		this.debtTypeString = debtTypeString;
	}

	public String getTaxPayerString() {
		return taxPayerString;
	}

	public void setTaxPayerString(String taxPayerString) {
		this.taxPayerString = taxPayerString;
	}

	public List<Debt> getDebtList() {
		return debtList;
	}

	public void setDebtList(List<Debt> debtList) {
		this.debtList = debtList;
	}

	public List<TaxPayerReturn> getListOfReturnReportDebt() {
		return listOfReturnReportDebt;
	}

	public List<CallProcess> getCallProcessList() {
		return callProcessList;
	}

	public List<ConnectedPersonReport> getConPersonReports() {
		return conPersonReports;
	}

	public String getSoundfile() {
		return soundfile;
	}

	public void setSoundfile(String soundfile) {
		this.soundfile = soundfile;
	}

	public Boolean getAllShow() {
		return allShow;
	}

	public void setAllShow(Boolean allShow) {
		this.allShow = allShow;
	}

	public void setConnectedPersonService(
			final ConnectedPersonService connectedPersonService) {
		this.connectedPersonService = connectedPersonService;
	}
	
	public List<ConnectedPerson> getConnectedPersons(){
		return connectedPersonService.findAll();
	}

	public String getConnectedPersonString() {
		return connectedPersonString;
	}

	public void setConnectedPersonString(String connectedPersonString) {
		this.connectedPersonString = connectedPersonString;
	}

	public List<Commitment> getCommitmentList() {
		return commitmentList;
	}

	public void setCommitmentService(final CommitmentService commitmentService) {
		this.commitmentService = commitmentService;
	}

	
}
