package mn.infosystems.callcenter.enums;

public enum PauseStatus {
	
	work(0l, "Ажиллаж байгаа"), wait(1l, "Завсарлага авсан");
	
	private Long id;
	private String description;
	
	PauseStatus(Long id, String description) {
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
