package mn.infosystems.enquire.service;

import java.util.List;

import mn.infosystems.enquire.model.Users;

public class UsersService extends GenericEntityService<Users, Long>{

	@Override
	protected Class<Users> entityClass() {
		return Users.class;
	}
	
	/**
	 * @param name
	 * @param id
	 * @return boolean value
	 * @see Тухайн нэр болон id-тэй хэрэглэгч байгаа эсэхийг шалгана
	 */
	public boolean hasUser(String name,Long id){
		if(id==null){
			return getCurrentSession().getNamedQuery("user.name").setString("name", name).list().isEmpty()?false:true;
		}
		return getCurrentSession().getNamedQuery("user.idandname").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
	public Users getUser(String userName){
		@SuppressWarnings("unchecked")
		List<Users> list = getCurrentSession().getNamedQuery("user.getByUsername").setString("username", userName).list();
		return list.isEmpty()?null:list.get(0);
		
	}

	
}

