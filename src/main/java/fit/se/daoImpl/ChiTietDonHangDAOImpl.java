package fit.se.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.ChiTietDonHangDAO;
import fit.se.model.ChiTietDonHang;

@Repository
public class ChiTietDonHangDAOImpl implements ChiTietDonHangDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public ChiTietDonHang addChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(chiTietDonHang);
		return chiTietDonHang;
	}
	@Override
	public ChiTietDonHang updateChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(chiTietDonHang);
		return chiTietDonHang;
	}

	@Override
	public ChiTietDonHang removeChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(chiTietDonHang);
		return chiTietDonHang;
	}
	@Override
	public List<ChiTietDonHang> getAllChiTietDonHang() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<ChiTietDonHang> chiTietDonHangs = session.createNativeQuery("select *from ChiTietDonHang", ChiTietDonHang.class).getResultList();
		return chiTietDonHangs;
	}
	@Override
	public List<ChiTietDonHang> getAllChiTietDonHangbyDoHang(int maDonHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<ChiTietDonHang> chiTietDonHangs = session.createNativeQuery("select * from ChiTietDonHang c where c.MADONHANG="+maDonHang+"", ChiTietDonHang.class).getResultList();
		return chiTietDonHangs;
	}
	@Override
	public ChiTietDonHang getChiTietbyDHSP(int maDonHang, int maSanPham) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createNativeQuery("Select * from ChiTietDonHang c where c.MADONHANG="+maDonHang+" and c.MASANPHAM="+maSanPham+"", ChiTietDonHang.class).getResultList().get(0);
	}
}
