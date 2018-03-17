package CSFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CSBean.illeBean;
import CSBean.userBean;
import CSMainFrame.carMain;

public class delUser extends JInternalFrame implements ActionListener,ListSelectionListener{
	private static final long serialVersionUID = 1L;
	private static final Frame delUser = null;
	userBean bean=new userBean();
	String[] colName= {"编号","姓名","性别","驾证等级","联系电话","联系地址"};
	String[][] colValue=null;
	ListSelectionModel listmodel=null;
	JPanel upPanel,centerPanel,downPanel,downPanel1,downPanel2;
	JLabel label1,label2,label3,label4,label5,label6,label7;
	JTextField text1,text2,text3,text4,text5,text6,text7;
	JButton button1,button2,button3;
	JRadioButton jrbutton1,jrbutton2;
	ButtonGroup group=new ButtonGroup();
	JTable table;
	JScrollPane jspane;
	public delUser() {
		super("删除驾驶员信息",true,true,true);
		setBounds(140,60,480,390);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //设置提供最大化按钮
		setClosable(true);  //提供关闭按钮
		setResizable(false);
		
		upPanel=new JPanel();
		upPanel.setPreferredSize(new Dimension(400,35));
		upPanel.setLayout(new FlowLayout());
		label1=new JLabel();
		label1.setText("删除驾驶员信息");
		upPanel.add(label1);
		add(upPanel,BorderLayout.NORTH);
		
		centerPanel=new JPanel();
		centerPanel.setPreferredSize(new Dimension(400,180));
		colValue=bean.selUser();
		table=new JTable(colValue,colName);
		table.setPreferredScrollableViewportSize(new Dimension(400,150));
		listmodel=table.getSelectionModel();
		listmodel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listmodel.addListSelectionListener(this);
		jspane=new JScrollPane(table);
		centerPanel.add(jspane);
		add(centerPanel);
		
		downPanel=new JPanel();
		downPanel.setPreferredSize(new Dimension(400,130));
		downPanel1=new JPanel(); 
		downPanel1.setPreferredSize(new Dimension(400,90));
		GridLayout g1=new GridLayout(0,4);
		g1.setHgap(15);
		g1.setVgap(10);
		downPanel1.setLayout(g1);
		
		label2=new JLabel();
		label2.setText("编    号：");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label2);
		text2=new JTextField();
		downPanel1.add(text2);
		
		label3=new JLabel();
		label3.setText("姓     名：");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label3);
		text3=new JTextField();
		downPanel1.add(text3);
		
		label4=new JLabel();
		label4.setText("性    别：");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label4);
		text4=new JTextField();
		downPanel1.add(text4);
		
		label5=new JLabel();
		label5.setText("驾证等级：");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label5);
		text5=new JTextField();
		downPanel1.add(text5);
		
		label6=new JLabel();
		label6.setText("联系电话：");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label6);
		text6=new JTextField();
		downPanel1.add(text6);
		
		label7=new JLabel();
		label7.setText("联系地址：");
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label7);
		text7=new JTextField();
		downPanel1.add(text7);
	
		downPanel.add(downPanel1);
		
		downPanel2=new JPanel();
		downPanel2.setPreferredSize(new Dimension(400,40));
		downPanel2.setBorder(new LineBorder(SystemColor.RED,1, false));
		FlowLayout f1=new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);  
		downPanel2.setLayout(f1);
		button2=new JButton();
		button2.setText("删除");
		downPanel2.add(button2);
		
		button1=new JButton();
		button1.setText("导出");
		button1.addActionListener(this);
		downPanel2.add(button1);
		
		button3=new JButton();
		button3.setText("退出");
		downPanel2.add(button3);
		button2.addActionListener(this);
		button3.addActionListener(this);
		downPanel.add(downPanel2);
		add(downPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			FileDialog fd=new FileDialog(delUser,"保存记录",FileDialog.SAVE);
			fd.setLocation(400, 250);
			fd.setVisible(true);
			String filePath = fd.getDirectory()+fd.getFile()+".xls";
			illeBean.exportToExcel(table, filePath);
		}
		else if(e.getSource()==button2) {
			 int pid=Integer.parseInt(text2.getText());
			 bean.delThisUser(pid);
			 this.dispose();
			 
			 delUser deluser=new delUser();
			 carMain.desktopPane.add(deluser);
		 }
		 else if(e.getSource()==button3) {
			 this.dispose();
		 }
		
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		int[] selectedRow=table.getSelectedRows();
		int[] selectedCol=table.getSelectedColumns();
		for(int i=0;i<selectedCol.length;i++) {
			for(int j=0;j<selectedRow.length;i++) {
				 text2.setText(colValue[selectedRow[i]][0]);
				 text2.setEnabled(false);
			     text3.setText(colValue[selectedRow[i]][1]);
			     text4.setText(colValue[selectedRow[i]][2]);
			     text5.setText(colValue[selectedRow[i]][3]);
			     text6.setText(colValue[selectedRow[i]][4]);
			     text7.setText(colValue[selectedRow[i]][5]);
			}
		}
	}
	

}
