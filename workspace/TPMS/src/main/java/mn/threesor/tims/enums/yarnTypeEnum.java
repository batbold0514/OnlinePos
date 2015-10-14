package mn.threesor.tims.enums;

public enum yarnTypeEnum {
	empty		(-1l,""),
	kashmir		(0l,"Ноолуур"),
	wool		(1l,"Ноос"),
	yakMolt		(2l,"Сарлагийн_хөөвөр"),
	camelWoll	(3l,"Тэмээний_ноос"),
	kashmirSilk	(4l,"Ноолуур_торготой"),
	woolSilk	(5l,"Ноос_торготой"); 
private Long id;
	private String label;
	private yarnTypeEnum(Long id , String label){
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
