package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.model.Doctor;

public class DoctorServiceTest extends AbstractModelServiceSpringContextTest {
	DoctorService doctorService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.doctorService = (DoctorService) getApplicationContext().getBean(
				"doctorService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(doctorService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();

		try {
			Long id = doctorService.save(new Doctor("АЖ78965413", "Bat",
					"Bold", "хэвийн", "99887766", "99008855", "88997766"));
			Doctor doctor = doctorService.get(id);
			assertNotNull(doctor);
			assertEquals("АЖ78965413", doctor.getRegistrationNumber());
			assertEquals("Bat", doctor.getName());
			assertEquals("Bold", doctor.getFamilyName());
			assertEquals("хэвийн", doctor.getStatus());
			assertEquals("99887766", doctor.getPhoneNumber());
			assertEquals("99008855", doctor.getMobile1());
			assertEquals("88997766", doctor.getMobile2());
		} finally {
			rollback();
		}
	}
}
