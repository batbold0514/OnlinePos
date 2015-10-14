package mn.threesor.tims.model;

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
@Table(name = "stepPrice")
@NamedQueries({
	@NamedQuery(name = "stepPrice.getListProductStep" , query="select sp.productStep from StepPrice sp where productModel = :id"),
	@NamedQuery(name = "stepPrice.updatePrice", query ="update StepPrice set price = :price where id=:id")})

public class StepPrice {
	private Long id;
	private Long productModel;			//загвар
	private ProductionStep productStep;	//дамжлага
	private int price;					//тухайн загварын дамжлагын тариф
	public StepPrice(){
		price = 0;
	}
	public StepPrice(ProductionStep productStep, Long productModel, int price) {
		this.productStep =productStep;
		this.productModel = productModel;
		this.price = price;
	}

	public StepPrice(ProductionStep productStep, Long productModel) {
		this.productStep = productStep;
		this.productModel = productModel;
		this.price = 0;
	}

	public StepPrice(ProductionStep productStep) {
		this.productStep = productStep;
		this.price = 0;
	}

	public StepPrice(StepPrice productStep) {
		this.productStep = productStep.getProductStep();
		this.productModel = productStep.getProductModel();
		this.price = productStep.getPrice();
	}

	public StepPrice(Long id, ProductionStep productStep, Long productModel,
			int price) {
		this.id = id;
		this.productStep = productStep;
		this.productModel = productModel;
		this.price = price;
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

	public Long getProductModel() {
		return productModel;
	}

	public void setProductModel(Long productModel) {
		this.productModel = productModel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@ManyToOne
	public ProductionStep getProductStep() {
		return productStep;
	}

	public void setProductStep(ProductionStep productStep) {
		this.productStep = productStep;
	}

}
