package it.uniroma3.controller;



import javax.validation.Valid;

import org.jgroups.blocks.MemcachedConnector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import it.uniroma3.model.ExamTypology;
import it.uniroma3.service.ExamTypologyService;
import it.uniroma3.service.PrerequisiteService;

@Controller
public class ExamTypologyController {

	@Autowired
	private ExamTypologyService examTypologyService;
	
	@Autowired
	private PrerequisiteService prerequisiteService;
	@RequestMapping(value="/listexamtypology", method = RequestMethod.GET)
	public String listExamTypology(Model model) {
		model.addAttribute("examTypologiesList", examTypologyService.listExamTypology());
		return "listexamtypology";
	}	

	@RequestMapping(value = "/addexamtypology", method = RequestMethod.GET)
	public String addExamTypology(Model model) {
		model.addAttribute("examTypology", new ExamTypology());
		return "addexamtypology";
	}

	@RequestMapping(value = "/updateexamtypology", method = RequestMethod.POST)
	public String updateExamTypology(@Valid @ModelAttribute("examTypology") ExamTypology examTypology, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) 
			return "addexamtypology";
		try {
			this.examTypologyService.insertExamTypology(examTypology);
		}
		catch(Exception e) {
			return "addexamtypology";
		}	
		model.addAttribute("examTypologiesList", examTypologyService.listExamTypology());
		return "examtypologyadded";
	}
	
	@RequestMapping(value = "/view/{etId}", method = RequestMethod.GET)
	public String getExamTypology(@PathVariable("etId") Long etId, Model model) {
		ExamTypology examTypology = this.examTypologyService.getExamTypology(etId);
		model.addAttribute("examTypology", examTypology);
		model.addAttribute("prerequistesList", this.prerequisiteService.listPrerequisite());
		return "selectedexamtypology";
	}
	
	@RequestMapping(value = "/updateexamtypology", method = RequestMethod.GET)
	public String updateNoGet() {
		return "addexamtypology";
	}

	@RequestMapping(value="/delete/{etId}", method = RequestMethod.GET)
	public String deleteExamTypology(@PathVariable("etId") Long etId, Model model) {
		this.examTypologyService.deleteExamTypology(etId);
		model.addAttribute("examTypologiesList", examTypologyService.listExamTypology());
		return "examtypologyadded";
	}


}
