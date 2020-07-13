package fit.se.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.TaiKhoanDAO;
import fit.se.model.TaiKhoan;
@Repository
public class TaiKhoanDAOImpl implements TaiKhoanDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(taiKhoan);
		return taiKhoan;
	}

	@Override
	public TaiKhoan updateTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(taiKhoan);
		return taiKhoan;
	}

	@Override
	public TaiKhoan removeTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(taiKhoan);
		return taiKhoan;
	}

	@Override
	public List<TaiKhoan> getAllTaiKhoan() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TaiKhoan> taiKhoans = session.createNativeQuery("select *from TaiKhoan", TaiKhoan.class).getResultList();
		return taiKhoans;
	}
	@Override
	public List<TaiKhoan> getTaiKhoanByIDAndMK(String tenTaiKhoan, String matKhau) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.createNativeQuery("select *from dbo.TaiKhoan where TenTaiKhoan = '"+tenTaiKhoan+"' and MATKHAU='"+matKhau+"'", TaiKhoan.class).getResultList();
	}
	
}
