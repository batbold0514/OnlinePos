package mn.infosystems.callcenter.enums;

public enum CallStatus {
	
	Nocall(0l,"Дуудлага хийгээгүй"),
	InCall(1l,"Дуудлага хийж байна"),
	Danger(2l,"Дуудлага хэвийн хэмжээнээс хэтэрсэн");
	
	private Long id;
	private String description;
	
	CallStatus(Long id, String description) {
		this.setId(id);
		this.setDescription(description);
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
