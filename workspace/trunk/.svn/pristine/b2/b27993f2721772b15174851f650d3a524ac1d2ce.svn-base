package mn.chinbat.surgery.service;

import mn.chinbat.surgery.AbstractModelServiceSpringContextTest;
import mn.chinbat.surgery.model.Diagnosis;

public class DiagnosisServiceTest extends AbstractModelServiceSpringContextTest{
	DiagnosisService diagnosisService;
	
	@Override
	public void onSetUp() throws Exception{
		super.onSetUp();
		this.diagnosisService = (DiagnosisService) getApplicationContext().getBean(
				"diagnosisService");
	}
	
	public void testServiceAvailable() throws Exception {
		assertNotNull(diagnosisService);
	}
	
	public void testSaveAndGet() throws Exception{
		startTransaction();
		try{
			Diagnosis diagnosis = new Diagnosis();
			diagnosis.setName("heart disk");
			diagnosis.setCode("heart disk broken");
			Long id = diagnosisService.save(diagnosis);
			diagnosis = diagnosisService.get(id);
			assertEquals("heart disk", diagnosis.getName());
			assertEquals("heart disk broken", diagnosis.getCode());
			assertEquals(id, diagnosis.getId());
		}finally{
			rollback();
		}
	}

}
