package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Result;

public interface ResultService {

	public Result getResult(Long id);

	public List<Result> listResult();

	public void insertResult(Result result);

	public void deleteResult(Long id);

}