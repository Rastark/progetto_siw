package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.ResultTypology;

public interface ResultTypologyDao {

	public ResultTypology getResultTypology(Long id);

	public List<ResultTypology> getAllResultTypologies();

	public void insertResultTypology(ResultTypology resultTypology);

	public void deleteResultTypology(Long id);

}