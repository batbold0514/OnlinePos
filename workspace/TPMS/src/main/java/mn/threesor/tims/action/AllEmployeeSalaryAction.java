package mn.threesor.tims.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

//import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.tims.model.Employee;
import mn.threesor.tims.model.EmployeeSalary;
import mn.threesor.tims.model.ReportShow;
import mn.threesor.tims.model.SumWorkStep;
import mn.threesor.tims.model.TrackingSheet;
import mn.threesor.tims.model.Users;
import mn.threesor.tims.service.EmployeeService;
import mn.threesor.tims.service.TrackingSheetService;
import mn.threesor.tims.service.UsersService;
import mn.threesor.tims.service.WorkStepService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/employee"),
		@Namespace("/designer"), @Namespace("/master"), @Namespace("/user") })
public class AllEmployeeSalaryAction extends ActionSupport implements
		Preparable, ModelDriven<Employee>, SessionAware {

	private static final long serialVersionUID = 1L;
	private WorkStepService workStepService;
	private TrackingSheetService trackingSheetService;
	private EmployeeService employeeService;
	private int empHash;
	private Employee employee = new Employee();
	private Date startDate = changeDayByOne(new Date());
	private Date endDate = new Date();
	@SuppressWarnings("unused")
	private String startDateStr;
	@SuppressWarnings("unused")
	private String endDateStr;
	private List<EmployeeSalary> listEmployeeSalary;
	private List<TrackingSheet> listTrackingSheet;
	private List<ReportShow> listReportShows;
	private Map<String, Object> m;
	private List<SumWorkStep> sumList;
	private UsersService usersService;
	private List<Integer> totalSumList;
	private int secondTotal = 0;

	public int getSecondTotal() {
		return secondTotal;
	}

	public void setSecondTotal(int secondTotal) {
		this.secondTotal = secondTotal;
	}

	public List<Integer> getTotalSumList() {
		return totalSumList;
	}

	public void setTotalSumList(List<Integer> totalSumList) {
		this.totalSumList = totalSumList;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(final UsersService usersService) {
		this.usersService = usersService;
	}

	public void setWorkStepService(final WorkStepService workStepService) {
		this.workStepService = workStepService;
	}

	@SkipValidation
	@Action(value = "allEmployeeSalary1", results = {
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", type = "tiles", location = "/allEmployeeSalaryReport.tiles") })
	public String execute1() throws Exception {
//		if (SessionInterceptor.isValid()) {
			setListEmployeeSalary(new LinkedList<EmployeeSalary>());
			m.put("d1", startDate);
			m.put("d2", endDate);
			return SUCCESS;
//		} else {
//			return ERROR;
//		}
	}

	@SkipValidation
	@Action(value = "allEmployeeSalary", results = {
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", type = "tiles", location = "/allEmployeeSalaryReport.tiles") })
	public String execute() throws Exception {
//		if (SessionInterceptor.isValid()) {
			setListEmployeeSalary(workStepService.getAllEmployeeSalary(
					startDate, endDate, employee.getId()));
			m.put("d1", startDate);
			m.put("d2", endDate);
			return SUCCESS;
//		} else {
//			return ERROR;
//		}
	}

	@Action(value = "reportShow", results = {
			@Result(name = "success", type = "tiles", location = "/reportShow.tiles"),
			@Result(name = "input", type = "redirectAction", location = "allEmployeeSalary") })
	public String show() throws Exception {
		try {
			Date startDate = new Date();
			startDate = (Date) m.get("d1");
			Date endDate = new Date();
			endDate = (Date) m.get("d2");
			setListTrackingSheet(trackingSheetService.getAllEmp(startDate,
					endDate, employee));
			sumList = new LinkedList<SumWorkStep>();
			sumList = workStepService.changeSubWorkStep(listTrackingSheet,
					employee);
			listReportShows = new LinkedList<ReportShow>();
			totalSumList = new ArrayList<Integer>();
			for (int m = 0; m < sumList.size(); m++) {
				totalSumList.add(0);
			}
			for (int i = 0; listTrackingSheet.size() > i; i++) {
				ReportShow rs = new ReportShow();
				rs.setNumber(listTrackingSheet.get(i).getBonus().getValue());
				rs.setCardNo(listTrackingSheet.get(i).getStartNumber());
				rs.setColor(listTrackingSheet.get(i).getYarnColor().getName());
				rs.setModelNo(listTrackingSheet.get(i).getProductModel()
						.getModelId());
				rs.setSize(listTrackingSheet.get(i).getKnitterSize().getSizes());
				rs.setOutWeight((double) listTrackingSheet.get(i)
						.getKnitterWeight());
				rs.setOneWeight((double) listTrackingSheet.get(i)
						.getKnitterWeight()
						/ listTrackingSheet.get(i).getKnitterQuantity());
				rs.setQuantity(listTrackingSheet.get(i).getKnitterQuantity());
				List<SumWorkStep> list = new LinkedList<SumWorkStep>();
				list = workStepService.changeSubWorkStep(sumList,
						listTrackingSheet.get(i).getWorkStepList(), employee,
						startDate, endDate);
				rs.setSumWorkSteps(list);
				int k = 0;
				secondTotal = 0;
				for (SumWorkStep sumWorkStept : list) {
					int g = totalSumList.get(k) + sumWorkStept.getSum();
					totalSumList.remove(k);
					totalSumList.add(k, g);
					secondTotal = secondTotal + totalSumList.get(k);
					k++;
				}
				rs.setSecondSum(workStepService.changeSecondSum(rs
						.getSumWorkSteps()));
				listReportShows.add(rs);
			}
			/*
			 * List<ProductionStep> allPSList = productionStepService.findAll();
			 * List<ProductionStep> joinPSList = new
			 * ArrayList<ProductionStep>(); for (int i = 0; allPSList.size() >
			 * i; i++) {
			 * 
			 * @SuppressWarnings("unchecked") List<StepPrice> spList =
			 * workStepService .getCurrentSession()
			 * .getNamedQuery("workStep.getSomeStepPrice")
			 * .setString("productStep_id",
			 * allPSList.get(i).getId().toString()).list(); if ((spList.size()
			 * != 0) && (spList != null)) { joinPSList.add(allPSList.get(i)); }
			 * } for (int i = 0; joinPSList.size() > i; i++) {
			 * JOptionPane.showMessageDialog(null, joinPSList.get(i).getName());
			 * }
			 */
			// m.clear();
			return SUCCESS;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return INPUT;
		}
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<EmployeeSalary> getListEmployeeSalary() {
		return listEmployeeSalary;
	}

	public void setListEmployeeSalary(List<EmployeeSalary> listEmployeeSalary) {
		this.listEmployeeSalary = listEmployeeSalary;
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public Employee getModel() {
		return employee;
	}

	public void prepare() throws Exception {
		if ((employee != null) && (employee.getId() != null)
				&& employee.getId() != -1) {
			this.employee = employeeService.get(employee.getId());
			setEmpHash(employee.hashCode());
		}
	}

	public int getEmpHash() {
		return empHash;
	}

	public void setEmpHash(int empHash) {
		this.empHash = empHash;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

	public List<TrackingSheet> getListTrackingSheet() {
		return listTrackingSheet;
	}

	public void setListTrackingSheet(List<TrackingSheet> listWorkStep) {
		this.listTrackingSheet = listWorkStep;
	}

	public TrackingSheetService getTrackingSheetService() {
		return trackingSheetService;
	}

	public void setTrackingSheetService(
			final TrackingSheetService trackingSheetService) {
		this.trackingSheetService = trackingSheetService;
	}

	public List<ReportShow> getListReportShows() {
		return listReportShows;
	}

	public void setListReportShows(List<ReportShow> listReportShows) {
		this.listReportShows = listReportShows;
	}

	public final List<SumWorkStep> getSumList() {
		return sumList;
	}

	public final void setSumList(List<SumWorkStep> sumList) {
		this.sumList = sumList;
	}

	private Date changeDayByOne(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	public List<Employee> getEmployees() {
		if (ServletActionContext.getRequest().isUserInRole("admin-role"))
			return employeeService.getNormalEmployeeList();
		else {
			Users user = new Users();
			user = usersService.getUserName(ServletActionContext.getRequest()
					.getUserPrincipal().toString());
			/*
			 * JOptionPane.showMessageDialog( null, user.getId() + "    " +
			 * user.getUserName() + "    " + user.getRole());
			 */
			return employeeService.getEmpUser(user.getId());
		}
	}

	public String getStartDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(startDate);
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
		this.startDate = stringToDate(startDateStr);
	}

	public String getEndDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(endDate);
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
		this.endDate = stringToDate(endDateStr);
	}

	private Date stringToDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!str.equals(""))
				date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
