package mn.threesor.wms.action;

import java.util.List;

import mn.threesor.wms.model.Customer;
import mn.threesor.wms.service.CustomerService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAjaxAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String customerName;
	private CustomerService customerService;
	private List<Customer> listOfCustomer;
	private Customer customer = new Customer();
	private Long customerId;
	
	@Action(value = "addCustomerInArticle", results = { @Result(name = "success",location = "move-ajax-customer-jsp",type="redirectAction") })
	public String saveCustomer() throws Exception {
		try {
			customer.setName(customerName);
			if (customer.getName().trim().equalsIgnoreCase("")
					|| customer.getName() == null) {
				return SUCCESS;
			}
			if (customerService.check(customer.getName(), customer.getId())) {
				return SUCCESS;
			}
			setCustomerId(customerService.save(customer));
		} catch (Exception e) {
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	@Action(value="move-ajax-customer-jsp",results={@Result(name = "success", location = "/WEB-INF/content/ajax-customer.jsp")})
	public String list() throws Exception{
		setListOfCustomer(customerService.findAll());
		setCustomerId(customerService.getLassAddId());
		return SUCCESS;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public List<Customer> getListOfCustomer() {
		return listOfCustomer;
	}

	public void setListOfCustomer(List<Customer> listOfCustomer) {
		this.listOfCustomer = listOfCustomer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
