package mn.threesor.tims.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.enums.statusTrackingSheet;
import mn.threesor.tims.model.Customer;
import mn.threesor.tims.model.Employee;
import mn.threesor.tims.model.ProductModel;
import mn.threesor.tims.model.ProductionStep;
import mn.threesor.tims.model.StepPrice;
import mn.threesor.tims.model.TrackingSheet;
import mn.threesor.tims.model.WorkStep;

public class TrackingSheetServiceTest extends
		AbstractModelServiceSpringContextTest {
	TrackingSheetService trackingSheetService;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		this.trackingSheetService = (TrackingSheetService) getApplicationContext()
				.getBean("trackingSheetService");
	}

	public void testServiceAvailable() throws Exception {
		assertNotNull(trackingSheetService);
	}

	public void testSaveAndGet() throws Exception {
		/*startTransaction();
		ProductionStep productionStep = new ProductionStep();
		productionStep.setId(1l);
		productionStep.setName("suldee");
		StepPrice stepPrice = new StepPrice();
		stepPrice.setId(1l);
		stepPrice.setProductStep(productionStep);
		stepPrice.setPrice(1000);
		ProductModel productModel= new ProductModel();
		productModel.setId(1l);
		productModel.setModelId("oow-12-03-013");
		List<StepPrice> listsp=new LinkedList<StepPrice>();
		listsp.add(stepPrice);
		productModel.setListOfStepPrice(listsp);
		WorkStep workStep = new WorkStep();
		workStep.setId(1l);
		workStep.setDate(new Date());
		workStep.setQuantity(10);
		workStep.setStepPrice(stepPrice);
		List<WorkStep> listws=new LinkedList<WorkStep>();
		listws.add(workStep);
		TrackingSheet trackingSheet=new TrackingSheet();
		//trackingSheet.setYarnColor("nogoon");
		//trackingSheet.setYarnType("nooluur");
		trackingSheet.setKnitterQuantity(10);
		//trackingSheet.setKnitterSize("xl");
		trackingSheet.setKnitterWeight(10);
		trackingSheet.setStartDate(new Date());
		trackingSheet.setEndDate(new Date());
		trackingSheet.setStartNumber(trackingSheetService.getStartNumber(trackingSheet.getStartDate()));
		trackingSheet.setEndNumber(trackingSheetService.getEndNumber(trackingSheet.getEndDate()));
		trackingSheet.setActualWeight(15);
		trackingSheet.setProductModel(productModel);
		trackingSheet.setWorkStepList(listws);
		trackingSheet.setStatus(statusTrackingSheet.stickit);
		trackingSheet.setCustomer(new Customer());
		Employee employee=new Employee();
		employee.setId(1l);
		employee.setFirstName("amarbaysgalan");
		trackingSheet.setKnitterChecker(employee);
		trackingSheet.setActualChecker(employee);
		trackingSheet.setMainKnitter(employee);
		Long id = trackingSheetService.save(trackingSheet);
		trackingSheet=trackingSheetService.get(id);
		assertEquals("nogoon", trackingSheet.getYarnColor());
		//assertEquals("nooluur",trackingSheet.getYarnType());
		assertEquals("2", trackingSheet.getStatus());
		assertEquals("xl",trackingSheet.getKnitterSize());
		assertEquals(10,trackingSheet.getKnitterQuantity());
		assertEquals("dotood",trackingSheet.getCustomer());
		assertEquals(15,trackingSheet.getActualWeight());
		//assertEquals("amarbaysgalan",trackingSheet.getKnitter().getFirstName());
		//assertEquals("amarbaysgalan",trackingSheet.getBandEmp().getFirstName());
		//assertEquals("amarbaysgalan",trackingSheet.getQualityCheker().getFirstName());
		try {
		} finally {
			rollback();
		}*/
	}
}
