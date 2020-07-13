package fit.se.daos;

import java.util.List;

import fit.se.model.DonHang;

public interface DonHangDAO {
	public DonHang addKDonHang(DonHang donHang);
	public DonHang updateDonHang(DonHang donHang);
	public DonHang removeDonHang(DonHang donHang);
	public List<DonHang> getAllDonHang();
	public int getIdMax();
	public List<DonHang> getAllDonHangbyMaKhachHang(int maKhacHang);
}
