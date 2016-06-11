package it.uniroma3.controller;

import java.text.ParseException;
import java.util.Date;

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

import it.uniroma3.dao.ExamDaoImpl;
import it.uniroma3.dao.ExamTypologyDaoImpl;
import it.uniroma3.model.Exam;
import it.uniroma3.model.ExamTypology;
import it.uniroma3.model.Result;
import it.uniroma3.service.ResultService;

@Controller
@RequestMapping("/result")
public class ResultController extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ResultService resultService;
	
	@Autowired
	@Qualifier("resultValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@ModelAttribute("result")
	public Result createResultModel() {
		return new Result();
	}
	
	@RequestMapping("/listresult")
	public String listResult(Model model) {
		model.addAttribute("resultsList", resultService.listResult());
		return "result";
	}
	
	@RequestMapping(value="/addresult", method = RequestMethod.POST)
	public String addResult(Model model) {
		return "/addresult";
	}
	
	@RequestMapping(value="/updateresult", method = RequestMethod.GET)
	public String updateResult(@ModelAttribute("result") @Validated Result result, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) 
			return "addresult";
		this.resultService.insertResult(result);
		model.addAttribute("resultList", resultService.listResult());
		return "result";
	}
	
	@RequestMapping(value="/delete/{rId}", method = RequestMethod.GET)
	public String deleteResult(@PathVariable("rId") Long rId, Model model) {
		this.resultService.deleteResult(rId);
		model.addAttribute("resultsList", resultService.listResult());
		return "result";
	}
}


