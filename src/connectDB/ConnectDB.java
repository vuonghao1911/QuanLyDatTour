package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Nguyễn Vương Hạo
 * connect database
 *
 */
public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException {
		String url ="jdbc:sqlserver://localhost:1433;databaseName=QLTour";
		String user ="sa";
		String password="1234";
		con = DriverManager.getConnection(url, user, password);
	}
	public void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
	}
	
	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		
		
			String url ="jdbc:sqlserver://localhost:1433;databaseName=QLTN";
			String user ="sa";
			String password="1234";
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLSeverDriver");
			Connection con;
			try {
				con = DriverManager.getConnection(url, user, password);
				System.out.println("thanh cong");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("that bai");
			}
			
		

}
}
