package it.uniroma3.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.ExamTypology;

@Repository
public class ExamTypologyDaoImpl implements ExamTypologyDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamTypologyDao#getExamTypology(java.lang.Long)
	 */
	@Override
	public ExamTypology getExamTypology(Long id) {
		ExamTypology typology = em.find(ExamTypology.class, id);
		return typology;
	}

	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamTypologyDao#getAllExamTypologies()
	 */
	
	@Override
	public List<ExamTypology> getAllExamTypologies() {
		List<ExamTypology> listExamTypology = em.createQuery("SELECT e FROM ExamTypology e", ExamTypology.class).getResultList();
		return listExamTypology;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamTypologyDao#insertExamTypology(it.uniroma3.model.ExamTypology)
	 */
	@Override
	@Transactional
	public void insertExamTypology(ExamTypology examTypology) {
		em.persist(examTypology);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamTypologyDao#deleteExamTypology(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteExamTypology(Long id) {
		ExamTypology examTypology = em.find(ExamTypology.class, id);
		em.remove(examTypology);
	}

//	/**
//	 * Creates an ExamTypology object, return it, then persists it.
//	 * @param name, code, description, cost
//	 * @return the created ExamTypology
//	 */
//	public ExamTypology createTypology(String name, String code, String description, float cost) {
//		ExamTypology typology = new ExamTypology(name, code, description, cost);
//		em.persist(typology);
//		return typology;
//	}

}

