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

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class ServicePriceAdminAction extends ActionSupport implements
		Preparable, ModelDriven<ServicePrice>, ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServicePriceService servicePriceService;
	private String priceStr;
	private ServicePrice servicePrice = new ServicePrice();
	private List<ServicePrice> pricelist;
	private int priceHash;
	private HttpServletRequest request;
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

	@Action(value="edit-price-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-service-price/service-price-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-service-price/service-price-ajax.jsp") })
	
	public String editAjax() throws Exception{
		if (servicePrice != null && servicePrice.hashCode() != priceHash) {
			if(servicePrice.getActive().equals("1")){
			if (servicePriceService.checkCodeAndId(servicePrice.getCode(),servicePrice.getId())) {
				
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
			else{
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
			}
		}
		return INPUT;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
