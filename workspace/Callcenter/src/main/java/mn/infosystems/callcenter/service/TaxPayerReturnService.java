package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.TaxPayerReturn;

public class TaxPayerReturnService extends GenericEntityService<TaxPayerReturn, Long>{

	@Override
	protected Class<TaxPayerReturn> entityClass() {
		return TaxPayerReturn.class;
	}
 
}
