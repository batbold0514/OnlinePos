package mn.threesor.wms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.InputArticle;
import mn.threesor.wms.service.CustomerService;
import mn.threesor.wms.service.InputArticleService;

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
public class InputArticleAction extends ActionSupport implements
		ModelDriven<InputArticle>, Preparable, SessionAware {

	private static final long serialVersionUID = 1L;
	private InputArticle inputArticle = new InputArticle();
	private Article article = new Article();
	private InputArticleService inputArticleService;
	private CustomerService customerService;
	private int inputArticleHash;
	private List<InputArticle> inputArticleList;
	private Map<String, Object> m;
	private Date firstDate = getDateOfFirstDayOfMonth();
	private Date secondDate = new Date();

	public void prepare() throws Exception {
		if (inputArticle != null && inputArticle.getId() != null) {
			this.inputArticle = inputArticleService.get(inputArticle.getId());
			this.setInputArticleHash(inputArticle.hashCode());
		}
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public InputArticle getModel() {
		return inputArticle;
	}

	public void setInputArticleService(
			final InputArticleService inputArticleService) {
		this.inputArticleService = inputArticleService;
	}

	public void setCustomerService(final CustomerService customerService){
		this.customerService = customerService;
	}
	
	public int getInputArticleHash() {
		return inputArticleHash;
	}

	public void setInputArticleHash(int inputArticleHash) {
		this.inputArticleHash = inputArticleHash;
	}

	public InputArticle getInputArticle() {
		return inputArticle;
	}

	public void setInputArticle(InputArticle inputArticle) {
		this.inputArticle = inputArticle;
	}

	public List<InputArticle> getInputArticleList() {
		return inputArticleList;
	}

	public void setInputArticleList(List<InputArticle> inputArticleList) {
		this.inputArticleList = inputArticleList;
	}

	@SkipValidation
	@Action(value = "inputArticleShow", results = { @Result(name = "success", type = "tiles", location = "/input-article-show.tiles") })
	public String execute1() throws Exception {
		return SUCCESS;
	}

	@Action(value = "inputArticleList", results = { @Result(name = "success", type = "tiles", location = "/input-article-list.tiles") })
	public String list()
	{
		this.inputArticleList = inputArticleService.getListBetweenDate(firstDate, secondDate);
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public final Article getArticle() {
		return article;
	}

	public final void setArticle(Article article) {
		this.article = article;
	}

	private Date getDateOfFirstDayOfMonth()
	{
		Calendar cal = new GregorianCalendar();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	public String getFirstDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		date = this.firstDate;
		if (date != null)
		{
			return formatter.format(date);
		}
		return null;
	}
	public void setFirstDate(String firstDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try
		{
			if (!firstDate.equals(""))
				date = formatter.parse(firstDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		this.firstDate = date;
	}

	public String getSecondDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		date = this.secondDate;
		if (date != null)
		{
			return formatter.format(date);
		}
		return null;
	}
	public void setSecondDate(String secondDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try
		{
			if (!secondDate.equals(""))
				date = formatter.parse(secondDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		this.secondDate = date;
	}
	
	public List<Customer> getCustomers(){
		return customerService.findAll();
	}

}
