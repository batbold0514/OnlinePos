package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.model.CallQuantity;
import mn.infosystems.callcenter.model.MaxPrice;
import mn.infosystems.callcenter.service.CallQuantityService;
import mn.infosystems.callcenter.service.MaxPriceService;

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
@Namespaces(value = { @Namespace("/admin"),@Namespace("/senior")})
public class MaxPriceAction extends ActionSupport implements Preparable,
ModelDriven<MaxPrice>,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaxPrice maxPrice = new MaxPrice();
	private MaxPriceService maxPriceService;
	private int maxPriceHash;
	private List<MaxPrice> listOfMaxPrice;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public MaxPrice getModel() {
		return maxPrice;
	}

	public void prepare() throws Exception {
		if(maxPrice!=null && maxPrice.getId()!=null){
			maxPrice = maxPriceService.get(maxPrice.getId());
			maxPriceHash = maxPrice.hashCode();
		}
	}
	@SkipValidation
	@Action(value = "maxPrices" , results= {@Result (name = "success" , type = "tiles" , location = "/maxPrice-list.tiles")})
	public String execute(){
		listOfMaxPrice = maxPriceService.findAll();
		return SUCCESS;
	}
	@Action(value="save-maxPrice-ajax",results={
			@Result(name = "success",location="/WEB-INF/content/ajax/maxPrice/maxPrice-result.jsp"),
			@Result(name = "input",location="/WEB-INF/content/ajax/maxPrice/maxPrice-result.jsp")
	})
	public String save(){
		if(maxPrice!=null && maxPrice.hashCode() != maxPriceHash){
			maxPriceService.saveOrUpdate(maxPrice);
			request.setAttribute("maxPriceSuccess", true);
			return SUCCESS;
		}
		return INPUT;
	}
	@SkipValidation
	@Action(value="maxPrice-result-ajax",results={
			@Result(name = "success",location="/WEB-INF/content/ajax/maxPrice/maxPrice-list-result.jsp")})
	public String list(){
		listOfMaxPrice= maxPriceService.findAll();
		return SUCCESS;
	}

	public MaxPrice getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(MaxPrice maxPrice) {
		this.maxPrice = maxPrice;
	}

	public List<MaxPrice> getListOfMaxPrice() {
		return listOfMaxPrice;
	}

	public void setMaxPriceService(final MaxPriceService maxPriceService) {
		this.maxPriceService = maxPriceService;
	}
	
}
