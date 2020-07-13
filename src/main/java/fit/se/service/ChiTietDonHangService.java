package fit.se.service;

import java.util.List;

import fit.se.model.ChiTietDonHang;


public interface ChiTietDonHangService {
	public ChiTietDonHang addChiTietDonHang(ChiTietDonHang chiTietDonHang);
	public ChiTietDonHang updateChiTietDonHang(ChiTietDonHang chiTietDonHang);
	public ChiTietDonHang removeChiTietDonHang(ChiTietDonHang chiTietDonHang);
	public List<ChiTietDonHang> getAllChiTietDonHang();
	public List<ChiTietDonHang> getAllChiTietDonHangbyDonHang(int maDonHang);
	public ChiTietDonHang getChiTietbyDHSP(int maDonHang,int maSanPham);
}
