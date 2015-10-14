package mn.infosystems.estimator.enums;

public enum EmployeeStatus {
		
	active(0l,"Идэвхтэй"),
	incative(1l,"Идэвхгүй");
	
	private Long id;
	private String status;
	
	public static EmployeeStatus get(Long id){
		Integer number = Integer.parseInt(Long.toString(id));
		switch(number){
			case 0: return EmployeeStatus.active; 
			case 1: return EmployeeStatus.incative;
 		}
		return null;
	}
	public static EmployeeStatus get(String id){
		Integer number = Integer.parseInt(id);;
		switch(number){
			case 0: return EmployeeStatus.active; 
			case 1: return EmployeeStatus.incative;
 		}
		return null;
	}
	EmployeeStatus(Long id,String status){
		this.id = id;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
