package CSBean;

import java.sql.*;
import javax.swing.JOptionPane;
import CSDao.Dao;

public class carBean {
	String sql;
	ResultSet rs;
	String cstyle,cname,cproduce,cdate,bdate,cdid,cdrive,crdtime,brand,caddress,cphone;
	int cids;
	Object drive;
	Object name;
	Object style;
	Dao db=new Dao();
	
	public int selCID() {
		int row=0;
		sql="select carid from CarInfo";
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
	@SuppressWarnings("null")
	public String[] selectStyle() {
		String[] style=null;
		int row=0;
		int i=0;
		sql="select cstyle from carStyles";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			if(rs.last()) {
				row=rs.getRow();
			}
			if(row==0) {
				style[0]="";
			}
			else {
				style=new String[row];
				rs.first();
				rs.previous();
				while(rs.next()) {
					  style[i]=rs.getString("cstyle");
					  i++;
				}
			}
		}
		catch(Exception e) {
		}
		finally{
			db.closeStat();
			db.closeConn();
		}
			return style;
		}
	
	@SuppressWarnings("null")
	public String[] selectNames(String carstyle) {
		String cstyle=carstyle;
		int row=0;
		int i=0;
		String[] name=null;
		sql="select cname from CarNames where nid=(select nid from CarStyles where cstyle='"+cstyle+"')";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			if(rs.last()) {
				row=rs.getRow();
			}
			if(row==0) {
				name[0]="";
			}
			else {
				name=new String[row];
				rs.first();
				rs.previous();
				while(rs.next()) {
					  name[i]=rs.getString("cname");
					  i++;
				}
			}
		}
		catch(Exception e) {
		}
		finally{
			db.closeStat();
			db.closeConn();
		}
			return name;
		}
	

	public void addCarInfo(int text1, String text2, String text3, String text4, String text5, String text6,String text7, String text8, String text9, String text10, String text11, String text12) {
		cids=text1;
		cstyle=text2;
		cname=text3;
		cproduce=text4;
		cdate=text5;
		bdate=text6;
		cdid=text7;
		cdrive=text8;
		crdtime=text9;
		brand=text10;
		caddress=text11;
		cphone=text12;
		sql="insert into CarInfo values('"+cids+"','"+cstyle+"','"+cname+"','"+cproduce+"','"+cdate+"','"+bdate+"','"+cdid+"','"+cdrive+"','"+crdtime+"','"+brand+"','"+caddress+"','"+cphone+"')";
		try {
			db.OpenConn();
			db.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"注册成功！");
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showConfirmDialog(null, "保存失败", "错误",JOptionPane.ERROR_MESSAGE);
		}
		finally{
			db.closeStat();
			db.closeConn();
		}
	}

	@SuppressWarnings("null")
	public String[][] searchAllCar() {
		String[][] sn=null;
		int row=0;
		int i=0;
		sql="select carid,cname,crdtime,cbrand,cphone from CarInfo order by carid";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			if(rs.last()) {
				row=rs.getRow();
			}
			if(row==0) {
				sn=new String[row][5];
				sn[0][0]="";
				sn[0][1]="";
				sn[0][2]="";
				sn[0][3]="";
				sn[0][4]="";
			}
			else {
				sn=new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()) {
					sn[i][0]=rs.getString("carid");
					sn[i][1]=rs.getString("cname");
					sn[i][2]=rs.getString("crdtime");
					sn[i][3]=rs.getString("cbrand");
					sn[i][4]=rs.getString("cphone");
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

	public void delThisCar(int text) {
		// TODO Auto-generated method stub
		cids=text;
		sql="delete from CarInfo where carid='"+cids+"'"; 
		try {
			db.OpenConn();
			db.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"删除成功！");
		}
		catch(Exception e) {
			
		}
		finally {
			db.closeStat();
			db.closeConn();
		}
	}
	
	public void updateCar(int text,String text1,String text2,String text3) {
		cids=text;
		cname=text1;
		brand=text2;
		cphone=text3;
		sql="update CarInfo set cname='"+cname+"',cbrand='"+brand+"',cphone='"+cphone+"' where carid='"+cids+"'";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			JOptionPane.showMessageDialog(null,"修改成功！");
		}
		catch(Exception e) {
			
		}
		finally {
			db.closeStat();
			db.closeConn();
		}
	}
}
