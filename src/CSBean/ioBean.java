package CSBean;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import CSDao.Dao;

public class ioBean {
	String sql;
	ResultSet rs;
	int id;
	String name,time,brand,route,phone;
	Dao db=new Dao();
	
	public int selInID() {
		int row=0;
		sql="select * from InRecord";
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
	
	public String[][] searchAllIn() {
		String[][] sn=null;
		int row=0;
		int i=0;
		sql="select * from InRecord order by iid";
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
					sn[i][0]=rs.getString("iid");
					sn[i][1]=rs.getString("pname");
					sn[i][2]=rs.getString("idate");
					sn[i][3]=rs.getString("cbrand");
					sn[i][4]=rs.getString("route");
					sn[i][5]=rs.getString("phone");
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

	public void addInRecord(int iid, String text, String text2, String text3, String text4, String text5) {
		id=iid;
		name=text;
		time=text2;
		brand=text3;
		route=text4;
		phone=text5;
		sql="insert into InRecord(iid,pname,idate,cbrand,route,phone) values('"+id+"','"+name+"','"+time+"','"+brand+"','"+route+"','"+phone+"')";
		try {
			db.OpenConn();
			db.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"添加成功！");
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showConfirmDialog(null, "添加失败", "错误",JOptionPane.ERROR_MESSAGE);
		}
		finally{
			db.closeStat();
			db.closeConn();
		}
	}

	public String[][] searchAllOut() {
		String[][] sn=null;
		int row=0;
		int i=0;
		sql="select * from OutRecord order by oid";
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
					sn[i][0]=rs.getString("oid");
					sn[i][1]=rs.getString("pname");
					sn[i][2]=rs.getString("odate");
					sn[i][3]=rs.getString("cbrand");
					sn[i][4]=rs.getString("route");
					sn[i][5]=rs.getString("phone");
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

	public void addOutRecord(int iid, String text, String text2, String text3, String text4, String text5) {
		id=iid;
		name=text;
		time=text2;
		brand=text3;
		route=text4;
		phone=text5;
		sql="insert into OutRecord(oid,pname,odate,cbrand,route,phone) values('"+id+"','"+name+"','"+time+"','"+brand+"','"+route+"','"+phone+"')";
		try {
			db.OpenConn();
			db.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"添加成功！");
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showConfirmDialog(null, "添加失败", "错误",JOptionPane.ERROR_MESSAGE);
		}
		finally{
			db.closeStat();
			db.closeConn();
		}
		
	}

	public int selOutID() {
		int row=0;
		sql="select * from OutRecord";
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
}
