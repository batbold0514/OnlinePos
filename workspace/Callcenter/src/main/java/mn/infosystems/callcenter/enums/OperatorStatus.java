package mn.infosystems.callcenter.enums;

public enum OperatorStatus {

	NONE(0l, ""), CALL(1l, "Дуудлага хийнэ"), RECIEVE(2l,
			"Дуудлага хүлээн авна");

	private Long id;
	private String description;

	OperatorStatus(Long id, String description) {
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
