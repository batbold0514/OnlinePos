package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.model.ProductionStep;

public class ProductionStepService extends
		GenericEntityService<ProductionStep, Long> implements TpmsLogger{

	protected Class<ProductionStep> entityClass() {
		return ProductionStep.class;
	}

	public String getPsName(Long id) {
		@SuppressWarnings("unchecked")
		List<String> list = getCurrentSession()
				.getNamedQuery("productionStep.getName").setLong("id", id)
				.list();
		if (list.size() != 0){
			return list.get(0);}else {
				return null;
			}

	}

	public void log(Object obj, String message) {
		ProductionStep ps = (ProductionStep) obj;
		LOG.info("Production step "+message+" : name: "+ps.getName());
	}
	
	public boolean hasConjuction(Long id,String name){
		if(id == null){
			return getCurrentSession().getNamedQuery("ps.getWithoutID").setString("name", name).list().isEmpty()?false:true;
		}
		return getCurrentSession().getNamedQuery("ps.getWithID").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
}
