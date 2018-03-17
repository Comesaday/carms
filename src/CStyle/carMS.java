package CStyle;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;

import CSMainFrame.carMain;
import CSMainFrame.loginFrame;

public class carMS {
	boolean packFrame=false;
	public carMS() {
	loginFrame frame=new loginFrame();
	//carMain frame=new carMain();
	if(packFrame) {
		frame.pack();
	}
	else {
		frame.validate();
	}
	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize=frame.getSize();
	if(frameSize.height>screenSize.height) {
		frameSize.height=screenSize.height;
	}
	if(frameSize.width>screenSize.width) {
		frameSize.height=screenSize.height;
	}
	frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
	frame.setVisible(true);
}
    public static void main(String[] args) {  
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
    	new carMS();
    }
}

