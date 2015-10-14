package mn.threesor.tims.service;

import mn.threesor.tims.model.Bonus;

public class BonusService extends GenericEntityService<Bonus, Long> implements
		TpmsLogger {

	@Override
	protected Class<Bonus> entityClass() {
		return Bonus.class;
	}

	public void log(Object obj,String message) {
		Bonus bonus = (Bonus) obj;
		LOG.info("BONUS : "+message+" name: " + bonus.getName() + sep +"value: "+ bonus.getValue());
	}

}
