package it.uniroma3.controller;

import java.text.ParseException;
import java.util.Date;
import org.springframework.stereotype.Controller;

import it.uniroma3.facade.ExamFacade;
import it.uniroma3.facade.ExamTypologyFacade;
import it.uniroma3.model.Exam;
import it.uniroma3.model.ExamTypology;

@Controller
public class ExamController {

	private ExamTypologyFacade examTypologyFacade;
	private ExamFacade examFacade;

	private Long id;
	private String visitDate;
	private ExamTypology examTypology;
	private Exam exam;
	
	public String createExam() throws ParseException {
		this.exam = this.examFacade.createExam(examTypology, visitDate);
		return "exam";
	}
	
	public ExamTypologyFacade getExamTypologyFacade() {
		return this.examTypologyFacade;
	}

	public void setExamTypologyFacade(ExamTypologyFacade examTypologyFacade) {
		this.examTypologyFacade = examTypologyFacade;
	}
	
	public ExamFacade getExamFacade() {
		return this.examFacade;
	}
	
	public void setExamFacade(ExamFacade examFacade) {
		this.examFacade = examFacade;
	}
	

}



