package entity;

import java.util.Date;



public class Tour {
	private int maTour;
	private String tenTour;
	private String diemDen;
	private String diemXuatPhat;
	private String thoiGian;
	private Date ngayKhoiHanh;
	private String moTa;
	private Double gia;
	private Double giaTreEm;
	private int soLuong;
	
	public Tour(int maTour, String tenTour, String diemDen, String diemXuatPhat, String thoiGian, Date ngayKhoiHanh,
			String moTa, Double gia, Double giaTreEm, int soLuong) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.diemDen = diemDen;
		this.diemXuatPhat = diemXuatPhat;
		this.thoiGian = thoiGian;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.moTa = moTa;
		this.gia = gia;
		this.giaTreEm = giaTreEm;
		this.soLuong = soLuong;
	}
	
	public Tour(int maTour) {
		super();
		this.maTour = maTour;
	}
	
	
	public Tour(int maTour, String tenTour, Double gia, Double giaTreEm) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.gia = gia;
		this.giaTreEm = giaTreEm;
	}
		


	public Tour(int maTour, String tenTour) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
	}
	


	public Tour(int maTour, String tenTour, String diemDen, String thoiGian, Date ngayKhoiHanh, Double gia,
			Double giaTreEm) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.diemDen = diemDen;
		this.thoiGian = thoiGian;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.gia = gia;
		this.giaTreEm = giaTreEm;
		
	}

	public int getMaTour() {
		return maTour;
	}
	public void setMaTour(int maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public String getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}
	public String getDiemXuatPhat() {
		return diemXuatPhat;
	}
	public void setDiemXuatPhat(String diemXuatPhat) {
		this.diemXuatPhat = diemXuatPhat;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public Date getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	public void setNgayKhoiHanh(Date ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	public Double getGiaTreEm() {
		return giaTreEm;
	}
	public void setGiaTreEm(Double giaTreEm) {
		this.giaTreEm = giaTreEm;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "Tour [maTour=" + maTour + ", tenTour=" + tenTour + ", diemDen=" + diemDen + ", diemXuatPhat="
				+ diemXuatPhat + ", thoiGian=" + thoiGian + ", ngayKhoiHanh=" + ngayKhoiHanh + ", moTa=" + moTa
				+ ", gia=" + gia + ", giaTreEm=" + giaTreEm + ", soLuong=" + soLuong + "]";
	}
	
}
