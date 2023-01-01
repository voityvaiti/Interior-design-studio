package com.webapp.business_card.validators;

public class CodeValidator {
	String errors;

	public CodeValidator(String code) {
		validate(code);
	}

	private void validate(String code) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		if (code.length() > 14)
			errorMessageBuilder.append("Too long code! <br>");
		if (code.length() < 1)
			errorMessageBuilder.append("Please, enter new code <br>");
		errors = errorMessageBuilder.toString();
	}

	public String getErrors() {
		return errors;
	}

	public boolean hasErrors() {
		if (errors.length() > 0)
			return true;
		else
			return false;
	}
}
