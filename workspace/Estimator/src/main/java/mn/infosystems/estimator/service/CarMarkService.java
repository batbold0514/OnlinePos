package mn.infosystems.estimator.service;

import java.util.List;

import mn.infosystems.estimator.model.CarMark;

public class CarMarkService extends GenericEntityService<CarMark, Long> {

	@Override
	protected Class<CarMark> entityClass() {
		return CarMark.class;
	}

	@SuppressWarnings("unchecked")
	public List<CarMark> getMarkForFactory(String factId) {
		if (factId == null || factId.trim().equals("")) {
			return findAll();
		}else{
			return getCurrentSession().getNamedQuery("Mark.getByFactory").setLong("factId", Long.parseLong(factId)).list();
		}
	}

}
