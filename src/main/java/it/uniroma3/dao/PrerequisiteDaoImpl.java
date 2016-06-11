package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Prerequisite;

@Repository
public class PrerequisiteDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	public Prerequisite getPrerequisite(Long id) {
		Prerequisite prerequisite = em.find(Prerequisite.class, id);
		return prerequisite;
	}
	
	public List<Prerequisite> getAllPrerequisites() {
		List<Prerequisite> listPrerequisite = em.createQuery("SELECT p FROM Prerequisite p", Prerequisite.class).getResultList();
		return listPrerequisite;
	}
	
	@Transactional 
	public void insertPrerequisite(Prerequisite prerequisite) {
		em.persist(prerequisite);
	}
	
	@Transactional
	public void deletePrerequisite(Long id) {
		Prerequisite prerequisite = em.find(Prerequisite.class, id);
		em.remove(prerequisite);
	}
}
