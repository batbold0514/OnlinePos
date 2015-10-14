package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.Defect;

public class DefectService extends GenericEntityService<Defect, Long>{

	@Override
	protected Class<Defect> entityClass() {
		return Defect.class;
	}

}
