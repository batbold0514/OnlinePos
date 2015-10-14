package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.CarFactory;

public class CarFactoryService extends GenericEntityService<CarFactory, Long>{

	@Override
	protected Class<CarFactory> entityClass() {
		return CarFactory.class;
	}

}
