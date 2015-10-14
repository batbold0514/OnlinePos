package mn.threesor.wms.service;

import mn.threesor.wms.AbstractModelServiceSpringContextTest;
import mn.threesor.wms.model.LocationWms;


public class LocationWmsServiceTest extends AbstractModelServiceSpringContextTest{
	LocationWmsService locationWmsService;
	
	@Override
	public void onSetUp() throws Exception{
		super.onSetUp();
		this.locationWmsService = (LocationWmsService)getApplicationContext().getBean("locationWmsService");
	}
	
	public void testServiceAvailable() throws Exception{
		assertNotNull(locationWmsService);
	}
	
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
			LocationWms location = new LocationWms();
			location.setId(1l);
			location.setLocationName("aaaa");
			Long id = locationWmsService.save(location);
			location = locationWmsService.get(id);
			assertEquals("aaaa", location.getLocationName());
			assertNotNull(location.getId());
		}finally{
			rollback();
		}
	}
}
