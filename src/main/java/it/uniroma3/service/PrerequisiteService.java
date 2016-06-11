package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PrerequisiteDao;
import it.uniroma3.model.Prerequisite;

@Service
public class PrerequisiteService {

	@Autowired
	private PrerequisiteDao prerequisiteDao;
	
	public Prerequisite getPrerequisite(Long id) {
		return this.prerequisiteDao.getPrerequisite(id);
	}
	
	public List<Prerequisite> listPrerequisite() {
		return this.prerequisiteDao.getAllPrerequisites();
	}
	
	public void insertPrerequisite(Prerequisite prerequisite) {
		this.prerequisiteDao.insertPrerequisite(prerequisite);
	}
	
	public void deletePrerequisite(Long id) {
		this.prerequisiteDao.deletePrerequisite(id);
	}
}
