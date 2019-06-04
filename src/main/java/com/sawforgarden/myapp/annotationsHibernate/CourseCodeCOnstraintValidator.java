package com.sawforgarden.myapp.annotationsHibernate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sawforgarden.myapp.POJO.VariableValidator;

public class CourseCodeCOnstraintValidator implements ConstraintValidator<Phone,String>{
	
//	private String coursePrefix;

	@Override
	public void initialize(Phone constraintAnnotation) {
//		coursePrefix = constraintAnnotation.value();
		
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		
		boolean result;
		
		if(theCode != null) {
			
			result = VariableValidator.forCallingValidatePhoneNumber(theCode);

		}
		else {
			result=true;
		}
		return result;
		
	}

}
