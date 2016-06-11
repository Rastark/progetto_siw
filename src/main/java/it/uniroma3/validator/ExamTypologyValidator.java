package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.ExamTypology;

public class ExamTypologyValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ExamTypology.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "name", "name.required");
	}

}
