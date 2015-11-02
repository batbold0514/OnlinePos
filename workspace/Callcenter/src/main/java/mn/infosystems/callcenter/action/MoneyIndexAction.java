package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.MoneyIndex;
import mn.infosystems.callcenter.service.MoneyIndexService;

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
public class MoneyIndexAction extends ActionSupport implements Preparable,
		ModelDriven<MoneyIndex>, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MoneyIndex moneyIndex = new MoneyIndex();
	private int moneyIndexHash;
	private List<MoneyIndex> listOfMoneyIndex;
	private MoneyIndexService moneyIndexService;
	private HttpServletRequest request;
	private String statusStr;
	private String deleteId;
	
	public MoneyIndex getMoneyIndex() {
		return moneyIndex;
	}

	public void setMoneyIndex(MoneyIndex moneyIndex) {
		this.moneyIndex = moneyIndex;
	}

	public List<MoneyIndex> getListOfMoneyIndex() {
		return listOfMoneyIndex;
	}

	public void setMoneyIndexService(final MoneyIndexService moneyIndexService) {
		this.moneyIndexService = moneyIndexService;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public MoneyIndex getModel() {
		return this.moneyIndex;
	}

	public void prepare() throws Exception {
		if (moneyIndex != null && moneyIndex.getId() != null) {
			moneyIndex = moneyIndexService.get(moneyIndex.getId());
			moneyIndexHash = moneyIndex.hashCode();
		}
	}

	@SkipValidation
	@Action(value = "moneyIndexsList", results = { @Result(name = "success", type = "tiles", location = "/moneyIndex-list.tiles") })
	public String excutue() {
		listOfMoneyIndex = moneyIndexService.findAll();
		if (!listOfMoneyIndex.isEmpty()
				&& listOfMoneyIndex.get(0).getStatus()
						.equals(StatusEnum.inActive))
			statusStr = "false";
		else
			statusStr = "true";
		return SUCCESS;
	}

	@Action(value = "save-moneyIndex-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/moneyIndex/moneyIndex-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/moneyIndex/moneyIndex-result.jsp") })
	public String save() {

		if (moneyIndex != null && moneyIndex.hashCode() != moneyIndexHash) {
			if (moneyIndexService.checkInterval(moneyIndex.getMin(),
					moneyIndex.getId())) {
				addFieldError("min", "interval");
				return INPUT;
			}
			if (moneyIndexService.checkInterval(moneyIndex.getMax(),
					moneyIndex.getId())) {
				addFieldError("max", "interval");
				return INPUT;
			}
			if (moneyIndexService.getStatus().equals("true"))
				moneyIndex.setStatus(StatusEnum.active);
			else
				moneyIndex.setStatus(StatusEnum.inActive);
			moneyIndexService.saveOrUpdate(moneyIndex);
			request.setAttribute("moneyIndexSuccess", true);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="delete-money-index",results={@Result(name="success",location="/WEB-INF/content/ajax/moneyIndex/moneyIndex-list-result.jsp")})
	public String delete(){
		moneyIndexService.delete(moneyIndexService.get(Long.parseLong(deleteId)));
		listOfMoneyIndex = moneyIndexService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "moneyIndexs-result-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/moneyIndex/moneyIndex-list-result.jsp") })
	public String list() {
		listOfMoneyIndex = moneyIndexService.findAll();
		return SUCCESS;
	}

	@Action(value = "change-money-index-status", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/moneyIndex/moneyIndex-result.jsp") })
	public String changeStatus() {
		if (statusStr.equals("true"))
			moneyIndexService.updateStatus(StatusEnum.active.getId());
		else
			moneyIndexService.updateStatus(StatusEnum.inActive.getId());
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
