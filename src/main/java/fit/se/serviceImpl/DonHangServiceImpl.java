package fit.se.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fit.se.daos.DonHangDAO;
import fit.se.model.DonHang;
import fit.se.service.DonHangService;
@Service
public class DonHangServiceImpl implements DonHangService {
	private DonHangDAO donHangDAO;
	
	public void setDonHangDAO(DonHangDAO donHangDAO) {
		this.donHangDAO = donHangDAO;
	}

	@Override
	@Transactional
	public DonHang addKDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangDAO.addKDonHang(donHang);
	}

	@Override
	@Transactional
	public DonHang updateDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangDAO.updateDonHang(donHang);
	}

	@Override
	@Transactional
	public DonHang removeDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangDAO.removeDonHang(donHang);
	}

	@Override
	@Transactional
	public List<DonHang> getAllDonHang() {
		// TODO Auto-generated method stub
		return donHangDAO.getAllDonHang();
	}

	@Override
	@Transactional
	public int getIdMax() {
		// TODO Auto-generated method stub
		return donHangDAO.getIdMax();
	}
	@Override
	@Transactional
	public List<DonHang> getAllDonHangbyMaKhachHang(int maKhacHang) {
		// TODO Auto-generated method stub
		return donHangDAO.getAllDonHangbyMaKhachHang(maKhacHang);
	}
}
