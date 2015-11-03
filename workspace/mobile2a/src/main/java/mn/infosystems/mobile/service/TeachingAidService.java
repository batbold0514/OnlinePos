package mn.infosystems.mobile.service;

import mn.infosystems.mobile.model.TeachingAid;

public class TeachingAidService extends GenericEntityService<TeachingAid, Long>{

	@Override
	protected Class<TeachingAid> entityClass() {
		return TeachingAid.class;
	}

}
