package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.Organisation;

public class OrganisationService extends GenericEntityService<Organisation, Long>{

	@Override
	protected Class<Organisation> entityClass() {
		return Organisation.class;
	}

}
