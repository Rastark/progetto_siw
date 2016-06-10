package it.uniroma3.controller;

import java.util.LinkedList;
import java.util.List;


import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.dao.ExamTypologyDao;
import it.uniroma3.model.ExamTypology;
import it.uniroma3.model.Prerequisite;

@Controller
@RequestMapping("/examTypology")
public class ExamTypologyController {
	
	private ExamTypologyDao examTypologyDao;
	
	@Autowired
	private ExamTypologyService examTypologyService;
	
	@ModelAttribute("examTypology")
	public ExamTypology createExamTypologyModel() {
		return new ExamTypology();
	}
	
	private List<ExamTypology> examTypologies;
	
	@RequestMapping(value="/listexamtypology", method= RequestMethod.GET)
	public String listExamTypology(Model model) {
		model.addAttribute("examTypologyList", examTypologyService.listExamTypology());
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
