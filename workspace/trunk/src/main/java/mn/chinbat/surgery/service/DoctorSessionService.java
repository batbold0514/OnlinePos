package mn.chinbat.surgery.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import mn.chinbat.surgery.enums.Customer;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Messages;
import mn.chinbat.surgery.model.MonthBalanceModel;
import mn.chinbat.surgery.model.MonthMap;
import mn.chinbat.surgery.model.Payment;
import mn.chinbat.surgery.model.ServicePrice;

public class DoctorSessionService extends
		GenericEntityService<DoctorSession, Long> {

	@Override
	protected Class<DoctorSession> entityClass() {
		return DoctorSession.class;
	}

	@SuppressWarnings("unchecked")
	public List<DoctorSession> searchSession(Long id) {
		return getCurrentSession().getNamedQuery("DoctorSession.searchSession")
				.setLong("id", id).list();
	}

	public DoctorSession getLastAdd() {
		return (DoctorSession) getCurrentSession()
				.getNamedQuery("DoctorSession.getLastAdd").list().get(0);
	}

	@SuppressWarnings("unchecked")
	private List<DoctorSession> getByYearAndMonth(Date date1, Date date2,
			Doctor doctor) {
		try {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String s = formatter.format(date1) + " 00:00:00.000";
			String s1 = formatter.format(date2) + " 23:59:59.999";
			if (!Messages.getCustomer("customer").trim()
					.equals(Customer.degfim.toString().trim())) {
				if (doctor == null)
					return getCurrentSession()
							.getNamedQuery("Session.getByYearAndMonth")
							.setString("date1", s).setString("date2", s1)
							.list();
				else
					return getCurrentSession()
							.getNamedQuery(
									"Session.getByYearAndMonthWithDoctor")
							.setString("date1", s).setString("date2", s1)
							.setLong("id", doctor.getId()).list();
			} else {
				if (doctor == null)
					return getCurrentSession()
							.getNamedQuery("Session.getByYearAndMonthForDegfim")
							.setString("date1", s).setString("date2", s1)
							.list();
				else
					return getCurrentSession()
							.getNamedQuery(
									"Session.getByYearAndMonthWithDoctorForDegfim")
							.setString("date1", s).setString("date2", s1)
							.setLong("id", doctor.getId()).list();
			}
		} catch (Exception e) {
			List<DoctorSession> list = new LinkedList<DoctorSession>();
			return list;
		}
	}

	@SuppressWarnings("unchecked")
	private List<DoctorSession> getByYearAndMonthPaidFalse(Date date1,
			Date date2, Doctor doctor) {
		try {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String s = formatter.format(date1) + " 00:00:00.000";
			String s1 = formatter.format(date2) + " 23:59:59.999";
			if (doctor == null)
				return getCurrentSession()
						.getNamedQuery("Session.getByYearAndMonthPaidFalse")
						.setString("date1", s).setString("date2", s1).list();
			else
				return getCurrentSession()
						.getNamedQuery(
								"Session.getByYearAndMonthWithDoctorPaidFalse")
						.setString("date1", s).setString("date2", s1)
						.setLong("id", doctor.getId()).list();
		} catch (Exception e) {
			List<DoctorSession> list = new LinkedList<DoctorSession>();
			return list;
		}
	}

	@SuppressWarnings({ "unchecked" })
	private List<ServicePrice> getAllServicePrice(Date date1, Date date2,
			Doctor doctor) {
		try {
			List<ServicePrice> list = new LinkedList<ServicePrice>();
			List<ServicePrice> mainList = new LinkedList<ServicePrice>();
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String s = formatter.format(date1) + " 00:00:00.000";
			String s1 = formatter.format(date2) + " 23:59:59.999";
			if (doctor == null)
				list = getCurrentSession()
						.getNamedQuery("Session.ServicePrice")
						.setString("date1", s).setString("date2", s1).list();
			else
				list = getCurrentSession()
						.getNamedQuery("Session.ServicePriceWithDoctor")
						.setString("date1", s).setString("date2", s1)
						.setLong("id", doctor.getId()).list();
			for (ServicePrice sp : list) {
				if (!mainList.contains(sp))
					mainList.add(sp);
			}
			return mainList;
		} catch (Exception e) {
			List<ServicePrice> mainList = new LinkedList<ServicePrice>();
			return mainList;
		}
	}

	public List<MonthBalanceModel> getMonthBalance(Date date1, Date date2,
			Doctor doctor) {
		List<DoctorSession> list = getByYearAndMonth(date1, date2, doctor);
		List<MonthBalanceModel> listBalance = new LinkedList<MonthBalanceModel>();
		int orderNumber = 1;
		for (DoctorSession ds : list) {
			MonthBalanceModel balanceModel = new MonthBalanceModel();
			int index = hasDoctor(listBalance, ds);
			if (index == -1) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Long l = (Long) getCurrentSession()
						.getNamedQuery("Appointment.getDurationOdDoctor")
						.setLong("id", ds.getDoctor().getId())
						.setString("date1", formatter.format(date1))
						.setString("date2",
								formatter.format(date2) + " 23:59:59.999")
						.list().get(0);
				String duration = "";
				if (l == null)
					duration = LongToString(0l);
				else
					duration = LongToString(l);
				balanceModel.setDoctor(ds.getDoctor());
				if (Messages.getCustomer("customer").trim()
						.equals(Customer.degfim.toString().trim())) {
					Long paidValue = (Long) getCurrentSession()
							.getNamedQuery("Payment.getValueForDocrtor")
							.setLong("id", ds.getDoctor().getId())
							.setString("date1", formatter.format(date1))
							.setString("date2", formatter.format(date2)).list()
							.get(0);
					if (paidValue != null)
						balanceModel.setPaidValue(Integer.parseInt(paidValue
								.toString()));
					else
						balanceModel.setPaidValue(0);
					Long directValue = (Long) getCurrentSession()
							.getNamedQuery("Payment.getDirectValue")
							.setString("date1", formatter.format(date1))
							.setString("date2", formatter.format(date2))
							.setLong("doctorID", ds.getDoctor().getId()).list()
							.get(0);
					if (directValue != null)
						balanceModel.setDirectValue(Integer
								.parseInt(directValue.toString()));
					else
						balanceModel.setDirectValue(0);
					balanceModel.setRecoupment(balanceModel.getPaidValue()
							- balanceModel.getDirectValue());
				}
				balanceModel.setTotalPrice(ds.getSum());
				balanceModel.setNumber(1);
				balanceModel.setDuration(duration);
				List<MonthMap> map = new LinkedList<MonthMap>();
				List<ServicePrice> listAll = getAllServicePrice(date1, date2,
						doctor);
				for (ServicePrice sp : listAll) {
					map.add(new MonthMap(sp, 0));
				}
				balanceModel.setPriceMapList(map);
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setOrderNumber(orderNumber++);
				listBalance.add(balanceModel);
			} else {
				balanceModel = listBalance.get(index);
				balanceModel.setTotalPrice(balanceModel.getTotalPrice()
						+ ds.getSum());
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setNumber(balanceModel.getNumber() + 1);
				listBalance.remove(index);
				listBalance.add(index, balanceModel);
			}
		}
		return listBalance;
	}

	public List<MonthBalanceModel> getMonthBalancePaidFalse(Date date1,
			Date date2, Doctor doctor) {
		List<DoctorSession> list = getByYearAndMonthPaidFalse(date1, date2,
				doctor);
		List<MonthBalanceModel> listBalance = new LinkedList<MonthBalanceModel>();
		int orderNumber = 1;
		for (DoctorSession ds : list) {
			MonthBalanceModel balanceModel = new MonthBalanceModel();
			int index = hasDoctor(listBalance, ds);
			if (index == -1) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Long l = (Long) getCurrentSession()
						.getNamedQuery("Appointment.getDurationOdDoctor")
						.setLong("id", ds.getDoctor().getId())
						.setString("date1", formatter.format(date1))
						.setString("date2",
								formatter.format(date2) + " 23:59:59.999")
						.list().get(0);
				String duration = "";
				if (l == null)
					duration = LongToString(0l);
				else
					duration = LongToString(l);
				balanceModel.setDoctor(ds.getDoctor());
				balanceModel.setTotalPrice(ds.getSum());
				balanceModel.setNumber(1);
				balanceModel.setDuration(duration);
				List<MonthMap> map = new LinkedList<MonthMap>();
				List<ServicePrice> listAll = getAllServicePrice(date1, date2,
						doctor);
				for (ServicePrice sp : listAll) {
					map.add(new MonthMap(sp, 0));
				}
				balanceModel.setPriceMapList(map);
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setOrderNumber(orderNumber++);
				listBalance.add(balanceModel);
			} else {
				balanceModel = listBalance.get(index);
				balanceModel.setTotalPrice(balanceModel.getTotalPrice()
						+ ds.getSum());
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setNumber(balanceModel.getNumber() + 1);
				listBalance.remove(index);
				listBalance.add(index, balanceModel);
			}
		}
		return listBalance;
	}

	public List<MonthBalanceModel> getMonthBalanceWithPatient(Date date1,
			Date date2, Doctor doctor) {
		List<DoctorSession> list = getByYearAndMonth(date1, date2, doctor);
		List<MonthBalanceModel> listBalance = new LinkedList<MonthBalanceModel>();
		int orderNumber = 1;
		for (DoctorSession ds : list) {
			MonthBalanceModel balanceModel = new MonthBalanceModel();
			int index = hasDoctorAndPatient(listBalance, ds);
			if (index == -1) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Long l = (Long) getCurrentSession()
						.getNamedQuery("Appointment.getDurationOdDoctor")
						.setLong("id", ds.getDoctor().getId())
						.setString("date1", formatter.format(date1))
						.setString("date2",
								formatter.format(date2) + " 23:59:59.999")
						.list().get(0);
				String duration = "";
				if (l == null)
					duration = LongToString(0l);
				else
					duration = LongToString(l);
				balanceModel.setDoctor(ds.getDoctor());
				balanceModel.setPatient(ds.getPatient());
				balanceModel.setTotalPrice(ds.getSum());
				balanceModel.setNumber(1);
				balanceModel.setDuration(duration);
				Long paidValue = (Long) getCurrentSession()
						.getNamedQuery("Payment.getValueForDocrtorAndPatient")
						.setLong("id", ds.getDoctor().getId())
						.setLong("pId", ds.getPatient().getId())
						.setString("date1", formatter.format(date1))
						.setString("date2", formatter.format(date2)).list()
						.get(0);
				if (paidValue != null)
					balanceModel.setPaidValue(Integer.parseInt(paidValue
							.toString()));
				else
					balanceModel.setPaidValue(0);
				List<MonthMap> map = new LinkedList<MonthMap>();
				List<ServicePrice> listAll = getAllServicePrice(date1, date2,
						doctor);
				for (ServicePrice sp : listAll) {
					map.add(new MonthMap(sp, 0));
				}
				balanceModel.setPriceMapList(map);
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setOrderNumber(orderNumber++);
				listBalance.add(balanceModel);
			} else {
				balanceModel = listBalance.get(index);
				balanceModel.setTotalPrice(balanceModel.getTotalPrice()
						+ ds.getSum());
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setNumber(balanceModel.getNumber() + 1);
				listBalance.remove(index);
				listBalance.add(index, balanceModel);
			}
		}
		return listBalance;
	}

	public List<MonthBalanceModel> getMonthBalancePaidFalseWithPatient(
			Date date1, Date date2, Doctor doctor) {
		List<DoctorSession> list = getByYearAndMonthPaidFalse(date1, date2,
				doctor);
		List<MonthBalanceModel> listBalance = new LinkedList<MonthBalanceModel>();
		int orderNumber = 1;
		for (DoctorSession ds : list) {
			MonthBalanceModel balanceModel = new MonthBalanceModel();
			int index = hasDoctorAndPatient(listBalance, ds);
			if (index == -1) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Long l = (Long) getCurrentSession()
						.getNamedQuery("Appointment.getDurationOdDoctor")
						.setLong("id", ds.getDoctor().getId())
						.setString("date1", formatter.format(date1))
						.setString("date2",
								formatter.format(date2) + " 23:59:59.999")
						.list().get(0);
				String duration = "";
				if (l == null)
					duration = LongToString(0l);
				else
					duration = LongToString(l);
				balanceModel.setDoctor(ds.getDoctor());
				balanceModel.setPatient(ds.getPatient());
				balanceModel.setTotalPrice(ds.getSum());
				balanceModel.setNumber(1);
				balanceModel.setDuration(duration);
				List<MonthMap> map = new LinkedList<MonthMap>();
				List<ServicePrice> listAll = getAllServicePrice(date1, date2,
						doctor);
				for (ServicePrice sp : listAll) {
					map.add(new MonthMap(sp, 0));
				}
				balanceModel.setPriceMapList(map);
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setOrderNumber(orderNumber++);
				listBalance.add(balanceModel);
			} else {
				balanceModel = listBalance.get(index);
				balanceModel.setTotalPrice(balanceModel.getTotalPrice()
						+ ds.getSum());
				balanceModel.setPriceMapList(setMonthBalanceModel(balanceModel,
						ds));
				balanceModel.setNumber(balanceModel.getNumber() + 1);
				listBalance.remove(index);
				listBalance.add(index, balanceModel);
			}
		}
		return listBalance;
	}

	@SuppressWarnings("unchecked")
	public List<MonthBalanceModel> getListOfRecoupment(Date date1, Date date2,
			Doctor doctor) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<MonthBalanceModel> listMBM = new LinkedList<MonthBalanceModel>();
		List<Payment> listP = getCurrentSession()
				.getNamedQuery("Payment.getDirectPayments")
				.setString("date1", formatter.format(date1))
				.setString("date2", formatter.format(date2))
				.setLong("doctorID", doctor.getId()).list();
		int index = 1;
		for(Payment p:listP){
			MonthBalanceModel mbm = new MonthBalanceModel();
			mbm.setOrderNumber(index++);
			mbm.setRecoupment(p.getValue());
			mbm.setDoctor(p.getDoctor());
			mbm.setPatient(p.getPatient());
			listMBM.add(mbm);
		}
		return listMBM;
	}

	private int hasDoctor(List<MonthBalanceModel> list, DoctorSession ds) {
		int index = 0;
		for (MonthBalanceModel mbm : list) {
			if (mbm.getDoctor().getId() == ds.getDoctor().getId())
				return index;
			else
				index++;
		}
		return -1;
	}

	private int hasDoctorAndPatient(List<MonthBalanceModel> list,
			DoctorSession ds) {
		int index = 0;
		for (MonthBalanceModel mbm : list) {
			if (mbm.getDoctor().getId() == ds.getDoctor().getId()
					&& mbm.getPatient().getId() == ds.getPatient().getId())
				return index;
			else
				index++;
		}
		return -1;
	}

	private List<MonthMap> setMonthBalanceModel(MonthBalanceModel model,
			DoctorSession ds) {
		List<MonthMap> map = new LinkedList<MonthMap>();
		map = (List<MonthMap>) model.getPriceMapList();
		for (ServicePrice sp : ds.getListOfService()) {
			int val = -1;
			for (int i = 0; i != map.size(); i++) {
				if (map.get(i).getSp().equals(sp)) {
					val = i;
					break;
				}
			}
			if (val == -1) {
				map.add(new MonthMap(sp, 1));
			} else {
				map.get(val).setCount(map.get(val).getCount() + 1);
			}
		}
		return map;
	}

	public int calculateDrSessionSum(List<ServicePrice> listOfService) {
		int i = 0;
		int sum = 0;
		if (listOfService != null) {
			while (listOfService.size() != i) {
				sum += listOfService.get(i).getPrice();
				i++;

			}
		}
		return sum;
	}

	private String LongToString(Long number) {
		long s1 = number / 60;
		long s2 = number % 60;
		String s = "";
		if (s1 > 0)
			s += s1 + " " + Messages.getString("hour");
		s += " " + s2 + " " + Messages.getString("minut");
		return s;
	}

	@SuppressWarnings("unchecked")
	public Doctor getDoctorWithUser(String name) {
		List<Doctor> list = getCurrentSession()
				.getNamedQuery("Doctor.getDoctorWithUser")
				.setString("name", name).list();
		return list.isEmpty() ? null : list.get(0);
	}

	public boolean isDoctor(String name) {
		return getCurrentSession().getNamedQuery("Doctor.getDoctorWithUser")
				.setString("name", name).list().isEmpty() ? false : true;
	}
}
