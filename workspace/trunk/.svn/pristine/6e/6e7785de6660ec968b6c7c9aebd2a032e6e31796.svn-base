package mn.chinbat.surgery.service;

import java.util.List;

import mn.chinbat.surgery.model.ServicePrice;

public class ServicePriceService extends
		GenericEntityService<ServicePrice, Long> {

	@Override
	protected Class<ServicePrice> entityClass() {
		return ServicePrice.class;
	}

	@SuppressWarnings("unchecked")
	public List<ServicePrice> searchActive(String active) {
		return getCurrentSession().getNamedQuery("ServicePrice.list")
				.setString("act", active).list();
	}
	public int checkActive(String code) {
		return getCurrentSession().getNamedQuery("ServicePrice.active")
				.setString("code", code).list().size();
	}
	public boolean checkCodeAndId(String code , Long id) {
		if(id == null) id = -1l;
		@SuppressWarnings("unchecked")
		List<ServicePrice> list = getCurrentSession().getNamedQuery("ServicePrice.codeAndID")
				.setString("code", code).setLong("id", id).list();
		if(list.size() == 0){
			return true;
		} 
		return false;
	}
}
