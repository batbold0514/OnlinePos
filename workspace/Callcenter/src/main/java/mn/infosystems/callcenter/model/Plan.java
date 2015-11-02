package mn.infosystems.callcenter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Dell
 * @see  Төлөвлөгөө тухайн операторын хийх ажил
 */
@Entity
@Table(name="plan")
@NamedQueries({@NamedQuery(name="plan.getByDate",query="select p from Plan p where p.date > cast(:date1 as timestamp) and p.date < cast(:date2 as timestamp)"),
	@NamedQuery(name="plan.call",query="select p from Plan p where p.date > cast(:date1 as timestamp) and p.date < cast(:date2 as timestamp) and p.call = true and operator.userName like :user"),
	@NamedQuery(name="plan.notCall",query="select p from Plan p where p.date > cast(:date1 as timestamp) and p.date < cast(:date2 as timestamp) and p.call = false and operator.userName like :user"),
	@NamedQuery(name="debt.getCommitment",query="select dt.commitments from Debt dt where dt.id =:id and dt.payDate is null and dt.callQuantity < :callQuantity and dt.endDate > now()"),

})
public class Plan{
	private Long id;
	private Users operator;
	private TaxPayer taxPayer;
	private Date date;
	private boolean call;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	public Users getOperator() {
		return operator;
	}
	public void setOperator(Users operator) {
		this.operator = operator;
	}
	@ManyToOne
	public TaxPayer getTaxPayer() {
		return taxPayer;
	}
	public void setTaxPayer(TaxPayer taxPayer) {
		this.taxPayer = taxPayer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isCall() {
		return call;
	}
	public void setCall(boolean call) {
		this.call = call;
	}
	
	
}
