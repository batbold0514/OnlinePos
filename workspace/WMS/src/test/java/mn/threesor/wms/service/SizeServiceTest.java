package mn.threesor.wms.service;

import mn.threesor.wms.AbstractModelServiceSpringContextTest;
import mn.threesor.wms.model.Size;

public class SizeServiceTest extends AbstractModelServiceSpringContextTest{
	SizeService sizeService;
	
	@Override
	public void onSetUp() throws Exception{
		super.onSetUp();
		this.sizeService = (SizeService) getApplicationContext().getBean("sizeService");
	}
	
	public void testServiceAvailable() throws Exception{
		assertNotNull(sizeService);
	}
	
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
			Size size = new Size();
			size.setSizes("XXXL");
			Long id = sizeService.save(size);
			size = sizeService.get(id);
			assertNotNull(size.getId());
			assertEquals("XXXL", size.getSizes());
		}finally{
			rollback();
		}
	}
}
