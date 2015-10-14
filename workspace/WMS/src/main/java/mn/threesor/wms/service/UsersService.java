package mn.threesor.wms.service;

import mn.threesor.wms.model.Users;

public class UsersService extends GenericEntityService<Users, Long>{

	@Override
	protected Class<Users> entityClass() {
		return Users.class;
	}
	
	public boolean hasUser(String name){
		return getCurrentSession().getNamedQuery("user.name").setString("name", name).list().isEmpty()?false:true;
		
	}
	
	public boolean hasUser(String name,Long id){
		return getCurrentSession().getNamedQuery("user.idandname").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
}

