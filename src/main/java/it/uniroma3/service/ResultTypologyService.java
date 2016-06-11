package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.ResultTypology;

public interface ResultTypologyService {

	public ResultTypology getResultTypology(Long id);

	public List<ResultTypology> listResultTypology();

	public void insertResultTypology(ResultTypology resultTypology);

	public void deleteResultTypology(Long id);

}