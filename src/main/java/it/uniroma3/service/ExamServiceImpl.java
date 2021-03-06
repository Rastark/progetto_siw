package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.ExamDao;
import it.uniroma3.model.Exam;

@Service
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private ExamDao examDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamService#getExam(java.lang.Long)
	 */
	@Override
	public Exam getExam(Long id) {
		return this.examDao.getExam(id);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamService#listExam()
	 */
	@Override
	public List<Exam> listExam() {
		return this.examDao.getAllExams();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamService#insertExam(it.uniroma3.model.Exam)
	 */
	@Override
	@Transactional
	public void insertExam(Exam exam) {
		this.examDao.insertExam(exam);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamService#deleteExam(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteExam(Long id) {
		this.examDao.deleteExam(id);
	}
	

}
