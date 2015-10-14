package mn.chinbat.surgery.enums;

public enum PaymentMethod {
	CASH		(0l, "A-", "Бэлнээр"), 
	CARD		(1l, "B-", "Картаар"), 
	TRANSFER	(2l, "C-", "Дансны шилжүүлэг"), 
	MONEY_BACK	(3l, "D-", "Мөнгө буцаалт"),
	ALL			(4l, "",   "Бүгд");
	
	private Long id;
	private String prefix;
	private String label;
	
	private PaymentMethod(Long id, String prefix, String label) {
		this.setId(id);
		this.prefix = prefix;
		this.label = label;
	}
	
	public String getPrefix() {
        return prefix;
    }
	
	public String getLabel() {
        return label;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public static PaymentMethod[] valuesWithoutAll() {
		PaymentMethod[] valuesWithoutAll = {CASH, CARD, TRANSFER, MONEY_BACK}; 
		return valuesWithoutAll;
	}
	
	public static PaymentMethod[] valuesForUserRole() {
		PaymentMethod[] valuesForUserRole = {CASH, CARD}; 
		return valuesForUserRole;
	}
}
