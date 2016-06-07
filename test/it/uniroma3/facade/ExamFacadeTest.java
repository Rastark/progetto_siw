package it.uniroma3.facade;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.controller.ExamController;
import it.uniroma3.model.Exam;
import it.uniroma3.model.ExamTypology;

public class ExamFacadeTest {
	private ExamTypology et = new ExamTypology("Cardiologico", "CARDGV170516", "Esame cardiologico", 300.2F);
	private ExamFacade examFacade = new ExamFacade();
	private ExamController examController;
	private String dataVisita = "20/06/1992";
	
	
	@Test
	public void createExamTest() throws ParseException {
		this.examController.setExamFacade(examFacade);
		Exam exam = this.examController.getExamFacade().createExam(et, dataVisita);
		assertNotNull(exam);
	}

}
