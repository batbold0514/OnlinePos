package mn.infosystems.callcenter.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.model.CallIndex;
import mn.infosystems.callcenter.service.CallIndexService;

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

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/senior")})
public class CallIndexAction extends ActionSupport implements Preparable,
ModelDriven<CallIndex> ,SessionAware ,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Map<String, Object> session;
	private CallIndex callIndexModel = new CallIndex();
	private int callIndexHash;
	private CallIndexService callIndexService;
	private List<CallIndex> listOfCallIndex;
	private HttpServletRequest request;
	
	public void setSession(Map<String, Object> session) {
		this.session= session;
	}


	public CallIndex getModel() {
		return callIndexModel;
	}

	public void prepare() throws Exception {
		if(callIndexModel!=null && callIndexModel.getId()!=null){
			callIndexModel = callIndexService.get(callIndexModel.getId());
			callIndexHash = callIndexModel.hashCode();
		}
	}




	public void setCallIndexService(final CallIndexService callIndexService) {
		this.callIndexService = callIndexService;
	}


	public List<CallIndex> getListOfCallIndex() {
		return listOfCallIndex;
	}
	
	
	
	public CallIndex getCallIndexModel() {
		return callIndexModel;
	}


	public void setCallIndexModel(CallIndex callIndexModel) {
		this.callIndexModel = callIndexModel;
	}


	@SkipValidation
	@Action(value = "callIndexs" , results= {@Result (name = "success" , type = "tiles" , location = "/callIndex-list.tiles")})
	public String execute(){
		listOfCallIndex = callIndexService.findAll();
		return SUCCESS;
	}
	
	@Action(value="save-callIndex-ajax",results={
			@Result(name = "success",location="/WEB-INF/content/ajax/callIndex/callIndex-result.jsp"),
			@Result(name = "input",location="/WEB-INF/content/ajax/callIndex/callIndex-result.jsp")
	})
	public String save(){
		if(callIndexModel!=null && callIndexModel.hashCode() != callIndexHash){
			callIndexService.saveOrUpdate(callIndexModel);
			request.setAttribute("callIndexSuccess", true);
			return SUCCESS;
		}
		return INPUT;
	}
	@SkipValidation
	@Action(value="callIndexs-result-ajax",results={
			@Result(name = "success",location="/WEB-INF/content/ajax/callIndex/callIndex-list-result.jsp")})
	public String list(){
		listOfCallIndex = callIndexService.findAll();
		return SUCCESS;
	}


	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
