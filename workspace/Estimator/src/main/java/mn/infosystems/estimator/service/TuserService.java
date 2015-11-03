package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.Tuser;

public class TuserService extends GenericEntityService<Tuser ,String>{

	@Override
	protected Class<Tuser> entityClass() {
		return Tuser.class;
	}

}
