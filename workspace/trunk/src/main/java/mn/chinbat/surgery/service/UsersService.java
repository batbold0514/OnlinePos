package mn.chinbat.surgery.service;

import java.util.List;

import org.h2.engine.User;

import mn.chinbat.surgery.model.Users;

public class UsersService extends GenericEntityService<Users, Long>{

	@Override
	protected Class<Users> entityClass() {
		return Users.class;
	}
	
	public boolean hasUser(String name){
		return getCurrentSession().getNamedQuery("user.name").setString("name", name).list().isEmpty()?false:true;
		
	}
	
	public boolean hasUser(String name,Long id){
		if(id==null){
			return getCurrentSession().getNamedQuery("user.name").setString("name", name).list().isEmpty()?false:true;
		}
		return getCurrentSession().getNamedQuery("user.idandname").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
	public Users getUser(String name){
		return (Users) getCurrentSession().getNamedQuery("user.name").setString("name", name).list().get(0);
	}
	@SuppressWarnings("unchecked")
	public List<Users> getUserNotInDoctor(){
		return getCurrentSession().getNamedQuery("user.notindoctor").list();
	}
}

