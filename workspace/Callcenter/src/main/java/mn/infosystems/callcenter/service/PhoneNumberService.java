package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.PhoneNumber;

public class PhoneNumberService extends GenericEntityService<PhoneNumber, Long>{

	@Override
	protected Class<PhoneNumber> entityClass() {
		return PhoneNumber.class;
	}

}
