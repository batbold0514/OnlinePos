package mn.chinbat.surgery.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.model.BestCustomerModel;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.Payment;

public class PaymentService extends GenericEntityService<Payment, Long> {

	@Override
	protected Class<Payment> entityClass() {
		return Payment.class;
	}

	public Payment getLastAdd() {
		return (Payment) getCurrentSession().getNamedQuery("Payment.getLast")
				.list().get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Payment> getPaymentDate(Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(date);
		return getCurrentSession().getNamedQuery("Payment.getDate")
				.setString("date", s).list();
	}

	public Payment getLastUpdate() {
		return (Payment) getCurrentSession()
				.getNamedQuery("Payment.getLastDate").list().get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Payment> getPaymentForDayBalance(Date date1, Date date2,
			String user, PaymentMethod method, Doctor doctor) {
		try {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String d1 = formatter.format(date1) + " 00:00:00.000";
			String d2 = formatter.format(date2) + " 23:59:59.999";
			if (user == null || user.equals(Messages.getString("User.all"))) {
				user = "%";
			}

			String paymentMethod;
			if (method == null || method.equals(PaymentMethod.ALL)) {
				paymentMethod = "%";
			} else {
				paymentMethod = method.getId().toString();
			}
			List<Payment> list = new LinkedList<Payment>();
			if (doctor == null){
				list = getCurrentSession()
						.getNamedQuery("Payment.getDayBalance")
						.setString("date1", d1).setString("date2", d2)
						.setString("user", user)
						.setString("method", paymentMethod).list();
			}else
				list = getCurrentSession()
						.getNamedQuery("Payment.getDayBalanceWithDoctor")
						.setString("date1", d1).setString("date2", d2)
						.setString("user", user)
						.setString("method", paymentMethod)
						.setString("doctorID", doctor.getId().toString())
						.list();
			return list;
		} catch (Exception e) {
			return new LinkedList<Payment>();
		}
	}

	@SuppressWarnings("unchecked")
	public String[] getUsers() {
		List<String> list = getCurrentSession().getNamedQuery(
				"Payment.getUsers").list();
		String[] ulist = new String[list.size() + 1];
		ulist[0] = Messages.getString("User.all");
		int i = 1;
		for (String s : list) {
			ulist[i++] = s.toString().trim();
		}
		return ulist;
	}
	
	@SuppressWarnings("unchecked")
	public List<BestCustomerModel> getBestCustomers(Date date1,Date date2,Integer limit){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String d1 = formatter.format(date1) + " 00:00:00.000";
		String d2 = formatter.format(date2) + " 23:59:59.999";
		List<Long> bestValues = getCurrentSession().getNamedQuery("Payment.bestValues").setMaxResults(limit).setString("date1", d1).setString("date2", d2).list();
		List<Patient> bestPatients = getCurrentSession().getNamedQuery("Payment.bestPatients").setMaxResults(limit).setString("date1", d1).setString("date2", d2).list();
		List<BestCustomerModel> bestCustomers = new LinkedList<BestCustomerModel>();
		int index = 0;
		for(Long value:bestValues){
			BestCustomerModel bestCustomer = new BestCustomerModel();
			bestCustomer.setValue(value);
			bestCustomer.setPatient(bestPatients.get(index));
			bestCustomer.setNumber(++index);
			bestCustomers.add(bestCustomer);
		}
		return bestCustomers;
	}
}
