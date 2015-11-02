package mn.infosystems.callcenter.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.callcenter.enums.CallStatus;
import mn.infosystems.callcenter.enums.PauseStatus;
import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.LogoutTime;
import mn.infosystems.callcenter.model.MessagesClient;
import mn.infosystems.callcenter.model.Plan;
import mn.infosystems.callcenter.model.Users;
import mn.infosystems.callcenter.service.LogoutTimeService;
import mn.infosystems.callcenter.service.PlanService;
import mn.infosystems.callcenter.service.UsersService;

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

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/operator"),
		@Namespace("/senior") })
public class OperatorAction extends ActionSupport implements ServletRequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	Map<String, Object> session;
	private List<Plan> listOfPlanCall;
	private List<Plan> listOfPlanNotCall;
	private PlanService planService;
	private LogoutTimeService logoutTimeService;
	private UsersService usersService;
	private String userName;
	private String callStatusIn;
	private String planId;
	
	@SkipValidation
	@Action(value="userlogin",results={@Result(name="success",type="tiles",location="/operator-home-page.tiles"),
			@Result(name="error",type="redirectAction",location="logout")})
	public String callAction(){
		Users user = usersService.getUser(request.getRemoteUser());
		if(user.getLoginStatus().equals(StatusEnum.inActive)) return ERROR;
		listOfPlanCall = planService.getCall(request.getRemoteUser(),new Date());
		listOfPlanNotCall = planService.getNotCall(request.getRemoteUser(),new Date());
		user.setPauseStatus(PauseStatus.work);
		LogoutTime logoutTime = (LogoutTime)logoutTimeService.get(0l);
		session.put("logoutTime", logoutTime);
		session.put("users", user);
		return SUCCESS;
	}
	@Action(value = "userChangeShowPlan",results={
			@Result(name = "success" , location="/WEB-INF/content/ajax/user-result.jsp"),
			@Result(name = "input" , location="/WEB-INF/content/ajax/user-result.jsp")
	})
	public String userChange(){
		MessagesClient client = new MessagesClient(getIpAddress(request), 1500);
		client.start();
		Users user = usersService.getUser(request.getRemoteUser());
		client.sendMessage("login-"+user.getOperatorLine());
		Plan plan = planService.get(Long.parseLong(planId));
		if(callStatusIn.equals("inCall")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			client.sendMessage("call-"+plan.getTaxPayer().getPhoneNumber()+"-"+plan.getTaxPayer().getRegNumber()+"-"+sdf.format(new Date())+"-"+request.getSession().getServletContext().getRealPath("/"));
			String filename = plan.getTaxPayer().getRegNumber()+sdf.format(new Date());
			session.put("filenames",filename);
		}else{
			client.sendMessage("reject");
		}
		client.stop();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
//		new File(request.getSession().getServletContext().getRealPath("/")+"/sound/"+plan.getTaxPayer().getRegNumber()+sdf.format(new Date())+".wav");
		request.setAttribute("successUser", "true");
		return SUCCESS;
	}
	@Action(value = "userChangeSearchTaxpayer",results={
			@Result(name = "success" , location="/WEB-INF/content/ajax/user-result.jsp"),
			@Result(name = "input" , location="/WEB-INF/content/ajax/user-result.jsp")
	})
	public String userChangeSearchTaxPayer(){
		MessagesClient client = new MessagesClient(getIpAddress(request), 1500);
		client.start();
		if(callStatusIn.equals("answer")){
			client.sendMessage("answer");
		}else{
			client.sendMessage("reject");
		}
		client.stop();
		request.setAttribute("successUser", "true");
		return SUCCESS;
	}
	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public void setPlanService(final PlanService planService){
		this.planService = planService;
	}
	
	public void setLogoutTimeService(final LogoutTimeService logoutTimeService){
		this.logoutTimeService = logoutTimeService;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public List<Plan> getListOfPlanCall() {
		return listOfPlanCall;
	}

	public void setListOfPlanCall(List<Plan> listOfPlanCall) {
		this.listOfPlanCall = listOfPlanCall;
	}

	public List<Plan> getListOfPlanNotCall() {
		return listOfPlanNotCall;
	}

	public void setListOfPlanNotCall(List<Plan> listOfPlanNotCall) {
		this.listOfPlanNotCall = listOfPlanNotCall;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCallStatusIn() {
		return callStatusIn;
	}
	public void setCallStatusIn(String callStatusIn) {
		this.callStatusIn = callStatusIn;
	}
	private String getIpAddress(HttpServletRequest request)
	{
		String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {  
            ip = request.getHeader("Proxy-Client-IP");  
        }
        
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {  
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }  
        
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	} 
	
	
}
