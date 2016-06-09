package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.ManyToMany;

import it.uniroma3.facade.ExamTypologyFacade;
import it.uniroma3.model.ExamTypology;
import it.uniroma3.model.Prerequisite;

public class ExamTypologyController {
	
	@EJB
	private ExamTypologyFacade examTypologyFacade;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

}
