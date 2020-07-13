package fit.se.daos;

import java.util.List;

import fit.se.model.KhachHang;


public interface KhachHangDAO {
	public KhachHang addKhachHang(KhachHang khachHang);
	public KhachHang updateKhachHang(KhachHang khachHang);
	public KhachHang removeKhachHang(KhachHang khachHang);
	public List<KhachHang> getAllKhachHang();
	public KhachHang getKhachHangByTaiKhoan(String tenTaiKhoan);
	public KhachHang getKhachHangById(int id);
}
