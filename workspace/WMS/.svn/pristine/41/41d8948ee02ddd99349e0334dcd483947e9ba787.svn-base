package mn.threesor.wms.action;

import java.util.List;

import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.Occupation;
import mn.threesor.wms.service.OccupationService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class OccupationAction extends ActionSupport implements Preparable, ModelDriven<Occupation>
{
	private static final long serialVersionUID = 1L;
	private Occupation occupation = new Occupation();
	private OccupationService occupationService;
	private List<Occupation> occupationList;
	private int occupationHash;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Occupation getModel()
	{
		return occupation;
	}

	public void prepare() throws Exception
	{
		if (occupation != null && occupation.getId() != null)
		{
			this.occupation = occupationService.get(occupation.getId());
			this.occupationHash = occupation.hashCode();
		}
	}

	public void setOccupationService(final OccupationService occupationService)
	{
		this.occupationService = occupationService;
	}

	@Override
	@SkipValidation
	@Action(value = "occupation", results =
	{
		@Result(name = "success", type = "tiles", location = "/occupation.tiles")
	})
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "occupation-list", results =
	{
		@Result(name = "success", type = "tiles", location = "/occupation-list.tiles")
	})
	public String list() throws Exception
	{
		this.setOccupationList(occupationService.findAll());
		return SUCCESS;
	}

	@Action(value = "save-occupation", results =
	{
		@Result(name = "success", type = "redirectAction", location = "occupation-list"),
		@Result(name = "input", type = "tiles", location = "/occupation.tiles")
	})
	public String save() throws Exception
	{
		if (occupation != null && occupation.hashCode() != occupationHash)
		{
			if(occupationService.check(occupation.getName(),occupation.getId()))
			{
				addFieldError("name", Messages.getString("occuopationOverride"));
				return INPUT;
			}
			occupationService.saveOrUpdate(occupation);
			return SUCCESS;
		}
		return INPUT;
	}

	public List<Occupation> getOccupationList()
	{
		return occupationList;
	}

	public void setOccupationList(List<Occupation> occupationList)
	{
		this.occupationList = occupationList;
	}
}