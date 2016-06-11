package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Patient;

public interface PatientService {

	public Patient getPatient(Long id);

	public List<Patient> listPatient();

	public void insertPatient(Patient patient);

	public void deletePatient(Long id);

}