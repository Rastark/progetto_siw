package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.ResultTypology;

@Repository
public class ResultTypologyDao {
	
	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	public ResultTypology getResultTypology(Long id) {
		ResultTypology resultTypology = em.find(ResultTypology.class, id);
		return resultTypology;
	}
	
	public List<ResultTypology> getAllResultTypologies() {
		List<ResultTypology> listResultTypology = em.createQuery("SELECT r FROM ResultTypology r", ResultTypology.class).getResultList();
		return listResultTypology;
	}
	
	@Transactional
	public void insertResultTypology(ResultTypology resultTypology) {
		em.persist(resultTypology);
	}
	
	@Transactional
	public void deleteResultTypology(Long id) {
		ResultTypology resultTypology = em.find(ResultTypology.class, id);
		em.remove(resultTypology);
	}

}
