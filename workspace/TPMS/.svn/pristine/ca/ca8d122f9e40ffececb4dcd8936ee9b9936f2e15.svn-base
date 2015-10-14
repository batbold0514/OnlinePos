package mn.threesor.tims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "ProductType", uniqueConstraints = @UniqueConstraint(columnNames = "prefix", name = "registrationNumber"))
@NamedQueries({@NamedQuery(name = "productType.getActiveList", query="SELECT pt from ProductType pt where active = 'true'"),
	@NamedQuery(name="productType.get",query="select pt from ProductType pt where prefix like :prefix")})
public class ProductType {
	private Long id;
	private String name;
	@Column(length = 2, name = "prefix", unique = true)
	private String prefix;
	private boolean active;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@RequiredStringValidator(key="validation.required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean getActive() {
		return active;
	}
	@RequiredStringValidator(key="required.prefix")
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		prefix = checkPrefix(prefix);
		this.prefix = prefix;
	}
	
	private String checkPrefix(String s){
		if(s.length()==1) s="0"+s;
		return s.matches("\\d{2}")?s:"";
	}
	
}
