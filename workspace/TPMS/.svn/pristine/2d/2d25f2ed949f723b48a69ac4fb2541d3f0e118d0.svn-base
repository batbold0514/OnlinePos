package mn.threesor.tims.service;

import mn.threesor.tims.model.Material;

public class MaterialService extends GenericEntityService<Material, Long> implements  TpmsLogger{

	@Override
	protected Class<Material> entityClass() {
		return Material.class;
	}

	public boolean hasCunjaction(Long id, String prefix) {
		if (id == null) {
			return getCurrentSession().getNamedQuery("Material.check")
					.setString("prefix", prefix).list().isEmpty() ? false
					: true;
		} else
			return getCurrentSession().getNamedQuery("Material.checkId")
					.setLong("id", id).setString("prefix", prefix).list()
					.isEmpty() ? false : true;
	}
	
	public Long getId(String prefix){
		Material material = (Material) getCurrentSession().getNamedQuery("Material.check").setString("prefix", prefix).list().get(0);
		return material.getId();
	}

	public void log(Object obj, String message) {
		Material material = (Material) obj;
		LOG.info("Material "+message+" : prefix "+material.getPrefix()+" | description : "+material.getDescription());
	}

}
