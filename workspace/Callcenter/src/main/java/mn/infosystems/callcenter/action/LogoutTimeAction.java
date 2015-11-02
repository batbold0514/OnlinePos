package mn.infosystems.callcenter.action;

import java.util.Map;

import mn.infosystems.callcenter.model.LogoutTime;
import mn.infosystems.callcenter.service.LogoutTimeService;

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

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/senior") })
public class LogoutTimeAction extends ActionSupport implements Preparable,ModelDriven<LogoutTime>,SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LogoutTime logoutTime = new LogoutTime();
	private LogoutTimeService logoutTimeService;
	private int logoutTimeHash;
	private Map<String, Object> m ;
	
	public LogoutTime getModel() {
		return logoutTime;
	}

	public void prepare() throws Exception {
		if(logoutTime!=null && logoutTime.getId()!=null){
			logoutTime = logoutTimeService.get(logoutTime.getId());
			logoutTimeHash = logoutTime.hashCode();
		}
	}
	
	@Action(value = "saveLogoutTime" , results = {@Result (name = "success",location="/WEB-INF/content/logoutTime.jsp")})
	public String save(){
		if (logoutTime != null && logoutTime.hashCode() != logoutTimeHash) {
			logoutTimeService.saveOrUpdate(logoutTime);
			m.put("logoutTime", logoutTime);
		}
		return SUCCESS;
	}

	public LogoutTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LogoutTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	public void setLogoutTimeService(final LogoutTimeService logoutTimeService) {
		this.logoutTimeService = logoutTimeService;
	}

	public void setSession(Map<String, Object> session) {
		m = session;
	}
	

}
