package mn.threesor.wms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.wms.model.Article;
import mn.threesor.wms.service.ArticleService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class OutputArticleMinAction extends ActionSupport implements ServletRequestAware
{
	private HttpServletRequest servletRequest;
	private ArticleService articleService;
	
	@SuppressWarnings("unchecked")
	@Action(value = "check-article-min", results = { 
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", location = "/WEB-INF/content/output-article-check-min.jsp") })
	public String execute() throws Exception
	{
		int msgStatus;
		String id = servletRequest.getParameter("id");
		int count = Integer.parseInt(servletRequest.getParameter("count"));
		List<Article> articleList = articleService.getCurrentSession().getNamedQuery("Article.getArticle").setString("id", id).list();
		double countDiff = articleList.get(0).getCount() - count;
		if (countDiff >= 0)
		{
			if (articleList.get(0).getMinCount() >= countDiff)
			{
				msgStatus = 0;
			}
			else
			{
				msgStatus = 1;
			}
		}
		else
		{
			msgStatus = -1;
		}
		servletRequest.setAttribute("msgStatus", msgStatus);
		return SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest request)
	{
		this.servletRequest = request;
	}
	public HttpServletRequest getServletRequest()
	{
		return servletRequest;
	}

	public ArticleService getArticleService()
	{
		return articleService;
	}
	public void setArticleService(ArticleService articleService)
	{
		this.articleService = articleService;
	}
}
