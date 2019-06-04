package com.sawforgarden.myapp.annotationsHibernate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordCanNotContainSemicolonClass implements ConstraintValidator<PasswordCanNotContainSemicolon,String> {

	@Override
	public void initialize(PasswordCanNotContainSemicolon constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		if(value.contains(";")) {
			return false;
		}
		
		
		return true;

	}

	

	
}
