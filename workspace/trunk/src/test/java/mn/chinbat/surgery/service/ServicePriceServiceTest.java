package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.model.ServicePrice;

public class ServicePriceServiceTest extends
		AbstractModelServiceSpringContextTest {
	ServicePriceService servicePriceService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.servicePriceService = (ServicePriceService) getApplicationContext().getBean("servicePriceService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(servicePriceService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();
		try {
			Long id = servicePriceService.save(new ServicePrice("1001",
					"bulga", "blabla", 2000, "active"));
			ServicePrice ser = servicePriceService.get(id);
			assertNotNull(ser);
			assertEquals("1001", ser.getCode());
			assertEquals("bulga", ser.getName());
			assertEquals("blabla", ser.getDescription());
			assertEquals(2000, ser.getPrice());
			assertEquals("active", ser.getActive());
		}
		finally {
			rollback();
		}
	}
	
	public void testSaveWithSameCode() {
		startTransaction();
		try{
			Long id1 = servicePriceService.save(new ServicePrice("1001",
					"bulga", "blabla", 2000, "active"));
			Long id2 = servicePriceService.save(new ServicePrice("1001",
					"bulga", "blabla", 3000, "active"));
			assertNotSame(id1, id2);
		} finally {
			rollback();
		}
	}

}
