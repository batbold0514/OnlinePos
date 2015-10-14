package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.enums.EmployeeStatus;
import mn.threesor.tims.model.Employee;

public class EmployeeService extends GenericEntityService<Employee, Long>
		implements TpmsLogger {

	@Override
	protected Class<Employee> entityClass() {
		return Employee.class;
	}

	@SuppressWarnings("unchecked")
	public boolean hasConjuction(Long id, String reg) {
		if (id == null) {
			return getCurrentSession().getNamedQuery("Employee.findRegnumber")
					.setString("reg", reg).list().isEmpty() ? false : true;
		}
		List<Employee> list = getCurrentSession()
				.getNamedQuery("Employee.find").setString("reg", reg)
				.setLong("id", id).list();
		if (list.isEmpty())
			return false;
		else
			return true;
	}

	public boolean hasCodeConjuction(Long id, String code) {
		if (id == null) {
			return getCurrentSession().getNamedQuery("Employee.checkCode")
					.setString("code", code).list().isEmpty() ? false : true;
		}
		return getCurrentSession().getNamedQuery("Employee.checkCodeAndId")
				.setString("code", code).setLong("id", id).list().isEmpty() ? false
				: true;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getNormalEmployeeList() {
		return getCurrentSession().getNamedQuery("Employee.normal")
				.setLong("stat", EmployeeStatus.normal.getId()).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmpUser(Long i) {
		return getCurrentSession().getNamedQuery("Employee.empUser")
				.setLong("userId", i).list();
	}

	public void log(Object obj, String message) {
		Employee emp = (Employee) obj;
		LOG.info("EMPLOYEE " + message + " : Register : " + emp.getRegNumber()
				+ sep + "firstname : " + emp.getFirstName() + sep
				+ "lastname : " + emp.getLastName() + sep + "phone : "
				+ emp.getPhone() + sep + "position : "
				+ emp.getPosition().getName());
	}

}
