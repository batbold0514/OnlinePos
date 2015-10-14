package mn.threesor.tims.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import mn.threesor.tims.model.ModelReportModel;
import mn.threesor.tims.service.TrackingSheetService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user"),
		@Namespace("/designer") })
public class ModelReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private TrackingSheetService trackingSheetService;
	private Date startDate = changeDayByOne();
	private Date endDate = new Date();
	private List<ModelReportModel> modelReportList;
	private String check;
	private String listOfNumbers;
	
	public void setTrackingSheetService(
			final TrackingSheetService trackingSheetService) {
		this.trackingSheetService = trackingSheetService;
	}

	@Action(value = "modelReport", results = { @Result(name = "success", type = "tiles", location = "/model-report.tiles") })
	public String execute() throws Exception {
		this.modelReportList = trackingSheetService.getModelReportList(
				startDate, endDate);
		return SUCCESS;
	}

	@Action(value = "excelExport", results = { @Result(name = "success", type = "tiles", location = "/model-report-export.tiles") })
	public String export() throws Exception {
		String[] list = listOfNumbers.split("\\D");
		this.modelReportList = trackingSheetService.getModelReportList(
				startDate, endDate);
		for (String str : list) {
			if (!str.equals(""))
				modelReportList.remove(Integer.parseInt(str));
		}
		return SUCCESS;
	}

	private Date changeDayByOne() {
		Calendar cal = new GregorianCalendar();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	/*public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = stringToDate(startDate);
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = stringToDate(endDate);
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}*/

	public List<ModelReportModel> getModelReportList() {
		return modelReportList;
	}

	public void setModelReportList(List<ModelReportModel> modelReportList) {
		this.modelReportList = modelReportList;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getListOfNumbers() {
		return listOfNumbers;
	}

	public void setListOfNumbers(String listOfNumbers) {
		this.listOfNumbers = listOfNumbers;
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

	public String getStartDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(startDate);
	}

	public void setStartDateStr(String startDateStr) {
		this.startDate = stringToDate(startDateStr);
	}

	public String getEndDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(endDate);
	}

	public void setEndDateStr(String endDateStr) {
		this.endDate = stringToDate(endDateStr);
	}

}
