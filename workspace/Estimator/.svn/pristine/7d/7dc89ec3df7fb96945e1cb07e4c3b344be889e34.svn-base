package mn.infosystems.estimator.enums;

public enum Confirm {
	
	approved(0l,"Батлагдсан"),
	unapproved(1l,"Батлагдаагүй");
	
	private Long id;
	private String description;
	
	public static Confirm get(Long id){
		Integer number = Integer.parseInt(Long.toString(id));
		switch(number){
			case 0: return Confirm.approved; 
			case 1: return Confirm.unapproved;
 		}
		return null;
	}
	public static Confirm get(String id){
		Integer number = Integer.parseInt(id);
		switch(number){
			case 0: return Confirm.approved; 
			case 1: return Confirm.unapproved;
 		}
		return null;
	}
	
	Confirm(Long id,String description){
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
