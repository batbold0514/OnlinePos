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

import javax.servlet.http.HttpServletRequest;

//import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.tims.enums.statusTrackingSheet;
import mn.threesor.tims.model.Bonus;
import mn.threesor.tims.model.Colour;
import mn.threesor.tims.model.Customer;
import mn.threesor.tims.model.Employee;
import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.model.QuantityWorkStep;
import mn.threesor.tims.model.Size;
import mn.threesor.tims.model.TrackingSheet;
import mn.threesor.tims.model.WorkStep;
import mn.threesor.tims.service.BarcodeService;
import mn.threesor.tims.service.BonusService;
import mn.threesor.tims.service.ColourService;
import mn.threesor.tims.service.CustomerService;
import mn.threesor.tims.service.EmployeeService;
import mn.threesor.tims.service.ProductModelService;
import mn.threesor.tims.service.SizeService;
import mn.threesor.tims.service.TrackingSheetService;
import mn.threesor.tims.service.WorkStepService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/master"),
		@Namespace("/designer"), @Namespace("/user") })
public class TrackingSheetAction extends ActionSupport implements
		ModelDriven<TrackingSheet>, Preparable, SessionAware,
		ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private TrackingSheet trackingSheet = new TrackingSheet();
	private TrackingSheetService trackingSheetService;
	private List<TrackingSheet> ListTrackingSheet;
	private int trackingSheetHash;
	private EmployeeService employeeService;
	private WorkStepService workStepService;
	private ProductModelService productModelService;
	private CustomerService customerService;
	private List<WorkStep> subWorkStepList;
	private String actualChekerLong;
	private String productModelLong;
	private String knitterChekerLong;
	private String productionStepCheckerLong;
	private String customerLong;
	private Map<String, Object> m;
	private HttpServletRequest request;
	private String addId;
	private ColourService colourService;
	private SizeService sizeService;
	private String yarnColorString;
	private String knitterSizeString;
	private List<QuantityWorkStep> listOfQuantityWorkStep;
	private BonusService bonusService;
	private String aChecker = "-1";
	private String pSChecker = "-1";
	private String kniterChecker = "-1";
	private String cstomer = "-1";
	private String productMoodel = "-1";
	private String barCodeEdit;
	private String bonusString;
	private String modelID;
	private String stDate;
	private List<String> listColorID;
	private BarcodeService barcodeService = new BarcodeService();
	private String quantityChange;
	private int changeId;
	private Long tsId;
	private Date startDate = changeDayByOne(new Date());
	private Date endDate = new Date();
	@SuppressWarnings("unused")
	private String startDateTs;
	@SuppressWarnings("unused")
	private String endDateTs;
	private List<String> wsDateList = new ArrayList<String>();

	public List<String> getWsDateList() {
		return wsDateList;
	}

	public void setWsDateList(List<String> wsDateList) {
		this.wsDateList = wsDateList;
	}

	public Long getTsId() {
		return tsId;
	}

	public void setTsId(Long tsId) {
		this.tsId = tsId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	private Date changeDayByOne(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	public String getStartDateTs() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(startDate);
	}

	public void setStartDateTs(String startDateTs) {
		this.startDateTs = startDateTs;
		this.startDate = stringToDate(startDateTs);
	}

	public String getEndDateTs() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(endDate);
	}

	public void setEndDateTs(String endDateTs) {
		this.endDateTs = endDateTs;
		this.endDate = stringToDate(endDateTs);
	}

	public TrackingSheet getTrackingSheet() {
		return trackingSheet;
	}

	public void setTrackingSheet(TrackingSheet trackingSheet) {
		this.trackingSheet = trackingSheet;
	}

	public int getChangeId() {
		return changeId;
	}

	public void setChangeId(int changeId) {
		this.changeId = changeId;
	}

	public String getQuantityChange() {
		return quantityChange;
	}

	public void setQuantityChange(String quantityChange) {
		this.quantityChange = quantityChange;
	}

	public String getBarCodeEdit() {
		return barCodeEdit;
	}

	public void setBarCodeEdit(String barCodeEdit) {
		this.barCodeEdit = barCodeEdit;
	}

	public List<QuantityWorkStep> getListOfQuantityWorkStep() {
		return listOfQuantityWorkStep;
	}

	public void setListOfQuantityWorkStep(
			List<QuantityWorkStep> listOfQuantityWorkStep) {
		this.listOfQuantityWorkStep = listOfQuantityWorkStep;
	}

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	public void setTrackingSheetService(
			final TrackingSheetService trackingShitService) {
		this.trackingSheetService = trackingShitService;
	}

	public void setEmployeeService(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setWorkStepService(final WorkStepService workStepService) {
		this.workStepService = workStepService;
	}

	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	public void setBonusService(final BonusService bonusService) {
		this.bonusService = bonusService;
	}

	public void setProductModelService(
			final ProductModelService productModelService) {
		this.productModelService = productModelService;
	}

	public void prepare() throws Exception {
		if (trackingSheet != null && trackingSheet.getId() != null) {
			this.trackingSheet = trackingSheetService
					.get(trackingSheet.getId());
			this.trackingSheetHash = trackingSheet.hashCode();
		}
	}

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public TrackingSheet getModel() {
		return trackingSheet;
	}

	public List<Employee> getEmployees() {
		return employeeService.getNormalEmployeeList();
	}

	public List<WorkStep> getWorkSteps() {
		return workStepService.findAll();
	}

	public List<ProductModel> getProductModels() {
		return productModelService.getProductModelActiveList();
	}

	@SkipValidation
	@Action(value = "trackingSheetList", results = { @Result(name = "success", type = "tiles", location = "/trackingSheet-list.tiles") })
	public String list() throws Exception {
		this.setListTrackingSheet(trackingSheetService.findByDateRange(
				startDate, endDate));
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "trackingSheetSearch", results = { @Result(name = "success", type = "tiles", location = "/trackingSheet-list.tiles") })
	public String searchlist() throws Exception {
		this.setListTrackingSheet(trackingSheetService.findByDateRange(
				startDate, endDate));
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "trackingST-list-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-trackingsheet/trackingsheet-list.jsp") })
	public String listajax() throws Exception {
		this.setListTrackingSheet(trackingSheetService.findByDateRange(
				startDate, endDate));
		TrackingSheet ts = trackingSheetService.getLastAddedTrackingSheet();
		if (!this.ListTrackingSheet.contains(ts))
			this.ListTrackingSheet.add(ts);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "trackingSheet", results = { @Result(name = "success", type = "tiles", location = "/trackingSheet.tiles") })
	public String execute() throws Exception {
		trackingSheet.setStartDate(new Date());
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "trackingSheet-edit-ajax", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-trackingsheet/trackingsheet-edit-result.jsp", params = {
			"model.id", "${id}" }) })
	public String TSedit() throws Exception {
		for (int i = 0; i < trackingSheet.getWorkStepList().size(); i++) {
			if (trackingSheet.getWorkStepList().get(i).getEmp() != null) {
				request.setAttribute("successTrackingSheet", "true");
				return SUCCESS;
			}
		}
		return SUCCESS;
	}

	@Action(value = "save-trackingST-ajax", results = {
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", location = "/WEB-INF/content/ajax-trackingsheet/trackingsheet-result.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-trackingsheet/trackingsheet-result.jsp") })
	public String save() throws Exception {
		if (trackingSheet != null
				&& trackingSheet.hashCode() != trackingSheetHash) {
			Boolean check = true;
			if (trackingSheet.getCustomer() == null) {
				addFieldError("cstomer", Messages.getString("customerHeader"));
				check = false;
			}

			if (trackingSheet.getProductModel() == null) {
				addFieldError("productMoodel",
						Messages.getString("productModel_idHeader"));
				check = false;

			}
			if (trackingSheet.getKnitterChecker() == null) {
				addFieldError("kniterChecker",
						Messages.getString("knitterChecker_idHeader"));
				check = false;
			}
			if (knitterSizeString == null) {
				addFieldError("knitterSizeString",
						Messages.getString("knitterSize"));
				check = false;
			}
			if (trackingSheet.getProductionStepChecker() == null) {
				addFieldError("PSChecker",
						Messages.getString("productionStepChecker_idHeader"));
				check = false;
			}
			if (trackingSheet.getActualChecker() == null) {
				addFieldError("aChecker",
						Messages.getString("actualChecker_idHeader"));
				check = false;
			}
			if (trackingSheet.getKnitterQuantity() == 0) {
				addFieldError("knitterQuantity", Messages.getString("notZero"));
				check = false;
			}
			/*
			 * Date dd = new Date(); if
			 * (stringToDate(this.getStDate()).after(dd)) {
			 * addFieldError("stDate", Messages.getString("outOfDateRange"));
			 * check = false; }
			 */
//			if (!SessionInterceptor.isValid()) {
//				return ERROR;
//			}
			if (check) {
				trackingSheet.setYarnColorList(trackingSheetService
						.strListToColourList(listColorID, colourService));
				trackingSheet.setStartDate(stringToDate(this.getStDate()));
				trackingSheet.setBonus(bonusService.get(Long
						.parseLong(bonusString.trim())));
				trackingSheet.setWorkStepList(workStepService
						.changeStepPriceToWorkStep(trackingSheet.getId(),
								trackingSheet.getProductModel().getId(),
								trackingSheet.getBonus().getValue()));
				trackingSheet.setYarnColor(trackingSheet.getYarnColorList()
						.get(0));
				trackingSheet.setKnitterSize(sizeService.get(Long
						.parseLong(knitterSizeString.trim())));
				trackingSheet.setStartNumber(trackingSheetService
						.getStartNumber(trackingSheet.getStartDate()));
				trackingSheetService.saveOrUpdate(trackingSheet);
				trackingSheetService.log(trackingSheet, "save");
				m.put("save", "true");
				m.put("savedObject", trackingSheet);
				request.setAttribute("successUser", "true");
				return SUCCESS;
			}

		}
		return INPUT;
	}

	@SkipValidation
	@Action(value = "trackingSheetShow", results = {
			@Result(name = "success", type = "tiles", location = "/trackingSheetShow.tiles"),
			@Result(name = "input", type = "tiles", location = "/trackingSheetShowStickit.tiles") })
	public String show() throws Exception {
		subWorkStepList = trackingSheet.getWorkStepList();
		for (WorkStep ws : subWorkStepList) {
			if (ws.getEmp() == null) {
				ws.setQuantity(trackingSheet.getKnitterQuantity());
				ws.setDate(new Date());
			}
		}
		m.put("ts", trackingSheet);
		m.put("subWorkStepList", subWorkStepList);
		// m.remove("addWorkStepList");
		// addWorkStepList = (LinkedList<WorkStep>) m.get("addWorkStepList");
		if (trackingSheet.getStatus().equals(statusTrackingSheet.finished)) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	@SuppressWarnings("unchecked")
	@Action(value = "quantityChange-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-trackingsheet/quantityChange-ajax.jsp" , params = {
					"model.id", "${id}" }),
			@Result(name = "input", location = "/WEB-INF/content/ajax-trackingsheet/quantityChange-ajax.jsp" , params = {
					"model.id", "${id}" }) })
	public String qua() {
		try {
			subWorkStepList = (List<WorkStep>) m.get("subWorkStepList");
			subWorkStepList.get(changeId)
					.setQuantity(Integer.parseInt(quantityChange));
			m.put("subWorkStepList", subWorkStepList);
		} catch (Exception e) {
			addFieldError("subWorkStepList[" + changeId + "].quantity",
					Messages.getString("subWokStepList_quantityEqualfasdf"));
		}
		return "success";

	}

	@SkipValidation
	@Action(value = "trackingSheetPrint", results = {
			@Result(name = "success", location = "../trackingSheet-print.jsp"),
			@Result(name = "input", type = "tiles", location = "/trackingSheetShowStickit.tiles") })
	public String tprint() throws Exception {
		subWorkStepList = trackingSheet.getWorkStepList();
		/* m.put("ts", trackingSheet); */
		m.put("subWorkStepList", subWorkStepList);
		// m.remove("addWorkStepList");
		// addWorkStepList = (LinkedList<WorkStep>) m.get("addWorkStepList");
		return SUCCESS;
	}

	@SuppressWarnings({ "unchecked", "finally" })
	@SkipValidation
	@Action(value = "trackingSheetAdd", results = { @Result(name = "success", type = "tiles", location = "/trackingSheetShowStickit.tiles", params = {
			"model.id", "${id}" }) })
	public String add() throws Exception {
		try {
			subWorkStepList = (List<WorkStep>) m.get("subWorkStepList");
			WorkStep subWs = subWorkStepList.get(Integer.parseInt(request
					.getParameter("WSID")));
			if (subWs.getQuantity() > 0
					&& (trackingSheet.getKnitterQuantity() - subWs
							.getQuantity()) > 0) {
				WorkStep ws = new WorkStep(subWs);
				ws.setQuantity(trackingSheet.getKnitterQuantity());
				// JOptionPane.showMessageDialog(null,
				// subWs.getId(),"WorkStep ID",JOptionPane.WARNING_MESSAGE);
				// JOptionPane.showMessageDialog(null,
				// subWs.getQuantity(),"WorkStep Quantity",JOptionPane.WARNING_MESSAGE);
				// JOptionPane.showMessageDialog(null,
				// subWs.getStepPrice().getProductStep().getName(),"ProductionStep name",JOptionPane.WARNING_MESSAGE);
				// JOptionPane.showMessageDialog(null,
				// trackingSheet.getKnitterQuantity(),"Kinitter quantity",JOptionPane.WARNING_MESSAGE);
				// JOptionPane.showMessageDialog(null,
				// trackingSheet.getId(),"Tracking Sheet ID",JOptionPane.WARNING_MESSAGE);
				// addWorkStepList = (LinkedList<WorkStep>)
				// m.get("addWorkStepList");
				// if (addWorkStepList == null)
				// addWorkStepList = new LinkedList<WorkStep>();
				// addWorkStepList.add(ws);
				subWorkStepList.add(
						Integer.parseInt(request.getParameter("WSID")) + 1, ws);
				m.put("subWorkStepList", subWorkStepList);
				trackingSheet.setId(Long.parseLong(request
						.getParameter("model")));
			} else {
				addFieldError(
						"subWorkStepList["
								+ Integer.parseInt(request.getParameter("WSID"))
								+ "].quantity",
						Messages.getString("subWokStepList_quantityEqual"));
			}
		} catch (NumberFormatException ne) {
		} catch (IndexOutOfBoundsException ie) {
		} finally {
			return SUCCESS;
		}
	}

	@SuppressWarnings("unchecked")
	@Action(value = "trackingSheetSave", results = {
			@Result(name = "success", type = "redirectAction", location = "trackingSheetList"),
			@Result(name = "input", type = "tiles", location = "/trackingSheetShowStickit.tiles") })
	public String saveEdit() throws Exception {
		if (trackingSheet != null
				&& trackingSheet.hashCode() != trackingSheetHash) {
			Boolean cheak = true;
			try {
				trackingSheet.setYarnColorList(trackingSheetService
						.getCurrentSession()
						.getNamedQuery("TrackingSheet.getYarnColorList")
						.setLong("id", trackingSheet.getId()).list());
				trackingSheet.setYarnColor(colourService.get(Long
						.parseLong(yarnColorString.trim())));
				trackingSheet.setKnitterSize(sizeService.get(Long
						.parseLong(knitterSizeString.trim())));
				trackingSheet.setActualChecker(employeeService.get(Long
						.parseLong(actualChekerLong)));
				trackingSheet.setKnitterChecker(employeeService.get(Long
						.parseLong(knitterChekerLong)));
				trackingSheet.setProductionStepChecker(employeeService.get(Long
						.parseLong(productionStepCheckerLong)));
				trackingSheet.setProductModel(productModelService.get(Long
						.parseLong(productModelLong)));
				trackingSheet.setCustomer(customerService.get(Long
						.parseLong(customerLong)));
				trackingSheet.setBonus(bonusService.get(Long
						.parseLong(bonusString)));
				listOfQuantityWorkStep = new LinkedList<QuantityWorkStep>();
				int i = 0;
				int has;
				boolean dd = false;
				for (WorkStep ws : subWorkStepList) {
					ws.setDate(stringToDate(wsDateList.get(i)));
					has = hasWorkStep(listOfQuantityWorkStep, ws);
					if (ws.getQuantity() < 0) {
						addFieldError(
								"subWorkStepList[" + i + "].quantity",
								Messages.getString("subWokStepList_quantityZero"));
						cheak = false;
					}
					if (has == -1) {
						listOfQuantityWorkStep.add(new QuantityWorkStep(ws
								.getStepPrice().getProductStep(), ws
								.getQuantity(), i));
					} else {
						listOfQuantityWorkStep.get(has).addLocation(i);
						listOfQuantityWorkStep.get(has).setQuantity(
								listOfQuantityWorkStep.get(has).getQuantity()
										+ ws.getQuantity());
					}
					ProductionStep psd = (ProductionStep) workStepService
							.getCurrentSession()
							.getNamedQuery("Workstep.getStepPrice")
							.setLong("id", ws.getStepPrice().getId()).list()
							.get(0);
					if (psd.getId() == 1000) {
						if (ws.getEmp() != null)
							trackingSheet.setMainKnitter(ws.getEmp());
						dd = true;
					}
					if (!dd) {
						if (psd.getId() == 1001) {
							if (ws.getEmp() != null)
								trackingSheet.setMainKnitter(ws.getEmp());
						}
					}
					i++;
					if (ws.getEmp().getId() == -1) {
						ws.setEmp(null);
					}
				}

				for (QuantityWorkStep qws : listOfQuantityWorkStep) {
					if (qws.getQuantity() > trackingSheet.getKnitterQuantity()) {
						for (Integer loc : qws.getListOfLocation()) {
							addFieldError(
									"subWorkStepList[" + loc + "].quantity",
									Messages.getString("subWokStepList_quantity"));
							cheak = false;
						}
					}
				}
				if (cheak) {
					trackingSheet.setWorkStepList(workStepService
							.addWorkStepList(trackingSheet.getWorkStepList(),
									subWorkStepList));
					trackingSheet.setWorkStepList(workStepService
							.updateWorkStepList(subWorkStepList, trackingSheet
									.getBonus().getValue()));
					subWorkStepList = trackingSheet.getWorkStepList();
					if (trackingSheet.getStatus().equals(
							statusTrackingSheet.finished)) {
						for (QuantityWorkStep qws : listOfQuantityWorkStep) {
							if (qws.getQuantity() != trackingSheet
									.getKnitterQuantity()) {
								for (Integer loc : qws.getListOfLocation()) {
									addFieldError(
											"subWorkStepList[" + loc
													+ "].quantity",
											Messages.getString("subWokStepList_quantityEqual"));
									cheak = false;
								}
							}
						}
						i = 0;
						for (WorkStep ws : subWorkStepList) {
							if (ws.getEmp() == null) {
								addFieldError(
										"subWorkStepList[" + i + "].emp.id",
										Messages.getString("subWokStepList_employee"));
								cheak = false;
							}
							i++;
						}
						if (cheak) {
							if (trackingSheet.getEndNumber() == null
									|| trackingSheet.getEndNumber().equals("")) {
								trackingSheet.setEndDate(new Date());
								trackingSheet
										.setBackingListNumber(trackingSheetService
												.getLastNumber() + 1);
								trackingSheet.setEndNumber(trackingSheetService
										.getEndNumber(trackingSheet
												.getEndDate()));
							}
						} else {
							return INPUT;
						}
					}
					if (trackingSheet.getStatus().getLabel()
							.equalsIgnoreCase("Дууссан")
							&& trackingSheet.getBarcode().equals("")) {
						// trackingSheet.setBarcode(trackingSheetService
						// .getBarcode(trackingSheet));
						trackingSheet
								.setBarcode(barcodeService.getBarCode(
										Messages.getCustomer("customer"),
										trackingSheet));
					}
					trackingSheetService.saveOrUpdate(trackingSheet);
					trackingSheetService.log(trackingSheet, "update");
					m.remove("ts");
					m.remove("subWorkStepList");
					// m.remove("addWorkStepList");
					return SUCCESS;

				}
			} catch (Exception e) {
				addFieldError("subWorkStepList[" + 0 + "].quantity",
						Messages.getString("subWokStepList_quantity"));
			}
		}
		return INPUT;
	}

	@Action(value = "trackingSheetSaveStatus", results = { @Result(name = "success", type = "redirectAction", location = "trackingSheetList") })
	public String saveEditStatus() throws Exception {
		TrackingSheet ts = trackingSheetService.get(trackingSheet.getId());
		ts.setStatus(trackingSheet.getStatus());
		ts.setBarcode(barCodeEdit);
		trackingSheetService.saveOrUpdate(ts);
		return SUCCESS;
	}

	@Action(value = "showTrackingSheetList", results = { @Result(name = "success", type = "tiles", location = "/trackingSheet-list.tiles") })
	public String trackingSheetShow() throws Exception {
		this.ListTrackingSheet = trackingSheetService
				.getTrackingSheetModelId(request.getParameter("model.id")
						.trim());
		return SUCCESS;
	}

	public statusTrackingSheet[] getStatusTrackingSheet() {
		return statusTrackingSheet.values();
	}

	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	public List<TrackingSheet> getListTrackingSheet() {
		return ListTrackingSheet;
	}

	public void setListTrackingSheet(List<TrackingSheet> listTrackingSheet) {
		ListTrackingSheet = listTrackingSheet;
	}

	public List<WorkStep> getSubWorkStepList() {
		return subWorkStepList;
	}

	public void setSubWorkStepList(List<WorkStep> subWorkStepList) {
		this.subWorkStepList = subWorkStepList;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setCstomer(String id) {
		trackingSheet.setCustomer(customerService.get(Long.parseLong(id)));
		this.cstomer = id;
	}

	public Long getCstomer() {
		return Long.parseLong(cstomer);
	}

	public void setProductMoodel(String id) {
		trackingSheet.setProductModel(productModelService.get(Long
				.parseLong(id)));
		this.productMoodel = id;
	}

	public Long getProductMoodel() {
		return Long.parseLong(productMoodel);
	}

	public void setKniterChecker(String id) {
		trackingSheet
				.setKnitterChecker(employeeService.get(Long.parseLong(id)));
		this.kniterChecker = id;
	}

	public Long getKniterChecker() {
		return Long.parseLong(kniterChecker);
	}

	public void setPSChecker(String id) {
		trackingSheet.setProductionStepChecker(employeeService.get(Long
				.parseLong(id)));
		this.pSChecker = id;
	}

	public Long getPSChecker() {
		return Long.parseLong(pSChecker);
	}

	public void setAChecker(String id) {
		trackingSheet.setActualChecker(employeeService.get(Long.parseLong(id)));
		this.aChecker = id;
	}

	public Long getAChecker() {
		return Long.parseLong(aChecker);
	}

	public String getActualChekerLong() {
		return actualChekerLong;
	}

	public void setActualChekerLong(String actualChekerLong) {
		this.actualChekerLong = actualChekerLong;
	}

	public String getProductModelLong() {
		return productModelLong;
	}

	public void setProductModelLong(String productModelLong) {
		this.productModelLong = productModelLong;
	}

	public String getKnitterChekerLong() {
		return knitterChekerLong;
	}

	public void setKnitterChekerLong(String knitterChekerLong) {
		this.knitterChekerLong = knitterChekerLong;
	}

	public String getProductionStepCheckerLong() {
		return productionStepCheckerLong;
	}

	public void setProductionStepCheckerLong(String productionStepCheckerLong) {
		this.productionStepCheckerLong = productionStepCheckerLong;
	}

	public String getCustomerLong() {
		return customerLong;
	}

	public void setCustomerLong(String customerLong) {
		this.customerLong = customerLong;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public void setSession(Map<String, Object> m) {
		this.m = m;
	}

	// public List<WorkStep> getAddWorkStepList() {
	// return addWorkStepList;
	// }

	// public void setAddWorkStepList(List<WorkStep> addWorkStepList) {
	// this.addWorkStepList = addWorkStepList;
	// }

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public List<Size> getSizes() {
		return sizeService.findAll();
	}

	public String getYarnColorString() {
		return yarnColorString;
	}

	public void setYarnColorString(String yarnColorString) {
		this.yarnColorString = yarnColorString;
	}

	public String getKnitterSizeString() {
		return knitterSizeString;
	}

	public void setKnitterSizeString(String knitterSizeString) {
		this.knitterSizeString = knitterSizeString;
	}

	private int hasWorkStep(List<QuantityWorkStep> list, WorkStep ws) {
		for (int i = 0; i < list.size(); i++) {
			QuantityWorkStep qws = list.get(i);
			if (qws.getProductionStep().getName()
					.equals(ws.getStepPrice().getProductStep().getName())) {
				return i;
			}
		}
		return -1;
	}

	public List<Bonus> getBonuses() {
		return bonusService.findAll();
	}

	public String getBonusString() {
		return bonusString;
	}

	public void setBonusString(String bonusString) {
		this.bonusString = bonusString;
	}

	@Action(value = "trackingSheet-colors", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-trackingsheet/trackingsheet-colors.jsp") })
	public String listtt() {
		ProductModel model = productModelService.get(Long.parseLong(modelID));
		trackingSheet.setProductModel(model);
		return SUCCESS;
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
	}

	public List<String> getListColorID() {
		return listColorID;
	}

	public void setListColorID(List<String> listColorID) {
		this.listColorID = listColorID;
	}

	public String getStDate() {
		return stDate;
	}

	public void setStDate(String startDate) {
		this.stDate = startDate;
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
