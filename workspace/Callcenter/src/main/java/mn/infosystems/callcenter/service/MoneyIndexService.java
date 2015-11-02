package mn.infosystems.callcenter.service;

import java.util.List;

import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.MoneyIndex;

public class MoneyIndexService extends GenericEntityService<MoneyIndex, Long> {

	@Override
	protected Class<MoneyIndex> entityClass() {
		return MoneyIndex.class;
	}

	/**
	 * @param min
	 * @param id
	 * @return boolean value
	 * @see Тухайн дүнгийн индекс өөр завсарт байгаа эсэхийг шалгах
	 */
	public boolean checkInterval(int min, Long id) {
		if (id == null)
			id = -1l;
		return getCurrentSession().getNamedQuery("moneyIndex.checkBalance")
				.setInteger("balance", min).setLong("id", id).list().isEmpty() ? false
				: true;
	}

	@SuppressWarnings("finally")
	public boolean updateStatus(Long status) {
		try {
			getCurrentSession().getNamedQuery("moneyIndex.upadateStatus")
					.setLong("status", status).executeUpdate();
		} catch (Exception e) {
			return false;
		} finally {
			return true;
		}
	}

	public String getStatus() {
		List<MoneyIndex> list = this.findAll();
		if (list.isEmpty())
			return "true";
		if (list.get(0).getStatus().equals(StatusEnum.active))
			return "true";
		else
			return "false";
	}

}
