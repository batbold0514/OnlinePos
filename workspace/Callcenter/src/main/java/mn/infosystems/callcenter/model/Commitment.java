package mn.infosystems.callcenter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 * @author Suld
 * @see Амлалт
 */
@Entity
@Table(name="Commitment")
@NamedQueries({@NamedQuery(name="commitment.getProcess",query="select sum(value) as sumValue,count(value) as countValue from Commitment c where giveDate > cast(:d1 as timestamp) and giveDate < cast(:d2 as timestamp)"),
		@NamedQuery(name = "commitment.getByDate", query="select commit from Commitment commit where commit.giveDate >= cast(:d1 as timestamp) and commit.giveDate <= cast(:d2 as timestamp)")
})
public class Commitment {
	private Long id;
	/*
	 тайлбар
	 */
	private String description;
	/*
	 амлалт авсан мөнгөн дүн
	 */
	private double value;
	/*
	амлалт өгхөд байсан мөнгөн дүн
	*/
	private double payBalance;
	/*
	амлалт өгсөн өдөр
	 */
	private Date giveDate;
	/*
	мөнгө төлөх өдөр
	*/
	private Date payDate;
	/*
	 * Татвар төлөгчийн өр
	 */
	private Debt debt;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getGiveDate() {
		return giveDate;
	}
	public void setGiveDate(Date giveDate) {
		this.giveDate = giveDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	@OneToOne
	public Debt getDebt() {
		return debt;
	}
	public void setDebt(Debt debt) {
		this.debt = debt;
	}
	public double getPayBalance() {
		return payBalance;
	}
	public void setPayBalance(double payBalance) {
		this.payBalance = payBalance;
	}
	
	
	
}
