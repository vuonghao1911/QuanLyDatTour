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
	
	public Tour tour(ResultSet resultSet) throws SQLException {
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
			String sql = "select maTour,tenTour,diemDen,diemXuatPhat,thoiGian, ngayKhoiHanh, moTa, gia,giaTreEm, soLuong from Tour";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int maTour = rs.getInt("maTour");
				String tenTour = rs.getString("tenTour");
				String diemXuatPhat = rs.getString("diemXuatPhat");
				String diemDen = rs.getString("diemDen");
				Date ngayKhoiHanh = rs.getDate("ngayKhoiHanh");
				String thoiGian = rs.getString("thoiGian");
				String moTa = rs.getString("moTa");
				Double gia = rs.getDouble("gia");
				Double giaTreEm = rs.getDouble("giaTreEm");
				int soLuong = rs.getInt("soLuong");
				Tour tour = new Tour(maTour,tenTour,diemDen,diemXuatPhat,thoiGian, ngayKhoiHanh, moTa, gia,giaTreEm, soLuong);
				dsTour.add(tour);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
	}
	
	public void them(Tour tour) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		Statement statement = connection.createStatement();
		try {
			String sqlQueryCommand = "INSERT INTO Tour(maTour, tenTour, diemDen, diemXuatPhat, thoiGian, ngayKhoiHanh, moTa, gia, giaTreEm, soLuong) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setInt(1, tour.getMaTour());
			preparedStatement.setString(2, tour.getTenTour());
			preparedStatement.setString(3, tour.getDiemDen());
			preparedStatement.setString(4, tour.getDiemXuatPhat());
			preparedStatement.setString(5, tour.getThoiGian());
			preparedStatement.setDate(6, (java.sql.Date) tour.getNgayKhoiHanh());	
			preparedStatement.setString(7, tour.getMoTa());
			preparedStatement.setDouble(8, tour.getGia());
			preparedStatement.setDouble(9, tour.getGiaTreEm());
			preparedStatement.setInt(10, tour.getSoLuong());
			statement.executeUpdate("SET IDENTITY_INSERT TOUR ON");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void sua(Tour tour, String id) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sqlQueryCommand = "UPDATE Tour SET maTour = ?, tenTour = ?, diemDen = ?, diemXuatPhat = ?, thoiGian = ?, ngayKhoiHanh = ?, moTa = ?, gia = ?, giaTreEm = ?, soLuong = ? WHERE maTour = ?";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setInt(1, tour.getMaTour());
			preparedStatement.setString(2, tour.getTenTour());
			preparedStatement.setString(3, tour.getDiemDen());
			preparedStatement.setString(4, tour.getDiemXuatPhat());
			preparedStatement.setString(5, tour.getThoiGian());
			preparedStatement.setDate(6, (java.sql.Date) tour.getNgayKhoiHanh());	
			preparedStatement.setString(7, tour.getMoTa());
			preparedStatement.setDouble(8, tour.getGia());
			preparedStatement.setDouble(9, tour.getGiaTreEm());
			preparedStatement.setInt(10, tour.getSoLuong());
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
		Tour tour = null;
		PreparedStatement preparedStatement = null;
		String sqlQueryCommand = "SELECT * FROM TOUR WHERE maTour = ?";
		try {
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				tour = tour(resultSet);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tour;
		}
	
}