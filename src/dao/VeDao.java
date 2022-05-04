package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;

import entity.KhachHang;

import entity.NhanVien;

import entity.Tour;
import entity.Ve;

public class VeDao {
	

	public ArrayList<Ve> getAllVes(){
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		ConnectDB.getInstance();
		Statement statement = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "  select v.[maVe],[soNguoiLon],[soTreEm],[trangThai],[ngayDat],t.[maTour],t.tenTour,v.[maKH],nv.[maNV]  ,nv.[tenNV],[tenKH]\r\n"
					+ "  \r\n"
					+ "  from [dbo].[Ve] v  join [dbo].[NhanVien] nv on v.maNV = nv.maNV\r\n"
					+ "  join [dbo].[KhachHang] kh on kh.maKH = v.maKH\r\n"
					+ "  join  [dbo].[Tour] t on v.maTour = t.maTour";
			 statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maVe = rs.getInt("maVe");
				int soNgouoiLon = rs.getInt("soNguoiLon");
				int soTreEm = rs.getInt("soTreEm");
				int trangThai = rs.getInt("TrangThai");
				Date ngayDate = rs.getDate("ngayDat");
				
				int maTour = rs.getInt("maTour");
				String tenTuor = rs.getString("tenTour");
				
				int maKH = rs.getInt("maKH");
				String tenKH = rs.getString("tenKH");
			
				int maNV = rs.getInt("maNV");
				String tenNV = rs.getString("tenNV");
				Tour  tour = new Tour(maTour, tenTuor);
				KhachHang kh = new KhachHang(maKH, tenKH);
				NhanVien nVien = new NhanVien(maNV, tenNV);
					Ve ve = new Ve(maVe, soNgouoiLon, soTreEm, trangThai, ngayDate, tour, kh, nVien);
				dsVe.add(ve);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsVe;
	}
	
	public boolean insert(Ve ve) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			String sql =  " insert into [dbo].[Ve] ([soNguoiLon],[soTreEm],[trangThai],[ngayDat],[maTour],[maKH],[maNV]) "
					
					+ "values(?,?,?,?,?,?,?)";
			stmt= con.prepareStatement(sql);
			stmt.setInt(1,ve.getSoNguoiLon());
			stmt.setInt(2,ve.getSoTreEm());
			stmt.setInt(3,ve.getTrangThai());
			stmt.setDate(4, new java.sql.Date(ve.getNgayDat().getTime()));			
			stmt.setInt(5,ve.getTour().getMaTour());
			stmt.setInt(6,ve.getKhachHang().getMaKH());
			stmt.setInt(7, ve.getNhanVien().getMaNV());
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
	public ArrayList<Ve> getVeByNameNhanVien(String name) {
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		ConnectDB.getInstance();
		 PreparedStatement stmt = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "    select v.[maVe],[soNguoiLon],[soTreEm],[trangThai],[ngayDat],t.[maTour],t.tenTour,v.[maKH],nv.[maNV]  ,nv.[tenNV],[tenKH]\r\n"
					+ "			\r\n"
					+ "				from [dbo].[Ve] v  join [dbo].[NhanVien] nv on v.maNV = nv.maNV\r\n"
					+ "					  join [dbo].[KhachHang] kh on kh.maKH = v.maKH\r\n"
					+ "				join  [dbo].[Tour] t on v.maTour = t.maTour\r\n"
					+ "				where nv.tenNV like ? ";
				stmt = con.prepareStatement(sql);
	            stmt.setString(1,"%" +name+"%" );
	       
	            ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maVe = rs.getInt("maVe");
				int soNgouoiLon = rs.getInt("soNguoiLon");
				int soTreEm = rs.getInt("soTreEm");
				int trangThai = rs.getInt("TrangThai");
				Date ngayDate = rs.getDate("ngayDat");
				
				int maTour = rs.getInt("maTour");
				String tenTuor = rs.getString("tenTour");
				
				int maKH = rs.getInt("maKH");
				String tenKH = rs.getString("tenKH");
			
				int maNV = rs.getInt("maNV");
				String tenNV = rs.getString("tenNV");
				Tour  tour = new Tour(maTour, tenTuor);
				KhachHang kh = new KhachHang(maKH, tenKH);
				NhanVien nVien = new NhanVien(maNV, tenNV);
					Ve ve = new Ve(maVe, soNgouoiLon, soTreEm, trangThai, ngayDate, tour, kh, nVien);
				dsVe.add(ve);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsVe;
	}
	public Ve getVeByMaVe(int ma) {
		Ve ve = null;
		ConnectDB.getInstance();
		 PreparedStatement stmt = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "    select v.[maVe],[soNguoiLon],[soTreEm] , t.gia, t.giaTreEm,[trangThai],[ngayDat],t.[maTour],t.tenTour,v.[maKH],nv.[maNV]  ,nv.[tenNV],[tenKH]\r\n"
					+ "			\r\n"
					+ "				from [dbo].[Ve] v  join [dbo].[NhanVien] nv on v.maNV = nv.maNV\r\n"
					+ "					  join [dbo].[KhachHang] kh on kh.maKH = v.maKH\r\n"
					+ "				join  [dbo].[Tour] t on v.maTour = t.maTour\r\n"
					+ "				where v.maVe = ? ";
				stmt = con.prepareStatement(sql);
	            stmt.setInt(1,ma );
	       
	            ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maVe = rs.getInt("maVe");
				int soNgouoiLon = rs.getInt("soNguoiLon");
				int soTreEm = rs.getInt("soTreEm");
				int trangThai = rs.getInt("TrangThai");
				Date ngayDate = rs.getDate("ngayDat");
				
				int maTour = rs.getInt("maTour");
				String tenTuor = rs.getString("tenTour");
				
				int maKH = rs.getInt("maKH");
				String tenKH = rs.getString("tenKH");
			
				int maNV = rs.getInt("maNV");
				String tenNV = rs.getString("tenNV");
				Tour  tour = new Tour(maTour, tenTuor,rs.getDouble("gia"),rs.getDouble("giaTreEm"));
				KhachHang kh = new KhachHang(maKH, tenKH);
				NhanVien nVien = new NhanVien(maNV, tenNV);
					ve = new Ve(maVe, soNgouoiLon, soTreEm, trangThai, ngayDate, tour, kh, nVien);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ve;
	}
	
	public ArrayList<Ve> getAllVeByDate(Date date) {
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		ConnectDB.getInstance();
		 PreparedStatement stmt = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "    select v.[maVe],[soNguoiLon],[soTreEm],[trangThai],[ngayDat],t.[maTour],t.tenTour,v.[maKH],nv.[maNV]  ,nv.[tenNV],[tenKH]\r\n"
					+ "			\r\n"
					+ "				from [dbo].[Ve] v  join [dbo].[NhanVien] nv on v.maNV = nv.maNV\r\n"
					+ "					  join [dbo].[KhachHang] kh on kh.maKH = v.maKH\r\n"
					+ "				join  [dbo].[Tour] t on v.maTour = t.maTour\r\n"
					+ "				where ngayDat = ? ";
				stmt = con.prepareStatement(sql);
	            stmt.setDate(1,new java.sql.Date(date.getTime()));
	       
	            ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maVe = rs.getInt("maVe");
				int soNgouoiLon = rs.getInt("soNguoiLon");
				int soTreEm = rs.getInt("soTreEm");
				int trangThai = rs.getInt("TrangThai");
				Date ngayDate = rs.getDate("ngayDat");
				
				int maTour = rs.getInt("maTour");
				String tenTuor = rs.getString("tenTour");
				
				int maKH = rs.getInt("maKH");
				String tenKH = rs.getString("tenKH");
			
				int maNV = rs.getInt("maNV");
				String tenNV = rs.getString("tenNV");
				Tour  tour = new Tour(maTour, tenTuor);
				KhachHang kh = new KhachHang(maKH, tenKH);
				NhanVien nVien = new NhanVien(maNV, tenNV);
					Ve ve = new Ve(maVe, soNgouoiLon, soTreEm, trangThai, ngayDate, tour, kh, nVien);
				dsVe.add(ve);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsVe;
	}
	
	public ArrayList<Ve> getVeByNameKhachHang(String name) {
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		ConnectDB.getInstance();
		 PreparedStatement stmt = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "    select v.[maVe],[soNguoiLon],[soTreEm],[trangThai],[ngayDat],t.[maTour],t.tenTour,v.[maKH],nv.[maNV]  ,nv.[tenNV],[tenKH]\r\n"
					+ "			\r\n"
					+ "				from [dbo].[Ve] v  join [dbo].[NhanVien] nv on v.maNV = nv.maNV\r\n"
					+ "					  join [dbo].[KhachHang] kh on kh.maKH = v.maKH\r\n"
					+ "				join  [dbo].[Tour] t on v.maTour = t.maTour\r\n"
					+ "				where  kh.tenKH like ?";
				stmt = con.prepareStatement(sql);
	            stmt.setString(1,"%" +name+"%" );
	            
	            ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maVe = rs.getInt("maVe");
				int soNgouoiLon = rs.getInt("soNguoiLon");
				int soTreEm = rs.getInt("soTreEm");
				int trangThai = rs.getInt("TrangThai");
				Date ngayDate = rs.getDate("ngayDat");
				
				int maTour = rs.getInt("maTour");
				String tenTuor = rs.getString("tenTour");
				
				int maKH = rs.getInt("maKH");
				String tenKH = rs.getString("tenKH");
			
				int maNV = rs.getInt("maNV");
				String tenNV = rs.getString("tenNV");
				Tour  tour = new Tour(maTour, tenTuor);
				KhachHang kh = new KhachHang(maKH, tenKH);
				NhanVien nVien = new NhanVien(maNV, tenNV);
					Ve ve = new Ve(maVe, soNgouoiLon, soTreEm, trangThai, ngayDate, tour, kh, nVien);
				dsVe.add(ve);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsVe;
	}
	
	 public ArrayList<Tour> getTuorTheoMaVe(int maVe) {
	        ArrayList<Tour> dsTour = new ArrayList<Tour>();
	        PreparedStatement stmt = null;
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        try {
	            String sql = "select * from [dbo].[Tour] t join [dbo].[Ve] v on v.maTour = t.maTour  where v.maVe = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, maVe);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	
	            	Tour tour = new Tour(rs.getInt("maTour"), rs.getString("tenTour"), rs.getString("diemDen"),rs.getString("diemXuatPhat") , rs.getString("thoiGian"),
	            			rs.getDate("ngayKhoiHanh"), rs.getString("moTa"), rs.getDouble("gia"), rs.getDouble("giaTreEm"), rs.getInt("soLuong"));
					
					dsTour.add(tour);
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return dsTour;
	    }
	 
	 public ArrayList<Ve> getVeByMonth(int month) {
	        ArrayList<Ve> dsTour = new ArrayList<Ve>();
	        PreparedStatement stmt = null;
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        try {
	            String sql = "select * from [dbo].[Ve] where MONTH(ngayDat)=?";
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, month);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	
	            	Ve ve = new Ve(rs.getInt("maVe"), rs.getInt("soNguoiLon"), rs.getInt("soTreEm"), rs.getInt("TrangThai"),rs.getDate("ngayDat"),
	            			new Tour(rs.getInt("maTour")),new KhachHang(rs.getInt("maKH")),new NhanVien(rs.getInt("maNV")));
					
					dsTour.add(ve);
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return dsTour;
	    }
	 
	 public ArrayList<Ve> getVeByDate(Date date) {
	        ArrayList<Ve> dsTour = new ArrayList<Ve>();
	        PreparedStatement stmt = null;
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        try {
	            String sql = "select * from [dbo].[Ve] where ngayDat = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setDate(1, new java.sql.Date(date.getTime()));
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	            	
	            	Ve ve = new Ve(rs.getInt("maVe"), rs.getInt("soNguoiLon"), rs.getInt("soTreEm"), rs.getInt("TrangThai"),rs.getDate("ngayDat"),
	            			new Tour(rs.getInt("maTour")),new KhachHang(rs.getInt("maKH")),new NhanVien(rs.getInt("maNV")));
					
					dsTour.add(ve);
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return dsTour;
	    }
}
