package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.Reason;

public class ReasonService extends GenericEntityService<Reason, Long>{

	@Override
	protected Class<Reason> entityClass() {
		return Reason.class;
	}
	
}
