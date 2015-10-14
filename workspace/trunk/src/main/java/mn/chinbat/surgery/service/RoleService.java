package mn.chinbat.surgery.service;

import java.util.List;

import mn.chinbat.surgery.model.Role;

public class RoleService extends GenericEntityService<Role, Long>{

	@Override
	protected Class<Role> entityClass() {
		return Role.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getRole(String role){
		return getCurrentSession().getNamedQuery("Role").setString("role", role).list();
	}
}
