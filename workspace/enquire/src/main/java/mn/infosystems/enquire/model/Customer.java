package mn.infosystems.enquire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(columnNames = "enquireName", name = "enquireName"))
@NamedQueries({
	@NamedQuery(name="customer.getByEnquireName",query="select c from Customer c where enquireName like :enquireName")
	})
public class Customer {
	private Long id;
	private Users user;
	/*
	 * Үйлчлүүлэгчийн нэр
	 * */
	private String enquireName;
	
	private String phone;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@OneToOne
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEnquireName() {
		return enquireName;
	}
	public void setEnquireName(String enquireName) {
		this.enquireName = enquireName;
	}
	
	
	
}
