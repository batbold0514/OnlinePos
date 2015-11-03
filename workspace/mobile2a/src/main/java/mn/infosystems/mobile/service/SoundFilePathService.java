package mn.infosystems.mobile.service;

import mn.infosystems.mobile.model.SoundFilePath;

public class SoundFilePathService extends GenericEntityService<SoundFilePath, Long>{

	@Override
	protected Class<SoundFilePath> entityClass() {
		return SoundFilePath.class;
	}

}
