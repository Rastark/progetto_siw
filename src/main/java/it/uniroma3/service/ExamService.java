package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.ExamDao;
import it.uniroma3.model.Exam;

@Service
public class ExamService {
	
	@Autowired
	private ExamDao examDao;
	
	public Exam getExam(Long id) {
		return this.examDao.getExam(id);
	}
	
	public List<Exam> listExam() {
		return this.examDao.getAllExams();
	}
	
	public void insertExam(Exam exam) {
		this.examDao.insertExam(exam);
	}
	
	public void deleteExam(Long id) {
		this.examDao.deleteExam(id);
	}
	

}
