package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.ReturnReason;

public class ReturnReasonService extends GenericEntityService<ReturnReason, Long>{

	@Override
	protected Class<ReturnReason> entityClass() {
		return ReturnReason.class;
	}

}
