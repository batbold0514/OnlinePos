package mn.infosystems.estimator.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	private Long id;
	private Date date;
	private CarMark carmark;
	private Date factoryDate;
	private Date importedDate;
	/**
	 * Vihicle Identificatiuon Number буюу арлын дугаар
	 */
	private String vin;
	private Long price;
	private String estimate;
	private String description;
	
	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne
	public CarMark getCarmark() {
		return carmark;
	}
	public void setCarmark(CarMark carmark) {
		this.carmark = carmark;
	}
	public Date getFactoryDate() {
		return factoryDate;
	}
	public void setFactoryDate(Date factoryDate) {
		this.factoryDate = factoryDate;
	}
	public Date getImportedDate() {
		return importedDate;
	}
	public void setImportedDate(Date importedDate) {
		this.importedDate = importedDate;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getEstimate() {
		return estimate;
	}
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
