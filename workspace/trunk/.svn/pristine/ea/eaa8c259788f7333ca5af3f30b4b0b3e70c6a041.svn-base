package mn.chinbat.surgery.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.Patient;

public class PatientService extends GenericEntityService<Patient, Long> {
	@Override
	protected Class<Patient> entityClass() {
		return Patient.class;
	}

	@SuppressWarnings("unchecked")
	public List<Patient> search(String regNumber, String lastName,
			String firstName, String phoneNumber, String cardNumber) {
		cardNumber = generateCardNumber(cardNumber);
		if (regNumber == null || regNumber.equals(""))
			regNumber = "%";
		else
			regNumber = "%" + regNumber.trim() + "%";
		if (lastName == null || lastName.equals(""))
			lastName = "%";
		else
			lastName = "%" + lastName.trim() + "%";
		if (firstName == null || firstName.equals(""))
			firstName = "%";
		else
			firstName = "%" + firstName.trim() + "%";
		if (cardNumber == null || cardNumber.equals("000000"))
			cardNumber = "%";
		else
			cardNumber = "%" + cardNumber.trim() + "%";
		if (phoneNumber == null || phoneNumber.equals("")
				|| phoneNumber.equals("noting"))
			phoneNumber = "%";
		else
			phoneNumber = "%" + phoneNumber.trim() + "%";
		return getCurrentSession().getNamedQuery("Patient.search")
				.setString("reg", regNumber).setString("last", lastName)
				.setString("first", firstName).setString("phone", phoneNumber)
				.setString("cardNumber", cardNumber).list();
	}

	@SuppressWarnings("unchecked")
	public List<Patient> searchById(Long id) {
		return getCurrentSession().getNamedQuery("Patient.searchId")
				.setLong("id", id).list();
	}

	public int hasSize(String regNumber) {
		if (regNumber == null || regNumber.equals(""))
			regNumber = "%";
		return getCurrentSession().getNamedQuery("Patient.regNumber")
				.setString("reg", regNumber).list().size();
	}

	public Long hasId(String regNumber) {
		if (regNumber == null || regNumber.equals(""))
			regNumber = "%";
		@SuppressWarnings("unchecked")
		List<Patient> list = getCurrentSession()
				.getNamedQuery("Patient.regNumber").setString("reg", regNumber)
				.list();
		return list.get(0).getId();
	}

	@SuppressWarnings("unchecked")
	public boolean hasConjuctiopn(Long id, String reg) {
		if (reg.equals(""))
			return false;
		if (id == null) {
			if (!getCurrentSession().getNamedQuery("Patient.regNumber")
					.setString("reg", reg).list().isEmpty())
				return true;
			else
				return false;
		}
		List<Doctor> list = getCurrentSession()
				.getNamedQuery("Patient.checkReg").setString("reg", reg)
				.setLong("id", id).list();
		if (list.isEmpty())
			return false;
		else
			return true;
	}

	public int getAge(Date birthday) {
		int actually_year = new GregorianCalendar().get(Calendar.YEAR);
		GregorianCalendar birth_calendar = new GregorianCalendar();
		if (birthday != null) {
			birth_calendar.setTime(birthday);
		}
		int birth_year = birth_calendar.get(Calendar.YEAR);
		return actually_year - birth_year;
	}

	@SuppressWarnings("unchecked")
	public int hasCardNumber(String cardNumber, Long id) {
		if (!cardNumber.equals("") && !cardNumber.matches("\\d{6}"))
			return -1;
		if (cardNumber.equals(""))
			return 0;
		if (id == null) {
			List<Patient> list = getCurrentSession()
					.getNamedQuery("Patient.cardNumber")
					.setString("cardNumber", cardNumber).list();
			if (!list.isEmpty())
				return 1;
			else
				return 0;
		} else {
			return getCurrentSession().getNamedQuery("Patient.checkCardNumber")
					.setString("cardNumber", cardNumber).setLong("id", id)
					.list().isEmpty() ? 0 : 1;
		}
	}

	private String generateCardNumber(String cardNumber) {
		if(cardNumber == null) cardNumber = "";
		while(cardNumber.length()<6)
			cardNumber = "0" + cardNumber;
		return cardNumber;
	}
	
	@SuppressWarnings("unchecked")
	public String newCardNumber(){
		List<String> list = getCurrentSession().getNamedQuery("Pateint.lastCardNumber").list();
		if(list.isEmpty()) return "000001";
		String oldCardNumber = list.get(0);
		Long l = Long.parseLong(oldCardNumber) + 1;
		String newCardNumber = l.toString();
		while(newCardNumber.length()<6){
			newCardNumber = "0"+newCardNumber;
		}
		return newCardNumber;
	}

}
