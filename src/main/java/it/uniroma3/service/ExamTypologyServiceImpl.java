package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.ExamTypologyDao;
import it.uniroma3.model.ExamTypology;

@Service
public class ExamTypologyServiceImpl implements ExamTypologyService {

	@Autowired
	private ExamTypologyDao examTypologyDao;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamTypology#getExamTypology(java.lang.Long)
	 */
	@Override
	public ExamTypology getExamTypology(Long id) {
		return this.examTypologyDao.getExamTypology(id);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamTypology#listExamTypology()
	 */
	@Override
	public List<ExamTypology> listExamTypology() {
		return this.examTypologyDao.getAllExamTypologies();
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamTypology#insertExamTypology(it.uniroma3.model.ExamTypology)
	 */
	@Override
	public void insertExamTypology(ExamTypology examTypology) {
		this.examTypologyDao.insertExamTypology(examTypology);
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.service.ExamTypology#deleteExamTypology(java.lang.Long)
	 */
	@Override
	public void deleteExamTypology(Long id) {
		this.examTypologyDao.deleteExamTypology(id);
	}
}
