package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.ResultTypology;

@Repository
public class ResultTypologyDaoImpl implements ResultTypologyDao {
	
//	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultTypologyDao#getResultTypology(java.lang.Long)
	 */
	@Override
	public ResultTypology getResultTypology(Long id) {
		ResultTypology resultTypology = em.find(ResultTypology.class, id);
		return resultTypology;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultTypologyDao#getAllResultTypologies()
	 */
	@Override
	public List<ResultTypology> getAllResultTypologies() {
		List<ResultTypology> listResultTypology = em.createQuery("SELECT r FROM ResultTypology r", ResultTypology.class).getResultList();
		return listResultTypology;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultTypologyDao#insertResultTypology(it.uniroma3.model.ResultTypology)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertResultTypology(ResultTypology resultTypology) {
		em.persist(resultTypology);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultTypologyDao#deleteResultTypology(java.lang.Long)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteResultTypology(Long id) {
		ResultTypology resultTypology = em.find(ResultTypology.class, id);
		em.remove(resultTypology);
	}

}
