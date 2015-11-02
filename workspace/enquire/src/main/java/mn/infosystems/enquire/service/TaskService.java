package mn.infosystems.enquire.service;

import mn.infosystems.enquire.model.Task;

public class TaskService extends GenericEntityService<Task, Long>{

	@Override
	protected Class<Task> entityClass() {
		return Task.class;
	}

}
