package CSDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao {
	private Statement stat=null;
	ResultSet rs=null;
	private Connection conn=null;
	private String URL = "jdbc:sqlserver://localhost;DatabaseName=CarMS";
	private String UserName = "sa";
    private String PassWord = "as19960727"; 
	String sql;
	
	public Dao() {
		
	}
	
	public void OpenConn() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn= DriverManager.getConnection(URL, UserName, PassWord); 
		}
		catch(Exception e) {
			System.err.println("OpenConn:"+e.getMessage());
		}
	}
	
	public ResultSet executeQuery(String sql) {
		stat=null;
		rs=null;
		try {
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stat.executeQuery(sql);
		}
		catch(Exception e) {
			System.err.println("executeQuery:"+e.getMessage());
		}
		return rs;
	}
	
	public int executeUpdate(String sql) {
		stat=null;
		rs=null;
		try {
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stat.executeUpdate(sql);
			conn.commit();
		}
		catch(Exception e) {
			System.err.println("executeUpdate:"+e.getMessage());
		}
		return 0;
	}
	
	public void closeStat() {
		try {
			stat.close();
		}
		catch(Exception e) {
			System.err.println("closeStat:"+e.getMessage());
		}
	}
	
	public void closeConn() {
		try {
			conn.close();
		}
		catch(Exception e) {
			System.err.println("closeConn:"+e.getMessage());
		}
	}
	
	public static String toUTF(String str){
		try {
			if(str==null) {
				str="";
			}
			else {
				str=new String(str.getBytes("IOS-8859-1"),"UTF-8");
			}
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return str;
	}
}