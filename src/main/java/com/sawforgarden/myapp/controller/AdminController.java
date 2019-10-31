package com.sawforgarden.myapp.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sawforgarden.myapp.dao.AdminDAO;
import com.sawforgarden.myapp.model.AdminInfo;
import com.sawforgarden.myapp.validator.AdminToggleValidation;

@Controller
public class AdminController {

	@Autowired
	private AdminDAO adminDAO;

	
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
