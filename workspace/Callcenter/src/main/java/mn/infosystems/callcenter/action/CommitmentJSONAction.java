package mn.infosystems.callcenter.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import mn.infosystems.callcenter.json.CommitmentJSONEntry;
import mn.infosystems.callcenter.model.Commitment;
import mn.infosystems.callcenter.service.CallQuantityService;
import mn.infosystems.callcenter.service.DebtService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("json-default")
public class CommitmentJSONAction  extends ActionSupport implements
ModelDriven<List<CommitmentJSONEntry>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DebtService debtService;
	
	public void setDebtService(final DebtService debtService) {
		this.debtService = debtService;
	}


	@Override
	@Action(value = "commitmentjson", results = {@Result(name = "success", type = "json" , params = {
			"enableGZIP", "noCache" })})
	@SkipValidation
	public String execute() {
		return SUCCESS;
	}
	
	public List<CommitmentJSONEntry> getModel() {
		Map<String, Object> parameters = ActionContext.getContext()
				.getParameters();
		long id = -1;
		int callQuantity = 5;
		Object s = parameters.get("showPlanId");
		if (s != null) {
			id = Long.parseLong(((Object[]) s)[0].toString());
		}
		Object s1 = parameters.get("callQuantity");
		if (s1 != null) {
			callQuantity = Integer.parseInt(((Object[]) s1)[0].toString());
		}
		List<Commitment> commitments = debtService.getCommitments(id,callQuantity);
		List<CommitmentJSONEntry> result = new ArrayList<CommitmentJSONEntry>(
				commitments.size()+1);
		Commitment commitment = null;
		GregorianCalendar cal = new GregorianCalendar();
		GregorianCalendar cal1 = new GregorianCalendar();
		
		for(int i = 0;i<commitments.size();i++){
				if(i ==0 ){
					commitment = commitments.get(i);
					result.add(new CommitmentJSONEntry(commitment));
				}else{
					cal.setTime(commitment.getGiveDate());
					cal1.setTime(commitments.get(i).getGiveDate());
					if(cal.get(Calendar.YEAR) == cal1.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == cal1.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) == cal1.get(Calendar.DAY_OF_MONTH)){
						result.add(new CommitmentJSONEntry(""+(Double.parseDouble(result.get(i-1).getYvalue())-commitments.get(i).getValue()),commitments.get(i).getPayDate()));
					}else{
						commitment = commitments.get(i);
						result.add(new CommitmentJSONEntry(commitment));
					}
				}
				
		}
		return result;
	}
	
	public void setShowPlanId(final long showPlanId) {
		// avoid error message
	}


	public void set_(final long requestTime) {
		// avoid error message
	}

}
