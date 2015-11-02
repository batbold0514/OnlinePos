package mn.infosystems.callcenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AccountNumber",uniqueConstraints={@UniqueConstraint(columnNames={"officeNumber","debtTypeNumber"})})
public class AccountNumber {
	private Long id;
	/**
	 * Дансны дугаар
	 */
	private String number;
	/**
	 * Банкны нэр
	 */
	private String bankName;
	/**
	 * Албадын дугаар
	 */
	private String officeNumber;
	/**
	 * Өрийн төрлийн дугаар
	 */
	private String debtTypeNumber;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 30)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getDebtTypeNumber() {
		return debtTypeNumber;
	}

	public void setDebtTypeNumber(String debtTypeNumber) {
		this.debtTypeNumber = debtTypeNumber;
	}

}
