package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.AccountNumber;

public class AccountNumberService extends GenericEntityService<AccountNumber, Long>{

	@Override
	protected Class<AccountNumber> entityClass() {
		return AccountNumber.class;
	}
	
}
