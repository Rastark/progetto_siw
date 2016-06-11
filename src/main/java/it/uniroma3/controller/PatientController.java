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

import it.uniroma3.model.Patient;
import it.uniroma3.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	@Qualifier("patientValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@ModelAttribute("patient")
	public Patient createPatient() {
		return new Patient();
	}
	
	@RequestMapping(value = "/listpatient", method = RequestMethod.GET)
	public String listPatient(Model model) {
		model.addAttribute("patientsList", this.patientService.listPatient());
		return "patient";
	}
	
	@RequestMapping(value = "/addpatient", method = RequestMethod.POST)
	public String addPatient(Model model) {
		return "/addpatient";
	}
	
	@RequestMapping(value = "/updatepatient", method = RequestMethod.GET)
	public String updatePatient(@ModelAttribute("patient") @Validated Patient patient, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors())
			return "addpatient";
		this.patientService.insertPatient(patient);
		model.addAttribute("patientsList", this.patientService.listPatient());
		return "patient";
	}
	
	@RequestMapping(value = "/delete/{pId}", method = RequestMethod.GET)
	public String delteExamTypology(@PathVariable("pId") Long pId, Model model) {
		this.patientService.deletePatient(pId);
		model.addAttribute("patientsList", this.patientService.listPatient());
		return "patient";
	}

}
