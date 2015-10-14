package mn.threesor.wms.service;

import mn.threesor.wms.model.LocationWms;

public class LocationWmsService extends GenericEntityService<LocationWms, Long>{

	@Override
	protected Class<LocationWms> entityClass() {
		return LocationWms.class;
	}
	
	public boolean check(String name,Long id){
		if(id ==null)return getCurrentSession().getNamedQuery("Location.check").setLong("id", -1l).setString("name", name).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("Location.check").setLong("id", id).setString("name", name).list().isEmpty()?false:true;
	}

}
