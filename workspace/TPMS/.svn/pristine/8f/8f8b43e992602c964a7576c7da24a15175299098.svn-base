package mn.threesor.tims.enums;

public enum ProductModelActivity {
	active 		(0l,"Идэвхитэй"),
	inActive	(1l,"Идэвхигүй");
	private Long id;
	private String label;
	private ProductModelActivity(Long id , String label){
		this.id = id;
		this.label = label;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public static ProductModelActivity[] valuesActive(){
		ProductModelActivity[] values = {active,inActive};
		return values;
	}
}
