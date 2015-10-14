package mn.threesor.tims.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.StollPrice;
import mn.threesor.tims.service.StollPriceService;

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

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin") })
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
public class StollPriceAddAction extends ActionSupport implements Preparable, ModelDriven<StollPrice>, ServletRequestAware
{
	private StollPrice stollPrice = new StollPrice();
	private StollPriceService stollPriceService;
	private int stollPriceHash;
	private HttpServletRequest request;
	public StollPrice getModel()
	{
		return stollPrice;
	}

	public void prepare() throws Exception
	{
		if(stollPrice != null && stollPrice.getId() != null)
		{
			stollPrice = stollPriceService.get(stollPrice.getId());
			stollPriceHash = stollPrice.hashCode();
		}
	}
//	/WEB-INF/content/ajax-stoll-price/stoll-price-result.jsp
//	/WEB-INF/content/stoll-price.jsp
	@SuppressWarnings("unchecked")
	@Override
	@Action(value = "save-stoll-price-ajax", results =
		{
			@Result(name = "success" ,location="/WEB-INF/content/ajax-stoll-price/stoll-price-result.jsp"),
			@Result(name = "input" ,location="/WEB-INF/content/ajax-stoll-price/stoll-price-result.jsp")
		})
	public String execute() throws Exception
	{
		if (stollPrice != null && stollPriceHash != stollPrice.hashCode())
		{
			if (stollPrice.getCostPrice() == 0)
			{
				addFieldError("costPrice", Messages.getString("wrongInput"));
				return INPUT;
			}
			
			if (stollPrice.getSellPrice() == 0)
			{
				addFieldError("sellPrice", Messages.getString("wrongInput"));
				return INPUT;
			}
			
			if (stollPrice.getSellPrice() < stollPrice.getCostPrice())
			{
				addFieldError("sellPrice", Messages.getString("wrongPrice"));
				return INPUT;
			}
			
			List<StollPrice> stollPriceList = stollPriceService.getCurrentSession().getNamedQuery("StollPrice.getLastStollPrice").list();
			if ((stollPriceList.size() != 0) && (stollPriceList != null))
			{
				stollPriceList.get(0).setStatus(false);
				stollPriceService.saveOrUpdate(stollPriceList.get(0));
			}
			
			stollPrice.setStatus(true);
			stollPrice.setDate(new Date());
			request.setAttribute("successStollPrice", "true");
			stollPriceService.saveOrUpdate(stollPrice);
			return SUCCESS;
		}
		return INPUT;
	}

	@SuppressWarnings("unchecked")
	public StollPrice getStollPrice()
	{
		List<StollPrice> stollPriceList = stollPriceService.getCurrentSession().getNamedQuery("StollPrice.getRealStollPrice").list();
		if (stollPriceList != null && stollPriceList.size() != 0)
		{
			stollPrice = stollPriceList.get(0);
		}
		return stollPrice;
	}

	public StollPriceService getStollPriceService()
	{
		return stollPriceService;
	}
	public void setStollPriceService(StollPriceService stollPriceService)
	{
		this.stollPriceService = stollPriceService;
	}

	public int getStollPriceHash()
	{
		return stollPriceHash;
	}
	public void setStollPriceHash(int stollPriceHash)
	{
		this.stollPriceHash = stollPriceHash;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}
}