package mn.threesor.wms.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.wms.enums.MeasuringUnit;
import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Category;
import mn.threesor.wms.model.Colour;
import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.Employee;
import mn.threesor.wms.model.InputArticle;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.Measure;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.Size;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.CategoryService;
import mn.threesor.wms.service.ColourService;
import mn.threesor.wms.service.CustomerService;
import mn.threesor.wms.service.EmployeeService;
import mn.threesor.wms.service.InputArticleService;
import mn.threesor.wms.service.LocationWmsService;
import mn.threesor.wms.service.MeasureService;
import mn.threesor.wms.service.SizeService;

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
public class ArticleAction extends ActionSupport implements
		ModelDriven<Article>, Preparable, SessionAware {

	private static final long serialVersionUID = 1L;
	private Article article = new Article();
	private InputArticle inputArticle = new InputArticle();
	private InputArticleService inputArticleService;
	private ArticleService articleService;
	private EmployeeService employeeService;
	private Employee inReciever;
	private SizeService sizeService;
	private ColourService colourService;
	private CategoryService categoryService;
	private MeasureService measureService;
	private CustomerService customerService;
	private int articleHash;
	private List<Article> articleList;
	private float addCount;
	private LocationWmsService locationWmsService;
	private String fromSb;
	private Category categoryInArticle;
	private Map<String, Object> m;
	private String categoryString;
	private String colourString;
	private String locationString;
	private String ownerString;
	private String sizeString;
	private String unitString;
	private String customerString;
	private String measureId;
	private String status = "1";
	

	public void prepare() throws Exception {
		if (article != null && article.getId() != null) {
			this.article = articleService.get(article.getId());
			this.setArticleHash(article.hashCode());
		}
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Article getModel() {
		return article;
	}

	public void setLocationWmsService(
			final LocationWmsService locationWmsService) {
		this.locationWmsService = locationWmsService;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}

	public void setInputArticleService(
			final InputArticleService inputArticleService) {
		this.inputArticleService = inputArticleService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	public void setCategoryService(final CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setMeasureService(final MeasureService measureService) {
		this.measureService = measureService;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public int getArticleHash() {
		return articleHash;
	}

	public void setArticleHash(int articleHash) {
		this.articleHash = articleHash;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Employee getInReciever() {
		return inReciever;
	}

	public void setInReciever(Employee inReciever) {
		this.inReciever = inReciever;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public float getAddCount() {
		return addCount;
	}

	public void setAddCount(float addCount) {
		this.addCount = addCount;
	}

	@SkipValidation
	@Action(value = "newArticle", results = { @Result(name = "success", type = "tiles", location = "/article-new-1.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "addArticle", results = { @Result(name = "success", type = "tiles", location = "/article-add.tiles", params = {
			"model.id", "${id}" }) })
	public String exexute1() throws Exception {
		m.put("articleAdd", article);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "showArticle", results = { @Result(name = "success", type = "tiles", location = "/article-show.tiles", params = {
			"model.id", "${id}" }) })
	public String exexute2() throws Exception {
		m.put("articleAdd", article);
		return SUCCESS;
	}

	@Action(value = "saveArticle", results = {
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", type = "redirectAction", location = "articleListSession"),
			@Result(name = "input", type = "tiles", location = "/article-new-2.tiles") })
	public String save() throws Exception {
		try {
			if (article != null && article.hashCode() != articleHash) {
				if (ownerString.equals("")) {
					addFieldError("ownerString",
							Messages.getString("Article.owner"));
					return INPUT;
				}
				if (article.getName().equals("")) {
					addFieldError("name", Messages.getString("Article.name"));
					return INPUT;
				}
				if (article.getCount() <= 0) {
					addFieldError("count", Messages.getString("Article.count"));
					return INPUT;
				}
				if (unitString.equals("-1")) {
					addFieldError("measuring_unit",
							Messages.getString("Article.measuringUnit"));
					return INPUT;
				}
				if (article.getMinCount() < 0) {
					addFieldError("minCount", Messages.getString("Article.min"));
					return INPUT;
				}
				if (inReciever.getId() == -1) {
					addFieldError("inReciever.id",
							Messages.getString("inRecieverError"));
					return INPUT;
				}
				if (customerString.equals("")) {
					addFieldError("customer", Messages.getString("customer"));
					return INPUT;
				}

				article.setMeasure(measureService.get(Long
						.parseLong(unitString)));
				article.setCategory(categoryService.get(Long
						.parseLong(categoryString.trim())));
				if (colourString != null && !colourString.equals(""))
					article.setColour(colourService.get(Long
							.parseLong(colourString.trim())));
				if (locationString != null && !locationString.equals(""))
					article.setLocation(locationWmsService.get(Long
							.parseLong(locationString.trim())));
				else {
					addFieldError("locationString",
							Messages.getString("emptyLocation"));
					return INPUT;
				}

				if (sizeString != null && !sizeString.equals(""))
					article.setSize(sizeService.get(Long.parseLong(sizeString
							.trim())));
				article.setOwner(employeeService.get(Long.parseLong(ownerString
						.trim())));
				// if(status.equals("1")){
				inputArticle.setArticle(articleService.saveArticle(article));
				inputArticle.setInDate(new Date());
				inputArticle.setInReciever(inReciever);
				inputArticle.setAddCount(article.getCount());
				inputArticle.setCustomer(customerService.get(Long
						.parseLong(customerString)));
				inputArticleService.saveOrUpdate(inputArticle);
				/*
				 * }else{ articleService.saveArticle(article); }
				 */
				m.put("articleName", article.getName());
				m.put("articleBarCode", article.getBarCode());
				if (sizeString != null && !sizeString.equals(""))
					m.put("articleSize", article.getSize().getId());
				else
					m.put("articleSize", -1l);
				if (colourString != null && !colourString.equals("")) {
					m.put("articleCode", article.getColour().getCode());
				} else {
					m.put("articleCode", "");
				}
				if (locationString != null && !locationString.equals(""))
					m.put("articleLocation", article.getLocation().getId());
				else
					m.put("articleLocation", -1l);
				return SUCCESS;

			}

		} catch (Exception e) {
			addFieldError("name", "Exception is : " + e.toString());
			return INPUT;
		}

		return INPUT;
	}

	@Action(value = "addCountArticle", results = {
			@Result(name = "success", type = "redirectAction", location = "articleListSession"),
			@Result(name = "input", type = "tiles", location = "/article-add.tiles") })
	public String addCount() throws Exception {
		if (!ownerString.equals(""))
			article.setOwner(employeeService.get(Long.parseLong(ownerString
					.trim())));
		if (!categoryString.equals(""))
			article.setCategory(categoryService.get(Long
					.parseLong(categoryString.trim())));
		if (!colourString.equals(""))
			article.setColour(colourService.get(Long.parseLong(colourString
					.trim())));
		if (!locationString.equals(""))
			article.setLocation(locationWmsService.get(Long
					.parseLong(locationString.trim())));

		if (!sizeString.equals(""))
			article.setSize(sizeService.get(Long.parseLong(sizeString.trim())));

		if (customerString.equals("")) {
			addFieldError("customer", Messages.getString("customer"));
			return INPUT;
		}

		if (inReciever.getId() != -1) {
			article.setCount(article.getCount() + addCount);
			articleService.saveOrUpdate(article);
			inputArticle.setArticle(article);
			inputArticle.setInDate(new Date());
			inputArticle.setAddCount(addCount);
			inputArticle.setInReciever(inReciever);
			inputArticle.setCustomer(customerService.get(Long
					.parseLong(customerString)));
			inputArticleService.saveOrUpdate(inputArticle);
			m.put("articleName", article.getName());
			m.put("articleBarCode", article.getBarCode());
			if (sizeString != null && !sizeString.equals(""))
				m.put("articleSize", article.getSize().getId());
			else
				m.put("articleSize", -1l);
			if (colourString != null && !colourString.equals("")) {
				m.put("articleCode", article.getColour().getCode());
			} else {
				m.put("articleCode", "");
			}
			if (locationString != null && !locationString.equals(""))
				m.put("articleLocation", article.getLocation().getId());
			else
				m.put("articleLocation", -1l);
			return SUCCESS;

		}
		addFieldError("inReciever.id", Messages.getString("inRecieverError"));
		return INPUT;
	}

	@SkipValidation
	@Action(value = "saveCategoryInArticle", results = {
			@Result(name = "success", type = "tiles", location = "/article-new-2.tiles"),
			@Result(name = "input", type = "tiles", location = "/article-new-1.tiles") })
	public String save1() throws Exception {
		try {
			if (categoryInArticle.getId() != -1) {
				this.categoryInArticle = categoryService.get(categoryInArticle
						.getId());
				m.put("categoryInArticle", categoryInArticle);
				return SUCCESS;
			}
			addFieldError("categoryInArticle.id",
					Messages.getString("categoryInArticleError"));
			return INPUT;
		} catch (Exception e) {
			return INPUT;
		}
	}

/*	@Action(value = "addCustomerInArticle", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-customer.jsp") })
	public String saveCustomer() throws Exception {
		JOptionPane.showMessageDialog(null, customerName);
		customerName += " xaxaxa";
		return SUCCESS;
	}
*/
	
	public List<Employee> getEmployeeList() {
		return employeeService.getAvailableEmployee();
	}

	public List<Size> getSizes() {
		return sizeService.findAll();
	}

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public List<Category> getCategories() {
		return categoryService.findAll();
	}

	public List<LocationWms> getLocationWms() {
		return locationWmsService.findAll();
	}

	public String getFromSb() {
		return fromSb;
	}

	public void setFromSb(String fromSb) {
		this.fromSb = fromSb;
	}

	public Category getCategoryInArticle() {
		return categoryInArticle;
	}

	public void setCategoryInArticle(Category categoryInArticle) {
		this.categoryInArticle = categoryInArticle;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public MeasuringUnit[] getMeasuringUnits() {
		return MeasuringUnit.values();
	}

	public String getCategoryString() {
		return categoryString;
	}

	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
	}

	public String getColourString() {
		return colourString;
	}

	public void setColourString(String colourString) {
		this.colourString = colourString;
	}

	public String getOwnerString() {
		return ownerString;
	}

	public void setOwnerString(String ownerString) {
		this.ownerString = ownerString;
	}
	public void setMeasureId(String id){
		if(!id.equals(""))
			this.article.setMeasure(measureService.get(Long.parseLong(id)));
	}
	

	public String getMeasureId() {
		return measureId;
	}

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	public String getSizeString() {
		return sizeString;
	}

	public void setSizeString(String sizeString) {
		this.sizeString = sizeString;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Measure> getMeasures() {
		return measureService.findAll();
	}

	public String getUnitString() {
		return unitString;
	}

	public void setUnitString(String unitString) {
		this.unitString = unitString;
	}

	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	public String getCustomerString() {
		return customerString;
	}

	public void setCustomerString(String customerString) {
		this.customerString = customerString;
	}

	

}
