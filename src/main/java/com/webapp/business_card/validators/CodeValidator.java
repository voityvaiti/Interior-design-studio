package com.webapp.business_card.validators;

public class CodeValidator extends Validator{
	String code;

	public CodeValidator(String code) {
		this.code = code;
		errors = validate();
	}

	protected String validate() {
		StringBuilder errorMessageBuilder = new StringBuilder();
		if (code.length() > 14)
			errorMessageBuilder.append("Too long code! <br>");
		if (code.length() < 1)
			errorMessageBuilder.append("Please, enter new code <br>");
		return errorMessageBuilder.toString();
	}
}
