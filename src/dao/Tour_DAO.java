package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.Tour;

public class Tour_DAO {
	
	public Tour init(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(1);
		String ten = resultSet.getString(2);
		String diemden = resultSet.getString(3);
		String diemdi = resultSet.getString(4);
		String	thoigian  = resultSet.getString(5);
		Date ngaykhoihanh = resultSet.getDate(6);
		String mota = resultSet.getString(7);
		Double gia = resultSet.getDouble(8);
		Double giaTE = resultSet.getDouble(9);
		int soluong = resultSet.getInt(10);
		return new Tour(id, ten, diemden, diemdi, thoigian, ngaykhoihanh, mota, gia, giaTE, soluong);
	}

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
				String diemDen = rs.getString("diemDen");
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
	
	public void them(Tour employee) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		Statement statement = connection.createStatement();
		try {
			String sqlQueryCommand = "INSERT INTO NhanVien(maNV, tenNV, diaChi, gioiTinh, ngaySinh, sdt) VALUES(?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setInt(1, employee.getMaTour());
			preparedStatement.setString(2, employee.getTenTour());
			preparedStatement.setString(3, employee.getDiemDen());
			preparedStatement.setString(4, employee.getDiemXuatPhat());
			preparedStatement.setString(5, employee.getThoiGian());
			preparedStatement.setDate(6, (java.sql.Date) employee.getNgayKhoiHanh());	
			preparedStatement.setString(7, employee.getMoTa());
			preparedStatement.setDouble(8, employee.getGia());
			preparedStatement.setDouble(9, employee.getGiaTreEm());
			preparedStatement.setInt(10, employee.getSoLuong());
			statement.executeUpdate("SET IDENTITY_INSERT TOUR ON");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void sua(Tour employee, String id) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sqlQueryCommand = "UPDATE NhanVien SET tenNV = ?, diaChi = ?, gioiTinh = ?, ngaySinh = ?, sdt = ? WHERE maNV = ?";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setInt(1, employee.getMaTour());
			preparedStatement.setString(2, employee.getTenTour());
			preparedStatement.setString(3, employee.getDiemDen());
			preparedStatement.setString(4, employee.getDiemXuatPhat());
			preparedStatement.setString(5, employee.getThoiGian());
			preparedStatement.setDate(6, (java.sql.Date) employee.getNgayKhoiHanh());	
			preparedStatement.setString(7, employee.getMoTa());
			preparedStatement.setDouble(8, employee.getGia());
			preparedStatement.setDouble(9, employee.getGiaTreEm());
			preparedStatement.setInt(10, employee.getSoLuong());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int xoa(String id) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		String sqlQueryCommand = "DELETE FROM NhanVien WHERE maTour = ?";
		try {
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement.executeUpdate();
	}

	public Tour findByID(String id) {
		Connection connection = ConnectDB.getConnection();
		Tour employee = null;
		PreparedStatement preparedStatement = null;
		String sqlQueryCommand = "SELECT * FROM TOUR WHERE maTour = ?";
		try {
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = init(resultSet);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
		}
	
}