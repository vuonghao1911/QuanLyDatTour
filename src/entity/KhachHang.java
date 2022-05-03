package entity;

import java.util.Objects;

public class KhachHang {
	private int maKH;
	private int maVe;
	private String tenKH;
	private String sdt;
	private String gioiTinh;
	private String cmnd;
	
	public KhachHang(int maKH, String tenKH, String sdt, String gioiTinh, String cmnd) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
	}
	
	public KhachHang(int maKH, String tenKH, String sdt, String gioiTinh, String cmnd, int maVe) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.maVe = maVe;
	}
	
	public KhachHang(int maKH) {
		super();
		this.maKH = maKH;
	}
	
	public KhachHang(int maKH, String tenKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
	}
	
	public int getMaKH() {
		return maKH;
	}
	
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	
	public String getTenKH() {
		return tenKH;
	}
	
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	
	public String getSdt() {
		return sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public String getCmnd() {
		return cmnd;
	}
	
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	

	public int getMaVe() {
		return maVe;
	}

	public void setMaVe(int maVe) {
		this.maVe = maVe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return maKH == other.maKH;
	}
	
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", cmnd="
				+ cmnd + "]";
	}
}
