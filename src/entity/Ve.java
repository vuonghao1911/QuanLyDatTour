package entity;

import java.util.Date;

public class Ve {
	private int maVe;
	private int soNguoiLon;
	private int soTreEm;
	private int trangThai; // 0.chua thanh toan || 1. da thanh toan
	private Date ngayDat;
	private Tour tour;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	
	public Ve(int maVe, int soNguoiLon, int soTreEm, int trangThai, Tour tour, KhachHang khachHang,
			NhanVien nhanVien) {
		super();
		this.maVe = maVe;
		this.soNguoiLon = soNguoiLon;
		this.soTreEm = soTreEm;
		this.trangThai = trangThai;
		this.ngayDat = new Date();
		this.tour = tour;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}
	public Ve(int maVe, int soNguoiLon, int soTreEm, int trangThai) {
		super();
		this.maVe = maVe;
		this.soNguoiLon = soNguoiLon;
		this.soTreEm = soTreEm;
		this.trangThai = trangThai;
		this.ngayDat = new Date();
	}
	public Ve(int maVe) {
		super();
		this.maVe = maVe;
	}
	public int getMaVe() {
		return maVe;
	}
	public void setMaVe(int maVe) {
		this.maVe = maVe;
	}
	public int getSoNguoiLon() {
		return soNguoiLon;
	}
	public void setSoNguoiLon(int soNguoiLon) {
		this.soNguoiLon = soNguoiLon;
	}
	public int getSoTreEm() {
		return soTreEm;
	}
	public void setSoTreEm(int soTreEm) {
		this.soTreEm = soTreEm;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "Ve [maVe=" + maVe + ", soNguoiLon=" + soNguoiLon + ", soTreEm=" + soTreEm + ", trangThai=" + trangThai
				+ ", ngayDat=" + ngayDat + ", tour=" + tour + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ "]";
	}
	
	
	
	
	
}
