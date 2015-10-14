package mn.threesor.tims.service;

import java.util.List;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.StepPrice;

public class ProductModelServiceTest extends
		AbstractModelServiceSpringContextTest {
	ProductModelService productModelService;
	StepPriceService stepPriceService;

	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.productModelService = (ProductModelService) getApplicationContext()
				.getBean("productModelService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(productModelService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();

		try {
//			List<StepPrice> listOfStepPrice = null;
			List<StepPrice> listOfStepPrice = null;
			ProductModel productModel1 = new ProductModel(3l, "ModelId", (float) 1, listOfStepPrice);
			productModel1.setPercent(50);
			Long id = productModelService.save(productModel1);
			ProductModel productModel = productModelService.get(id);
			assertNotNull(productModel);
			assertEquals(id, productModel.getId());
			assertEquals("ModelId", productModel.getModelId());
			//assertEquals(1, productModel.getStoll());
//			assertEquals(listOfStepPrice, productModel.getLisOfStepPrice());
			assertEquals(listOfStepPrice, productModel.getListOfStepPrice());
			assertEquals(50, productModel.getPercent());
		} finally {
			rollback();
		}
	}
}