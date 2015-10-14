package mn.threesor.wms.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import mn.threesor.wms.model.OutputArticle;
import mn.threesor.wms.service.OutputArticleService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class OutputShowAction extends ActionSupport implements Preparable,
ModelDriven<OutputArticle> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OutputArticle outputArticle = new OutputArticle();
	private OutputArticleService outputArticleService;
	@SuppressWarnings("unused")
	private int outputHash;
	public OutputArticle getModel() {
		return outputArticle;
	}
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void prepare() throws Exception {
		if(outputArticle != null && outputArticle.getId() !=null){
			this.outputArticle = outputArticleService.get(outputArticle.getId());
			this.outputHash = outputArticle.hashCode();
		}
	}
	@Action(value = "showOutputArticle", results = { @Result(name = "success", type = "tiles", location = "/output-article-edit.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}
	public OutputArticle getOutputArticle() {
		return outputArticle;
	}

	public void setOutputArticle(OutputArticle outputArticle) {
		this.outputArticle = outputArticle;
	}

	public void setOutputArticleService(final OutputArticleService outputArticleService) {
		this.outputArticleService = outputArticleService;
	}
	

}
