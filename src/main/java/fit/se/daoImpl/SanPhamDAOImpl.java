package fit.se.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.SanPhamDAO;
import fit.se.model.SanPham;
@Repository
public class SanPhamDAOImpl implements SanPhamDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public SanPham addSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sanPham);
		return sanPham ;
	}

	@Override
	public SanPham updateSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sanPham);
		return sanPham;
	}

	@Override
	public SanPham removeSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(sanPham);
		return sanPham;
	}

	@Override
	public List<SanPham> getAllSanPham() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<SanPham> sanPhams = session.createNativeQuery("select *from SanPham", SanPham.class).getResultList();
		return sanPhams;
	}
	@Override
	public SanPham getSanPhamByID(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		//SanPham sanPham =(SanPham) session.load(SanPham.class, new Integer(id));
		SanPham sanPham = session.find(SanPham.class, id);	
		return sanPham;
	}
	@Override
	public List<SanPham> getSanPhamByDanhMuc(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<SanPham> lists= session.createNativeQuery("select *from SanPham", SanPham.class).getResultList();
		List<SanPham> sanPhams = new ArrayList<SanPham>();
		for(SanPham sanPham : lists) {
			if(sanPham.getDanhMuc().getMaDanhMuc()==id) {
				sanPhams.add(sanPham);
			}
		}
		return sanPhams;
	}
	@Override
	public List<SanPham> getSanPhamByDanhMucByTen(String tenDanhMuc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.createNativeQuery("select * from [dbo].[SanPham] sp join [dbo].[DanhMuc] dm on sp.MADANHMUC=dm.MADANHMUC where dm.[TENDANHMUC]=N'"+tenDanhMuc+"'", SanPham.class).getResultList();
	}
	@Override
	public SanPham updateSanPhambyTrangThai(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		SanPham s= session.find(SanPham.class, id);
		s.setTrangThai("false");
		session.update(s);
		return s;
	}
	@Override
	public List<SanPham> getAllSanPhambyTrangThai() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<SanPham> sanPhams = session.createNativeQuery("select * from SanPham s where s.trangThai='true'", SanPham.class).getResultList();
		return sanPhams;
	}
	@Override
	public List<SanPham> getSanPhamByten(String ten) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String tenThuong = ten.toLowerCase().trim();
		List<SanPham> list=new ArrayList<SanPham>();
		list = session.createNativeQuery("select *from SanPham", SanPham.class).getResultList();
		List<SanPham> listSP=new ArrayList<SanPham>();
		for(SanPham sanPham : list) {
			if(sanPham.getTenSanPham().toLowerCase().trim().contains(tenThuong)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
}
