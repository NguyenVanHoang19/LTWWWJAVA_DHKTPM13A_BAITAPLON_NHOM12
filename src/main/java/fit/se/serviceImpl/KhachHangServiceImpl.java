package fit.se.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fit.se.daos.KhachHangDAO;
import fit.se.model.KhachHang;
import fit.se.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	private KhachHangDAO khachHangDAO;
	
	public void setKhachHangDAO(KhachHangDAO khachHangDAO) {
		this.khachHangDAO = khachHangDAO;
	}

	@Override
	@Transactional
	public KhachHang addKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return khachHangDAO.addKhachHang(khachHang);
	}

	@Override
	@Transactional
	public KhachHang updateKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return khachHangDAO.updateKhachHang(khachHang);
	}

	@Override
	@Transactional
	public KhachHang removeKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return khachHangDAO.removeKhachHang(khachHang);
	}

	@Override
	@Transactional
	public List<KhachHang> getAllKhachHang() {
		// TODO Auto-generated method stub
		return khachHangDAO.getAllKhachHang();
	}

	@Override
	@Transactional
	public KhachHang getKhachHangByTaiKhoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		return khachHangDAO.getKhachHangByTaiKhoan(tenTaiKhoan);
	}

	@Override
	@Transactional
	public KhachHang getKhachHangById(int id) {
		// TODO Auto-generated method stub
		return khachHangDAO.getKhachHangById(id);
	}
	
}
