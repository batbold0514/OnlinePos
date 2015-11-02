package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import mysourcee.MyListener;
import mysourcee.MyRecord;
import net.sourceforge.peers.FileLogger;
import net.sourceforge.peers.Logger;
import net.sourceforge.peers.gui.EventManager;
import net.sourceforge.peers.gui.Registration;
import net.sourceforge.peers.javaxsound.JavaxSoundManager;
import net.sourceforge.peers.media.AbstractSoundManager;
import net.sourceforge.peers.sip.Utils;

public class TestExample extends JFrame{
	private Logger logger;
	
	private MyListener listener;

	private JButton callBtn;
	private JButton answerBtn;
	private JButton rejectBtn;
	private JButton registerBtn;

	public TestExample(final String[] args) {
		
		
		this.setSize(300,100);
		this.setLayout(new FlowLayout());
		callBtn = new JButton("Call");
		answerBtn = new JButton("Answer");
		rejectBtn = new JButton("Reject");
		registerBtn = new JButton("Register");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(registerBtn);
		this.add(callBtn);
		this.add(rejectBtn);
		this.add(answerBtn);
		
		registerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.accountRegister("104");
			}
		});
		
		callBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.callClicked("sip:989925402");
			}
		});
		
		rejectBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.hangupClicked(listener.getSipRequest());
			}
		});
		
		answerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.pickupClicked(listener.getSipRequest());
				
			}
			
		});
		
		String peersHome = Utils.DEFAULT_PEERS_HOME;
		if (args.length > 0) {
			peersHome = args[0];
		}
		logger = new FileLogger(peersHome);
		String lookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeelClassName);
        } catch (Exception e) {
            logger.error("cannot change look and feel", e);
        }
        final AbstractSoundManager soundManager = new JavaxSoundManager(
                false, //TODO config.isMediaDebug(),
                logger, peersHome);
        String title = "";
        if (!Utils.DEFAULT_PEERS_HOME.equals(peersHome)) {
            title = peersHome;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String peersHome = Utils.DEFAULT_PEERS_HOME;
                if (args.length > 0) {
                    peersHome = args[0];
                }
                listener = new MyListener(peersHome, logger, soundManager);
                listener.register();
            }
        }, "gui-event-manager");
        thread.start();
        try {
            while (listener  == null) {
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            return;
        }
        
        
//        register("104");
       
	}
	
	public void register(String accountLine){
		listener.accountRegister(accountLine);
	}
	
	public void call(String number,String register,String date , String sourcename){
		listener.newRecord();
		listener.setRecordName(register+date);
		listener.setSourceName(sourcename);
		listener.callClicked("sip:9"+number);
	}
	
	public void reject(){
		listener.hangupClicked(listener.getSipRequest());
	}
	
	public void answer() throws SQLException{
		listener.pickupClicked(listener.getSipRequest());
		
	}
	
	public static void main(String[] args) throws LineUnavailableException, InterruptedException {
//		new TestExample(args).setVisible(true);
		/*MyRecord myRecord = new MyRecord("8562");
		myRecord.setSourcename("C:/workspace/Callcenter");
		myRecord.startRecord();
		Thread.sleep(10000);
		myRecord.stopRecord();*/
	}
}
