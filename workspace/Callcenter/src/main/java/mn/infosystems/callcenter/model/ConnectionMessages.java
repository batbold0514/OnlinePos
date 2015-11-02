package mn.infosystems.callcenter.model;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConnectionMessages {
private static final String BUNDLE_NAME = "locale.message.connections";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	
	private ConnectionMessages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	public static String getString(String key , String property) {
		try {
			ResourceBundle RESOURCE_BUNDLE1 = ResourceBundle
					.getBundle(property);
			return RESOURCE_BUNDLE1.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}