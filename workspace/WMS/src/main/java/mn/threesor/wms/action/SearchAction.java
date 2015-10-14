package mn.threesor.wms.action;

import java.util.List;
import java.util.Map;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Colour;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.Size;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.ColourService;
import mn.threesor.wms.service.LocationWmsService;
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

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class SearchAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Article> articleList;
	private ArticleService articleService;
	private Map<String, Object> m;
	private String articleName;
	private Long articleSize;
	private String articleCode;
	private String articleBarCode;
	private Long articleLocation;
	private LocationWmsService locationWmsService;
	private ColourService colourService;
	private SizeService sizeService;

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}

	@SkipValidation
	@Action(value = "articleListSearch", results = { @Result(name = "success", type = "tiles", location = "/article-search.tiles") })
	public String lists() throws Exception {
		return SUCCESS;
	}

	// articleListSearch url search start
	@SkipValidation
	@Action(value = "articleList", results =
	{
		@Result(name = "success", type = "tiles", location = "/article-list.tiles"),
		@Result(name = "input", type = "redirectAction", location = "showArticle", params =
		{
			"model.id", "${articleList.get(0).id}"
		})
	})
	public String list() throws Exception
	{
		if (articleName == null || articleSize == null || articleCode == null || articleLocation == null || articleBarCode == null)
		{
			this.articleList = articleService.findAll();
		}
		else
		{
			this.articleList = articleService.searchArticleList(articleName, articleSize, articleCode, articleLocation, articleBarCode);
		}
		
		if (this.articleList.size() != 1)
			return SUCCESS;
		m.put("articleAdd", this.articleList.get(0));
		return INPUT;
	}
	
	@SkipValidation
	@Action(value = "articleListSession", results = {
			@Result(name = "success", type = "tiles", location = "/article-list.tiles") })
	public String listSession() throws Exception {
		articleName = (String) m.get("articleName");
		articleCode = (String) m.get("articleCode");
		articleSize = (Long) m.get("articleSize");
		articleLocation = (Long) m.get("articleLocation");
		articleBarCode = (String) m.get("articleBarCode");
		this.articleList = articleService.searchArticleList(articleName,
				articleSize, articleCode, articleLocation, articleBarCode);
			return SUCCESS;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Long getArticleSize() {
		return articleSize;
	}

	public void setArticleSize(Long articleSize) {
		this.articleSize = articleSize;
	}

	public String getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}
	
	public String getArticleBarCode() {
		return articleBarCode;
	}

	public void setArticleBarCode(String articleBarCode) {
		this.articleBarCode = articleBarCode;
	}

	public Long getArticleLocation() {
		return articleLocation;
	}

	public void setArticleLocation(Long articleLocation) {
		this.articleLocation = articleLocation;
	}

	public void setLocationWmsService(
			final LocationWmsService locationWmsService) {
		this.locationWmsService = locationWmsService;
	}

	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public List<LocationWms> getLocations() {
		return locationWmsService.findAll();
	}

	public List<Size> getSizes() {
		return sizeService.findAll();
	}

}
