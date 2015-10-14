package mn.chinbat.surgery.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.ServicePrice;
import mn.chinbat.surgery.service.ServicePriceService;
import mn.chinbat.surgery.service.SsmLoggerService;

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
public class ServicePriceAction extends ActionSupport implements Preparable,
		ModelDriven<ServicePrice>, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServicePriceService servicePriceService;

	private ServicePrice servicePrice = new ServicePrice();
	private List<ServicePrice> pricelist;
	private int priceHash;
	private HttpServletRequest request;
	private String priceStr;
	SsmLoggerService ssm = new SsmLoggerService();

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}

	public ServicePrice getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(final ServicePrice servicePrice) {
		this.servicePrice = servicePrice;
	}

	public List<ServicePrice> getPricelist() {
		return pricelist;
	}

	public void setServicePriceService(ServicePriceService servicePriceService) {
		this.servicePriceService = servicePriceService;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public ServicePrice getModel() {
		return servicePrice;
	}

	public void prepare() throws Exception {
		if ((servicePrice != null) && (servicePrice.getId() != null)) {
			this.servicePrice = servicePriceService.get(servicePrice.getId());
			this.priceHash = servicePrice.hashCode();
		}
	}


	@Action(value = "linkPrices", results = { @Result(name = "success", type = "tiles", location = "/price-list.tiles") })
	@SkipValidation
	public String list() throws Exception {
		this.pricelist = servicePriceService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-price-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-service-price/service-price-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-service-price/service-price-ajax.jsp") })
	public String saveAjax() throws Exception {
		if (servicePrice.hashCode() != priceHash) {
			if (servicePriceService.checkActive(servicePrice.getCode()) == 0) {
				try{
					servicePrice.setPrice(Integer.parseInt(priceStr));
				}catch(NumberFormatException numberFormatException){
					addFieldError("priceStr", Messages.getString("numberEmpty"));
					return INPUT;
				}
				servicePriceService.saveOrUpdate(servicePrice);
				ssm.logInfo(servicePrice);
				request.setAttribute("priceSuccess", SUCCESS);
				return SUCCESS;
			} else {
				addFieldError("code", Messages.getString("doubleCode"));
				return INPUT;
			}
		}
		return INPUT;
	}

	@SkipValidation
	@Action(value = "service-price-list", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-service-price/service-price-list.jsp") })
	public String list1() throws Exception {
		this.pricelist = servicePriceService.findAll();
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
