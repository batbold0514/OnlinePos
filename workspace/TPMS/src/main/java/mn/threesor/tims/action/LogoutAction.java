package mn.threesor.tims.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("basicStack") })
public class LogoutAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Override
    @Action(value = "logout", results = { @Result(name = "success", location = "/login/login.jsp") })
    @SkipValidation
    public String execute() throws Exception {
        // just a test for error page
        // throw new ServletException();
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }
}
