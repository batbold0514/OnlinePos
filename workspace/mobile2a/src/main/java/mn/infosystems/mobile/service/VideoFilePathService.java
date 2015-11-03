package mn.infosystems.mobile.service;

import mn.infosystems.mobile.model.VideoFilePath;

public class VideoFilePathService extends GenericEntityService<VideoFilePath, Long>{

	@Override
	protected Class<VideoFilePath> entityClass() {
		return VideoFilePath.class;
	}

}
