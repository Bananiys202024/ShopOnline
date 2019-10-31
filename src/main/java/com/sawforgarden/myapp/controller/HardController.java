package com.sawforgarden.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sawforgarden.myapp.dao.CommentDAO;
import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.model.CartInfo;
import com.sawforgarden.myapp.model.CommentInfo;
import com.sawforgarden.myapp.model.EditComment;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.SortType;
import com.sawforgarden.myapp.util.Utils;

@Controller
public class HardController {

	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private ProductDAO productDAO;

	
		@RequestMapping(value = "/ReviewRatingComment", method = RequestMethod.GET)
		public String ReviewRatingComment(Locale locale, Model model 
				,ServletRequest session
				,@RequestParam(value = "code", defaultValue = "") String code
//		    	,@ModelAttribute("codeForProduct") int codeProduct
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
	        

	        double valueOfRating=productDAO.queryRating(code);	      
	        model.addAttribute("RatingValueOfItem", valueOfRating);
	        

	        
//	        For sort type
	        Map< String, String > typesSort = new HashMap<String, String>();

	        typesSort.put("LowestRating", "Lowest rating");
	        typesSort.put("HigherRating", "Highest rating");
	        typesSort.put("Oldest", "Oldest");
	        typesSort.put("Newest", "Newest");
	        
	        
	        
//	        typesSort.put("MostHelpful", "Most helpful");

	        
	        
	        if(myform.getChoosenTypeOfSorting()!=null) {
		    	TransitedTypeOfSorting = myform.getChoosenTypeOfSorting();
		    }
		    
	        model.addAttribute("AttributeTransitTypeSorting",TransitedTypeOfSorting);
		    			    	
	        
	        
	        
	        model.addAttribute("listOfSortingTypes", typesSort);

	        model.addAttribute("SortType", new SortType());
//	        For sort type
	        
	        List<String> numbersList = new ArrayList<String>();
	        numbersList.add("Yes, I would recommend this to a friend");
	        numbersList.add("No, I would not recommed this to a friend");
	        //....
	        
	        
	    	model.addAttribute("numberList",numbersList);  
	        
//	        
//	        logger.info("Keycheck--"+result.dateTime);
	        
	        
	        model.addAttribute("Anonymous","Anonymous");
       
	        return "ReviewRatingComment/ReviewRatingComment";
		}		 
	 
		
		
		
		
		
		
		
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
		
	    


	    

	    
}
