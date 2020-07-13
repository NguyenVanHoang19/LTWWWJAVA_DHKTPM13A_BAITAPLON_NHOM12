package fit.se.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fit.se.daos.TaiKhoanDAO;
import fit.se.model.TaiKhoan;
import fit.se.service.TaiKhoanService;
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
	private TaiKhoanDAO taiKhoanDAO;
	
	public void setTaiKhoanDAO(TaiKhoanDAO taiKhoanDAO) {
		this.taiKhoanDAO = taiKhoanDAO;
	}

	@Override
	@Transactional
	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.addTaiKhoan(taiKhoan);
	}

	@Override
	@Transactional
	public TaiKhoan updateTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.updateTaiKhoan(taiKhoan);
	}

	@Override
	@Transactional
	public TaiKhoan removeTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.removeTaiKhoan(taiKhoan);
	}

	@Override
	@Transactional
	public List<TaiKhoan> getAllTaiKhoan() {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getAllTaiKhoan();
	}

	@Override
	@Transactional
	public List<TaiKhoan> getTaiKhoanByIDAndMK(String tenTaiKhoan, String matKhau) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getTaiKhoanByIDAndMK(tenTaiKhoan, matKhau);
	}
	
}
