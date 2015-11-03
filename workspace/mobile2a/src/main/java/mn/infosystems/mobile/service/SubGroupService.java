package mn.infosystems.mobile.service;

import java.util.List;

import mn.infosystems.mobile.model.SubGroup;
import mn.infosystems.mobile.model.TeachingAid;

public class SubGroupService extends GenericEntityService<SubGroup, Long>{

	@Override
	protected Class<SubGroup> entityClass() {
		return SubGroup.class;
	}
	@SuppressWarnings("unchecked")
	public List<SubGroup> getListCategory(int category,int level){
		return getCurrentSession().getNamedQuery("subGroup.category").setInteger("level", level).setInteger("category", category).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<TeachingAid> getTeachingAidList(Long id){
		return getCurrentSession().getNamedQuery("subGroup.teachingAid").setLong("id", id).list();
	}
	@SuppressWarnings("unchecked")
	public List<SubGroup> getSubGroupList(Long id){
		return getCurrentSession().getNamedQuery("subGroup.listSubGroup").setLong("id", id).list();
	}
}
