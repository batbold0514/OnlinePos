package mn.chinbat.surgery.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.SessionPayment;

public class SessionPaymentService extends
		GenericEntityService<SessionPayment, Long> {

	@Override
	protected Class<SessionPayment> entityClass() {
		return SessionPayment.class;
	}

	public SessionPayment getSpExistPatient(Long id) {
		@SuppressWarnings("unchecked")
		List<SessionPayment> list = getCurrentSession()
				.getNamedQuery("Sp.Deference").setLong("id", id).list();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<SessionPayment> getSpNonDeference(Long id) {
		return getCurrentSession().getNamedQuery("Sp.Deference")
				.setLong("id", id).list();
	}

	@SuppressWarnings("unchecked")
	public List<SessionPayment> getSpDeference(Long id) {
		return getCurrentSession().getNamedQuery("Sp.zeroDeference")
				.setLong("id", id).list();
	}

	@SuppressWarnings("unchecked")
	public List<SessionPayment> getSpDeferenceDateRange(Long id, Date date1,
			Date date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return getCurrentSession().getNamedQuery("Sp.DeferenceDate")
				.setLong("id", id)
				.setString("start", formatter.format(date1) + " 00:00:00.000")
				.setString("end", formatter.format(date2) + " 23:59:59.999")
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<SessionPayment> getDebtSessionPayment(Date date1, Date date2) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = formatter.format(date1) + " 00:00:00.000";
		String s2 = formatter.format(date2) + " 23:59:59.999";
		List<SessionPayment> list = getCurrentSession()
				.getNamedQuery("Sp.debt").setString("date1", s1)
				.setString("date2", s2).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<SessionPayment> getDonationSessionPayment(Date date1, Date date2) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = formatter.format(date1) + " 00:00:00.000";
		String s2 = formatter.format(date2) + " 23:59:59.999";
		List<SessionPayment> list = getCurrentSession()
				.getNamedQuery("Sp.donation").setString("date1", s1)
				.setString("date2", s2).list();
		return list;
	}

	public List<DoctorSession> setAllPaid(List<DoctorSession> list) {
		for (DoctorSession d : list) {
			d.setPaid(true);
		}
		return list;
	}
}
