package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.model.CallQuantity;
import mn.infosystems.callcenter.service.CallQuantityService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/senior")})
public class CallQuantityAction extends ActionSupport implements Preparable,
ModelDriven<CallQuantity>,ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CallQuantity callQuantity = new CallQuantity();
	private CallQuantityService callQuantityService;
	private int callQuantityHash;
	private List<CallQuantity> listOfCallQuantity;
	private HttpServletRequest request;
	
	public CallQuantity getModel() {
		return callQuantity;
	}

	public void prepare() throws Exception {
		if(callQuantity!=null && callQuantity.getId()!=null){
			callQuantity = callQuantityService.get(callQuantity.getId());
			callQuantityHash = callQuantity.hashCode();
		}
	}

	public CallQuantity getCallQuantity() {
		return callQuantity;
	}

	public void setCallQuantity(CallQuantity callQuantity) {
		this.callQuantity = callQuantity;
	}

	public void setCallQuantityService(final CallQuantityService callQuantityService) {
		this.callQuantityService = callQuantityService;
	}

	public List<CallQuantity> getListOfCallQuantity() {
		return listOfCallQuantity;
	}
 
	@SkipValidation
	@Action(value = "callQuantitys" , results= {@Result (name = "success" , type = "tiles" , location = "/callQuantity-list.tiles")})
	public String execute(){
		listOfCallQuantity = callQuantityService.findAll();
		return SUCCESS;
	}
	@Action(value="save-callQuantity-ajax",results={
			@Result(name = "success",location="/WEB-INF/content/ajax/callQuantity/callQuantity-result.jsp"),
			@Result(name = "input",location="/WEB-INF/content/ajax/callQuantity/callQuantity-result.jsp")
	})
	public String save(){
		if(callQuantity!=null && callQuantity.hashCode() != callQuantityHash){
			callQuantityService.saveOrUpdate(callQuantity);
			request.setAttribute("callQuantitySuccess", true);
			return SUCCESS;
		}
		return INPUT;
	}
	@SkipValidation
	@Action(value="callQuantity-result-ajax",results={
			@Result(name = "success",location="/WEB-INF/content/ajax/callQuantity/callQuantity-list-result.jsp")})
	public String list(){
		listOfCallQuantity= callQuantityService.findAll();
		return SUCCESS;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
