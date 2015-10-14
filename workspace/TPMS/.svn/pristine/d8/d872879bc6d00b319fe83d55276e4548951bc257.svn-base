package mn.threesor.tims.model;


public class SumWorkStep {
	private WorkStep workStep;
	private int sum;

	public SumWorkStep(WorkStep ws , WorkStep sesondWs) {
		this.workStep = new WorkStep(ws , ws.getQuantity());
		this.workStep.setQuantity(this.workStep.getQuantity()+sesondWs.getQuantity());
		if (workStep.getStepPrice().getProductStep().getId() == 1001
				|| workStep.getStepPrice().getProductStep().getId() == 1002){
			this.sum = this.workStep.getQuantity()
					* (this.workStep.getStepPrice().getPrice() * (100 + ws.getBonus()) / 100);
		}
		else
			this.sum = this.workStep.getQuantity() * ws.getStepPrice().getPrice();
	}
	public SumWorkStep(WorkStep ws , int sum) {
		this.workStep = new WorkStep(ws);
		this.sum = 0;
	} 
	public WorkStep getWorkStep() {
		return workStep;
	}

	public void setWorkStep(WorkStep workStep) {
		this.workStep = workStep;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
