package mn.infosystems.callcenter.model;

/**
 * @author Dell
 * @see Тайлан гаргахад хэрэглэх өрийг өргөтгасан класс
 */
public class Debtx {
	private Debt debt;
	private int balanceIndex;
	private int dateIndex;
	private int date;
	
	public Debt getDebt() {
		return debt;
	}
	public void setDebt(Debt debt) {
		this.debt = debt;
	}
	public int getBalanceIndex() {
		return balanceIndex;
	}
	public void setBalanceIndex(int balanceIndex) {
		this.balanceIndex = balanceIndex;
	}
	public int getDateIndex() {
		return dateIndex;
	}
	public void setDateIndex(int dateIndex) {
		this.dateIndex = dateIndex;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
}
