package mn.infosystems.callcenter.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import mn.infosystems.callcenter.model.CallProcess;
import mn.infosystems.callcenter.model.Calls;
import mn.infosystems.callcenter.model.ConnectedPersonReport;

public class CallService extends GenericEntityService<Calls, Long>{

	@Override
	protected Class<Calls> entityClass() {
		return Calls.class;
	}
	public void callPlus(Long id, int callQuantity){
		getCurrentSession().getNamedQuery("debt.updateCallQuantity").setLong("id", id).setInteger("callQuantity", callQuantity).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Calls> getCalls(String date1,String date2,Integer duration,String opId,String reasonId){
		@SuppressWarnings("unused")
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr1 = date1 + " 00:00:00.000";
		String dateStr2 = date2 + " 23:59:59.999";
		List<Calls> calls = getCurrentSession().getNamedQuery("calls.getCall").setString("d1", dateStr1)
				.setString("d2", dateStr2).setInteger("duration", duration)
				.setString("opId", opId).setString("reasonId", reasonId).list() ;
		return (calls==null)?new LinkedList<Calls>():calls;
	}
	@SuppressWarnings("unchecked")
	public List<CallProcess> getProcess(String date1,String date2 ,String reason){
		String dateStr1 = date1 + " 00:00:00.000";
		String dateStr2 = date2 + " 23:59:59.999";
		List<Calls> calls = getCurrentSession().getNamedQuery("calls.getReason").setString("d1", dateStr1)
				.setString("d2", dateStr2).setString("reason", reason).list() ;
		List<CallProcess> callProcess = new LinkedList<CallProcess>();
		if(calls.size() !=0)
			callProcess.add(new CallProcess(calls.get(0)));
		int check = 0;
		for(int i = 1; i <calls.size();i++){
			for(CallProcess process:callProcess){
				if(process.getListOfCall().get(0).getReason().getId() == calls.get(i).getReason().getId()){
					process.addQuantity(calls.get(i));
					check = 1;
					break;
				}
			}
			if(check == 0){
				callProcess.add(new CallProcess(calls.get(i)));
			}else{
				check = 0;
			}
		}
		return (calls==null)?new LinkedList<CallProcess>():callProcess;
	}
	@SuppressWarnings("unchecked")
	public List<CallProcess> getProcessGroup(String date1,String date2 ,String reason){
		String dateStr1 = date1 + " 00:00:00.000";
		String dateStr2 = date2 + " 23:59:59.999";
		List<Calls> calls = getCurrentSession().getNamedQuery("calls.getReason").setString("d1", dateStr1)
				.setString("d2", dateStr2).setString("reason", reason).list() ;
		List<CallProcess> callProcess = new LinkedList<CallProcess>();
			callProcess.add(new CallProcess());
			callProcess.add(new CallProcess());
		for(Calls call:calls){
			if(call.getReason().getId() == 0l){
				callProcess.get(0).addQuantity(call);
			}
			else{
				callProcess.get(1).addQuantity(call);
			}
		}
		return (calls==null)?new LinkedList<CallProcess>():callProcess;
	}
	@SuppressWarnings("unchecked")
	public List<ConnectedPersonReport> getConnectedPerson(String date1,String date2 ,String connPerson){
		String dateStr1 = date1 + " 00:00:00.000";
		String dateStr2 = date2 + " 23:59:59.999";
		List<Calls> calls = null ;
		if(connPerson.equals("%")){
			calls = getCurrentSession().getNamedQuery("calls.getCallBetween").setString("d1", dateStr1)
					.setString("d2", dateStr2).list();
		}else{
			calls = getCurrentSession().getNamedQuery("calls.getConnectePerson").setString("d1", dateStr1)
			.setString("d2", dateStr2).setString("person", connPerson).list();
		}
		List<ConnectedPersonReport> connectedPerson = new LinkedList<ConnectedPersonReport>();
		if(calls.size() !=0){
			if(calls.get(0) !=null){
			connectedPerson.add(new ConnectedPersonReport(calls.get(0)));
			}
		}
		int check = 0;
		for(int i = 1; i <calls.size();i++){
			for(ConnectedPersonReport personReport:connectedPerson){
				if(personReport.getListOfCall().get(0).getPerson() == null){
					personReport.addQuantity(calls.get(i));
					check = 1;
					break;
				}
				if(personReport.getListOfCall().get(0).getPerson() != null && personReport.getListOfCall().get(0).getPerson().getId() 
						== calls.get(i).getPerson().getId()){
					personReport.addQuantity(calls.get(i));
					check = 1;
					break;
				}
			}
			if(check == 0){
				if(calls.get(0) !=null){
					connectedPerson.add(new ConnectedPersonReport(calls.get(0)));
				}
			}else{
				check = 0;
			}
		}
		return (calls==null)?new LinkedList<ConnectedPersonReport>():connectedPerson;
	}
}
