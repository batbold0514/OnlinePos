package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.CarFactory;
import mn.infosystems.estimator.model.CarMark;
import mn.infosystems.estimator.model.Employee;
import mn.infosystems.estimator.model.InfoBoard;
import mn.infosystems.estimator.model.Users;

import org.apache.log4j.Logger;

public class EstimateLoggerService {

	private static final Logger LOG = Logger
			.getLogger(EstimateLoggerService.class);
	private static final String sep = " | ";

	public static void writeLog(Users user) {
		LOG.info(" Хэрэглэгч : " + sep + user.getUserName() + sep
				+ user.getRole().get(0).toString());
	}

	public static void writeLog(CarFactory factory) {
		LOG.info(" Машины үйлдвэр : " + sep + factory.getFactoryName());
	}

	public static void writeLog(CarMark mark) {
		LOG.info(" Машины марк : " + sep + mark.getFactory().getFactoryName()
				+ sep + mark.getMark());
	}

	public static void writeLog(InfoBoard board) {
		LOG.info(" Мэдээллийн самбар : " + sep + board.getDate() + sep
				+ board.getUser().getUserName() + sep + board.getInfo());
	}

	public static void writeLog(Employee emp) {
		LOG.info(" Ажилчин : " + sep + emp.getLastName() + sep
				+ emp.getFirstName() + sep + emp.getPhoneNumber() + sep
				+ emp.getRegNumber() + sep + emp.getStatus().getStatus());
	}
}
