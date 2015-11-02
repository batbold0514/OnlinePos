package mn.infosystems.callcenter.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mn.infosystems.callcenter.model.Plan;

/**
 * @author Suld
 * @see Төлөвлөгөөний сервис класс
 */
public class PlanService extends GenericEntityService<Plan, Long> {

	@Override
	protected Class<Plan> entityClass() {
		return Plan.class;
	}

	/**
	 * @param date
	 * @return Төлөвлөгөөний жасгаалт
	 * @see Тухайн зонгодсон өдөрийн төлөвлөгөөг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Plan> getPlansOfDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = formatter.format(date);
		String str1 = dateStr + " 00:00:00.000";
		String str2 = dateStr + " 23:59:59.999";
		return getCurrentSession().getNamedQuery("plan.getByDate")
				.setString("date1", str1).setString("date2", str2).list();
	}
	/**
	 * @param user
	 * @return Төлөвлөгөөний жагсаалт
	 * @see Тухайн операторын тухайн өдөр залгасан төлөвлөгөөнүүдийг буцаана 
	 */
	@SuppressWarnings("unchecked")
	public List<Plan> getCall(String user,Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = formatter.format(date);
		String str1 = dateStr + " 00:00:00.000";
		String str2 = dateStr + " 23:59:59.999";
		return getCurrentSession().getNamedQuery("plan.call")
				.setString("date1", str1).setString("date2", str2).setString("user", user).list();
	}
	/**
	 * @param str
	 * @return Төлөвлөгөөний жагсаалт
	 * @see Тухайн операторын тухайн өдөр залгаагүй төлөвлөгөөнүүдийг буцаана 
	 */
	@SuppressWarnings("unchecked")
	public List<Plan> getNotCall(String str,Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = formatter.format(date);
		String str1 = dateStr + " 00:00:00.000";
		String str2 = dateStr + " 23:59:59.999";
		return getCurrentSession().getNamedQuery("plan.notCall")
				.setString("date1", str1).setString("date2", str2).setString("user", str).list();
	}

}
