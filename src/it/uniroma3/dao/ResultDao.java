package it.uniroma3.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Result;

@Repository
public class ResultDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	public Result getResult(Long id) {
		Result result = em.find(Result.class, id);
		return result;
	}
	
	public List<Result> getAllResults() {
		List<Result> listResult = em.createQuery("SELECT r FROM Result r", Result.class).getResultList();
		return listResult;
	}
	
	@Transactional
	public void insertResult(Result result) {
		em.persist(result);
	}
	
	@Transactional
	public void deleteResult(Long id) {
		Result result = em.find(Result.class, id);
		em.remove(result);
	}
}
