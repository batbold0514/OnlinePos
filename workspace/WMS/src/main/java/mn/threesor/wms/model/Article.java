package mn.threesor.wms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import mn.threesor.wms.enums.MeasuringUnit;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
@Table(name = "Article")
@NamedQueries({
		// @NamedQuery(name = "Article.getNameAndBarCode", query =
		// "select a from Article a where UPPER(name) like UPPER(:name) and barCode like :barCode order by name"),
		@NamedQuery(name = "Article.getAll", query = "select a from Article a order by name"),
		@NamedQuery(name = "Article.getArticle", query = "SELECT article FROM Article article WHERE id = :id"),
		@NamedQuery(name = "Article.check", query = "select a from Article a where a.name like :name and a.location.locationName like :location"
				+ " and a.colour.name like :colour and a.barCode like :barCode and size.sizes like :size"),
		@NamedQuery(name = "Article.checkUpdate", query = "select a from Article a where a.name like :name and"
				+ " (a.location.id like :location or a.location is null )"
				+ " and (a.size.id like :size or a.size is null)"
				+ " and (a.colour.code like :code or a.colour is null)"
				+ " and a.barCode like :barCode"),
		@NamedQuery(name = "Article.1", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode"),
		@NamedQuery(name = "Article.2", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id like :location"),
		@NamedQuery(name = "Article.3", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.colour.code like :colour"),
		@NamedQuery(name = "Article.4", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.size.id like :size"),
		@NamedQuery(name = "Article.5", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.size.id like :size and a.location.id like :location"),
		@NamedQuery(name = "Article.6", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.size.id like :size and a.colour.code like :colour"),
		@NamedQuery(name = "Article.7", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id like :location and a.colour.code like :colour"),
		@NamedQuery(name = "Article.8", query = "select a from Article a where UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id like :location and a.colour.code like :colour and a.size.id like :size"),
		@NamedQuery(name = "Article.9", query = "select a from Article a where a.category.id like :category and a.measuring_unit.id like :unit and a.name like :name and a.barCode like :barCode and a.location is null and a.size is null and a.colour is null"),
		@NamedQuery(name = "Article.10", query = "select a from Article a where a.category.id like :category and UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id like :location and a.size is null and a.colour is null"),
		@NamedQuery(name = "Article.11", query = "select a from Article a where a.category.id like :category and UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id like :location and a.size.id like :size and a.colour is null"),
		@NamedQuery(name = "Article.12", query = "select a from Article a where a.category.id like :category and UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id like :location and a.size is null and a.colour.code like :colour"),
		@NamedQuery(name = "Article.13", query = "select a from Article a where a.category.id like :category and UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id is null and a.size is null and a.colour.code like :colour"),
		@NamedQuery(name = "Article.14", query = "select a from Article a where a.category.id like :category and UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id is null and a.size.id like :size and a.colour.code like :colour"),
		@NamedQuery(name = "Article.15", query = "select a from Article a where a.category.id like :category and UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id is null and a.size.id like :size and a.colour is null"),
		@NamedQuery(name = "Article.16", query = "select a from Article a where a.category.id like :category and UPPER(a.name) like UPPER(:name) and a.barCode like :barCode and a.location.id like :location and a.size.id like :size and a.colour.code like :colour"),
		@NamedQuery(name = "Article.updateLocCount", query = "update Article a set a.count = :countLoc,a.location.id = :loc where a.id=:id"),
		@NamedQuery(name = "ArticleDelete", query = "delete from Article where id = :id"),
		@NamedQuery(name = "Article.getOrder", query = "select a from Article a order by name,barCode,colour,size")
// @NamedQuery(name = "Article.getMinCountCount", query =
// "select sum(a.count) from Article a group by a.name, a.barcode, a.size.id, a.colour.id"),
// (name = "Article.getMinCountID", query =
// "select id from Article a group by a.name, a.barcode, a.size.id, a.colour.id")

})
public class Article {
	private Long id;
	private String name;
	private String serialNumber;
	private String barCode;
	private String description;
	private String buyPrice;
	private String sellPrice;
	private int packageWeight;
	private double count;
	private double minCount;
	private int moisture;
	private String partNumber;
	private MeasuringUnit measuring_unit;
	private Size size;
	private Colour colour;
	private Category category;
	private Employee owner;
	private LocationWms location;
	private Measure measure;
	private transient String buyPriceNumber;
	private transient String sellPriceNumber;

	public Article() {
	}

	public Article(Article article) {
		this.id = null;
		this.count = article.getCount();
		this.name = article.getName();
		this.measuring_unit = article.getMeasuring_unit();
		this.buyPrice = article.getBuyPrice();
		this.sellPrice = article.getSellPrice();
		this.minCount = article.getMinCount();
		this.description = article.getDescription();
		this.location = article.getLocation();
		this.owner = article.getOwner();
		this.serialNumber = article.getSerialNumber();
		this.packageWeight = article.getPackageWeight();
		this.moisture = article.getMoisture();
		this.size = article.getSize();
		this.colour = article.getColour();
		this.category = article.getCategory();
		this.partNumber = article.getPartNumber();
		this.barCode = article.getBarCode();
		this.measure = article.getMeasure();
	}

	@Id
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	@RequiredStringValidator(key = "validation.article.name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeasuringUnit getMeasuring_unit() {
		return measuring_unit;
	}

	public void setMeasuring_unit(MeasuringUnit measuring_unit) {
		this.measuring_unit = measuring_unit;
	}

	public String getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	@Transient
	public String getBuyPriceNumber() {
		if (buyPrice != null) {
			this.buyPriceNumber = StringToNumber(this.buyPrice);
		} else {
			this.buyPriceNumber = "";
		}
		return buyPriceNumber;
	}

	@Transient
	public String getSellPriceNumber() {
		if (sellPrice != null) {
			this.sellPriceNumber = StringToNumber(this.sellPrice);
		} else {
			this.sellPriceNumber = "";
		}
		return sellPriceNumber;
	}

	@Transient
	public void setBuyPriceNumber(String buyPriceNumber) {
		this.buyPriceNumber = buyPriceNumber;
	}

	@Transient
	public void setSellPriceNumber(String sellPriceNumber) {
		this.sellPriceNumber = sellPriceNumber;
	}

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getMinCount() {
		return minCount;
	}

	public void setMinCount(double minCount) {
		this.minCount = minCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	public LocationWms getLocation() {
		return location;
	}

	public void setLocation(LocationWms location) {
		this.location = location;
	}

	@ManyToOne
	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getMoisture() {
		return moisture;
	}

	public void setMoisture(int moisture) {
		this.moisture = moisture;
	}

	@ManyToOne
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@ManyToOne
	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	@ManyToOne
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPackageWeight() {
		return packageWeight;
	}

	public void setPackageWeight(int packageWeight) {
		this.packageWeight = packageWeight;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@ManyToOne
	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	private String StringToNumber(String number) {
		int count = number.length();
		while (count > 3) {
			count -= 3;
			number = number.substring(0, count) + "," + number.substring(count);
		}
		return number;
	}
}
