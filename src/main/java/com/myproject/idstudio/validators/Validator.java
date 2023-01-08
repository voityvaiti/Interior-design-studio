package com.myproject.idstudio.validators;

public abstract class Validator {
	protected String errors;
	
	abstract String validate();
	
	public String getErrors() {
		return errors;
	}

	public boolean hasErrors() {
		if(errors.length()>0) return true;
		else return false;
	}
}
