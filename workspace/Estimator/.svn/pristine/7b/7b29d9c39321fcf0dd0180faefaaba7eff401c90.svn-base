package mn.infosystems.estimator.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mn.infosystems.estimator.enums.InsuranceType;
import mn.infosystems.estimator.model.Customer;
import mn.infosystems.estimator.model.EmpReportModel;
import mn.infosystems.estimator.model.EmployeeReportModel;

public class CustomerService extends GenericEntityService<Customer, Long> {

	@Override
	protected Class<Customer> entityClass() {
		return Customer.class;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getRegNumber(String number) {
		number = "%" + number + "%";
		return getCurrentSession().getNamedQuery("customer.getRegister")
				.setString("reg", number).list();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCnumber(String number) {
		number = "%" + number + "%";
		return getCurrentSession().getNamedQuery("customer.getCnumber")
				.setString("number", number).list();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getByDate(String firstDate, String secondDate,
			String emp) {
		firstDate = (firstDate == null || firstDate.trim().equals("")) ? "1000-01-01"
				: firstDate + " 00:00:00.001";
		secondDate = (secondDate == null || secondDate.trim().equals("")) ? "3000-01-01"
				: secondDate + " 23:59:59.999";
		emp = (emp == null || emp.trim().equals("")) ? "%" : emp;
		return getCurrentSession().getNamedQuery("customer.getByDate")
				.setString("date1", firstDate).setString("date2", secondDate)
				.setString("emp", emp).list();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomer(String date1, String date2,
			String factId, String markId, String factDate, String cnumber) {
		date1 = (date1 == null || date1.trim().equals("")) ? "1000-01-01"
				: date1 + " 00:00:00.001";
		date2 = (date2 == null || date2.trim().equals("")) ? "3000-01-01"
				: date2 + " 23:59:59.999";
		factId = (factId == null || factId.trim().equals("")) ? "%" : factId;
		markId = (markId == null || markId.trim().equals("")) ? "%" : markId;
		factDate = (factDate == null || factDate.trim().equals("")) ? "%"
				: factDate;
		cnumber = (cnumber == null || cnumber.trim().equals("")) ? "%"
				: cnumber;
		return getCurrentSession().getNamedQuery("customer.search")
				.setString("date1", date1).setString("date2", date2)
				.setString("cnum", cnumber).setString("factory", factId)
				.setString("mark", markId).setString("factDate", factDate)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeReportModel> getEmployyReport(String firstDate,
			String secondDate, String emp) {
		firstDate = (firstDate == null || firstDate.trim().equals("")) ? "1000-01-01"
				: firstDate + " 00:00:00.001";
		secondDate = (secondDate == null || secondDate.trim().equals("")) ? "3000-01-01"
				: secondDate + " 23:59:59.999";
		emp = (emp == null || emp.trim().equals("")) ? "%" : emp;
		List<Customer> list = getCurrentSession()
				.getNamedQuery("customer.getByDate")
				.setString("date1", firstDate).setString("date2", secondDate)
				.setString("emp", emp).list();
		List<EmployeeReportModel> listReport = new LinkedList<EmployeeReportModel>();
		if (list.isEmpty())
			return listReport;
		HashMap<Long, List<Customer>> hash = new HashMap<Long, List<Customer>>();
		/*
		 * Long empId = list.get(0).getMainEmp().getId(); Integer estCount = 0;
		 * Long estPrice = 0l; Integer insCount = 0; Long insPrice = 0l;
		 * EmpReportModel erm = new EmpReportModel();
		 */
		for (Customer c : list) {
			Long id = c.getMainEmp().getId();
			if (hash.containsKey(id)) {
				List<Customer> l = hash.get(id);
				l.add(c);
			} else {
				List<Customer> l = new LinkedList<Customer>();
				l.add(c);
				hash.put(id, l);
			}
		}
		Iterator iterator = hash.entrySet().iterator();
		while (iterator.hasNext()) {
			List<EmpReportModel> sublist = new LinkedList<EmpReportModel>();
			Map.Entry<String, List<Customer>> pair = (Entry<String, List<Customer>>) iterator
					.next();
			List<Customer> ll = pair.getValue();
			Date d = ll.get(0).getDate();
			int count = 0;
			Integer estCount = 0;
			Long estPrice = 0l;
			Integer insCount = 0;
			Long insPrice = 0l;
			for (Customer c : ll) {
				if (c.getDate().equals(d)) {
					estCount++;
					if(c.getChangePrice()!= null){
						estPrice += c.getChangePrice();
					}
					if(c.getRepairPrice()!=null){
						estPrice += c.getRepairPrice();
					}
					if (!c.getItype().equals(InsuranceType.uninsured)) {
						insCount++;
						if(c.getChangePrice()!= null){
							estPrice += c.getChangePrice();
						}
						if(c.getRepairPrice()!=null){
							estPrice += c.getRepairPrice();
						}
					}
				} else {
					EmpReportModel erm = new EmpReportModel();
					erm.setId(++count);
					erm.setDate(EstimaterStaticFunctions.dateToStr(d));
					erm.setEstCount(estCount);
					erm.setEstPrice(estPrice);
					erm.setInsuranceCount(insCount);
					erm.setInsurancePrice(insPrice);
					sublist.add(erm);
					d = c.getDate();
					estCount = 1;
					if(c.getChangePrice()!= null){
						estPrice = c.getChangePrice();
					}else{
						estPrice = 0l;
					}
					if(c.getRepairPrice()!=null){
						estPrice += c.getRepairPrice();
					}
					if (!c.getItype().equals(InsuranceType.uninsured)) {
						insCount = 1;
						if(c.getChangePrice()!= null){
							estPrice = c.getChangePrice();
						}else{
							estPrice = 0l;
						}
						if(c.getRepairPrice()!=null){
							estPrice += c.getRepairPrice();
						}
					} else {
						insCount = 0;
						insPrice = 0l;
					}

				}
			}
			EmpReportModel erm = new EmpReportModel();
			erm.setId(++count);
			erm.setDate(EstimaterStaticFunctions.dateToStr(d));
			erm.setEstCount(estCount);
			erm.setEstPrice(estPrice);
			erm.setInsuranceCount(insCount);
			erm.setInsurancePrice(insPrice);
			sublist.add(erm);
			EmployeeReportModel model = new EmployeeReportModel();
			model.setEmployee(ll.get(0).getMainEmp());
			model.setCounList(sublist);
			listReport.add(model);
			
		}
		return listReport;
	}

}
