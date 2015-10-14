package mn.chinbat.surgery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity()
@Table(name = "servicePrice")
@NamedQueries({ @NamedQuery(name = "ServicePrice.list", query = ""
		+ "select e from ServicePrice e where e.active like :act"),
		@NamedQuery(name = "ServicePrice.active", query = ""
				+ "select e from ServicePrice e where e.active like '1' and e.code =:code"),
				@NamedQuery(name = "ServicePrice.codeAndID", query = ""
						+ "select e from ServicePrice e where e.active like '1' and e.code =:code and e.id != :id")})
public class ServicePrice {
	private Long id;
	@Column(length = 4, name = "code")
	private String code;
	private String name;
	private String description;
	private int price;
	private String active = "1";

	public ServicePrice() {
	}

	public ServicePrice(String code, String name, String description,
			int price, String active) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.active = active;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	@RequiredStringValidator(key = "validation.code")
	public String getCode() {
		return code;
	}

	public String checkCode(String s) {
		return s.matches("[0-9]{4}") ? s : null;
	}

	public void setCode(String code) {
		code = checkCode(code);
		this.code = code;
	}

	@RequiredStringValidator(key = "validation.required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active1) {
		this.active = active1;
	}
}
