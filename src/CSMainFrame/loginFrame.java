package CSMainFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import CSBean.MnaBean;

public class loginFrame extends JFrame implements ActionListener,FocusListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int userrow=0;//获取数据库中用户信息
	int managerrow=0;//获取数据库中管理员信息
	MnaBean ubean=new MnaBean();
	
	
	JButton bsure,breset;
	JLabel laccount,lpassword;
	public static JTextField taccount;
	JTextField tpassword;
	
	public loginFrame(){  
        super();  
        this.setTitle("车管登录");  
        this.setBounds(100,80,385,260);       
        //setResizable(false);
        Container p = getContentPane();  
        p.setLayout(null);  
        
        laccount = new JLabel("账    号：");  
        laccount.setBounds(60,75,80,20);  
        p.add(laccount);  
          
        taccount= new JTextField("账号登录"); 
        taccount.setBounds(130,75,150,22);
        taccount.addActionListener(this);
        taccount.addFocusListener(this);
        p.add(taccount);  
          
        lpassword= new JLabel("密    码："); 
        lpassword.setBounds(60,120,80,22);  
        p.add(lpassword); 
        
        tpassword= new JPasswordField(8);  
        tpassword.setBounds(130,120,150,22);
        tpassword.setFocusable(true);
        p.add(tpassword); 
              
        breset = new JButton("重置"); 
        breset.setBounds(225,180,60,27); 
        breset.addActionListener(this);
        p.add(breset);
        
        bsure = new JButton("登录");  
        bsure.setBounds(105,180,60,27);  
        bsure.addActionListener(this); 
        p.add(bsure);
           
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
    }
	
	public void actionPerformed(ActionEvent e) {
	     
	     if(e.getSource()==breset){
	       		taccount.setText(null);
	    	   	tpassword.setText(null);
	     }  
	
	     if(e.getSource()==bsure){
	    	 
	    	if(taccount.getText().length()==0||tpassword.getText().length()==0) {
	    		JOptionPane.showMessageDialog(null,"账号或密码不能为空！","错误",JOptionPane.ERROR_MESSAGE);
	    	}
	    	else{
	    		managerrow=ubean.ManagerLogin(taccount.getText(), tpassword.getText());
	    		if(managerrow>0) {
	    			loginFrame.this.setVisible(false);
		    		carMain mframe=new carMain();
		    		mframe.setVisible(true);
	    		}	
	    		else {
	    			JOptionPane.showMessageDialog(null,"账号或密码错误！","错误",JOptionPane.ERROR_MESSAGE);
	    			taccount.setText(null);
	    			tpassword.setText(null);
	    		}
	    	 }
	     }  
	}
	 public void focusGained(FocusEvent e){   
		 
		 if(e.getSource()==taccount){
			 taccount.setText(null); 			
	   	}
		 
		 if(e.getSource()==tpassword){
			 tpassword.setText(null); 			
	   	}
		 
	}
	 
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
