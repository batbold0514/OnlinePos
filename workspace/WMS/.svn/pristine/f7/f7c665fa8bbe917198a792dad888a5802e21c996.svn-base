package mn.threesor.wms.service;

import mn.threesor.wms.model.Colour;

public class ColourService extends GenericEntityService<Colour, Long>{

	@Override
	protected Class<Colour> entityClass() {
		return Colour.class;
	}
	public boolean check(String code , Long id){
		if(id == null)return getCurrentSession().getNamedQuery("Colour.check").setString("code", code).setLong("id", -1l).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("Colour.check").setString("code", code).setLong("id", id).list().isEmpty()?false:true;
	}
}
