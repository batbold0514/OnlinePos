package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.BreakedPart;

public class BreakedPartService extends GenericEntityService<BreakedPart, Long>{

	@Override
	protected Class<BreakedPart> entityClass() {
		return BreakedPart.class;
	}
	public boolean checkName(String id){
		return getCurrentSession().getNamedQuery("breakerPart.id").setString("id", id).list().size()==0? true : false;
	}
	public BreakedPart getBreakedPart(String id){
		return (BreakedPart) getCurrentSession().getNamedQuery("breakerPart.id").setString("id", id).list().get(0);
	}
}
