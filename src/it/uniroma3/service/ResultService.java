package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.ResultDao;
import it.uniroma3.model.Result;

@Service
public class ResultService {

	@Autowired
	private ResultDao resultDao;
	
	public Result getResult(Long id) {
		return this.resultDao.getResult(id);
	}
	
	public List<Result> listResult() {
		return this.resultDao.getAllResults();
	}
	
	public void insertResult(Result result) {
		this.resultDao.insertResult(result);
	}
	
	public void deleteResult(Long id) {
		this.resultDao.deleteResult(id);
	}
}
