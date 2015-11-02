package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.DateIndex;
import mn.infosystems.callcenter.service.DateIndexService;

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
@Namespaces(value = { @Namespace("/admin"), @Namespace("/senior") })
public class DateIndexAction extends ActionSupport implements Preparable,
		ModelDriven<DateIndex>, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DateIndex dateIndex = new DateIndex();
	private HttpServletRequest request;
	private DateIndexService dateIndexService;
	private int dateIndexHash;
	private List<DateIndex> listOfDateIndex;
	private String statusStr;
	private String deleteId;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public DateIndex getModel() {
		return dateIndex;
	}

	public void prepare() throws Exception {
		if (dateIndex != null && dateIndex.getId() != null) {
			dateIndex = dateIndexService.get(dateIndex.getId());
			dateIndexHash = dateIndex.hashCode();
		}
	}

	public DateIndex getDateIndex() {
		return dateIndex;
	}

	public void setDateIndex(DateIndex dateIndex) {
		this.dateIndex = dateIndex;
	}

	public List<DateIndex> getListOfDateIndex() {
		return listOfDateIndex;
	}

	public void setDateIndexService(final DateIndexService dateIndexService) {
		this.dateIndexService = dateIndexService;
	}

	@SkipValidation
	@Action(value = "dateIndexsList", results = { @Result(name = "success", type = "tiles", location = "/dateIndex-list.tiles") })
	public String execute() {
		listOfDateIndex = dateIndexService.findAll();
		if (!listOfDateIndex.isEmpty()
				&& listOfDateIndex.get(0).getStatus()
						.equals(StatusEnum.inActive))
			statusStr = "false";
		else
			statusStr = "true";
		return SUCCESS;
	}

	@Action(value = "save-dateIndex-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/dateIndex/dateIndex-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/dateIndex/dateIndex-result.jsp") })
	public String save() {
		if (dateIndex != null && dateIndex.hashCode() != dateIndexHash) {
			if (dateIndexService.checkInterval(dateIndex.getMin(),
					dateIndex.getId())) {
				addFieldError("min", "interval");
				return INPUT;
			}
			if (dateIndexService.checkInterval(dateIndex.getMax(),
					dateIndex.getId())) {
				addFieldError("max", "interval");
				return INPUT;
			}
			if (dateIndexService.getStatus().equals("true"))
				dateIndex.setStatus(StatusEnum.active);
			else
				dateIndex.setStatus(StatusEnum.inActive);
			dateIndexService.saveOrUpdate(dateIndex);
			request.setAttribute("dateIndexSuccess", true);
			return SUCCESS;
		}
		return INPUT;
	}

	@SkipValidation
	@Action(value = "dateIndexs-result-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/dateIndex/dateIndex-list-result.jsp") })
	public String list() {
		listOfDateIndex = dateIndexService.findAll();
		return SUCCESS;
	}

	@Action(value = "update-date-index-status", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/dateIndex/dateIndex-list-result.jsp") })
	public String updateStatus() {
		if (statusStr.equals("true"))
			dateIndexService.updateStatus(StatusEnum.active.getId());
		else
			dateIndexService.updateStatus(StatusEnum.inActive.getId());
		return SUCCESS;
	}

	@Action(value = "delete-date-index", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/dateIndex/dateIndex-list-result.jsp") })
	public String delete() {
		dateIndexService.delete(dateIndexService.get(Long.parseLong(deleteId)));
		listOfDateIndex = dateIndexService.findAll();
		return SUCCESS;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}

}
