package mn.infosystems.callcenter.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.infosystems.callcenter.model.Commitment;
import mn.infosystems.callcenter.service.CommitmentService;
import mn.infosystems.callcenter.service.PlanService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
	@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"),@Namespace("/senior")})
public class CommitmentAction extends ActionSupport implements Preparable,
ModelDriven<Commitment>,ServletRequestAware,SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private Commitment commitment = new Commitment();
	private int commitmentHash;
	private Map<String, Object> session;
	private CommitmentService commitmentService;
	private PlanService planService;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request =request;
	}

	public Commitment getModel() {
		return commitment;
	}

	
	public Commitment getCommitment() {
		return commitment;
	}

	public void setCommitment(Commitment commitment) {
		this.commitment = commitment;
	}

	public void setCommitmentService(final CommitmentService commitmentService) {
		this.commitmentService = commitmentService;
	}
	

	public void setPlanService(final PlanService planService) {
		this.planService = planService;
	}

	public void prepare() throws Exception {
		if(commitment !=null && commitment.getId()!=null){
			commitment = commitmentService.get(commitment.getId());
			commitmentHash = commitment.hashCode();
		}
	}
	@Action(value = "commitmentsave",results= {
			@Result(name = "success" , location= "/WEB-INF/content/ajax/user-list-result.jsp")
	})
	public String save(){
		String payStr = request.getParameter("paydateStr");
			commitment.setPayDate(stringToDate(payStr));
//		commitmentService.save(commitment);
//		Plan plan = planService.get(Long.parseLong(request.getParameter("modelId")));
//		plan.getTaxPayer().
//		session.put("plan", plan);
		return SUCCESS;
	}
	private Date stringToDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!str.equals(""))
				date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
