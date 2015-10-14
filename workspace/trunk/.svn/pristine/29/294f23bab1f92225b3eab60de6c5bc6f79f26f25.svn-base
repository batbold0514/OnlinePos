package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.model.Doctor;

public class SsmLoggerServiceTest extends AbstractModelServiceSpringContextTest{
	SsmLoggerService ssmLogger;
	
	protected void onSetUp() {
		ssmLogger = new SsmLoggerService();
	}
	
	public void testServiceAvailable() throws Exception {
		assertNotNull(ssmLogger);
	}
	
	public void testSaveAndGet(){
		Doctor doctor = new Doctor();
		doctor.setFamilyName("FimalyName");
		doctor.setName("Name");
		doctor.setRegistrationNumber("RegNumber");
		ssmLogger.logInfo(doctor);
	}

}
