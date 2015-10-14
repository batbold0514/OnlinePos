package mn.threesor.tims.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "ProductModelCode")
@NamedQueries({
		@NamedQuery(name = "ProductModelCode.getLastAdd", query = "select pmc from ProductModelCode pmc order by id desc limit 1"),
		@NamedQuery(name = "ProductModelCode.getLastModelId", query = "SELECT p FROM ProductModelCode p WHERE number = (SELECT MAX(number) FROM ProductModelCode WHERE category LIKE :category AND material LIKE :material AND gauge LIKE :gauge AND productType LIKE :productType)"),
		@NamedQuery(name = "ProductModelCode.getCode", query = "select p from ProductModelCode p where category like :category and material like :material and gauge like :gauge and number like :number and productType like :type"), 
		@NamedQuery(name = "ProductModelCode.getCodeWithNumber", query = "select p from ProductModelCode p where category like :category and material like :material and gauge like :gauge and number like :number and productType like :type")})
public class ProductModelCode {
	private Long id;
	private String category;
	private String material;
	private String gauge;
	private String productType;
	private String number;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	@RequiredStringValidator(message = "input")
	public void setCategory(String category) {
		this.category = category;
	}

	public String getMaterial() {
		return material;
	}

	@RequiredStringValidator(message = "input")
	public void setMaterial(String material) {
		this.material = material;
	}

	public String getGauge() {
		return gauge;
	}

	@RequiredStringValidator(message = "input")
	public void setGauge(String gauge) {
		this.gauge = gauge;
	}

	public String getProductType() {
		return productType;
	}

	@RequiredStringValidator(message = "input")
	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		if(number.length() == 1) number="00"+number; else
		if(number.length() == 2) number="0"+number;
		this.number = number;
	}

	public String takeProductModelCode() {
		return material + category + "-" + gauge + "-"
				+ productType.substring(0, 2) + "-" + number;
	}

}