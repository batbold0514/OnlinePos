package mn.chinbat.surgery.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import mn.chinbat.surgery.model.Diagnosis;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.service.DiagnosisService;
import mn.chinbat.surgery.service.SsmLoggerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class DiagnosisAction extends ActionSupport implements Preparable,
		ModelDriven<Diagnosis>,ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private Diagnosis diagnosis = new Diagnosis();
	private DiagnosisService diagnosisService;
	private List<Diagnosis> diagnosisList;
	private int diagnosisHash;
	private SsmLoggerService ssm = new SsmLoggerService();
	private HttpServletRequest requst;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Diagnosis getModel() {
		return diagnosis;
	}

	public void prepare() throws Exception {
		if (diagnosis != null && diagnosis.getId() != null) {
			this.diagnosis = diagnosisService.get(diagnosis.getId());
			this.diagnosisHash = diagnosis.hashCode();
		}
	}

	public void setDiagnosisService(final DiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}

	public List<Diagnosis> getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(List<Diagnosis> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}

	@Action(value = "diagnosisList", results = { @Result(name = "success", type = "tiles", location = "/diagnosis-list.tiles") })
	public String list() throws Exception {
		this.diagnosisList = diagnosisService.findAll();
		return SUCCESS;
	}

	@Action(value="save-diagnosis-ajax",results={
		@Result(name="success",location="/WEB-INF/content/ajax-diagnosis/ajax-diagnosis-add.jsp"),
		@Result(name="input",location="/WEB-INF/content/ajax-diagnosis/ajax-diagnosis-add.jsp")})
	public String saveAjax() throws Exception {
		try {
			if (diagnosis != null && diagnosis.hashCode() != diagnosisHash) {
				if(diagnosisService.check(diagnosis.getCode(), diagnosis.getId())){
					addFieldError("code", Messages.getString("DiagnosisCode"));
					return INPUT;
				}
				diagnosisService.saveOrUpdate(diagnosis);
				ssm.logInfo(diagnosis);
				requst.setAttribute("diagnosisSuccess", SUCCESS);
				return SUCCESS;
			}
		} catch (Exception e) {
			addFieldError("code", Messages.getString("DiagnosisCode"));
			return INPUT;
		}
		return INPUT;
	}
	
	@SkipValidation
	@Action(value="diagnosis-list",results={@Result(name="success",location="/WEB-INF/content/ajax-diagnosis/ajax-diagnosis-list.jsp")})
	public String listAjax() throws Exception{
		this.diagnosisList = diagnosisService.findAll();
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.requst = request;
	}
}
