package it.uniroma3.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import it.uniroma3.model.Patient;
import it.uniroma3.model.Result;
import it.uniroma3.service.ExamService;
import it.uniroma3.service.ExamTypologyService;
import it.uniroma3.service.MedicService;
import it.uniroma3.service.PatientService;
import it.uniroma3.service.ResultService;
//import it.uniroma3.validator.ExamValidator;

@Controller
//@RequestMapping("/exam")
	public class ExamController extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private ResultService resultService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ExamTypologyService examTypologyService;
	
	@Autowired
	private MedicService medicService;
	
//	@Autowired
//	@Qualifier("examValidator")
//	private Validator validator;
	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	
//	@ModelAttribute("exam")
//	public Exam createExamModel() {
//		return new Exam();
//	}
	
	@RequestMapping("/listexam")
	public String listExam(Model model) {
		model.addAttribute("examsList", examService.listExam());
		return "exam";
	}
	
	@RequestMapping(value="/addexam", method = RequestMethod.GET)
	public String addExam(Model model) {
		List<Patient> listPatient = new ArrayList<Patient>(this.patientService.listPatient());
		List<Result> listResult = new ArrayList<Result>(this.resultService.listResult());
		List<ExamTypology> listExamTypology = new ArrayList<ExamTypology>(this.examTypologyService.listExamTypology());
		List<Medic> listMedic = new ArrayList<Medic>(this.medicService.listMedic());
		model.addAttribute("exam", new Exam());
		model.addAttribute("patientsList", listPatient);
		model.addAttribute("resultsList", listResult);
		model.addAttribute("examTypologiesList", listExamTypology);
		model.addAttribute("medicsList", listMedic);
		return "addexam";
	}
	
	@RequestMapping(value = "/insertexam", method = RequestMethod.POST)
	public String insertExam(@Valid @ModelAttribute("exam") Exam exam, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) 
			return "addexam";
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = dateFormat.parse("23-09-2007");
			long time = date.getTime();
			exam.setPrenotationDate(new Timestamp(time)); //se non funziona farlo tornare al solo "new Date()"
			this.examService.insertExam(exam);
		}
		catch(Exception e) {
			return "addexam";
		}	
		model.addAttribute("examsList", examService.listExam());
		return "examresults";
	}
	
	@RequestMapping(value = "/examspatient/{pId}", method = RequestMethod.GET)
	public String getPatientExams(@PathVariable ("pId") Long id, Model model) {
		List<Exam> listExam = this.examService.getPatientExams(id);
		model.addAttribute("patientexams", listExam);
		return "";
	}
	
	@RequestMapping(value = "/medicsexam/{mName}/{mSurname}", method = RequestMethod.GET)
	public String getMedicsExam(@PathVariable("mName") String name, @PathVariable("mSurname") String surname, Model model) {
		Medic medic = this.medicService.getMedic(name, surname);
		List<Exam> listMedicExam = this.examService.getMedicExam(medic.getId());
		model.addAttribute("medicsList", listMedicExam);
		return "";
	}
	
	@RequestMapping(value="/deletee/{eId}", method = RequestMethod.GET)
	public String deleteExamTypology(@PathVariable("eId") Long eId, Model model) {
		this.examService.deleteExam(eId);
		model.addAttribute("examsList", examService.listExam());
		return "exam";
	}
}



