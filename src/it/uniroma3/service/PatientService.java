package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PatientDao;
import it.uniroma3.model.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;
	
	public Patient getPatient(Long id) {
		return this.patientDao.getPatient(id);
	}
	
	public List<Patient> listPatient() {
		return this.patientDao.getAllPatients();
	}
	
	public void insertPatient(Patient patient) {
		this.patientDao.insertPatient(patient);
	}
	
	public void deletePatient(Long id) {
		this.patientDao.deletePatient(id);
	}
}
