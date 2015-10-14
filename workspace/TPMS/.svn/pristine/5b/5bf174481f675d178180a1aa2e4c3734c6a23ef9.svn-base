package mn.threesor.tims.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import mn.threesor.tims.model.Employee;
import mn.threesor.tims.model.EmployeeSalary;
import mn.threesor.tims.model.StepPrice;
import mn.threesor.tims.model.StepPriceWithNumber;
import mn.threesor.tims.model.SumWorkStep;
import mn.threesor.tims.model.TrackingSheet;
import mn.threesor.tims.model.WorkStep;

public class WorkStepService extends GenericEntityService<WorkStep, Long> {

	@Override
	protected Class<WorkStep> entityClass() {
		return WorkStep.class;
	}

	public List<WorkStep> changeStepPriceToWorkStep(Long ModelId,Long id, int bonus) {
		@SuppressWarnings("unchecked")
		List<StepPrice> list = getCurrentSession()
				.getNamedQuery("ProductModel.stepPrices").setLong("id", id)
				.list();
		List<WorkStep> listWs = new LinkedList<WorkStep>();
		if(ModelId!=null)
		getCurrentSession().getNamedQuery("TrackingSheet.DeleteAllWorkStep").setLong("id", ModelId);
		for (StepPrice sp : list) {
			WorkStep workStep = new WorkStep();
			workStep.setStepPrice(sp);
			workStep.setBonus(bonus);
			Long l = save(workStep);
			listWs.add(get(l));
		}
		return listWs;
	}

	public List<WorkStep> updateWorkStepList(List<WorkStep> workStepList,
			int bonus) {
		List<WorkStep> list = new LinkedList<WorkStep>();
		for (WorkStep ws : workStepList) {
			ws.setBonus(bonus);
			list.add(update(ws));
		}
		return list;
	}

	public List<EmployeeSalary> getAllEmployeeSalary(Date date1, Date date2,
			Long empId) {
		String employeeId = (empId==null || empId == -1l) ? "%" : empId.toString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("unchecked")
		List<WorkStep> list = getCurrentSession()
				.getNamedQuery("workStep.getByDate")
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2))
				.setString("empId", employeeId).list();
		List<EmployeeSalary> listEmpSal = new LinkedList<EmployeeSalary>();
		int id = 1;
		for (WorkStep ws : list) {
			int index = hasEmp(listEmpSal, ws.getEmp());
			if (index != -1) {
				EmployeeSalary employeeSalary = listEmpSal.get(index);
				int salary = 0;
				if (ws.getStepPrice().getProductStep().getId() == 1001
						|| ws.getStepPrice().getProductStep().getId() == 1002)
					salary = ws.getQuantity()
							* (ws.getStepPrice().getPrice()
									* (100 + ws.getBonus()) / 100);
				else
					salary = ws.getQuantity() * ws.getStepPrice().getPrice();
				employeeSalary.setSalary(employeeSalary.getSalary() + salary);
				List<StepPriceWithNumber> listSpwn = employeeSalary
						.getStepPriceList();
				List<StepPriceWithNumber> subList = new LinkedList<StepPriceWithNumber>();
				for (StepPriceWithNumber spwn : listSpwn) {
					if (spwn.getStepPrice().getProductStep().getId() == ws
							.getStepPrice().getProductStep().getId()
							&& spwn.getStepPrice().getPrice() == ws
									.getStepPrice().getPrice()) {
						spwn.setNumber(spwn.getNumber() + ws.getQuantity());
						if (ws.getStepPrice().getProductStep().getId() == 1001
								|| ws.getStepPrice().getProductStep().getId() == 1002) {
							spwn.setPrice(spwn.getPrice()
									+ ws.getQuantity()
									* (ws.getStepPrice().getPrice()
											* (100 + ws.getBonus()) / 100));
						} else {
							spwn.setPrice(spwn.getPrice()
									+ ws.getStepPrice().getPrice()
									* ws.getQuantity());
						}
						subList.add(spwn);
					} else {
						subList.add(spwn);
					}
				}
				employeeSalary.setStepPriceList(subList);
				listEmpSal.remove(index);
				listEmpSal.add(index, employeeSalary);
			} else {
				EmployeeSalary employeeSalary = new EmployeeSalary();
				employeeSalary.setEmployee(ws.getEmp());
				employeeSalary.setId(id++);
				int salary = 0;
				if (ws.getStepPrice().getProductStep().getId() == 1001
						|| ws.getStepPrice().getProductStep().getId() == 1002)
					salary = ws.getQuantity()
							* (ws.getStepPrice().getPrice()
									* (100 + ws.getBonus()) / 100);
				else
					salary = ws.getQuantity() * ws.getStepPrice().getPrice();
				employeeSalary.setSalary(salary);
				employeeSalary.setStepPriceList(getAllStepPriceWithNumber(
						date1, date2));
				List<StepPriceWithNumber> listSpwn = employeeSalary
						.getStepPriceList();
				List<StepPriceWithNumber> subList = new LinkedList<StepPriceWithNumber>();
				for (StepPriceWithNumber spwn : listSpwn) {
					if (spwn.getStepPrice().getProductStep().getId() == ws
							.getStepPrice().getProductStep().getId()
							&& spwn.getStepPrice().getPrice() == ws
									.getStepPrice().getPrice()) {
						spwn.setNumber(spwn.getNumber() + ws.getQuantity());
						if (ws.getStepPrice().getProductStep().getId() == 1001
								|| ws.getStepPrice().getProductStep().getId() == 1002) {
							spwn.setPrice(spwn.getPrice()
									+ ws.getQuantity()
									* (ws.getStepPrice().getPrice()
											* (100 + ws.getBonus()) / 100));
						} else {
							spwn.setPrice(spwn.getPrice()
									+ ws.getStepPrice().getPrice()
									* ws.getQuantity());
						}
						subList.add(spwn);
					} else {
						subList.add(spwn);
					}
				}
				employeeSalary.setStepPriceList(subList);
				listEmpSal.add(employeeSalary);
			}
		}
		return setSumNumbersAndPrices(listEmpSal, id);

	}

	private int hasEmp(List<EmployeeSalary> list, Employee emp) {
		int index = -1;
		for (EmployeeSalary es : list) {
			index++;
			if (es.getEmployee().getId() == emp.getId())
				return index;
		}
		return -1;
	}

	private List<StepPriceWithNumber> getAllStepPriceWithNumber(Date date1,
			Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("unchecked")
		List<StepPrice> stepPriceList = getCurrentSession()
				.getNamedQuery("workStep.getAllStepPrice")
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2)).list();
		List<StepPriceWithNumber> listSpwn = new LinkedList<StepPriceWithNumber>();
		for (StepPrice sp : stepPriceList) {
			if (!hasConjuction(listSpwn, sp)) {
				StepPriceWithNumber spwm = new StepPriceWithNumber();
				spwm.setNumber(0);
				spwm.setStepPrice(sp);
				listSpwn.add(spwm);
			}
		}
		return listSpwn;
	}

	private boolean hasConjuction(List<StepPriceWithNumber> list, StepPrice sp) {
		for (StepPriceWithNumber spwn : list) {
			if (spwn.getStepPrice().getProductStep().getId() == sp
					.getProductStep().getId()
					&& spwn.getStepPrice().getPrice() == sp.getPrice())
				return true;
		}
		return false;
	}

	public List<SumWorkStep> changeSubWorkStep(
			List<TrackingSheet> listTrackingSheet, Employee emp) {
		List<SumWorkStep> list = new LinkedList<SumWorkStep>();
		for (TrackingSheet ts : listTrackingSheet) {
			for (WorkStep ws : ts.getWorkStepList()) {
				if (emp.equals(ws.getEmp()) && hasWorkStep(list, ws) == -1) {
					list.add(new SumWorkStep(ws, 0));
				}
			}
		}
		return list;
	}

	public List<SumWorkStep> changeSubWorkStep(List<SumWorkStep> sumWorkStep,
			List<WorkStep> wsList, Employee emp, Date start, Date end) {
		List<SumWorkStep> list = new LinkedList<SumWorkStep>(sumWorkStep);
		Calendar startCal = new GregorianCalendar();
		startCal.setTime(start);
		startCal.set(Calendar.HOUR, 0);
		startCal.set(Calendar.MINUTE, 0);
		startCal.set(Calendar.SECOND, 0);
		Calendar endCal = new GregorianCalendar();
		endCal.setTime(end);
		endCal.set(Calendar.HOUR, 23);
		endCal.set(Calendar.MINUTE, 59);
		endCal.set(Calendar.SECOND, 59);
		start = startCal.getTime();
		end = endCal.getTime();
		for (WorkStep ws : wsList) {
			if (ws.getEmp() != null && ws.getEmp().getId().equals(emp.getId())
					&& start.before(ws.getDate()) && end.after(ws.getDate())) {
				int i = hasWorkStep(sumWorkStep, ws);
				list.add(i, new SumWorkStep(ws, list.get(i).getWorkStep()));
				list.remove(i + 1);
			}
		}
		return list;
	}

	public int changeSecondSum(List<SumWorkStep> sumWorkStep) {
		int lastSum = 0;
		for (SumWorkStep sw : sumWorkStep) {
			lastSum = lastSum + sw.getSum();
		}
		return lastSum;
	}

	private int hasWorkStep(final List<SumWorkStep> list, final WorkStep ws) {
		int i = 0;
		for (SumWorkStep sw : list) {
			if (sw.getWorkStep().getStepPrice().getProductStep().getName()
					.equals(ws.getStepPrice().getProductStep().getName())) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public List<WorkStep> addWorkStepList(List<WorkStep> subWorkStepList,
			List<WorkStep> addWorkStepList) {
		for (WorkStep ws : addWorkStepList) {
			saveOrUpdate(ws);
			// subWorkStepList.add(ws);
		}
		return subWorkStepList;
	}

	private List<EmployeeSalary> setSumNumbersAndPrices(
			List<EmployeeSalary> listEmpSal, int id) {
		if (listEmpSal.isEmpty())
			return listEmpSal;
		List<StepPriceWithNumber> spwnList = listEmpSal.get(0)
				.getStepPriceList();
		int[] numberMassiv = new int[spwnList.size()];
		int[] priceMassiv = new int[spwnList.size()];
		int index;
		int salary = 0;
		for (EmployeeSalary es : listEmpSal) {
			index = 0;
			salary += es.getSalary();
			for (StepPriceWithNumber sp : es.getStepPriceList()) {
				numberMassiv[index] += sp.getNumber();
				priceMassiv[index] += sp.getPrice();
				index++;
			}
		}
		index = 0;
		List<StepPriceWithNumber> list = new LinkedList<StepPriceWithNumber>();
		for (StepPriceWithNumber sp : spwnList) {
			StepPriceWithNumber spwn = new StepPriceWithNumber();
			spwn.setNumber(numberMassiv[index]);
			spwn.setPrice(priceMassiv[index]);
			spwn.setStepPrice(sp.getStepPrice());
			list.add(spwn);
			index++;
		}
		EmployeeSalary empSal = new EmployeeSalary();
		Employee employee = new Employee();
		employee.setLastName("Нийлбэр");
		employee.setFirstName("дүн");
		empSal.setEmployee(employee);
		empSal.setId(id);
		empSal.setSalary(salary);
		empSal.setStepPriceList(list);
		listEmpSal.add(empSal);
		return listEmpSal;
	}

}
