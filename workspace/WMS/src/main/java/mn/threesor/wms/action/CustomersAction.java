package mn.threesor.wms.action;

import java.util.ArrayList;
import java.util.List;

import mn.threesor.wms.model.Customer;
import mn.threesor.wms.service.CustomerService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin"),@Namespace("/user") })
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"), @InterceptorRef("paramsPrepareParamsStack") })
public class CustomersAction extends ActionSupport
{
	private CustomerService customerService;
	private List<Customer> customerList = new ArrayList<Customer>();
	
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

	public CustomerService getCustomerService()
	{
		return customerService;
	}
	public void setCustomerService(CustomerService customerService)
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
}