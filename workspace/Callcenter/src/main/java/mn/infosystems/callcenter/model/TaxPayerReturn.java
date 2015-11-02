package mn.infosystems.callcenter.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
 
@Entity
@Table(name="TaxPayerReturn")
public class TaxPayerReturn {
	private Long id;
	private List<Debt> debtOfList;
	private Date date;
	private ReturnReason reason;
	private Users operator;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne
	public ReturnReason getReason() {
		return reason;
	}
	public void setReason(ReturnReason reason) {
		this.reason = reason;
	}
	@ManyToMany
	public List<Debt> getDebtOfList() {
		return debtOfList;
	}
	public void setDebtOfList(List<Debt> debtOfList) {
		this.debtOfList = debtOfList;
	}
	@ManyToOne
	public Users getOperator() {
		return operator;
	}
	public void setOperator(Users operator) {
		this.operator = operator;
	}
	
	
	
}
