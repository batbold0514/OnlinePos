package mn.threesor.tims.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.model.StepPrice;
import mn.threesor.tims.service.ProductModelService;
import mn.threesor.tims.service.ProductionStepService;
import mn.threesor.tims.service.StepPriceService;
import mn.threesor.tims.service.StollPriceService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/designer"),
		@Namespace("/user") })
public class ProductModelEditStepAction extends ActionSupport implements
		Preparable, ModelDriven<ProductModel>, SessionAware {
	private static final long serialVersionUID = 1L;
	private ProductModel productModel = new ProductModel();
	private ProductModelService productModelService;
	@SuppressWarnings("unused")
	private int modelHash;
	private ProductionStepService psService;
	private Map<String, Object> session;
	private List<ProductionStep> listOfStep;
	private List<Integer> listOfPrice;
	private StollPriceService stollPriceService;
	private StepPriceService stepPriceService;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public ProductModel getModel() {
		return productModel;
	}

	public void prepare() throws Exception {
		if (productModel != null && productModel.getId() != null) {
			this.productModel = productModelService.get(productModel.getId());
			this.modelHash = productModel.hashCode();
		}
	}

	public void setProductModelService(
			final ProductModelService productModelService) {
		this.productModelService = productModelService;
	}

	public void setPsService(final ProductionStepService psService) {
		this.psService = psService;
	}

	public void setStollPriceService(final StollPriceService stollPriceService) {
		this.stollPriceService = stollPriceService;
	}

	public void setStepPriceService(final StepPriceService stepPriceService) {
		this.stepPriceService = stepPriceService;
	}

	@Action(value = "editSteps", results = { @Result(name = "success", type = "tiles", location = "/productModel-edit-step.tiles") })
	public String execute() throws Exception {
		this.productModel = productModelService.get(productModel.getId());
		List<Long> list = new LinkedList<Long>();
		for (StepPrice sp : productModel.getListOfStepPrice()) {
			list.add(sp.getProductStep().getId());
		}
		session.put("psList", list);
		return SUCCESS;
	}

	@Action(value = "edit-next", results = {
			@Result(name = "success", type = "tiles", location = "/productModel-edit-step-next.tiles"),
			@Result(name = "input", type = "tiles", location = "/productModel-edit-step.tiles") })
	public String next() throws Exception {
		if (listOfStep.size() > 0) {
			for (ProductionStep ps : listOfStep) {
				ps.setName(psService.get(ps.getId()).getName());
			}
			Integer stoll = (int) (stollPriceService.getRealPrice()
					.getCostPrice() * productModelService.get(
					productModel.getId()).getStoll());
			session.put("stoll", stoll);
			session.put("listofs", listOfStep);
			return SUCCESS;
		}
		return INPUT;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "save-edit-step", results = { @Result(name = "success", type = "redirectAction", location = "productModels") })
	public String save() {
		List<StepPrice> list = new LinkedList<StepPrice>();
		productModel = productModelService.get(productModel.getId());
		listOfStep = (List<ProductionStep>) session.get("listofs");
		for(int i = 0;i<listOfStep.size()/2;i++){
			StepPrice stepPrice = new StepPrice();
			stepPrice.setPrice(listOfPrice.get(i));
			stepPrice.setProductStep(listOfStep.get(i));
			stepPriceService.saveOrUpdate(stepPrice);
			list.add(stepPrice);
		}
		List<StepPrice> list1 = productModel.getListOfStepPrice();
		productModel.setListOfStepPrice(list);
		productModelService.saveOrUpdate(productModel);
		for(StepPrice sp:list1){
			stepPriceService.delete(sp);
		}
		return SUCCESS;
	}

	public List<ProductionStep> getProductStepList() {
		return psService.findAll();
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ProductionStep> getListOfStep() {
		return listOfStep;
	}

	public void setListOfStep(List<ProductionStep> listOfStep) {
		this.listOfStep = listOfStep;
	}

	public List<Integer> getListOfPrice() {
		return listOfPrice;
	}

	public void setListOfPrice(List<Integer> listOfPrice) {
		this.listOfPrice = listOfPrice;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

}
