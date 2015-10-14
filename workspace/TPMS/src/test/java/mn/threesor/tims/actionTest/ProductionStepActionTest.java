/*package mn.threesor.tims.actionTest;

import org.apache.struts2.StrutsTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import mn.threesor.tims.action.ProductionStepAction;

public class ProductionStepActionTest extends StrutsTestCase {
	public void testInterceptorsBySettingDomainObjects() throws Exception {
		// ProductionStepAction action =
		// createAction(ProductionStepAction.class,
		// "/admin", "productionSteps");
		// String result = proxy.execute();
		// assertEquals(result, "success");
		
		 * ActionMapping mapping = getActionMapping("/test/testAction.action");
		 * assertNotNull(mapping); assertEquals("/test",
		 * mapping.getNamespace()); assertEquals("testAction",
		 * mapping.getName());
		 
	}

	*//**
	 * Invoke all interceptors and specify value of action class' domain objects
	 * through request parameters.
	 * 
	 * @throws Exception
	 *             Exception
	 *//*
	public void testInterceptorsBySettingRequestParameters() throws Exception {
		
		 * createAction(PersonAction.class, "/site", "deletePerson");
		 * request.addParameter("id", "123"); String result = proxy.execute();
		 * assertEquals(result, "success");
		 
	}

	*//**
	 * Skip interceptors and specify value of action class' domain objects by
	 * setting them directly.
	 * 
	 * @throws Exception
	 *             Exception
	 *//*
	public void testActionAndSkipInterceptors() throws Exception {
		
		 * PersonAction action = createAction(PersonAction.class, "/site",
		 * "deletePerson"); action.setId(123); String result =
		 * action.deletePerson(); assertEquals(result, "success");
		 
	}
}
*/