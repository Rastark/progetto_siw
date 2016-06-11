package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Prerequisite;

public interface PrerequisiteDao {

	public Prerequisite getPrerequisite(Long id);

	public List<Prerequisite> getAllPrerequisites();

	public void insertPrerequisite(Prerequisite prerequisite);

	public void deletePrerequisite(Long id);

}