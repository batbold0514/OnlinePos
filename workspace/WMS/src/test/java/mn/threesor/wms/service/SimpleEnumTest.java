package mn.threesor.wms.service;

import mn.threesor.wms.AbstractModelServiceSpringContextTest;

public class SimpleEnumTest extends AbstractModelServiceSpringContextTest{
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
//			assertEquals(6,EmployeePosition.values().length);
//			assertEquals(5,EmployeeStatus.values().length);
		}
		finally{
			rollback();
		}
	}
}
