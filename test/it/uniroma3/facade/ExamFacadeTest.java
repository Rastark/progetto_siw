package it.uniroma3.facade;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Properties;

import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.controller.ExamController;
import it.uniroma3.model.Exam;
import it.uniroma3.model.ExamTypology;

public class ExamFacadeTest {
	private ExamTypology et = new ExamTypology("Cardiologico", "CARDGV170516", "Esame cardiologico", 300.2F);
	private ExamFacade examFacade = new ExamFacade();
	private ExamController examController = new ExamController();
	private String dataVisita = "20/06/1992";
	
	
	@Test
	public void createExamTest() throws ParseException {
		Exam exam = this.examController.getExamFacade().createExam(et, dataVisita);
		assertNotNull(this.examController.getExamFacade().getExam(exam.getId()));
	}

}
