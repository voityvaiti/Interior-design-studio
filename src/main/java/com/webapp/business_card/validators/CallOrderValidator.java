package com.webapp.business_card.validators;

import com.webapp.business_card.models.Call;

public class CallOrderValidator {
	String errors;
	
	public CallOrderValidator(Call callToValidate) {
		validate(callToValidate);
	}
	
	private void validate(Call callToValidate) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		if(callToValidate.getName().length()>40)  errorMessageBuilder.append("Too long name! <br>");
		if(callToValidate.getName().length()<1) errorMessageBuilder.append("Please, enter your name <br>");
		if(callToValidate.getNumber().length()>16) errorMessageBuilder.append("Too long telephone number! <br>");
		if(callToValidate.getNumber().length()<1) errorMessageBuilder.append("Please, enter your telephone number <br>");
		errors = errorMessageBuilder.toString();
	}
	
	public boolean hasErrors() {
		if(errors.length()>0) {
			return true;
		}
		else return false;
	}
	
	public String getErrors() {
		return errors;
	}

}
