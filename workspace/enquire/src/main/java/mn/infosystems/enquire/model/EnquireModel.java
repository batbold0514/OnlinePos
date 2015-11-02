package mn.infosystems.enquire.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "enquireModel")

public class EnquireModel {
	private Long id;
	/*
	 * Захиалгын дугаар
	 */
	private String enquireNumber;
	/*
	 * Үнэ
	 */
	private Double price;
	/*
	 * Банкын нэр
	 */
	private String bankName;
	/*
	 * Банкын дугаар
	 */
	private String bankNumber;
	/*
	 * Утас
	 */
	private Date createDate = new Date();
	/*
	 * Төрөл
	 */
	private EnquireType enquireType;
//	private Branch branch;
//	private Department department
	private Customer customer;
	private List<ItemName> listOfItemName;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@OneToOne
	public EnquireType getEnquireType() {
		return enquireType;
	}
	public void setEnquireType(EnquireType enquireType) {
		this.enquireType = enquireType;
	}
	public String getEnquireNumber() {
		return enquireNumber;
	}
	public void setEnquireNumber(String enquireNumber) {
		this.enquireNumber = enquireNumber;
	}

	@OneToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToMany
	public List<ItemName> getListOfItemName() {
		return listOfItemName;
	}

	public void setListOfItemName(List<ItemName> listOfItemName) {
		this.listOfItemName = listOfItemName;
	}
	
	
	
}
