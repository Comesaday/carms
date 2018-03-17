package CSFrames;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import CSBean.userBean;

public class addUser extends JInternalFrame implements ActionListener   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	userBean bean=new userBean();
	String grade=null;
	String sex=null;
	String[] level= {"A1","A2","A3","B1","B2","C1","C2","C3","C4","D","E","F","M","N","P"};
	JPanel upPanel,centerPanel,downPanel,sexPanel;
	JLabel bg,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12;
	JTextField text1,text3,text5,text6,text7,text8,text9,text10,text11,text12;
	JButton button1,button2,button3;
	JRadioButton jrbutton1,jrbutton2;
	JComboBox jcbox;
	ButtonGroup group;
	public addUser() {
		super("添加驾驶员",true,true,true);
		setBounds(140,60,460,360);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //设置提供最大化按钮
		setClosable(true);  //提供关闭按钮
		setResizable(false);
		
		upPanel=new JPanel();
		upPanel.setPreferredSize(new Dimension(500,80));
		upPanel.setBorder(new EmptyBorder(0,0,0,0));
		bg=new JLabel();
		bg.setBounds(0,0,0,0);
		bg.setIcon(null);
		Image image=Toolkit.getDefaultToolkit().getImage("res/login.jpg");
		Icon icon=new ImageIcon(image);
		bg.setIcon(icon);
		upPanel.add(bg);
		add(upPanel,BorderLayout.NORTH);
		
		centerPanel=new JPanel();
		centerPanel.setBorder(new EmptyBorder(5, 25, 15, 25));
		centerPanel.setPreferredSize(new Dimension(450,200));
		GridLayout g1=new GridLayout(0,4);
		g1.setHgap(15);
		g1.setVgap(10);
		centerPanel.setLayout(g1);
		label1=new JLabel();
		label1.setText("姓    名：");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label1);
		text1=new JTextField(15);
		centerPanel.add(text1);
		
		label2=new JLabel();
		label2.setText("性    别：");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label2);
		sexPanel=new JPanel();
		jrbutton1=new JRadioButton();
		jrbutton1.setText("男");
		jrbutton2=new JRadioButton();
		jrbutton2.setText("女");
		group=new ButtonGroup();
		jrbutton1.addActionListener(this);
		jrbutton2.addActionListener(this);
		group.add(jrbutton1);
		group.add(jrbutton2);
		sexPanel.add(jrbutton1);
		sexPanel.add(jrbutton2);
		centerPanel.add(sexPanel);
		
		label3=new JLabel();
		label3.setText("身份证号：");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label3);
		text3=new JTextField(15);
		centerPanel.add(text3);
		label4=new JLabel();
		label4.setText("驾证等级：");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label4);
		jcbox=new JComboBox(level);
		jcbox.addActionListener(this);
		centerPanel.add(jcbox);
		
		label5=new JLabel();
		label5.setText("编    号：");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label5);
		text5=new JTextField(15);
		String pid= String.valueOf(bean.selPID()+1);
		text5.setText(pid);
		text5.setEnabled(false);
		centerPanel.add(text5);
		label6=new JLabel();
		label6.setText("联系电话：");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label6);
		text6=new JTextField(15);
		centerPanel.add(text6);
		
		label7=new JLabel();
		label7.setText("联系地址：");
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label7);
		text7=new JTextField(15);
		centerPanel.add(text7);
		label8=new JLabel();
		label8.setText("身    高：");
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label8);
		text8=new JTextField(15);
		centerPanel.add(text8);
		
		label9=new JLabel();
		label9.setText("体    重：");
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label9);
		text9=new JTextField(15);
		centerPanel.add(text9);
		label10=new JLabel();
		label10.setText("视    力：");
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label10);
		text10=new JTextField(15);
		centerPanel.add(text10);
		
		label11=new JLabel();
		label11.setText("取得时间：");
		label11.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label11);
		text11=new JTextField(15);
		centerPanel.add(text11);
		label12=new JLabel();
		label12.setText("年检时间：");
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(label12);
		text12=new JTextField(15);
		centerPanel.add(text12);
	    add(centerPanel,BorderLayout.CENTER);
		
		downPanel=new JPanel();
		downPanel.setPreferredSize(new Dimension(500,40));
		downPanel.setBorder(new LineBorder(SystemColor.RED,1,false));
		FlowLayout f1=new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);
		downPanel.setLayout(f1);
		button1=new JButton();
		button1.setText("添加");
		button2=new JButton();
		button2.setText("清空");
		button3=new JButton();
		button3.setText("退出");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		downPanel.add(button1);
		downPanel.add(button2);
		downPanel.add(button3);
		add(downPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jrbutton1) {
			sex="男";
		}
		else if(e.getSource()==jrbutton2) {
			sex="女";
		}
		else if(e.getSource()==jcbox) {
			grade=String.valueOf(jcbox.getSelectedItem());
		}
		else if(e.getSource()==button1) {
			int pid=Integer.parseInt(text5.getText());
			bean.addUser(text1.getText(),sex,text3.getText(),grade,pid,text6.getText(),text7.getText(),text8.getText(),text9.getText(),text10.getText(),text11.getText(),text12.getText());
			String id= String.valueOf(bean.selPID()+1);
			text5.setText(id);
			setNull();
		}
		else if(e.getSource()==button2) {
			setNull();
		}
		else if(e.getSource()==button3) {
			this.dispose();
		}
	}
	public void setNull() {
		text1.setText(null);
		text3.setText(null);
		text6.setText(null);
		text7.setText(null);
		text8.setText(null);
		text9.setText(null);
		text10.setText(null);
		text11.setText(null);
		text12.setText(null);
	}

}
