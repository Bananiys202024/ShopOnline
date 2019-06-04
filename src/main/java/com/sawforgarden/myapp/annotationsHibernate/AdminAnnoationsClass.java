package com.sawforgarden.myapp.annotationsHibernate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sawforgarden.myapp.POJO.VariableValidator;

public class AdminAnnoationsClass implements ConstraintValidator<AdminIsUniqueNameAndUnrepeatable,String> {

	@Override
	public void initialize(AdminIsUniqueNameAndUnrepeatable constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		
		boolean result=true;
		
		if(theCode.equals("Admin") || theCode.equals("Admin@gmail.com") || theCode.equals("Admin@gmail")) {
			return false;
		}
		
		return result;
//		return false;
		
	}


}
