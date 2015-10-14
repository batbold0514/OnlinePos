package mn.infosystems.estimator.enums;

public enum CarType {
	
	own(0l,"Хувийн хэрэгцээнд"),
	work(1l,"Албаны хэрэгцээнд"),
	publicTransport(2l,"Нийтийн тээвэр");
	
	private Long id;
	private String type;
	
	public static CarType get(Long id){
		Integer number = Integer.parseInt(Long.toString(id));
		switch(number){
			case 0: return CarType.own;
			case 1: return CarType.work;
			case 2: return CarType.publicTransport;
 		}
		return null;
	}
	public static CarType get(String id){
		Integer number = Integer.parseInt(id);
		switch(number){
			case 0: return CarType.own;
			case 1: return CarType.work;
			case 2: return CarType.publicTransport;
 		}
		return null;
	}
	CarType(Long id,String type){
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
