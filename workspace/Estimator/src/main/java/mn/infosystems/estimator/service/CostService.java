package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.Cost;

public class CostService extends GenericEntityService<Cost, Long>{

	@Override
	protected Class<Cost> entityClass() {
		return Cost.class;
	}

}
