package mn.infosystems.enquire.service;

import java.util.List;

import mn.infosystems.enquire.model.EnquireType;

public class EnquireTypeService extends GenericEntityService<EnquireType, Long>{

	@Override
	protected Class<EnquireType> entityClass() {
		return EnquireType.class;
	}
	public EnquireType getEnquireType(String desc){
		@SuppressWarnings("unchecked")
		List<EnquireType> list = getCurrentSession().getNamedQuery("enquireType.get").setString("desc", desc).list();
		return list.isEmpty() ? new EnquireType():list.get(0);
	}
}
