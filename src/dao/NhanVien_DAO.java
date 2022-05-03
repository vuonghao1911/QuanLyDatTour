package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {

	public NhanVien init(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt(1);
		String name = resultSet.getString(2);
		String address = resultSet.getString(3);
		String gender = resultSet.getString(4);
		Date dayOfBirth = resultSet.getDate(5);
		String tel = resultSet.getString(6);
		return new NhanVien(id, name, address, gender, dayOfBirth, tel);
	}

	public List<NhanVien> getAll() {
		List<NhanVien> employees = new ArrayList<NhanVien>();
		Connection connection = ConnectDB.getConnection();
		String sqlQueryCommand = "SELECT * FROM NhanVien";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryCommand);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanVien employee = init(resultSet);
				employees.add(employee);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public void add(NhanVien employee) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		Statement statement = connection.createStatement();
		try {
			String sqlQueryCommand = "INSERT INTO NhanVien(maNV, tenNV, diaChi, gioiTinh, ngaySinh, sdt) VALUES(?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setInt(1, employee.getMaNV());
			preparedStatement.setString(2, employee.getTenNV());
			preparedStatement.setString(3, employee.getDiaChi());
			preparedStatement.setString(4, employee.getGioiTinh());
			preparedStatement.setDate(5, (java.sql.Date) employee.getNgaySinh());
			preparedStatement.setString(6, employee.getSdt());
			statement.executeUpdate("SET IDENTITY_INSERT NhanVien ON");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(NhanVien employee, String id) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sqlQueryCommand = "UPDATE NhanVien SET tenNV = ?, diaChi = ?, gioiTinh = ?, ngaySinh = ?, sdt = ? WHERE maNV = ?";
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, employee.getTenNV());
			preparedStatement.setString(2, employee.getDiaChi());
			preparedStatement.setString(3, employee.getGioiTinh());
			preparedStatement.setDate(4, new java.sql.Date(employee.getNgaySinh().getTime()));
			preparedStatement.setString(5, employee.getSdt());
			preparedStatement.setInt(6, Integer.parseInt(id));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int delete(String id) throws SQLException {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		String sqlQueryCommand = "DELETE FROM NhanVien WHERE maNV = ?";
		try {
			preparedStatement = connection.prepareStatement(sqlQueryCommand);
			preparedStatement.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement.executeUpdate();
	}

	public NhanVien findByID(String id) {
		Connection connection = ConnectDB.getConnection();
		NhanVien employee = null;
		PreparedStatement preparedStatement = null;
		String sqlQueryCommand = "SELECT * FROM NhanVien WHERE maNV = ?";
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
