package com.sawforgarden.myapp.POJO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class VariableValidator {

	
	public static boolean forCallingValidatePhoneNumber(String phoneNo) {
		return validatePhoneNumber(phoneNo);
	}
	
	
	private static boolean validatePhoneNumber(String phoneNo) {
		
		String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(phoneNo);
		
		//validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{10}")) return true;
		//validating phone number with -, . or spaces
		else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extension length from 3 to 5
		else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//validating phone number where area code is in braces ()
		else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		//if +1234567890 match
		else if(matcher.matches()) return true;
		//return false if nothing matches the input
		else return false;
		
	}
	
	public static boolean isOnlyNumbers(String str){
        try{
            Double.parseDouble(str);
        }catch(NumberFormatException exception){
            return false;
        }
        return true;
    }
	
	
	public static boolean isValid(String str) {
		
		if(str.equals("BestSelling")) {
			return true;
		}
		if(str.equals("PriceLowToHight")){
			return true;
		}
		
		if(str.equals("PriceHightToLow")) {
			return true;
		}
		if(str.equals("CustomerRating")) {
			return true;
		}
		if(str.equals("NewArrivals")) {
			return true;
		}
		
		if(str.equals("BrandAZ")) {
			return true;
		}
		
		if(str.equals("BrandAZ")) {
			return true;
		}
			
		return false;
		
	}


	public static boolean chackEmail(String email) {
		
		boolean result = false;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = true;
		   }
		   return result;
		
	}
	
//public static boolean isItEmail(String email) {
//		
//	String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//    return email.matches(regex);
//	}
//	
	


	public static boolean checkPhoneOnLength(String phone) {
		if(phone.length()>=9 || phone.length()<=15) {return false;}
		return true;
	}


	public static boolean isWhetverNumbers(String phone) {
		  try{
	            Double.parseDouble(phone);
	        }catch(NumberFormatException exception){
	            return true;
	        }
		return false;
	}

	public static boolean CheckOnFormatPhone(String phone) {
		 
		
		
		if(phone==null || phone.isEmpty()) {}
		else {
		String FirstSymvol =phone.substring(0, 1);
		if(FirstSymvol.equals("+")) {return false;}
		if(FirstSymvol.equals("0")) {return false;}
		}
		
		return true;
	}


	public static boolean CheckForLengthSix(String password) {
		
		
		if(!password.isEmpty()) {}
		else {
		if(password.length()<6) {
			return true;
		}
		}
		
		return false;
	}


	public static boolean checkRadio(String recommend) {
		
		String yes="Yes, I would recommend this to a friend";
		
		if(yes.equals(recommend)) {
			return true;
		}
		
		return false;
		
		
		
	}
	
public static String checkRadioString(String recommend) {
		
		String yes="Yes, I would recommend this to a friend";
		
		if(yes.equals(recommend)) {
			return "true";
		}
		
		return "false";
		
		
		
	}


	public static boolean EmptyOrNotSearch(String likeName) {
		
		if(likeName!=null && likeName.length()>0) {
			return true;
		}
		
		return false;
	}
	
	
	
public static boolean emptyOrNotSortCatB(String categorySearch) {
		
		if(!categorySearch.equals("ThatEmpty") && !categorySearch.equals("Empty")) {
			return true;
		}
		
		return false;
	}


public static boolean emptyOrNotSortByBrand(String sortByBrand) {
	
	if(sortByBrand!=null && !sortByBrand.equals("Empty")) {
		return true;
	}
	
	
	return false;
}


public static String tofindKeyWordForSearchName(String searchName) {
	

  if(searchName.equals("OldArrivals")) {
  return " p.createDate ";
  }
  
  if(searchName.equals("BrandAZ")) {
  return " p.name ";
  }
  
  if(searchName.equals("BrandZA")) {
      return " p.name desc ";
  }
  
  if(searchName.equals("PriceLowToHight")) {
      return " p.price ";
  }
  
  if(searchName.equals("PriceHightToLow")) {
      return " p.price desc ";
  }
  
  if(searchName.equals("NewArrivals")) {
      return " p.createDate desc ";
  }

	return null;
}


public static String tofindKeyWordForPrice(String priceSort) {
	

    if(priceSort.equals("1000")) {return " price < 1000 ";}
    if(priceSort.equals("10003000")) {return " price > 1000 AND price<3000 ";}
    if(priceSort.equals("30005000")) {return  " price > 3000 AND price<5000 ";}
    if(priceSort.equals("50009999")) {return " price > 5000 AND price<10000 ";}
    if(priceSort.equals("10000")) {return " price > 10000 ";}      

	return null;
}


public static String tofindKeyWordForRating(String ratingSort) {

	 if(ratingSort.equals("5")) {return " rating <= 5 AND rating >=4.5 ";}
     if(ratingSort.equals("4")) {return " rating < 4.5 AND rating>4 ";}
     if(ratingSort.equals("3")) {return " rating >=3 AND rating<4 ";}
     if(ratingSort.equals("2")) {return " rating<=2 AND rating<3 ";}
     if(ratingSort.equals("1")) {return " rating<2 ";}      
	
	return null;
}


	
}
