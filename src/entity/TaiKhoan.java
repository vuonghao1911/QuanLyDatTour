package entity;
/**
 * 
 * @author Vuong Hao
 *
 */
public class TaiKhoan {
	private int tenDN; /// tenDN la maNV
	private String  maKhau;  // matKhau mac dinh la sdt nhan vien
	private int quyen ; // 0. quan ly || 1.nhan vien
	public TaiKhoan(int tenDN, String maKhau, int quyen) {
		super();
		this.tenDN = tenDN;
		this.maKhau = maKhau;
		this.quyen = quyen;
	}
	public int getTenDN() {
		return tenDN;
	}
	public void setTenDN(int tenDN) {
		this.tenDN = tenDN;
	}
	public String getMaKhau() {
		return maKhau;
	}
	public void setMaKhau(String maKhau) {
		this.maKhau = maKhau;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenDN=" + tenDN + ", maKhau=" + maKhau + ", quyen=" + quyen + "]";
	}
	
	
}
