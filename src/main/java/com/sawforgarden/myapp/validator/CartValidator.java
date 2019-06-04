package com.sawforgarden.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sawforgarden.myapp.POJO.POJO;
import com.sawforgarden.myapp.POJO.VariableValidator;
import com.sawforgarden.myapp.model.CustomerInfo;

public class CartValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CustomerInfo customerinfo = (CustomerInfo) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.cartValidator.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.cartValidator.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.cartValidator.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.cartValidator.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "town", "NotEmpty.cartValidator.town");
		
		if(VariableValidator.chackEmail(customerinfo.getEmail())) {
			errors.rejectValue("email", "email wrong", new Object[]{"'email'"}, "Неправильный емайл, емайл должен иметь следующие формы: *****@gmail.com or ***@mail.ru");
		}
		
		if(!VariableValidator.forCallingValidatePhoneNumber(customerinfo.getPhone())) {
			errors.rejectValue("phone", "phone wrong", new Object[]{"'phone'"}, "Неправильный телефон. Пример правильных номеров телефона: 1234567890. (055) 4477284");
		}
	
	
	}

}
