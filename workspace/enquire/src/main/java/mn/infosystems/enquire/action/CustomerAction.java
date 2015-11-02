package mn.infosystems.enquire.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.enquire.model.Customer;
import mn.infosystems.enquire.model.Users;
import mn.infosystems.enquire.service.CustomerService;
import mn.infosystems.enquire.service.UsersService;

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
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>,Preparable,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Customer customer = new Customer();
	private HttpServletRequest request;
	private List<Customer> listOfCustomer;
	private CustomerService customerService;
	private int customerhash;
	private UsersService usersService;
	private String usersString;

	@SkipValidation
	@Action(value = "customerList", results = { @Result(name = "success", type = "tiles", location = "/customer-list.tiles") })
	public String list() throws Exception {
		listOfCustomer = customerService.findAll();
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "get-customer-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax/customer/customer-list-result.jsp") })
	public String getList() throws Exception {
		listOfCustomer = customerService.findAll();
		return SUCCESS;
	}
	
	@Action(value = "save-customer-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax/customer/customer-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax/customer/customer-result.jsp") })
	public String save2() throws Exception {
		try {
				if(!usersString.equals(""))
					customer.setUser(usersService.getUser(usersString));
				customerService.saveOrUpdate(customer);
				request.setAttribute("successCustomer", "true");
				return SUCCESS;
		} catch (Exception e) {
			addFieldError("enquireName", "Unique");
		}
		return INPUT;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void prepare() throws Exception {
		if(customer !=null && customer.getId()!=null){
			customer = customerService.get(customer.getId());
			customerhash = customer.hashCode();
		}
			
	}

	public Customer getModel() {
		return customer;
	}

	public List<Customer> getListOfCustomer() {
		return listOfCustomer;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}
	
	public List<Users> getUsers(){
		return usersService.findAll();
	}

	public String getUsersString() {
		return usersString;
	}

	public void setUsersString(String usersString) {
		this.usersString = usersString;
	}

}
