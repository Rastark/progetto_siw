package it.uniroma3.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Result;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ResultDaoImpl implements ResultDao {

//	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultDao#getResult(java.lang.Long)
	 */
	@Override
	public Result getResult(Long id) {
		Result result = em.find(Result.class, id);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultDao#getAllResults()
	 */
	@Override
	public List<Result> getAllResults() {
		List<Result> listResult = em.createQuery("SELECT r FROM Result r", Result.class).getResultList();
		return listResult;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultDao#insertResult(it.uniroma3.model.Result)
	 */
	@Override
	public void insertResult(Result result) {
		em.persist(result);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ResultDao#deleteResult(java.lang.Long)
	 */
	@Override
	public void deleteResult(Long id) {
		Result result = em.find(Result.class, id);
		em.remove(result);
	}
}
