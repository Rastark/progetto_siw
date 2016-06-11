package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.ExamTypology;

public interface ExamTypologyService{

	public ExamTypology getExamTypology(Long id);

	public List<ExamTypology> listExamTypology();

	public void insertExamTypology(ExamTypology examTypology);

	public void deleteExamTypology(Long id);

}