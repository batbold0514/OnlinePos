package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.model.Reason;
import mn.infosystems.callcenter.service.ReasonService;

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
@Namespaces(value = { @Namespace("/admin"), @Namespace("/senior") })
public class ReasonAction extends ActionSupport implements Preparable,
		ModelDriven<Reason>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Reason reason = new Reason();
	private ReasonService reasonService;
	private List<Reason> reasonList;
	private int reasonHash;
	private HttpServletRequest request;
	private String deleteId;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Reason getModel() {
		return reason;
	}

	public void prepare() throws Exception {
		if (reason != null && reason.getId() != null) {
			this.reason = reasonService.get(reason.getId());
			this.reasonHash = reason.hashCode();
		}
	}

	public void setReasonService(final ReasonService reasonService) {
		this.reasonService = reasonService;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public List<Reason> getReasonList() {
		return reasonList;
	}

	@SkipValidation
	@Action(value = "reasons", results = { @Result(name = "success", type = "tiles", location = "/reason-list.tiles") })
	public String list() throws Exception {
		this.reasonList = reasonService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "list-result-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/reason/reason-list-result.jsp") })
	public String list1() throws Exception {
		this.reasonList = reasonService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-reason-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/reason/reason-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/reason/reason-result.jsp") })
	public String save() throws Exception {
		if (reason != null && reason.hashCode() != reasonHash) {
			try {
				reasonService.saveOrUpdate(reason);
				request.setAttribute("successReason", true);
				return SUCCESS;
			} catch (Exception e) {
				addFieldError("description", "Unique");
			}
		}
		return INPUT;
	}

	@SkipValidation
	@Action(value = "delete-reason", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/reason/reason-list-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/reason/reason-result.jsp") })
	public String delete() {
		try {
			reasonService.delete(reasonService.get(Long.parseLong(deleteId)));
			this.reasonList = reasonService.findAll();
		} catch (Exception e) {
			request.setAttribute("successReason", true);
			return INPUT;
		}
		return SUCCESS;
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
