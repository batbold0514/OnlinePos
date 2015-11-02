package mn.infosystems.callcenter.service;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import mn.infosystems.callcenter.model.Commitment;
import mn.infosystems.callcenter.model.Debt;
import mn.infosystems.callcenter.model.TaxPayerReturn;

import org.springframework.transaction.annotation.Transactional;

public class DebtService extends GenericEntityService<Debt, Long> {

	@Override
	protected Class<Debt> entityClass() {
		return Debt.class;
	}

	/**
	 * @param id
	 *            (Өр)
	 * @return Амлалтын жагсаалт
	 * @see Тухайн id-тай өрд харгалзах амлалтуудйг авна
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Commitment> getCommitments(Long id ,int callQuantity) {
		List<Commitment> list = new LinkedList<Commitment>();
		list = getCurrentSession().getNamedQuery("debt.getCommitment")
				.setLong("id", id).setInteger("callQuantity", callQuantity).list();
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getPayDate().after(list.get(j).getPayDate())) {
					Commitment com = list.get(i);
					list.remove(i);
					list.add(i, list.get(j - 1));
					list.add(j, com);
					list.remove(j + 1);
				}
			}
		}
		return list;
	}


	/**
	 * @param startDate
	 * @param endDate
	 * @param typeId
	 * @param taxPayerId
	 * @return Өрийн жагсаалт
	 * @see Тухайн огнооны завсар дахь сонгогдсон төрөлтэй сонгогдсон хүнд
	 *      харгалзах өрүүдийг буцаана
	 */
	@SuppressWarnings("unchecked")
	public List<Debt> getDebtReportList(String startDate, String endDate,
			String typeId, String taxPayerId) {
		String sd1, sd2, pd1, pd2;
		if (startDate == null || startDate.equals("")) {
			sd1 = "1900-01-01 00:00:00.000";
			sd2 = "2100-01-01 23:59:59.999";
		} else {
			String[] startDates = startDate.trim().split(" ");
			sd1 = startDates[0] + " 00:00:00.000";
			sd2 = startDates[2] + " 23:59:59.999";
		}
		if (endDate == null || endDate.equals("")) {
			pd1 = "1900-01-01 00:00:00.000";
			pd2 = "2100-01-01 23:59:59.999";
		} else {
			String[] payDates = endDate.trim().split(" ");
			pd1 = payDates[0] + " 00:00:00.000";
			pd2 = payDates[2] + " 23:59:59.999";
		}
		List<Debt> debts = getCurrentSession()
				.getNamedQuery("Debt.getDebtReport").setString("sd1", sd1)
				.setString("sd2", sd2).setString("pd1", pd1)
				.setString("pd2", pd2).setString("typeId", typeId)
				.setString("tpId", taxPayerId).list();
		return (debts.isEmpty()) ? (new LinkedList<Debt>()) : (debts);
	}

	/**
	 * @param start
	 * @param end
	 * @return Өрийн жагсаалт
	 * @see Сонгодсон огнооны завсартах буцах нөхцөлийг хангасан өрүүд
	 */
	@SuppressWarnings("unchecked")
	public List<TaxPayerReturn> getRepurnReport(String start, String end, String opId) {
		String str1 = start + " 00:00:00.000";
		String str2 = end + " 23:59:59.999";
		return getCurrentSession().getNamedQuery("debt.returnReport")
				.setString("date1", str1).setString("date2", str2).setString("opId", opId).list();
	}
}
