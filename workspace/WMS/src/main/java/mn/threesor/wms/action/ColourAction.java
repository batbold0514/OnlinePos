package mn.threesor.wms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.wms.model.Colour;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.service.ColourService;

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

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class ColourAction extends ActionSupport implements Preparable, ModelDriven<Colour>, ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	
	private Colour colour = new Colour();
	private ColourService colourService;
	private List<Colour> colourList;
	private int colourHash;
	private HttpServletRequest request;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Colour getModel()
	{
		return colour;
	}

	public void prepare() throws Exception
	{
		if (colour != null && colour.getId() != null)
		{
			this.colour = colourService.get(colour.getId());
			this.colourHash = colour.hashCode();
		}
	}

	public Colour getColour()
	{
		return colour;
	}
	public void setColour(Colour colour)
	{
		this.colour = colour;
	}

	public List<Colour> getColourList()
	{
		return colourList;
	}

	public void setColourService(final ColourService colourService)
	{
		this.colourService = colourService;
	}

	@SkipValidation
	@Action(value = "colour-list", results =
	{
		@Result(name = "success", type = "tiles", location = "/colour-list.tiles")
	})
	public String list() throws Exception
	{
		this.colourList = colourService.findAll();
		return SUCCESS;
	}

	@Override
	@SkipValidation
	@Action(value = "colour", results =
	{
		@Result(name = "success", type = "tiles", location = "/colour.tiles")
	})
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	@Action(value = "save-colour", results =
	{
		@Result(name = "error", type = "tiles", location = "/licence.tiles"),
		@Result(name = "success", type = "redirectAction", location = "colour-list"),
		@Result(name = "input", type = "tiles", location = "/colour.tiles")
	})
	public String save() throws Exception
	{
			
		if (colour != null && colour.hashCode() != colourHash)
		{
			if(colourService.check(colour.getCode(),colour.getId()))
			{
				addFieldError("code", Messages.getString("colorOverride"));
				return INPUT;
			}
			colourService.saveOrUpdate(colour);
			return SUCCESS;
		}
		return INPUT;
	}
	
	/*@Action(value = "save-colour-ajax", results =
	{
		@Result(name = "success", location = "/WEB-INF/content/colour-result.jsp"),
		@Result(name = "input", location = "/WEB-INF/content/colour-result.jsp")
	})
	public String save2() throws Exception
	{		
		if (colour != null && colour.hashCode() != colourHash)
		{
			if(colourService.check(colour.getCode(),colour.getId()))
			{
				addFieldError("code", Messages.getString("colorOverride"));
				return INPUT;
			}
			colourService.saveOrUpdate(colour);
			request.setAttribute("successColour", "true");
			return SUCCESS;
		}
		return INPUT;
	}*/

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest()
	{
		return request;
	}
}
