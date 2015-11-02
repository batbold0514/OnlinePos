package mn.infosystems.callcenter.enums;

public enum TaxpayerStatus {
	 
	ACTIVE(0l,"Callcenter дээр байгаа"),
	INACTIVE(1l,"Татварын баазруу буцсан");
	
	private Long id;
	private String description;
	
	TaxpayerStatus(Long id,String description){
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
