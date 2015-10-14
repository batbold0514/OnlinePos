package mn.infosystems.estimator.enums;

public enum CrashGrade {
	
	high(0l,"Их"),
	medium(1l,"Дунд"),
	low(2l,"Бага"),
	broken(3l,"Хагарсан"),
	paint(4l,"Будах");
	
	private Long id;
	private String grade;

	public static CrashGrade get(Long id){
		Integer number = Integer.parseInt(Long.toString(id));
		switch(number){
			case 0: return CrashGrade.high; 
			case 1: return CrashGrade.medium;
			case 2: return CrashGrade.low;
			case 3: return CrashGrade.broken;
			case 4: return CrashGrade.paint;
 		}
		return null;
	}
	
	public static CrashGrade get(String id){
		Integer number = Integer.parseInt(id);
		switch(number){
		case 0: return CrashGrade.high; 
		case 1: return CrashGrade.medium;
		case 2: return CrashGrade.low;
		case 3: return CrashGrade.broken;
		case 4: return CrashGrade.paint;
		}
		return null;
	}
	
	CrashGrade(Long id, String grade) {
		this.id = id;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
