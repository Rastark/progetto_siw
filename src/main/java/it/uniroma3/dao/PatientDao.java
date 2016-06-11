package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Patient;

public interface PatientDao {

	public Patient getPatient(Long id);

	public List<Patient> getAllPatients();

	public void insertPatient(Patient patient);

	public void deletePatient(Long id);

}