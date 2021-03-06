package mn.infosystems.estimator.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.estimator.model.CarFactory;
import mn.infosystems.estimator.model.CarMark;
import mn.infosystems.estimator.service.CarFactoryService;
import mn.infosystems.estimator.service.CarMarkService;
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
@Namespaces(value = { @Namespace("/admin") ,@Namespace("/employee")})
public class CarMarkAction extends ActionSupport implements Preparable,
		ModelDriven<CarMark>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private CarMark carMark = new CarMark();
	private CarMarkService carMarkService;
	private CarFactoryService carFactoryService;
	private List<CarMark> carMarkList;
	private int carMarkHash;
	private HttpServletRequest request;
	private String factoryStr;

	@Action(value = "car-mark", results = { @Result(name = "success", type = "tiles", location = "/carmark.tiles") })
	public String list() {
		this.carMarkList = carMarkService.findAll();
		return SUCCESS;
	}

	@Action(value = "car-mark-list", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/carmark/carmark-list.jsp") })
	public String listAjax() {
		this.carMarkList = carMarkService.findAll();
		return SUCCESS;
	}

	@Action(value = "car-mark-save", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/carmark/carmark-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/carmark/carmark-result.jsp") })
	public String save() {
		if (carMark != null && carMark.hashCode() != carMarkHash) {
			carMark.setFactory(carFactoryService.get(Long.parseLong(factoryStr)));
			carMarkService.saveOrUpdate(carMark);
			request.setAttribute("carmarkSuccess", SUCCESS);
			EstimateLoggerService.writeLog(carMark);
			return SUCCESS;
		}
		return INPUT;
	}

	public List<CarFactory> getCarFactories() {
		return carFactoryService.findAll();
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public CarMark getModel() {
		return carMark;
	}

	public void prepare() throws Exception {
		if (carMark != null && carMark.getId() != null) {
			this.carMark = carMarkService.get(carMark.getId());
			this.carMarkHash = carMark.hashCode();
		}
	}

	public CarMark getCarMark() {
		return carMark;
	}

	public void setCarMark(CarMark carMark) {
		this.carMark = carMark;
	}

	public List<CarMark> getCarMarkList() {
		return carMarkList;
	}

	public void setCarMarkService(final CarMarkService carMarkService) {
		this.carMarkService = carMarkService;
	}

	public void setCarFactoryService(final CarFactoryService carFactoryService) {
		this.carFactoryService = carFactoryService;
	}

	public String getFactoryStr() {
		return factoryStr;
	}

	public void setFactoryStr(String factoryStr) {
		this.factoryStr = factoryStr;
	}

}
