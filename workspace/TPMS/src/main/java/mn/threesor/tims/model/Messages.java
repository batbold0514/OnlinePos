package mn.threesor.tims.model;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "locale.patient.messages";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);
	
	private static final String customer_prop = "locale.customer.customers";
	
	private static final ResourceBundle customer_bundle = ResourceBundle.getBundle(customer_prop);  
	
	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getCustomer(String key){
		try{
			return customer_bundle.getString(key);
		}catch(MissingResourceException e){
			return '!' + key+ '!';
		}
	}
}