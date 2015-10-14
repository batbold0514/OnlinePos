package mn.threesor.wms.enums;

public enum OutputArticleActivity {
	unfinish(0l, "T-", "Идэвхигүй"),finish(1l, "F-", "Идэвхитэй");
	private Long id;
	private String prefix;
	private String label;

	private OutputArticleActivity(Long id, String prefix, String label) {
		this.id = id;
		this.label = label;
		this.prefix = prefix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static OutputArticleActivity[] valuesActive() {
		OutputArticleActivity[] values = { finish, unfinish };
		return values;
	}

}
