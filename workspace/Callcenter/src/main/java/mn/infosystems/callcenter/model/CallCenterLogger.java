package mn.infosystems.callcenter.model;

import org.apache.log4j.Logger;
public interface CallCenterLogger {
	Logger LOG = Logger.getLogger(CallCenterLogger.class);
	String sep = " | ";
	
	public void log(Object obj,String message);
}
