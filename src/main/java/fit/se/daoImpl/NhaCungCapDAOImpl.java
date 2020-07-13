package fit.se.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.NhaCungCapDAO;
import fit.se.model.NhaCungCap;

@Repository
public class NhaCungCapDAOImpl implements NhaCungCapDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public NhaCungCap addNhaCungCap(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nhaCungCap);
		return nhaCungCap;
	}

	@Override
	public NhaCungCap updateNhaCungCap(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nhaCungCap);
		return nhaCungCap;
	}

	@Override
	public NhaCungCap removeNhaCungCap(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(nhaCungCap);
		return nhaCungCap;
	}

	@Override
	public List<NhaCungCap> getAllNhaCungCap() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<NhaCungCap> nhaCungCaps = session.createNativeQuery("select *from NhaCungCap", NhaCungCap.class).getResultList();
		return nhaCungCaps;
	}
	@Override
	public NhaCungCap getNhaCungCapbyTen(String ten) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return (NhaCungCap) session.createNativeQuery("select * from NhaCungCap n where n.tenNhaCungCap= N'"+ten+"'",NhaCungCap.class).getResultList().get(0);
	}
}
