package it.uniroma3.controller;

import java.text.ParseException;
import java.util.Date;
import org.springframework.stereotype.Controller;

import it.uniroma3.dao.ExamDao;
import it.uniroma3.dao.ExamTypologyDao;
import it.uniroma3.model.Exam;
import it.uniroma3.model.ExamTypology;

@Controller
public class ExamController {

	private ExamTypologyDao examTypologyFacade;
	private ExamDao examFacade;

	private Long id;
	private String visitDate;
	private ExamTypology examTypology;
	private Exam exam;
	
	public String createExam() throws ParseException {
		this.exam = this.examFacade.createExam(examTypology, visitDate);
		return "exam";
	}
	
	public ExamTypologyDao getExamTypologyFacade() {
		return this.examTypologyFacade;
	}

	public void setExamTypologyFacade(ExamTypologyDao examTypologyFacade) {
		this.examTypologyFacade = examTypologyFacade;
	}
	
	public ExamDao getExamFacade() {
		return this.examFacade;
	}
	
	public void setExamFacade(ExamDao examFacade) {
		this.examFacade = examFacade;
	}
	

}



