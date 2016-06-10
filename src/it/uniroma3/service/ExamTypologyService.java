package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.ExamTypologyDao;
import it.uniroma3.model.ExamTypology;

@Service
public class ExamTypologyService {

	@Autowired
	private ExamTypologyDao examTypologyDao;
	
	public List<ExamTypology> listExamTypology() {
		return this.examTypologyDao.getAllExamTypologies();
	}
	
	public void insertExamTypology(ExamTypology examTypology) {
		this.examTypologyDao.insertExamTypology();
	}
	
	public void deleteExamTypology(Long id) {
		this.examTypologyDao.deleteExamTypology();
	}
}