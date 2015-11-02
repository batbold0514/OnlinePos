package mn.infosystems.callcenter.service;


import mn.infosystems.callcenter.model.CallQuantity;

public class CallQuantityService extends GenericEntityService<CallQuantity, Long>{

	@Override
	protected Class<CallQuantity> entityClass() {
		return CallQuantity.class;
	}

}
