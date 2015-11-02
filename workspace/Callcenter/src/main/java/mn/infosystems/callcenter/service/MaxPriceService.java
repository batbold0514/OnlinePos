package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.MaxPrice;

public class MaxPriceService extends GenericEntityService<MaxPrice, Long>{

	@Override
	protected Class<MaxPrice> entityClass() {
		return MaxPrice.class;
	}

}
