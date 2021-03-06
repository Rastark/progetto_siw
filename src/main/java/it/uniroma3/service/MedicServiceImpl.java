package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.MedicDao;
import it.uniroma3.model.Medic;

@Service
public class MedicServiceImpl implements MedicService {

	@Autowired
	private MedicDao medicDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.MedicService#getMedic(java.lang.Long)
	 */
	@Override
	public Medic getMedic(String name, String surname) {
		return this.medicDao.getMedic(name, surname);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.MedicService#listMedic()
	 */
	@Override
	public List<Medic> listMedic() {
		return this.medicDao.getAllMedics();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.MedicService#insertMedic(it.uniroma3.model.Medic)
	 */
	@Override
	@Transactional
	public void insertMedic(Medic medic) {
		this.medicDao.insertMedic(medic);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.MedicService#deleteMedic(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteMedic(Long id) {
		this.medicDao.deleteMedic(id);
	}
}