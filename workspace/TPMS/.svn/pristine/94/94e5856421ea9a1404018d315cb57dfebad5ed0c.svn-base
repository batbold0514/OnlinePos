package mn.threesor.tims.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mn.threesor.tims.enums.ProductModelActivity;
import mn.threesor.tims.helper.ImageFilter;
import mn.threesor.tims.model.ColoursPercent;
import mn.threesor.tims.model.Image;
import mn.threesor.tims.model.Material;
import mn.threesor.tims.model.Messages;
import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.ProductModelCode;
import mn.threesor.tims.model.ProductType;
import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.model.StepPrice;
import mn.threesor.tims.model.StollPrice;
import mn.threesor.tims.service.ColoursPercentService;
import mn.threesor.tims.service.ImageService;
import mn.threesor.tims.service.MaterialService;
import mn.threesor.tims.service.ProductModelCodeService;
import mn.threesor.tims.service.ProductModelService;
import mn.threesor.tims.service.ProductTypeService;
import mn.threesor.tims.service.ProductionStepService;
import mn.threesor.tims.service.StepPriceService;
import mn.threesor.tims.service.StollPriceService;

import org.apache.commons.io.FileUtils;
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
@Namespaces(value = { @Namespace("/admin"), @Namespace("/designer"),
		@Namespace("/user") })
public class ProductModelAction extends ActionSupport implements Preparable,
		ModelDriven<ProductModel>, SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private ProductModel productModel = new ProductModel();
	private ProductModelCode productModelCode = new ProductModelCode();
	private ProductModelCodeService productModelCodeService;
	private ProductModelService productModelService;
	private int productModelHash;
	private List<ProductModel> listOfPM;
	private ProductionStepService psService;
	private List<ProductionStep> listOfStep = new LinkedList<ProductionStep>();
	private StepPriceService stepPriceService;
	private String subCategory;
	private String subMaterial;
	private String subGauge;
	private String subNumber;
	private String subProductTypeString;
	private String subModelId;
	private ProductType subProductType = new ProductType();
	private Map<String, Object> m;
	private List<Integer> listOfPrice;
	private ProductTypeService productTypeService;
	private StollPriceService stollPriceService;
	private List<File> files = new ArrayList<File>();
	private List<String> imFileName = new ArrayList<String>();
	private List<String> imContentType = new ArrayList<String>();
	private List<Image> imageList = new ArrayList<Image>();
	List<File> fileList = new ArrayList<File>();
	private ImageService imageService;
	private HttpServletRequest servletRequest;
	private MaterialService materialService;
	private List<Integer> listOfColorPercent;
	private ColoursPercentService coloursPercentService;

	@VisitorFieldValidator(message = "", appendPrefix = false)
	public ProductModel getModel() {
		return productModel;
	}

	public List<ProductType> getProductTypes() {
		return productTypeService.getActiveProductTypeList();
	}

	public void setProductTypeService(
			final ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(final ImageService imageService) {
		this.imageService = imageService;
	}

	public void setStollPriceService(final StollPriceService stollPriceService) {
		this.stollPriceService = stollPriceService;
	}

	public void setColoursPercentService(
			final ColoursPercentService coloursPercentService) {
		this.coloursPercentService = coloursPercentService;
	}

	public StepPriceService getStepPriceService() {
		return stepPriceService;
	}

	public void setProductModelCodeService(
			final ProductModelCodeService productModelCodeService) {
		this.productModelCodeService = productModelCodeService;
	}

	public void setProductModel(final ProductModel productModel) {
		this.productModel = productModel;
	}

	public void setStepPriceService(final StepPriceService stepPriceService) {
		this.stepPriceService = stepPriceService;
	}

	public void setMaterialService(final MaterialService materialService) {
		this.materialService = materialService;
	}

	@SuppressWarnings("unchecked")
	public List<ProductModel> getListOfPM() {
		listOfPM = productModelService.findAllSort();
		List<ProductionStep> allPSList = productModelService
				.getCurrentSession()
				.getNamedQuery("productModel.getAllProductionStep").list();
		List<ProductionStep> joinPSList = new ArrayList<ProductionStep>();
		for (int i = 0; allPSList.size() > i; i++) {
			List<StepPrice> spList = productModelService
					.getCurrentSession()
					.getNamedQuery("productModel.getSomeStepPrice")
					.setString("productStep_id",
							allPSList.get(i).getId().toString()).list();
			if ((spList.size() != 0) && (spList != null)) {
				joinPSList.add(allPSList.get(i));
			}
		}
		for (int i = 0; listOfPM.size() > i; i++) {
			ProductModel pm = new ProductModel(listOfPM.get(i));
			List<Image> imList = new ArrayList<Image>();
			for (int inc = 0; listOfPM.get(i).getImageList().size() > inc; inc++) {
				if (listOfPM.get(i).getImageList().get(inc).getIsMain() == true) {
					imList.add(listOfPM.get(i).getImageList().get(inc));
				}
			}
			if (imList.size() <= 0) {
				Image imageBlank = new Image();
				imageBlank.setName("blank.png");
				imageBlank.setIsMain(true);
				imList.add(imageBlank);
				pm.setImageList(imList);
			} else {
				pm.setImageList(imList);
			}

			List<StepPrice> stepPriceList = new ArrayList<StepPrice>();
			for (int j = 0; pm.getListOfStepPrice().size() > j; j++) {
				if (pm.getListOfStepPrice().get(j).getPrice() != 0) {
					stepPriceList.add(pm.getListOfStepPrice().get(j));
				}
			}
			List<ProductionStep> psList = new ArrayList<ProductionStep>();
			for (int j = 0; stepPriceList.size() > j; j++) {
				psList.add(stepPriceList.get(j).getProductStep());
			}
			/*
			 * List<ColoursPercent> cpList = new ArrayList<ColoursPercent>();
			 * for (int j = 0; cp.size() > j; j++) {
			 * psList.add(stepPriceList.get(j).getProductStep()); }
			 */
			for (int j = 0; joinPSList.size() > j; j++) {
				if (!psList.contains(joinPSList.get(j))) {
					for (int k = 0; psList.size() > k; k++) {
						if (joinPSList.get(j).getId() < psList.get(k).getId()) {
							psList.add(k, joinPSList.get(j));
							StepPrice sp = new StepPrice(joinPSList.get(j));
							stepPriceList.add(k, sp);
							break;
						} else if (((psList.size() - 1) == k)
								&& (joinPSList.get(j).getId() > psList.get(k)
										.getId())) {
							psList.add(joinPSList.get(j));
							StepPrice sp = new StepPrice(joinPSList.get(j));
							stepPriceList.add(sp);
							break;
						}
					}
				}
			}
			pm.setListOfStepPrice(stepPriceList);
			StollPrice stollPrice = productModelService.getRealStollPrice();
			if (stollPrice != null) {
				pm.setStollPrice(stollPrice);
			}
			listOfPM.remove(i);
			listOfPM.add(i, pm);
		}
		return listOfPM;
	}

	public void setProductModelService(
			final ProductModelService productModelService) {
		this.productModelService = productModelService;
	}

	@Override
	@SkipValidation
	@Action(value = "productModel", results = { @Result(name = "success", type = "tiles", location = "/productModel.tiles") })
	public String execute() {
		// m.clear();
		listOfColorPercent = new LinkedList<Integer>();
		listOfColorPercent.add(100);
		if (subMaterial == null) {
			m.put("subMaterial", "00");
		}
		m.put("imList", imageList);
		m.put("fileList", fileList);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "product-model-color", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/ajax-product-model-color.jsp") })
	public String productModelColor() throws Exception {
		if (listOfColorPercent == null) {
			listOfColorPercent = new LinkedList<Integer>();
			listOfColorPercent.add(100);
		} else
			listOfColorPercent.add(0);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "product-model-minus", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/ajax-product-model-color.jsp") })
	public String productModelMinus() throws Exception {
		if (listOfColorPercent.size() > 1)
			listOfColorPercent.remove(listOfColorPercent.size() - 1);
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "generate", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-productTypeNumber.jsp") })
	public String generateAction() {
		productModelCode.setCategory(subCategory);
		productModelCode.setGauge(subGauge);
		productModelCode.setMaterial(materialService.get(
				Long.parseLong(subMaterial)).getPrefix());
		productModelCode.setProductType(productTypeService.get(
				Long.parseLong(subProductTypeString)).getPrefix());
		if (!subModelId.equals("")
				&& subCategory.equals(subModelId.substring(2, 3))
				&& subGauge.equals(subModelId.substring(4, 6))
				// && subMaterial.equals(subModelId.substring(0, 2))
				&& productModelCode.getMaterial().equals(
						subModelId.substring(0, 2))
				&& productModelCode.getProductType().equals(
						subModelId.substring(7, 9))) {
			setSubNumber(subModelId.substring(10));
		} else {
			setSubNumber(productModelCodeService.getNumber(productModelCode));
		}
		setSubNumber(productModelCodeService.getNumber(productModelCode));
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "productModel-change", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/productModel-changeA.jsp") })
	public String change() {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "backProductModel", results = { @Result(name = "success", type = "tiles", location = "/productModel.tiles") })
	public String back() {
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@SkipValidation
	@Action(value = "turshilt", results = { @Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/productModel-changeA.jsp") })
	public String turshilt() throws IOException {

		String filePath = Messages.getString("picturePath") + "\\temp"; //"E:/SimpleServiceManagement/pictures"
		for (int i = 0; files.size() > i; i++) {
			File fileToCreate = new File(filePath, imFileName.get(i));
			FileUtils.copyFile(files.get(i), fileToCreate);
			fileList = (List<File>) m.get("fileList");
			fileList.add(fileToCreate);
			Image im = new Image();
			im.setName(imFileName.get(i));
			im.setContentType(imContentType.get(i));
			if (i == 0) {
				im.setIsMain(true);
			} else {
				im.setIsMain(false);
			}
			imageList = (List<Image>) m.get("imList");
			imageList.add(im);
		}
		m.put("imList", imageList);
		m.put("fileList", fileList);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "saveChange", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/productModel-error-2.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-productmodel/productModel-error-2.jsp") })
	public String saveChange() throws IOException {
		if (productModel != null && productModelHash != productModel.hashCode()) {

			listOfStep = (List<ProductionStep>) m.get("listofs");
			Boolean cheak = true;
			for (int i = 0; i < listOfPrice.size(); i++) {
				if (listOfPrice.get(i) == null) {
					addFieldError("listOfPrice[" + i + "]",
							Messages.getString("stepPriceinputPriceEmpty"));
					cheak = false;
				}
			}
			if (cheak) {
				productModel.setListOfStepPrice(productModelService
						.getListOfStepPrice(listOfStep, listOfPrice,
								stepPriceService));

				ProductModel pm = (ProductModel) m.get("product");
				fileList = (List<File>) m.get("fileList");
				String filePathd = servletRequest.getSession()
						.getServletContext().getRealPath("/")
						+ "\\uploads";
				String filePath = Messages.getString("picturePath");
				for (int i = 0; pm.getImageList().size() > i; i++) {
					long id = 0l;
					List<Image> list = productModelService.getCurrentSession()
							.getNamedQuery("productModel.getLastImageId")
							.list();
					if (list.size() <= 0)
						id = 1l;
					else
						id = list.get(0).getId() + 1l;
					String ext = "";
					if (pm.getImageList().get(i).getContentType()
							.equalsIgnoreCase("image/jpeg"))
						ext = ".jpg";
					else if (pm.getImageList().get(i).getContentType()
							.equalsIgnoreCase("image/png"))
						ext = ".png";
					else if (pm.getImageList().get(i).getContentType()
							.equalsIgnoreCase("image/gif"))
						ext = ".gif";
					else if (pm.getImageList().get(i).getContentType()
							.equalsIgnoreCase("image/bmp"))
						ext = ".bmp";
					else {
						addFieldError("im", Messages.getString("extensionErr"));
						return INPUT;
					}
					String name = id + ext;
					pm.getImageList().get(i).setName(name);
					File fileToCreate = new File(filePath, name);
					FileUtils.copyFile(fileList.get(i), fileToCreate);
					File fileToCreated = new File(filePathd, name);
					FileUtils.copyFile(fileList.get(i), fileToCreated);
					FileUtils.deleteQuietly(fileList.get(i));
					imageService.saveOrUpdate(pm.getImageList().get(i));
				}

				productModel.setImageList(pm.getImageList());
				productModel.setListOfColours(productModelService
						.intListToObjList(
								(List<Integer>) m.get("listOfColors"),
								coloursPercentService));
				productModelService.saveOrUpdate(productModel);
				productModelService.log(productModel, "saveOrUpdate");
				productModelService.setSpProductModel();
				m.remove("subCategory");
				m.remove("subGauge");
				m.remove("subProductType");
				m.remove("listofs");
				m.remove("product");
				m.remove("subMaterial");
				m.remove("fileList");
				m.remove("listOfColors");
				m.remove("stollPrice");
				// m.clear();
				m.put("save", "true");
				m.put("savedObject", productModel);
				servletRequest.setAttribute("successUser", "true");
				return SUCCESS;
			} else {
				return INPUT;
			}
		}
		return INPUT;
	}

	@Action(value = "productModels", results = { @Result(name = "success", type = "tiles", location = "/productModel-list.tiles", params = {
			"model.id", "${id}" }) })
	public String list() {
		@SuppressWarnings("deprecation")
		String filePathd = servletRequest.getRealPath("/") + "\\uploads";
		final ImageFilter imageFilter = new ImageFilter();
		final File checkDir = new File(filePathd);
		int i = 0;
		for (final File dirFile : checkDir.listFiles()) {
			if (imageFilter.accept(dirFile)) {
				i++;
			}
		}
		if (i <= 1) {
			String filePath = Messages.getString("picturePath");
			final File dir = new File(filePath);
			for (final File imgFile : dir.listFiles()) {
				if (imageFilter.accept(imgFile)) {
					File fileToCreate = new File(filePathd, imgFile.getName());
					try {
						FileUtils.copyFile(imgFile, fileToCreate);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		listOfPM = productModelService.findAllSort();
		return SUCCESS;
	}

	@Action(value = "savePmPrice", results = {
			@Result(name = "success", type = "redirectAction", location = "productModels"),
			@Result(name = "input", type = "tiles", location = "/productModel-editPrice.tiles") })
	public String savePrice() {
		if (productModel != null && productModelHash != productModel.hashCode()) {
			int j = 0;
			for (int i = 0; i < listOfPrice.size(); i++) {
				if (listOfPrice.get(i) == null) {
					addFieldError("listOfPrice[" + i + "]",
							Messages.getString("stepPriceinputPriceEmpty"));
					j = 1;
				}
			}
			if (j == 0) {
				if (!productModelService.isModel(productModel.getModelId())
						|| productModelService
								.isProductModelActive(productModel.getId())) {
					productModelService.setPmEdit(
							ProductModelActivity.inActive, productModel);
					productModel.setStatus(ProductModelActivity.active);
					productModel.setListOfStepPrice(productModelService
							.getListOfStep(
									stepPriceService
											.getListOfProductStep(productModel
													.getId()), listOfPrice,
									stepPriceService));
					ProductModel pm = new ProductModel();
					pm = productModelService.get(productModel.getId());
					productModel.setImageList(productModelService
							.getListOfImage(pm.getImageList(), imageService));
					productModelService.save(productModel);
					productModelService.log(productModel, "save");
					productModelService.setSpProductModel();
					m.remove("ListOfStepPrice");
					return SUCCESS;
				}
				addFieldError("label", Messages.getString("statusError"));
			}
		}
		m.put("listOfStepPrice", productModel.getListOfStepPrice());
		return INPUT;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "editProductModel", results = {
			@Result(name = "success", type = "redirectAction", location = "productModels"),
			@Result(name = "input", type = "tiles", location = "/productModel-edit.tiles") })
	public String edit() {
		if (productModel != null && productModelHash != productModel.hashCode()) {
			if (productModel.getStatus().equals(ProductModelActivity.inActive)
					|| productModelService.check(productModel.getId(),
							productModel.getModelId())) {
				productModelCodeService.deleteCurrentModelCode(productModel
						.getModelId());
				productModel.getModelId();
				productModelCode.setCategory(subCategory);
				productModelCode.setGauge(subGauge);
				productModelCode.setMaterial(materialService.get(
						Long.parseLong(subMaterial)).getPrefix());
				productModelCode.setProductType(productTypeService.get(
						Long.parseLong(subProductTypeString)).getPrefix());
				productModelCode.setNumber(subNumber);
				Integer num = 0;
				for (Integer i : listOfColorPercent)
					num += i;
				if (num != 100) {
					addFieldError("listColor", Messages.getString("percent"));
					return INPUT;
				}

				if (subNumber.equals("")) {
					productModelCodeService
							.saveProductModelCode(productModelCode);
					productModel.setModelId(productModelCodeService
							.getLastAddModelCode());
				} else {
					if (!productModelCodeService.checkCode(productModelCode)) {
						addFieldError("subMaterial",
								Messages.getString("modelIdConj"));
						return INPUT;
					}
					productModelCodeService.saveOrUpdate(productModelCode);
					productModel.setModelId(productModelCodeService
							.getLastAddModelCode());
				}
				productModel.setListOfColours(productModelService
						.intListToObjList(listOfColorPercent,
								coloursPercentService));
				productModelService
						.updateStepPrice(productModel.getId(),
								(int) (stollPriceService.getRealPrice()
										.getCostPrice() * productModel
										.getStoll()));
				productModel.setListOfStepPrice(productModelService
						.getCurrentSession()
						.getNamedQuery("ProductModel.stepPrices")
						.setLong("id", productModel.getId()).list());
				productModel.setImageList(productModelService
						.getCurrentSession()
						.getNamedQuery("ProductModel.getImages")
						.setLong("id", productModel.getId()).list());
				productModelService.update(productModel);
				coloursPercentService.deleteUnusedColoursPercent();
				// productModelService.setPmEdit(productModel.getStatus(),
				// productModel);
				// productModelService.saveOrUpdate(productModel);
				return SUCCESS;
			}
			addFieldError("status", Messages.getString("statusError"));
		}
		subCategory = productModel.getModelId().substring(2, 3);
		subMaterial = materialService.getId(
				productModel.getModelId().substring(0, 2)).toString();
		subProductType = productTypeService.getProductType(productModel
				.getModelId().substring(7, 9));
		subProductTypeString = productTypeService
				.getProductType(productModel.getModelId().substring(7, 9))
				.getId().toString();
		subGauge = productModel.getModelId().substring(4, 6);
		subNumber = productModel.getModelId().substring(10);
		listOfColorPercent = new LinkedList<Integer>();
		for (ColoursPercent cp : productModel.getListOfColours()) {
			listOfColorPercent.add(cp.getPercent());
		}
		m.put("checkVal", productModelService.checkProductModel(productModel
				.getId().toString()));
		return INPUT;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "get-addition-images", results = { @Result(name = "success", location = "/WEB-INF/content/get-addition-images.jsp") })
	public String getAdditionImages() {
		String id = servletRequest.getParameter("id");
		List<ProductModel> pmList = productModelService.getCurrentSession()
				.getNamedQuery("productModel.getOnePM").setString("id", id)
				.list();
		List<Image> list = new ArrayList<Image>();
		for (int i = 0; pmList.size() > i; i++) {
			for (int j = 0; pmList.get(i).getImageList().size() > j; j++) {
				if (pmList.get(i).getImageList().get(j).getIsMain() == false) {
					if (j != 0)
						list.add(pmList.get(i).getImageList().get(j));
				}
			}
		}
		servletRequest.setAttribute("imList", list);
		return SUCCESS;
	}

	@Action(value = "save-productModel-ajax", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/productModel-error.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-productmodel/productModel-error.jsp") })
	public String save() throws IOException {
		// m.clear();
		if (productModel != null && productModelHash != productModel.hashCode()) {
			m.put("subCategory", subCategory);
			m.put("subGauge", subGauge);
			m.put("subProductType", subProductType);
			m.put("listofs", listOfStep);
			m.put("product", productModel);
			m.put("subMaterial", subMaterial);
			m.put("subProductTypeString", subProductTypeString);
			m.put("subNumber", subNumber);
			m.put("listOfColors", listOfColorPercent);
			Boolean check = true;
			if (subMaterial.equals("-1")) {
				addFieldError("subMaterial",
						Messages.getString("subMaterialHeader"));
				check = false;
			}
			if (subCategory.equals("-1")) {
				addFieldError("subCategory",
						Messages.getString("subCategoryHeader"));
				check = false;
			}
			if (subGauge.equals("-1")) {
				addFieldError("subGauge", Messages.getString("subGaugeHeader"));
				check = false;
			}
			if (subProductTypeString.equals("-1")
					|| subProductTypeString.length() > 3) {
				addFieldError("subProductTypeString",
						Messages.getString("subProductType_idHeader"));
				check = false;
			}
			if (productModel.getStoll() < 0) {
				addFieldError("stoll", Messages.getString("stollValidation"));
				check = false;
			}
			if (productModel.getChordPrice() < 0) {
				addFieldError("chordPrice", Messages.getString("numberInsert"));
				check = false;
			}
			if (productModel.getAidPrice() < 0) {
				addFieldError("aidPrice", Messages.getString("numberInsert"));
				check = false;
			}
			if (productModel.getUnitChordPrice() < 0) {
				addFieldError("unitChordPrice",
						Messages.getString("numberInsert"));
				check = false;
			}
			if (productModel.getSellPrice() <= 0) {
				addFieldError("sellPrice",
						Messages.getString("positivenumberInsert"));
				check = false;
			}
			Integer num = 0;
			for (Integer i : listOfColorPercent)
				num += i;
			if (num != 100) {
				addFieldError("listColor", Messages.getString("percent"));
				check = false;
			}
			if (listOfStep.size() != 0) {
				if (check) {
					productModelCode.setCategory(subCategory);
					productModelCode.setGauge(subGauge);
					productModelCode.setMaterial(materialService.get(
							Long.parseLong(subMaterial)).getPrefix());
					productModelCode.setProductType(productTypeService.get(
							Long.parseLong(subProductTypeString)).getPrefix());
					productModelCode.setNumber(subNumber);
					if (subNumber.equals("")) {
						productModelCodeService
								.saveProductModelCode(productModelCode);
						productModel.setModelId(productModelCodeService
								.getLastAddModelCode());
					} else {
						if (!productModelService.isModelAll(productModelCode
								.takeProductModelCode())) {
							if (!productModelCodeService
									.checkCode(productModelCode)) {
								productModelCodeService
										.deleteCurrentModelCode(productModelCode
												.takeProductModelCode());
							}
						}
						if (!productModelCodeService
								.checkCode(productModelCode)) {
							addFieldError("subMaterial",
									Messages.getString("modelIdConj"));
							return INPUT;
						}
						productModelCodeService.saveOrUpdate(productModelCode);
						productModel.setModelId(productModelCodeService
								.getLastAddModelCode());
					}
					productModel.setListOfColours(productModelService
							.intListToObjList(listOfColorPercent,
									coloursPercentService));
					coloursPercentService.deleteUnusedColoursPercent();
					List<File> fileList = new ArrayList<File>();
					String filePath = Messages.getString("picturePath")
							+ "\\temp";
					for (int i = 0; files.size() > i; i++) {
						File fileToCreate = new File(filePath,
								imFileName.get(i));
						FileUtils.copyFile(files.get(i), fileToCreate);
						fileList.add(fileToCreate);
						Image im = new Image();
						im.setName(imFileName.get(i));
						im.setContentType(imContentType.get(i));
						if (i == 0) {
							im.setIsMain(true);
						} else {
							im.setIsMain(false);
						}
						imageList.add(im);
					}
					productModel.setImageList(imageList);
					// imageList = (List<Image>) m.get("imList");
					// productModel.setImageList(imageList);

					for (int i = 0; i < listOfStep.size() / 2; i++) {
						String s = psService.getPsName(listOfStep.get(i)
								.getId());
						if (s != null) {
							listOfStep.get(i).setName(s);
						}
					}
					m.put("fileList", fileList);
					if (stollPriceService.getRealPrice() != null) {
						Integer stoll = (int) (stollPriceService.getRealPrice()
								.getCostPrice() * productModel.getStoll());
						m.put("stoll", stoll);
						m.put("stollPrice", stollPriceService.getRealPrice());
					}
					servletRequest.setAttribute("successUser", "true");
					return SUCCESS;
				}
			} else {
				addFieldError("listOfStep.id",
						Messages.getString("productionstepSelectionEmpty"));
				return INPUT;
			}
		}
		return INPUT;
	}

	@Action(value = "deleteProductModel", results = { @Result(name = "success", type = "redirectAction", location = "productModels") })
	public String delete() throws Exception {
		productModelCodeService.deleteCurrentModelCode(productModel
				.getModelId());
		productModelService.delete(productModel);
		return SUCCESS;
	}

	@Action(value = "save-pm-images", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/ajax-image-list-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-productmodel/ajax-image-input-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax-productmodel/ajax-error-response.jsp") })
	public String saveImagesAction() throws IOException {
		try {
			if (productModel.getId() == null || productModel.getId() == 0l) {
				addFieldError("id", Messages.getString("emptyError"));
				return INPUT;
			}

			if (files.size() <= 0) {
				addFieldError("im", Messages.getString("emptyError"));
				return INPUT;
			}

			ProductModel pm = new ProductModel();
			pm = productModelService.get(productModel.getId());
			if (pm == null) {
				addFieldError("id", Messages.getString("wrongIdError"));
				return INPUT;
			}
			String filePathd = servletRequest.getSession().getServletContext()
					.getRealPath("/")
					+ "\\uploads";
			String filePath = Messages.getString("picturePath");
			for (int i = 0; i < files.size(); i++) {
				if (files.get(i).length() > 5500000) {
					addFieldError("im", Messages.getString("maxSizeLimitError"));
					return INPUT;
				}

				String ext = "";
				switch (imContentType.get(i)) {
				case "image/jpeg":
					ext = ".jpg";
					break;
				case "image/png":
					ext = ".png";
					break;
				case "image/gif":
					ext = ".gif";
					break;
				case "image/bmp":
					ext = ".bmp";
					break;
				default:
					addFieldError("im", Messages.getString("extensionError"));
					return INPUT;
				}

				Image image = new Image();
				long id = 0l;
				@SuppressWarnings("unchecked")
				List<Image> list = productModelService.getCurrentSession()
						.getNamedQuery("productModel.getLastImageId").list();
				if (list.size() <= 0)
					id = 1l;
				else
					id = list.get(0).getId() + 1l;

				String name = id + ext;
				image.setName(name);
				image.setContentType(imContentType.get(i));
				image.setIsMain(false);
				File fileToCreate = new File(filePath, name);
				FileUtils.copyFile(files.get(i), fileToCreate);
				File fileToCreated = new File(filePathd, name);
				FileUtils.copyFile(files.get(i), fileToCreated);
				imageService.saveOrUpdate(image);
				pm.getImageList().add(image);
			}
			productModelService.saveOrUpdate(pm);
			servletRequest.setAttribute("imageList", pm.getImageList());
			return SUCCESS;
		} catch (Exception e) {
			addFieldError("exception", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}

	@Action(value = "set-main-image-pm", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/ajax-image-list-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-productmodel/ajax-image-input-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax-productmodel/ajax-error-response.jsp") })
	public String setMainImageAction() {
		try {
			if (productModel.getId() == null || productModel.getId() == 0l) {
				addFieldError("id", Messages.getString("emptyError"));
				return INPUT;
			}

			String imageId = (String) servletRequest.getParameter("imageId");
			if (imageId == null || imageId.trim().equals("")) {
				addFieldError("imageId", Messages.getString("emptyError"));
				return INPUT;
			}

			ProductModel pm = new ProductModel();
			pm = productModelService.get(productModel.getId());
			if (pm == null) {
				addFieldError("id", Messages.getString("wrongIdError"));
				return INPUT;
			}

			Long imageIdLong = 0l;
			try {
				imageIdLong = Long.parseLong(imageId);
			} catch (NumberFormatException e) {
				addFieldError("imageId", Messages.getString("numberIdError"));
				return INPUT;
			}

			Image image = new Image();
			image = imageService.get(imageIdLong);
			if (image == null) {
				addFieldError("imageId", Messages.getString("wrongIdError"));
				return INPUT;
			}

			for (int i = 0; i < pm.getImageList().size(); i++) {
				if (pm.getImageList().get(i).getIsMain()) {
					pm.getImageList().get(i).setIsMain(false);
				}
			}
			for (int i = 0; i < pm.getImageList().size(); i++) {
				if (pm.getImageList().get(i).getId() == image.getId()) {
					pm.getImageList().get(i).setIsMain(true);
				}
			}
			productModelService.saveOrUpdate(pm);
			servletRequest.setAttribute("imageList", pm.getImageList());
			return SUCCESS;
		} catch (Exception e) {
			addFieldError("exception", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}

	@Action(value = "delete-pm-images", results = {
			@Result(name = "success", location = "/WEB-INF/content/ajax-productmodel/ajax-image-list-response.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/ajax-productmodel/ajax-image-input-error-response.jsp"),
			@Result(name = "error", location = "/WEB-INF/content/ajax-productmodel/ajax-error-response.jsp") })
	public String deleteImagesAction() {
		try {
			if (productModel.getId() == null || productModel.getId() == 0l) {
				addFieldError("id", Messages.getString("emptyError"));
				return INPUT;
			}

			String[] imageIds = servletRequest.getParameterValues("imageIds[]");
			if (imageIds == null || imageIds.length <= 0) {
				addFieldError("imageIds", Messages.getString("emptyError"));
				return INPUT;
			}

			ProductModel pm = new ProductModel();
			pm = productModelService.get(productModel.getId());
			if (pm == null) {
				addFieldError("id", Messages.getString("wrongIdError"));
				return INPUT;
			}
			String filePathd = servletRequest.getSession().getServletContext()
					.getRealPath("/")
					+ "\\uploads";
			String filePath = Messages.getString("picturePath");
			for (int j = 0; j < imageIds.length; j++) {
				Long imageId = 0l;
				try {
					imageId = Long.parseLong(imageIds[j]);
				} catch (NumberFormatException e) {
					addFieldError("imageIds",
							Messages.getString("numberIdError"));
					return INPUT;
				}

				Image image = new Image();
				image = imageService.get(imageId);
				if (image == null) {
					addFieldError("imageIds",
							Messages.getString("wrongIdError"));
					return INPUT;
				}

				for (int i = 0; i < pm.getImageList().size(); i++) {
					if (pm.getImageList().get(i).getId() == image.getId()) {
						pm.getImageList().remove(i);
						productModelService.saveOrUpdate(pm);
						imageService.delete(image);
						FileUtils.deleteQuietly(new File(filePath + "\\"
								+ image.getName()));
						FileUtils.deleteQuietly(new File(filePathd + "\\"
								+ image.getName()));
					}
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			addFieldError("exception", Messages.getString("somethingWrong"));
			return ERROR;
		}
	}

	public void setPsService(final ProductionStepService psService) {
		this.psService = psService;
	}

	public List<ProductionStep> getProductStepList() {
		return psService.findAll();
	}

	public ProductType getSubProductType() {
		return subProductType;
	}

	public void setSubProductType(ProductType subProductType) {
		this.subProductType = subProductType;
	}

	public void prepare() throws Exception {
		if (productModel != null && productModel.getId() != null) {
			this.productModel = productModelService.get(productModel.getId());
			this.productModelHash = productModel.hashCode();
		}
	}

	public List<ProductionStep> getListOfStep() {
		return listOfStep;
	}

	public void setListOfStep(List<ProductionStep> listOfStep) {
		this.listOfStep = listOfStep;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSubMaterial() {
		return subMaterial;
	}

	public void setSubMaterial(String subMaterial) {
		this.subMaterial = subMaterial;
	}

	public String getSubGauge() {
		return subGauge;
	}

	public void setSubGauge(String subGauge) {
		this.subGauge = subGauge;
	}

	public String getSubModelId() {
		return subModelId;
	}

	public void setSubModelId(String subModelId) {
		this.subModelId = subModelId;
	}

	public ProductModelActivity[] getProductModelActivity() {
		return ProductModelActivity.valuesActive();
	}

	public void setSession(Map<String, Object> session) {
		this.m = session;
	}

	public Map<String, Object> getSession() {
		return m;
	}

	public List<Integer> getListOfPrice() {
		return listOfPrice;
	}

	public void setListOfPrice(List<Integer> listOfPrice) {
		this.listOfPrice = listOfPrice;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public HttpServletRequest getServletRequest(
			HttpServletRequest servletRequest) {
		return servletRequest;
	}

	public List<File> getIm() {
		return files;
	}

	public void setIm(List<File> im) {
		this.files = im;
	}

	public List<String> getImContentType() {
		return imContentType;
	}

	public void setImContentType(List<String> imContentType) {
		this.imContentType = imContentType;
	}

	public List<String> getImFileName() {
		return imFileName;
	}

	public void setImFileName(List<String> imFileName) {
		this.imFileName = imFileName;
	}

	public String getSubNumber() {
		return subNumber;
	}

	public void setSubNumber(String subNumber) {
		this.subNumber = subNumber;
	}

	public String getSubProductTypeString() {
		return subProductTypeString;
	}

	public void setSubProductTypeString(String subProductTypeString) {
		this.subProductTypeString = subProductTypeString;
	}

	public List<Material> getMaterials() {
		return materialService.findAll();
	}

	public List<Integer> getListOfColorPercent() {
		return listOfColorPercent;
	}

	public void setListOfColorPercent(List<Integer> listOfColorPercent) {
		this.listOfColorPercent = listOfColorPercent;
	}
}
