package mn.threesor.tims.service;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.model.StepPrice;

public class StepPriceTest extends AbstractModelServiceSpringContextTest {
	StepPriceService stepPriceService;
	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.stepPriceService= (StepPriceService) getApplicationContext().getBean(
				"stepPriceService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(stepPriceService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();

		try {
			ProductionStep productionStep = new ProductionStep();
			StepPrice sp = new StepPrice();
			sp.setPrice(3000);
			sp.setProductModel(1l);
			sp.setProductStep(productionStep);
			Long id = stepPriceService.save(sp);
			StepPrice stepPrice = stepPriceService.get(id);
			assertNotNull(stepPrice);
			assertEquals(id, stepPrice.getId());
			assertEquals(3000, stepPrice.getPrice());
			assertEquals(productionStep, stepPrice.getProductStep());
			assertEquals((Long)1l, stepPrice.getProductModel());
		} finally {
			rollback();
		}
	}
}
