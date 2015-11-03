package mn.infosystems.estimator.action;

import java.util.List;
import java.util.Map;

import mn.infosystems.estimator.model.Customer;
import mn.infosystems.estimator.service.CustomerService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/employee"),@Namespace("/user") })
public class NumberSearchAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	private List<Customer> cusotmerList;
	private String numberString;
	private Map<String, Object> session;
	private Long id;
	
	@Action(value="number-search",results={@Result(name="success",type="tiles",location="/search-number.tiles")})
	public String list() {
		session.put("print", new Customer());
		return SUCCESS;
	}
	
	@Action(value="search-number",results={@Result(name="success",type="tiles",location="/search-number.tiles")})
	public String search(){
		this.cusotmerList = customerService.getCnumber(numberString);
		return SUCCESS;
	}
	@Action(value="print-image",results={@Result(name="success",location="/WEB-INF/content/ajax/customer/print-image.jsp")})
	public String printImage(){
		session.put("print", customerService.get(id));
		return SUCCESS;
	}
	@Action(value="print-test",results={@Result(name="success",location="/WEB-INF/content/print.jsp")})
	public String print(){
		session.put("print", customerService.get(id));
		return SUCCESS;
	}
	
	public String getNumberString() {
		return numberString;
	}
	public void setNumberString(String numberString) {
		this.numberString = numberString;
	}
	public List<Customer> getCusotmerList() {
		return cusotmerList;
	}
	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
