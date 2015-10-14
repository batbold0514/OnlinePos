package mn.threesor.tims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.model.Colour;
import mn.threesor.tims.model.Messages;
import mn.threesor.tims.service.ColourService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
public class ColourAction extends ActionSupport implements Preparable,
		ModelDriven<Colour>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Colour colour = new Colour();
	private ColourService colourService;
	private List<Colour> colourList;
	private int colourHash;
	private HttpServletRequest request;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Colour getModel() {
		return colour;
	}

	public void prepare() throws Exception {
		if (colour != null && colour.getId() != null) {
			this.colour = colourService.get(colour.getId());
			this.colourHash = colour.hashCode();
		}
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public List<Colour> getColourList() {
		return colourList;
	}

	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	@SkipValidation
	@Action(value = "colourList", results = { @Result(name = "success", type = "tiles", location = "/colour-list.tiles") })
	public String list() throws Exception {
		this.colourList = colourService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "color-list-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-color/color-list-ajax.jsp") })
	public String lis1t() throws Exception {
		this.colourList = colourService.findAll();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "addColour", results = { @Result(name = "success", type = "tiles", location = "/colour.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "save-color-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-color/add-color-ajax.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-color/add-color-ajax.jsp") })
	public String save() throws Exception {
		try {
			if (colour != null && colour.hashCode() != colourHash) {
				if(colourService.hasConjuction(colour)){
					addFieldError("code", Messages.getString("colour.input"));
					return INPUT;
				}
				colourService.saveOrUpdate(colour);
				colourService.log(colour, "save");
				request.setAttribute("colorSuccess", SUCCESS);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("code", Messages.getString("colour.input"));
		}
		return INPUT;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
