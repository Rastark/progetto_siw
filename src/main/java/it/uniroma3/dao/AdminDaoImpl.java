package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Admin;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AdminDaoImpl implements AdminDao {
	
//	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.AdminDao#getAdmin(java.lang.Long)
	 */
	@Override
	public Admin getAdmin(Long id) {
		Admin admin = em.find(Admin.class, id);
		return admin;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.AdminDao#getAllAdmins()
	 */
	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> listAdmin = em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
		return listAdmin;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.AdminDao#insertAdmin(it.uniroma3.model.Admin)
	 */
	@Override
	public void insertAdmin(Admin admin) {
		em.persist(admin);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.AdminDao#deleteAdmin(java.lang.Long)
	 */
	@Override
	public void deleteAdmin(Long id) {
		Admin admin = em.find(Admin.class, id);
		em.remove(admin);
	}

}
