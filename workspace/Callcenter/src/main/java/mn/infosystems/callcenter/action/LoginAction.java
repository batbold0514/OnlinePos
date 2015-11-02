package mn.infosystems.callcenter.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.enums.PauseStatus;
import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.LogoutTime;
import mn.infosystems.callcenter.model.MessagesClient;
import mn.infosystems.callcenter.model.Plan;
import mn.infosystems.callcenter.model.Users;
import mn.infosystems.callcenter.service.LogoutTimeService;
import mn.infosystems.callcenter.service.PlanService;

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

@SuppressWarnings("serial")
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/operator"),
		@Namespace("/senior") })
public class LoginAction extends ActionSupport implements ServletRequestAware,
		Preparable, ModelDriven<Plan>, SessionAware {

	private Date date = new Date();
	private HttpServletRequest request;
	private List<Plan> listOfPlanCall;
	private List<Plan> listOfPlanNotCall;
	private PlanService planService;
	private LogoutTimeService logoutTimeService;
	private Plan plan = new Plan();
	private int planHash;
	private Map<String, Object> m;

	@SkipValidation
	@Action(value = "adminlogin", results = {
			@Result(name = "success", type = "redirectAction", location = "debt-report-pre"),
			@Result(name = "error", type = "redirectAction", location = "logout") })
	public String admin() {
		Users user = (Users) planService.getCurrentSession()
				.getNamedQuery("user.getByUsername")
				.setString("username", request.getRemoteUser()).list().get(0);
		if (user.getLoginStatus().equals(StatusEnum.inActive))
			return ERROR;
		user.setPauseStatus(PauseStatus.work);
		LogoutTime logoutTime = (LogoutTime) logoutTimeService.get(0l);
		m.put("logoutTime", logoutTime);
		m.put("users", user);
		return SUCCESS;
	}
	@SkipValidation
	@Action(value = "seniorlogin", results = {
			@Result(name = "success", type = "redirectAction", location = "operator-status"),
			@Result(name = "error", type = "redirectAction", location = "logout") })
	public String senior() {
		Users user = (Users) planService.getCurrentSession()
				.getNamedQuery("user.getByUsername")
				.setString("username", request.getRemoteUser()).list().get(0);
		if (user.getLoginStatus() == null ||user.getLoginStatus().equals(StatusEnum.inActive))
			return ERROR;
		user.setPauseStatus(PauseStatus.work);
		LogoutTime logoutTime = (LogoutTime) logoutTimeService.get(0l);
		m.put("logoutTime", logoutTime);
		m.put("users", user);
		return SUCCESS;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public List<Plan> getListOfPlanCall() {
		return listOfPlanCall;
	}

	public List<Plan> getListOfPlanNotCall() {
		return listOfPlanNotCall;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Plan getModel() {
		return plan;
	}

	public void prepare() throws Exception {
		if (plan != null && plan.getId() != null) {
			plan = planService.get(plan.getId());
			planHash = plan.hashCode();
		}
	}

	public void setPlanService(final PlanService planService) {
		this.planService = planService;
	}

	public void setSession(Map<String, Object> session) {
		m = session;
	}

	public void setLogoutTimeService(final LogoutTimeService logoutTimeService) {
		this.logoutTimeService = logoutTimeService;
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
}
