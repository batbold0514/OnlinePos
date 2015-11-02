package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.LogoutTime;

public class LogoutTimeService extends GenericEntityService<LogoutTime, Long>{

	@Override
	protected Class<LogoutTime> entityClass() {
		return LogoutTime.class;
	}

}
