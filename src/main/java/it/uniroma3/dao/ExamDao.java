package it.uniroma3.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Exam;

public interface ExamDao {

	public Exam getExam(Long id);

	public List<Exam> getAllExams();

	public void insertExam(Exam exam);

	public void deleteExam(Long id);

}