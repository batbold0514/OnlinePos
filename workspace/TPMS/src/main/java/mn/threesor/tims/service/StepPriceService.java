package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.model.StepPrice;

public class StepPriceService extends GenericEntityService<StepPrice, Long> {

	@Override
	protected Class<StepPrice> entityClass() {
		return StepPrice.class;
	}
	@SuppressWarnings("unchecked")
	public List<ProductionStep> getListOfProductStep(Long id){
		return getCurrentSession().getNamedQuery("stepPrice.getListProductStep").setLong("id", id).list();
	}
}
