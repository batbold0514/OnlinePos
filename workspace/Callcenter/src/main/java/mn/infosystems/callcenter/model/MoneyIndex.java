package mn.infosystems.callcenter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import mn.infosystems.callcenter.enums.StatusEnum;
/**
 * @author Suld
 * @see Мөнгөний индекс
 */
@Entity
@Table(name="moneyIndex")
@NamedQueries({@NamedQuery(name = "moneyIndex.getIndex", query = "select money.money_index from MoneyIndex money where :balance >= money.min and :balance <= money.max"),
	@NamedQuery(name = "moneyIndex.checkBalance", query = "select money from MoneyIndex money where :balance >= money.min and :balance <= money.max and money.id !=:id"),
	@NamedQuery(name = "moneyIndex.upadateStatus", query = "update MoneyIndex set status = :status")
	})
public class MoneyIndex {
	private Long id;
	/**
	 * Хамгийн бага үнэ
	 */
	private int min;
	/**
	 * Хамгийн их үнэ
	 */
	private int max;
	/**
	 * Хамгийн бага,их үнэд харгалзах индекс 
	 */
	private int money_index;
	
	private StatusEnum status;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMoney_index() {
		return money_index;
	}
	public void setMoney_index(int money_index) {
		this.money_index = money_index;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
}
