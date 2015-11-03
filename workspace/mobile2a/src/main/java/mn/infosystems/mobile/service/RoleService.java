package mn.infosystems.mobile.service;

import java.util.List;

import mn.infosystems.mobile.model.Role;

public class RoleService extends GenericEntityService<Role, Long>{

	@Override
	protected Class<Role> entityClass() {
		return Role.class;
	}
	
	/**
	 * @param role
	 * @return Role
	 * @see Тухайн заасан эрхийг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Role> getRole(String role){
		return getCurrentSession().getNamedQuery("Role").setString("role", role).list();
	}
}
