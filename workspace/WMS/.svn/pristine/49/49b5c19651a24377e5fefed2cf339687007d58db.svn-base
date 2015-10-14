package mn.threesor.wms.service;

import java.util.List;

import mn.threesor.wms.enums.EmployeeStatus;
import mn.threesor.wms.model.Employee;

public class EmployeeService extends GenericEntityService<Employee, Long> {

	@Override
	protected Class<Employee> entityClass() {
		return Employee.class;
	}
	
	@SuppressWarnings("unchecked")
	public boolean hasConjuction(Long id,String reg){
		if(id==null){
			return getCurrentSession().getNamedQuery("Employee.findRegnumber").setString("reg", reg).list().isEmpty()?false:true;
		}
		List<Employee> list = getCurrentSession().getNamedQuery("Employee.find").setString("reg", reg).setLong("id", id).list();
		if(list.isEmpty()) return false;
		else return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAvailableEmployee(){
		return getCurrentSession().getNamedQuery("Employee.normal").setLong("stat", EmployeeStatus.normal.getId()).list();
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

}
