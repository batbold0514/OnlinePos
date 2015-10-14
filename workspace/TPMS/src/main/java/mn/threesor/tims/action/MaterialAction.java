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

import mn.threesor.tims.model.Material;
import mn.threesor.tims.model.Messages;
import mn.threesor.tims.service.MaterialService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class MaterialAction extends ActionSupport implements Preparable,
		ModelDriven<Material>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Material materail = new Material();
	private MaterialService materailService;
	private List<Material> listOfMaterials;
	private int materailHash;
	private HttpServletRequest request;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Material getModel() {
		return materail;
	}

	public void prepare() throws Exception {
		if (materail != null && materail.getId() != null) {
			this.materail = materailService.get(materail.getId());
			this.materailHash = materail.hashCode();
		}
	}

	public void setMaterialService(final MaterialService materialService) {
		this.materailService = materialService;
	}

	@Action(value = "material", results = { @Result(name = "success", type = "tiles", location = "/material.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "materials", results = { @Result(name = "success", type = "tiles", location = "/material-list.tiles") })
	public String list() throws Exception {
		this.setListOfMaterials(materailService.findAll());
		return SUCCESS;
	}

	@Action(value = "material-list-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-material/material-list-ajax.jsp") })
	public String list1() {
		this.setListOfMaterials(materailService.findAll());
		return SUCCESS;
	}

	@Action(value = "save-material-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-material/material-add-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-material/material-add-ajax.jsp") })
	public String save() throws Exception {
		try {
			if (materail != null && materailHash != materail.hashCode()) {
				if (materail.getPrefix().equals("")
						|| materail.getPrefix().length() != 2) {
					addFieldError("prefix",
							Messages.getString("material.empty"));
					return INPUT;
				}
				if (materailService.hasCunjaction(materail.getId(),
						materail.getPrefix())) {
					addFieldError("prefix", Messages.getString("material.cunj"));
					return INPUT;
				}
				materailService.saveOrUpdate(materail);
				materailService.log(materail, "saveOrUpadate");
				request.setAttribute("materialSuccess", SUCCESS);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("prefix", Messages.getString("material.cunj"));
		}
		return INPUT;
	}

	public List<Material> getListOfMaterials() {
		return listOfMaterials;
	}

	public void setListOfMaterials(List<Material> listOfMaterials) {
		this.listOfMaterials = listOfMaterials;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
