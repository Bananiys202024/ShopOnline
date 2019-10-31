package com.sawforgarden.myapp.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.RecentlyViewedItems;

@Controller
public class ViewController {

	@Autowired
	private ProductDAO productDAO;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	

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
        
        
//        Recently viewed
        PaginationResult<ProductInfo> result = 
        		productDAO
        		.queryProducts(recentlyvieweditems.getId());
        model.addAttribute("paginationProducts", result);	 
        
//        ProductInfo ReviewItemsInfo = null;
//		productInfo = productDAO.queryProducts(code);
//		model.addAttribute("paginationProducts", ReviewItemsInfo);
//		
//        ...
        
//        Number reviews of rating
        
        model.addAttribute("NumberReviews", productDAO.queryNumberReviews(code));
        
        
        
//        ...
        
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

		 
	    @RequestMapping(value = "/ViewProductForRepeat", method = RequestMethod.GET)
				public String ViewProductFromViewPage(Locale locale, Model model,
						HttpServletRequest request, 
//			            @RequestParam(value = "code", defaultValue = "") String code,
			            ServletRequest session,
			            @ModelAttribute("CodeForProduct") String code
			            
//			            ,RedirectAttributes redirectAttributes
			            ) {

					ProductInfo productInfo = null;
					productInfo = productDAO.queryProductByCode(code);
					
			        model.addAttribute("productFormOfViewPage", productInfo);

					return "ViewProduct/ViewProduct";
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
	    

	    

		
}
