package mn.threesor.tims.service;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.enums.EmployeePosition;
import mn.threesor.tims.enums.EmployeeStatus;
import mn.threesor.tims.enums.ProductModelActivity;
import mn.threesor.tims.enums.statusTrackingSheet;
import mn.threesor.tims.enums.yarnColorEnum;
import mn.threesor.tims.enums.yarnTypeEnum;

public class SimpleEnumTest extends AbstractModelServiceSpringContextTest{
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
//			assertEquals(12,EmployeePosition.values().length);
//			assertEquals(6,EmployeeStatus.values().length);
//			assertEquals(2,ProductModelActivity.values().length);
//			assertEquals(2, statusTrackingSheet.values().length);
//			assertEquals(4, yarnColorEnum.values().length);
//			assertEquals(7, yarnTypeEnum.values().length);
		}
		finally{
			rollback();
		}
	}
}
