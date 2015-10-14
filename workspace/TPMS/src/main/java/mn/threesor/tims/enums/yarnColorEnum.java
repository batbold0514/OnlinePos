package mn.threesor.tims.enums;

public enum yarnColorEnum {
	empty		(-1l,""),
	E1049	(0l,"E1049"),
	E1051	(1l,"E1051"),
	E1052	(2l,"E1052");
	private Long id;
	private String label;
	private yarnColorEnum(Long id , String label){
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
	
}
