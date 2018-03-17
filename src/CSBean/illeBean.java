package CSBean;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import CSDao.Dao;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class illeBean {
	String sql;
	ResultSet rs;
	int id;
	String time,brand,name,style,detail,driver;
	Dao db=new Dao();
	
	public void dealIll(int text) {
		id=text;
		sql="delete from IllegalInfo where iid='"+id+"'";
		try {
			db.OpenConn();
			db.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"É¾³ý³É¹¦£¡");
		}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showInternalMessageDialog(null, "É¾³ýÊ§°Ü£¡", "´íÎó",JOptionPane.ERROR_MESSAGE);
		}
		finally {
			db.closeStat();
			db.closeConn();
		}
	}
	
	public String[][] searchAllIG() {
		String[][] sn=null;
		int row=0;
		int i=0;
		sql="select * from IllegalInfo order by iid";
		try {
			db.OpenConn();
			rs=db.executeQuery(sql);
			if(rs.last()) {
				row=rs.getRow();
			}
			if(row==0) {
				sn=new String[row][7];
				sn[0][0]="";
				sn[0][1]="";
				sn[0][2]="";
				sn[0][3]="";
				sn[0][4]="";
				sn[0][5]="";
				sn[0][6]="";
			}
			else {
				sn=new String[row][7];
				rs.first();
				rs.previous();
				while(rs.next()) {
					sn[i][0]=rs.getString("iid");
					sn[i][1]=rs.getString("itime");
					sn[i][2]=rs.getString("cbrand");
					sn[i][3]=rs.getString("cname");
					sn[i][4]=rs.getString("phone");
					sn[i][5]=rs.getString("detail");
					sn[i][6]=rs.getString("driver");
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

	public static void exportToExcel(JTable table, String filePath) {
		try {
			WritableWorkbook book=Workbook.createWorkbook(new File(filePath));
			WritableSheet sheet = book.createSheet("sheet1",0);
			int columnCount = table.getColumnCount();
			int rowCount = table.getRowCount();
			WritableFont font1 = new WritableFont(WritableFont.createFont("ºÚÌå"),14, WritableFont.NO_BOLD);
			WritableCellFormat format1 = new WritableCellFormat(font1);
			WritableFont font2 = new WritableFont(WritableFont.TIMES,12);
			WritableCellFormat format2 = new WritableCellFormat(font2);
			Label label = null;
			for(int i=0;i<columnCount;i++){
				String columnName = table.getColumnName(i);
				label = new Label(i,0,columnName,format1);
				sheet.addCell(label);
				for(int j=0;j<rowCount;j++){
					String value = table.getValueAt(j,i).toString();
					label = new Label(i,j+1,value,format2);
					sheet.addCell(label);					
				}
			}
			book.write();
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}	
}
