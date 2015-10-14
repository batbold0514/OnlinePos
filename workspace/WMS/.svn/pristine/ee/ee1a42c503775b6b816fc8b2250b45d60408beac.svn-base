package mn.threesor.wms.service;

import mn.threesor.wms.model.Size;

public class SizeService extends GenericEntityService<Size, Long>{

	@Override
	protected Class<Size> entityClass() {
		return Size.class;
	}
	
	public boolean check(String sizes,Long id){
		if(id == null )return getCurrentSession().getNamedQuery("Size.check").setLong("id", -1l).setString("size", sizes).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("Size.check").setLong("id", id).setString("size", sizes).list().isEmpty()?false:true;
	}
}
