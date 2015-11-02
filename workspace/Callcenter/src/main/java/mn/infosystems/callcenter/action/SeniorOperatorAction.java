package mn.infosystems.callcenter.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.callcenter.enums.CallStatus;
import mn.infosystems.callcenter.enums.OperatorStatus;
import mn.infosystems.callcenter.model.CallDuration;
import mn.infosystems.callcenter.model.UserProFile;
import mn.infosystems.callcenter.model.Users;
import mn.infosystems.callcenter.service.CallDurationService;
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

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/senior") })
public class SeniorOperatorAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Map<String, Object> session;
	private List<Users> usersList;
	private UsersService usersService;
	private List<Long> listStatus;
	private CallDurationService callDurationService;
	private CallDurationService durationService;
	private TaxPayerService taxPayerService;
	
	@Action(value = "manage-operators", results = { @Result(name = "success", type = "tiles", location = "/manage-operartor.tiles") })
	public String manageList() {
		this.usersList = usersService.getOperatorsOfSenior(request
				.getRemoteUser());
		CallDuration callduration = callDurationService.get(0l);
		for(Users user:usersList){
			if(user.getDurationNumber()>=callduration.getDuration()){
				user.setCallStatus(CallStatus.Danger);
				usersService.saveOrUpdate(user);
			}
		}
		session.put("managelist", usersList);
		return SUCCESS;
	}

	@Action(value = "save-mng-ops", results = { @Result(name = "success", type = "redirectAction", location = "manage-operators") })
	public String saveManageOperators() {
		int index = 0;
		usersList = usersService.getOperatorsOfSenior(request
				.getRemoteUser());
		for (Users user : usersList) {
			if (listStatus.get(index) == 1l) {
				user.setStatus(OperatorStatus.CALL);
			} else {
				if (listStatus.get(index) == 2l) {
					user.setStatus(OperatorStatus.RECIEVE);
				} else {
					user.setStatus(OperatorStatus.NONE);
				}
			}
			index++;
			usersService.saveOrUpdate(user);
		}
		return SUCCESS;
	}
	
	@Action(value="operator-status",results={@Result(name="success",type="tiles",location="/operator-status.tiles")})
	public String operatorStatus() throws Exception{
		List<UserProFile> listOfUserProFile = new LinkedList<UserProFile>();
		this.usersList = usersService.getOperatorsOfSenior(request
				.getRemoteUser());
		CallDuration callduration = callDurationService.get(0l);
		for(Users user:usersList){
			if(user.getCallStatus() !=null &&!user.getCallStatus().equals(CallStatus.Nocall)
					&& user.getDurationNumber()>=callduration.getDuration()){
				user.setCallStatus(CallStatus.Danger);
				usersService.save(user);
			}
			UserProFile userf = new UserProFile(user);
			listOfUserProFile.add(userf);
		}
		session.put("listOfUserProFile", listOfUserProFile);
		return SUCCESS;
	}
	
	@Action(value="operator-status-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/operator-status-ajax.jsp")})
	public String operatorStatusAjax() throws Exception{
		List<UserProFile> listOfUserProFile = new LinkedList<UserProFile>();
		this.usersList = usersService.getOperatorsOfSenior(request
				.getRemoteUser());
		CallDuration callduration = callDurationService.get(0l);
		for(Users user:usersList){
			if(user.getCallStatus() !=null &&!user.getCallStatus().equals(CallStatus.Nocall) && user.getDurationNumber()>=callduration.getDuration()){
				user.setCallStatus(CallStatus.Danger);
				usersService.save(user);
			}
			UserProFile userf = new UserProFile(user);
			userf.setTaxPayer(taxPayerService.getTaxPayer(user.getPhone()));
			listOfUserProFile.add(userf);
		}
		session.put("listOfUserProFile", listOfUserProFile);
		return SUCCESS;
	}
	
	
	public void setTaxPayerService(final TaxPayerService taxPayerService) {
		this.taxPayerService = taxPayerService;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}
	
	public void setCallDurationService(final CallDurationService callDurationService) {
		this.callDurationService = callDurationService;
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}

	public OperatorStatus[] getOperatorStatuses() {
		return OperatorStatus.values();
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Long> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<Long> listStatus) {
		this.listStatus = listStatus;
	}

	public void setDurationService(final CallDurationService durationService) {
		this.durationService = durationService;
	}
	
}
