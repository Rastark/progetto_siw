package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.ExamTypology;

public interface ExamTypologyDao {

	/**
	 * Gets an ExamTypology from its id
	 * @param id
	 * @return the typology with the requested id
	 */
	public ExamTypology getExamTypology(Long id);

	/**
	 * Gets all typologies in the database
	 * @return
	 */

	public List<ExamTypology> getAllExamTypologies();

	public void insertExamTypology(ExamTypology examTypology);

	public void deleteExamTypology(Long id);

}