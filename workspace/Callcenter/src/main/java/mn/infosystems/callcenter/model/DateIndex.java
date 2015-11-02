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
 * @see Өдрийн индекс
 */
@Entity
@Table(name="dateIndex")
@NamedQueries({@NamedQuery(name = "dateIndex.getIndex",query = "select d.date_index from DateIndex d where :balance >= d.min and :balance <= d.max"),
	@NamedQuery(name = "dateIndex.checkBalance", query = "select d from DateIndex d where :balance >= d.min and :balance <= d.max and d.id != :id"),
	@NamedQuery(name = "dateindex.updateStatus" , query = "update DateIndex set status = :status")
})
public class DateIndex {
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
	private int date_index;
	
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
	public int getDate_index() {
		return date_index;
	}
	public void setDate_index(int date_index) {
		this.date_index = date_index;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
}
