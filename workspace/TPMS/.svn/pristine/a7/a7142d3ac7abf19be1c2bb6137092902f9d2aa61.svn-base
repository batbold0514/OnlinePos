package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.model.Users;

public class UsersService extends GenericEntityService<Users, Long> implements
		TpmsLogger {

	@Override
	protected Class<Users> entityClass() {
		return Users.class;
	}

	public boolean hasUser(String name) {
		return getCurrentSession().getNamedQuery("user.name")
				.setString("name", name).list().isEmpty() ? false : true;

	}

	public Users getUserName(String name) {
		return (Users) getCurrentSession().getNamedQuery("user.name")
				.setString("name", name).list().get(0);
	}

	public boolean hasUser(String name, Long id) {
		if (id == null)
			return getCurrentSession().getNamedQuery("user.name")
					.setString("name", name).list().isEmpty() ? false : true;
		return getCurrentSession().getNamedQuery("user.idandname")
				.setString("name", name).setLong("id", id).list().isEmpty() ? false
				: true;
	}

	@SuppressWarnings("unchecked")
	public List<Users> getEmpUser() {
		return getCurrentSession().getNamedQuery("user.notinemployee").list();
	}

	public void log(Object obj, String message) {
		Users user = (Users) obj;
		LOG.info("USER " + message + ": username : " + user.getUserName() + sep
				+ "role : " + user.getRole().get(0).getRole());
	}
}
