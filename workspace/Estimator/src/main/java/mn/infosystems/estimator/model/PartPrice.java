package mn.infosystems.estimator.model;

import java.util.Date;

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
@Table(name = "PartPrice")
@NamedQueries({ @NamedQuery(name = "partprice.get", query = "select cp from PartPrice cp where date >= cast(:d1 as timestamp)"
		+ "and date < cast(:d2 as timestamp)"
		+ "and cast(factoryDate as integer ) >= :fd1 and cast(factoryDate as integer) <= :fd2"
		+ " and cast(partFactory.id as string) like :fid and cast(partMark.id as string) like :mid and partName like :name") })
public class PartPrice {
	private Long id;
	private Date date;
	private String factoryDate;
	private String partName;
	private CarFactory partFactory;
	private CarMark partMark;
	private float price;
	private Employee estimator;
	private String description;

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the factoryDate
	 */
	public String getFactoryDate() {
		return factoryDate;
	}

	/**
	 * @param factoryDate
	 *            the factoryDate to set
	 */
	public void setFactoryDate(String factoryDate) {
		this.factoryDate = factoryDate;
	}

	/**
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName
	 *            the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the estimator
	 */
	@ManyToOne
	public Employee getEstimator() {
		return estimator;
	}

	/**
	 * @param estimator
	 *            the estimator to set
	 */
	public void setEstimator(Employee estimator) {
		this.estimator = estimator;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	public CarFactory getPartFactory() {
		return partFactory;
	}

	public void setPartFactory(CarFactory partFactory) {
		this.partFactory = partFactory;
	}

	@ManyToOne
	public CarMark getPartMark() {
		return partMark;
	}

	public void setPartMark(CarMark partMark) {
		this.partMark = partMark;
	}

}
