package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.Tour;

public class Tour_DAO {
	public ArrayList<Tour> getAllTour(){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select maTour,tenTour,ngayKhoiHanh,diemDen,thoiGian,gia,giaTreEm from Tour";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maTour = rs.getInt("maTour");
				String tenTour = rs.getString("tenTour");
				Date ngayKhoiHanh = rs.getDate("ngayKhoiHanh");
				String diemDen = rs.getString("diaDiem");
				String thoiGian = rs.getString("thoiGian");
				Double gia = rs.getDouble("gia");
				Double giaTreEm = rs.getDouble("giaTreEm");
				Tour tour = new Tour(maTour,tenTour,diemDen,thoiGian,thoiGian, ngayKhoiHanh,thoiGian, gia,giaTreEm, maTour);
				dsTour.add(tour);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
	}
}
