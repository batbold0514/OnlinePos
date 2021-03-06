package mn.threesor.wms.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.wms.enums.OutputArticleActivity;
import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.Employee;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.OutputArticle;
import mn.threesor.wms.model.ProductionStep;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.CustomerService;
import mn.threesor.wms.service.EmployeeService;
import mn.threesor.wms.service.OutputArticleService;
import mn.threesor.wms.service.ProductionStepService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class OutputArticleAction extends ActionSupport implements Preparable,
		ModelDriven<OutputArticle>, SessionAware {
	private static final long serialVersionUID = 1L;
	private OutputArticle outputArticle = new OutputArticle();
	private OutputArticleService outputArticleService;
	private ArticleService articleService;
	private EmployeeService employeeService;
	private ProductionStepService psService;
	private CustomerService customerService;
	private int outputArticleHash;
	private List<OutputArticle> outputArticleList;
	private Article outArticle;
	private String articleString;
	private String fromString;
	private String customerString;
	private String articleName;
	private String articleBarCode;
	private List<Article> articleSearchList;
	private Map<String, Object> m;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public OutputArticle getModel() {
		return outputArticle;
	}

	public void prepare() throws Exception {
		if (outputArticle != null && outputArticle.getId() != null) {
			articleString = outputArticle.getId().toString().trim();
			this.outputArticle = outputArticleService
					.get(outputArticle.getId());
			if (outArticle != null) {
				this.outputArticleHash = outputArticle.hashCode();
			} else {
				outputArticle = new OutputArticle(articleService.get(Long
						.parseLong(articleString)));
				this.outputArticleHash = outputArticle.hashCode();
			}
		}
	}

	
	public String getArticleBarCode() {
		return articleBarCode;
	}

	public void setArticleBarCode(String articleBarCode) {
		this.articleBarCode = articleBarCode;
	}

	public OutputArticle getOutputArticle() {
		return outputArticle;
	}

	public void setOutputArticle(OutputArticle outputArticle) {
		this.outputArticle = outputArticle;
	}

	public int getOutputArticleHash() {
		return outputArticleHash;
	}

	public void setOutputArticleHash(int outputArticleHash) {
		this.outputArticleHash = outputArticleHash;
	}

	public List<OutputArticle> getOutputArticleList() {
		return outputArticleList;
	}

	public void setOutputArticleList(List<OutputArticle> outputArticleList) {
		this.outputArticleList = outputArticleList;
	}

	public void setOutputArticleService(
			final OutputArticleService outputArticleService) {
		this.outputArticleService = outputArticleService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setPsService(final ProductionStepService psService) {
		this.psService = psService;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public void setCustomerService(final CustomerService customerService){
		this.customerService = customerService;
	}

	@SkipValidation
	@Action(value = "outputArticle", results =
	{
		@Result(name = "success", type = "tiles", location = "/output-article.tiles"),
		@Result(name = "error", type = "redirectAction", location = "articleList")
	})
	public String execute() throws Exception
	{
		if (articleString == null)
		{
			return ERROR;
		}
		
		articleName = articleService.get(Long.parseLong(articleString)).getName();
		m.put("articleName", outputArticle.getArticle().getName());
		m.put("articleBarCode", outputArticle.getArticle().getBarCode());
		if (outputArticle.getArticle().getSize() != null )
			m.put("articleSize", outputArticle.getArticle().getSize().getId());
		else
			m.put("articleSize", -1l);
		
		if (outputArticle.getArticle().getColour() != null )
			m.put("articleCode", outputArticle.getArticle().getColour().getCode());
		else
			m.put("articleCode", "");
		
		if (outputArticle.getArticle().getLocation() != null)
			m.put("articleLocation", outputArticle.getArticle().getLocation().getId());
		else
			m.put("articleLocation", -1l);
		
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "outList", results = { @Result(name = "success", type = "tiles", location = "/output-article-list.tiles") })
	public String list() throws Exception {
		this.outputArticleList = outputArticleService.getOutputArticleFinish();
		return SUCCESS;
	}

	@Action(value = "doOutputArticle", results = {
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", type = "redirectAction", location = "articleListSession"),
			@Result(name = "input", type = "tiles", location = "/output-article.tiles") })
	public String save() throws Exception {
		if (outputArticle != null
				&& outputArticle.hashCode() != outputArticleHash) {

			
			boolean hasError = false;
			
			if (fromString.equals("")) {
				addFieldError("fromString",
						Messages.getString("fromSB"));
				hasError = true;
			}
			
			if(customerString.equals("")){
				addFieldError("outputCustomer", Messages.getString("customer"));
				hasError = true;
			}
			
			if(hasError) return INPUT;
			
			outputArticle.setOutDate(new Date());
			if (!articleString.equals(""))
				outArticle = articleService.get(Long.parseLong(articleString
						.trim()));
			if (!fromString.equals(""))
				outputArticle.setFrom(employeeService.get(Long
						.parseLong(fromString.trim())));
			outputArticle.setCustomer(customerService.get(Long.parseLong(customerString)));
			outputArticle.setNumber(outputArticleService
					.getOutputArticleNumber(OutputArticleActivity.finish));
			if (outArticle.getCount() < outputArticle.getOutCount()) {
				addFieldError("outCount",
						Messages.getString("notEnoughArticleResourse"));
				return INPUT;
			}
			outArticle.setCount(outArticle.getCount()
					- outputArticle.getOutCount());
			outputArticle.setStatus(OutputArticleActivity.finish);
			outputArticle.setArticle(outArticle);
			articleService.saveOrUpdate(outArticle);
			outputArticleService.saveOrUpdate(outputArticle);
			return SUCCESS;
		}
		return INPUT;
	}

	public List<Employee> getEmployeeList() {
		return employeeService.getAvailableEmployee();
	}

	public List<Article> getArticleList() {
		return articleService.findAll();
	}

	public List<ProductionStep> getProductionSteps() {
		return psService.findAll();
	}

	public String getArticleString() {
		return articleString;
	}

	public void setArticleString(String articleString) {
		this.articleString = articleString;
	}

	public String getFromString() {
		return fromString;
	}

	public void setFromString(String formString) {
		this.fromString = formString;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}


	public List<Article> getArticleSearchList() {
		return articleSearchList;
	}

	public void setArticleSearchList(List<Article> articleSearchList) {
		this.articleSearchList = articleSearchList;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}
	
	public List<Customer> getCustomers(){
		return customerService.findAll();
	}

	public String getCustomerString() {
		return customerString;
	}

	public void setCustomerString(String customerString) {
		this.customerString = customerString;
	}
}
