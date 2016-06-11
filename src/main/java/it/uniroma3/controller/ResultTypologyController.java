package it.uniroma3.controller;

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
import it.uniroma3.model.ResultTypology;
import it.uniroma3.service.ResultTypologyService;

@Controller
@RequestMapping("/resulttypology")
public class ResultTypologyController extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ResultTypologyService resultTypologyService;
	
	@Autowired
	@Qualifier("resultTypologyValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@ModelAttribute("resultTypology")
	public ResultTypology createResultTypologyModel() {
		return new ResultTypology();
	}
	
	@RequestMapping("/listresulttypology")
	public String listResultTypology(Model model) {
		model.addAttribute("resultTypologiesList", resultTypologyService.listResultTypology());
		return "resulttypology";
	}
	
	@RequestMapping(value="/addresulttypology", method = RequestMethod.POST)
	public String addResultTypology(Model model) {
		return "/addresulttypology";
	}
	
	@RequestMapping(value="/updateresulttypology", method = RequestMethod.GET)
	public String updateResultTypology(@ModelAttribute("resultTypology") @Validated ResultTypology resultTypology, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) 
			return "addresulttypology";
		this.resultTypologyService.insertResultTypology(resultTypology);
		model.addAttribute("resultTypologyList", resultTypologyService.listResultTypology());
		return "resultTypology";
	}
	
	@RequestMapping(value="/delete/{rtId}", method = RequestMethod.GET)
	public String deleteResultTypology(@PathVariable("rtId") Long rtId, Model model) {
		this.resultTypologyService.deleteResultTypology(rtId);
		model.addAttribute("resultTypologiesList", resultTypologyService.listResultTypology());
		return "resultTypology";
	}
}
