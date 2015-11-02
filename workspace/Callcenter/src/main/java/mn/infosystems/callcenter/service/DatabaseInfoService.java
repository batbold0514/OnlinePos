package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.DatabaseInfo;

public class DatabaseInfoService extends GenericEntityService<DatabaseInfo, Long>{

	@Override
	protected Class<DatabaseInfo> entityClass() {
		return DatabaseInfo.class;
	}

}
