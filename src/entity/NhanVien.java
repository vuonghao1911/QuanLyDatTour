package entity;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private int maNV;
	private String tenNV;
	private String diaChi;
	private String gioiTinh;
	private Date ngaySinh;
	private String sdt;
	
	public NhanVien(int maNV, String tenNV, String diaChi, String gioiTinh, Date ngaySinh, String sdt) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
	}
	
	public NhanVien(int maNV, String tenNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
	}

	public NhanVien(int maNV) {
		super();
		this.maNV = maNV;
	}
	
	public int getMaNV() {
		return maNV;
	}
	
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	
	public String getTenNV() {
		return tenNV;
	}
	
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public Date getNgaySinh() {
		return ngaySinh;
	}
	
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	public String getSdt() {
		return sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return maNV == other.maNV;
	}
	
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + "]";
	}
	
}
