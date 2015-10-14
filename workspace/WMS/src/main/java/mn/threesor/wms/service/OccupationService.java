package mn.threesor.wms.service;

import mn.threesor.wms.model.Occupation;

public class OccupationService extends GenericEntityService<Occupation, Long>{

	@Override
	protected Class<Occupation> entityClass() {
		return Occupation.class;
	}
	public boolean check(String name,Long id){
		if(id == null)return getCurrentSession().getNamedQuery("occupation.check").setString("name", name).setLong("id",-1l).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("occupation.check").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
}
