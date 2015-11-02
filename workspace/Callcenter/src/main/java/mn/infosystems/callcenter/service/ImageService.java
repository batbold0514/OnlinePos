package mn.infosystems.callcenter.service;

import mn.infosystems.callcenter.model.Image;


public class ImageService extends GenericEntityService<Image, Long> {
	@Override
	protected Class<Image> entityClass() {
		return Image.class;
	}
}
