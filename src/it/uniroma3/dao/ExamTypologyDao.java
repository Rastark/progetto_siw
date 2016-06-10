package it.uniroma3.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import it.uniroma3.model.ExamTypology;

@Repository
public class ExamTypologyDao {

	public ExamTypologyDao() {}

	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;

	/**
	 * Creates an ExamTypology object, return it, then persists it.
	 * @param name, code, description, cost
	 * @return the created ExamTypology
	 */
	public ExamTypology createTypology(String name, String code, String description, float cost) {
		ExamTypology typology = new ExamTypology(name, code, description, cost);
		em.persist(typology);
		return typology;
	}

	/**
	 * Gets an ExamTypology from its id
	 * @param id
	 * @return the typology with the requested id
	 */
	public ExamTypology getTypology(Long id) {
		ExamTypology typology = em.find(ExamTypology.class, id);
		return typology;
	}

	/**
	 * Gets all typologies in the database
	 * @return
	 */
	
	public List<ExamTypology> getAllExamTypologies() {
		CriteriaQuery<ExamTypology> cq = em.getCriteriaBuilder().createQuery(ExamTypology.class);
		cq.select(cq.from(ExamTypology.class));
		List<ExamTypology> typologiesList = em.createQuery(cq).getResultList();
		return typologiesList;
	}

}

