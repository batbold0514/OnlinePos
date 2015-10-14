package mn.threesor.wms.service;

import mn.threesor.wms.model.Measure;

public class MeasureService extends GenericEntityService<Measure, Long>{

	@Override
	protected Class<Measure> entityClass() {
		return Measure.class;
	}
	
	public boolean check(Long id,String unit){
		if(id == null){
			return getCurrentSession().getNamedQuery("measure.checkWithoutnID").setString("unit", unit).list().isEmpty()?false:true;
		}
		return getNamedQuery("measure.checkWithID").setString("unit", unit).setLong("id", id).list().isEmpty()?false:true;
	}

}
