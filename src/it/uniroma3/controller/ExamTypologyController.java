package it.uniroma3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import it.uniroma3.model.ExamTypology;
import it.uniroma3.service.ExamTypologyService;

@Controller
@RequestMapping("/examTypology")
public class ExamTypologyController extends WebMvcConfigurerAdapter{

	@Autowired
	private ExamTypologyService examTypologyService;

	@Autowired
	@Qualifier("examTypologyValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@ModelAttribute("examTypology")
	public ExamTypology createExamTypologyModel() {
		return new ExamTypology();
	}
	
	@RequestMapping(value="/listexamtypology", method = RequestMethod.GET)
	public String listExamTypology(Model model) {
		model.addAttribute("examTypologiesList", examTypologyService.listExamTypology());
		return "examTypology";
	}	
	
	@RequestMapping(value = "/addexamtypology", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		return "/addexamtypology";
	}

	@RequestMapping(value="/updateexamtypology", method = RequestMethod.GET)
	public String updateExamTypology(@ModelAttribute("examTypology") @Validated ExamTypology examTypology, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) 
			return "addexamtypology";
		this.examTypologyService.insertExamTypology(examTypology);
		model.addAttribute("examTypologiesList", examTypologyService.listExamTypology());
		return "examTypology";
	}

	@RequestMapping(value="/delete/{etId}", method = RequestMethod.GET)
	public String deleteExamTypology(@PathVariable("etid") Long etId, Model model) {
		this.examTypologyService.deleteExamTypology(etId);
		model.addAttribute("examTypologiesList", examTypologyService.listExamTypology());
		return "examTypology";
	}
}
