package mn.infosystems.mobile.service;

import mn.infosystems.mobile.model.TextUpload;


public class TextUploadService extends GenericEntityService<TextUpload, Long> {
	@Override
	protected Class<TextUpload> entityClass() {
		return TextUpload.class;
	}
}
