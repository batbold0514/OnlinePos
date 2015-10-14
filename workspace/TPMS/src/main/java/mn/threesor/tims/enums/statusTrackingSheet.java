package mn.threesor.tims.enums;

public enum statusTrackingSheet {
	finished(0l,"Дууссан"),
	stickit(1l,"Дуусаагүй");
private Long id;
private String label;

private statusTrackingSheet(Long id, String label){
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
