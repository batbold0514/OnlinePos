package mn.infosystems.estimator.service;

import java.util.LinkedList;
import java.util.List;

import mn.infosystems.estimator.model.CarPrice;

public class CarPriceService extends GenericEntityService<CarPrice, Long> {

	@Override
	protected Class<CarPrice> entityClass() {
		return CarPrice.class;
	}

	@SuppressWarnings("unchecked")
	public List<CarPrice> getPriceList(String d1, String d2, String fd1,
			String fd2, String fid, String mid) {
		List<CarPrice> list = getCurrentSession()
				.getNamedQuery("CarPrice.search").setString("d1", d1+" 00:00:00.001")
				.setString("d2", d2+" 23:59:59.999").setInteger("fd1", Integer.parseInt(fd1))
				.setInteger("fd2", Integer.parseInt(fd2)).setString("fid", fid)
				.setString("mid", mid).list();
		return list == null ? new LinkedList<CarPrice>() : list;
	}

}
