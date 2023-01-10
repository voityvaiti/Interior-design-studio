package com.myproject.idstudio.abstractions;

public abstract class Validator {
	protected String errors;
	
	protected abstract String validate();
	
	public String getErrors() {
		return errors;
	}

	public boolean hasErrors() {
		if(errors.length()>0) return true;
		else return false;
	}
}
