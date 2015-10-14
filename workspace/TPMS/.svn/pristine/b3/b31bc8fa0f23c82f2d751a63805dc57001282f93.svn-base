package mn.threesor.tims.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import mn.threesor.tims.enums.ProductModelActivity;

@Entity
@Table(name = "productModel")
@NamedQueries({
		@NamedQuery(name = "productModel.setProductModel", query = "UPDATE StepPrice s SET s.productModel =(select max(pm.id) from ProductModel pm) where s.productModel is null"),
		@NamedQuery(name = "productModel.getAllProductionStep", query = "SELECT ps FROM ProductionStep ps"),
		@NamedQuery(name = "productModel.getSomeStepPrice", query = "SELECT sp FROM StepPrice sp WHERE price > 0 AND productStep_id LIKE :productStep_id"),
		@NamedQuery(name = "ProductModel.stepPrices", query = "select pm.listOfStepPrice from ProductModel pm where pm.id = :id"),
		@NamedQuery(name = "ProductModel.getImages", query = "select pm.imageList from ProductModel pm where pm.id = :id"),
		@NamedQuery(name = "updateStatusDesc", query = "update ProductModel set status=:status, description=:description,chordPrice=:chordPrice,"
				+ "unitChordPrice=:unitChordPrice,aidPrice=:aidPrice,sellPrice=:sellPrice,modelId=:modelId,percent=:percent,"
				+ "stoll=:stoll,yarnNumber=:ynumber where id =:id"),
		@NamedQuery(name = "productModel.getLastImageId", query = "SELECT im FROM Image im WHERE id = (SELECT MAX(id) FROM Image)"),
		@NamedQuery(name = "productModel.getOnePM", query = "SELECT pm FROM ProductModel pm WHERE id = :id"),
		@NamedQuery(name = "productModel.getOnePMupModel", query = "SELECT pm FROM ProductModel pm WHERE modelId = :model and status = 0"),
		@NamedQuery(name = "productModel.getActiveList", query = "SELECT pm FROM ProductModel pm WHERE status = 0"),
		@NamedQuery(name = "productmodel.check", query = "select pm from ProductModel pm where modelid like :model and id<>:id"),
		@NamedQuery(name = "productModel.findAll",query = "select pm from ProductModel pm order by  substr(pm.modelId,5,2),pm.modelId"),
		@NamedQuery(name = "productModel.getColors", query="select listOfColours from ProductModel pm"),
		@NamedQuery(name = "productModel.getModelId", query="select pm from ProductModel pm where modelId = :model"),
})
public class ProductModel {
	private Long id;
	private String modelId; //Загварын дугаар
	private float stoll; //Столл
	private List<StepPrice> listOfStepPrice; // Дамжлагын үнэ,нэр
	private ProductModelActivity Status = ProductModelActivity.active; //Төлөв
	private String description; // Дэлгэрэнгүй
	private List<Image> imageList; //Зураг
	private int chordPrice; // Утас(граммаар)
	private int unitChordPrice;// Утасны нэгж үнэ (₮/кг)
	private int aidPrice;// Туслах материал (₮)
	private int sellPrice;// Худалдах үнэ (₮)
	private int percent = 0; //Процент
	private transient StollPrice stollPrice; //Столл
	private String yarnNumber; //Утасны дугаар
	private List<ColoursPercent> listOfColours; //Өнгөний алаг
    
	public ProductModel() {
	}

	public ProductModel(ProductModel pm) {
		this.id = pm.getId();
		this.modelId = pm.getModelId();
		this.stoll = pm.getStoll();
		this.listOfStepPrice = pm.getListOfStepPrice();
		this.Status = pm.getStatus();
		this.description = pm.getDescription();
		this.imageList = pm.getImageList();
		this.chordPrice = pm.getChordPrice();
		this.unitChordPrice = pm.getUnitChordPrice();
		this.aidPrice = pm.getAidPrice();
		this.sellPrice = pm.getSellPrice();
		this.percent = pm.getPercent();
		this.yarnNumber = pm.getYarnNumber();
		this.listOfColours = pm.getListOfColours();
	}

	public ProductModel(String model_id, float stoll,
			List<StepPrice> listOfStepPrice) {
		this.modelId = model_id;
		this.stoll = stoll;
		this.listOfStepPrice = listOfStepPrice;
	}

	public ProductModel(Long id, String model_id, float stoll,
			List<StepPrice> listOfStepPrice) {
		this.id = id;
		this.modelId = model_id;
		this.stoll = stoll;
		this.listOfStepPrice = listOfStepPrice;
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

	public float getStoll() {
		return stoll;
	}

	public void setStoll(String stoll) {
		try {
			if (stoll.equals(""))
				this.stoll = 0;
			else
				this.stoll = Float.parseFloat(stoll);
		} catch (Exception e) {
			this.stoll = -1;
		}
	}

	public void setStoll(float stoll) {
		this.stoll = stoll;
	}

	@ManyToMany
	public List<StepPrice> getListOfStepPrice() {
		return listOfStepPrice;
	}

	public void setListOfStepPrice(List<StepPrice> listOfStepPrice) {
		this.listOfStepPrice = listOfStepPrice;
	}

	public ProductModelActivity getStatus() {
		return Status;
	}

	public void setStatus(ProductModelActivity status) {
		Status = status;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany
	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}

	@Transient
	public StollPrice getStollPrice() {
		return stollPrice;
	}

	@Transient
	public void setStollPrice(StollPrice stollPrice) {
		this.stollPrice = stollPrice;
	}

	// Нийт зардал
	@Transient
	public int getTotalCostPrice() {
		int s = 0;
		s += getOtherCosts();	
		if(percent !=0) {s += getOtherCosts()*2;}
		else{
			for (StepPrice sp : listOfStepPrice) {
				s += sp.getPrice();
			}
			s += getTotalChordPrice();
		}
		s += aidPrice;
		return s;
	}

	public int getChordPrice() {
		return chordPrice;
	}

	public void setChordPrice(String chordPrice) {
		chordPrice = chordPrice.trim();
		try {
			if (chordPrice.equals(" ") || chordPrice.equals("")) {
				this.chordPrice = 0;
			} else {
				this.chordPrice = Integer.parseInt(chordPrice);
			}
		} catch (Exception e) {
			this.chordPrice = -1;
		}
	}

	public void setChordPrice(int chordPrice) {
		this.chordPrice = chordPrice;
	}

	public int getUnitChordPrice() {
		return unitChordPrice;
	}

	public void setUnitChordPrice(String unitChordPrice) {
		unitChordPrice = unitChordPrice.trim();
		try {
			if (unitChordPrice.equals(" ") || unitChordPrice.equals("")) {
				this.unitChordPrice = 0;
			} else {
				this.unitChordPrice = Integer.parseInt(unitChordPrice);
			}
		} catch (Exception e) {
			this.unitChordPrice = -1;
		}
	}

	public void setUnitChordPrice(int unitChordPrice) {
		this.unitChordPrice = unitChordPrice;
	}

	public int getAidPrice() {
		return aidPrice;
	}

	public void setAidPrice(String aidPrice) {
		aidPrice = aidPrice.trim();
		try {
			if (aidPrice.equals(" ") || aidPrice.equals("")) {
				this.aidPrice = 0;
			} else {
				this.aidPrice = Integer.parseInt(aidPrice);
			}
		} catch (Exception e) {
			this.aidPrice = -1;
		}
	}

	public void setAidPrice(int aidPrice) {
		this.aidPrice = aidPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public void setPercent(String percent) {
		percent = percent.trim();
		if (percent.equals(""))
			this.percent = 0;
		else
			this.percent = Integer.parseInt(percent);
	}

	public void setSellPrice(String sellPrice) {
		sellPrice = sellPrice.trim();
		try {
			if (sellPrice.equals(" ") || sellPrice.equals("")) {
				this.sellPrice = -1;
			}
			this.sellPrice = Integer.parseInt(sellPrice);
		} catch (Exception e) {
			this.aidPrice = -1;
		}
	}

	// Утасны нийт үнэ (₮)
	@Transient
	public int getTotalChordPrice() {
		int totalChordPrice = 0;
		totalChordPrice = (unitChordPrice * chordPrice);
		totalChordPrice /= 1000;
		return totalChordPrice;
	}

	// Бусад зардал (%)
	@Transient
	public int getOtherCosts() {
		int s = 0;
		for (StepPrice sp : listOfStepPrice) {
			s += sp.getPrice();
		}
		s += getTotalChordPrice();
		s *= percent;
		s /= 100;
		return s;
	}

	// Дундаж ашиг (%)
	@Transient
	public int getAverageEarnings() {
		float averageEarnings = 0;
		averageEarnings = sellPrice - getTotalCostPrice();
		averageEarnings *= 100;
		averageEarnings /= getTotalCostPrice();
		averageEarnings += 0.5;
		return (int) averageEarnings;
	}

	public String getYarnNumber() {
		return yarnNumber;
	}

	public void setYarnNumber(String yarnNumber) {
		this.yarnNumber = yarnNumber;
	}

	@ManyToMany
	public List<ColoursPercent> getListOfColours() {
		return listOfColours;
	}

	public void setListOfColours(List<ColoursPercent> listOfColours) {
		this.listOfColours = listOfColours;
	}

	@Transient
	public int getshx() {
		int shx = 0;

		for (int i = 0; i < listOfStepPrice.size(); i++) {
			shx += listOfStepPrice.get(i).getPrice();
		}
		return shx;
	}

	@Transient
	public int getshxFull() {
		int shx = 0;

		for (int i = 0; i < listOfStepPrice.size(); i++) {
			if (listOfStepPrice.get(i).getProductStep().getId() == 1000) {
				shx+=this.stoll*stollPrice.getSellPrice();
			} else {
				shx += listOfStepPrice.get(i).getPrice();
			}
		}
		return shx;
	}

}
