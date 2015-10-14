package mn.threesor.wms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
public class HelpAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Action(value = "contact", results = { @Result(name = "success", type = "tiles", location = "/contact.tiles") })
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	@Action(value = "faq", results = { @Result(name = "success", type = "tiles", location = "/faq.tiles") })
	public String faq() throws Exception
	{
		return SUCCESS;
	}
	
	@Action(value = "test", results = { @Result(name = "success", location = "/WEB-INF/content/test.jsp" ) })
	public String test()
	{
		return SUCCESS;
	}
}