package mn.infosystems.estimator.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="carprice")
@NamedQueries({@NamedQuery(name="CarPrice.search",query="select cp from CarPrice cp where date > cast(:d1 as timestamp)"
		+ "and date < cast(:d2 as timestamp) and cast(factoryDate as integer ) >= :fd1 and cast(factoryDate as integer) <= :fd2"
		+ " and cast(factory.id as string) like :fid and cast(mark.id as string) like :mid")})
public class CarPrice {
	private Long id;
	private CarMark mark;
	private CarFactory factory;
	private float price;
	private String vinNumber;
	private String factoryDate;
	private String importedDate;
	private Employee estimator;
	private String description;
	private Date date;
	
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
	public CarMark getMark() {
		return mark;
	}
	public void setMark(CarMark mark) {
		this.mark = mark;
	}
	@ManyToOne
	public CarFactory getFactory() {
		return factory;
	}
	public void setFactory(CarFactory factory) {
		this.factory = factory;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getVinNumber() {
		return vinNumber;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public String getFactoryDate() {
		return factoryDate;
	}
	public void setFactoryDate(String factoryDate) {
		this.factoryDate = factoryDate;
	}
	public String getImportedDate() {
		return importedDate;
	}
	public void setImportedDate(String importedDate) {
		this.importedDate = importedDate;
	}
	@ManyToOne
	public Employee getEstimator() {
		return estimator;
	}
	public void setEstimator(Employee estimator) {
		this.estimator = estimator;
	}
	@Column(length=1000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
