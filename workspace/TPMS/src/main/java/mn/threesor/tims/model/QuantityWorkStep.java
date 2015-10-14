package mn.threesor.tims.model;

import java.util.LinkedList;
import java.util.List;

public class QuantityWorkStep {
	private ProductionStep productionStep;
	private List<Integer> listOfLocation;
	private int quantity;
	public QuantityWorkStep(ProductionStep productionStep , int quantity ,Integer location){
		this.productionStep = productionStep;
		this.quantity = quantity;
		this.listOfLocation = new LinkedList<Integer>();
		this.listOfLocation.add(location);
	} 
	public List<Integer> getListOfLocation() {
		return listOfLocation;
	}
	public void setListOfLocation(List<Integer> listOfLocation) {
		this.listOfLocation = listOfLocation;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductionStep getProductionStep() {
		return productionStep;
	}
	public void setProductionStep(ProductionStep productionStep) {
		this.productionStep = productionStep;
	}
	public void addLocation(Integer loc){
		listOfLocation.add(loc);
	}
	
}
