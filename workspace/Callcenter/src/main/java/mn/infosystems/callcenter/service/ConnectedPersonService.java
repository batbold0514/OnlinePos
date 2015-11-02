package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.ConnectedPerson;

public class ConnectedPersonService extends GenericEntityService<ConnectedPerson, Long>{

	@Override
	protected Class<ConnectedPerson> entityClass() {
		return ConnectedPerson.class;
	}

}
