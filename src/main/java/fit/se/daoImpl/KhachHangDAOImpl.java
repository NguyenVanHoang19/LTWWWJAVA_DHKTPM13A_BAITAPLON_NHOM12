package fit.se.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.KhachHangDAO;
import fit.se.model.KhachHang;

@Repository
public class KhachHangDAOImpl implements KhachHangDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public KhachHang addKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(khachHang);
		return khachHang;
	}

	@Override
	public KhachHang updateKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachHang);
		return khachHang;
	}

	@Override
	public KhachHang removeKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(khachHang);
		return khachHang;
	}
	@Override
	public List<KhachHang> getAllKhachHang() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> khachHangs = session.createNativeQuery("select *from KhachHang", KhachHang.class).getResultList();
		return khachHangs;
	}
	@Override
	public KhachHang getKhachHangByTaiKhoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		KhachHang khachHang = null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		list = session.createNativeQuery("select *from dbo.KhachHang where TENTAIKHOAN = '"+tenTaiKhoan+"'", KhachHang.class).getResultList();
		for(KhachHang kh : list ) {
			khachHang = kh;
		}
		if(khachHang==null)
			return null;
		else
			return khachHang;
	}
	@Override
	public KhachHang getKhachHangById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		KhachHang khachHang =(KhachHang) session.load(KhachHang.class, new Integer(id));
		return khachHang;
	}
	
}
