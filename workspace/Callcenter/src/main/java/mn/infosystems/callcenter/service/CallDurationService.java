package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.CallDuration;

public class CallDurationService extends GenericEntityService<CallDuration, Long>{

	@Override
	protected Class<CallDuration> entityClass() {
		return CallDuration.class;
	}

}
