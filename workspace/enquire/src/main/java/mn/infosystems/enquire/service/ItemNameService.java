package mn.infosystems.enquire.service;

import mn.infosystems.enquire.model.ItemName;

public class ItemNameService extends GenericEntityService<ItemName, Long>{

	@Override
	protected Class<ItemName> entityClass() {
		// TODO Auto-generated method stub
		return ItemName.class;
	}

}
