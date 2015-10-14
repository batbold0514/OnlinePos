package mn.threesor.tims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.ProductType;
import mn.threesor.tims.service.ProductTypeService;

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
public class ProductTypeAction extends ActionSupport implements Preparable,
		ModelDriven<ProductType>, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductTypeService productTypeService;
	private ProductType productType = new ProductType();
	private List<ProductType> listPt;
	private int productTypeHash;
	private HttpServletRequest request;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public ProductType getModel() {
		return productType;
	}

	public void prepare() throws Exception {
		if (productType != null && productType.getId() != null) {
			this.productType = productTypeService.get(productType.getId());
			this.productTypeHash = productType.hashCode();
		}
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(
			final ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}



	@SkipValidation
	@Action(value = "productTypes", results = { @Result(name = "success", type = "tiles", location = "/productTypes.tiles") })
	public String list() {
		listPt = productTypeService.findAll();
		return SUCCESS;
	}
	@SkipValidation
	@Action(value = "get-product-typeList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-product-type/productType-list-result.jsp") })
	public String getList() throws Exception {
		listPt = productTypeService.findAll();
		return SUCCESS;
	}
	@Action(value = "save-product-type-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-product-type/productType-result.jsp"),
			@Result(name = "input",  location = "/WEB-INF/content/ajax-product-type/productType-result.jsp") })
	public String saveType() {
		try{
		if (productType != null && productTypeHash != productType.hashCode()) {
			request.setAttribute("successProductType", "true");
			productTypeService.saveOrUpdate(productType);
			productTypeService.log(productType, "saveOrUpdate");
			return SUCCESS;
		}
		}catch(Exception e){
			addFieldError("prefix", Messages.getString("prefixUnique"));
		}
		return INPUT;
	}

	public List<ProductType> getListPt() {
		return listPt;
	}

	public void setListPt(List<ProductType> listPt) {
		this.listPt = listPt;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}
}
