package CSFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class aboutSystem extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public aboutSystem() {
		super("关于系统",true,true,true);
		setBounds(140,60,470,240);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //设置提供最大化按钮
		setClosable(true);  //提供关闭按钮
		//setResizable(false);
		JPanel panel=new JPanel();
		panel.setPreferredSize(new Dimension(300,150));
		JLabel label2=new JLabel("本系统应用于小型汽车客运站，由CHEN开发，版权所有@CHEN");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label2);
		add(panel);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
