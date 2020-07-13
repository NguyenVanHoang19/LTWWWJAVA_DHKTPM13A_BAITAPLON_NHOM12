package fit.se.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.DonHangDAO;
import fit.se.model.DonHang;
@Repository
public class DonHangDAOImpl implements DonHangDAO {
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public DonHang addKDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(donHang);
		return donHang;
	}

	@Override
	public DonHang updateDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(donHang);
		return donHang;
	}

	@Override
	public DonHang removeDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(donHang);
		return donHang;
	}
	@Override
	public List<DonHang> getAllDonHang() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<DonHang> donHangs = session.createNativeQuery("select *from DonHang", DonHang.class).getResultList();
		return donHangs;
	}
	@Override
	public int getIdMax() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<DonHang> list = session.createNativeQuery("select *from DonHang", DonHang.class).getResultList();
		int maxId = 1 ;
		for(DonHang dh : list) {
			if(maxId < dh.getMaDonHang()) {
				maxId = dh.getMaDonHang();
			}
		}
		return maxId;
	}
	@Override
	public List<DonHang> getAllDonHangbyMaKhachHang(int maKhachHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<DonHang> donHangs = session.createNativeQuery("select * from DonHang d where d.MAKHACHHANG="+maKhachHang+"", DonHang.class).getResultList();
		return donHangs;
	}
}
