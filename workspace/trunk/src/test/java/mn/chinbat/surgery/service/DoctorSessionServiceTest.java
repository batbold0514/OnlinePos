package mn.chinbat.surgery.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.model.Doctor;
import mn.chinbat.surgery.model.DoctorSession;
import mn.chinbat.surgery.model.Patient;
import mn.chinbat.surgery.model.ServicePrice;

public class DoctorSessionServiceTest extends
		AbstractModelServiceSpringContextTest {
	DoctorSessionService doctorSessionService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.doctorSessionService = (DoctorSessionService) getApplicationContext()
				.getBean("doctorSessionService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(doctorSessionService);
	}

	public void testSaveAndGet() throws Exception {
		startTransaction();
	

		try {
			Doctor doctor = new Doctor();
			Patient patient = new Patient();
			doctor.setName("Dido");
			patient.setFirstName("Kono");
			List<ServicePrice> listOfService = new LinkedList<ServicePrice>();
			listOfService
					.add(new ServicePrice("1001", "", "", 10000, "active"));
			listOfService
					.add(new ServicePrice("1002", "", "", 15000, "active"));
			listOfService.add(new ServicePrice("1003", "", "", 5000, "active"));
			DoctorSession doctorSession = new DoctorSession();
			doctorSession.setDate(new Date());
			doctorSession.setDoctor(doctor);
			doctorSession.setPatient(patient);
			doctorSession.setListOfService(listOfService);
			doctorSession.setSum(doctorSessionService.calculateDrSessionSum(doctorSession.getListOfService()));
			doctorSession.setPaid(true);
			Long id = doctorSessionService.save(doctorSession);
			DoctorSession ser1 = doctorSessionService.get(id);
			ser1.setSum(calculateDrSessionSum(ser1.getListOfService()));
			assertNotNull(ser1);
			assertEquals("Dido", ser1.getDoctor().getName());
			assertEquals("Kono", ser1.getPatient().getFirstName());
			assertEquals(30000, ser1.getSum());
			assertEquals(true, ser1.isPaid());
		} finally {
			rollback();
		}
	}

	private int calculateDrSessionSum(List<ServicePrice> listOfService) {
		int i = 0;
		int sum = 0;
		if (listOfService != null) {
			while (listOfService.size() != i) {
				sum += listOfService.get(i).getPrice();
				i++;
			}
		}
		return sum;
	}

}
