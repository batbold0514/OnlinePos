package mn.threesor.wms.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import mn.threesor.wms.enums.OutputArticleActivity;
import mn.threesor.wms.model.Article;
import mn.threesor.wms.model.Colour;
import mn.threesor.wms.model.Customer;
import mn.threesor.wms.model.LocationWms;
import mn.threesor.wms.model.OutputArticle;
import mn.threesor.wms.model.Size;
import mn.threesor.wms.service.ArticleService;
import mn.threesor.wms.service.ColourService;
import mn.threesor.wms.service.CustomerService;
import mn.threesor.wms.service.LocationWmsService;
import mn.threesor.wms.service.OutputArticleService;
import mn.threesor.wms.service.SizeService;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({ @InterceptorRef("transactionInterceptor"),
		@InterceptorRef("paramsPrepareParamsStack") })
@Namespaces(value = { @Namespace("/admin"), @Namespace("/user") })
public class MultipleOutputAction extends ActionSupport implements
		SessionAware, ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OutputArticleService outputArticleService;
	private OutputArticle outputArticle = new OutputArticle();
	private List<OutputArticle> outputArticles;
	private List<Article> articleList;
	private ArticleService articleService;
	private Map<String, Object> m;
	private HttpServletRequest request;
	private String articleName;
	private Long articleSize;
	private String articleCode;
	private Long customerId;
	private CustomerService customerService;
	private int count;
	private String changerId;
	private String articleBarCode;
	private Long articleLocation;
	private LocationWmsService locationWmsService;
	private ColourService colourService;
	private SizeService sizeService;
	private int minusIndex;

	public OutputArticle getOutputArticle() {
		return outputArticle;
	}

	public void setOutputArticle(OutputArticle outputArticle) {
		this.outputArticle = outputArticle;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getChangerId() {
		return changerId;
	}

	public void setChangerId(String changerId) {
		this.changerId = changerId;
	}

	public int getMinusIndex() {
		return minusIndex;
	}

	public void setMinusIndex(int minusIndex) {
		this.minusIndex = minusIndex;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Long getArticleSize() {
		return articleSize;
	}

	public void setArticleSize(Long articleSize) {
		this.articleSize = articleSize;
	}

	public String getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	
	public String getArticleBarCode() {
		return articleBarCode;
	}

	public void setArticleBarCode(String articleBarCode) {
		this.articleBarCode = articleBarCode;
	}

	public Long getArticleLocation() {
		return articleLocation;
	}

	public void setArticleLocation(Long articleLocation) {
		this.articleLocation = articleLocation;
	}

	public LocationWmsService getLocationWmsService() {
		return locationWmsService;
	}

	public void setLocationWmsService(
			final LocationWmsService locationWmsService) {
		this.locationWmsService = locationWmsService;
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

	public List<Colour> getColours() {
		return colourService.findAll();
	}

	public List<LocationWms> getLocations() {
		return locationWmsService.findAll();
	}

	public List<Size> getSizes() {
		return sizeService.findAll();
	}

	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(final ArticleService articleService) {
		this.articleService = articleService;
	}

	public OutputArticleService getOutputArticleService() {
		return outputArticleService;
	}

	public void setOutputArticleService(
			final OutputArticleService outputArticleService) {
		this.outputArticleService = outputArticleService;
	}

	public List<OutputArticle> getOutputArticles() {
		return outputArticles;
	}

	public void setOutputArticles(List<OutputArticle> outputArticles) {
		this.outputArticles = outputArticles;
	}

	public void setSession(Map<String, Object> m) {
		this.m = m;
	}

	public Map<String, Object> getM() {
		return m;
	}

	public void setM(Map<String, Object> m) {
		this.m = m;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@SkipValidation
	@Action(value = "multiOutputSearch", results = { @Result(name = "success", type = "tiles", location = "/multiple-output.tiles") })
	public String list() throws Exception {
		this.articleList = articleService.searchArticleList(articleName,
				articleSize, articleCode, articleLocation, articleBarCode);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "multiOutputGetCustomer", results = { @Result(name = "success", type = "tiles", location = "/multiple-output.tiles") })
	public String getCustomerAction() throws Exception {
		m.put("customer", customerService.get(customerId));
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "multipleOutput", results = { @Result(name = "success", type = "tiles", location = "/multiple-output.tiles") })
	public String multipleOutput() throws Exception {
		m.put("multiOutlist", new LinkedList<Article>());
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "multipleOutput1", results = { @Result(name = "success", type = "tiles", location = "/multiple-output.tiles") })
	public String multipleOutput1() throws Exception {
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@SkipValidation
	@Action(value = "changeCountValue", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-multi-output-list.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-multi-output-error.jsp") })
	public String changeCount() throws Exception {
		setArticleList((List<Article>) m.get("multiOutlist"));
		if (articleList != null) {
			for (Article art : articleList) {
				if (art.getId() == Long.parseLong(changerId)) {
					Article art1 = new Article();
					art1 = articleService.get(art.getId());
					if (art1.getCount() < count) {
						return INPUT;
					} else {
						art.setCount(count);
					}
				}
			}
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@SkipValidation
	@Action(value = "multiOut-minus", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-multi-output-list.jsp") })
	public String multipleOutputMinus() throws Exception {
		setArticleList((List<Article>) m.get("multiOutlist"));
		articleList.remove(minusIndex);
		m.put("multiOutlist", articleList);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@SkipValidation
	@Action(value = "multiOut-saveTemp", results = {
			@Result(name = "success", type = "tiles", location = "/multiple-output.tiles"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-multi-output-list.jsp") })
	public String multipleOutputSaveTemp() throws Exception {
		setArticleList((List<Article>) m.get("multiOutlist"));
		Customer customer = (Customer) m.get("customer");
		String number = outputArticleService
				.getOutputArticleNumber(OutputArticleActivity.unfinish);
		for (Article art : articleList) {
			outputArticle = new OutputArticle();
			outputArticle.setCustomer(customer);
			outputArticle.setOutCount(art.getCount());
			outputArticle.setNumber(number);
			outputArticle.setArticle(art);
			outputArticle.setOutDate(new Date());
			outputArticle.setStatus(OutputArticleActivity.unfinish);
			outputArticleService.save(outputArticle);
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@SkipValidation
	@Action(value = "multiOut-saveFinish", results = { @Result(name = "success", location = "../outputArticleInvoice-print.jsp") })
	public String multipleOutputSaveFinish() throws Exception {
		setArticleList((List<Article>) m.get("multiOutlist"));
		Customer customer = (Customer) m.get("customer");
		String number = outputArticleService
				.getOutputArticleNumber(OutputArticleActivity.finish);
		for (Article art : articleList) {
			outputArticle = new OutputArticle();
			outputArticle.setCustomer(customer);
			outputArticle.setOutCount(art.getCount());
			outputArticle.setNumber(number);
			outputArticle.setArticle(art);
			outputArticle.setOutDate(new Date());
			outputArticle.setStatus(OutputArticleActivity.finish);
			outputArticleService.save(outputArticle);
			Article newArt = new Article();
			newArt = articleService.get(art.getId());
			newArt.setCount(newArt.getCount() - art.getCount());
			articleService.update(newArt);
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@SkipValidation
	@Action(value = "multiple-output-next1", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-multi-output-list.jsp") })
	public String multipleOutputNext() {
		if (request.getParameterValues("rows[]") != null) {
			setArticleList((List<Article>) m.get("multiOutlist"));
			String[] idArray = (String[]) request.getParameterValues("rows[]");
			for (int i = 0; i < idArray.length; i++) {
				Article a = null;
				for (Article art : articleList) {
					if (art.getId() == Long.parseLong(idArray[i])) {
						a = art;
					}
				}

				if (a != null) {
				} else {
					a = articleService.get(Long.parseLong(idArray[i]));
					articleList.add(a);
				}
			}

		}
		m.put("multiOutlist", articleList);
		return SUCCESS;
	}

}
