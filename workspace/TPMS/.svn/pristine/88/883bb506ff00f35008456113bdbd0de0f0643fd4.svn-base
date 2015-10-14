package mn.threesor.tims.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import mn.threesor.tims.model.Colour;
import mn.threesor.tims.model.ColourPersentSum;
import mn.threesor.tims.model.TrackingSheet;
import mn.threesor.tims.service.ColourService;
import mn.threesor.tims.service.TrackingSheetService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/employee"),
		@Namespace("/designer"), @Namespace("/master"), @Namespace("/user") })
public class TotalYarnReportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date firstDate = changeDayByOne(new Date());
	private Date secondDate = new Date();
	private String colour;
	private Long colourId;
	private ColourService colourService;
	private List<TrackingSheet> listTrackingSheet;
	private List<ColourPersentSum> listColourPersentSum;
	private TrackingSheetService trackingSheetService;

	@SkipValidation
	@Action(value = "totalYarnReport", results = { @Result(name = "success", type = "tiles", location = "/totalYarnReport.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "totalYarnReportSearch", results = { @Result(name = "success", type = "tiles", location = "/totalYarnReport.tiles") })
	public String searchYarn() throws Exception {
		/*setListTrackingSheet(trackingSheetService.getTotalYarnReport(colour,
				firstDate, secondDate));*/
		setListColourPersentSum(trackingSheetService.getTotalYarnReport(colourService.get(colourId),
				firstDate, secondDate));
		return SUCCESS;
	}

	public Long getColourId() {
		return colourId;
	}

	public void setColourId(Long colourId) {
		this.colourId = colourId;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getSecondDate() {
		return secondDate;
	}

	public void setSecondDate(Date secondDate) {
		this.secondDate = secondDate;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public ColourService getColourService() {
		return colourService;
	}

	public void setColourService(ColourService colourService) {
		this.colourService = colourService;
	}

	public List<TrackingSheet> getListTrackingSheet() {
		return listTrackingSheet;
	}

	public void setListTrackingSheet(List<TrackingSheet> listTrackingSheet) {
		this.listTrackingSheet = listTrackingSheet;
	}

	public List<ColourPersentSum> getListColourPersentSum() {
		return listColourPersentSum;
	}

	public void setListColourPersentSum(
			List<ColourPersentSum> listColourPersentSum) {
		this.listColourPersentSum = listColourPersentSum;
	}

	public TrackingSheetService getTrackingSheetService() {
		return trackingSheetService;
	}

	public void setTrackingSheetService(
			TrackingSheetService trackingSheetService) {
		this.trackingSheetService = trackingSheetService;
	}

	private Date changeDayByOne(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	public String getSecondDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(secondDate);
	}

	public void setSecondDateStr(String seconfDateStr) {
		this.secondDate = stringToDate(seconfDateStr);
	}

	public String getFirstDateStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(firstDate);
	}

	public void setFirstDateStr(String firstDateStr) {
		this.firstDate = stringToDate(firstDateStr);
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
