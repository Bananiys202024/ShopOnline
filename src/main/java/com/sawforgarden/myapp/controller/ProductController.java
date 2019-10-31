package com.sawforgarden.myapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sawforgarden.myapp.POJO.HashMaps;
import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.SortType;
import com.sawforgarden.myapp.validator.ProductInfoValidator;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	 
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
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
	
	    	
	    	ProductInfoValidator userValidator = new ProductInfoValidator();
	        userValidator.validate(productInfo, result);
	    	
	    	if (result.hasErrors()) {
	    		   		
	    		model.addAttribute("listOfCategoryTypes", HashMaps.getCategories());
		        model.addAttribute("listOfSecionTypes", HashMaps.getSections());
		        model.addAttribute("listOfBrands", HashMaps.getBrands());
		        
		        return "Admin/Create Product/CreateProduct";
		      }
	    	
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
	 
	 

}
