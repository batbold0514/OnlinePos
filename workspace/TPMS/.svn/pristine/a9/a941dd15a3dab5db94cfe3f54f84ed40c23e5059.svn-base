package mn.threesor.tims.service;

import mn.threesor.tims.model.Occupation;

public class OccupationService extends GenericEntityService<Occupation, Long>
		implements TpmsLogger {

	@Override
	protected Class<Occupation> entityClass() {
		return Occupation.class;
	}

	public void log(Object obj, String message) {
		Occupation oc = (Occupation) obj;
		LOG.info("Occupation " + message + " : name" + oc.getName());
	}
	
	public boolean checkCunjuction(Long id,String name){
		if(id == null) return getCurrentSession().getNamedQuery("Occupation.checkNonID").setString("name", name).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("Occupation.checkID").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}

}
