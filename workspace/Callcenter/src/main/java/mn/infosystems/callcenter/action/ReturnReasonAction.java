package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.model.ReturnReason;
import mn.infosystems.callcenter.service.ReturnReasonService;

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
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/senior")})
public class ReturnReasonAction extends ActionSupport implements Preparable,ModelDriven<ReturnReason>,ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReturnReason reason = new ReturnReason();
	private ReturnReasonService returnReasonService;
	private int returnReasonHash;
	private HttpServletRequest request;
	public List<ReturnReason> listOfReasons;
	private String deleteId;
	
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public ReturnReason getModel() {
		return reason;
	}

	public void prepare() throws Exception {
		if(reason!=null && reason.getId()!=null){
			this.reason = returnReasonService.get(reason.getId());
			this.returnReasonHash = reason.hashCode();
		}
	}
	
	
	public ReturnReason getReason() {
		return reason;
	}

	public void setReason(ReturnReason reason) {
		this.reason = reason;
	}

	public void setReturnReasonService(final ReturnReasonService returnReasonService) {
		this.returnReasonService = returnReasonService;
	}

	@Action(value="returnReason",results={@Result(name="success",type="tiles",location="/return-reason.tiles")})
	public String list() throws Exception{
		listOfReasons = returnReasonService.findAll();
		return SUCCESS;
	}
	
	@Action(value="save-returnReason-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/return-reason/return-reason.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/return-reason/return-reason.jsp")})
	public String save() throws Exception{
		if(reason!=null && reason.hashCode()!=returnReasonHash){
			returnReasonService.saveOrUpdate(reason);
			request.setAttribute("returnReasonSuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="return-result-list-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/return-reason/return-reason-list.jsp")})
	public String listAjax() throws Exception{
		listOfReasons = returnReasonService.findAll();
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value="delete-return-reason",results={@Result(name="success",location="/WEB-INF/content/ajax/return-reason/return-reason-list.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/return-reason/return-reason.jsp")})
	public String delete(){
		try{
			returnReasonService.delete(returnReasonService.get(Long.parseLong(deleteId)));
			listOfReasons = returnReasonService.findAll();
		}catch(Exception e){
			request.setAttribute("returnReasonSuccess", SUCCESS);
			return INPUT;
		}
		return SUCCESS;
	}
	
	public List<ReturnReason> getListOfReasons(){
		return listOfReasons;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
}
