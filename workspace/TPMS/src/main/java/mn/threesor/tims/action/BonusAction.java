package mn.threesor.tims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import mn.threesor.tims.model.Bonus;
import mn.threesor.tims.model.Messages;
import mn.threesor.tims.service.BonusService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class BonusAction extends ActionSupport implements Preparable,
		ModelDriven<Bonus>,ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private Bonus bonus = new Bonus();
	private BonusService bonusService;
	private int bonusHash;
	private List<Bonus> bonusList;
	private HttpServletRequest request;
	
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Bonus getModel() {
		return bonus;
	}

	public void prepare() throws Exception {
		if (bonus != null && bonus.getId() != null) {
			this.bonus = bonusService.get(bonus.getId());
			this.bonusHash = bonus.hashCode();
		}
	}

	public void setBonusService(final BonusService bonusService) {
		this.bonusService = bonusService;
	}

	public List<Bonus> getBonusList() {
		return bonusList;
	}

	public void setBonusList(List<Bonus> bonusList) {
		this.bonusList = bonusList;
	}

	@SkipValidation
	@Action(value = "bonus", results = { @Result(name = "success", type = "tiles", location = "/bonus.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "bonusList", results = { @Result(name = "success", type = "tiles", location = "/bonus-list.tiles") })
	public String list() throws Exception {
		this.bonusList = bonusService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "bonus-list-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-bonus/bonus-list-ajax.jsp") })
	public String lis1t() throws Exception {
		this.bonusList = bonusService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-bonus-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-bonus/bonus-add-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-bonus/bonus-add-ajax.jsp") })
	public String save() throws Exception {
		try {
			if (bonus != null && bonus.hashCode() != bonusHash) {
				bonusService.saveOrUpdate(bonus);
				bonusService.log(bonus, "saveOrUpdate");
				request.setAttribute("bonusSuccess", SUCCESS);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("name", Messages.getString("bonus.name"));
			return INPUT;
		}
		return INPUT;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
