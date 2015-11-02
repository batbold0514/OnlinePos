package mn.infosystems.enquire.service;

import mn.infosystems.enquire.model.Employee;

public class EmployeeService extends GenericEntityService<Employee, Long>{

	@Override
	protected Class<Employee> entityClass() {
		return Employee.class;
	}

}
