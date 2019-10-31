package com.sawforgarden.myapp.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sawforgarden.myapp.POJO.HashMaps;
import com.sawforgarden.myapp.jdbc.ExistingQueryParmeters;
import com.sawforgarden.myapp.model.CartInfo;
import com.sawforgarden.myapp.model.RecentlyViewedItems;
import com.sawforgarden.myapp.model.SortingVariables;
import com.sawforgarden.myapp.util.Utils;

@Controller
public class SimpleController {

	private static int CountedShoppingCart=0;

	RecentlyViewedItems recentlyvieweditems=new RecentlyViewedItems();

	CartInfo cartInfo_forSaveItemsOfCart_AfterLogOut = null;
	
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



}
