package mn.threesor.wms.service;


import mn.threesor.wms.AbstractModelServiceSpringContextTest;
import mn.threesor.wms.model.ProductionStep;

public class ProductionStepTest extends AbstractModelServiceSpringContextTest {
	ProductionStepService psService;
	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.psService = (ProductionStepService) getApplicationContext().getBean(
				"psService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(psService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();

		try {
			Long id = psService.save(new ProductionStep(2l,"motch"));
			ProductionStep productionStep = psService.get(id);
			assertNotNull(productionStep);
			assertEquals(id, productionStep.getId());
			assertEquals("motch",productionStep.getName());
		} finally {
			rollback();
		}
	}
}
