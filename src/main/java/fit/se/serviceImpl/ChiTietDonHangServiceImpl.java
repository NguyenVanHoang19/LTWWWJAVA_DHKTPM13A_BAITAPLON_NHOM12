package fit.se.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fit.se.daos.ChiTietDonHangDAO;
import fit.se.model.ChiTietDonHang;
import fit.se.service.ChiTietDonHangService;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService {
	private ChiTietDonHangDAO chiTietDonHangDAO;
	
	public void setChiTietDonHangDAO(ChiTietDonHangDAO chiTietDonHangDAO) {
		this.chiTietDonHangDAO = chiTietDonHangDAO;
	}

	@Override
	@Transactional
	public ChiTietDonHang addChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		// TODO Auto-generated method stub
		return chiTietDonHangDAO.addChiTietDonHang(chiTietDonHang);
	}

	@Override
	@Transactional
	public ChiTietDonHang updateChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		// TODO Auto-generated method stub
		return chiTietDonHangDAO.updateChiTietDonHang(chiTietDonHang);
	}

	@Override
	@Transactional
	public ChiTietDonHang removeChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		// TODO Auto-generated method stub
		return chiTietDonHangDAO.removeChiTietDonHang(chiTietDonHang);
	}

	@Override
	@Transactional
	public List<ChiTietDonHang> getAllChiTietDonHang() {
		// TODO Auto-generated method stub
		return chiTietDonHangDAO.getAllChiTietDonHang();
	}
	@Override
	@Transactional
	public List<ChiTietDonHang> getAllChiTietDonHangbyDonHang(int maDonHang) {
		// TODO Auto-generated method stub
		return chiTietDonHangDAO.getAllChiTietDonHangbyDoHang(maDonHang);
	}
	@Override
	@Transactional
	public ChiTietDonHang getChiTietbyDHSP(int maDonHang, int maSanPham) {
		// TODO Auto-generated method stub
		return chiTietDonHangDAO.getChiTietbyDHSP(maDonHang, maSanPham);
	}
}
