package mn.infosystems.mobile.enums;


public enum Category {
	KeepingAndCredit(0l,"Хадгаламж ба зээл"),
	AssetsAndBond(1l,"Хөрөнгө ба үнэт цаас"),
	Investment(2l,"Хөрөнгө оруулалт"),
	Insurance(3l,"Даатгал"),
	Custodians(4l,"Кастодиан");
	
	public static Category get(Long id){
		Integer number = Integer.parseInt(Long.toString(id));
		switch(number){
			case 0: return Category.KeepingAndCredit;
			case 1: return Category.AssetsAndBond;
			case 2: return Category.Investment;
			case 3: return Category.Insurance;
			case 4: return Category.Custodians;
 		}
		return null;
	}
	public static Category get(String id){
		Integer number = Integer.parseInt(id);
		switch(number){
			case 0: return Category.KeepingAndCredit;
			case 1: return Category.AssetsAndBond;
			case 2: return Category.Investment;
			case 3: return Category.Insurance;
			case 4: return Category.Custodians;
 		}
		return null;
	}
	
	Category(Long id , String desc){
		this.id = id;
		this.description = desc;
	}
	
	private Long id;
	private String description;
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
