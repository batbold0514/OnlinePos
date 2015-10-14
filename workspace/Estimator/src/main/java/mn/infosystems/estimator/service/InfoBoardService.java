package mn.infosystems.estimator.service;

import mn.infosystems.estimator.model.InfoBoard;

public class InfoBoardService extends GenericEntityService<InfoBoard, Long>{

	@Override
	protected Class<InfoBoard> entityClass() {
		return InfoBoard.class;
	}

}
