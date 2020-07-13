package fit.se.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.DanhMucDAO;
import fit.se.model.DanhMuc;

@Repository
public class DanhMucDAOImpl implements DanhMucDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public DanhMuc addDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(danhMuc);
		return danhMuc;
	}

	@Override
	public DanhMuc updateDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(danhMuc);
		return danhMuc;
	}

	@Override
	public DanhMuc removeDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(danhMuc);
		return danhMuc;
	}
	@Override
	public List<DanhMuc> getAllDanhMuc() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<DanhMuc> danhMucs = session.createNativeQuery("select *from DanhMuc", DanhMuc.class).getResultList();
		return danhMucs;
	}
	@Override
	public DanhMuc getDanhMucbyTen(String ten) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<DanhMuc> list= session.createNativeQuery("select * from DanhMuc d where d.tenDanhMuc= N'"+ten+"'",DanhMuc.class).getResultList();
		DanhMuc d=list.get(0);
		return d;
	}
}
