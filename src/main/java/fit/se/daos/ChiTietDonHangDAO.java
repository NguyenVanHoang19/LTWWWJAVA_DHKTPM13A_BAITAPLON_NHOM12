package fit.se.daos;

import java.util.List;

import fit.se.model.ChiTietDonHang;


public interface ChiTietDonHangDAO {
	public ChiTietDonHang addChiTietDonHang(ChiTietDonHang chiTietDonHang);
	public ChiTietDonHang updateChiTietDonHang(ChiTietDonHang chiTietDonHang);
	public ChiTietDonHang removeChiTietDonHang(ChiTietDonHang chiTietDonHang);
	public List<ChiTietDonHang> getAllChiTietDonHang();
	public List<ChiTietDonHang> getAllChiTietDonHangbyDoHang(int maDonHang);
	public ChiTietDonHang getChiTietbyDHSP(int maDonHang,int maSanPham);
}
