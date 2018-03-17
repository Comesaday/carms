package CSBean;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import CSDao.Dao;

public class userBean {
	String sql;
	ResultSet rs;
	String name,sex,address,phone,identify,weight,vision,height,ttime,gtime;
	Object grade;
	int id;
	Dao db=new Dao();
	
	public int selPID() {
		int row=0;
		sql="select pid from DriverInfo";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			if(rs.last()) {
				row=rs.getRow();
			}
		}
		catch(Exception e) {
		}
		finally{
			db.closeStat();
			db.closeConn();
		}
		return row;
	}
	
	public void addUser(String text1,String text2,String text3,Object text4,int text5,String text6,String text7,String text8,String text9,String text10,String text11,String text12) {
		name=text1;
		sex=text2;
		identify=text3;
		grade=text4;
	    id=text5;
	    phone=text6;
		address=text7;
		height=text8;
		weight=text9;
		vision=text10;
		gtime=text11;
		ttime=text12;
		sql="insert into DriverInfo(pname,psex,pidentify,pgrade,pid,pphone,paddress,pheight,pweight,pvision,pgtime,pttime) values('"+name+"','"+sex+"','"+identify+"','"+grade+"','"+id+"','"+phone+"','"+address+"','"+height+"','"+weight+"','"+vision+"','"+gtime+"','"+ttime+"')";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			JOptionPane.showMessageDialog(null,"注册成功！");
		}
		catch(Exception e) {
			
		}
		finally {
			db.closeStat();
			db.closeConn();
			
		}
	}
	
	public void delThisUser(int text) {
		id=text;
		sql="delete from DriverInfo where pid='"+id+"'";
		try{
			db.OpenConn();
			db.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"删除成功");
		}
		catch(Exception e) {
			
		}
		finally {
			db.closeStat();
			db.closeConn();
		}
	}
	public String[][] selUser() {
		String[][] sn=null;
		int row=0;
		int i=0;
		sql="select pid,pname,psex,pgrade,pphone,paddress from DriverInfo order by pid";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			if(rs.last()) {
				row=rs.getRow();
			}
			if(row==0) {
				sn=new String[1][6];
				sn[0][0]="";
				sn[0][1]="";
				sn[0][2]="";
				sn[0][3]="";
				sn[0][4]="";
				sn[0][5]="";
			}
			else {
				sn=new String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()) {
					sn[i][0]=rs.getString("pid");
					sn[i][1]=rs.getString("pname");
					sn[i][2]=rs.getString("psex");
					sn[i][3]=rs.getString("pgrade");
					sn[i][4]=rs.getString("pphone");
					sn[i][5]=rs.getString("paddress");
					i++;
				}
			}
		}
		catch(Exception e) {
			
		}
		finally {
			db.closeStat();
			db.closeConn();
			
		}
		return sn;
	}

	public void updateUser(int text, String text1, String text2, String text3, String text4, String text5) {
		// TODO Auto-generated method stub
		id=text;
		name=text1;
		sex=text2;
		grade=text3;
		phone=text4;
		address=text5;
		sql="update DriverInfo set pname='"+name+"',psex='"+sex+"',pgrade='"+grade+"',pphone='"+phone+"',paddress='"+address+"' where pid='"+id+"'";
		try{
			db.OpenConn();
			db.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"修改成功");
		}
		catch(Exception e) {
			
		}
		finally {
			db.closeStat();
			db.closeConn();
		}
	}
}
