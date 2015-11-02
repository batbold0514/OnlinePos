package mn.infosystems.callcenter.enums;

public enum StatusEnum {

	active(0l, "Идэвхтэй"), inActive(1l, "Идэвхгүй");

	private Long id;
	private String description;

	StatusEnum(Long id, String description) {
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
