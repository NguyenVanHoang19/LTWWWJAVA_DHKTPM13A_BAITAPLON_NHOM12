package fit.se.daos;

import java.util.List;

import fit.se.model.NguoiQuanLy;


public interface NguoiQuanLyDAO {
	public NguoiQuanLy addNguoiQuanLy(NguoiQuanLy nguoiQuanLy);
	public NguoiQuanLy updateNguoiQuanLy(NguoiQuanLy nguoiQuanLy);
	public NguoiQuanLy removeNguoiQuanLy(NguoiQuanLy nguoiQuanLy);
	public List<NguoiQuanLy> getAllNguoiQuanLy();
}
