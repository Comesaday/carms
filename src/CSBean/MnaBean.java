package CSBean;

import java.sql.*;

import CSDao.Dao;

public class MnaBean {
	String sql;
	ResultSet rs;
	String idname;
	String password;
	Dao db=new Dao();
	
	public int ManagerLogin(String id,String pass) {
		idname=id;
		password=pass;
		int identity=0;
		sql="select * from Manager where maccount='"+idname+"' and mpassword='"+password+"'";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			while(rs.next()) {
				identity=1;
			}
		}
		catch(Exception e) {
		}
		finally{
			db.closeStat();
			db.closeConn();
			}
			return identity;
		}
}
