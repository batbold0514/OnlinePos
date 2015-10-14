/*package mn.threesor.tims.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsTestCase;

import mn.threesor.tims.AbstractModelServiceSpringContextTest;
import mn.threesor.tims.action.ProductionStepAction;

import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

public class ProductionStepActionTest extends StrutsTestCase {
	public void testGetActionMapping() {

		ActionMapping mapping = getActionMapping("/admin/productionStepAction.action");
		assertNotNull(mapping);
		assertEquals("/admin", mapping.getNamespace());
		assertEquals("productionStepAction", mapping.getName());
	}
	
	 * public void testGetActionProxy() throws Exception { // set parameters
	 * before calling getActionProxy request.addParameter("name", "FD");
	 * 
	 * ActionProxy proxy = getActionProxy("/admin/productionStepAction.action");
	 * 
	 * assertNotNull(proxy);
	 * 
	 * ProductionStepAction action = (ProductionStepAction) proxy.getAction();
	 * assertNotNull(action);
	 * 
	 * String result = proxy.execute(); assertEquals(Action.SUCCESS, result);
	 * assertEquals("FD", action.getProductionStep().getName()); }
	 * 
	 * public void testExecuteAction() throws ServletException,
	 * UnsupportedEncodingException { String output =
	 * executeAction("/test/testAction.action"); assertEquals("Hello", output);
	 * }
	 * 
	 * public void testGetValueFromStack() throws ServletException,
	 * UnsupportedEncodingException { request.addParameter("name", "FD");
	 * executeAction("/test/testAction.action"); String name = (String)
	 * findValueAfterExecute("name"); assertEquals("FD", name); }
	 
}
*/