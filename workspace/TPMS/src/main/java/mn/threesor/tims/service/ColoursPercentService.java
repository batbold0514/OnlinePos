package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.model.ColoursPercent;

public class ColoursPercentService extends
		GenericEntityService<ColoursPercent, Long> {

	@Override
	protected Class<ColoursPercent> entityClass() {
		return ColoursPercent.class;
	}

	@SuppressWarnings({ "unchecked" })
	public void deleteUnusedColoursPercent() {
		List<ColoursPercent> list1 = getCurrentSession().getNamedQuery(
				"productModel.getColors").list();
		List<ColoursPercent> list2 = findAll();
		for (ColoursPercent cp : list2) {
			if(!list1.contains(cp)) delete(cp);
		}
	}
}
