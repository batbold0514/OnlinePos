package mn.infosystems.mobile.service;

import mn.infosystems.mobile.model.Users;

import org.apache.log4j.Logger;

public class MobileLoggerService {

	private static final Logger LOG = Logger
			.getLogger(MobileLoggerService.class);
	private static final String sep = " | ";

	public static void writeLog(Users user) {
		LOG.info(" Хэрэглэгч : " + sep + user.getUserName() + sep
				+ user.getRole().get(0).toString());
	}

}
