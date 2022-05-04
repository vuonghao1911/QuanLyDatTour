package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public KhachHang init(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(1);
		String name = resultSet.getString(2);
		String tel = resultSet.getString(3);
		String gender = resultSet.getString(4);
		String code = resultSet.getString(5);
		int ticketCode = resultSet.getInt(6);
		return new KhachHang(id, name, tel, gender, code, ticketCode);
	}
	
	public List<KhachHang> getAll() {
		List<KhachHang> customers = new ArrayList<KhachHang>();
		Connection connection = ConnectDB.getConnection();
		String sqlQueryCommand = "SELECT KhachHang.maKH, tenKH, sdt, gioiTinh, cmnd, maVe FROM KhachHang JOIN Ve ON KhachHang.maKH = Ve.maKH";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryCommand);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				KhachHang customer = init(resultSet);
				customers.add(customer);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}
	public ArrayList<KhachHang> getALLKhachHang() {
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Statement statement = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT * FROM KhachHang";
			 statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maKH = rs.getInt("MaKH");
				String tenKH = rs.getString(2);
				String sdt = rs.getString(3);
				String cmnd = rs.getString(5);
				String gioiTinh = rs.getString(4);
				KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, cmnd);
				dsKH.add(kh);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
	public void add(KhachHang customer) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		Statement statement = connection.createStatement();
		try {
			String sqlQueryCommand = "INSERT INTO KhachHang(maKH, tenKH, sdt, gioiTinh, cmnd) VALUES(?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setInt(1, customer.getMaKH());
			preparedStatement.setString(2, customer.getTenKH());
			preparedStatement.setString(3, customer.getSdt());
			preparedStatement.setString(4, customer.getGioiTinh());
			preparedStatement.setString(5, customer.getCmnd());
			statement.executeUpdate("SET IDENTITY_INSERT KhachHang ON");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean insert(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			String sql = " insert into [dbo].[KhachHang] (tenKH,sdt,gioiTinh,cmnd)"
					+ " values (?,?,?,?)";
			stmt= con.prepareStatement(sql);
			stmt.setString(1,kh.getTenKH());
			stmt.setString(2,kh.getSdt());
			stmt.setString(4,kh.getCmnd());
			stmt.setString(3,kh.getGioiTinh());
			n= stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
			return n>0;	
	}
	
	public void update(KhachHang customer, String id) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		String sqlQueryCommand = "UPDATE KhachHang SET tenKH = ?, sdt = ?, gioiTinh = ?, cmnd = ? WHERE maKH = ?";
		try {
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, customer.getTenKH());
			preparedStatement.setString(2, customer.getSdt());
			preparedStatement.setString(3, customer.getGioiTinh());
			preparedStatement.setString(4, customer.getCmnd());
			preparedStatement.setInt(5, Integer.parseInt(id));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sqlQueryCommand = "DELETE FROM KhachHang WHERE maKH = ?";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			String sqlQueryCommand = "DELETE FROM Ve WHERE maKH = ?";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public KhachHang findByID(String id) {
		Connection connection = ConnectDB.getConnection();
		KhachHang customer = null;
		PreparedStatement preparedStatement = null;
		String sqlQueryCommand = "SELECT KhachHang.maKH, tenKH, sdt, gioiTinh, cmnd, maVe FROM KhachHang JOIN Ve ON KhachHang.maKH = Ve.maKH WHERE KhachHang.maKH = ?";
		try {
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = init(resultSet);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
