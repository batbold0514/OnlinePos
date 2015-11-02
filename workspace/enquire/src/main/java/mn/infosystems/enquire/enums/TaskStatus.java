package mn.infosystems.enquire.enums;

public enum TaskStatus {
	
	notStarted(0l,"Not started"),
	inProgress(1l,"In progress"),
	finished(2l,"Finished"),
	droped(3l,"Dropped");
	
	private Long id;
	private String status;
	
	TaskStatus(Long id,String status){
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
