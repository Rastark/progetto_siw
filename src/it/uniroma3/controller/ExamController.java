package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.facade.ExamFacade;
import it.uniroma3.facade.ExamTypologyFacade;

@ManagedBean
public class ExamController {

	@EJB
	private ExamTypologyFacade examTypologyFacade;
	
	@EJB
	private ExamFacade examFacade;

	@ManagedProperty(value="#{param.id}")
	private Long id;
	
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



