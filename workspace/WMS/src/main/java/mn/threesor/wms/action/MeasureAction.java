package mn.threesor.wms.action;

import java.util.List;

import mn.threesor.wms.model.Measure;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.service.MeasureService;

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
public class MeasureAction extends ActionSupport implements Preparable, ModelDriven<Measure>
{
	private static final long serialVersionUID = 1L;
	private Measure measure = new Measure();
	private MeasureService measureService;
	private int measureHash;
	private List<Measure> listOfMeasure;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Measure getModel()
	{
		return measure;
	}

	public void prepare() throws Exception
	{
		if (measure != null && measure.getId() != null)
		{
			this.measure = measureService.get(measure.getId());
			this.measureHash = measure.hashCode();
		}
	}

	public List<Measure> getListOfMeasure()
	{
		return listOfMeasure;
	}

	public void setMeasureService(final MeasureService measureService)
	{
		this.measureService = measureService;
	}

	public Measure getMeasure()
	{
		return measure;
	}
	public void setMeasure(Measure measure)
	{
		this.measure = measure;
	}
	
	@SkipValidation
	@Action(value = "measure", results =
	{
		@Result(name = "success", type = "tiles", location = "/measure.tiles")
	})
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "measure-list", results =
	{
		@Result(name = "success", type = "tiles", location = "/measure-list.tiles")
	})
	public String list() throws Exception
	{
		this.listOfMeasure = measureService.findAll();
		return SUCCESS;
	}
	
	@Action(value = "save-measure", results =
	{
		@Result(name = "success", type = "redirectAction", location = "measure-list"),
		@Result(name = "input", type = "tiles", location = "/measure.tiles")
	})
	public String save() throws Exception
	{
		try
		{
			if (measure != null && measure.hashCode() != measureHash)
			{
				if(measureService.check(measure.getId(), measure.getMeasuringUnit()))
				{
					addFieldError("measuringUnit", Messages.getString("measureConjuction"));
					return INPUT;
				}
				measureService.saveOrUpdate(measure);
				return SUCCESS;
			}
		}
		catch (Exception e)
		{
			addFieldError("measuringUnit", Messages.getString("measureConjuction"));
		}
		return INPUT;
	}
}