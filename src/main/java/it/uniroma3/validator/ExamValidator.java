package it.uniroma3.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Exam;

/**
 * 
 *
 * Si potrebbe fare il controllo sulla data
 * 
 */

@Component
public class ExamValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Exam.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Exam exam = (Exam) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "code", "code.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "visitDate", "visitDate.required");
		
	}

}
