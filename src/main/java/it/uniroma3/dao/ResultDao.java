package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Result;

public interface ResultDao {

	public Result getResult(Long id);

	public List<Result> getAllResults();

	public void insertResult(Result result);

	public void deleteResult(Long id);

}