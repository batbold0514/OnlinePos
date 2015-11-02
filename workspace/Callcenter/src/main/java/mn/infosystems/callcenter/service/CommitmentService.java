package mn.infosystems.callcenter.service;

import java.util.LinkedList;
import java.util.List;

import mn.infosystems.callcenter.model.Commitment;

public class CommitmentService extends GenericEntityService<Commitment,Long>{

	@Override
	protected Class<Commitment> entityClass() {
		return Commitment.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Commitment> getByDate(String startDate , String endDate){
		startDate = startDate + " 00:00:00.000";
		endDate = endDate + " 23:59:59.999";
		List<Commitment> list =getCurrentSession().getNamedQuery("commitment.getByDate").setString("d1", startDate).setString("d2", endDate).list();
		return list.isEmpty()?(new LinkedList<Commitment>()):list;
	}

}
