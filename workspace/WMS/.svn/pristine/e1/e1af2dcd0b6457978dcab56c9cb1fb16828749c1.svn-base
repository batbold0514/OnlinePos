package mn.threesor.wms.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.ProductionStep;
import mn.threesor.wms.service.ProductionStepService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class ProductionStepAction extends ActionSupport implements Preparable,
		ModelDriven<ProductionStep> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductionStepService psService;
	private ProductionStep productionStep = new ProductionStep();
	private int ProductionStepHash;
	private List<ProductionStep> listOfPS;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public ProductionStep getModel() {
		return productionStep;
	}

	public void prepare() throws Exception {
		if (productionStep != null && productionStep.getId() != null) {
			productionStep = psService.get(productionStep.getId());
			ProductionStepHash = productionStep.hashCode();

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

	@Action(value = "saveProductionStep", results = {
			@Result(name = "success", type = "redirectAction", location = "productionSteps"),
			@Result(name = "input", type = "tiles", location = "/productionStep.tiles") })
	public String save() {
		if (productionStep != null
				&& ProductionStepHash != productionStep.hashCode()) {
			if(productionStep.getName().trim().equals("")){
				addFieldError("name", Messages.getString("productionStep.name"));
				return INPUT;
			}
			if(psService.check(productionStep.getName(),productionStep.getId())){
				addFieldError("name", Messages.getString("productionStep.override"));
				return INPUT;
			}
			psService.saveOrUpdate(productionStep);
			return SUCCESS;
		}
		return INPUT;
	}

}
