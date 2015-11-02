package mn.infosystems.callcenter.model;

import java.util.LinkedList;
import java.util.List;

public class CallProcess {
	/*private Reason reason;
	private int quantity;*/
	private List<Calls> listOfCall;
	
	public CallProcess(Calls call ){
		/*this.reason = reason;
		this.quantity = 1;*/
		listOfCall = new LinkedList<Calls>();
		listOfCall.add(call);
	}
	public CallProcess(){
		/*this.reason = reason;
		this.quantity = 1;*/
		listOfCall = new LinkedList<Calls>();
	}
	/*public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Reason getReason() {
		return reason;
	}
	public void setReason(Reason reason) {
		this.reason = reason;
	}*/
	public void addQuantity(Calls call){
//		this.quantity++;''
		listOfCall.add(call);
	}

	public List<Calls> getListOfCall() {
		return listOfCall;
	}

	public void setListOfCall(List<Calls> listOfCall) {
		this.listOfCall = listOfCall;
	}
	
}
