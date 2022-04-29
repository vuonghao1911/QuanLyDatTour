package entity;

public class KhachHang {
	private int maKH;
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
	public KhachHang(int maKH) {
		super();
		this.maKH = maKH;
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
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", cmnd="
				+ cmnd + "]";
	}

	
}
