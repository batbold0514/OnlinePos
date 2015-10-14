package mn.threesor.wms.action;

import java.util.List;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.service.ArticleService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class ArticleCountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArticleService articleService;
	private List<Article> listArticles;
	private String articleCount;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	@SkipValidation
	@Action(value = "articleCount", results = { @Result(name = "success", type = "tiles", location = "/article-count.tiles") })
	public String execute() throws Exception {
		setListArticles(articleService.getArticleCount("id desc"));
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "articleCountOrder", results = { @Result(name = "success", type = "tiles", location = "/article-count.tiles") })
	public String execute1() throws Exception {
		setListArticles(articleService.getArticleCount(articleCount));
		return SUCCESS;
	}

	public String getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(String articleCount) {
		this.articleCount = articleCount;
	}

}
