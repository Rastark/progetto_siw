package it.uniroma3.controller;

import java.util.LinkedList;
import java.util.List;


import javax.persistence.ManyToMany;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.dao.ExamTypologyDao;
import it.uniroma3.model.ExamTypology;
import it.uniroma3.model.Prerequisite;

@Controller
@RequestMapping("/examTypology")
public class ExamTypologyController {
	
	private ExamTypologyDao examTypologyFacade;

	private Long id;	
	private String name;
	private String code;
	private String description;
	private float cost;
	
	@ModelAttribute("examTypology")
	public ExamTypology createExamTypologyModel() {
		return new ExamTypology();
	}
	
	private List<ExamTypology> examTypologies;
	
	@RequestMapping(value="examTypologyList", method= RequestMethod.GET)
	public List<ExamTypology> getExamTypologyList() {
		List<ExamTypology> examTypologies = new LinkedList<ExamTypology>();
	return examTypologies;
	}	
	
	public void setExamTypologyFacade(ExamTypologyDao examTypologyFacade) {
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
