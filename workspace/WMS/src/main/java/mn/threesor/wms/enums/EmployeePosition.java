package mn.threesor.wms.enums;

public enum EmployeePosition
{	
	empty		(-1l,""),
	knitter		(0l,"Сүлжигч"),
	bandKnitter	(1l,"Зах сүлжигч"),
	kettel		(2l,"Кеттелчин"), 
	snipper		(3l,"Оёдолчин"), 
	examine 	(4l,"Чанар шалгагч"),
	washman		(5l,"Угаагч"),
	presser		(6l,"Индүүчин"),
	calyxHair	(7l,"Хаг хялгас"),
	instaurator	(8l,"Нөхөн засагч"),
	foreman		(9l,"Мастер"),
	other		(10l,"Бусад");
	private Long id;
	private String label;
	private EmployeePosition(Long id , String label){
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
