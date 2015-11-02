package mn.infosystems.enquire.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import mn.infosystems.enquire.model.Customer;
import mn.infosystems.enquire.model.EnquireModel;
import mn.infosystems.enquire.model.EnquireType;
import mn.infosystems.enquire.model.ItemName;
import mn.infosystems.enquire.service.CustomerService;
import mn.infosystems.enquire.service.EnquireModelService;
import mn.infosystems.enquire.service.EnquireTypeService;
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
public class EnquireModelAction extends ActionSupport implements Preparable,
ModelDriven<EnquireModel>, ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private EnquireModel enquireModel = new EnquireModel();
	private EnquireModelService enquireModelService;
	private List<EnquireModel> listOfModel;
	private int enquireModelHash;
	private EnquireTypeService enquireTypeService;
	private String enquiretypeString;
	private String priceStr;
	private String enquireNameString;
	private CustomerService customerService;
	private ItemNameService itemNameService;
	private List<String> itemNameString = new LinkedList<String>();
	
	@SkipValidation
	@Action(value = "enquireModelLists", results = { @Result(name = "success", type = "tiles", location = "/enquireModel-list.tiles") })
	public String list() throws Exception {
		listOfModel = enquireModelService.findAll();
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "get-enquireModel-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/enquireModel/enquireModel-list-result.jsp") })
	public String getList() throws Exception {
		listOfModel = enquireModelService.findAll();
		return SUCCESS;
	}
	
	@Action(value = "save-enquireModel-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/enquireModel/enquireModel-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/enquireModel/enquireModel-result.jsp") })
	public String save2() throws Exception {
		try {
				enquireModel.setEnquireType(enquireTypeService.getEnquireType(enquiretypeString));
				enquireModel.setPrice(Double.parseDouble(priceStr));
				enquireModel.setCustomer(customerService.getCustomer(enquireNameString));
			List<ItemName> list = new LinkedList<ItemName>();
				/*for(int i = 0 ; i < itemNameString.size()-1;i++){
					ItemName item = new ItemName();
					item = itemNameService.get(Long.parseLong(itemNameString.get(i)));
					list.add(item);
					itemNameService.saveOrUpdate(item);
				}*/
				enquireModel.setListOfItemName(list);
				enquireModelService.saveOrUpdate(enquireModel);
				request.setAttribute("successenquireModel", "true");
				return SUCCESS;
		} catch (Exception e) {
			addFieldError("enquiretypeString", "Unique");
		}
		return INPUT;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public EnquireModel getModel() {
		return enquireModel;
	}

	public void prepare() throws Exception {
		if(enquireModel != null && enquireModel.getId()!=null){
			enquireModel = enquireModelService.get(enquireModel.getId());
			enquireModelHash = enquireModel.hashCode();
		}
	}

	public List<EnquireModel> getListOfModel() {
		return listOfModel;
	}

	public void setEnquireModelService(final EnquireModelService enquireModelService) {
		this.enquireModelService = enquireModelService;
	}

	public void setEnquireTypeService(final EnquireTypeService enquireTypeService) {
		this.enquireTypeService = enquireTypeService;
	}
	public List<EnquireType> getEnquireTypes(){
		return enquireTypeService.findAll();
	}

	public String getEnquiretypeString() {
		return enquiretypeString;
	}

	public void setEnquiretypeString(String enquiretypeString) {
		this.enquiretypeString = enquiretypeString;
	}

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}

	public String getEnquireNameString() {
		return enquireNameString;
	}

	public void setEnquireNameString(String enquireNameString) {
		this.enquireNameString = enquireNameString;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}
	public List<Customer> getCustomers(){
		return customerService.findAll();
	}

	public void setItemNameService(final ItemNameService itemNameService) {
		this.itemNameService = itemNameService;
	}
	public List<ItemName> getItemNames(){
		return itemNameService.findAll();
	}

	public List<String> getItemNameString() {
		return itemNameString;
	}

	public void setItemNameString(List<String> itemNameString) {
		this.itemNameString = itemNameString;
	}
	
	

	
}
