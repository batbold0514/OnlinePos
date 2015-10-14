package mn.threesor.tims.service;

import java.util.LinkedList;
import java.util.List;

import mn.threesor.tims.enums.ProductModelActivity;
import mn.threesor.tims.model.ColoursPercent;
import mn.threesor.tims.model.Image;
import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.model.StepPrice;
import mn.threesor.tims.model.StollPrice;

public class ProductModelService extends
		GenericEntityService<ProductModel, Long> implements TpmsLogger {

	@Override
	protected Class<ProductModel> entityClass() {
		return ProductModel.class;
	}

	public List<StepPrice> getListOfStepPrice(
			List<ProductionStep> listOfProductionStep, List<Integer> listOfInt,
			StepPriceService spService) {
		List<StepPrice> list = new LinkedList<StepPrice>();
		for (int i = 0; i < listOfProductionStep.size() / 2; i++) {
			list.add(new StepPrice(listOfProductionStep.get(i), null, listOfInt
					.get(i)));
			spService.saveOrUpdate(list.get(i));
		}
		return list;
	}

	public List<StepPrice> getListOfStep(
			List<ProductionStep> listOfProductionStep, List<Integer> listOfInt,
			StepPriceService spService) {
		List<StepPrice> list = new LinkedList<StepPrice>();
		for (int i = 0; i < listOfProductionStep.size(); i++) {
			list.add(new StepPrice(listOfProductionStep.get(i), null, listOfInt
					.get(i)));
			spService.saveOrUpdate(list.get(i));
		}
		return list;
	}

	public List<Image> getListOfImage(List<Image> list,
			ImageService imageService) {
		List<Image> listOfImage = new LinkedList<Image>();
		for (int i = 0; i < list.size(); i++) {
			listOfImage.add(new Image(list.get(i)));
			imageService.save(listOfImage.get(i));
		}
		return listOfImage;
	}

	public void setSpProductModel() {
		getCurrentSession().getNamedQuery("productModel.setProductModel")
				.executeUpdate();
	}

	public void setPmEdit(ProductModelActivity status, ProductModel productModel) {
		getCurrentSession().getNamedQuery("updateStatusDesc")
				.setLong("status", status.getId())
				.setString("description", productModel.getDescription())
				.setLong("id", productModel.getId())
				.setInteger("chordPrice", productModel.getChordPrice())
				.setInteger("unitChordPrice", productModel.getUnitChordPrice())
				.setInteger("aidPrice", productModel.getAidPrice())
				.setInteger("sellPrice", productModel.getSellPrice())
				.setFloat("stoll", productModel.getStoll())
				.setString("modelId", productModel.getModelId())
				.setInteger("percent", productModel.getPercent())
				.setString("ynumber", productModel.getYarnNumber())
				.executeUpdate();
	}

	public boolean isModel(String model) {
		int count = getCurrentSession()
				.getNamedQuery("productModel.getOnePMupModel")
				.setString("model", model).list().size();
		if (count != 0)
			return true;
		return false;
	}
	public boolean isModelAll(String model) {
		int count = getCurrentSession()
				.getNamedQuery("productModel.getModelId")
				.setString("model", model).list().size();
		if (count != 0)
			return true;
		return false;
	}

	public boolean isProductModelActive(Long id) {
		ProductModel pm = (ProductModel) getCurrentSession()
				.getNamedQuery("productModel.getOnePM").setLong("id", id)
				.list().get(0);
		if (pm.getStatus().equals(ProductModelActivity.active))
			return true;
		return false;
	}

	public StollPrice getRealStollPrice() {
		if (getCurrentSession().getNamedQuery("StollPrice.getRealStollPrice")
				.list().size() > 0) {
			return (StollPrice) getCurrentSession()
					.getNamedQuery("StollPrice.getRealStollPrice").list()
					.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProductModel> getProductModelActiveList() {
		return getCurrentSession().getNamedQuery("productModel.getActiveList")
				.list();
	}

	public boolean descriptionNotEquals(Long id, String desc) {
		ProductModel pm = (ProductModel) getCurrentSession()
				.getNamedQuery("productModel.getOnePM").setLong("id", id)
				.list().get(0);
		if (pm.getDescription().equals(desc))
			return false;
		return true;
	}

	public boolean check(Long id, String modelId) {
		return getCurrentSession().getNamedQuery("productmodel.check")
				.setString("model", modelId).setLong("id", id).list().isEmpty() ? true
				: false;
	}

	public void log(Object obj, String message) {
		ProductModel model = (ProductModel) obj;
		LOG.info("ProductModel " + message + " : modelID: "
				+ model.getModelId() + sep + " stoll : " + model.getStoll()
				+ sep + "total cost: " + model.getTotalCostPrice());
	}

	@SuppressWarnings("unchecked")
	public void updateStepPrice(Long id, int price) {
		List<StepPrice> list = getCurrentSession()
				.getNamedQuery("ProductModel.stepPrices").setLong("id", id)
				.list();
		for (StepPrice sp : list) {
			if (sp.getProductStep().getId() == 1000l) {
				getCurrentSession().getNamedQuery("stepPrice.updatePrice")
						.setLong("id", sp.getId()).setInteger("price", price)
						.executeUpdate();
			}
		}
	}

	public boolean checkProductModel(String id) {
		return getCurrentSession()
				.getNamedQuery("TrackingSheet.getProductModel")
				.setString("id", id).list().isEmpty() ? true : false;
	}

	public List<ColoursPercent> intListToObjList(
			List<Integer> listOfColorPercent,
			ColoursPercentService coloursPercentService) {
		List<ColoursPercent> list = new LinkedList<ColoursPercent>();
		for(Integer i:listOfColorPercent){
			ColoursPercent cp = new ColoursPercent();
			cp.setPercent(i);
			list.add(coloursPercentService.saveOrUpdate(cp));
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductModel> findAllSort(){
		return getCurrentSession().getNamedQuery("productModel.findAll").list();
	}
}
