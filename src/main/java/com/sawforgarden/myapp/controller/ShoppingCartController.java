package com.sawforgarden.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.sawforgarden.myapp.dao.OrderDAO;
import com.sawforgarden.myapp.model.AjaxResponseBody;
import com.sawforgarden.myapp.model.CartInfo;
import com.sawforgarden.myapp.model.CustomerInfo;
import com.sawforgarden.myapp.model.Views;
import com.sawforgarden.myapp.util.Utils;

@Controller
public class ShoppingCartController {

		@Autowired
		private OrderDAO orderDAO;	

		private static int CountedShoppingCart=0; 
		
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
    
//	    Ajax
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
	        
	

	    
}
