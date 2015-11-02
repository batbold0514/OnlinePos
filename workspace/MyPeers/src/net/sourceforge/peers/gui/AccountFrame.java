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
    
    Copyright 2010 Yohann Martineau 
*/

package net.sourceforge.peers.gui;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import net.sourceforge.peers.Config;
import net.sourceforge.peers.Logger;
import net.sourceforge.peers.sip.RFC3261;
import net.sourceforge.peers.sip.core.useragent.UserAgent;
import net.sourceforge.peers.sip.syntaxencoding.SipURI;
import net.sourceforge.peers.sip.syntaxencoding.SipUriSyntaxException;
import net.sourceforge.peers.sip.transport.SipRequest;
import net.sourceforge.peers.sip.transport.SipResponse;

/**
 * AccountFrame, edited with NetBeans IDE.
 * 
 * @author yohann
 */
public class AccountFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private Logger logger;

    /** Creates new form AccountFrame */
    public AccountFrame(UserAgent userAgent, Logger logger) {
        this.userAgent = userAgent;
        this.logger = logger;
        unregistering = false;
        initComponents();
        registration = new Registration(jLabel6, logger);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account");

        Config config = userAgent.getConfig();

        String userPart = config.getUserPart();
        if (userPart != null) {
            jTextField1.setText(userPart);
        }

        String domain = config.getDomain();
        if (domain != null) {
            jTextField2.setText(domain);
        }

        String password = config.getPassword();
        if (password != null) {
            jPasswordField1.setText(password);
        }

        SipURI outboundProxy = config.getOutboundProxy();
        if (outboundProxy != null) {
            jTextField4.setText(outboundProxy.toString());
        }

        jLabel1.setText("User");

        jLabel2.setText("Domain");

        jLabel3.setText("Password");

        jLabel4.setText("Outbound Proxy");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel5.setText("Account management");

        jButton1.setText("Apply");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton2)
                    .addGap(6, 6, 6))
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel5)
                    .addGap(168, 168, 168))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jLabel6))
                    .addGap(7, 7, 7))
            );

        pack();
    }// </editor-fold>                        

    private void applyNewConfig() {
        Config config = userAgent.getConfig();
        String userpart = jTextField1.getText();
        if (userpart != null) {
            config.setUserPart(userpart);
        }
        String domain = jTextField2.getText();
        if (domain != null) {
            config.setDomain(domain);
        }
        char[] password = jPasswordField1.getPassword();
        if (password != null && password.length > 0) {
            config.setPassword(new String(password));
        }
        String outboundProxy = jTextField4.getText();
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
                JOptionPane.showMessageDialog(this, e.getMessage());
                logger.error("sip uri syntax issue", e);
                return;
            }
        }
        config.save();
        unregistering = false;
        if (password != null && password.length > 0) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        userAgent.register();
                    } catch (SipUriSyntaxException e) {
                        JOptionPane.showMessageDialog(AccountFrame.this,
                                e.getMessage());
                        logger.error("sip uri syntax issue", e);
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
    private void applyNewConfig1() {
    	Config config = userAgent.getConfig();
    		config.setUserPart("105");
    		config.setDomain("192.168.1.105");
    	String password = "1234";
    		config.setPassword(password);
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
    			JOptionPane.showMessageDialog(this, e.getMessage());
    			logger.error("sip uri syntax issue", e);
    			return;
    		}
    	}
    	config.save();
    	unregistering = false;
    	if (password != null && password.length() > 0) {
    		Runnable runnable = new Runnable() {
    			public void run() {
    				try {
    					userAgent.register();
    				} catch (SipUriSyntaxException e) {
    					JOptionPane.showMessageDialog(AccountFrame.this,
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Runnable runnable;
        if (userAgent.isRegistered()) {
            synchronized (this) {
                unregistering = true;
            }
            runnable = new Runnable() {
                @Override
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
                @Override
                public void run() {
                    userAgent.close();
                    applyNewConfig();
                }
            };
        }
        SwingUtilities.invokeLater(runnable);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration                   

    private boolean unregistering;
    private UserAgent userAgent;
    private Registration registration;

}

