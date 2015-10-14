package mn.infosystems.estimator.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Suld
 * <br> Сэлбэг
 */
@Entity
@Table(name="part")
public class Part {
	private Long id;
	private CarMark carMark;
	private Date date;
	private Date factoryDate;
	private String partName;
	private int price;
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
	@ManyToOne
	public CarMark getCarMark() {
		return carMark;
	}
	public void setCarMark(CarMark carMark) {
		this.carMark = carMark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getFactoryDate() {
		return factoryDate;
	}
	public void setFactoryDate(Date factoryDate) {
		this.factoryDate = factoryDate;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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
