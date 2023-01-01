package com.webapp.business_card.validators;

import com.webapp.business_card.models.Call;

public class CallOrderValidator {
	String errors;
	
	public CallOrderValidator(Call call) {
		validate(call);
	}

	private void validate(Call call) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		if(call.getName().length()>40)  errorMessageBuilder.append("Too long name! <br>");
		if(call.getName().length()<1) errorMessageBuilder.append("Please, enter your name <br>");
		if(call.getNumber().length()>16) errorMessageBuilder.append("Too long telephone number! <br>");
		if(call.getNumber().length()<1) errorMessageBuilder.append("Please, enter your telephone number <br>");
		errors = errorMessageBuilder.toString();
	}
	
	public String getErrors() {
		return errors;
	}

	public boolean hasErrors() {
		if(errors.length()>0) return true;
		else return false;
	}
}
