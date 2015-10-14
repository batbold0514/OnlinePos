package mn.chinbat.surgery.service;

import mn.chinbat.surgery.model.Diagnosis;

public class DiagnosisService extends GenericEntityService<Diagnosis, Long> {

	@Override
	protected Class<Diagnosis> entityClass() {
		return Diagnosis.class;
	}

	public boolean check(String code, Long id) {
		if (id == null) {
			return getCurrentSession().getNamedQuery("Diagnosis.checkNonId")
					.setString("code", code).list().isEmpty() ? false : true;
		}
		return getCurrentSession().getNamedQuery("Diagnosis.checkId")
				.setString("code", code).setLong("id", id).list().isEmpty() ? false
				: true;
	}

}
