package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

import it.uniroma3.model.Exam;
import it.uniroma3.service.ExamService;

@Controller
@RequestMapping("/exam")
	public class ExamController extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	@Qualifier("examValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@ModelAttribute("exam")
	public Exam createExamModel() {
		return new Exam();
	}
	
	@RequestMapping("/listexam")
	public String listExam(Model model) {
		model.addAttribute("examsList", examService.listExam());
		return "exam";
	}
	
	@RequestMapping(value="/addexam", method = RequestMethod.POST)
	public String addExam(Model model) {
		return "/addexam";
	}
	
	@RequestMapping(value="/updateexam", method = RequestMethod.GET)
	public String updateExam(@ModelAttribute("exam") @Validated Exam exam, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) 
			return "addexam";
		this.examService.insertExam(exam);
		model.addAttribute("examList", examService.listExam());
		return "exam";
	}
	
	@RequestMapping(value="/delete/{eId}", method = RequestMethod.GET)
	public String deleteExamTypology(@PathVariable("eId") Long eId, Model model) {
		this.examService.deleteExam(eId);
		model.addAttribute("examsList", examService.listExam());
		return "exam";
	}
}



