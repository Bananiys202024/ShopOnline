package com.sawforgarden.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sawforgarden.myapp.jdbc.ExistingQueryParmeters;
import com.sawforgarden.myapp.model.RegisterInfo;
import com.sawforgarden.myapp.model.RestorePassword;

public class RestorePasswordInfoValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterInfo.class.isAssignableFrom(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
			
		if(target instanceof RestorePassword) {
		
		RestorePassword restorepassword = (RestorePassword) target;

			
		if(ExistingQueryParmeters.checkForUniqueEmailForRestorePassword(restorepassword.getEmailAddress())) {
			   errors.rejectValue("emailAddress", "UniqueEmail", new Object[]{"'emailAddress'"}, "We have not account with that email");	
		}

	if(restorepassword.isThatCheckPoint()) {
			
		if(!restorepassword.getVerificationCodeExpected().trim().equals(restorepassword.getInputedCode().trim())) {
			   errors.rejectValue("InputedCode", "WrongRestoreCode", new Object[]{"'InputedCode'"}, "That wrong code, go again.");	
		}
		
		if(restorepassword.getInputedCode()==null) {
			   errors.rejectValue("InputedCode", "WrongRestoreCode", new Object[]{"'InputedCode'"}, "That can't be empty");	

		}
		
		}//there end check getInputedCode for null
	
		if(restorepassword.isThatCheckPointSecond()) {
		if(!restorepassword.getNewPassword().trim().equals(restorepassword.getRepeateNewPassword().trim())) {
			   errors.rejectValue("repeateNewPassword", "MatchRestorePassword", new Object[]{"'repeateNewPassword'"}, "Password not match.");	
		}
		
		if(restorepassword.getNewPassword().length()<6) {
			   errors.rejectValue("repeateNewPassword", "WrongLength", new Object[]{"'repeateNewPassword'"}, "Password should have length more of 6 characteries.");	
		}
		
		}//there end chec same password
		
		
	}
}

}