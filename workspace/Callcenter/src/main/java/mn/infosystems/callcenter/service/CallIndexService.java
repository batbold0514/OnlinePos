package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.CallIndex;

public class CallIndexService extends GenericEntityService<CallIndex, Long> {

	@Override
	protected Class<CallIndex> entityClass() {
		return CallIndex.class;
	}

}
