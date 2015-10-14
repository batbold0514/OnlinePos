package mn.chinbat.surgery.service;

import mn.chinbat.surgery.model.Diagnosis;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.Payment;
import mn.chinbat.surgery.model.ServicePrice;
import mn.chinbat.surgery.model.Users;

import org.apache.log4j.Logger;

public class SsmLoggerService {

	private static final Logger LOG = Logger.getLogger(SsmLoggerService.class);
	private static final String sep = " | ";

	public void logInfo(ServicePrice sps) {
		LOG.info(" SERVICE PRICE :" + sep + sps.getCode() + sep + sps.getName()
				+ sep + sps.getPrice() + sps.getDescription());
	}

	public void logInfo(Diagnosis diagnosis) {
		LOG.info(" DIAGNOSIS :" + sep + diagnosis.getCode() + sep
				+ diagnosis.getName());
	}

	public void logInfo(Doctor doctor) {
		if (doctor.getDoctorUser() == null) {
			LOG.info(" DOCTOR :" + sep + doctor.getFamilyName() + sep
					+ doctor.getName() + sep + doctor.getRegistrationNumber()
					+ sep + doctor.getMobile1() + sep + doctor.getMobile2()
					+ sep + doctor.getPhoneNumber() + doctor.getStatus());
		} else
			LOG.info(" DOCTOR :" + sep + doctor.getFamilyName() + sep
					+ doctor.getName() + sep + doctor.getRegistrationNumber()
					+ sep + doctor.getMobile1() + sep + doctor.getMobile2()
					+ sep + doctor.getPhoneNumber() + doctor.getStatus()
					+ doctor.getDoctorUser().getUserName());
	}

	public void logInfo(DoctorSession ds, String servicePrice,
			String diagnoses, String doctor) {
		LOG.info(" DOCTOR SERVICE : " + sep + ds.getDate() + sep + "Doctor : "
				+ doctor + sep + "Patient : " + ds.getPatient().getFirstName()
				+ sep + "sercie : " + servicePrice + sep + "Diagonses : "
				+ diagnoses);
	}

	public void logInfo(Patient patient) {
		LOG.info(" PATIENT : " + sep + patient.getFirstName() + sep
				+ patient.getLastName() + sep + patient.getCardNumber() + sep
				+ patient.getRegNumber() + sep + patient.getMobil_1() + "."
				+ patient.getMobil_2() + "." + patient.getPhone() + sep
				+ patient.getSex());
	}

	public void logInfo(Payment payment) {
		LOG.info(" PAYMENT : " + sep + payment.getDate() + sep
				+ payment.getPaymentNumber() + sep
				+ payment.getPatient().getCardNumber() + "."
				+ payment.getPatient().getFirstName() + sep
				+ payment.getValue() + sep + payment.getUser());
	}

	public void logInfo(Users user) {
		LOG.info(" USER : " + sep + user.getUserName() + sep
				+ user.getRole().get(0).toString());
	}
}
