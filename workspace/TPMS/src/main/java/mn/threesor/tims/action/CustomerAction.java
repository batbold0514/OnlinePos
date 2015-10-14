/*package mn.threesor.tims.action;

import java.util.ArrayList;
import java.util.List;

import mn.threesor.tims.model.Customer;
import mn.threesor.tims.service.CustomerService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin") })
public class CustomerAction extends ActionSupport
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
	@SkipValidation
	@Action(value = "get-customerList-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-customer/customer-list-result.jsp") })
	public String getList() throws Exception {
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
}*/