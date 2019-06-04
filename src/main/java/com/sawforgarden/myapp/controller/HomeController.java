
package com.sawforgarden.myapp.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sawforgarden.myapp.CloudCommunicationPlatform.SendSms;
import com.sawforgarden.myapp.POJO.HashMaps;
import com.sawforgarden.myapp.POJO.POJO;
import com.sawforgarden.myapp.POJO.SendMail;
//import com.journaldev.spring.form.model.Employee;
import com.sawforgarden.myapp.POJO.VariableValidator;
import com.fasterxml.jackson.annotation.JsonView;
import com.sawforgarden.myapp.dao.AdminDAO;
import com.sawforgarden.myapp.dao.CommentDAO;
import com.sawforgarden.myapp.dao.OrderDAO;
import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.dao.UserDAO;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.jdbc.ExistingQueryParmeters;
import com.sawforgarden.myapp.jdbc.GetQuery;
import com.sawforgarden.myapp.jdbc.InsertToDatabase;
import com.sawforgarden.myapp.model.AdminInfo;
import com.sawforgarden.myapp.model.AjaxResponseBody;
import com.sawforgarden.myapp.model.CartInfo;
import com.sawforgarden.myapp.model.CommentInfo;
import com.sawforgarden.myapp.model.CustomerInfo;

import com.sawforgarden.myapp.model.OrderDetailInfo;
import com.sawforgarden.myapp.model.OrderInfo;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.ReceiveCodeInfo;
import com.sawforgarden.myapp.model.RecentlyViewedItems;
import com.sawforgarden.myapp.model.RegisterInfo;
import com.sawforgarden.myapp.model.RestorePassword;
import com.sawforgarden.myapp.model.SortType;
import com.sawforgarden.myapp.model.SortingVariables;
import com.sawforgarden.myapp.model.Views;
import com.sawforgarden.myapp.util.Utils;
import com.sawforgarden.myapp.validator.AdminToggleValidation;
import com.sawforgarden.myapp.validator.CartValidator;
import com.sawforgarden.myapp.validator.CommentInfoValidator;
import com.sawforgarden.myapp.validator.EditCommentInfoValidator;
import com.sawforgarden.myapp.validator.ProductInfoValidator;
import com.sawforgarden.myapp.validator.RegisterInfoValidator;
import com.sawforgarden.myapp.validator.RestorePasswordInfoValidator;
import com.sawforgarden.myapp.model.EditComment;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;
//import org.apache.log4j.LoggerFactory;

@Controller
@SessionAttributes({"RegisterData", "NameLoggedUser", "EmailLoggedUser", "CommentStar"
	,"TemporaryVariable","CustomerForm","recentlyvieweditems","TopMenuInstruments","cartForm","TagsSorting",
	"CartForItemsOfTopMenu","searchName","sortBy","categorySort","brandSort","priceSorting","ratingSorting"
	,"TopMenuBrands","TopMenuInstruments"
})


public class HomeController {
	
private static final Logger logger = Logger
			.getLogger(HomeController.class);	
	
//Start variable of Log In And Register	
static String emailToRecipient, emailSubject, emailMessage;
static final String emailFromRecipient = "***@gmail.com";

@Autowired
private JavaMailSender mailSenderObj;
//End variable of Log In And Register
@Autowired
private ProductDAO productDAO;

@Autowired
private CommentDAO commentDAO;

@Autowired
private OrderDAO orderDAO;	

@Autowired
private UserDAO userDAO;	

@Autowired
private AdminDAO adminDAO;

@Autowired
private JdbcTemplate jdbcTemplate;
	
//private int countTime=0;
	
private static int CountedShoppingCart=0;


RecentlyViewedItems recentlyvieweditems=new RecentlyViewedItems();


CartInfo cartInfo_forSaveItemsOfCart_AfterLogOut = null;

//@Autowired
//@Qualifier("employeeValidator")
//private Validator validator;
	
//@Autowired
//@Qualifier("productinfoValidator")
//private Validator validator;
//
//@Autowired
//@Qualifier("productinfoValidator")
//private Validator validatorOfRegister;
//
//@Autowired
//@Qualifier("commentinfoValidator")
//private Validator validatorComment;


//private Map<String, Employee> emps = null;

//@InitBinder
//private void initBinder(WebDataBinder binder) {
//   binder.setValidator(validator);
//   binder.setValidator(validatorComment);
//   
//   
//}


//public HomeController() {
//	emps = new HashMap<String, Employee>();
	
//}
	
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages
//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages//	Start Ways Of Pages	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale, Model model) {

		//initialize

		recentlyvieweditems.setId(" ");
		model.addAttribute("recentlyvieweditems",recentlyvieweditems);
		

		
		
		//sorting attribute
		model.addAttribute("searchName","");
    	model.addAttribute("sortBy","");
    	model.addAttribute("categorySort","");
    	model.addAttribute("brandSort","");
    	model.addAttribute("priceSorting","");
    	model.addAttribute("ratingSorting","");
    	
		
		
		model.addAttribute("TopMenuBrands", HashMaps.getBrands());
		model.addAttribute("TopMenuInstruments", HashMaps.getSections());
		
		model.addAttribute("TemporaryVariable","");
		model.addAttribute("CartForItemsOfTopMenu","");
		CountedShoppingCart=0;
		//..

		
		return "StartingPage/StartingPage";
	}
	
	
	@RequestMapping(value = "/StartingPage", method = RequestMethod.GET)
	public String StartingPage(Locale locale, Model model) throws IOException {
		

//		Spring security
		
//		That part code for say hello, my diar ****(user) on the top menu
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String email = loggedInUser.getName();
		
		
		if(!email.equals("anonymousUser")) {		
		String name = ExistingQueryParmeters.findName(email);
		model.addAttribute("NameLoggedUser",name);
		logger.info("");
		}

//		....end ... spring ... security

		return "StartingPage/StartingPage";
	}
	
	
	@RequestMapping(value = "/StartingPageAfterLogOut", method = RequestMethod.GET)
	public String StartingPageAfterLogOut(HttpServletRequest request,
			Locale locale, Model model) throws IOException {
		

//		Spring security
		
//		That part code for say hello, my diar ****(user) on the top menu
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String email = loggedInUser.getName();
		
		logger.info(email+"--ThatFromLogInUser");
//		logger.info(email+"--ThatFromLogInUser");
		
		
		if(!email.equals("anonymousUser")) {		
		String name = ExistingQueryParmeters.findName(email);
		model.addAttribute("NameLoggedUser",name);
		}
//		That yet that name part		
		
//		....end ... spring ... security
		
		
//		initialize variables
		
		
				model.addAttribute("recentlyvieweditems",recentlyvieweditems);
	
				//sorting attribute
				model.addAttribute("searchName","");
		    	model.addAttribute("sortBy","");
		    	model.addAttribute("categorySort","");
		    	model.addAttribute("brandSort","");
		    	model.addAttribute("priceSorting","");
		    	model.addAttribute("ratingSorting","");
		    	
				
				
				model.addAttribute("TopMenuBrands", HashMaps.getBrands());
				model.addAttribute("TopMenuInstruments", HashMaps.getSections());
				
				model.addAttribute("CartForItemsOfTopMenu",CountedShoppingCart);
//		.,,,..

				request.getSession().setAttribute("myCart", cartInfo_forSaveItemsOfCart_AfterLogOut);
				
		return "StartingPage/StartingPage";
	}
	
	@RequestMapping(value = "/CartEmptyPag", method = RequestMethod.GET)
	public String CartEmptyPag(Locale locale, Model model) {
		return "Cart/Cart-Empty-CombinationAll";
	}

	@RequestMapping(value = "/ConfirmationOfOrder", method = RequestMethod.GET)
	public String ConfirmationOfOrder(Locale locale, Model model) {
		return "ConfirmationOfOrder/ConfirmationOfOrder";
	}
	
	@RequestMapping(value = "/ReviewRules", method = RequestMethod.GET)
	public String PageReviewRules(Locale locale, Model model) {
		return "ItemsOfShop/addComment/ReviewRules";
	}
	

	@RequestMapping(value = "/SuccessStatusOrder", method = RequestMethod.GET)
	public String SuccessStatusOrder(Locale locale, Model model) {
		return "StatusOfOrder/SuccessStatusOrder";
	}
	
	@RequestMapping(value = "/UnfailurStatusOrder", method = RequestMethod.GET)
	public String UnfailurStatusOrder(Locale locale, Model model) {
		return "StatusOfOrder/UnfailurStatusOrder";
	}
	
	@RequestMapping(value = "/LogIn", method = RequestMethod.GET)
	public String LogIn(HttpServletRequest request,
			Locale locale, Model model) {
		cartInfo_forSaveItemsOfCart_AfterLogOut = Utils.getCartInSession(request);
		
		return "LogInAndRegister/LogIn/LogIn";
	}

	@RequestMapping(value = "/CreateProduct", method = RequestMethod.GET)
	public String CreateProduct(Locale locale, Model model) {
		return "Admin/Create Product/CreateProduct";
	}
	
	@RequestMapping(value = "/OrderList", method = RequestMethod.GET)
	public String OrderList(Locale locale, Model model) {
		return "Admin/Order List/OrderList";
	}
	
	@RequestMapping(value = "/PaymentDelivery", method = RequestMethod.GET)
	public String PagePaymentANDdelivery(Locale locale, Model model) {
		return "BottomMenuInformation/Payment and delivery";
	}
	
	@RequestMapping(value = "/QuestionsAnswers", method = RequestMethod.GET)
	public String PageQuestionsANDanswers(Locale locale, Model model) {
		return "BottomMenuInformation/Questions and answers";
	}
	
	@RequestMapping(value = "/ReturnExchange", method = RequestMethod.GET)
	public String PageReturnORExchange(Locale locale, Model model) {
		return "BottomMenuInformation/Return or Exchange";
	}
	
	@RequestMapping(value = "/AbotCompany", method = RequestMethod.GET)
	public String PageAbotCompany(Locale locale, Model model) {
		return "BottomMenuInformation/AbotCompany";
	}
	

	
	
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages
//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages//	End Ways of Pages

	
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/ForTestingPage", method = RequestMethod.POST, produces = "application/json")
	private String processPhone( HttpServletRequest request,Model model
//	         ,@ModelAttribute("TestingClass") @Valid TestingClass testingclass
	         ,BindingResult result
	         ) throws Exception {

		if (result.hasErrors()) {
	         return "We should remove this folder/ForTestingPage";
	      }
	       
		return "We should remove this folder/result";

    }

	
	@RequestMapping(value = "/ForTestingPage", method = RequestMethod.GET)	 
	public String updateUserHandler(Model model) {

//		model.addAttribute("TestingClass", new TestingClass());
//		new SortType()
		
		return "We should remove this folder/ForTestingPage";
	}
	
	@RequestMapping(value = "/ForTestingPageThatAJAX", method = RequestMethod.GET)	 
	public String updateUserHandleraAJAX(Model model
			,@RequestParam(value = "ReleaseId")String noteForTextBox
			,@RequestParam(value = "comment")String comment
			) {
	
		return "ItemsOfShop/addComment/SucessAddComment";
	}
	

	
	@ModelAttribute("productinfo")
	public ProductInfo createEmployeeModelTwo() {
		// ModelAttribute value should be same as used in the empSave.jsp
		return new ProductInfo();
	}
	
	
	@ModelAttribute("CommentInfo")
	public CommentInfo createCommentInfo() {
		// ModelAttribute value should be same as used in the empSave.jsp
		return new CommentInfo();
	}
	
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage(Model model) {
	         
	        return "loginPage";
	    }
	
	 @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	    public String userInfo(Model model, Principal principal) {
	        return "userInfoPage";
	    }
	 
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it
//We should delete it//We should delete it//We should delete it//We should delete it	
	
	 
	 
	 
	 
	 
	 
	 
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//St//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register//Start Parts Of LogIn And Register
	 
	 
//	 @RequestMapping(value = "/registerProcess", method = RequestMethod.GET)
//		public String checkData(HttpServletRequest request,Model model) {
//			
//			Random rand = new Random();
//
//			int  generatedRandom= rand.nextInt(10000) + 1000;
//			
//			String username=request.getParameter("username");
//			String password=request.getParameter("password");
//			String mail=request.getParameter("mail");
//			String randomNumber=String.valueOf(generatedRandom);
//			emailToRecipient = mail;
//			
//			final String emailMessage = randomNumber;
//		
//			mailSenderObj.send(new MimeMessagePreparator() {
//				public void prepare(MimeMessage mimeMessage) throws Exception {
//
//					MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
//					mimeMsgHelperObj.setTo(emailToRecipient);
//					mimeMsgHelperObj.setFrom(emailFromRecipient);
//					mimeMsgHelperObj.setText(emailMessage);
//
//					}});
//			model.addAttribute("codeForEmail", randomNumber);
//			model.addAttribute("usernameForEmail", username);
//			model.addAttribute("passwordForEmail", password);
//			model.addAttribute("emailForEmail", mail);
//			request.getSession().setAttribute("cart",randomNumber);
//			request.getSession().setAttribute("username",username);
//			request.getSession().setAttribute("password",password);
//			request.getSession().setAttribute("mail",mail);
////			final String updateQuery = "INSERT INTO SwFrGrdn(username,password,mail) VALUES (?,?,?)";
////			jdbcTemplate.update(updateQuery,username,password,mail);
//
//			return "inputCodeForEmail";
////			return "SuccesRegister";
//		}
 
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
			 		 logger.info("CatchedMistake--"+e);
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
	 
	 
	 
	
	 
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
//End Parts Of LogIn And Register//End Parts Of LogIn And Register//End Parts Of LogIn And Register
	
	 
	 
	 
	 @RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
	    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
	            @RequestParam("code") String code) throws IOException {
	        Product product = null;
	        if (code != null) {
	            product = this.productDAO.findProduct(code);
	        }
	        if (product != null && product.getImage() != null) {
	            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	            response.getOutputStream().write(product.getImage());
	        }    
	        response.getOutputStream().close();
	    }
		
		// GET: Show product.
	    @RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	    public String product(Model model, @RequestParam(value = "code", defaultValue = "") String code,
	    		@ModelAttribute("ThatCheckOfQuantity") String CheckOfQuantityAuuuu) {
	    	
	    	ProductInfo productInfo = null;
 
	        model.addAttribute("ThatCheckOfQuantity",CheckOfQuantityAuuuu);   
	        
	        if (code != null && code.length() > 0) {
	            productInfo = productDAO.findProductInfo(code);
	        }
	        if (productInfo == null) {
	            productInfo = new ProductInfo();
	            productInfo.setNewProduct(true);
	            
	            
	        }
	        model.addAttribute("productForm", productInfo);

	        model.addAttribute("listOfCategoryTypes", HashMaps.getCategories());
	        model.addAttribute("listOfSecionTypes", HashMaps.getSections());
	        model.addAttribute("listOfBrands", HashMaps.getBrands());
	       
	        
	        return "Admin/Create Product/CreateProduct";
	    }
	    
	    // POST: Save product
	    @RequestMapping(value = {"/product" }, method = RequestMethod.POST)
	    // Avoid UnexpectedRollbackException (See more explanations)
//	    @Transactional(propagation = Propagation.NEVER)
	    public String productSave(Model model, //
	            @ModelAttribute("productForm") @Validated ProductInfo productInfo, //
	            BindingResult result, //
	            final RedirectAttributes redirectAttributes
	           ,@ModelAttribute("SortType") SortType myform ) {
	
	    	
	    	logger.info("First");
	    	ProductInfoValidator userValidator = new ProductInfoValidator();
	        userValidator.validate(productInfo, result);
	    	
	        logger.info("Second");
	    	if (result.hasErrors()) {
	    		   		
	    		model.addAttribute("listOfCategoryTypes", HashMaps.getCategories());
		        model.addAttribute("listOfSecionTypes", HashMaps.getSections());
		        model.addAttribute("listOfBrands", HashMaps.getBrands());
		        
		        return "Admin/Create Product/CreateProduct";
		      }
	    	
	    	logger.info("Third");
//	    	part for to do something with many choosen select option
	    	
	    	String[] array;
	    	
	    	array = productInfo.getCategory().split(",");
	    	String category = String.join("#", array);
	    	category = "#"+category;
	    	
	    	
	    	array = productInfo.getSection().split(",");
	    	String section = String.join("#", array);
	    	section = "#"+section;
	    	
	    	array = productInfo.getBrand().split(",");
	    	String brand = String.join("#", array);
	    	brand = "#"+brand;
	  
	    	productInfo.setBrand(brand);
	    	productInfo.setCategory(category+section);

	    	
//	    	RedirectAttributes redirectAttributes
//	    	@ModelAttribute("mapping1Form") int mapping1FormObject
	    	
	    	
	    	String QuantityIsNumbers = productInfo.getQuantity();
	    	model.addAttribute("BooleanForQuantity","true");

	    	if(QuantityIsNumbers.matches("[0-9]+")) {}
	    	else {
//		    	redirectAttributes.addFlashAttribute("ThatCheckOfQuantity", "BooleanForQuantity");
	    		return "redirect:/product?ThatCheckOfQuantity=true&codeTransit";
	    	}
	
	    	//try to take from database code +1
	    	
	    	String sql = "SELECT MAX(code) FROM Products";
	    	 
	    	String CodeForItem = jdbcTemplate.queryForObject(sql, String.class);
	    	
//	    	That try catch block for checking on null
//	    	That need when we have not in database items
//	    	That need to start point count of out items
	    	try {
	    	CodeForItem=String.valueOf(Integer.parseInt(CodeForItem)+1);
	    	}
	    	catch(NumberFormatException e) {
	    	CodeForItem="24000";
	    	}
	    	
	    	//	    	}
	    	//end
	    	productInfo.setRating(3);
	    	//ten is undefined rating
	    	
//	    	WE should create page of error
	        if (result.hasErrors()) {
	            return "Admin/Create Product/CreateProduct";
	        }
	        try {
	            productDAO.saveOwnMethod(productInfo,CodeForItem);
	        } catch (Exception e) {
	            // Need: Propagation.NEVER?
	            String message = e.getMessage();
	            model.addAttribute("message", message);
	            // Show product form.
	            return "Admin/Create Product/CreateProduct";
	 
	        }
	        return "redirect:/CatalogOfitems";
	    }
	 
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    @RequestMapping(value = "/ForTestingPage", method = RequestMethod.POST)
//		public String ForTestingPage(@Valid @ModelAttribute("ProductErrors")  ProductInfo productinfo, 
//				final BindingResult bindingResult, Model model) {
//			
//			 if (bindingResult.hasErrors()) {
//		         return "ForTestingPage";
//		      }
//		      model.addAttribute("name", productinfo.getName());
//		      model.addAttribute("quantity", productinfo.getQuantity());
//		      model.addAttribute("id", student.getId());
//
//		      return "We should remove this folder/result";
//		}
//		
//		@RequestMapping(value = "/ForTestingPage", method = RequestMethod.GET)
//		public ModelAndView ProductErrors(){
//		      return new ModelAndView("We should remove this folder/ForTestingPage", "command", new ProductInfo());
//		}
//	    
//	    
//	    
	    
	    
	    
	    
//	    Transit
//	    ProductFormForInpujt
	    
	    
	    
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
	    
	    
	    @RequestMapping(value = {"/productEditForViewPage" }, method = RequestMethod.GET)
	    public String productEditForViewPage(Model model, @RequestParam(value = "code", defaultValue = "") String code
	    		,final RedirectAttributes redirectAttributes,
	    		@ModelAttribute("ThatCheckOfQuantity") String CheckOfQuantityAuuuu,
	    		@ModelAttribute("WeUseThisCodeForQuantityNOOOOW") String WeUseThisCodeForQuantityNOOOOW,
	    		@ModelAttribute("codeTransit") String codeTransit) {
		        ProductInfo productInfo = null;
	
		        model.addAttribute("ThatCheckOfQuantity",CheckOfQuantityAuuuu);

	        if (code != null && code.length() > 0) {
	            productInfo = productDAO.findProductInfo(code);
	        }
	        if (productInfo == null) {
	            productInfo = new ProductInfo();
	            productInfo.setNewProduct(true);
	        }
//		    }//end else
	        
	        
//	        I should find there product
	        model.addAttribute("productFormForEdit", productInfo);
	        model.addAttribute("CodeOfProduct", code);
	        
	  
	        redirectAttributes.addFlashAttribute("CodeOfProductThatForProductEditPost", code);
	      
	        return "Admin/Create Product/CreateProductForEdit-SameAsCreateProduct";
	    }
	  
	    
	    
	    
	    
	    @RequestMapping(value = { "/productEditForViewPage" }, method = RequestMethod.POST)
	    // Avoid UnexpectedRollbackException (See more explanations)
//	    @Transactional(propagation = Propagation.NEVER)
	    public String productSaveEditForViewPage(Model model, //
	            @ModelAttribute("productFormForEdit") @Validated ProductInfo productInfo, //
	            final BindingResult result, //
	            @ModelAttribute("ProductInfo") @Validated ProductInfo productinfo
				) {
	 	    
	    	
	    	
	    	ProductInfoValidator userValidator = new ProductInfoValidator();
	        userValidator.validate(productinfo, result);
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	if (result.hasErrors()) {
		         return "Admin/Create Product/CreateProductForEdit-SameAsCreateProduct";
		      }
	    	
	    	
	    	model.addAttribute("BooleanForQuantity","true");

	
//	    	
	        try {
	            productDAO.saveOwnMethod(productInfo,productInfo.getCode());
	        } catch (Exception e) {
	            // Need: Propagation.NEVER?
	            String message = e.getMessage();
	            model.addAttribute("message", message);
	            // Show product form.
	            return "Admin/Create Product/CreateProductForEdit-SameAsCreateProduct";
	 
	        }
	        
	        if (result.hasErrors()) {
		         return "productEdit";
		      }
	     
//	        countTime=0;
	        return "redirect:/ViewProduct?code="+productInfo.getCode();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
// GET: Show product.
	    @RequestMapping(value = {"/productEdit" }, method = RequestMethod.GET)
	    public String productEdit(Model model, @RequestParam(value = "code", defaultValue = "") String code
	    		,final RedirectAttributes redirectAttributes,
	    		@ModelAttribute("ThatCheckOfQuantity") String CheckOfQuantityAuuuu,
	    		@ModelAttribute("WeUseThisCodeForQuantityNOOOOW") String WeUseThisCodeForQuantityNOOOOW,
	    		@ModelAttribute("codeTransit") String codeTransit) {
		        ProductInfo productInfo = null;
		 	    	
		    model.addAttribute("ThatCheckOfQuantity",CheckOfQuantityAuuuu);
        
	        if (code != null && code.length() > 0) {
	            productInfo = productDAO.findProductInfo(code);
	        }
	        if (productInfo == null) {
	            productInfo = new ProductInfo();
	            productInfo.setNewProduct(true);
	        }
//		    }//end else
	        
	        
//	        I should find there product
	        model.addAttribute("productFormForEdit", productInfo);
	        model.addAttribute("CodeOfProduct", code);
	        
	  
	        redirectAttributes.addFlashAttribute("CodeOfProductThatForProductEditPost", code);
	     
	        
	        model.addAttribute("listOfCategoryTypes", HashMaps.getCategories());
	        model.addAttribute("listOfSecionTypes", HashMaps.getSections());
	        model.addAttribute("listOfBrands", HashMaps.getBrands());
	        
	        
	        model.addAttribute("SectionContainer",productDAO.findSection(code));
	        model.addAttribute("BrandContainer",productDAO.findBrand(code));
	        model.addAttribute("CategoryContainer",productDAO.findCategory(code));
	        
	        return "Admin/Create Product/CreateProductForEdit-SameAsCreateProduct";
	    }
	    
	    
	    
	    
	    

	    // POST: Save product
	    @RequestMapping(value = { "/productEdit" }, method = RequestMethod.POST)
	    // Avoid UnexpectedRollbackException (See more explanations)
//	    @Transactional(propagation = Propagation.NEVER)
	    public String productSaveEdit(Model model //
	           ,@ModelAttribute("productFormForEdit") @Valid ProductInfo productInfo 
	           ,final BindingResult result 
				) {
	 	  
	    	
	    	ProductInfoValidator userValidator = new ProductInfoValidator();
	        userValidator.validate(productInfo, result);
	    	 	
	    	if (result.hasErrors()) {
	    		
	    		model.addAttribute("SectionContainer",productDAO.findSection(productInfo.getCode()));
		        model.addAttribute("BrandContainer",productDAO.findBrand(productInfo.getCode()));
		        model.addAttribute("CategoryContainer",productDAO.findCategory(productInfo.getCode()));
	    		
//		        model.addAttribute("listOfCategoryTypes", HashMaps.getCategories());
		        model.addAttribute("listOfSecionTypes", HashMaps.getSections());
		        model.addAttribute("listOfBrands", HashMaps.getBrands());
		        
		         return "Admin/Create Product/CreateProductForEdit-SameAsCreateProduct";
		      }
	    	    	
	    	model.addAttribute("BooleanForQuantity","true");

	        try {
	            productDAO.saveOwnMethod(productInfo,productInfo.getCode());
	        } catch (Exception e) {
	            // Need: Propagation.NEVER?
	            String message = e.getMessage();
	            model.addAttribute("message", message);
	            // Show product form.
	            return "Admin/Create Product/CreateProductForEdit-SameAsCreateProduct";
	 
	        }
	        
	        if (result.hasErrors()) {
		         return "productEdit";
		      }

	        return "redirect:/CatalogOfitems";
	    }
	 
	 
	 
	 
	 
//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	  //Start Lists Of Items//Start Lists Of Items//Start Lists Of Items//Start Lists Of Items
	    
	    
	    @RequestMapping(value = "/DeleteCategory", method = RequestMethod.GET)
		public String DeleteCategoryFilter(Locale locale, Model model) {
	    	model.addAttribute("categorySort","");
			return "redirect:/CatalogOfitems";
		}
	    
	    @RequestMapping(value = "/DeleteSearchName", method = RequestMethod.GET)
		public String DeleteSearchFilter(Locale locale, Model model) {
	    	model.addAttribute("searchName","");
			return "redirect:/CatalogOfitems";
		}
	    
	    
	    
	    @RequestMapping(value = "/DeleteBrand", method = RequestMethod.GET)
		public String DeleteBrandFilter(Locale locale, Model model) {
	    	model.addAttribute("brandSort","");
			return "redirect:/CatalogOfitems";
		}
	    
	    @RequestMapping(value = "/DeletePrice", method = RequestMethod.GET)
		public String DeletePriceFilter(Locale locale, Model model) {
	    	model.addAttribute("priceSorting","");
			return "redirect:/CatalogOfitems";
		}
	    
	    @RequestMapping(value = "/DeleteRating", method = RequestMethod.GET)
		public String DeleteRatingFilter(Locale locale, Model model) {
	    	model.addAttribute("ratingSorting","");
			return "redirect:/CatalogOfitems";
		}
	    
	    
	    
	    @ModelAttribute("SortingVariables")
		   public SortingVariables createSortingTypesClassModel() {	
		      return new SortingVariables();
		   }

	    
	    @RequestMapping(value = "/CatalogOfitems", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	    public String productListToShopItemsPOST(HttpServletRequest request,Model model 
	            ,@RequestParam(value = "page", defaultValue = "1") int page
	                    
	            //sorting variables
	            
	            ,@ModelAttribute("searchName") String searchName
	            ,@ModelAttribute("sortBy") String sortBy
	            ,@ModelAttribute("categorySort") String categorySort
	            ,@ModelAttribute("brandSort") String brandSort
	            ,@ModelAttribute("priceSorting") String priceSorting
	            ,@ModelAttribute("ratingSorting") String ratingSorting
	            
	            ,@ModelAttribute("SortingVariables") SortingVariables sortingvariables
	            //... 

			) throws Exception {	

	    	
            logger.info(sortingvariables.getRatings()+"---KeySecond");

//    		sorting variables

            if(sortingvariables.getSearch() !=null) {
            	searchName = sortingvariables.getSearch();
    			model.addAttribute("searchName", sortingvariables.getSearch());
    		}
            
            if(sortingvariables.getRatings()!=null) {
            	ratingSorting = sortingvariables.getRatings();
    			model.addAttribute("ratingSorting", sortingvariables.getRatings());
    		}
            
            if(sortingvariables.getBrands()!=null) {
            	brandSort = sortingvariables.getBrands();
    			model.addAttribute("brandSort", sortingvariables.getBrands());
    		}
            
            if(sortingvariables.getPrices()!=null) {
            	priceSorting = sortingvariables.getPrices();
    			model.addAttribute("priceSorting", sortingvariables.getPrices());
    		}
            
    		if(sortingvariables.getCategories()!=null) {
    			categorySort= sortingvariables.getCategories();
    			model.addAttribute("categorySort",sortingvariables.getCategories());
    		}
    	
    	
	    	if(sortingvariables.getSortBy()!=null)
	    	{
	    		sortBy=sortingvariables.getSortBy();
		    	model.addAttribute("sortBy",sortingvariables.getSortBy());
	    	}
	    	
//	    	...
	    	
	    	
//			display products(8 on one page) 
	    	
			final int maxResult = 8;
	        final int maxNavigationPage = 100;
	 
	        PaginationResult<ProductInfo> result = 
	        		productDAO
	        		.queryProducts(page,maxResult, maxNavigationPage, searchName, sortBy ,categorySort, brandSort , priceSorting, ratingSorting);
	       
	        model.addAttribute("paginationProducts", result);
	        
//	        ...
	        
//	        for sorting menu	
	        model.addAttribute("listOfBrands", HashMaps.getBrands());
	        model.addAttribute("listOfSortingTypes", HashMaps.getBySort());
	        model.addAttribute("listOfPrice", HashMaps.getPrices());
	        model.addAttribute("listOfRating", HashMaps.getRating());
	        model.addAttribute("listOfSectionsMain", HashMaps.getSectionsForSideMenu());
//	        ...
	        
			return "CatalogOfItems/CatalogOfitems";
		}	    
	    

//	    AJAX
	    @RequestMapping(value={ "/shoppingListRemoveProductFromView" }, method = RequestMethod.POST)
	    public @ResponseBody AjaxResponseBody removeProductFromListHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") String code,
	            @RequestParam(value = "id", defaultValue = "") String id) {

	    	logger.info("I was here"+id);
	    	AjaxResponseBody ajaxresponse = new AjaxResponseBody();

	    	
	    	if(productDAO.chechIfItemExistInOrderList(id)){
	    		ajaxresponse.setMsg("Перед удалением продукта, необходимо удалить заказ с этим продуктом из листа заказов.");
	    		return ajaxresponse;
	    	}
	    	
	    	productDAO.deleteProduct(code);
	    	

	    	ajaxresponse.setMsg("Вы успешно удалили продукт");
	    	

	        return ajaxresponse;
	    }
	    
	    
	  //AJAX
	    @RequestMapping(value = { "/AddToCart" }, method = RequestMethod.GET)
	    public String AddToCartPlusOne(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") String code) {
	    	
	    	if(code!=null && !code.equals("")) {
	    	CountedShoppingCart+=1;
	    	}
	    	
	    	model.addAttribute("CartForItemsOfTopMenu",CountedShoppingCart);
	    	
	        Product product = null;
	        if (code != null && code.length() > 0) {
	            product = productDAO.findProduct(code);
	        }
	        if (product != null) {
	 
	            // Cart info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request); 
	            
	            ProductInfo productInfo = new ProductInfo(product);
	            cartInfo.setCodeFromCartInfo(code);
	            cartInfo.addProduct(productInfo, 1);
	        }
	            
        CartInfo myCart = Utils.getCartInSession(request);


        model.addAttribute("cartForm", myCart);
        

	     return "redirect:/ReviewRatingComment?code="+code;
	    }
	    
	    //AJAX
	    @RequestMapping(value = { "/DuplicatedbuyProduct" }, method = RequestMethod.POST)
	    public @ResponseBody AjaxResponseBody DuplicatebuyProductPOSTAJAX(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") String code,
	            @RequestParam(value = "page", defaultValue = "1") int page,
	            @RequestParam(value = "ItemsOfCart", defaultValue = "1") String ItemsOfCart,
	            RedirectAttributes redirectAttributes) {
	    	
	    
	    	redirectAttributes.addFlashAttribute("mapping1Form", page);

	    	if(code!=null && !code.equals("")) {
	    	CountedShoppingCart+=1;
	    	}
	    	
	    	model.addAttribute("CartForItemsOfTopMenu",CountedShoppingCart);
	    	
	        Product product = null;
	        if (code != null && code.length() > 0) {
	            product = productDAO.findProduct(code);
	        }
	        if (product != null) {
	 
	            // Cart info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request); 
	            
	            ProductInfo productInfo = new ProductInfo(product);
	            cartInfo.setCodeFromCartInfo(code);
	            cartInfo.addProduct(productInfo, 1);
	        }
	            
        CartInfo myCart = Utils.getCartInSession(request);


        model.addAttribute("cartForm", myCart);
        

        AjaxResponseBody result = new AjaxResponseBody();
        result.setPage(String.valueOf(page));
        result.PlusOneToAmountItemsOfCartForTopMenu(ItemsOfCart);

        
        
	        // Redirect to shoppingCart page.
	     return result;
	    }
	    
	    
	    @RequestMapping({ "/DuplicatedbuyProduct" })
	    public String DuplicatedlistProductHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") String code,
	            @RequestParam(value = "page", defaultValue = "1") int page,
	            RedirectAttributes redirectAttributes) {
	    	
	    	

	    	
	    	redirectAttributes.addFlashAttribute("mapping1Form", page);

	        Product product = null;
	        if (code != null && code.length() > 0) {
	            product = productDAO.findProduct(code);
	        }
	        if (product != null) {
	 
	            // Cart info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request); 
	            
	            ProductInfo productInfo = new ProductInfo(product);
	            cartInfo.setCodeFromCartInfo(code);
	            cartInfo.addProduct(productInfo, 1);
	        }
	        // Redirect to shoppingCart page.
	        return "redirect:/DuplicatedshoppingCart";
	    }
		
		
		// POST: Update quantity of products in cart.
	    @RequestMapping(value = { "/DuplicatedshoppingCart" }, method = RequestMethod.POST)
	    public String DuplicatedshoppingCartUpdateQty(HttpServletRequest request, //
	            Model model, //
	            @ModelAttribute("cartForm") CartInfo cartForm,
	            @RequestParam(value = "page", defaultValue = "1") int page) {

	        CartInfo cartInfo = Utils.getCartInSession(request);
	        cartInfo.updateQuantity(cartForm);
	        
	        // Redirect to shoppingCart page.
	        return "redirect:/DuplicatedshoppingCart";
	    }
	 
	    // GET: Show Cart
	    @RequestMapping(value = { "/DuplicatedshoppingCart" }, method = RequestMethod.GET)
	    public String DuplicatedshoppingCartHandler(HttpServletRequest request, Model model,
	    		@RequestParam(value = "page", defaultValue = "1") int page,
	    		@ModelAttribute("mapping1Form") int mapping1FormObject) {
	        CartInfo myCart = Utils.getCartInSession(request);

	        model.addAttribute("cartForm", myCart);
	        
	        
	        return "redirect:/CountShoppingCart";
	    }
		
	    

	   
	    
	    
	    
	    
	    
	    
	    
	    
	 // POST: Update quantity of products in cart.
	    @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.POST)
	    public String shoppingCartUpdateQty(HttpServletRequest request, //
	            Model model, //
	            @ModelAttribute("cartForm") CartInfo cartForm) {
	 
	        CartInfo cartInfo = Utils.getCartInSession(request);
	        cartInfo.updateQuantity(cartForm);

	        return "redirect:/shoppingCart";
	    }
	 
	    // GET: Show Cart
	    @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
	    public String shoppingCartHandler(HttpServletRequest request, Model model) {
	        CartInfo myCart = Utils.getCartInSession(request);
	        
	        model.addAttribute("cartForm", myCart);        
	
	        return "Cart/Cart-WithItems-CombinationAll";
	    }
	    
	    
	
	    
	    @RequestMapping({ "/shoppingCartRemoveProduct" })
	    public String removeProductHandler(HttpServletRequest request, Model model, //
	    		@ModelAttribute("cartForm") CartInfo cartForm,	
	    		@RequestParam(value = "quantity", defaultValue = "") String quantity,
	            @RequestParam(value = "code", defaultValue = "") String code) {
	    	
	    	int AskedQuantity=0;
	    	
	    	Product product = null;
	        if (code != null && code.length() > 0) {
	            product = productDAO.findProduct(code);
	        }
	        if (product != null) {
	 
	            // Cart Info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request); 
	            ProductInfo productInfo = new ProductInfo(product);
	            
	            AskedQuantity = cartInfo.findQuantityByProduct(productInfo);

	            cartInfo.removeProduct(productInfo);
	            
	            
	        }
	        	
	        
	        
	        if(CountedShoppingCart>0) 
	        {
	        CountedShoppingCart-=AskedQuantity;
	        model.addAttribute("CartForItemsOfTopMenu", CountedShoppingCart);
	        }
	        
	        return "redirect:/shoppingCart";
	    }
	    
	    	
	    
	    

	    
	    
	    
	    
	    
	    
	    
//	    / GET: Enter customer information.
	    @RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.GET)
	    public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {
	 
	        CartInfo cartInfo = Utils.getCartInSession(request);
	      
	        // Cart is empty.
	        if (cartInfo.isEmpty()) {
	             
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        }
	 
	        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
	        if (customerInfo == null) {
	            customerInfo = new CustomerInfo();
	        }
	 
	        model.addAttribute("customerForm", customerInfo);
	 
	        return "ConfirmationOfOrder/ConfirmationOfOrder";
	    }
	 
	    // POST: Save customer information.
	    @RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.POST)
	    public String shoppingCartCustomerSave(HttpServletRequest request, //
	            Model model, //
	            @ModelAttribute("customerForm") @Validated CustomerInfo customerForm, //
	            BindingResult result, //
	            final RedirectAttributes redirectAttributes) {
	  
	    	
	    	CartValidator cartValidator = new CartValidator();
	        cartValidator.validate(customerForm, result);
	    	
	        
	        // If has Errors.
	        if (result.hasErrors()) {
	            customerForm.setValid(false);
	            // Forward to reenter customer info.
	            return "ConfirmationOfOrder/ConfirmationOfOrder";
	        }
	 
	        customerForm.setValid(true);
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        cartInfo.setCustomerInfo(customerForm);
	 
	        // Redirect to Confirmation page.
	        return "redirect:/ContinueConfirmationOfOrder";
	    }
	    
	    
	    
	    
	    @RequestMapping(value = { "/orderList" }, method = RequestMethod.GET)
	    public String orderList(Model model, //
	            @RequestParam(value = "page", defaultValue = "1") String pageStr) {
	        int page = 1;
	        try {
	            page = Integer.parseInt(pageStr);
	        } catch (Exception e) {
	        }
	        final int MAX_RESULT = 20;
	        final int MAX_NAVIGATION_PAGE = 100;
	 
	        PaginationResult<OrderInfo> paginationResult //
	        = orderDAO.listOrderInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);
	 
	        model.addAttribute("paginationResult", paginationResult);
	        return "Admin/Order List/OrderList-CombinationOfAll";
	    }
	    
	    
	    
	    @RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	    public String orderView(Model model, @RequestParam("orderId") String orderId) {
	        OrderInfo orderInfo = null;
	        if (orderId != null) {
	            orderInfo = this.orderDAO.getOrderInfo(orderId);
	        }
	        if (orderInfo == null) {
	            return "redirect:/orderList";
	        }
	        List<OrderDetailInfo> details = this.orderDAO.listOrderDetailInfos(orderId);
	        orderInfo.setDetails(details);
	 
	        model.addAttribute("orderInfo", orderInfo);
 
	        return "Admin/Order List/ViewProduct-Order";
	    }
	    
	    @RequestMapping(value = { "/deleteOrder" }, method = RequestMethod.GET)
	    public String orderDelete(Model model, @RequestParam("orderId") String orderId) {
	
	    	String deleteSqlFromOrder_Details = "DELETE FROM Order_Details WHERE ORDER_ID="+"'"+orderId+"'";
	    	jdbcTemplate.update(deleteSqlFromOrder_Details);
//	    	orderDAO.deleteOrderDetailsORDERID(orderId);
	    	orderDAO.deleteOrders(orderId);
	    	orderDAO.deleteOrderDetails(orderId);

	        return "redirect:/orderList";
	    }
	    
	    
	    @RequestMapping(value = { "/solded" }, method = RequestMethod.GET)
	    public String orderSolded(Model model, @RequestParam("orderId") String orderId) {
	    		
	    	List<OrderDetailInfo> details = this.orderDAO.listOrderDetailInfos(orderId);

	    	for(OrderDetailInfo orderdetailinf : details) {
	    	productDAO.UpdateQuantitiesOfItems(orderdetailinf.getProductCode(), orderdetailinf.getQuanity());	
	    	}
	    	
	        return "redirect:/deleteOrder?orderId="+orderId;
	    }
	    
	    @RequestMapping(value = { "/SendMessageByPhone" }, method = RequestMethod.GET)
	    public String orderSendMessage(Model model, @RequestParam("orderId") String orderId) {
	       
	    	 List<String> list = orderDAO.listOrderInfoGetSingleItemOrSingleQuery(orderId);
	    	
	    	 
//	    	String price=POJO.transformPrice(list.get(0)); 
//	    	logger.info(price);
	    	String PHONEMESSAGE = 
	    			"Ваш заказ № "+ list.get(1) +" передан курьеру. "
	    			+ "Ожидайте доставку."
	    			+ "К оплате "+ list.get(0) +" гривны ";
	    			
	    	String PHONE = list.get(2);
	    	
	    	
	    	SendSms.SendSmsWithTwillo(PHONEMESSAGE,PHONE);
	    	
	    	return "redirect:/orderList";
	    }
	    
	    
	    
	    //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items   
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	  //End Lists Of Items//End Lists Of Items//End Lists Of Items//End Lists Of Items 
	    
	    
	 // GET: Review Cart to confirm.
	    @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.GET)
	    public String shoppingCartConfirmationReview(HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	 
	        return "shoppingCartConfirmation";
	    }
	 
	    // POST: Send Cart (Save).
	    @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.POST)
	    // Avoid UnexpectedRollbackException (See more explanations)
//	    @Transactional(propagation = Propagation.NEVER)
	    public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	        try {
	            orderDAO.saveOrderWithEditOfQuantity(cartInfo);
	        } catch (Exception e) {
	            // Need: Propagation.NEVER?
	            return "shoppingCartConfirmation";
	        }
	        // Remove Cart In Session.
	        Utils.removeCartInSession(request);
	         
	        // Store Last ordered cart to Session.
	        Utils.storeLastOrderedCartInSession(request, cartInfo);
	 
	        // Redirect to successful page.
	        return "redirect:/shoppingCartFinalize";
	    }
	    
	    @RequestMapping(value = { "/shoppingCartFinalize" }, method = RequestMethod.GET)
	    public String shoppingCartFinalize(HttpServletRequest request, Model model) {
	 
	        CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);
	 
	        if (lastOrderedCart == null) {
	            return "redirect:/shoppingCart";
	        }
	        
	        
	        CountedShoppingCart=0;
	        model.addAttribute("CartForItemsOfTopMenu", CountedShoppingCart);
	        
	        
	        return "StatusOfOrder/SuccessStatusOrder";
	    }
	 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	 // GET: Review Cart to confirm.
	    @RequestMapping(value = { "/ContinueConfirmationOfOrder" }, method = RequestMethod.GET)
	    public String shoppingCartConfirmationReviewContinueConfirmationOfOrder(HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	 
	        return "ContinueConfirmationOfOrder/ContinueConfirmationOfOrder";
	    }
	 
	    // POST: Send Cart (Save).
	    @RequestMapping(value = { "/ContinueConfirmationOfOrder" }, method = RequestMethod.POST)
	    // Avoid UnexpectedRollbackException (See more explanations)
//	    @Transactional(propagation = Propagation.NEVER)
	    public String shoppingCartConfirmationSaveASd(HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	        try {
	            orderDAO.saveOrder(cartInfo);
	        } catch (Exception e) {
	            // Need: Propagation.NEVER?
	            return "shoppingCartConfirmation";
	        }
	        // Remove Cart In Session.
	        Utils.removeCartInSession(request);
	         
	        // Store Last ordered cart to Session.
	        Utils.storeLastOrderedCartInSession(request, cartInfo);
	 
	        // Redirect to successful page.
	        return "redirect:/shoppingCartFinalize";
	    }
	    
	    
	    
	  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		@RequestMapping(value = "/ViewProduct", method = RequestMethod.GET)
		public String ViewProduct(Locale locale, Model model,
				HttpServletRequest request, 
	            @RequestParam(value = "code", defaultValue = "") String code,
	            ServletRequest session            
	            ,@ModelAttribute("recentlyvieweditems") RecentlyViewedItems recentlyvieweditems
				) {
			

				 productDAO.saveLastView(code);

			
			
			recentlyvieweditems.concatId(code+" ");
			model.addAttribute("recentlyvieweditems",recentlyvieweditems);
			
			
			ProductInfo productInfo = null;
			productInfo = productDAO.queryProductByCode(code);
			
	        model.addAttribute("productFormOfViewPage", productInfo);
      

	        String sqlForMaxNumberOfRole_IDColumn = "SELECT COUNT(product_id) FROM comments WHERE product_id="+code; 
	    	String revises = jdbcTemplate.queryForObject(sqlForMaxNumberOfRole_IDColumn, String.class);

	        model.addAttribute("Rivises",revises);
	        

	        String sqlRevisesNotRecommend = "SELECT COUNT(wouldRecommendThisToAFriend) FROM comments WHERE wouldRecommendThisToAFriend=0 AND product_id="+code+";"; 
	        String sqlRevisesWouldRecommend = "SELECT COUNT(wouldRecommendThisToAFriend) FROM comments WHERE wouldRecommendThisToAFriend=1 AND product_id="+code+";"; 

	    	Double GeneralNumberOfVotes = Double.parseDouble(jdbcTemplate.queryForObject(sqlRevisesNotRecommend, String.class));
	    	Double VotesOfYes = Double.parseDouble(jdbcTemplate.queryForObject(sqlRevisesWouldRecommend, String.class));
 
	    	if(GeneralNumberOfVotes==0) {GeneralNumberOfVotes=(double) 1;}
	    	if(VotesOfYes==0) {VotesOfYes=(double) 0;}
	    	
	    	double percentOfRevises= (VotesOfYes/GeneralNumberOfVotes)*100;
	       
	        model.addAttribute("percentOfRevises",percentOfRevises);
	        
	        
//	        Recently viewed
	        PaginationResult<ProductInfo> result = 
	        		productDAO
	        		.queryProducts(recentlyvieweditems.getId());
	        model.addAttribute("paginationProducts", result);	 
	        
//	        ProductInfo ReviewItemsInfo = null;
//			productInfo = productDAO.queryProducts(code);
//			model.addAttribute("paginationProducts", ReviewItemsInfo);
//			
//	        ...
	        
//	        Number reviews of rating
	        
	        model.addAttribute("NumberReviews", productDAO.queryNumberReviews(code));
	        
	        
	        
//	        ...
	        
			return "ViewProduct/ViewProduct";
		}
		
		@RequestMapping(value = "/ViewProductEnterForSuccessComment", method = RequestMethod.GET)
		public String ViewProductDuplicated(Locale locale, Model model,
				HttpServletRequest request, 
	            ServletRequest session,
	            @RequestParam(value = "code", defaultValue = "") String code
	            ) {

			ProductInfo productInfo = null;
			productInfo = productDAO.queryProductByCode(code);
			
	        model.addAttribute("productFormOfViewPage", productInfo);

			return "ViewProduct/ViewProduct";
		}
	    
	    
	    
	
		
		 @RequestMapping(value = { "/productImageForViewPage" }, method = RequestMethod.GET)
		    public void productImageForViewPage(HttpServletRequest request, HttpServletResponse response, Model model,
		            @RequestParam("code") String code) throws IOException {
		        Product product = null;
		        if (code != null) {
		            product = this.productDAO.findProduct(code);
		        }
		        if (product != null && product.getImage() != null) {
		            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		            response.getOutputStream().write(product.getImage());
		        }    
		        response.getOutputStream().close();
		    }
		 
		 @RequestMapping(value = { "/DataOfCreateForViewPage" }, method = RequestMethod.GET)
		    public void DataOfCreateForViewPage(HttpServletRequest request, HttpServletResponse response, Model model,
		            @RequestParam("code") String code) throws IOException {
		        Product product = null;
		        if (code != null) {
		            product = this.productDAO.findProduct(code);
		        }
		        if (product != null && product.getCreateDate() != null) {
		        	
		            response.getOutputStream().write(1231321);   
//		            Integer.parseInt(String.valueOf(product.getCreateDate()))
		        }    
		        response.getOutputStream().close();
		    }

		 
		 
		 
			@RequestMapping(value = "/ReviewRatingComment", method = RequestMethod.GET)
			public String ReviewRatingComment(Locale locale, Model model 
					,ServletRequest session
					,@RequestParam(value = "code", defaultValue = "") String code
//			    	,@ModelAttribute("codeForProduct") int codeProduct
					,@RequestParam(value = "page", defaultValue = "1") int page
					,@RequestParam(value = "name", defaultValue = "") String likeName
					,@RequestParam(value = "TransitTypeSorting", defaultValue = "ThatEmpty") String TransitedTypeOfSorting
					,@ModelAttribute("SortType") SortType myform
			    	,@RequestParam(value = "transitedString", defaultValue = "ThatEmpty") String transitedString	
					
					) {
	
				EditComment editcomment = new EditComment();
				model.addAttribute("EditComment", editcomment);
	
				if(code==null) {
					code=myform.getCode();
				}
		
				if(myform.getChoosenTypeOfSorting()!=null) {
			    	TransitedTypeOfSorting = myform.getChoosenTypeOfSorting();
			    	}
				
		        	model.addAttribute("AttributeForSelecetdFieldInDropMenu",TransitedTypeOfSorting);
			    	model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);

				
				ProductInfo productInfo = null;
				productInfo = productDAO.queryProductByCode(code);
				
		        model.addAttribute("productFormOfReviewRatingPage", productInfo);
		       						
				final int maxResult = 4;
		        final int maxNavigationPage = 100;
		 
		        PaginationResult<CommentInfo> result =
		        		commentDAO
		        		.queryComments(page,maxResult, maxNavigationPage, likeName, TransitedTypeOfSorting,code);
		        
	

		        //change there paginationResult class to own class pagination result
		        //
		        
				model.addAttribute("InfoAboutComments", result);

		        //There end that process of list
		        
				logger.info(code+"ForCheckingOfGetCode");

		        double valueOfRating=productDAO.queryRating(code);	      
		        model.addAttribute("RatingValueOfItem", valueOfRating);
		        
	
		        
//		        For sort type
		        Map< String, String > typesSort = new HashMap<String, String>();

		        typesSort.put("LowestRating", "Lowest rating");
		        typesSort.put("HigherRating", "Highest rating");
		        typesSort.put("Oldest", "Oldest");
		        typesSort.put("Newest", "Newest");
		        
		        
		        
//		        typesSort.put("MostHelpful", "Most helpful");

		        
		        
		        if(myform.getChoosenTypeOfSorting()!=null) {
			    	TransitedTypeOfSorting = myform.getChoosenTypeOfSorting();
			    }
			    
		        model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);
			    			    	
		        
		        
		        
		        model.addAttribute("listOfSortingTypes", typesSort);

		        model.addAttribute("SortType", new SortType());
//		        For sort type
		        
		        List<String> numbersList = new ArrayList<String>();
		        numbersList.add("Yes, I would recommend this to a friend");
		        numbersList.add("No, I would not recommed this to a friend");
		        //....
		        
		        
		    	model.addAttribute("numberList",numbersList);  
		        
//		        
//		        logger.info("Keycheck--"+result.dateTime);
		        
		        
		        model.addAttribute("Anonymous","Anonymous");
	        
		        return "ReviewRatingComment/ReviewRatingComment";
			}		 
		 
		
			
//		 @RequestMapping(value = "/ReviewRatingCommentAfterEdit", method = RequestMethod.GET)
//			public String ReviewRatingCommentAfterEdit(Locale locale, Model model 
//					,ServletRequest session
//					,@RequestParam(value = "code", defaultValue = "") String code
////			    	,@ModelAttribute("codeForProduct") int codeProduct
//					,@RequestParam(value = "page", defaultValue = "1") int page
//					,@RequestParam(value = "name", defaultValue = "") String likeName
//					,@RequestParam(value = "TransitTypeSorting", defaultValue = "ThatEmpty") String TransitedTypeOfSorting
//					,@ModelAttribute("SortType") SortType myform
//			    	,@RequestParam(value = "transitedString", defaultValue = "ThatEmpty") String transitedString	
//					
//					) {
//	
//				EditComment editcomment = new EditComment();
//				model.addAttribute("EditComment", editcomment);
//	
//				if(code==null) {
//					code=myform.getCode();
//				}
//		
//				if(myform.getChoosenTypeOfSorting()!=null) {
//			    	TransitedTypeOfSorting = myform.getChoosenTypeOfSorting();
//			    	}
//				
//		        	model.addAttribute("AttributeForSelecetdFieldInDropMenu",TransitedTypeOfSorting);
//			    	model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);
//
//				
//				ProductInfo productInfo = null;
//				productInfo = productDAO.queryProductByCode(code);
//				
//		        model.addAttribute("productFormOfReviewRatingPage", productInfo);
//		       						
//				final int maxResult = 4;
//		        final int maxNavigationPage = 100;
//		 
//		        PaginationResult<CommentInfo> result =
//		        		commentDAO
//		        		.queryComments(page,maxResult, maxNavigationPage, likeName, TransitedTypeOfSorting,code);
//		        
//	
//
//		        //change there paginationResult class to own class pagination result
//		        //
//		        
//				model.addAttribute("InfoAboutComments", result);
//
//		        //There end that process of list
//		        
//				logger.info(code+"ForCheckingOfGetCode");
//
//		        double valueOfRating=productDAO.queryRating(code);	      
//		        model.addAttribute("RatingValueOfItem", valueOfRating);
//		        
//	
//		        
////		        For sort type
//		        Map< String, String > typesSort = new HashMap<String, String>();
//
//		        typesSort.put("LowestRating", "Lowest rating");
//		        typesSort.put("HigherRating", "Highest rating");
//		        typesSort.put("Oldest", "Oldest");
//		        typesSort.put("Newest", "Newest");
//		        
//		        
//		        
////		        typesSort.put("MostHelpful", "Most helpful");
//
//		        
//		        
//		        if(myform.getChoosenTypeOfSorting()!=null) {
//			    	TransitedTypeOfSorting = myform.getChoosenTypeOfSorting();
//			    }
//			    
//		        model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);
//			    			    	
//		        
//		        
//		        
//		        model.addAttribute("listOfSortingTypes", typesSort);
//
//		        model.addAttribute("SortType", new SortType());
////		        For sort type
//		        
//		        List<String> numbersList = new ArrayList<String>();
//		        numbersList.add("Yes, I would recommend this to a friend");
//		        numbersList.add("No, I would not recommed this to a friend");
//		        //....
//		        
//		        
//		    	model.addAttribute("numberList",numbersList);  
//		        
////		        
////		        logger.info("Keycheck--"+result.dateTime);
//		        
//		        
//		        model.addAttribute("Anonymous","Anonymous");
//	        
//		        return "ReviewRatingComment/ReviewRatingComment";
//			}		 
		 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			@RequestMapping({ "/DuplicatedbuyProductFromViewPage" })
		    public String DuplicatedlistProductHandlerFromViewPage(HttpServletRequest request, Model model, //
		            @RequestParam(value = "code", defaultValue = "") String code,
		            @RequestParam(value = "page", defaultValue = "1") int page,
		            RedirectAttributes redirectAttributes) {
		    	
	
				model.addAttribute("CodeForProduct",code);
				
				redirectAttributes.addAttribute("CodeForProduct", code);
		    	redirectAttributes.addFlashAttribute("mapping1Form", page);

		        Product product = null;
		        if (code != null && code.length() > 0) {
		            product = productDAO.findProduct(code);
		        }
		        if (product != null) {
		 
		            // Cart info stored in Session.
		            CartInfo cartInfo = Utils.getCartInSession(request); 
		            
		            ProductInfo productInfo = new ProductInfo(product);
		            cartInfo.setCodeFromCartInfo(code);
		            cartInfo.addProduct(productInfo, 1);
		        }
		        // Redirect to shoppingCart page.
		        return "redirect:/DuplicatedshoppingCartFromViewPage";
		    }
			
			
			// POST: Update quantity of products in cart.
		    @RequestMapping(value = { "/DuplicatedshoppingCartFromViewPage" }, method = RequestMethod.POST)
		    public String DuplicatedshoppingCartUpdateQtyFromViewPage(HttpServletRequest request, //
		            Model model, //
		            @ModelAttribute("CodeForProduct") String check,
		            @ModelAttribute("cartForm") CartInfo cartForm,
		            @RequestParam(value = "page", defaultValue = "1") int page) {

		        CartInfo cartInfo = Utils.getCartInSession(request);
		        cartInfo.updateQuantity(cartForm);
		        
		        // Redirect to shoppingCart page.
		        return "redirect:/DuplicatedshoppingCartFromViewPage";
		    }
		 
		    // GET: Show Cart
		    @RequestMapping(value = { "/DuplicatedshoppingCartFromViewPage" }, method = RequestMethod.GET)
		    public String DuplicatedshoppingCartHandlerFromViewPage(HttpServletRequest request, Model model,
		    		@RequestParam(value = "page", defaultValue = "1") int page,
		    		@ModelAttribute("mapping1Form") int mapping1FormObject,
		    		@ModelAttribute("CodeForProduct") String check
		    		) {
		        CartInfo myCart = Utils.getCartInSession(request);
        
		        model.addAttribute("cartForm", myCart);
		        
		        
		        return "redirect:/CountShoppingCartFromViewPage";
		    }
			
		    

		    @RequestMapping(value = "/ViewProductForRepeat", method = RequestMethod.GET)
			public String ViewProductFromViewPage(Locale locale, Model model,
					HttpServletRequest request, 
//		            @RequestParam(value = "code", defaultValue = "") String code,
		            ServletRequest session,
		            @ModelAttribute("CodeForProduct") String code
		            
//		            ,RedirectAttributes redirectAttributes
		            ) {

				ProductInfo productInfo = null;
				productInfo = productDAO.queryProductByCode(code);
				
		        model.addAttribute("productFormOfViewPage", productInfo);

				return "ViewProduct/ViewProduct";
			}
			
			
			
			
			
			
			
			
			
			
			
	
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    @RequestMapping({ "/DuplicatedbuyProductFromViewPageOfComment" })
		    public String DuplicatedlistProductHandlerFromViewPageOfComment(HttpServletRequest request, Model model, //
		            @RequestParam(value = "code", defaultValue = "") String code,
		            @RequestParam(value = "page", defaultValue = "1") int page,
		            RedirectAttributes redirectAttributes) {
		 
				
				model.addAttribute("CodeForProduct",code);
				
				redirectAttributes.addAttribute("CodeForProduct", code);
		    	redirectAttributes.addFlashAttribute("mapping1Form", page);
    	
		        Product product = null;
		        if (code != null && code.length() > 0) {
		            product = productDAO.findProduct(code);
		        }
		        if (product != null) {
		 
		            // Cart info stored in Session.
		            CartInfo cartInfo = Utils.getCartInSession(request); 
		            
		            ProductInfo productInfo = new ProductInfo(product);
		            cartInfo.setCodeFromCartInfo(code);
		            cartInfo.addProduct(productInfo, 1);
		        }
		        // Redirect to shoppingCart page.
		        return "redirect:/DuplicatedshoppingCartFromViewPageOfComment";
		    }
			
			
			// POST: Update quantity of products in cart.
		    @RequestMapping(value = { "/DuplicatedshoppingCartFromViewPageOfComment" }, method = RequestMethod.POST)
		    public String DuplicatedshoppingCartUpdateQtyFromViewPageOfComment(HttpServletRequest request, //
		            Model model, //
		            @ModelAttribute("CodeForProduct") String check,
		            @ModelAttribute("cartForm") CartInfo cartForm,
		            @RequestParam(value = "page", defaultValue = "1") int page) {
	
		        CartInfo cartInfo = Utils.getCartInSession(request);
		        cartInfo.updateQuantity(cartForm);
		        
		        // Redirect to shoppingCart page.
		        return "redirect:/DuplicatedshoppingCartFromViewPageOfComment";
		    }
		 
		    // GET: Show Cart
		    @RequestMapping(value = { "/DuplicatedshoppingCartFromViewPageOfComment" }, method = RequestMethod.GET)
		    public String DuplicatedshoppingCartHandlerFromViewPageOfComment(HttpServletRequest request, Model model,
		    		@RequestParam(value = "page", defaultValue = "1") int page,
		    		@ModelAttribute("mapping1Form") int mapping1FormObject,
		    		@ModelAttribute("CodeForProduct") String check
		    		) {
		        CartInfo myCart = Utils.getCartInSession(request);
		        
		        model.addAttribute("cartForm", myCart);
		        
		        
		        return "redirect:/CountShoppingCartFromViewPageOfComment";
		    }
			
		    


		    
		    @RequestMapping(value = "/ViewProductForRepeatOfComment", method = RequestMethod.GET)
			public String ViewProductFromViewPageOfComment(Locale locale, Model model,
					HttpServletRequest request, 
		            ServletRequest session,
		            @ModelAttribute("CodeForProduct") String code
		            
		            ) {

		    	ProductInfo productInfo = null;
				productInfo = productDAO.queryProductByCode(code);
				
		        model.addAttribute("productFormOfReviewRatingPage", productInfo);

				return "ReviewRatingComment/ReviewRatingComment";
			}
		    
		    
		    
		    @JsonView(Views.Public.class)
		    @RequestMapping(value = "/MinusOfShoppingCart", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)    
		    public @ResponseBody AjaxResponseBody removeProductNumberFromCartMinusAJAX(HttpServletRequest request
		    		,Model model
		    		,@RequestParam(value = "quantity", defaultValue = "1") String quantity
		            ,@RequestParam(value = "code", defaultValue = "") String code
		            ,@RequestParam(value = "AmountItemsOfCartForTopMenu", defaultValue = "1") String AmountItemsOfCartForTopMenu
		            ,@ModelAttribute("cartForm") CartInfo cartForm) {


				AjaxResponseBody result = new AjaxResponseBody();
				
				result.setCode(code);
				result.MinusOneToQuantity(quantity);	
				result.MinusOneToAmountItemsOfCartForTopMenu(AmountItemsOfCartForTopMenu);
				
			
		        CartInfo cartInfo = Utils.getCartInSession(request);
		        cartInfo.updateProductOwnForMinusShoppingCart(code,Integer.parseInt(quantity));
		      
		         CountedShoppingCart-=1;
		         model.addAttribute("CartForItemsOfTopMenu", CountedShoppingCart);  
		      
			     model.addAttribute("cartForm", cartInfo);
			     model.addAttribute("CountedCart", CountedShoppingCart);        
    
			     

			     CustomerInfo customerInfo = cartInfo.getCustomerInfo();
			     model.addAttribute("customerForm", customerInfo);
			     
					
			        return result;
			  }
	    
//		    Ajax
			@JsonView(Views.Public.class)
		    @RequestMapping(value = "/PlusOfShoppingCart", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)    
		    public @ResponseBody AjaxResponseBody removeProductNumberFromCartPlusAjax(HttpServletRequest request
		    		,Model model
		    		,@RequestParam(value = "quantity", defaultValue = "1") String quantity
		            ,@RequestParam(value = "code", defaultValue = "") String code
		            ,@RequestParam(value = "AmountItemsOfCartForTopMenu", defaultValue = "1") String AmountItemsOfCartForTopMenu
		            ) {


				AjaxResponseBody result = new AjaxResponseBody();
				
				result.setCode(code);
				result.plusOneToQuantity(quantity);	
				result.PlusOneToAmountItemsOfCartForTopMenu(AmountItemsOfCartForTopMenu);
				
				CountedShoppingCart+=1;
				model.addAttribute("CartForItemsOfTopMenu", CountedShoppingCart);  
				      
				
		        CartInfo cartInfo = Utils.getCartInSession(request);
		        cartInfo.updateProductOwnForPlusShoppingCart(code,Integer.parseInt(quantity));
		        
			     model.addAttribute("cartForm", cartInfo);
			     model.addAttribute("CountedCart", CountedShoppingCart);        
    
			     CustomerInfo customerInfo = cartInfo.getCustomerInfo();
			     model.addAttribute("customerForm", customerInfo);
			     
			        return result;
			  }
		        
		
		    
		    
		    
		  
		    
		    
		    
		    
		    
		    
		    
		    
		    @RequestMapping(value = "/addComment", method = RequestMethod.GET)
			public String addComment(HttpServletRequest request,Locale locale, Model model,
					@RequestParam(value = "code", defaultValue = "") String code) {	
	    	

		        List<String> numbersList = new ArrayList<String>();
		        numbersList.add("Yes, I would recommend this to a friend");
		        numbersList.add("No, I would not recommed this to a friend");
		        //....
		        
		        
		        if(!model.containsAttribute("NameLoggedUser"))
		    	{
		            model.addAttribute("NameLoggedUser","Anonymous");
		    	}
		        
		    	model.addAttribute("numberList",numbersList);    	
		    	
		    	model.addAttribute("TemporaryVariable",code);
		    	model.addAttribute("CommentInfo", new CommentInfo());
		    	
		    	model.addAttribute("InfoProduct", productDAO.queryProductByCode(code));
		    	
				return "ItemsOfShop/addComment/addComment";
			}
		    
		    
		 
			@RequestMapping(value = "/addComment", method = RequestMethod.POST)	 
			public String AddingToDataBase(Model model
   				    ,@ModelAttribute("TemporaryVariable") String code
					,@ModelAttribute("NameLoggedUser") String name
				    ,@ModelAttribute("CommentInfo") @Validated CommentInfo commentinfo	    	
				    ,final BindingResult result
				    ) {		
				    CommentInfoValidator userValidator = new CommentInfoValidator();
			        userValidator.validate(commentinfo, result);

			        if (result.hasErrors()) {     	
				    	
				        List<String> numbersList = new ArrayList<String>();
				        numbersList.add("Yes, I would recommend this to a friend");
				        numbersList.add("No, I would not recommed this to a friend");
				        //....
				    	model.addAttribute("InfoProduct", productDAO.queryProductByCode(code));
				    	model.addAttribute("numberList",numbersList);    	

			          return "ItemsOfShop/addComment/addComment";
			        }

			        
				   commentinfo.setProduct_id(code);
				   commentinfo.setDateTime(new Date());	   
		    	   commentinfo.setNameOfUser(name);
		    	   commentinfo.setRecommend(String.valueOf(VariableValidator.checkRadio(commentinfo.getRecommend())));

		    	   //do rating
//		    	   Double rating = GetQuery.ReturnCount(commentinfo.getRating());
		    	   //...
		    	   Double rating = commentinfo.getRating();
		    	   commentinfo.setRating(rating);
		    	   logger.info(rating+"--CheckRating");
		    	   //there is should be  counted average of item with help of even comment .
		    	   try {
		    	   productDAO.updateRating(rating,code);
		    	   }
		    	   catch(Exception e) {
		    		   logger.error("Error with logger "+e);
		    	   }	   
		    	   
		    	    try {
			            commentDAO.saveComment(commentinfo,code);
			        } catch (Exception e) {
			            String message = e.getMessage();
			            model.addAttribute("message", message);
			            return "Admin/Create Product/CreateProduct";
			        }	    	
	
				return "ItemsOfShop/addComment/SucessAddComment";
			}
		    
		    
		    
		    
		    
		    
			@RequestMapping(value = "/EditComment", method = RequestMethod.GET)
			public String EditComment(Locale locale, Model model
					,@RequestParam("code") String code
					,@RequestParam("CodeOfItem") String codeitem
					,@RequestParam(value = "page", defaultValue = "") int page
					,@RequestParam(value = "likeName", defaultValue = "") String likeName
					,@RequestParam(value = "TransitTypeSorting", defaultValue = "ThatEmpty") String TransitedTypeOfSorting
					,@ModelAttribute("EditComment") @Validated EditComment editcomment
					,@ModelAttribute("SortType") SortType sorttypeClass
					) {	
				
				ProductInfo productInfo = null;
				productInfo = productDAO.queryProductByCode(codeitem);
				
		        model.addAttribute("productFormOfReviewRatingPage", productInfo);
		       						
				final int maxResult = 4;
		        final int maxNavigationPage = 100;
		 
		        PaginationResult<CommentInfo> result =
		        		commentDAO
		        		.queryComments(page,maxResult, maxNavigationPage, likeName, TransitedTypeOfSorting,codeitem);
		        
				model.addAttribute("InfoAboutComments", result);

			
		        double valueOfRating=productDAO.queryRating(codeitem);	      
		        model.addAttribute("RatingValueOfItem", valueOfRating);
		        
		        
		        if(sorttypeClass.getChoosenTypeOfSorting()!=null) {
			    	TransitedTypeOfSorting = sorttypeClass.getChoosenTypeOfSorting();
			    }
			    
		        model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);
		        model.addAttribute("listOfSortingTypes", HashMaps.gettypessort());
		        model.addAttribute("SortType", new SortType());
		    	model.addAttribute("numberList",HashMaps.getnumberlist());  
		        model.addAttribute("Anonymous","Anonymous");
				model.addAttribute("CommentInfo", commentDAO.findCommentInfo(code));
				model.addAttribute("ChoosendFormForEdit", code);

				return "ReviewRatingComment/ReviewRatingComment";
			}
		    
			

			
			
			@RequestMapping(value = "/EditComment", method = RequestMethod.POST)
			public String EditCommentPOST(Locale locale, Model model
					,@RequestParam("CodeOfItem") String code
					,@ModelAttribute("CommentInfo") @Validated CommentInfo commentinfo
					,final BindingResult result
					) {

				commentDAO.updateComment(commentinfo);
				
				return "redirect:/ReviewRatingComment?code="+code+"&page="+commentinfo.getPage();
			}
			

			@RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
			public String deleteComment(Locale locale, Model model 
					,ServletRequest session
					,@RequestParam(value = "code", defaultValue = "") String code
					,@RequestParam(value = "id", defaultValue = "") String id
			    	,@RequestParam(value = "page", defaultValue = "1") int page
					,@RequestParam(value = "name", defaultValue = "") String likeName
					,@RequestParam(value = "TransitTypeSorting", defaultValue = "ThatEmpty") String TransitedTypeOfSorting
					,@ModelAttribute("SortType") SortType myform
			    	,@RequestParam(value = "transitedString", defaultValue = "ThatEmpty") String transitedString	
					
					) {
	
				
				
				
				commentDAO.deleteComment(id);
				
				
	
				if(code==null) {
					code=myform.getCode();
				}
		
				if(myform.getChoosenTypeOfSorting()!=null) {
			    	TransitedTypeOfSorting = myform.getChoosenTypeOfSorting();
			    	}
				
		        	model.addAttribute("AttributeForSelecetdFieldInDropMenu",TransitedTypeOfSorting);
			    	model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);

				
				ProductInfo productInfo = null;
				productInfo = productDAO.queryProductByCode(code);
				
		        model.addAttribute("productFormOfReviewRatingPage", productInfo);
		       						
				final int maxResult = 4;
		        final int maxNavigationPage = 100;
		 
		        PaginationResult<CommentInfo> result =
		        		commentDAO
		        		.queryComments(page,maxResult, maxNavigationPage, likeName, TransitedTypeOfSorting,code);
		              
				model.addAttribute("InfoAboutComments", result);

		        double valueOfRating=productDAO.queryRating(code);	      
		        model.addAttribute("RatingValueOfItem", valueOfRating);
		        
//		        For sort type
		        Map< String, String > typesSort = new HashMap<String, String>();

		        typesSort.put("LowestRating", "Lowest rating");
		        typesSort.put("HigherRating", "Highest rating");
		        typesSort.put("Oldest", "Oldest");
		        typesSort.put("Newest", "Newest");
		        
  
		        if(myform.getChoosenTypeOfSorting()!=null) {
			    	TransitedTypeOfSorting = myform.getChoosenTypeOfSorting();
			    }
			    
		        model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);      	    
		        model.addAttribute("listOfSortingTypes", typesSort);
		        model.addAttribute("SortType", new SortType());
		        model.addAttribute("Anonymous","Anonymous");
	        
		        return "ReviewRatingComment/ReviewRatingComment";
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		    @RequestMapping(value = "errors", method = RequestMethod.GET)
		    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
		         
		        ModelAndView errorPage = new ModelAndView("errorPage");
		        String errorMsg = "";
		        int httpErrorCode = getErrorCode(httpRequest);
		 
		        switch (httpErrorCode) {
		            case 400: {
		                errorMsg = "Http Error Code: 400. Bad Request";
		                break;
		            }
		            case 401: {
		                errorMsg = "Http Error Code: 401. Unauthorized";
		                break;
		            }
		            case 404: {
		                errorMsg = "Http Error Code: 404. Resource not found";
		                break;
		            }
		            case 500: {
		                errorMsg = "Http Error Code: 500. Internal Server Error";
		                break;
		            }
		        }
		        errorPage.addObject("errorMsg", errorMsg);
		        return errorPage;
		    }
		     
		    private int getErrorCode(HttpServletRequest httpRequest) {
		        return (Integer) httpRequest
		          .getAttribute("javax.servlet.error.status_code");
		    }	
			
			
			
			
			
			
			
			
			
			
			
			@RequestMapping(value = "/PersonalTogglingForAdmin", method = RequestMethod.GET)
			public ModelAndView TogglingAdmin(Locale locale, Model model) {
				
				model.addAttribute("CompanyData", adminDAO.queryCompanyData());
				
		        return new ModelAndView("Admin/Toggling/AdmingToggling", "AdminInfo", new AdminInfo());
			}
			
			@RequestMapping(value = "/PersonalTogglingForAdmin", method = RequestMethod.POST)
			public String TogglingAdminPOST(Locale locale, Model model
					,@ModelAttribute("AdminInfo") AdminInfo admininfo
					,BindingResult result
					) {
				
				AdminToggleValidation admintogglevalidation = new AdminToggleValidation();
				admintogglevalidation.validate(admininfo, result);
		 		
			    	if (result.hasErrors()) 
			    	{	
			    		model.addAttribute("CompanyData", adminDAO.queryCompanyData());
			    		return "Admin/Toggling/AdmingToggling";
				    }
			    	
	
			    adminDAO.setCompanyData(admininfo);
			    model.addAttribute("CompanyData", adminDAO.queryCompanyData());
				
				return "Admin/Toggling/AdmingToggling";
			}
			
			
			
			
			
			
			
			
			
			
			
			
}
