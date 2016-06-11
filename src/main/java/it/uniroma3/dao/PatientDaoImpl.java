package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PatientDao#getPatient(java.lang.Long)
	 */
	@Override
	public Patient getPatient(Long id) {
		Patient patient = em.find(Patient.class, id);
		return patient;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PatientDao#getAllPatients()
	 */
	@Override
	public List<Patient> getAllPatients() {
		List<Patient> listPatient = em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
		return listPatient;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PatientDao#insertPatient(it.uniroma3.model.Patient)
	 */
	@Override
	@Transactional
	public void insertPatient(Patient patient) {
		em.persist(patient);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.PatientDao#deletePatient(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deletePatient(Long id) {
		Patient patient = em.find(Patient.class, id);
		em.remove(patient);
	}
}
