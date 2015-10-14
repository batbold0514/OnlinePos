package mn.threesor.tims.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

public class LocaleAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@SkipValidation
	@Action(value = "locale", results = { @Result(name = "success", type = "redirectAction", location = "usersList") })
	public String execute() {
		return SUCCESS;
	}
}
