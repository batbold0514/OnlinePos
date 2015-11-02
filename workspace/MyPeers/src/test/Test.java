package test;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.sourceforge.peers.gui.MainFrame;

public class Test {

	public static void main(final String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI(args);
	            }
	        });
	}
	
	private static void createAndShowGUI(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new MainFrame(args);
    }
	
}
