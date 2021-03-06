package mn.threesor.wms.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.service.LocationWmsService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class LocationWmsAction extends ActionSupport implements Preparable, ModelDriven<LocationWms>
{
	private static final long serialVersionUID = 1L;
	private LocationWms location = new LocationWms();
	private LocationWmsService locationWmsService;
	private List<LocationWms> locationList;
	private int locationHash;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public LocationWms getModel()
	{
		return location;
	}

	public void prepare() throws Exception
	{
		if (location != null && location.getId() != null)
		{
			this.location = locationWmsService.get(location.getId());
			this.locationHash = location.hashCode();
		}
	}

	public void setLocationWmsService(final LocationWmsService locationWmsService)
	{
		this.locationWmsService = locationWmsService;
	}

	public LocationWms getLocation()
	{
		return location;
	}
	public void setLocation(LocationWms location)
	{
		this.location = location;
	}

	public List<LocationWms> getLocationList()
	{
		return locationList;
	}

	@Override
	@SkipValidation
	@Action(value = "location", results =
	{
		@Result(name = "success", type = "tiles", location = "/location.tiles")
	})
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "location-list", results =
	{
		@Result(name = "success", type = "tiles", location = "/location-list.tiles")
	})
	public String list() throws Exception
	{
		this.locationList = locationWmsService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-location", results =
	{
		@Result(name = "error", type = "tiles", location = "/licence.tiles"),
		@Result(name = "success", type = "redirectAction", location = "location-list"),
		@Result(name = "input", type = "tiles", location = "/location.tiles")
	})
	public String save() throws Exception
	{
		
		if (location != null && location.hashCode() != locationHash)
		{
			if (locationWmsService.check(location.getLocationName(), location.getId()))
			{
				addFieldError("locationName", Messages.getString("locationOverride"));
				return INPUT;
			}
			locationWmsService.saveOrUpdate(location);
			return SUCCESS;
		}
		return INPUT;
	}
}