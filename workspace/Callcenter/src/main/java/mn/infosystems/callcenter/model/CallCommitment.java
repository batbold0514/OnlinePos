package mn.infosystems.callcenter.model;

import java.util.LinkedList;
import java.util.List;

public class CallCommitment {
	private List<String> commitValues= new LinkedList<String>();;
	private List<String> commitDates= new LinkedList<String>();;
	private List<String> commitDescriptions= new LinkedList<String>();
	private List<Debt> listOfDebt = new LinkedList<Debt>();
	private int listsize;
	private int primaryData;
	public CallCommitment(){
		listsize = 0;
		primaryData = 0;
	}
	public List<String> getCommitValues() {
		return commitValues;
	}
	public void setCommitValues(List<String> commitValues) {
		this.commitValues = commitValues;
	}
	public List<String> getCommitDates() {
		return commitDates;
	}
	public void setCommitDates(List<String> commitDates) {
		this.commitDates = commitDates;
	}
	public List<String> getCommitDescriptions() {
		return commitDescriptions;
	}
	public void setCommitDescriptions(List<String> commitDescriptions) {
		this.commitDescriptions = commitDescriptions;
	}
	public void add(Debt debt){
		commitDates.add("");
		commitDescriptions.add("");
		commitValues.add("");
		listOfDebt.add(debt);
		listsize++;
		primaryData++;
	}
	public void add(){
		commitDates.add("");
		commitDescriptions.add("");
		commitValues.add("");
	}
	public void remove(int index){
		commitDates.remove(index);
		commitDescriptions.remove(index);
		commitValues.remove(index);
	}
	public int getListsize() {
		return listsize;
	}
	public void setListsize(int listsize) {
		this.listsize = listsize;
	}
	public List<Debt> getListOfDebt() {
		return listOfDebt;
	}
	public void setListOfDebt(List<Debt> listOfDebt) {
		this.listOfDebt = listOfDebt;
	}
	public int getPrimaryData() {
		return primaryData;
	}
	public void setPrimaryData(int primaryData) {
		this.primaryData = primaryData;
	}
	
}
