package mn.threesor.wms.action;

import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.service.CustomerService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
public class CustomerSaveAction extends ActionSupport implements Preparable, ModelDriven<Customer>
{
	private Customer customer = new Customer();
	private CustomerService customerService;
	private int customerHash;

	public Customer getModel()
	{
		return customer;
	}

	public void prepare() throws Exception
	{
		if (customer != null && customer.getId() != null)
		{
			customer = customerService.get(customer.getId());
			customerHash = customer.hashCode();
		}
	}

	@Override
	@Action(value = "customer", results =
	{
		@Result(name = "success", type = "tiles", location = "/customer.tiles")
	})
	public String execute()
	{
		return SUCCESS;
	}

	@Action(value = "save-customer", results =
	{
		@Result(name = "success", type = "redirectAction", location = "customer-list"),
		@Result(name = "input", type = "tiles", location = "/customer.tiles")
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
	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}
}