package com.sawforgarden.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sawforgarden.myapp.POJO.VariableValidator;
import com.sawforgarden.myapp.model.AdminInfo;

public class AdminToggleValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		AdminInfo admininfo = (AdminInfo) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneAdmin", "NotEmpty.cartValidator.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAdmin", "NotEmpty.cartValidator.email");
		
		if(VariableValidator.chackEmail(admininfo.getEmailAdmin())) {
			errors.rejectValue("emailAdmin", "email wrong", new Object[]{"'email'"}, "Неправильный емайл, емайл должен иметь следующую форму: *****@gmail.com");
		}
		
		if(!VariableValidator.forCallingValidatePhoneNumber(admininfo.getPhoneAdmin())) {
			errors.rejectValue("phoneAdmin", "phone wrong", new Object[]{"'phone'"}, "Неправильный телефон. Пример правильных номеров телефона: 1234567890. (055) 4477284");
		}
		
	}

}
