package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.MedicDao;
import it.uniroma3.model.Medic;

@Service
public class MedicService {

	@Autowired
	private MedicDao medicDao;
	
	public Medic getMedic(Long id) {
		return this.medicDao.getMedic(id);
	}
	
	public List<Medic> listMedic() {
		return this.medicDao.getAllMedics();
	}
	
	public void insertMedic(Medic medic) {
		this.medicDao.insertMedic(medic);
	}
	
	public void deleteMedic(Long id) {
		this.medicDao.deleteMedic(id);
	}
}
