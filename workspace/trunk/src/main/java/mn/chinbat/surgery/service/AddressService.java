package mn.chinbat.surgery.service;

import mn.chinbat.surgery.model.Address;

public class AddressService extends GenericEntityService<Address, Long>{

	@Override
	protected Class<Address> entityClass() {
		return Address.class;
	}
	
}
