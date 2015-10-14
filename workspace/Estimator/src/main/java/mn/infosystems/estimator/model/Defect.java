package mn.infosystems.estimator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import mn.infosystems.estimator.enums.CrashGrade;

/**
 * @author Suld <br>
 *         Эвдрэл
 */
@Entity
@Table(name = "defect")
public class Defect {
	private Long id;
	/**
	 * Эвдэрсэн эд анги
	 */
	private BreakedPart breakedPart;
	/**
	 * Эвдрэлийн зэрэг
	 */
	private CrashGrade crashGrade;
	/**
	 * Засах үнэ
	 */
	private Integer repairPrice;
	/**
	 * Солих үнэ
	 */
	private Integer changePrice;
public Defect(){
	breakedPart = null;
	crashGrade = null;
	changePrice =0;
	repairPrice = 0;
	
}
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	public BreakedPart getBreakedPart() {
		return breakedPart;
	}

	public void setBreakedPart(BreakedPart breakedPart) {
		this.breakedPart = breakedPart;
	}

	public CrashGrade getCrashGrade() {
		return crashGrade;
	}

	public void setCrashGrade(CrashGrade crashGrade) {
		this.crashGrade = crashGrade;
	}

	public Integer getRepairPrice() {
		return repairPrice;
	}

	public void setRepairPrice(Integer repairPrice) {
		this.repairPrice = repairPrice;
	}

	public Integer getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(Integer changePrice) {
		this.changePrice = changePrice;
	}

}
