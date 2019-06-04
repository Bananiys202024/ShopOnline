package com.sawforgarden.myapp.POJO;

public class CheckTypeOfObject {

	
	public static boolean isNumeric(String check) {
	    try {
	        check = check.replaceAll("[0-9]", "");

	        if(check.equals(""))return true;
	        
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    return false;
	}
}
