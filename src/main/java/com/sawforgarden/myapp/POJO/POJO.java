package com.sawforgarden.myapp.POJO;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;

import com.sawforgarden.myapp.controller.HomeController;
import com.sawforgarden.myapp.model.OrderDetailInfo;
import com.sawforgarden.myapp.model.OrderInfo;

public class POJO {

	private static final Logger logger = Logger
			.getLogger(POJO.class);
	
	
	public static void InfoAboutSoldedItem(List<OrderDetailInfo> details) {
	

    	for(OrderDetailInfo orderdetailinf : details) {
    	logger.info("Start line");
    	logger.info(orderdetailinf.getProductCode()+"--ProductCode");
    	logger.info(orderdetailinf.getProductName() +"--ProductName");
    	logger.info(orderdetailinf.getQuanity() +"--Quantity");
    	logger.info(orderdetailinf.getPrice() +"--Price");
    	logger.info(orderdetailinf.getAmount() +"--Amount");
    	logger.info("End line");
    	}
		
	}


	public static String countingQuantity(String soldedQuantity, long InStock) {
		
		 BigInteger result;
	        BigInteger GetPresentQuantity = BigInteger.valueOf(Long.parseLong(soldedQuantity));
	        BigInteger SoldedQuantityOfItem = BigInteger.valueOf(InStock);
	       
	        if(GetPresentQuantity.compareTo(SoldedQuantityOfItem) == -1)
	        {
	        result = BigInteger.ZERO;
	        }
	        else 
	        {
	        result = GetPresentQuantity.subtract(SoldedQuantityOfItem);
	        }
	        
	       return  String.valueOf(result);
	}


	public static String transformPrice(String string) {
		
		String price="";
		
		for(int i=0;i<string.length();i++) {
			
			if(i%3==0)
			{
			price+="_"+string.charAt(i);
			}	
			else
			{
			price+=string.charAt(i);
			}
	
		}
		
//		for()delete zeroes after point	

		
		return price.substring(1);
	}

}
