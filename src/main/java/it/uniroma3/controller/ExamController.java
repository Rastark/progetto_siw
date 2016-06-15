package it.uniroma3.controller;

import java.util.List;

import javax.validation.Valid;

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
import it.uniroma3.model.ExamTypology;
import it.uniroma3.model.Medic;
import it.uniroma3.service.ExamService;
//import it.uniroma3.validator.ExamValidator;
import it.uniroma3.service.MedicService;

@Controller
//@RequestMapping("/exam")
	public class ExamController extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private MedicService medicService;
	@RequestMapping("/listexam")
	public String listExam(Model model) {
		model.addAttribute("examsList", examService.listExam());
		return "exam";
	}
	
	@RequestMapping(value="/addexam", method = RequestMethod.GET)
	public String addExam(Model model) {
		model.addAttribute("exam", new Exam());
		return "addexam";
	}
	
	@RequestMapping(value="/updateexam", method = RequestMethod.POST)
	public String updateExam(@ModelAttribute("exam") @Valid Exam exam, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) 
			return "addexam";
		this.examService.insertExam(exam);
		model.addAttribute("examList", examService.listExam());
		return "index";
	}
	
	@RequestMapping(value = "/findmedic", method = RequestMethod.GET)
	public String getMedic(Model model) {
		return "searchmedic";
	}
	
	@RequestMapping(value = "/findexam/{mName}/{mSurname}", method = RequestMethod.POST)
	public String getExams(@PathVariable("mName") String name, @PathVariable("mSurname") String surname, Model model) {
		Medic medic = this.medicService.getMedic(name, surname);
		Exam exam = this.examService.getExam(medic.getId());
		model.addAttribute("examsList", exam);
		return "listexams";
	}
	
	@RequestMapping(value="/delete/{eId}", method = RequestMethod.GET)
	public String deleteExamTypology(@PathVariable("eId") Long eId, Model model) {
		this.examService.deleteExam(eId);
		model.addAttribute("examsList", examService.listExam());
		return "exam";
	}
}



