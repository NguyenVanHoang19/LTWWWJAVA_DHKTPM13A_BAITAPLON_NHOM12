package fit.se.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fit.se.daos.NguoiQuanLyDAO;
import fit.se.model.NguoiQuanLy;

@Repository
public class NguoiQuanLyDAOImpl implements NguoiQuanLyDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public NguoiQuanLy addNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nguoiQuanLy);
		return nguoiQuanLy;
	}

	@Override
	public NguoiQuanLy updateNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nguoiQuanLy);
		return nguoiQuanLy;
	}

	@Override
	public NguoiQuanLy removeNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(nguoiQuanLy);
		return nguoiQuanLy;
	}
	@Override
	public List<NguoiQuanLy> getAllNguoiQuanLy() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<NguoiQuanLy> nguoiQuanLies = session.createNativeQuery("select *from NguoiQuanLy", NguoiQuanLy.class).getResultList();
		return nguoiQuanLies;
	}
	
}
