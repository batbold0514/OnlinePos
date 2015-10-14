package mn.threesor.wms.action;

import java.util.List;

import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.Size;
import mn.threesor.wms.service.SizeService;

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
public class SizeAction extends ActionSupport implements Preparable, ModelDriven<Size>
{
	private static final long serialVersionUID = 1L;
	private Size size = new Size();
	private SizeService sizeService;
	private List<Size> sizeList;
	private int sizeHash;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Size getModel()
	{
		return size;
	}

	public void prepare() throws Exception
	{
		if (size != null && size.getId() != null)
		{
			this.size = sizeService.get(size.getId());
			this.sizeHash = size.hashCode();
		}
	}

	public Size getSize()
	{
		return size;
	}
	public void setSize(Size size)
	{
		this.size = size;
	}

	public void setSizeService(final SizeService sizeService)
	{
		this.sizeService = sizeService;
	}

	public List<Size> getSizeList()
	{
		return sizeList;
	}

	@SkipValidation
	@Action(value = "size-list", results =
	{
		@Result(name = "success", type = "tiles", location = "/size-list.tiles")
	})
	public String List() throws Exception
	{
		this.sizeList = sizeService.findAll();
		return SUCCESS;
	}
	
	@Override
	@SkipValidation
	@Action(value = "size", results =
	{
		@Result(name = "success", type = "tiles", location = "/size.tiles")
	})
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	@Action(value = "save-size", results =
	{
		@Result(name = "success", type = "redirectAction", location = "size-list"),
		@Result(name = "input", type = "tiles", location = "/size.tiles")
	})
	public String save() throws Exception
	{
		if (size != null && size.hashCode() != sizeHash)
		{
			if (sizeService.check(size.getSizes(), size.getId()))
			{
				addFieldError("sizes", Messages.getString("sizeOverride"));
				return INPUT;
			}
			sizeService.saveOrUpdate(size);
			return SUCCESS;
		}
		return INPUT;
	}
}