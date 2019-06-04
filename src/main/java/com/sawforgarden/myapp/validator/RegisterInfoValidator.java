package com.sawforgarden.myapp.validator;


import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import com.sawforgarden.myapp.POJO.VariableValidator;
import com.sawforgarden.myapp.controller.HomeController;
//import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.dao.UserDAO;
import com.sawforgarden.myapp.jdbc.ExistingQueryParmeters;
import com.sawforgarden.myapp.model.RegisterInfo;
import com.sawforgarden.myapp.model.RestorePassword;

public class RegisterInfoValidator  implements Validator {
	
private static final Logger logger = Logger
			.getLogger(RegisterInfoValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
			
		return RegisterInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ArrayList list= (ArrayList) (target);
		
		
		logger.info(list+"--ThatList");
		if(Boolean.parseBoolean((String) list.get(0))) {
			errors.rejectValue("email", "email exists", new Object[]{"'email'"}, "Такой емайл уже зарегистрирован");
		}
		
		if(Boolean.parseBoolean((String) list.get(0))) {
			errors.rejectValue("email", "email exists", new Object[]{"'email'"}, "Такой емайл уже зарегистрирован");
		}
		
		if(Boolean.parseBoolean((String) list.get(1))) {
			errors.rejectValue("phone", "phone exists", new Object[]{"'phone'"}, "Такой номер телефона уже зарегистрирован");
		}
		
//		boolean resultEmail=false;
//		
//		try {
//			resultEmail = Boolean.parseBoolean(String.valueOf(target));
//		}
//		catch(Exception e) {
//			logger.info("That class do  some mistake-- in RegisterInfoValidator, but all okey");
//		}
//		
//		if(resultEmail)
//		{
//		errors.rejectValue("email", "email exists", new Object[]{"'email'"}, "Такой емайл уже зарегистрирован");	
//		}
		
		
	
}
	
}
