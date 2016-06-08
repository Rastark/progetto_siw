package it.uniroma3.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Exam;
import it.uniroma3.model.ExamTypology;

@Stateless
public class ExamFacade {

	@PersistenceContext(unitName="dawnstone")
	private EntityManager em;
	
	public ExamFacade() {}
	
	/** Creates an exam of the selected typology, the exam is persisted
	 */
	public Exam createExam(ExamTypology et, String visitDate) throws ParseException {
		Exam exam = new Exam();
		exam.setEt(et);
		Date creationTime = new Date();
		exam.setPrenotationDate(creationTime);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date vd = sdf.parse(visitDate);
		exam.setVisitDate(vd);
		em.persist(exam);
		return exam;
	}
	
	public Exam getExam(Long id) {
		Exam exam = em.find(Exam.class, id);
		return exam;
	}
	
	public List<Exam> getAllExams () {
		CriteriaQuery<Exam> cq = em.getCriteriaBuilder().createQuery(Exam.class);
		cq.select(cq.from(Exam.class));
		List<Exam> examsList = em.createQuery(cq).getResultList();
		return examsList;
	}
	
	public void updateExam(Exam exam) {
		em.merge(exam);
	}	

	private void deleteExam(Exam exam) {
		em.remove(exam);
	}

	public void deleteExam(Long id) {
		Exam exam = em.find(Exam.class, id);
		deleteExam(exam);
	}
}
