package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.Trole;

public class TroleService extends GenericEntityService<Trole, String> {

	@Override
	protected Class<Trole> entityClass() {
		return Trole.class;
	}

}
