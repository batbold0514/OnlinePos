package mysourcee;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import net.sourceforge.peers.Config;
import net.sourceforge.peers.Logger;
import net.sourceforge.peers.gui.Registration;
import net.sourceforge.peers.sip.RFC3261;
import net.sourceforge.peers.sip.core.useragent.UserAgent;
import net.sourceforge.peers.sip.syntaxencoding.SipURI;
import net.sourceforge.peers.sip.syntaxencoding.SipUriSyntaxException;
import net.sourceforge.peers.sip.transport.SipRequest;
import net.sourceforge.peers.sip.transport.SipResponse;

public class Account {
	private String user;
	private String domain;
	private String password;
	
	private boolean unregistering;
    private UserAgent userAgent;
    private Registration registration;
	private Logger logger;
	
	public Account(String domain,String user,String password,UserAgent agent,Logger logger , Registration registration) {
		this.domain = domain;
		this.user = user;
		this.password = password;
		this.userAgent = agent;
		this.logger = logger;
		this.registration = registration;
	}
	
	
	/**
	 * РЕГИСТЕР ХИЙЖ БАЙГАА ХЭСЭГ 99095388
	 */
	public void register(){
		Runnable runnable;
        if (userAgent.isRegistered()) {
            synchronized (this) {
                unregistering = true;
            }
            runnable = new Runnable() {
                public void run() {
                    try {
                        userAgent.unregister();
                    } catch (SipUriSyntaxException e) {
                        logger.error("syntax error", e);
                    }
                }
            };
        } else {
            runnable = new Runnable() {
                public void run() {
                    userAgent.close();
                    applyNewConfig();
                }
            };
        }
        SwingUtilities.invokeLater(runnable);
	}
	
	
	private void applyNewConfig() {
        Config config = userAgent.getConfig();
        if (user != null) {
            config.setUserPart(user);
        }
        if (domain != null) {
            config.setDomain(domain);
        }
        if (password != null) {
            config.setPassword(new String(password));
        }
        String outboundProxy = "";
        if (outboundProxy != null) {
            SipURI sipURI;
            try {
                if ("".equals(outboundProxy.trim())) {
                    config.setOutboundProxy(null);
                } else {
                    if (!outboundProxy.startsWith(RFC3261.SIP_SCHEME)) {
                        outboundProxy = RFC3261.SIP_SCHEME
                            + RFC3261.SCHEME_SEPARATOR + outboundProxy;
                    }
                    sipURI = new SipURI(outboundProxy);
                    config.setOutboundProxy(sipURI);
                }
            } catch (SipUriSyntaxException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                logger.error("sip uri syntax issue", e);
                return;
            }
        }
        config.save();
        unregistering = false;
        if (password != null) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        userAgent.register();
                    } catch (SipUriSyntaxException e) {
                        JOptionPane.showMessageDialog(null,
                                e.getMessage());
                        logger.error("sip uri syntax issue", e);
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
	
	public void registering(SipRequest sipRequest) {
        registration.registerSent();
    }
	
	 public synchronized void registerSuccess(SipResponse sipResponse) {
	        if (unregistering) {
	        	userAgent.close();
	            applyNewConfig();
	        } else {
	            registration.registerSuccessful();
	        }
	    }

	    public void registerFailed(SipResponse sipResponse) {
	        if (unregistering) {
	        	userAgent.close();
	            applyNewConfig();
	        } else {
	            registration.registerFailed();
	        }
	    }
	
	    
	
	    
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
