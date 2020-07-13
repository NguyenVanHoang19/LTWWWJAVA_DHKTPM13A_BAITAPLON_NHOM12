package fit.se.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fit.se.daos.SanPhamDAO;
import fit.se.model.SanPham;
import fit.se.service.SanPhamService;
@Service
public class SanPhamServiceImpl implements SanPhamService {
	private SanPhamDAO sanPhamDAO;
	
	public void setSanPhamDAO(SanPhamDAO sanPhamDAO) {
		this.sanPhamDAO = sanPhamDAO;
	}

	@Override
	@Transactional
	public SanPham addSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.addSanPham(sanPham);
	}

	@Override
	@Transactional
	public SanPham updateSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.updateSanPham(sanPham);
	}

	@Override
	@Transactional
	public SanPham removeSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.removeSanPham(sanPham);
	}

	@Override
	@Transactional
	public List<SanPham> getAllSanPham() {
		// TODO Auto-generated method stub
		return sanPhamDAO.getAllSanPham();
	}

	@Override
	@Transactional
	public SanPham getSanPhamByID(int id) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getSanPhamByID(id);
	}

	@Override
	@Transactional
	public List<SanPham> getSanPhamByDanhMuc(int id) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getSanPhamByDanhMuc(id);
	}

	@Override
	@Transactional
	public List<SanPham> getSanPhamByDanhMucByTen(String tenDanhMuc) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getSanPhamByDanhMucByTen(tenDanhMuc);
	}
	@Override
	@Transactional
	public SanPham updateSanPhambyTrangThai(int id) {
		// TODO Auto-generated method stub
		return sanPhamDAO.updateSanPhambyTrangThai(id);
	}
	@Override
	@Transactional
	public List<SanPham> getAllSanPhambyTrangThai() {
		// TODO Auto-generated method stub
		return sanPhamDAO.getAllSanPhambyTrangThai();
	}

	@Override
	@Transactional
	public List<SanPham> getSanPhamByten(String ten) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getSanPhamByten(ten);
	}
}
