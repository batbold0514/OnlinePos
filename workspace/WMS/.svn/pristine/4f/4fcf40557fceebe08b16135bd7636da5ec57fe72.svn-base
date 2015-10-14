package mn.threesor.wms.service;

import mn.threesor.wms.AbstractModelServiceSpringContextTest;
import mn.threesor.wms.model.Occupation;


public class OccupationServiceTest extends AbstractModelServiceSpringContextTest{
	OccupationService occupationService;
	

   	@Override
   	protected void onSetUp() throws Exception {
   		super.onSetUp();
   		this.occupationService = (OccupationService) getApplicationContext().getBean(
   				"occupationService");
   	}

   	public void testServiceAvailable() throws Exception {
   		assertNotNull(occupationService);
   	}
   	
   	public void testSaveAndGet() throws Exception{
   		startTransaction();
   		try{
   			Occupation oc = new Occupation();
   			oc.setName("programmer");
   			Long id = occupationService.save(oc);
   			oc = occupationService.get(id);
   			assertEquals("programmer", oc.getName());
   			assertEquals(id, oc.getId());
   		}finally{
   			rollback();
   		}
   	}
}
