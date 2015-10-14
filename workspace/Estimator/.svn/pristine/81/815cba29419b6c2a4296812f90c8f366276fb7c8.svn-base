package mn.infosystems.estimator.service;

import java.util.List;

import mn.infosystems.estimator.model.Employee;

public class EmployeeService extends GenericEntityService<Employee, Long>{

	@Override
	protected Class<Employee> entityClass() {
		return Employee.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees(Long st){
		return getCurrentSession().getNamedQuery("Employee.getActive").setLong("status", st).list();
	}
	
}
