package mn.threesor.wms.action;

import java.util.List;
import java.util.Map;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.Employee;
import mn.threesor.wms.model.InputArticle;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.CustomerService;
import mn.threesor.wms.service.EmployeeService;
import mn.threesor.wms.service.InputArticleService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

/**
 * @author info
 * 
 */
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class InputArticleEditAction extends ActionSupport implements
		Preparable, ModelDriven<InputArticle>, SessionAware {

	private static final long serialVersionUID = 1L;
	private InputArticleService inputArticleService;
	private InputArticle inputArticle = new InputArticle();
	private int inputArticleHash;
	private List<InputArticle> inputArticleList;
	private ArticleService articleService;
	private EmployeeService employeeService;
	private CustomerService customerService;
	private double beforeCount;
	private Map<String, Object> m;

	public InputArticle getModel() {
		return inputArticle;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void prepare() throws Exception {
		if (inputArticle != null && inputArticle.getId() != null) {
			this.inputArticle = inputArticleService.get(inputArticle.getId());
			this.inputArticleHash = inputArticle.hashCode();
		}
	}

	public InputArticle getInputArticle() {
		return inputArticle;
	}

	public void setInputArticle(InputArticle inputArticle) {
		this.inputArticle = inputArticle;
	}

	public void setInputArticleService(
			final InputArticleService inputArticleService) {
		this.inputArticleService = inputArticleService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public void setCustomerService(final CustomerService customerService){
		this.customerService = customerService;
	}

	@Action(value = "editInputArticle", results = { @Result(name = "success", type = "tiles", location = "/input-article-edit.tiles") })
	public String execute() throws Exception {
		setBeforeCount(inputArticle.getAddCount());
		m.put("InputArticle", inputArticle);
		return SUCCESS;
	}


	@Action(value = "saveEdit", results = {
			@Result(name = "success", type = "redirectAction", location = "inputArticleList"),
			@Result(name = "input", type = "tiles", location = "/input-article-edit.tiles") })
	public String edit() throws Exception {
		if (inputArticle != null && inputArticle.hashCode() != inputArticleHash) {
			if (getBeforeCount() - inputArticle.getAddCount() > inputArticle
					.getArticle().getCount()) {
				addFieldError("addCount",
						Messages.getString("InputArticle.count"));
				return INPUT;
			}
			Article article = articleService.get((inputArticle.getArticle().getId()));
			article.setCount(article.getCount() - getBeforeCount()
					+ inputArticle.getAddCount());
			articleService.update(article);
			m.remove("InputArticle");
			inputArticleService.update(inputArticle);
			return SUCCESS;
		}
		return INPUT;
	}

	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	public void setSession(Map<String, Object> m) {
		this.m = m;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public List<InputArticle> getInputArticleList() {
		return inputArticleList;
	}

	public double getBeforeCount() {
		return beforeCount;
	}

	public void setBeforeCount(double beforeCount) {
		this.beforeCount = beforeCount;
	}
	
	public List<Customer> getCustomers(){
		return customerService.findAll();
	}

}
