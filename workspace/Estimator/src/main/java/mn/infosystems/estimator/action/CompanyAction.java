package mn.infosystems.estimator.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import mn.infosystems.estimator.model.Company;
import mn.infosystems.estimator.service.CompanyService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin") ,@Namespace("/employee")})
public class CompanyAction extends ActionSupport implements Preparable,
		ModelDriven<Company>, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Company company = new Company();
	private CompanyService companyService;
	private List<Company> companyList;
	private int companyHash;
	private HttpServletRequest request;
	
	
	@Action(value="company",results={@Result(name="success",type="tiles",location="/company.tiles")})
	public String list(){
		this.companyList = companyService.findAll();
		return SUCCESS;
	}
	
	@Action(value="company-list-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/company/company-list.jsp")})
	public String listAjax(){
		this.companyList = companyService.findAll();
		return SUCCESS;
	}
	
	@Action(value="save-company",results={@Result(name="success",location="/WEB-INF/content/ajax/company/company-result.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/company/company-result.jsp")})
	public String save(){
		if(company!=null && company.hashCode() != companyHash){
			companyService.saveOrUpdate(company);
			request.setAttribute("companySuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@VisitorFieldValidator(appendPrefix = false, message = "")
	public Company getModel() {
		return company;
	}

	public void prepare() throws Exception {
		if(company!=null && company.getId()!=null){
			this.company = companyService.get(company.getId());
			this.companyHash = company.hashCode();
		}
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyService(final CompanyService companyService) {
		this.companyService = companyService;
	}
	
	
	
}
