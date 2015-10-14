package mn.threesor.tims.enums;

public enum EmployeeStatus {
	normal		(0l,"Хэвийн"),
	diseased	(1l,"Өвчтэй"),
	relaxed 	(2l,"Чөлөөтэй"),
	separatee	(3l,"Халагдсан"),
	pregnant	(4l,"Жирэмсэн");
     private Long id;
     private String label;
     private EmployeeStatus(Long id ,String label){
    	 this.id = id;
    	 this.label = label;
     }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
     
}
