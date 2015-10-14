package mn.infosystems.estimator.model;

import java.util.List;

public class EmployeeReportModel {

	private Employee employee;
	private List<EmpReportModel> counList;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<EmpReportModel> getCounList() {
		return counList;
	}

	public void setCounList(List<EmpReportModel> counList) {
		this.counList = counList;
	}

}
