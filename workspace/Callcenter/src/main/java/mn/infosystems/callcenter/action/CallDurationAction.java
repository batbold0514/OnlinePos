package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.callcenter.model.CallDuration;
import mn.infosystems.callcenter.service.CallDurationService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/senior")})
public class CallDurationAction extends ActionSupport implements Preparable,ModelDriven<CallDuration>,ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	private CallDuration callDuration = new CallDuration();
	private CallDurationService callDurationService;
	private int callDurationHash;
	private List<CallDuration> callDurationList;
	private HttpServletRequest request;

	public CallDuration getModel() {
		return callDuration;
	}

	public void prepare() throws Exception {
		if(callDuration!=null && callDuration.getId()!=null){
			this.callDuration = callDurationService.get(callDuration.getId());
			this.callDurationHash = callDuration.hashCode();
		}
	}

	/**
	 * @return Төлвийн тэмдэгт мөр
	 * @throws Exception
	 * @see Дуудлагын боломит хугцааны жагсаалт
	 */
	@Action(value="call-duration",results={@Result(name="success",type="tiles",location="/call-duration.tiles")})
	public String list() throws Exception{
		this.callDurationList = callDurationService.findAll();
		return SUCCESS;
	}
	
	@Action(value="save-callduration",results={@Result(name="success",location="/WEB-INF/content/ajax/callduration/call-duration-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/callIndex/callIndex-result.jsp")})
	public String save() throws Exception{
		if(callDuration!=null && callDuration.hashCode() != callDurationHash){
			callDurationService.saveOrUpdate(callDuration);
			request.setAttribute("callResuest", true);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="call-duration-list-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/callduration/call-duration-list.jsp")})
	public String listAjax(){
		this.callDurationList = callDurationService.findAll();
		return SUCCESS;
	}
	
	@Action(value="haha")
	public String haha(){
		JOptionPane.showMessageDialog(null, callDurationService.findAll().size());
		return SUCCESS;
	}
	
	public CallDuration getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(CallDuration callDuration) {
		this.callDuration = callDuration;
	}

	public int getCallDurationHash() {
		return callDurationHash;
	}

	public void setCallDurationHash(int callDurationHash) {
		this.callDurationHash = callDurationHash;
	}

	public List<CallDuration> getCallDurationList() {
		return callDurationList;
	}

	public void setCallDurationList(List<CallDuration> callDurationList) {
		this.callDurationList = callDurationList;
	}

	public void setCallDurationService(final CallDurationService callDurationService) {
		this.callDurationService = callDurationService;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	
}
