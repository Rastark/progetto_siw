package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.ResultTypologyDao;
import it.uniroma3.model.ResultTypology;

@Service
public class ResultTypologyService {

	@Autowired
	private ResultTypologyDao resultTypologyDao;
	
	public ResultTypology getResultTypology(Long id) {
		return this.resultTypologyDao.getResultTypology(id);
	}
	
	public List<ResultTypology> listResultTypology() {
		return this.resultTypologyDao.getAllResultTypologies();
	}
	
	public void insertResultTypology(ResultTypology resultTypology) {
		this.resultTypologyDao.insertResultTypology(resultTypology);
	}
	
	public void deleteResultTypology(Long id) {
		this.resultTypologyDao.deleteResultTypology(id);
	}
}
