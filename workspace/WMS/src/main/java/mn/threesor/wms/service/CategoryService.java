package mn.threesor.wms.service;

import mn.threesor.wms.model.Category;

public class CategoryService extends GenericEntityService<Category, Long>
{
	@Override
	protected Class<Category> entityClass()
	{
		return Category.class;
	}
	public boolean check(String name , Long id){
		if(id == null) return getCurrentSession().getNamedQuery("Category.check").setString("name", name).setLong("id", -1l).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("Category.check").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
}
