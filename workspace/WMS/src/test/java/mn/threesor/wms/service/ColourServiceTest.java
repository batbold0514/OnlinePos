package mn.threesor.wms.service;

import mn.threesor.wms.AbstractModelServiceSpringContextTest;
import mn.threesor.wms.model.Colour;

public class ColourServiceTest extends AbstractModelServiceSpringContextTest {
	ColourService colourService;

	@Override
	public void onSetUp() throws Exception {
		super.onSetUp();
		this.colourService = (ColourService) getApplicationContext().getBean(
				"colourService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(colourService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();
		try {
			Colour colour = new Colour();
			colour.setId(1l);
			colour.setCode("123123");
			colour.setName("RED");
			Long id = colourService.save(colour);
			colour = colourService.get(id);
			assertNotNull(colour.getId());
			assertEquals("123123", colour.getCode());
			assertEquals("RED", colour.getName());
		} finally {
			rollback();
		}
	}
}
