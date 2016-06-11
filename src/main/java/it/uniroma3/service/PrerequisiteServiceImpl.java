package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PrerequisiteDao;
import it.uniroma3.model.Prerequisite;

@Service
public class PrerequisiteServiceImpl implements PrerequisiteService {

	@Autowired
	private PrerequisiteDao prerequisiteDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PrerequisiteService#getPrerequisite(java.lang.Long)
	 */
	@Override
	public Prerequisite getPrerequisite(Long id) {
		return this.prerequisiteDao.getPrerequisite(id);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PrerequisiteService#listPrerequisite()
	 */
	@Override
	public List<Prerequisite> listPrerequisite() {
		return this.prerequisiteDao.getAllPrerequisites();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PrerequisiteService#insertPrerequisite(it.uniroma3.model.Prerequisite)
	 */
	@Override
	public void insertPrerequisite(Prerequisite prerequisite) {
		this.prerequisiteDao.insertPrerequisite(prerequisite);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.PrerequisiteService#deletePrerequisite(java.lang.Long)
	 */
	@Override
	public void deletePrerequisite(Long id) {
		this.prerequisiteDao.deletePrerequisite(id);
	}
}
