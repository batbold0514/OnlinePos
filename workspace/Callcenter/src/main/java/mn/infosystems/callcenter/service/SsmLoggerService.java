package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.Users;

import org.apache.log4j.Logger;

public class SsmLoggerService {

	private static final Logger LOG = Logger.getLogger(SsmLoggerService.class);
	private static final String sep = " | ";

	
	public void logInfo(Users user) {
		LOG.info(" USER : " + sep + user.getUserName() + sep
				+ user.getRole().get(0).toString());
	}
}
