package fit.se.service;

import java.util.List;

import fit.se.model.DonHang;

public interface DonHangService {
	public DonHang addKDonHang(DonHang donHang);
	public DonHang updateDonHang(DonHang donHang);
	public DonHang removeDonHang(DonHang donHang);
	public List<DonHang> getAllDonHang();
	public int getIdMax();
	public List<DonHang> getAllDonHangbyMaKhachHang(int maKhacHang);
}
