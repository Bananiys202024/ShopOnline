package com.sawforgarden.myapp.annotationsHibernate;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;

import com.sawforgarden.myapp.controller.HomeController;

import org.apache.commons.beanutils.BeanUtils;

public class ClassForAnnotationPasswordValidator implements ConstraintValidator<ValidPassword,Object>{
	
	
	private static final Logger logger = Logger
			.getLogger(ClassForAnnotationPasswordValidator.class);	


	 private String firstFieldName;
	 private String secondFieldName;
	
	@Override
	public void initialize(final ValidPassword validatePassword) {	
		this.firstFieldName = validatePassword.first();
		this.secondFieldName = validatePassword.second();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {

		boolean result=false;
		
		
		//add path
	    context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addNode("confirmpassword").addConstraintViolation();
	    //....

	
		
		try {
			final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

			logger.info(firstObj+"--Check--");
			logger.info(secondObj);
			
			if(firstObj.equals(secondObj)) {
				result=true;
			}

		}catch(Exception e) {
			logger.info("Mistake Of Annotation--"+e);
		}
		

		
		
		return result;
		
	}

	

}
