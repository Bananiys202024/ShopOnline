package com.sawforgarden.myapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sawforgarden.myapp.POJO.HashMaps;
import com.sawforgarden.myapp.POJO.VariableValidator;
import com.sawforgarden.myapp.dao.CommentDAO;
import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.model.CommentInfo;
import com.sawforgarden.myapp.model.EditComment;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.SortType;
import com.sawforgarden.myapp.validator.CommentInfoValidator;

@Controller
public class CommentController {

	private static final Logger logger = Logger
			.getLogger(CommentController.class);	

	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CommentDAO commentDAO;
    
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
//    	   Double rating = GetQuery.ReturnCount(commentinfo.getRating());
    	   //...
    	   Double rating = commentinfo.getRating();
    	   commentinfo.setRating(rating);
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
        
//        For sort type
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
