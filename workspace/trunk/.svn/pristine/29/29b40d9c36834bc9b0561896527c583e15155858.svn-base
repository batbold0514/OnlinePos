package mn.chinbat.surgery.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PaymentNumberCounter")
@NamedQueries(@NamedQuery(name="PaymentNumberCounterQuerry",query="select n from PaymentNumberCounter n"))
public class PaymentNumberCounter {
	private Long id;
	private long cash;
	private long card;
	private long bankTransfer;
	private long moneyBack;
	
	public PaymentNumberCounter(){
		this.setId(0l);
		this.setCash(0);
		this.setCard(0);
		this.setBankTransfer(0);
		this.setMoneyBack(0);
	}
	
	@Id
    @PrimaryKeyJoinColumn
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Long getCash() {
		return cash;
	}
	
	public void setCash(long cash) {
		this.cash = cash;
	}
	
	public Long getCard() {
		return card;
	}
	
	public void setCard(long card) {
		this.card = card;
	}
	
	public Long getBankTransfer() {
		return bankTransfer;
	}
	
	public void setBankTransfer(long bankTransfer) {
		this.bankTransfer = bankTransfer;
	}
	
	public Long getMoneyBack() {
		return moneyBack;
	}
	
	public void setMoneyBack(long moneyBack) {
		this.moneyBack = moneyBack;
	}

}
