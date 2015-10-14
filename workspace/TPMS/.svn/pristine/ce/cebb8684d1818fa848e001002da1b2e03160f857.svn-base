package mn.threesor.tims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.service.ProductionStepService;

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
@Namespaces(value = { @Namespace("/user"), @Namespace("/admin") })
public class ProductionStepAction extends ActionSupport implements Preparable,
		ModelDriven<ProductionStep>, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductionStepService psService;
	private ProductionStep productionStep = new ProductionStep();
	private int productionStepHash;
	private List<ProductionStep> listOfPS;
	private HttpServletRequest request;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public ProductionStep getModel() {
		return productionStep;
	}

	public void prepare() throws Exception {
		if (productionStep != null && productionStep.getId() != null) {
			productionStep = psService.get(productionStep.getId());
			productionStepHash = productionStep.hashCode();

		}
	}

	public ProductionStep getProductionStep() {
		return productionStep;
	}

	public void setProductionStep(ProductionStep productionStep) {
		this.productionStep = productionStep;
	}

	public List<ProductionStep> getListOfPS() {
		return listOfPS;
	}

	public void setPsService(final ProductionStepService psService) {
		this.psService = psService;
	}

	@Override
	@SkipValidation
	@Action(value = "productionStep", results = { @Result(name = "success", type = "tiles", location = "/productionStep.tiles") })
	public String execute() {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "productionSteps", results = { @Result(name = "success", type = "tiles", location = "/productionStep-list.tiles") })
	public String list() {
		listOfPS = psService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "productionStep-list-ajax1", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-production-step/productionStep-list-ajax.jsp") })
	public String list1() throws Exception {
		listOfPS = psService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "save-productionStep-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-production-step/productionStep-add-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-production-step/productionStep-add-ajax.jsp") })
	public String save() {
		try {
			if (productionStep != null
					&& productionStepHash != productionStep.hashCode()) {
				if (productionStep.getName().trim().equals("")) {
					addFieldError("name", Messages.getString("inputEmpty"));
					return INPUT;
				}
				if (psService.hasConjuction(productionStep.getId(),
						productionStep.getName())) {
					addFieldError("name",
							Messages.getString("productionStep.name"));
					return INPUT;
				}
				psService.saveOrUpdate(productionStep);
				psService.log(productionStep, "save");
				request.setAttribute("successPS", SUCCESS);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("name", Messages.getString("productionStep.name"));
		}
		return INPUT;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
