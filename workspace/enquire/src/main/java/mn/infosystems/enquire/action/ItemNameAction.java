package mn.infosystems.enquire.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.enquire.model.ItemName;
import mn.infosystems.enquire.service.ItemNameService;

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

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/users") })
public class ItemNameAction  extends ActionSupport implements ModelDriven<ItemName>,Preparable,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemName itemName = new ItemName();
	private ItemNameService itemNameService;
	private int itemNameHash;
	private List<ItemName> listOfItemName;
	private HttpServletRequest request;

	@SkipValidation
	@Action(value = "itemNameList", results = { @Result(name = "success", type = "tiles", location = "/itemName-list.tiles") })
	public String list() throws Exception {
		listOfItemName = itemNameService.findAll();
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "get-itemName-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/itemName/itemName-list-result.jsp") })
	public String getList() throws Exception {
		listOfItemName= itemNameService.findAll();
		return SUCCESS;
	}
	
	@Action(value = "save-itemName-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/itemName/itemName-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/itemName/itemName-result.jsp") })
	public String save2() throws Exception {
		try {
				itemNameService.saveOrUpdate(itemName);
				request.setAttribute("successitemName", "true");
				return SUCCESS;
		} catch (Exception e) {
			addFieldError("name", "Unique");
		}
		return INPUT;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void prepare() throws Exception {
		if(itemName!=null && itemName.getId()!=null){
			itemName = itemNameService.get(itemName.getId());
			itemNameHash = itemName.hashCode();
		}
	}

	public ItemName getModel() {
		return itemName;
	}

	public List<ItemName> getListOfItemName() {
		return listOfItemName;
	}

	public void setItemNameService(final ItemNameService itemNameService) {
		this.itemNameService = itemNameService;
	}

	
}
