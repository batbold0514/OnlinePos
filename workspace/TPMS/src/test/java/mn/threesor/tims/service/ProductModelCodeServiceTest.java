package mn.threesor.tims.service;

//import org.hibernate.event.SaveOrUpdateEvent;

import java.util.LinkedList;
import java.util.List;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.model.ProductModelCode;

public class ProductModelCodeServiceTest extends
		AbstractModelServiceSpringContextTest {
	ProductModelCodeService productModelCodeService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.productModelCodeService = (ProductModelCodeService) getApplicationContext()
				.getBean("productModelCodeService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(productModelCodeService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();
		try {
			List<Long> list = new LinkedList<Long>();
			ProductModelCode pmc = new ProductModelCode();
			pmc.setId(1l);
			pmc.setCategory("W");
			pmc.setMaterial("N");
			pmc.setGauge("05");
			pmc.setProductType("03");
			list.add(productModelCodeService.saveProductModelCode(pmc));

			pmc = new ProductModelCode();
			pmc.setId(2l);
			pmc.setCategory("M");
			pmc.setMaterial("0");
			pmc.setGauge("12");
			pmc.setProductType("02");
			list.add(productModelCodeService.saveProductModelCode(pmc));

			pmc = new ProductModelCode();
			pmc.setId(3l);
			pmc.setCategory("W");
			pmc.setMaterial("N");
			pmc.setGauge("05");
			pmc.setProductType("03");
			list.add(productModelCodeService.saveProductModelCode(pmc));

			pmc = new ProductModelCode();
			pmc.setId(4l);
			pmc.setCategory("W");
			pmc.setMaterial("N");
			pmc.setGauge("05");
			pmc.setProductType("03");
			list.add(productModelCodeService.saveProductModelCode(pmc));

			assertEquals("NW-05-03-001",
					productModelCodeService.get(list.get(0))
							.takeProductModelCode());
			assertEquals("0M-12-02-001",
					productModelCodeService.get(list.get(1))
							.takeProductModelCode());
			assertEquals("NW-05-03-002",
					productModelCodeService.get(list.get(2))
							.takeProductModelCode());
			assertEquals("NW-05-03-003",
					productModelCodeService.get(list.get(3))
							.takeProductModelCode());
		} finally {
			rollback();
		}
	}

}