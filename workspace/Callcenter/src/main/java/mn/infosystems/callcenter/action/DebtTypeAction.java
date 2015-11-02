package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.DebtType;
import mn.infosystems.callcenter.service.DebtTypeService;

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
public class DebtTypeAction extends ActionSupport implements Preparable,
ModelDriven<DebtType>,ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DebtType debtType = new DebtType();
	private List<DebtType> listOfDebtType;
	private int debtTypeHash;
	private DebtTypeService debtTypeService;
	private HttpServletRequest request;
	private String statusString;
	
	public DebtType getDebtType() {
		return debtType;
	}
	public void setDebtType(DebtType debtType) {
		this.debtType = debtType;
	}
	public List<DebtType> getListOfDebtType() {
		return listOfDebtType;
	}
	public void setDebtTypeService(final DebtTypeService debtTypeService) {
		this.debtTypeService = debtTypeService;
	}
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public DebtType getModel() {
		return debtType;
	}
	public void prepare() throws Exception {
		if(debtType !=null && debtType.getId()!=null){
			this.debtType = debtTypeService.get(debtType.getId());
			debtTypeHash = debtType.hashCode();
		}
	}
	@SkipValidation
	@Action(value="debtTypes",results={@Result(name="success",type="tiles",location="/debtType-list.tiles")})
	public String list() throws Exception{
		this.listOfDebtType = debtTypeService.findAll();
		return SUCCESS;
	}
	@SkipValidation
	@Action(value="debtTypes-result-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/debtType/debtType-list-result.jsp")})
	public String list1() throws Exception{
		this.listOfDebtType = debtTypeService.findAll();
		return SUCCESS;
	}
	@Action(value="save-debtType-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/debtType/debtType-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/debtType/debtType-result.jsp")})
	public String save() throws Exception{
		try{
			if(debtType!=null && debtType.hashCode() != debtTypeHash){
				if(statusString.equals("1")) debtType.setStatus(StatusEnum.inActive);
				else debtType.setStatus(StatusEnum.active);
				debtTypeService.saveOrUpdate(debtType);
				request.setAttribute("successDebtType", "true");
				return SUCCESS;
			}
		}catch(Exception e){
			addFieldError("typeName", "Unique");
		}
		return INPUT;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public StatusEnum[] getStatuses(){
		return StatusEnum.values();
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
}
