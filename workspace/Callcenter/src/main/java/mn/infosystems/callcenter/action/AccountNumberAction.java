package mn.infosystems.callcenter.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import mn.infosystems.callcenter.model.AccountNumber;
import mn.infosystems.callcenter.model.DebtType;
import mn.infosystems.callcenter.service.AccountNumberService;
import mn.infosystems.callcenter.service.DebtTypeService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AccountNumberAction extends ActionSupport implements Preparable,ModelDriven<AccountNumber>,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountNumber accountNumber = new AccountNumber();
	private AccountNumberService accountNumberService;
	private HttpServletRequest request;
	private int accountNumberHash;
	private List<AccountNumber> listOfAccounts;
	private DebtTypeService debtTypeService;
	
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public AccountNumber getModel() {
		return accountNumber;
	}

	public void prepare() throws Exception {
		if(accountNumber!=null && accountNumber.getId()!=null){
			this.accountNumber = accountNumberService.get(accountNumber.getId());
			this.accountNumberHash = accountNumber.hashCode();
		}
	}

	public AccountNumber getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(AccountNumber accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<AccountNumber> getListOfAccounts() {
		return listOfAccounts;
	}

	public void setListOfAccounts(List<AccountNumber> listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}

	public void setAccountNumberService(final AccountNumberService accountNumberService) {
		this.accountNumberService = accountNumberService;
	}
	
	public void setDebtTypeService(final DebtTypeService debtTypeService) {
		this.debtTypeService = debtTypeService;
	}

	public List<DebtType> getDebtTypes(){
		return debtTypeService.findAll();
	}
	
	@Action(value="account-number",results={@Result(name="success",location="/account-number.tiles",type="tiles")})
	public String list(){
		this.listOfAccounts = accountNumberService.findAll();
		return SUCCESS;
	}
	
	@Action(value="save-account-number-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/account/account.jsp"),
			@Result(name="input",location="/WEB-INF/content/ajax/account/account.jsp")})
	public String save(){
		if(accountNumber!=null && accountNumber.hashCode()!=accountNumberHash){
			accountNumberService.saveOrUpdate(accountNumber);
			request.setAttribute("accountSuccess", SUCCESS);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Action(value="account-number-list-ajax",results={@Result(name="success",location="/WEB-INF/content/ajax/account/account-list.jsp")})
	public String list_ajax(){
		this.listOfAccounts = accountNumberService.findAll();
		return SUCCESS;
	}
	
	
}
