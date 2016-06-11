package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Patient;

@Repository
public class PatientDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	public Patient getPatient(Long id) {
		Patient patient = em.find(Patient.class, id);
		return patient;
	}
	
	public List<Patient> getAllPatients() {
		List<Patient> listPatient = em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
		return listPatient;
	}
	
	@Transactional
	public void insertPatient(Patient patient) {
		em.persist(patient);
	}
	
	@Transactional
	public void deletePatient(Long id) {
		Patient patient = em.find(Patient.class, id);
		em.remove(patient);
	}
}
