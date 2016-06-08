package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.ManyToMany;

import it.uniroma3.facade.ExamTypologyFacade;
import it.uniroma3.model.ExamTypology;
import it.uniroma3.model.Prerequisite;

@ManagedBean
public class ExamTypologyController {
	
	@EJB(beanName="etFacade")
	private ExamTypologyFacade examTypologyFacade;

	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private String name;
	private String code;
	private String description;
	private float cost;
	
	public String createExamTypology() {
		ExamTypologyFacade examTypologyFacade = new ExamTypologyFacade();
		examTypologyFacade.createTypology(name,code,description,cost);
		return "name";
	}
	
//	public String createExamTypology() {}
	
	private List<ExamTypology> examTypologies;
	
	public ExamTypologyFacade getExamTypologyFacade() {
		return this.examTypologyFacade;
	}
	
	public void setExamTypologyFacade(ExamTypologyFacade examTypologyFacade) {
		this.examTypologyFacade = examTypologyFacade;
	}
	
	public List<ExamTypology> getListExamTypologies() {
		return this.examTypologyFacade.getAllExamTypologies();
	}
	
}
