package mn.infosystems.estimator.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import mn.infosystems.estimator.model.Customer;
import mn.infosystems.estimator.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/user"),@Namespace("/employee") })
public class RegisterSearchAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	private List<Customer> customerList;
	private String registerStr;
	
	@Action(value="register-search",results={@Result(name="success",type="tiles",location="/search-register.tiles")})
	public String list(){
		return SUCCESS;
	}
	
	@Action(value="search-register",results={@Result(name="success",type="tiles",location="/search-register.tiles")})
	public String search(){
		this.customerList = customerService.getRegNumber(registerStr);
		return SUCCESS;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}


	public String getRegisterStr() {
		return registerStr;
	}


	public void setRegisterStr(String registerStr) {
		this.registerStr = registerStr;
	}
	
	

}
