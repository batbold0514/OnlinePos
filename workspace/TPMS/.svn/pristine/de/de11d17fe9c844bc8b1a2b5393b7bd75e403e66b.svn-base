package mn.threesor.tims.service;

import mn.threesor.tims.model.Size;


public class SizeService extends GenericEntityService<Size, Long> implements TpmsLogger{

	@Override
	protected Class<Size> entityClass() {
		return Size.class;
	}

	public boolean check(String sizes,Long id){
		if(id == null) 
			return getCurrentSession().getNamedQuery("Size.check").setString("size", sizes).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("Size.checkWithId").setString("size", sizes).setLong("id", id).list().isEmpty()?false:true;
	}

	public void log(Object obj, String message) {
		Size s = (Size) obj;
		LOG.info("Size "+message+": size: "+s.getSizes());
	}
}
