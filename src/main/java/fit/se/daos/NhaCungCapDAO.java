package fit.se.daos;

import java.util.List;

import fit.se.model.NhaCungCap;


public interface NhaCungCapDAO {
	public NhaCungCap addNhaCungCap(NhaCungCap nhaCungCap);
	public NhaCungCap updateNhaCungCap(NhaCungCap nhaCungCap);
	public NhaCungCap removeNhaCungCap(NhaCungCap nhaCungCap);
	public List<NhaCungCap> getAllNhaCungCap();
	public NhaCungCap getNhaCungCapbyTen(String ten);
}
