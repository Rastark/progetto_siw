package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Prerequisite;

@Repository
public class PrerequisiteDaoImpl implements PrerequisiteDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PrerequisiteDao#getPrerequisite(java.lang.Long)
	 */
	@Override
	public Prerequisite getPrerequisite(Long id) {
		Prerequisite prerequisite = em.find(Prerequisite.class, id);
		return prerequisite;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PrerequisiteDao#getAllPrerequisites()
	 */
	@Override
	public List<Prerequisite> getAllPrerequisites() {
		List<Prerequisite> listPrerequisite = em.createQuery("SELECT p FROM Prerequisite p", Prerequisite.class).getResultList();
		return listPrerequisite;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PrerequisiteDao#insertPrerequisite(it.uniroma3.model.Prerequisite)
	 */
	@Override
	@Transactional 
	public void insertPrerequisite(Prerequisite prerequisite) {
		em.persist(prerequisite);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PrerequisiteDao#deletePrerequisite(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deletePrerequisite(Long id) {
		Prerequisite prerequisite = em.find(Prerequisite.class, id);
		em.remove(prerequisite);
	}
}
