package mn.infosystems.enquire.service;

import mn.infosystems.enquire.model.EnquireModel;

public class EnquireModelService extends GenericEntityService<EnquireModel, Long>{

	@Override
	protected Class<EnquireModel> entityClass() {
		return EnquireModel.class;
	}
	

}
