package mysourcee;

/*
    This file is part of Peers, a java SIP softphone.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
    Copyright 2010-2013 Yohann Martineau 
*/


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.SwingUtilities;

import net.sourceforge.peers.Config;
import net.sourceforge.peers.Logger;
import net.sourceforge.peers.gui.Registration;
import net.sourceforge.peers.media.AbstractSoundManager;
import net.sourceforge.peers.media.MediaManager;
import net.sourceforge.peers.sip.RFC3261;
import net.sourceforge.peers.sip.Utils;
import net.sourceforge.peers.sip.core.useragent.SipListener;
import net.sourceforge.peers.sip.core.useragent.UserAgent;
import net.sourceforge.peers.sip.syntaxencoding.SipHeaderFieldName;
import net.sourceforge.peers.sip.syntaxencoding.SipHeaderFieldValue;
import net.sourceforge.peers.sip.syntaxencoding.SipHeaders;
import net.sourceforge.peers.sip.syntaxencoding.SipUriSyntaxException;
import net.sourceforge.peers.sip.transactionuser.Dialog;
import net.sourceforge.peers.sip.transactionuser.DialogManager;
import net.sourceforge.peers.sip.transport.SipRequest;
import net.sourceforge.peers.sip.transport.SipResponse;
//import javax.swing.JOptionPane;

public class MyListener implements SipListener,
         ActionListener {

    public static final String PEERS_URL = "http://peers.sourceforge.net/";
    public static final String PEERS_USER_MANUAL = PEERS_URL + "user_manual";

    public static final String ACTION_EXIT          = "Exit";
    public static final String ACTION_ACCOUNT       = "Account";
    public static final String ACTION_PREFERENCES   = "Preferences";
    public static final String ACTION_ABOUT         = "About";
    public static final String ACTION_DOCUMENTATION = "Documentation";

    private UserAgent userAgent;
  //  private MainFrame mainFrame;
  //  private AccountFrame accountFrame;
    private Registration registration;
    private Account account;
    private boolean closed;
    private Logger logger;
    private SipRequest sipRequest;
    private SipResponse sipResponce;
	private Connection connection; 
	private MyRecord record ;
	
    public MyListener(String peersHome,
            Logger logger, AbstractSoundManager soundManager) {
    //    this.mainFrame = mainFrame;
        this.logger = logger;
      //  callFrames = Collections.synchronizedMap(
       //         new HashMap<String, CallFrame>());
        closed = false;
        registration = new Registration(null, logger);
        // create sip stack
        try {
            userAgent = new UserAgent(this, peersHome, logger, soundManager);
        } catch (SocketException e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    /*JOptionPane.showMessageDialog(null, "Peers sip port " +
                    		"unavailable, about to leave", "Error",
                            JOptionPane.ERROR_MESSAGE);*/
                    System.exit(1);
                }
            });
        }
      //  account = new Account("192.168.1.105","104","1234",userAgent,logger);
      //  account.register();
      //  callClicked("sip:107");
        connectionDb();
    }

    public void accountRegister(String accountLine){
    	 account = new Account("192.168.1.105",accountLine,"1234",userAgent,logger,registration);
         account.register();
    }
    
    // sip events

    // never update gui from a non-swing thread, thus using
    // SwingUtilties.invokeLater for each event coming from sip stack.
    @Override
    public void registering(final SipRequest sipRequest) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
            //    if (accountFrame != null) {
            //        accountFrame.registering(sipRequest);
            //    }
            //    mainFrame.registering(sipRequest);
            	if(account != null){
            		account.registering(sipRequest);
            	}
            }
        });

    }

    @Override
    public void registerFailed(final SipResponse sipResponse) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                //mainFrame.setLabelText("Registration failed");
                if(account != null){
            		account.registerFailed(sipResponse);
            	}
            }
        });

    }

    @Override
    public void registerSuccessful(final SipResponse sipResponse) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                if (closed) {
                    userAgent.close();
                    System.exit(0);
                    return;
                }
                if (account != null) {
                	account.registerSuccess(sipResponse);
                }
//                mainFrame.registerSuccessful(sipResponse);
            }
        });

    }

    @Override
    public void calleePickup(final SipResponse sipResponse) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
            	Statement statement = null;
				try {
					statement = connection.createStatement();
					statement.executeUpdate("update users set callstatus = 1,duration = now() where operatorline = '" +userAgent.getUserpart()+"'");
					try {
						record.startRecord();
					} catch (LineUnavailableException e) {
						statement.executeUpdate("update users set callstatus = 0 , phone = '' where operatorline = '" +userAgent.getUserpart()+"'");
						e.printStackTrace();
					}
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

    }

    @Override
    public void error(final SipResponse sipResponse) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
       //         CallFrame callFrame = getCallFrame(sipResponse);
       //         if (callFrame != null) {
       //             callFrame.error(sipResponse);
       //        }

            }
        });

    }

    @Override
    public void incomingCall(final SipRequest sipRequest,
            SipResponse provResponse) {
    	this.sipRequest = sipRequest;
    	this.sipResponce = provResponse;
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                SipHeaders sipHeaders = sipRequest.getSipHeaders();
                SipHeaderFieldName sipHeaderFieldName =
                    new SipHeaderFieldName(RFC3261.HDR_FROM);
                SipHeaderFieldValue from = sipHeaders.get(sipHeaderFieldName);
                final String fromValue = from.getValue();
                String callId = Utils.getMessageCallId(sipRequest);
                Statement statement = null;
				try {
					statement = connection.createStatement();
					statement.executeUpdate("update users set phone = '"+fromValue.substring(4,fromValue.length())+"'where status =2 and callstatus = 0 and operatorline = '" +userAgent.getUserpart()+"'");
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

    }

    @Override
    public void remoteHangup(final SipRequest sipRequest) {
    	try{	
    		record.stopRecord();
    	}catch(Exception e){
    		
    	}
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Statement statement = null;
            	try {
					statement = connection.createStatement();
					statement.executeUpdate("update users set callstatus = 0 , phone = '' where operatorline = '" +userAgent.getUserpart()+"'");
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

    }

    @Override
    public void ringing(final SipResponse sipResponse) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });

    }

    // main frame events

    public void register() {
        if (userAgent == null) {
            // if several peers instances are launched concurrently,
            // display error message and exit
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                Config config = userAgent.getConfig();
                if (config.getPassword() != null) {
                    try {
                        userAgent.register();
                    } catch (SipUriSyntaxException e) {
           //             mainFrame.setLabelText(e.getMessage());
                    }
                }
            }
        });

    }

    public void callClicked(final String uri) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                String callId = Utils.generateCallID(
                        userAgent.getConfig().getLocalInetAddress());
            //    CallFrame callFrame = new CallFrame(uri, callId,
              //          EventManager.this, logger);
            //    callFrames.put(callId, callFrame);
                try {
                    sipRequest = userAgent.invite(uri, callId);
                } catch (SipUriSyntaxException e) {
                    logger.error(e.getMessage(), e);
              //      mainFrame.setLabelText(e.getMessage());
                    return;
                }
            //    callFrame.setSipRequest(sipRequest);
             //   callFrame.callClicked();
            }
        });

    }

    
    public void windowClosed() {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    userAgent.unregister();
                } catch (Exception e) {
                    logger.error("error while unregistering", e);
                }
                closed = true;
                try {
                    Thread.sleep(3 * RFC3261.TIMER_T1);
                } catch (InterruptedException e) {
                }
                System.exit(0);
            }
        });
    }

    // call frame events
    
    public void hangupClicked(final SipRequest sipRequest) {
    	try{	
    		record.stopRecord();
    	}catch(Exception e){
    		
    	}
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                userAgent.terminate(sipRequest);
                Statement statement = null;
            	try {
					statement = connection.createStatement();
					statement.executeUpdate("update users set callstatus = 0 , phone = '' where operatorline = '" +userAgent.getUserpart()+"'");
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    public void pickupClicked(final SipRequest sipRequest) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String callId = Utils.getMessageCallId(sipRequest);
                DialogManager dialogManager = userAgent.getDialogManager();
                Dialog dialog = dialogManager.getDialog(callId);
                userAgent.acceptCall(sipRequest, dialog);
                Statement statement = null;
				try {
					statement = connection.createStatement();
					statement.executeUpdate("update users set callstatus = 1,duration = now()where operatorline = '" +userAgent.getUserpart()+"'");
					
					try {
						record.startRecord();
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
            }
        });
    }
    
    public void busyHereClicked(final SipRequest sipRequest) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                userAgent.rejectCall(sipRequest);
            }
        });

    }
    
    public void dtmf(final char digit) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MediaManager mediaManager = userAgent.getMediaManager();
                mediaManager.sendDtmf(digit);
            }
        });
    }

    
    public SipRequest getSipRequest(){
    	return sipRequest;
    }
    public SipResponse getSipResponce(){
    	return sipResponce;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        logger.debug("gui actionPerformed() " + action);
        Runnable runnable = null;
        if (ACTION_EXIT.equals(action)) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    windowClosed();
                }
            };
        } else if (ACTION_ACCOUNT.equals(action)) {
            runnable = new Runnable() {
                @Override
                public void run() {
                 /*   if (accountFrame == null ||
                            !accountFrame.isDisplayable()) {
                        accountFrame = new AccountFrame(userAgent, logger);
                        accountFrame.setVisible(true);
                    } else {
                        accountFrame.requestFocus();
                    }*/
                }
            };
        } else if (ACTION_PREFERENCES.equals(action)) {
            runnable = new Runnable() {
                @Override
                public void run() {
                   /* JOptionPane.showMessageDialog(null, "Not implemented yet");*/
                }
            };
        } else if (ACTION_ABOUT.equals(action)) {
            runnable = new Runnable() {
                @Override
                public void run() {
              /*      AboutFrame aboutFrame = new AboutFrame(
                            userAgent.getPeersHome(), logger);
                    aboutFrame.setVisible(true);*/
                }
            };
        } else if (ACTION_DOCUMENTATION.equals(action)) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        URI uri = new URI(PEERS_USER_MANUAL);
                        java.awt.Desktop.getDesktop().browse(uri);
                    } catch (URISyntaxException e) {
                        logger.error(e.getMessage(), e);
                    } catch (IOException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            };
        }
        if (runnable != null) {
            SwingUtilities.invokeLater(runnable);
        }
    }
    private boolean connectionDb(){
		String connectionString = "jdbc:postgresql://localhost:5432/callcenter?user=postgres&password=123asd90@&charSet=UTF-8";
		System.out.println(connectionString);
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(connectionString);

		} catch (Exception ex) {
			// throw new Exception(ex.toString());
			System.out.println("Error: Can't connect to database!\nMessage: "
					+ ex.toString());
			return false;
		}
		return true;
	}


    
    
    public void newRecord(){
    	record = new MyRecord("");
    }
	public void setRecordName(String name) {
		this.record.setName(name);
	}
	public void setSourceName(String sourcename){
		this.record.setSourcename(sourcename);
	}
    
}
