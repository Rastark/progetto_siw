package it.uniroma3.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Exam;

@Repository
public class ExamDaoImpl implements ExamDao {

	@Autowired
	@PersistenceContext(unitName = "dawnstone")
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamDai#getExam(java.lang.Long)
	 */
	@Override
	public Exam getExam(Long id) {
		Exam exam = em.find(Exam.class, id);
		return exam;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamDai#getAllExams()
	 */
	@Override
	public List<Exam> getAllExams () {
//		*** VERSIONE VECCHIA CON CRITERIAQUERY ***
//		CriteriaQuery<Exam> cq = em.getCriteriaBuilder().createQuery(Exam.class);
//		cq.select(cq.from(Exam.class));
//		List<Exam> examsList = em.createQuery(cq).getResultList();
//		return examsList;
		List<Exam> listExam = em.createQuery("SELECT e FROM Exams e", Exam.class).getResultList();
		return listExam;
	}
	
	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamDai#insertExam(it.uniroma3.model.Exam)
	 */
	@Override
	@Transactional
	public void insertExam(Exam exam) {
		em.persist(exam);
	}

	/* (non-Javadoc)
	 * @see it.uniroma3.dao.ExamDai#deleteExam(java.lang.Long)
	 */
	@Override
	@Transactional
	public void deleteExam(Long id) {
		Exam exam = em.find(Exam.class, id);
		em.remove(exam);
	}
	
//	/** Creates an exam of the selected typology, the exam is persisted
//	 */
//	public Exam createExam(ExamTypology et, String visitDate) throws ParseException {
//		Exam exam = new Exam();
//		exam.setEt(et);
//		Date creationTime = new Date();
//		exam.setPrenotationDate(creationTime);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date vd = sdf.parse(visitDate);
//		exam.setVisitDate(vd);
//		em.persist(exam);
//		return exam;
//	}
	
//	public void updateExam(Exam exam) {
//		em.merge(exam);
//	}	

//	private void deleteExam(Exam exam) {
//		em.remove(exam);
//	}
}
