package mn.threesor.tims.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//import mn.chinbat.interceptor.SessionInterceptor;
import mn.threesor.tims.model.Colour;
import mn.threesor.tims.model.Customer;
import mn.threesor.tims.model.NumberAndPriceReport;
import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.Size;
import mn.threesor.tims.service.ColourService;
import mn.threesor.tims.service.CustomerService;
import mn.threesor.tims.service.ProductModelService;
import mn.threesor.tims.service.SizeService;
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
@Namespaces(value = { @Namespace("/admin"), @Namespace("/designer"),
		@Namespace("/user") })
public class NumberAndPriceReportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date startDate = changeDayByOne(new Date());;
	private Date endDate = new Date();
	private Long customerId = -1l;
	private Long sizeId = -1l;
	private Long colourId = -1l;
	private String modelNumber = "";
	private CustomerService customerService;
	private SizeService sizeService;
	private ProductModelService productModelService;
	private ColourService colourService;
	private TrackingSheetService trackingSheetService;
	private List<NumberAndPriceReport> listOfNumberPriceFinish;
	private List<NumberAndPriceReport> listOfNumberPriceUnFinish;

	@SkipValidation
	@Action(value = "numberAndPriceReport", results = { 
			@Result(name = "error", type = "tiles", location = "/licence.tiles"),
			@Result(name = "success", type = "tiles", location = "/numberAndPriceReport.tiles") })
	public String execute() throws Exception {
//		if (SessionInterceptor.isValid()) {
			if (customerId != -2) {
				if (modelNumber.equals("")) {
					modelNumber = "%";
				}
				listOfNumberPriceFinish = trackingSheetService
						.getNumberAndPriceFinish(startDate, endDate,
								String.valueOf(customerId),
								String.valueOf(sizeId), modelNumber,
								String.valueOf(colourId), trackingSheetService);
				listOfNumberPriceUnFinish = trackingSheetService
						.getNumberAndPriceUnFinish(startDate, endDate,
								String.valueOf(customerId),
								String.valueOf(sizeId), modelNumber,
								String.valueOf(colourId), trackingSheetService);
				return SUCCESS;
			}
			return SUCCESS;
//		} else {
//			return ERROR;
//		}
	}

	public Long getTotalCost() {
		Long total = 0l;
		for (int i = 0; i < listOfNumberPriceFinish.size(); i++) {
			total += listOfNumberPriceFinish.get(i).getTotalCostPrice();
		}
		for (int i = 0; i < listOfNumberPriceUnFinish.size(); i++) {
			total += listOfNumberPriceUnFinish.get(i).getTotalCostPrice();
		}
		return total;
	}

	public Long getTotalSell() {
		Long total = 0l;
		for (int i = 0; i < listOfNumberPriceFinish.size(); i++) {
			total += listOfNumberPriceFinish.get(i).getSellPrice();
		}
		for (int i = 0; i < listOfNumberPriceUnFinish.size(); i++) {
			total += listOfNumberPriceUnFinish.get(i).getSellPrice();
		}
		return total;
	}

	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public List<Size> getSizes() {
		return sizeService.findAll();
	}

	public List<ProductModel> getProductModels() {
		return productModelService.findAll();
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public List<NumberAndPriceReport> getListOfNumberPriceFinish() {
		return listOfNumberPriceFinish;
	}

	public List<NumberAndPriceReport> getListOfNumberPriceUnFinish() {
		return listOfNumberPriceUnFinish;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setSizeService(final SizeService sizeService) {
		this.sizeService = sizeService;
	}

	public void setProductModelService(
			final ProductModelService productModelService) {
		this.productModelService = productModelService;
	}

	public void setTrackingSheetService(
			final TrackingSheetService trackingSheetService) {
		this.trackingSheetService = trackingSheetService;
	}

	public void setColourService(final ColourService colourService) {
		this.colourService = colourService;
	}

	public Long getColourId() {
		return colourId;
	}

	public void setColourId(Long colourId) {
		this.colourId = colourId;
	}

	private Date changeDayByOne(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
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
