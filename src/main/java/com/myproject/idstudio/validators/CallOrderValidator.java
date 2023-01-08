package com.myproject.idstudio.validators;

import com.myproject.idstudio.models.Call;

public class CallOrderValidator extends Validator {
	Call call;
	
	public CallOrderValidator(Call call) {
		this.call = call;
		errors = validate();
	}

	protected String validate() {
		StringBuilder errorMessageBuilder = new StringBuilder();
		if(call.getName().length()>40)  errorMessageBuilder.append("Too long name! <br>");
		if(call.getName().length()<1) errorMessageBuilder.append("Please, enter your name <br>");
		if(call.getNumber().length()>16) errorMessageBuilder.append("Too long telephone number! <br>");
		if(call.getNumber().length()<1) errorMessageBuilder.append("Please, enter your telephone number <br>");
		return errorMessageBuilder.toString();
	}
}
