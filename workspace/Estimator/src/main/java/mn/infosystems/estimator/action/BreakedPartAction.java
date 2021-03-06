package mn.infosystems.estimator.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.estimator.model.BreakedPart;
import mn.infosystems.estimator.service.BreakedPartService;

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
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/employee") })
public class BreakedPartAction extends ActionSupport implements Preparable,
		ModelDriven<BreakedPart>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private BreakedPart breakedPart = new BreakedPart();
	private BreakedPartService breakedPartService;
	private List<BreakedPart> breakedPartList;
	private int breakedPartHash;
	private HttpServletRequest request;
	private String partId;

	@Action(value = "breaked-part", results = { @Result(name = "success", type = "tiles", location = "/breaked-part.tiles") })
	public String list() {
		this.breakedPartList = breakedPartService.findAll();
		return SUCCESS;
	}

	@Action(value = "breaked-part-list", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/breakedpart/breaked-part-list.jsp") })
	public String listAjax() {
		this.breakedPartList = breakedPartService.findAll();
		return SUCCESS;
	}

	@Action(value = "breaked-part-save", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/breakedpart/breaked-part-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/breakedpart/breaked-part-result.jsp") })
	public String save() {
		if (breakedPart != null && breakedPart.hashCode() != breakedPartHash) {
			breakedPartService.saveOrUpdate(breakedPart);
			request.setAttribute("breakedPartSuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}

	@Action(value = "breaked-part-delete", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/breakedpart/breaked-part-list.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/breakedpart/breaked-part-list.jsp") })
	public String delete() {
		try {
			breakedPartService.delete(breakedPartService.get(Long
					.parseLong(partId)));
			this.breakedPartList = breakedPartService.findAll();
		} catch (Exception e) {
			this.breakedPartList = breakedPartService.findAll();
			return INPUT;
		}
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public BreakedPart getModel() {
		return breakedPart;
	}

	public void prepare() throws Exception {
		if (breakedPart != null && breakedPart.getId() != null) {
			this.breakedPart = breakedPartService.get(breakedPart.getId());
			this.breakedPartHash = breakedPart.hashCode();
		}
	}

	public BreakedPart getBreakedPart() {
		return breakedPart;
	}

	public void setBreakedPart(BreakedPart breakedPart) {
		this.breakedPart = breakedPart;
	}

	public List<BreakedPart> getBreakedPartList() {
		return breakedPartList;
	}

	public void setBreakedPartService(
			final BreakedPartService breakedPartService) {
		this.breakedPartService = breakedPartService;
	}

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

}
