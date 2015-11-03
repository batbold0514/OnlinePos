package mn.infosystems.mobile.service;

import mn.infosystems.mobile.model.Image;


public class ImageService extends GenericEntityService<Image, Long> {
	@Override
	protected Class<Image> entityClass() {
		return Image.class;
	}
}
