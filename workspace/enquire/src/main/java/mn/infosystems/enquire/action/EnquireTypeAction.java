package mn.infosystems.enquire.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.enquire.model.EnquireType;
import mn.infosystems.enquire.service.EnquireTypeService;

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
@Namespaces(value = { @Namespace("/admin"),@Namespace("/users") })
public class EnquireTypeAction extends ActionSupport implements Preparable,
ModelDriven<EnquireType>, ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private EnquireType enquireType =new EnquireType(); 
	private EnquireTypeService enquireTypeService;
	private int enquireHash;
	private List<EnquireType> listOfType;
	
	
	
	
	@SkipValidation
	@Action(value = "enquireTypeLists", results = { @Result(name = "success", type = "tiles", location = "/enquireType-list.tiles") })
	public String list() throws Exception {
		listOfType = enquireTypeService.findAll();
		return SUCCESS;
	}
	@SkipValidation
	@Action(value = "get-enquireType-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/enquireType/enquireType-list-result.jsp") })
	public String getList() throws Exception {
		listOfType = enquireTypeService.findAll();
		return SUCCESS;
	}
	
	@Action(value = "save-enquireType-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/enquireType/enquireType-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/enquireType/enquireType-result.jsp") })
	public String save2() throws Exception {
		try {
			enquireTypeService.saveOrUpdate(enquireType);
			request.setAttribute("successenquireType", "true");
			return SUCCESS;
		} catch (Exception e) {
			addFieldError("description", "Unique");
		}
		return INPUT;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public EnquireType getModel() {
		return enquireType;
	}

	public void prepare() throws Exception {
		if(enquireType != null && enquireType.getId() != null){
			enquireType = enquireTypeService.get(enquireType.getId());
			enquireHash = enquireType.hashCode();
		}
	}

	public void setEnquireTypeService(final EnquireTypeService enquireTypeService) {
		this.enquireTypeService = enquireTypeService;
	}

	public List<EnquireType> getListOfType() {
		return listOfType;
	}
	
	

}
