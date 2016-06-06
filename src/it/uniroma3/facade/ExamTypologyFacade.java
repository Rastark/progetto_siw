package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.ExamTypology;

@Stateless
public class ExamTypologyFacade {

	public ExamTypologyFacade() {}

	@PersistenceContext(unitName = "placeholder")
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
	
	public List<ExamTypology> getAllTypologies() {
		CriteriaQuery<ExamTypology> cq = em.getCriteriaBuilder().createQuery(ExamTypology.class);
		cq.select(cq.from(ExamTypology.class));
		List<ExamTypology> typologiesList = em.createQuery(cq).getResultList();
		return typologiesList;
	}
	
	
}

