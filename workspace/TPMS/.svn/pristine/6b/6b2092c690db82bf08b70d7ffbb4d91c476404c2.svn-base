package mn.threesor.tims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.Occupation;
import mn.threesor.tims.service.OccupationService;

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
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class OccupationAction extends ActionSupport implements Preparable,
		ModelDriven<Occupation>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Occupation occupation = new Occupation();
	private OccupationService occupationService;
	private List<Occupation> occupationList;
	private int occupationHash;
	private HttpServletRequest request;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Occupation getModel() {
		return occupation;
	}

	public void prepare() throws Exception {
		if (occupation != null && occupation.getId() != null) {
			this.occupation = occupationService.get(occupation.getId());
			this.occupationHash = occupation.hashCode();
		}
	}

	public void setOccupationService(final OccupationService occupationService) {
		this.occupationService = occupationService;
	}


	@SkipValidation
	@Action(value = "occupationList", results = { @Result(name = "success", type = "tiles", location = "/occupation-list.tiles") })
	public String list() throws Exception {
		this.setOccupationList(occupationService.findAll());
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "occupation-list-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-occupation/occupation-list-ajax.jsp") })
	public String list1() throws Exception {
		this.setOccupationList(occupationService.findAll());
		return SUCCESS;
	}

	@Action(value = "save-occupation-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-occupation/occupation-add-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-occupation/occupation-add-ajax.jsp") })
	public String save() throws Exception {
		try {
			if (occupation != null && occupation.hashCode() != occupationHash) {
				/*
				 * if(occupation.getName().trim().equals("")){
				 * addFieldError("name", Messages.getString("occupationinput"));
				 * return INPUT; }
				 */
				if (occupationService.checkCunjuction(occupation.getId(),
						occupation.getName())) {
					addFieldError("name", Messages.getString("occupation"));
					return INPUT;
				}
				occupationService.saveOrUpdate(occupation);
				occupationService.log(occupation, "saveOrUpdate");
				request.setAttribute("ocSuccess", SUCCESS);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("name", Messages.getString("occupation"));
			return INPUT;
		}
		return INPUT;
	}

	public List<Occupation> getOccupationList() {
		return occupationList;
	}

	public void setOccupationList(List<Occupation> occupationList) {
		this.occupationList = occupationList;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
