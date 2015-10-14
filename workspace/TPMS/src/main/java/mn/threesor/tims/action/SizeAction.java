package mn.threesor.tims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.Size;
import mn.threesor.tims.service.SizeService;

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
@Namespaces(value = { @Namespace("/admin") })
public class SizeAction extends ActionSupport implements Preparable,
		ModelDriven<Size> , ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Size size = new Size();
	private SizeService sizeService;
	private List<Size> sizeList;
	private int sizeHash;
	private HttpServletRequest request;
	
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Size getModel() {
		return size;
	}

	public void prepare() throws Exception {
		if (size != null && size.getId() != null) {
			this.size = sizeService.get(size.getId());
			this.sizeHash = size.hashCode();
		}
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	public List<Size> getSizeList() {
		return sizeList;
	}

	@SkipValidation
	@Action(value = "sizeList", results = { @Result(name = "success", type = "tiles", location = "/size-list.tiles") })
	public String List() throws Exception {
		this.sizeList = sizeService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "size-list-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-size/size-list-ajax.jsp") })
	public String List1() throws Exception {
		this.sizeList = sizeService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "addSize", results = { @Result(name = "success", type = "tiles", location = "/size.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "save-size-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-size/size-add-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-size/size-add-ajax.jsp") })
	public String save() throws Exception {
		if (size != null && size.hashCode() != sizeHash) {
			if (sizeService.check(size.getSizes(), size.getId())) {
				addFieldError("sizes", Messages.getString("size.input"));
				return INPUT;
			}
			sizeService.saveOrUpdate(size);
			sizeService.log(size, "saveOrUpdate");
			request.setAttribute("sizeSuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
