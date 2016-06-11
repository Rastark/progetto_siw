package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Medic;

@Repository
public class MedicDaoImpl implements MedicDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.MedicDao#getMedic(java.lang.Long)
	 */
	@Override
	public Medic getMedic(Long id) {
		Medic medic = em.find(Medic.class, id);
		return medic;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.MedicDao#getAllMedics()
	 */
	@Override
	public List<Medic> getAllMedics() {
		List<Medic> listMedic = em.createQuery("SELECT m FROM Medic m", Medic.class).getResultList();
		return listMedic;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.MedicDao#insertMedic(it.uniroma3.model.Medic)
	 */
	@Override
	@Transactional
	public void insertMedic(Medic medic) {
		em.persist(medic);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.MedicDao#deleteMedic(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteMedic(Long id) {
		Medic medic = em.find(Medic.class, id);
		em.remove(medic);
	}
}
