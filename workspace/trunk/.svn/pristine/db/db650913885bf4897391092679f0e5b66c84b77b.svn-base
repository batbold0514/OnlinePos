package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.model.Patient;

public class PatientServiceTest extends AbstractModelServiceSpringContextTest {
	PatientService patientService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.patientService = (PatientService) getApplicationContext().getBean(
				"patientService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(patientService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();
		try {
			Long id = patientService.save(new Patient(10l, "1001", "bulga",
					"blabla", "haha", "99999998", "99123456", "99654321"));
			Patient ser = patientService.get(id);
			assertNotNull(ser);
			assertEquals("1001", ser.getRegNumber());
			assertEquals("bulga", ser.getFirstName());
			assertEquals("blabla", ser.getLastName());
			assertEquals("haha", ser.getSex());
			assertEquals("99999998", ser.getPhone());
			assertEquals("99123456", ser.getMobil_1());
			assertEquals("99654321", ser.getMobil_2());
		} finally {
			rollback();
		}
	}
}
