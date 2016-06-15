package it.uniroma3.service;

import java.util.Collection;
import java.util.List;

import it.uniroma3.model.Prerequisite;

public interface PrerequisiteService {

	public Prerequisite getPrerequisite(Long id);

	public Collection<Prerequisite> listPrerequisite();

	public void insertPrerequisite(Prerequisite prerequisite);

	public void deletePrerequisite(Long id);

}