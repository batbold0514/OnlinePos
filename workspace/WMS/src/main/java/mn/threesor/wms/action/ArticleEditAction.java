package mn.threesor.wms.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Colour;
import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.Employee;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.Measure;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.model.Size;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.CategoryService;
import mn.threesor.wms.service.ColourService;
import mn.threesor.wms.service.CustomerService;
import mn.threesor.wms.service.EmployeeService;
import mn.threesor.wms.service.LocationWmsService;
import mn.threesor.wms.service.MeasureService;
import mn.threesor.wms.service.SizeService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class ArticleEditAction extends ActionSupport implements Preparable,
		ModelDriven<Article>, ServletRequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article article = new Article();
	private ArticleService articleService;
	private int articleHash;
	private Map<String, Object> m;
	private EmployeeService employeeService;
	private SizeService sizeService;
	private ColourService colourService;
	private LocationWmsService locationWmsService;
	private MeasureService measureService;
	private CustomerService customerService;
	private CategoryService categoryService;
	private String categoryString;
	private String colourString;
	private String locationString;
	private String ownerString;
	private String sizeString;
	private String unitString;

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

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	public String getOwnerString() {
		return ownerString;
	}

	public void setOwnerString(String ownerString) {
		this.ownerString = ownerString;
	}

	public String getSizeString() {
		return sizeString;
	}

	public void setSizeString(String sizeString) {
		this.sizeString = sizeString;
	}

	public String getUnitString() {
		return unitString;
	}

	public void setUnitString(String unitString) {
		this.unitString = unitString;
	}

	
	public void setCategoryService(final CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	public void setLocationWmsService(
			final LocationWmsService locationWmsService) {
		this.locationWmsService = locationWmsService;
	}

	public void setMeasureService(final MeasureService measureService) {
		this.measureService = measureService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setServletRequest(HttpServletRequest request) {
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Article getModel() {
		return article;
	}

	public void prepare() throws Exception {
		if (article != null && article.getId() != null) {
			this.article = articleService.get(article.getId());
			this.setArticleHash(article.hashCode());
			this.categoryString = "" + article.getCategory().getId();
			if (article.getColour() != null) {
				this.colourString = "" + article.getColour().getId();
			}
			this.locationString = "" + article.getLocation().getId();
			this.unitString = "" + article.getMeasure().getId();
			if (article.getSize() != null) {
				this.sizeString = "" + article.getSize().getId();
			}
			this.ownerString = "" + article.getOwner().getId();
		}
	}

	@SkipValidation
	@Action(value = "editArticle", results =
	{
		@Result(name = "success", type = "tiles", location = "/article-edit.tiles")
	})
	public String editArticle() throws Exception
	{
		Long Catid = Long.parseLong(categoryString);
		m.put("categoryInArticle", categoryService.get(Catid));
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "editArticleSave", results = {
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", type = "redirectAction", location = "articleListSession") })
	public String editArticleSave() throws Exception {
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
			articleService.update(article);
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
		return INPUT;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}

	public int getArticleHash() {
		return articleHash;
	}

	public void setArticleHash(int articleHash) {
		this.articleHash = articleHash;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public List<Employee> getEmployeeList() {
		return employeeService.getAvailableEmployee();
	}

	public List<Measure> getMeasures() {
		return measureService.findAll();
	}

	public List<LocationWms> getLocationWms() {
		return locationWmsService.findAll();
	}

	public List<Size> getSizes() {
		return sizeService.findAll();
	}

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

}
