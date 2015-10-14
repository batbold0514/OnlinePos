package mn.threesor.wms.service;

import java.util.List;

import mn.threesor.wms.model.ProductionStep;

public class ProductionStepService extends
		GenericEntityService<ProductionStep, Long> {

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
	public boolean check(String name,Long id){
		if(id == null) return getCurrentSession().getNamedQuery("productionStep.check").setString("name", name).setLong("id", -1l).list().isEmpty()?false:true;
		return getCurrentSession().getNamedQuery("productionStep.check").setString("name", name).setLong("id", id).list().isEmpty()?false:true;
	}
}
