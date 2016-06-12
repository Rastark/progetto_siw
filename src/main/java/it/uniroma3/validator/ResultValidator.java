package it.uniroma3.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Result;

@Component
public class ResultValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Result.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "value", "value.required");
	}

}
