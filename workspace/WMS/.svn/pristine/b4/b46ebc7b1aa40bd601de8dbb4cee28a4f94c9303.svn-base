package mn.threesor.wms.action;

import java.util.List;

import mn.threesor.wms.model.ArticleMin;
import mn.threesor.wms.service.ArticleService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") })
public class ArticleMinAction extends ActionSupport {
	private ArticleService articleService;
	private List<ArticleMin> articleList;
	
	@Action(value = "min-article-list", results = { @Result(name = "success", type = "tiles", location = "/article-min-list.tiles") })
	public String execute() throws Exception {
		setArticleList(articleService.getArticleMinList());
		return SUCCESS;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public List<ArticleMin> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleMin> articleList) {
		this.articleList = articleList;
	}


}