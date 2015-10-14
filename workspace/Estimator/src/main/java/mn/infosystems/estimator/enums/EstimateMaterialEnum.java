package mn.infosystems.estimator.enums;

public enum EstimateMaterialEnum {
	
	first(0l,"1-р зэрэг","Сэлбэгийн зах зээлийн дундаж үнэ, 1-р зэрэглэлийн засварын ажлын дундаж үнийн тарифыг баримтлав."),
	second(1l,"2-р зэрэг","Сэлбэгийн зах зээлийн дундаж үнэ, 2-р зэрэглэлийн засварын ажлын дундаж үнийн тарифыг баримтлав."),
	third(2l,"3-р зэрэг","Сэлбэгийн зах зээлийн дундаж үнэ, 3-р зэрэглэлийн засварын ажлын дундаж үнийн тарифыг баримтлав."),
	fourth(3l,"4-р зэрэг","Сэлбэгийн зах зээлийн дундаж үнэ, 4-р зэрэглэлийн засварын ажлын дундаж үнийн тарифыг баримтлав."),
	fifth(4l,"5-р зэрэг","Сэлбэгийн зах зээлийн дундаж үнэ, 5-р зэрэглэлийн засварын ажлын дундаж үнийн тарифыг баримтлав."),
	sixth(5l,"6-р зэрэг","Сэлбэгийн зах зээлийн дундаж үнэ, 6-р зэрэглэлийн засварын ажлын дундаж үнийн тарифыг баримтлав.");
	
	private Long id;
	private String grade;
	private String description;
	
	private EstimateMaterialEnum(Long id,String grade,String description) {
		this.id = id;
		this.grade = grade;
		this.description = description;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
