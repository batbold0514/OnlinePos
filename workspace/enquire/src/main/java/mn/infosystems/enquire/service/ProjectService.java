package mn.infosystems.enquire.service;

import mn.infosystems.enquire.model.Project;

public class ProjectService extends GenericEntityService<Project, Long>{

	@Override
	protected Class<Project> entityClass() {
		return Project.class;
	}
	
}
