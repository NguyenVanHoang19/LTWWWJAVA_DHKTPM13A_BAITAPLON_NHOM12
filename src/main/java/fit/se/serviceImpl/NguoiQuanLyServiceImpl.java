package fit.se.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fit.se.daos.NguoiQuanLyDAO;
import fit.se.model.NguoiQuanLy;
import fit.se.service.NguoiQuanLyService;

@Service
public class NguoiQuanLyServiceImpl implements NguoiQuanLyService {
	private NguoiQuanLyDAO nguoiQuanLyDAO;
	
	public void setNguoiQuanLyDAO(NguoiQuanLyDAO nguoiQuanLyDAO) {
		this.nguoiQuanLyDAO = nguoiQuanLyDAO;
	}

	@Override
	@Transactional
	public NguoiQuanLy addNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		// TODO Auto-generated method stub
		return nguoiQuanLyDAO.addNguoiQuanLy(nguoiQuanLy);
	}

	@Override
	@Transactional
	public NguoiQuanLy updateNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		// TODO Auto-generated method stub
		return nguoiQuanLyDAO.updateNguoiQuanLy(nguoiQuanLy);
	}

	@Override
	@Transactional
	public NguoiQuanLy removeNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		// TODO Auto-generated method stub
		return nguoiQuanLyDAO.removeNguoiQuanLy(nguoiQuanLy);
	}

	@Override
	@Transactional
	public List<NguoiQuanLy> getAllNguoiQuanLy() {
		// TODO Auto-generated method stub
		return nguoiQuanLyDAO.getAllNguoiQuanLy();
	}
	
}
