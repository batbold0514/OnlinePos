package mn.threesor.wms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.OutputArticle;
import mn.threesor.wms.service.CustomerService;
import mn.threesor.wms.service.OutputArticleService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class OutputArticleInvoiceAction extends ActionSupport implements
		SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OutputArticleService outputArticleService;
	private CustomerService customerService;
	private List<OutputArticle> listOutputFromDatebase;
	private List<OutputArticle> listOutputIntoDisplay;
	private List<Article> lisArticles;
	private Map<String, Object> m;
	private Date firstDate = getDateOfFirstDayOfMonth();
	private Date secondDate = new Date();
	private Long customerId;
	private String number;

	public List<Article> getLisArticles() {
		return lisArticles;
	}

	public void setLisArticles(List<Article> lisArticles) {
		this.lisArticles = lisArticles;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public List<OutputArticle> getListOutputFromDatebase() {
		return listOutputFromDatebase;
	}

	public void setListOutputFromDatebase(
			List<OutputArticle> listOutputFromDatebase) {
		this.listOutputFromDatebase = listOutputFromDatebase;
	}

	public List<OutputArticle> getListOutputIntoDisplay() {
		return listOutputIntoDisplay;
	}

	public void setListOutputIntoDisplay(
			List<OutputArticle> listOutputIntoDisplay) {
		this.listOutputIntoDisplay = listOutputIntoDisplay;
	}

	public Map<String, Object> getM() {
		return m;
	}

	public void setM(Map<String, Object> m) {
		this.m = m;
	}

	public OutputArticleService getOutputArticleService() {
		return outputArticleService;
	}

	public void setOutputArticleService(
			final OutputArticleService outputArticleService) {
		this.outputArticleService = outputArticleService;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	@SkipValidation
	@Action(value = "outputArticleInvoice", results = { @Result(name = "success", type = "tiles", location = "/invoice.tiles") })
	public String execute() throws Exception {
		listOutputIntoDisplay = new ArrayList<OutputArticle>();
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "outputArticleInvoice-search", results = { @Result(name = "success", type = "tiles", location = "/invoice.tiles") })
	public String list() throws Exception {
		listOutputIntoDisplay = new ArrayList<OutputArticle>();
		listOutputFromDatebase = outputArticleService.getInvoice(customerId,
				firstDate, secondDate);
		int m = 0;
		for (OutputArticle out : listOutputFromDatebase) {
			m = 0;
			if (listOutputIntoDisplay == null) {
				listOutputIntoDisplay.add(out);
			} else {
				for (OutputArticle out1 : listOutputIntoDisplay) {
					if (out1.getNumber().equals(out.getNumber())) {
						m = 1;
					}
				}
				if (m == 0) {
					listOutputIntoDisplay.add(out);
				}
			}
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "outputArticleInvoice-show", results = { @Result(name = "success", type = "redirectAction", location = "multipleOutput1") })
	public String show() throws Exception {
		listOutputFromDatebase = outputArticleService.getNumber(number);
		lisArticles = new ArrayList<Article>();
		for (OutputArticle out : listOutputFromDatebase) {
			Article a = new Article();
			a = out.getArticle();
			a.setCount(out.getOutCount());
			lisArticles.add(a);
		}
		m.put("multiOutlist", lisArticles);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "outputArticleInvoice-print", results = { @Result(name = "success", location = "../outputArticleInvoice-print.jsp") })
	public String print() throws Exception {
		listOutputFromDatebase = outputArticleService.getNumber(number);
		lisArticles = new ArrayList<Article>();
		for (OutputArticle out : listOutputFromDatebase) {
			Article a = new Article();
			a = out.getArticle();
			a.setCount(out.getOutCount());
			lisArticles.add(a);
		}
		m.put("multiOutlist", lisArticles);
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

	private Date getDateOfFirstDayOfMonth() {
		Calendar cal = new GregorianCalendar();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return cal.getTime();
	}

	public String getFirstDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		date = this.firstDate;
		if (date != null) {
			return formatter.format(date);
		}
		return null;
	}

	public void setFirstDate(String firstDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!firstDate.equals(""))
				date = formatter.parse(firstDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.firstDate = date;
	}

	public String getSecondDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		date = this.secondDate;
		if (date != null) {
			return formatter.format(date);
		}
		return null;
	}

	public void setSecondDate(String secondDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (!secondDate.equals(""))
				date = formatter.parse(secondDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.secondDate = date;
	}
}
