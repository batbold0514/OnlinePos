package mn.threesor.wms.action;

import java.util.List;
import java.util.Map;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.Messages;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.CategoryService;
import mn.threesor.wms.service.ColourService;
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
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;


@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class TransferAction extends ActionSupport implements
		ModelDriven<Article>, Preparable, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article article = new Article();
	private ArticleService articleService;
	@SuppressWarnings("unused")
	private int articleHash;
	private List<Article> transferList;
	private LocationWmsService locationWmsService;
	private int changeCount;
	private Map<String, Object> m;
	private String colourName;
	private String colourCode;
	private String sizes;
	private String locName;
	private String changeLocation;
	@SuppressWarnings("unused")
	private Session session;
	private ColourService colourService;
	private EmployeeService employeeService;
	private CategoryService categoryService;
	private MeasureService measureService;
	private SizeService sizeService;
	
	public void prepare() throws Exception {
		if (article != null && article.getId() != null) {
			article = articleService.get(article.getId());
			articleHash = article.hashCode();
		}
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Article getModel() {
		return article;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setLocationWmsService(
			final LocationWmsService locationWmsService) {
		this.locationWmsService = locationWmsService;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}

	public void setMeasureService(final MeasureService measureService) {
		this.measureService = measureService;
	}

	public final List<Article> getTransferList() {
		return transferList;
	}

	public final void setTransferList(List<Article> transferList) {
		this.transferList = transferList;
	}

	@Action(value = "transfer-part", results =
	{
		@Result(name = "success", type = "tiles", location = "/transfer-part.tiles"),
		@Result(name = "input", type = "redirectAction", location = "articleList"),
	})
	public String show()
	{
		if (article == null)
		{
			return INPUT;
		}
		
		m.put("article", article);
		return SUCCESS;
	}

	@Action(value = "alltransfer", results = {
			@Result(name = "success", type = "redirectAction", location = "articleListSession"),
			@Result(name = "input", type = "tiles", location = "/transfer-part.tiles") })
	public String allTransfer() {
		if(!articleService.transferArticle(article, changeLocation, changeCount)) {
			addFieldError("changeCount", article.getCount() + " " + Messages.getString("maxCount"));
			return INPUT;}
		m.put("articleName", article.getName());
		m.put("articleBarCode", article.getBarCode());
		if (article.getSize() != null )
			m.put("articleSize", article.getSize().getId());
		else
			m.put("articleSize", -1l);
		if (article.getColour() != null ) {
			m.put("articleCode", article.getColour().getCode());
		} else {
			m.put("articleCode", "");
		}
			m.put("articleLocation", Long.parseLong(changeLocation));
		return SUCCESS;

	}

	public List<LocationWms> getLocationWnsShow() {
		return locationWmsService.findAll();
	}

	public int getChangeCount() {
		return changeCount;
	}

	public void setChangeCount(int changeCount) {
		this.changeCount = changeCount;
	}

	public void setSession(Map<String, Object> session) {
		m = session;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public String getColourName() {
		return colourName;
	}

	public void setColourName(String colourName) {
		this.colourName = colourName;
	}

	public String getColourCode() {
		return colourCode;
	}
	
	public void setColourCode(String colourCode) {
		this.colourCode = colourCode;
	}
	
	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getChangeLocation() {
		return changeLocation;
	}

	public void setChangeLocation(String changeLocation) {
		this.changeLocation = changeLocation;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	public void setColourId(String id){
		if(!id.equals(""))
		this.article.setColour(colourService.get(Long.parseLong(id)));
	}
	public void setLocationId(String id){
		if(!id.equals(""))
		this.article.setLocation(locationWmsService.get(Long.parseLong(id)));
	}
	public void setOwnerId(String id){
		if(!id.equals(""))
		this.article.setOwner(employeeService.get(Long.parseLong(id)));
	}
	public void setMeasureId(String id){
		if(!id.equals(""))
			this.article.setMeasure(measureService.get(Long.parseLong(id)));
	}
	public void setCategoryId(String id){
		if(!id.equals(""))
		this.article.setCategory(categoryService.get(Long.parseLong(id)));
	}
	public void setSizeId(String id){
		if(!id.equals(""))
		this.article.setSize(sizeService.get(Long.parseLong(id)));
	}
	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setCategoryService(final CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	
	
}
