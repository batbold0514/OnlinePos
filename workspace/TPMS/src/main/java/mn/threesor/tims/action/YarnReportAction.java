package mn.threesor.tims.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

//import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.tims.model.Colour;
import mn.threesor.tims.model.Customer;
import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.Size;
import mn.threesor.tims.model.TrackingSheet;
import mn.threesor.tims.service.ColourService;
import mn.threesor.tims.service.CustomerService;
import mn.threesor.tims.service.ProductModelService;
import mn.threesor.tims.service.SizeService;
import mn.threesor.tims.service.TrackingSheetService;

import com.opensymphony.xwork2.ActionSupport;

@Namespaces(value = { @Namespace("/admin"), @Namespace("/user"),
		@Namespace("/designer") })
public class YarnReportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date firstDate = changeDayByOne(new Date());
	private Date secondDate = new Date();
	private String knitterSize;
	private String colour;
	private String customer;
	private String productModel;
	private TrackingSheetService trackingSheetService;
	private List<TrackingSheet> listTrackingSheet;
	private List<TrackingSheet> listYarnFinish;
	private List<TrackingSheet> listYarnUnfinish;
	private ColourService colourService;
	private SizeService sizeService;
	private CustomerService customerService;
	private ProductModelService productModelService;

	public List<TrackingSheet> getListYarnFinish() {
		return listYarnFinish;
	}

	public void setListYarnFinish(List<TrackingSheet> listYarnFinish) {
		this.listYarnFinish = listYarnFinish;
	}

	public List<TrackingSheet> getListYarnUnfinish() {
		return listYarnUnfinish;
	}

	public void setListYarnUnfinish(List<TrackingSheet> listYarnUnfinish) {
		this.listYarnUnfinish = listYarnUnfinish;
	}

	public String getKnitterSize() {
		return knitterSize;
	}

	public void setKnitterSize(String knitterSize) {
		this.knitterSize = knitterSize;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public List<TrackingSheet> getListTrackingSheet() {
		return listTrackingSheet;
	}

	public void setListTrackingSheet(List<TrackingSheet> listTrackingSheet) {
		this.listTrackingSheet = listTrackingSheet;
	}

	public ColourService getColourService() {
		return colourService;
	}

	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	public SizeService getSizeService() {
		return sizeService;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public ProductModelService getProductModelService() {
		return productModelService;
	}

	public void setProductModelService(
			final ProductModelService productModelService) {
		this.productModelService = productModelService;
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

	public TrackingSheetService getTrackingSheetService() {
		return trackingSheetService;
	}

	public void setTrackingSheetService(
			final TrackingSheetService trackingSheetService) {
		this.trackingSheetService = trackingSheetService;
	}

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public List<Size> getSizes() {
		return sizeService.findAll();
	}

	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	public List<ProductModel> getProductModels() {
		return productModelService.findAll();
	}

	@SkipValidation
	@Action(value = "yarnReport", results = { @Result(name = "success", type = "tiles", location = "/yarnReport.tiles") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "yarnReportShow", results = {
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", type = "tiles", location = "/yarnReport.tiles"),
			@Result(name = "input", type = "tiles", location = "/yarnReport.tiles") })
	public String execute1() throws Exception {
		/*if (SessionInterceptor.isValid()) {*/
			setListTrackingSheet(trackingSheetService.getYarnReport(
					knitterSize, customer, colour, productModel, firstDate,
					secondDate));
			setListYarnFinish(trackingSheetService.getYarnReportFinish(
					knitterSize, customer, colour, productModel, firstDate,
					secondDate));
			setListYarnUnfinish(trackingSheetService.getYarnReportUnfinish(
					knitterSize, customer, colour, productModel, firstDate,
					secondDate));
			return SUCCESS;
		/*} else {
			return ERROR;
		}*/
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
