package mn.infosystems.callcenter.service;

import java.util.List;

import mn.infosystems.callcenter.enums.StatusEnum;
import mn.infosystems.callcenter.model.DateIndex;

public class DateIndexService extends GenericEntityService<DateIndex, Long> {

	@Override
	protected Class<DateIndex> entityClass() {
		return DateIndex.class;
	}

	/**
	 * @param min
	 * @param id
	 * @return boolean value
	 * @see өдрийн индексийн интервалыг шалгана
	 */
	public boolean checkInterval(int min, Long id) {
		if (id == null)
			id = -1l;
		return getCurrentSession().getNamedQuery("dateIndex.checkBalance")
				.setInteger("balance", min).setLong("id", id).list().isEmpty() ? false
				: true;
	}

	@SuppressWarnings("finally")
	public boolean updateStatus(Long status) {
		try {
			getCurrentSession().getNamedQuery("dateindex.updateStatus")
					.setLong("status", status).executeUpdate();
		} catch (Exception e) {
			return false;
		} finally {
			return true;
		}
	}

	public String getStatus() {
		List<DateIndex> list = this.findAll();
		if (list.isEmpty())
			return "true";
		if (list.get(0).getStatus().equals(StatusEnum.active))
			return "true";
		else
			return "false";
	}
}
