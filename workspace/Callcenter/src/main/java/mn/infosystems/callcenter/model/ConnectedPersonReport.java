package mn.infosystems.callcenter.model;

import java.util.LinkedList;
import java.util.List;

public class ConnectedPersonReport {
//	private ConnectedPerson connectedPerson;
//	private int quantity;
	private List<Calls> listOfCall;
	
	public ConnectedPersonReport(Calls call) {
//		this.connectedPerson = call.getPerson();
//		quantity = 1;
		listOfCall = new LinkedList<Calls>();
		listOfCall.add(call);
	}

//	public ConnectedPerson getConnectedPerson() {
//		return connectedPerson;
//	}
//
//	public void setConnectedPerson(ConnectedPerson connectedPerson) {
//		this.connectedPerson = connectedPerson;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	public void addQuantity(Calls call){
//		this.quantity++;
		listOfCall.add(call);
	}

	public List<Calls> getListOfCall() {
		return listOfCall;
	}

	public void setListOfCall(List<Calls> listOfCall) {
		this.listOfCall = listOfCall;
	}
	
}
