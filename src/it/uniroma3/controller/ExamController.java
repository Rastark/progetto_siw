package it.uniroma3.controller;

import java.text.ParseException;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.facade.ExamFacade;
import it.uniroma3.facade.ExamTypologyFacade;
import it.uniroma3.model.Exam;
import it.uniroma3.model.ExamTypology;

@ManagedBean
public class ExamController {

	@EJB
	private ExamTypologyFacade examTypologyFacade;
	
	@EJB(beanName="eFacade")
	private ExamFacade examFacade;

	@ManagedProperty(value="#{param.id}")
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



