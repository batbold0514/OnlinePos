package mn.infosystems.callcenter.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import mn.infosystems.callcenter.enums.TaxpayerStatus;

/**
 * @author Suld
 * @see Татвар төлөгч
 */
@Entity
@Table(name="taxpayer")
@NamedQueries({@NamedQuery(name="taxpayer.get",query="select tp from TaxPayer tp where avgDay >= :day and tp.id not in (select dt.taxPayer.id from Debt dt where  status = 0 and id in (select commit.debt.id from Commitment commit where paydate > now())) and tp.id not in (select pl.taxPayer.id from Plan pl where pl.date > cast(:d1 as timestamp) and pl.date <cast(:d2 as timestamp)) order by totalIndex desc"),
	@NamedQuery(name="taxpayer.phoneNumber",query="select tp from TaxPayer tp where tp.phoneNumber = :phoneNumber"),
})
/*
@NamedNativeQueries({
	@NamedNativeQuery(name="taxpayer.updateBalance",query="select updatebalance()")
})*/
public class TaxPayer {
	private Long id;
	/**
	 * Компаны нэр
	 */
	private String companyName;
	/**
	 * Татвар төлөгчийн дугаар
	 */
	private String regNumber;
	/**
	 * Захирлын нэр
	 */
	private String rectorFirstName;
	/**
	 * Захирлын овог
	 */
	private String rectorLastName;
	/**
	 * Факсны дугаар
	 */
	private String fax;
	/**
	 * Утасны дугаар
	 */
	private String phoneNumber;
	/**
	 * Е-мэйл хаяг
	 */
	private String email;
	/**
	 * Татвар төлөгчийн өрүүд
	 */
	private List<Debt> debtList;

	/**
	 * Дуудлагууд
	 */
	private List<Calls> calls;
	/**
	 * Нийт индекс
	 */
	private int totalIndex;
	/**
	 * Дундаж өдөр
	 */
	private Integer avgDay;
	
	/**
	 * Утасны дугаарууд
	 */
	private List<PhoneNumber> phones;
	
	/**
	 * Хариуцлагын хэлбэр
	 */
	private String etype;
	
	private int callQuantity;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getRectorFirstName() {
		return rectorFirstName;
	}

	public void setRectorFirstName(String rectorFirstName) {
		this.rectorFirstName = rectorFirstName;
	}

	public String getRectorLastName() {
		return rectorLastName;
	}

	public void setRectorLastName(String rectorLastName) {
		this.rectorLastName = rectorLastName;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@ManyToMany
	public List<Debt> getDebtList() {
		return debtList;
	}
	@Transient
	public List<Debt> getActiveDebtList(){
		List<Debt> list = new LinkedList<Debt>();
		for(Debt debt:debtList){
			if(debt.getStatus().equals(TaxpayerStatus.ACTIVE) && debt.getPayDate() == null){
				list.add(debt);
			}
		}
		return list;
	}
	public void setDebtList(List<Debt> debtList) {
		this.debtList = debtList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany
	public List<Calls> getCalls() {
		return calls;
	}

	public void setCalls(List<Calls> calls) {
		this.calls = calls;
	}

	public int getTotalIndex() {
		return totalIndex;
	}

	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}

	public Integer getAvgDay() {
		return avgDay;
	}

	public void setAvgDay(Integer avgDay) {
		this.avgDay = avgDay;
	}
	
	@ManyToMany
	public List<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}


	public String getEtype() {
		return etype;
	}

	public void setEtype(String etype) {
		this.etype = etype;
	}

	public int getCallQuantity() {
		return callQuantity;
	}

	public void setCallQuantity(int callQuantity) {
		this.callQuantity = callQuantity;
	}

	
}
