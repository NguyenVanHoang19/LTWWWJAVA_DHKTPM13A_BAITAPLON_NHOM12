package fit.se.daos;

import java.util.List;

import fit.se.model.SanPham;

public interface SanPhamDAO {
	public SanPham addSanPham(SanPham sanPham);
	public SanPham updateSanPham(SanPham sanPham);
	public SanPham removeSanPham(SanPham sanPham);
	public List<SanPham> getAllSanPham();
	public SanPham getSanPhamByID(int id);
	public List<SanPham> getSanPhamByDanhMuc(int id);
	public List<SanPham> getSanPhamByDanhMucByTen(String tenDanhMuc);
	public SanPham updateSanPhambyTrangThai(int id);
	public List<SanPham> getAllSanPhambyTrangThai();
	public List<SanPham> getSanPhamByten(String ten);
}
