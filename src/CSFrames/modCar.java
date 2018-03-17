package CSFrames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CSBean.carBean;
import CSBean.illeBean;
import CSMainFrame.carMain;

public class modCar extends JInternalFrame implements ActionListener,ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private static final Frame modCar = null;
	carBean bean=new carBean();
	String[] colName= {"编号","名称","登记时间","车牌号","联系方式"};
	String[][] colValue;
	int style=0;
	JPanel upPanel,centerPanel,downPanel,downPanel1,downPanel2;
	JLabel label1,label2,label3,label4,label5;
	JTextField text1,text2,text3,text4,text5;
	JButton button1,button2,button3;
	JTable table;
	JScrollPane jspane;
	ListSelectionModel listmodel=null;
	public modCar() {
		super("修改车辆信息",true,true,true);
		setBounds(140,60,480,350);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //设置提供最大化按钮
		setClosable(true);  //提供关闭按钮
		setResizable(false);
		
		upPanel=new JPanel();
		upPanel.setPreferredSize(new Dimension(400,20));
		label1=new JLabel();
		label1.setText("修改车辆信息");
		upPanel.add(label1);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		add(upPanel,BorderLayout.NORTH);
		
		centerPanel=new JPanel();
		centerPanel.setPreferredSize(new Dimension(400,180));
		colValue=bean.searchAllCar();
		table=new JTable(colValue,colName);
		table.setPreferredScrollableViewportSize(new Dimension(400,150));
		listmodel=table.getSelectionModel();
		listmodel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listmodel.addListSelectionListener(this);
		jspane=new JScrollPane(table);
		centerPanel.add(jspane);
		add(centerPanel);
		
		downPanel=new JPanel();
		downPanel.setPreferredSize(new Dimension(400,100));
		downPanel1=new JPanel();
		downPanel1.setPreferredSize(new Dimension(400,60));
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
		label3.setText("名    称：");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label3);
		text3=new JTextField();
		downPanel1.add(text3);
		label4=new JLabel();
		label4.setText("车 牌 号：");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label4);
		text4=new JTextField();
		downPanel1.add(text4);
		label5=new JLabel();
		label5.setText("联系方式：");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label5);
		text5=new JTextField();
		downPanel1.add(text5);
		downPanel.add(downPanel1);
		
		downPanel2=new JPanel();
		downPanel2.setPreferredSize(new Dimension(400,40));
		downPanel2.setBorder(new LineBorder(SystemColor.RED,1, false));
		FlowLayout f1=new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);  
		downPanel2.setLayout(f1);
		button2=new JButton();
		button2.setText("修改");
		button2.addActionListener(this);
		downPanel2.add(button2);
		
		button1=new JButton();
		button1.setText("导出");
		button1.addActionListener(this);
		downPanel2.add(button1);
		
		button3=new JButton();
		button3.setText("退出");
		button3.addActionListener(this);
		downPanel2.add(button3);
		downPanel.add(downPanel2);
		add(downPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			FileDialog fd=new FileDialog(modCar,"保存记录",FileDialog.SAVE);
			fd.setLocation(400, 250);
			fd.setVisible(true);
			String filePath = fd.getDirectory()+fd.getFile()+".xls";
			illeBean.exportToExcel(table, filePath);
		}
		else if(e.getSource()==button2) {
			int cids = Integer.parseInt(text2.getText());
			bean.updateCar(cids,text3.getText(),text4.getText(),text5.getText());
			this.dispose();
			
			modCar modcar=new modCar();
			modcar.setVisible(true);
			carMain.desktopPane.add(modcar);
			table.revalidate();
		}
		else if(e.getSource()==button3) {
			this.dispose();
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int[] selectedRow=table.getSelectedRows();
		int[] selectedCol=table.getSelectedColumns();
		for(int i=0;i<selectedCol.length;i++) {
			for(int j=0;j<selectedRow.length;i++) {
				 text2.setText(colValue[selectedRow[i]][0]);
				 text2.setEnabled(false);
			     text3.setText(colValue[selectedRow[i]][1]);
			     text4.setText(colValue[selectedRow[i]][3]);
			     text5.setText(colValue[selectedRow[i]][4]);
			}
		}
	}
}
