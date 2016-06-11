package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Admin;

@Repository
public class AdminDao {
	
	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	public Admin getAdmin(Long id) {
		Admin admin = em.find(Admin.class, id);
		return admin;
	}
	
	public List<Admin> getAllAdmins() {
		List<Admin> listAdmin = em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
		return listAdmin;
	}
	
	@Transactional
	public void insertAdmin(Admin admin) {
		em.persist(admin);
	}
	
	@Transactional
	public void deleteAdmin(Long id) {
		Admin admin = em.find(Admin.class, id);
		em.remove(admin);
	}

}
