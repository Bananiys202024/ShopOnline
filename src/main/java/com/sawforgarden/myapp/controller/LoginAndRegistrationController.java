package com.sawforgarden.myapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sawforgarden.myapp.POJO.SendMail;
import com.sawforgarden.myapp.dao.UserDAO;
import com.sawforgarden.myapp.jdbc.InsertToDatabase;
import com.sawforgarden.myapp.model.AjaxResponseBody;
import com.sawforgarden.myapp.model.ReceiveCodeInfo;
import com.sawforgarden.myapp.model.RegisterInfo;
import com.sawforgarden.myapp.model.RestorePassword;
import com.sawforgarden.myapp.validator.RegisterInfoValidator;
import com.sawforgarden.myapp.validator.RestorePasswordInfoValidator;

@Controller
public class LoginAndRegistrationController {

	private static final Logger logger = Logger
			.getLogger(LoginAndRegistrationController.class);	
	
	@Autowired
	private UserDAO userDAO;	
	
	@Autowired
	private JavaMailSender mailSenderObj;
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	//Start variable of Log In And Register	
	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "***@gmail.com";

	 @RequestMapping(value = "/Register", method = RequestMethod.GET)
		public String Register(Model model) {
		 
		    RegisterInfo registerInfo = null;
		    
	        registerInfo = new RegisterInfo();
	        registerInfo.setNewProduct(true);        
	        
	        model.addAttribute("RegisterData","testedCode");
	        model.addAttribute("registerForm", registerInfo);
	
	        
		 return "LogInAndRegister/Register/Register";
		}
	 
	 @RequestMapping(value = "/Register", method = RequestMethod.POST)
		public String Register(Locale locale, Model model,
				@ModelAttribute("registerForm") @Validated RegisterInfo registerInfo,
				final BindingResult result,
				@ModelAttribute("RegisterData") String randomCode) {
		 
		 List<String> list =  new ArrayList<String>();
		 list.add(userDAO.CheckIfemailExistsInDataBase(registerInfo.getEmail()));
		 list.add(userDAO.CheckIfphoneExistsInDataBase(registerInfo.getPhone()));
		 
		 RegisterInfoValidator registerValidator = new RegisterInfoValidator();
		 registerValidator.validate(list, result);

	    	if (result.hasErrors()) {
		         return "LogInAndRegister/Register/Register";
		      }

		 ReceiveCodeInfo receivecodeinfo = null;
	        
		 receivecodeinfo = new ReceiveCodeInfo();
		 receivecodeinfo.setNewProduct(true);
		 

		    //Ther process of send code
	        Random rand = new Random();

			int  generatedRandom= rand.nextInt(10000) + 1000;
			
			String mail=registerInfo.getEmail();
			String randomNumber=String.valueOf(generatedRandom);
			emailToRecipient = mail;
			
			final String emailMessage = randomNumber;
		
			mailSenderObj.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {

					MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
					mimeMsgHelperObj.setTo(emailToRecipient);
					mimeMsgHelperObj.setFrom(emailFromRecipient);
					mimeMsgHelperObj.setText(emailMessage);
//					checkprojectsforwork@gmail.com 
					}});
	        

	     
	     
	     
	     
//	     There end process of end email
	     
   	String sqlForMaxNumberOfRole_IDColumn = "SELECT MAX(ROLE_ID) FROM USER_ROLES;"; 
   	String CodeEmptyOrNotThatWhereQuastion = jdbcTemplate.queryForObject(sqlForMaxNumberOfRole_IDColumn, String.class);

  	
	     
			model.addAttribute("codeForm", receivecodeinfo);
		
		     registerInfo.setCodeRecieved(randomNumber);
		     registerInfo.setMaxValueColumnRoleIdOfUSER_ROLESTABLE(CodeEmptyOrNotThatWhereQuastion);
		     	
		     model.addAttribute("RegisterData",registerInfo);
		     
	     
		     
		     
		     
		     
		     
		     
		     
		    
		     
		     
	     
		 return "redirect:/ReceiveCode";
		}
	 
	 @RequestMapping(value = "/ReceiveCode", method = RequestMethod.GET)
		public String Register(Locale locale, Model model,
				@ModelAttribute("codeForm") @Validated ReceiveCodeInfo receivecodeinfo,
				@ModelAttribute("RegisterData") RegisterInfo registerInfo,
				RedirectAttributes redirectAttributes) {

		 boolean addtoDataBase = false;
		 
		 model.addAttribute("SendedEmail",registerInfo.getEmail().trim());
		 
		 if(receivecodeinfo.getEmailcode()==null) {
	     return "LogInAndRegister/Register/RegisterCodeEmail";
		 }

		 if(receivecodeinfo.getEmailcode().equals(registerInfo.getCodeRecieved())) 
		 {
			 addtoDataBase=true;
		 }	 
		 if(addtoDataBase) {
			 	 try 
			 	 {
			 	 userDAO.saveRegisteredDataUsers(registerInfo);
			 	 userDAO.saveRegisteredDataUserRoles(registerInfo);
			 	 }
			 	 catch(Exception e) {
			 		 logger.error("CatchedMistake--"+e);
			 	 }
			 	 return "redirect:/RegisterSuccess";
		 }
		 
		 return "redirect:/ReceiveFailure";
		}

	 @RequestMapping(value = "/RegisterSuccess", method = RequestMethod.GET)
		public String RegisterSucess(Locale locale, Model model) {
		 	return "LogInAndRegister/Register/RegisterSucess";
		}
	 
	 @RequestMapping(value = "/ReceiveFailure", method = RequestMethod.GET)
		public String RegisterFailure(Locale locale, Model model) {
		 	return "LogInAndRegister/Register/RegisterThereIsSomeMistake";
		}
	 

	    
	    @RequestMapping(value = "/RestorePassword", method = RequestMethod.GET)
		public String RestorePassword(Locale locale, Model model
				) {
	    		    	
	    	RestorePassword restorepassword = null;
	        
	    	restorepassword = new RestorePassword();
	    	restorepassword.setRestore(true);
			
	    	model.addAttribute("restorepassword", restorepassword);	

			return "LogInAndRegister/RestorePassword/RestorePassword";
		}
	    
	    @RequestMapping(value = "/RestorePassword", method = RequestMethod.POST)
		public String RestorePasswordPOST(Locale locale, Model model,
				@ModelAttribute("restorepassword") @Validated RestorePassword restorepassword,
				final BindingResult result) {
	 
	    	
	    	Random rand = new Random();

			int  RandomCode= rand.nextInt(10000) + 1000;
			restorepassword.setVerificationCodeExpected(String.valueOf(RandomCode));
			
		 	RestorePasswordInfoValidator userValidator = new RestorePasswordInfoValidator();
	        userValidator.validate(restorepassword, result);
	    	
	    	if (result.hasErrors()) {
		         return "LogInAndRegister/RestorePassword/RestorePassword";
		      }
	    	
	    	String adminEmail ="";
	    	String adminPassword="";
	    	
	    	SendMail.sendEmail(restorepassword.getEmailAddress(), String.valueOf(RandomCode));
	    	
	    	restorepassword.setThatCheckPoint(true);
	        model.addAttribute("RegisterData", restorepassword);
	        model.addAttribute("TemporaryVariable",restorepassword.getEmailAddress());
	        
			return "LogInAndRegister/RestorePassword/RestorePassword-InputSendedCode";
		}

	    
//	    AJAX
	    @RequestMapping(value = "/ResendCodeAgain", method = RequestMethod.GET)
		public  @ResponseBody AjaxResponseBody ResendCodeRestorePasswordAgain(
				Locale locale,Model model,
				@RequestParam(value = "email", defaultValue = "") String email) throws InterruptedException {
	 
	    	logger.info("I was here"+email);

//	    	@ModelAttribute("restorepassword") @Validated RestorePassword restorepassword,
	    	RestorePassword restorepassword = new RestorePassword();
	    	restorepassword.setEmailAddress(email);
	    	
	    	Random rand = new Random();

			int  RandomCode= rand.nextInt(10000) + 1000;
			restorepassword.setVerificationCodeExpected(String.valueOf(RandomCode));
			
	    	SendMail.sendEmail(restorepassword.getEmailAddress(), String.valueOf(RandomCode));
	    	
	    	restorepassword.setThatCheckPoint(true);
	        model.addAttribute("RegisterData", restorepassword);
	        model.addAttribute("TemporaryVariable",restorepassword.getEmailAddress());
	        
	        AjaxResponseBody result1 = new AjaxResponseBody();
	        result1.setMsg("Код был отправлен");
	        
			return result1;
		}
	    
	    
	    @RequestMapping(value = "/InputRestorePassword", method = RequestMethod.GET)
		public String InputRestorePasswordPOST(Locale locale, Model model,
				@ModelAttribute("RegisterData") @Validated RestorePassword restorepassword,
				@ModelAttribute("restorepassword") @Validated RestorePassword restorepasswordOriginal
,
				final BindingResult result) {
	    	
	 
	    	RestorePasswordInfoValidator userValidator = new RestorePasswordInfoValidator();
	        userValidator.validate(restorepassword, result);
	    	
	        if (result.hasErrors()) {
		         return "LogInAndRegister/RestorePassword/RestorePassword-InputSendedCode";
		      }
	        
	        restorepassword.setNewPassword(restorepasswordOriginal.getNewPassword());
	        
	        
	    	return "LogInAndRegister/RestorePassword/RestorePassword-InputNewPassword";
		}
	    
	    @RequestMapping(value = "/SuccessRestorePassword", method = RequestMethod.GET)
	  		public String SuccessRestorePasswordPOST(Locale locale, Model model,
	  				@ModelAttribute("RegisterData") @Validated RestorePassword restorepassword,
	  				@ModelAttribute("restorepassword") @Validated RestorePassword restorepasswordOriginal,
					final BindingResult result) {
	    	
	    	restorepassword.setThatCheckPointSecond(true);
	    	
	    	RestorePasswordInfoValidator userValidator = new RestorePasswordInfoValidator();
	        userValidator.validate(restorepassword, result);
	    	
	        if (result.hasErrors()) {
		         return "LogInAndRegister/RestorePassword/RestorePassword-InputNewPassword";
		      }
	    	
	        restorepassword.setNewPassword(restorepasswordOriginal.getNewPassword());
	    	
	    
	    	try {
	    	InsertToDatabase.insertToDatabase(restorepassword.getEmailAddress(), restorepassword.getNewPassword());
	    	}
	    	catch(Exception e){
	    		return "Problems/403";
//	    		That better rename to 503, but that's okey for some time
	    	}
	    	
	  			return "LogInAndRegister/RestorePassword/SuccessRestorePassword";
	  		}
	    

	 
	 
	 
}
