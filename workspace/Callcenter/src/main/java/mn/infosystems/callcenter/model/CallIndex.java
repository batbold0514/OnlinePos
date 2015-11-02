package mn.infosystems.callcenter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 * @author Suld
 * @see Дуудлагын индекс
 */
@Entity
@Table(name="callIndex")
public class CallIndex {
	private Long id;
	/*
	 Дуудлага харгалзах индекс
	 */
	private int callIndex;
	/*
	Дуудлага хийсэн тоо
	 */
	private int callQuantity;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCallIndex() {
		return callIndex;
	}
	public void setCallIndex(int callIndex) {
		this.callIndex = callIndex;
	}
	public int getCallQuantity() {
		return callQuantity;
	}
	public void setCallQuantity(int callQuantity) {
		this.callQuantity = callQuantity;
	}
	
	
}
