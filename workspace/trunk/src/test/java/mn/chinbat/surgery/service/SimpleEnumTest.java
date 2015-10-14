package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.enums.PaymentMethod;
import mn.chinbat.surgery.enums.RoleEnum;
import mn.chinbat.surgery.enums.Sex;
import mn.chinbat.surgery.enums.enumDoctors;

public class SimpleEnumTest extends AbstractModelServiceSpringContextTest{
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
			assertEquals(2,RoleEnum.values().length);
			assertEquals(2, Sex.values().length);
			assertEquals(5,PaymentMethod.values().length);
			assertEquals(5, enumDoctors.values().length);
		}
		finally{
			rollback();
		}
	}
}
