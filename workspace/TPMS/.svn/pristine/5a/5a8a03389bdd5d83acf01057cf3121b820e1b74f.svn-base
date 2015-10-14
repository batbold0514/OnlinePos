package mn.threesor.tims.action;

import java.util.List;

import mn.threesor.tims.model.StollPrice;
import mn.threesor.tims.service.StollPriceService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin") })
public class StollPriceAction extends ActionSupport
{
	private StollPrice stollPrice = new StollPrice();
	private StollPriceService stollPriceService;
	private List<StollPrice> listOfPrices;
	
	
	public List<StollPrice> getListOfPrices() {
		return listOfPrices;
	}
	@Override
	@Action(value = "stoll-price", results =
		{
			@Result(name = "success", type = "tiles", location = "/stoll-price.tiles")
		})
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	@Action(value = "get-stollPriceList-ajax", results =
		{
			@Result(name = "success",location = "/WEB-INF/content/ajax-stoll-price/stoll-price-list-result.jsp")
		})
	public String execute1() throws Exception
	{
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public StollPrice getStollPrice()
	{
		List<StollPrice> stollPriceList = stollPriceService.getCurrentSession().getNamedQuery("StollPrice.getRealStollPrice").list();
		if (stollPriceList != null && stollPriceList.size() != 0)
		{
			stollPrice = stollPriceList.get(0);
		}
		else
		{
			stollPrice = null;
		}
		return stollPrice;
	}
	public void setStollPrice(StollPrice stollPrice)
	{
		this.stollPrice = stollPrice;
	}

	public StollPriceService getStollPriceService()
	{
		return stollPriceService;
	}
	public void setStollPriceService(StollPriceService stollPriceService)
	{
		this.stollPriceService = stollPriceService;
	}
}