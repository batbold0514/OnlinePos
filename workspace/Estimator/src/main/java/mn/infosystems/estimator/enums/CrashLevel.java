package mn.infosystems.estimator.enums;

public enum CrashLevel {
	
	first("1-р зэрэгийн"),
	second("2-р зэрэгийн"),
	third("3-р зэрэгийн"),
	fourth("4-р зэрэгийн"),
	fifth("5-р зэрэгийн"),
	sixth("6-р зэрэгийн");
	
	private String level;
	
	CrashLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
}
