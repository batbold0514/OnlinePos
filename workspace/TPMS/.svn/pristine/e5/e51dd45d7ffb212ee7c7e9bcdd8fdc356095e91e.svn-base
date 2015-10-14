package mn.threesor.tims.service;

import java.util.Date;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.model.Employee;
import mn.threesor.tims.model.Occupation;

public class EmployeeServiceTest extends AbstractModelServiceSpringContextTest{
       EmployeeService employeeService;
       OccupationService occupationService;

   	@Override
   	protected void onSetUp() throws Exception {
   		super.onSetUp();
   		this.employeeService = (EmployeeService) getApplicationContext().getBean(
   				"employeeService");
   		this.occupationService = (OccupationService) getApplicationContext().getBean("occupationService");
   	}

   	public void testServiceAvailable() throws Exception {
   		assertNotNull(occupationService);
   		assertNotNull(employeeService);
   	}

	@SuppressWarnings("deprecation")
	public void testSaveAndGet() throws Exception {
   		startTransaction();

   		try {
   			Occupation oc = new Occupation();
   			oc.setName("programmer");
   			Long id = occupationService.save(oc);
   			oc = occupationService.get(id);
   			assertEquals("programmer", oc.getName());
   			assertEquals(id, oc.getId());
   			
   			Employee emp = new Employee();
   			emp.setId(1l);
   			emp.setFirstName("Bat");
   			emp.setLastName("Bold");
   			emp.setPosition(oc);
   			emp.setBirthday(new Date(1985,12,12));
   			emp.setEmail("bat@bold.com");
   			emp.setPhone("99554411");
   			emp.setRegNumber("БӨ12324565");
   			emp.setCode("dd55");
   			id = employeeService.save(emp);
   			emp = employeeService.get(id);
   			assertEquals(id, emp.getId());
   			assertEquals("Bat", emp.getFirstName());
   			assertEquals("Bold", emp.getLastName());
   			assertEquals("БӨ12324565", emp.getRegNumber());
   			assertEquals("99554411", emp.getPhone());
   			assertEquals("programmer", emp.getPosition().getName());
   			assertEquals("dd55", emp.getCode());
   		} finally {
   			rollback();
   		}
   	}
}
