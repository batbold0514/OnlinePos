package mn.infosystems.callcenter.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import mn.infosystems.callcenter.enums.TaxpayerStatus;

/**
 * @author Suld
 * @see Өрийн мэдэээлэл
 */
@Entity
@Table(name="debt",uniqueConstraints={@UniqueConstraint(columnNames={"debtNumber"})})
@NamedQueries({@NamedQuery(name="debt.getPayDateNotNull",query="select d from Debt d where paydate is not null order by d.taxPayer.id"),
	@NamedQuery(name="taxpayer.updateAvgDay",query="update TaxPayer tp set tp.avgDay = :avgVal where tp.id = :id"),
	@NamedQuery(name="debt.updateCallQuantity",query="update Debt dt set dt.callQuantity =dt.callQuantity+1 where dt.taxPayer.id = :id  and dt.payDate is null and dt.callQuantity <:callQuantity and dt.endDate > now()"),
	@NamedQuery(name="debt.getMaxQuantity",query="select max(dt.callQuantity) from Debt dt where dt.taxPayer.id  =:id  and dt.payDate is null and dt.callQuantity <:callQuantity and dt.endDate > now()"),
	@NamedQuery(name="Debt.getDebtReport",query="select d from Debt d where startDate > cast(:sd1 as timestamp) and startDate <cast(:sd2 as timestamp) and " +
			"paydate > cast(:pd1 as timestamp) and payDate < cast(:pd2 as timestamp) and cast(type.id as string) like :typeId and cast(taxPayer.id as string) like :tpId"),
	@NamedQuery(name = "debt.returnReport",query="select tpr from TaxPayerReturn tpr where tpr.date > cast(:date1 as timestamp) and cast(:date2 as timestamp)>tpr.date and cast(operator.id as string) like :opId")
})
public class Debt {
	private Long id;
	/**
	 * Татварын дугаар
	 */
	private String debtNumber;
	/**
	 * Үлдэгдэл
	 */
	private Double balance;
	/**
	 * Эхлэх огноо
	 */
	private Date startDate;
	/**
	 * Хүчинтэй хугацаа (хоногоор)
	 */
	private int duration;
	/**
	 * Дуусах огноо
	 */
	private Date endDate;
	/**
	 * Төрөл
	 */
	private DebtType type;
	/**
	 * Татвар төлөгч
	 */
	private TaxPayer taxPayer;
	/**
	 * Мэдэгдэх хуудасны дугаар
	 */
	private String ticketNumber;
	/**
	 Татвар төлсөн огноо
	 */
	private Date payDate;
	/**
	 * Тухайн өрд өгсөн амлалтууд
	 */
	private List<Commitment> commitments;
	/**
	 * Дуудлага хийсэн тоо
	 */
	private int callQuantity;
	/**
	 * Албадын дугаар
	 */
	private String officeNumber;
	/**
	 *Данснууд 
	 */
	private List<AccountNumber> listOfAccountNumber;
	/**
	 *он 
	 */
	private String create_yaer;
	/**
	 *улирал 
	 */
	private String bill_time;
	/**
	 *тайлангын хэлбэр 
	 */
	private String dtype_code;
	private TaxpayerStatus status;
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	//45*54 
	public void setId(Long id) {
		this.id = id;
	}
	public String getDebtNumber() {
		return debtNumber;
	}
	public void setDebtNumber(String debtNumber) {
		this.debtNumber = debtNumber;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@NotNull
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@ManyToOne
	public DebtType getType() {
		return type;
	}
	public void setType(DebtType type) {
		this.type = type;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@ManyToOne
	public TaxPayer getTaxPayer() {
		return taxPayer;
	}
	public void setTaxPayer(TaxPayer taxPayer) {
		this.taxPayer = taxPayer;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	@ManyToMany
	public List<Commitment> getCommitments() {
		return commitments;
	}
	public void setCommitments(List<Commitment> commitments) {
		this.commitments = commitments;
	}
	public int getCallQuantity() {
		return callQuantity;
	}
	public void setCallQuantity(int callQuantity) {
		this.callQuantity = callQuantity;
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	@ManyToMany
	public List<AccountNumber> getListOfAccountNumber() {
		return listOfAccountNumber;
	}
	public void setListOfAccountNumber(List<AccountNumber> listOfAccountNumber) {
		this.listOfAccountNumber = listOfAccountNumber;
	}
	public String getCreate_yaer() {
		return create_yaer;
	}
	public void setCreate_yaer(String create_yaer) {
		this.create_yaer = create_yaer;
	}
	public String getBill_time() {
		return bill_time;
	}
	public void setBill_time(String bill_time) {
		this.bill_time = bill_time;
	}
	public String getDtype_code() {
		return dtype_code;
	}
	public void setDtype_code(String dtype_code) {
		this.dtype_code = dtype_code;
	}
	public TaxpayerStatus getStatus() {
		return status;
	} 
	
	public void setStatus(TaxpayerStatus status) {
		this.status = status;
	}
	
}
