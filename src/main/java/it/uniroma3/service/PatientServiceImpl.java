package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PatientDao;
import it.uniroma3.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PatientService#getPatient(java.lang.Long)
	 */
	@Override
	public Patient getPatient(Long id) {
		return this.patientDao.getPatient(id);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PatientService#listPatient()
	 */
	@Override
	public List<Patient> listPatient() {
		return this.patientDao.getAllPatients();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PatientService#insertPatient(it.uniroma3.model.Patient)
	 */
	@Override
	public void insertPatient(Patient patient) {
		this.patientDao.insertPatient(patient);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PatientService#deletePatient(java.lang.Long)
	 */
	@Override
	public void deletePatient(Long id) {
		this.patientDao.deletePatient(id);
	}
}
