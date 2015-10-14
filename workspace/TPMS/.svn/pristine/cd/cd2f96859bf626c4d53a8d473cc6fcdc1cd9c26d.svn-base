package mn.threesor.tims.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.model.Customer;
import mn.threesor.tims.model.Messages;
import mn.threesor.tims.service.CustomerService;

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

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin") })
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
public class CustomerAddAction extends ActionSupport implements Preparable, ModelDriven<Customer>, ServletRequestAware
{
	private Customer customer = new Customer();
	private CustomerService customerService;
	private int customerHash;
	private List<Customer> customerList = new ArrayList<Customer>();
	private HttpServletRequest request;
	
	public Customer getModel()
	{
		return customer;
	}

	public void prepare() throws Exception
	{
		if(customer != null && customer.getId() != null)
		{
			customer = customerService.get(customer.getId());
			customerHash = customer.hashCode();
		}
	}
	
	@Override
	@Action(value = "customer-list", results =
		{
			@Result(name = "success", type = "tiles", location = "/customer-list.tiles")
		})
	public String execute() throws Exception
	{
		customerList = customerService.findAll();
		return SUCCESS;
	}
	@SkipValidation
	@Action(value = "get-customerList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-customer/customer-list-result.jsp") })
	public String getList() throws Exception {
		customerList = customerService.findAll();
		return SUCCESS;
	}

	@Action(value = "save-customer-ajax", results =
		{
			@Result(name = "success", location = "/WEB-INF/content/ajax-customer/customer-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-customer/customer-result.jsp")
		})
	public String save() throws Exception
	{
		if (customer != null && customerHash != customer.hashCode())
		{
			if (customer.getName() == null || customer.getName().trim().equalsIgnoreCase(""))
			{
				addFieldError("name", Messages.getString("inputEmpty"));
				return INPUT;
			}
			
			if (customerService.check(customer.getName(), customer.getId()))
			{
				addFieldError("name", Messages.getString("unsuccessful"));
				return INPUT;
			}

			request.setAttribute("successCustomer", "true");
			customerService.saveOrUpdate(customer);
			return SUCCESS;
		}
		return INPUT;
	}
	

	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public CustomerService getCustomerService()
	{
		return customerService;
	}
	public void setCustomerService(final CustomerService customerService)
	{
		this.customerService = customerService;
	}
	public List<Customer> getCustomerList()
	{
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList)
	{
		this.customerList = customerList;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}
	
}