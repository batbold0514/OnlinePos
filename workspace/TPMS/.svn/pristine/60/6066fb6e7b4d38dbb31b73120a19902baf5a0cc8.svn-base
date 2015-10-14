package mn.threesor.tims.service;

import mn.threesor.tims.model.Colour;

public class ColourService extends GenericEntityService<Colour, Long> implements
		TpmsLogger {

	@Override
	protected Class<Colour> entityClass() {
		return Colour.class;
	}

	public void log(Object obj, String message) {
		Colour colour = (Colour) obj;
		LOG.info("COLOR : " + message + " code:" + colour.getCode() + sep
				+ "name: " + colour.getName());
	}

	public boolean hasConjuction(Colour col) {
		if (col.getId() == null) {
			return getCurrentSession().getNamedQuery("colour.check1")
					.setString("code", col.getCode()).list().isEmpty() ? false
					: true;
		}
		return getCurrentSession().getNamedQuery("colour.check")
				.setLong("id", col.getId()).setString("code", col.getCode())
				.list().isEmpty() ? false : true;
	}

}
