package mn.infosystems.estimator.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.estimator.model.CarFactory;
import mn.infosystems.estimator.service.CarFactoryService;
import mn.infosystems.estimator.service.EstimateLoggerService;

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
@Namespaces(value = { @Namespace("/admin"),@Namespace("/employee") })
public class CarFactoryAction extends ActionSupport implements Preparable,
		ModelDriven<CarFactory>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private CarFactory carFactory = new CarFactory();
	private CarFactoryService carFactoryService;
	private List<CarFactory> carFactoryList;
	private HttpServletRequest request;
	private int carFactoryHash;

	@Action(value="car-factory",results={@Result(name="success",type="tiles",location="/carfactory.tiles")})
	public String list() {
		this.carFactoryList = carFactoryService.findAll();
		return SUCCESS;
	}

	@Action(value="car-factory-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/carfactory/carfactory-list.jsp")})
	public String listAjax() {
		this.carFactoryList = carFactoryService.findAll();
		return SUCCESS;
	}

	@Action(value="car-factory-save",results={@Result(name="success",location="/WEB-INF/content/ajax/carfactory/carfactory-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/carfactory/carfactory-result.jsp")})
	public String save() {
		if (carFactory != null && carFactoryHash != carFactory.hashCode()) {
			carFactoryService.saveOrUpdate(carFactory);
			request.setAttribute("carfactorySuccess", SUCCESS);
			EstimateLoggerService.writeLog(carFactory);
			return SUCCESS;
		}
		return INPUT;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public CarFactory getModel() {
		return carFactory;
	}

	public void prepare() throws Exception {
		if (carFactory != null && carFactory.getId() != null) {
			this.carFactory = carFactoryService.get(carFactory.getId());
			this.carFactoryHash = carFactory.hashCode();
		}
	}

	public CarFactory getCarFactory() {
		return carFactory;
	}

	public void setCarFactory(CarFactory carFactory) {
		this.carFactory = carFactory;
	}

	public List<CarFactory> getCarFactoryList() {
		return carFactoryList;
	}

	public void setCarFactoryService(final CarFactoryService carFactoryService) {
		this.carFactoryService = carFactoryService;
	}

}
