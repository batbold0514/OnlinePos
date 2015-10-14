package mn.infosystems.estimator.enums;

/**
 * @author Suld
 * Даатгалын төрөл
 *
 */
public enum InsuranceType {
	
	uninsured(0l,"Даатгалгүй"),
	driverInsured(1l,"Жолоочийн хариуцлагын даатгал"),
	carInsured(2l,"Тээврийн хэрэгслийн даатгалзэ");
	
	private Long id;
	private String type;
	
	public static InsuranceType get(Long id){
		Integer number = Integer.parseInt(Long.toString(id));
		switch(number){
			case 0: return InsuranceType.uninsured; 
			case 1: return InsuranceType.driverInsured;
			case 2 : return InsuranceType.carInsured;
 		}
		return null;
	}
	public static InsuranceType get(String id){
		Integer number = Integer.parseInt(id);
		switch(number){
			case 0: return InsuranceType.uninsured; 
			case 1: return InsuranceType.driverInsured;
			case 2 : return InsuranceType.carInsured;
 		}
		return null;
	}
	InsuranceType(Long id,String type) {
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
