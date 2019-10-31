package com.sawforgarden.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sawforgarden.myapp.CloudCommunicationPlatform.SendSms;
import com.sawforgarden.myapp.POJO.HashMaps;
import com.sawforgarden.myapp.dao.OrderDAO;
import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.model.AjaxResponseBody;
import com.sawforgarden.myapp.model.CartInfo;
import com.sawforgarden.myapp.model.CustomerInfo;
import com.sawforgarden.myapp.model.OrderDetailInfo;
import com.sawforgarden.myapp.model.OrderInfo;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.SortingVariables;
import com.sawforgarden.myapp.util.Utils;
import com.sawforgarden.myapp.validator.CartValidator;

@Controller
public class ListOfItems {

	@Autowired
	private ProductDAO productDAO;
    
	private static int CountedShoppingCart=0;
	
	@Autowired
	private OrderDAO orderDAO;	
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
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

    	
//		sorting variables

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
    	
//    	...
    	
    	
//		display products(8 on one page) 
    	
		final int maxResult = 8;
        final int maxNavigationPage = 100;
 
        PaginationResult<ProductInfo> result = 
        		productDAO
        		.queryProducts(page,maxResult, maxNavigationPage, searchName, sortBy ,categorySort, brandSort , priceSorting, ratingSorting);
       
        model.addAttribute("paginationProducts", result);
        
//        ...
        
//        for sorting menu	
        model.addAttribute("listOfBrands", HashMaps.getBrands());
        model.addAttribute("listOfSortingTypes", HashMaps.getBySort());
        model.addAttribute("listOfPrice", HashMaps.getPrices());
        model.addAttribute("listOfRating", HashMaps.getRating());
        model.addAttribute("listOfSectionsMain", HashMaps.getSectionsForSideMenu());
//        ...
        
		return "CatalogOfItems/CatalogOfitems";
	}	    
    

//    AJAX
    @RequestMapping(value={ "/shoppingListRemoveProductFromView" }, method = RequestMethod.POST)
    public @ResponseBody AjaxResponseBody removeProductFromListHandler(HttpServletRequest request, Model model, //
            @RequestParam(value = "code", defaultValue = "") String code,
            @RequestParam(value = "id", defaultValue = "") String id) {

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
    
    	
    
    

    
    
    
    
    
    
    
//    / GET: Enter customer information.
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
//    	orderDAO.deleteOrderDetailsORDERID(orderId);
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
    	
    	 
//    	String price=POJO.transformPrice(list.get(0)); 
//    	logger.info(price);
    	String PHONEMESSAGE = 
    			"Ваш заказ № "+ list.get(1) +" передан курьеру. "
    			+ "Ожидайте доставку."
    			+ "К оплате "+ list.get(0) +" гривны ";
    			
    	String PHONE = list.get(2);
    	
    	
    	SendSms.SendSmsWithTwillo(PHONEMESSAGE,PHONE);
    	
    	return "redirect:/orderList";
    }
    
    
    
    
}
