package fit.se.service;

import java.util.List;

import fit.se.model.NhaCungCap;


public interface NhaCungCapService {
	public NhaCungCap addNhaCungCap(NhaCungCap nhaCungCap);
	public NhaCungCap updateNhaCungCap(NhaCungCap nhaCungCap);
	public NhaCungCap removeNhaCungCap(NhaCungCap nhaCungCap);
	public List<NhaCungCap> getAllNhaCungCap();
	public NhaCungCap getNhaCungCapbyTen(String ten);
}
