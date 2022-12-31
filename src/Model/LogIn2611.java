package Model;

import java.util.Objects;

public class LogIn2611 {
	private String tenDangNhap;
	private String matKhau;
	
	public LogIn2611() {
		super();
		tenDangNhap = "TranVanAnh";
		matKhau = "12062003";
	}

	public LogIn2611(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matKhau, tenDangNhap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogIn2611 other = (LogIn2611) obj;
		return Objects.equals(matKhau, other.matKhau) && Objects.equals(tenDangNhap, other.tenDangNhap);
	}
	
	
	
}
