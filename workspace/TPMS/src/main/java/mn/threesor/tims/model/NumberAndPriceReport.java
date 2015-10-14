package mn.threesor.tims.model;

import javax.persistence.Transient;

public class NumberAndPriceReport {
	private TrackingSheet trackingSheet;//загвар
	private Long quantity;//тоо ширхэг
	public NumberAndPriceReport(){
	}
	public NumberAndPriceReport(NumberAndPriceReport numberAndPriceReport){
		this.trackingSheet = numberAndPriceReport.getTrackingSheet();
		this.quantity = numberAndPriceReport.getQuantity();
	}
	public NumberAndPriceReport(TrackingSheet tr , Long quantity){
		this.trackingSheet = tr;
		this.quantity = quantity;
	}

	public TrackingSheet getTrackingSheet() {
		return trackingSheet;
	}
	public void setTrackingSheet(TrackingSheet trackingSheet) {
		this.trackingSheet = trackingSheet;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Transient
	public Long getTotalCostPrice(){
		return quantity*trackingSheet.getProductModel().getTotalCostPrice();
	}
	@Transient
	public Long getSellPrice(){
		return quantity*trackingSheet.getProductModel().getSellPrice();
	}
	
}
