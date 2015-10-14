package mn.threesor.tims.service;

import mn.threesor.tims.model.Image;

public class ImageService extends GenericEntityService<Image, Long> {
	@Override
	protected Class<Image> entityClass() {
		return Image.class;
	}
}
