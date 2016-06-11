package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Exam;

public interface ExamService {

	public Exam getExam(Long id);

	public List<Exam> listExam();

	public void insertExam(Exam exam);

	public void deleteExam(Long id);

}