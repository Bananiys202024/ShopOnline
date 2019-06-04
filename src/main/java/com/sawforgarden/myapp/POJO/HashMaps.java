package com.sawforgarden.myapp.POJO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMaps {

	  public static List<String> getnumberlist() {
		  List<String> numbersList = new ArrayList<String>();
		  numbersList.add("No, I would not recommed this to a friend");
		  numbersList.add("Yes, I would recommend this to a friend");	        
	      return numbersList;  
	  }
	  
	  

	  public static Map< String, String > gettypessort() {
		  
		    Map< String, String > typesSort = new HashMap<String, String>();

	        typesSort.put("LowestRating", "Lowest rating");
	        typesSort.put("HigherRating", "Highest rating");
	        typesSort.put("Oldest", "Oldest");
	        typesSort.put("Newest", "Newest");
	          
		  return typesSort;
	  }
	
    
      public static List<String>  GetsubMenuInstrumentOfMillingCutters() {
			List<String> result =new ArrayList<String>();
		
			result.add("Инструмент для фрезирования");
			result.add("Фрейзеры");
		    result.add("Многофункциональный инструмент");

		return result;
	}
      
      
	 public static List<String>  GetsubMenuInstrumentOfAVacuumCleanerANDBlowersANDThermallowers() {
			List<String> result =new ArrayList<String>();
		
			result.add("Пылесосы/Термовоздуходувы/Воздуходувы");
			result.add("Воздуходувки");
		    result.add("Термодувки");
		    result.add("Пылесосы");
	    
		return result;
	}
	 
	 public static List<String>  GetsubMenuInstrumentOfGarden(){
			List<String> result =new ArrayList<String>();
		
			  result.add("Садовый инструмент");
		      result.add("Пилы");
		      result.add( "Газонокосилки");
		      result.add("Аераторы");
		      result.add("Косы");
		      result.add("Насосы");
		      result.add("Резаки");
		      result.add("Опрыскиватели");
		      result.add( "Мойки высокого давления");
		      result.add("Измельчители");
		      result.add("Генераторы");
		      result.add("Ножницы для газона");
	    
		return result;
	}
	 
	 
	
	 
	 public static List<String>  GetsubMenuInstrumentOPneumatic(){
			List<String> result =new ArrayList<String>();
		
			result.add("Пневматичный инструмент");
			result.add("Компрессор высокого давления");
		    result.add("Пневматичный инструмент");
		    result.add("Гвоздезабивной инструмент");
		    result.add("Воздушный компрессор");
		    result.add("Пневматичные стеллеры");
		    
		    
		return result;
	}
	 
	
	
	
	 public static List<String>  GetsubMenuInstrumentOfSawing(){
			List<String> result =new ArrayList<String>();
		
			result.add("Инструмент для разпиливание");
			result.add("Торцевые пилы");
		    result.add("Настольные пилы");
		    result.add("Лобзики");
		    result.add("Дисковые пилы");
	    
		return result;
	}

	
	
    public static List<String>  GetsubMenuInstrumentForPolishingAndGriding(){
		List<String> result =new ArrayList<String>();
	
		result.add("Инструменты для полирования/шлифования");
		result.add("Угловые шлифомашинки");
	    result.add("Лесные ножницы");
	    result.add("Ленточные плиты");
	    result.add("Дисковые плиты");
    
	return result;
}
	
	
	public static List<String>  GetsubMenuInstrumentForDesctroyingANDSmeshingANDDrilling(){
			List<String> result =new ArrayList<String>();
		
		result.add("Инструменты для разрушения/смешивания");
		result.add("Перфоратор");
        result.add("Отбойные молотки");
        result.add("Дрели с ударом");
        result.add("Дрели");
        result.add("Угловые дрели");
        result.add("Мешалки");
        
		return result;
	}
	
	public static List<String>  GetsubMenuInstrumentForSubbling(){
		List<String> result =new ArrayList<String>();
	
		result.add("Инструмент для стругания");
		result.add("Електричные рубанки");
        result.add("Рейсмусы");
    
	return result;
}
	
	public static HashMap<List<String>,String> getSectionsForSideMenu() {
	
		List<String> empty1 = new ArrayList<String>() {private static final long serialVersionUID = 1L;};
		empty1.add("1");
		empty1.add("ThatEmpty");

		List<String> empty = new ArrayList<String>() {private static final long serialVersionUID = 1L;};
		empty.add("ThatEmpty");
		
		List<String> empty2 = new ArrayList<String>() {private static final long serialVersionUID = 1L;};
		empty2.add("ThatEmpty");
		empty2.add("2");
		
      Map< List<String>, String > typesSecion = new LinkedHashMap<List<String>, String>();
     
      typesSecion.put(empty1, "Весь инструмент");
      typesSecion.put(empty2, "Аккумуляторный инструмент");
      typesSecion.put(empty, "Наборы инструментов");      
      typesSecion.put(GetsubMenuInstrumentForDesctroyingANDSmeshingANDDrilling(), "Инструменты для разрушения/смешивания");
      typesSecion.put(GetsubMenuInstrumentForPolishingAndGriding(), "Инструменты для полирования/шлифования");
      typesSecion.put(GetsubMenuInstrumentForSubbling(), "Инструмент для стругания");
      typesSecion.put(GetsubMenuInstrumentOfSawing(), "Инструмент для разпиливание");
      typesSecion.put(GetsubMenuInstrumentOfMillingCutters(), "Инструмент для фрезирования");
      typesSecion.put(GetsubMenuInstrumentOPneumatic(), "Пневматичный инструмент");
      typesSecion.put(GetsubMenuInstrumentOfGarden(), "Садовый инструмент");
      typesSecion.put(GetsubMenuInstrumentOfAVacuumCleanerANDBlowersANDThermallowers(), "Пылесосы/Термовоздуходувы/Воздуходувы");
      //....

	  return (HashMap<List<String>, String>) typesSecion;
		
	}
	
	public static ArrayList<List<String>> getSectionsForSideMenuOldWeCanRemoveIt() {
		
		List<String> empty1 = new ArrayList<String>() {private static final long serialVersionUID = 1L;};
		empty1.add("Весь инструмент");

		List<String> empty = new ArrayList<String>() {private static final long serialVersionUID = 1L;};
		empty.add("Наборы инструментов");
		
		List<String> empty2 = new ArrayList<String>() {private static final long serialVersionUID = 1L;};
		empty2.add("Аккумуляторный инструмент");
		
      List< List<String>> typesSecion = new ArrayList<List<String>>();
     
      typesSecion.add(empty1);
      typesSecion.add(empty2);
      typesSecion.add(empty);      
      typesSecion.add(GetsubMenuInstrumentForDesctroyingANDSmeshingANDDrilling());
      typesSecion.add(GetsubMenuInstrumentForPolishingAndGriding());
      typesSecion.add(GetsubMenuInstrumentForSubbling());
      typesSecion.add(GetsubMenuInstrumentOfSawing());
      typesSecion.add(GetsubMenuInstrumentOfMillingCutters());
      typesSecion.add(GetsubMenuInstrumentOPneumatic());
      typesSecion.add(GetsubMenuInstrumentOfGarden());
      typesSecion.add(GetsubMenuInstrumentOfAVacuumCleanerANDBlowersANDThermallowers());
      //....

      return (ArrayList<List<String>>) typesSecion;
		
	}
	
	public static HashMap<String,String> getSections() {
		
	     
//        That for section menu
        Map< String, String > typesSecion = new LinkedHashMap<String, String>();
       
        typesSecion.put("Весь инструмент", "Весь инструмент");
        typesSecion.put("Аккумуляторный инструмент", "Аккумуляторный инструмент");
        typesSecion.put("Наборы инструментов", "Наборы инструментов");      
        typesSecion.put("Инструменты для разрушения/смешивания", "Инструменты для разрушения/смешивания");
        typesSecion.put("Инструменты для полирования/шлифования", "Инструменты для полирования/шлифования");
        typesSecion.put("Инструмент для стругания", "Инструмент для стругания");
        typesSecion.put("Инструмент для разпиливание", "Инструмент для разпиливание");
        typesSecion.put("Инструмент для фрезирования", "Инструмент для фрезирования");
        typesSecion.put("Пневматичный инструмент", "Пневматичный инструмент");
        typesSecion.put("Садовый инструмент", "Садовый инструмент");
        typesSecion.put("Пылесосы/Термовоздуходувы/Воздуходувы", "Пылесосы/Термовоздуходувы/Воздуходувы");
        //....
		
		
		return (HashMap<String, String>) typesSecion;
		
	}
	
	
	
	public static HashMap<String,String> getBySort() {

	        Map< String, String > typesSort = new HashMap<String, String>();
//	        typesSort.put("BestSelling", "Best Selling");
	        typesSort.put("OldArrivals", "Old Arrivals");
	        typesSort.put("PriceLowToHight", "Price Low to High");
	        typesSort.put("PriceHightToLow", "Price High to Low");
//	        typesSort.put("CustomerRating", "Customer Rating");
	        typesSort.put("NewArrivals", "New Arrivals");
	        typesSort.put("BrandAZ", "Brand A-Z");
	        typesSort.put("BrandZA", "Brand Z-A");
	        
	        
	        return (HashMap<String, String>) typesSort;
	}
	
	
	public static HashMap<String,String> getBrands() {

        Map< String, String > typesBrand = new HashMap<String, String>();
        
//        typesBrand.put("All brands", "All brands");
        typesBrand.put("Bosch", "Bosch");
        typesBrand.put("Stihl", "Stihl");
        typesBrand.put("Viking", "Viking");	
//        typesBrand.put("Yamaha", "Yamaha");
        typesBrand.put("Makita", "Makita");
        typesBrand.put("Husquarna", "Husquarna");
        
        
        return (HashMap<String, String>) typesBrand;
}
	

	public static HashMap<String,String> getPrices() {
		
		Map< String, String > typesPrices = new LinkedHashMap<String, String>();
        
		typesPrices.put("1000", "0-1000 гривен");
		typesPrices.put("1_000-3000", "1000-3000 гривен");
		typesPrices.put("3000-5000", "3000-5000 гривен");	
		typesPrices.put("5000-9999", "5000-10000 гривен");
		typesPrices.put(">10_000", "больше 10_000 гривен");
		
        return (HashMap<String, String>) typesPrices;
	}
	
public static HashMap<String,String> getRating() {
		
		Map< String, String > typesRating = new LinkedHashMap<String, String>();
        

		typesRating.put("100", "5");
		typesRating.put("80", "4");
		typesRating.put("60", "3");	
		typesRating.put("40", "2");
		typesRating.put("20", "1");
		
        return (HashMap<String, String>) typesRating;
	}
	
	
	public static String tofindValueOfKeyHashMap(HashMap<String,String> map,String value) {

		
		for (Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(value)) {
            	return String.valueOf(entry.getValue());
            }
        }
		
		
		return "Empty";	
	}
	public static HashMap<String,String> getCategories() {
		
		
	     
//      Lists for categories
      Map< String, String > typesCategories = new HashMap<String, String>();
      
      typesCategories.put("Перфоратор", "Перфоратор");
      typesCategories.put("Отбойные молотки", "Отбойные молотки");
      typesCategories.put("Дрели с ударом", "Дрели с ударом");
      typesCategories.put("Дрели", "Дрели");
      typesCategories.put("Угловые дрели", "Угловые дрели");
      typesCategories.put("Мешалки", "Мешалки");
      
      typesCategories.put("Електричные рубанки", "Електричные рубанки");
      typesCategories.put("Рейсмусы", "Рейсмусы");
      
      typesCategories.put("Угловые шлифомашинки", "Угловые шлифомашинки");
      typesCategories.put("Лесные ножницы", "Лесные ножницы");
      typesCategories.put("Ленточные плиты", "Ленточные плиты");
      typesCategories.put("Дисковые плиты", "Дисковые плиты");
      
      
      typesCategories.put("Торцевые пилы", "Торцевые пилы");
      typesCategories.put("Настольные пилы", "Настольные пилы");
      typesCategories.put("Лобзики", "Лобзики");
      typesCategories.put("Дисковые пилы", "Дисковые пилы");
      
      typesCategories.put("Frazers", "Фрейзеры");
      typesCategories.put("Многофункциональный инструмент", "Многофункциональный инструмент");
      
      typesCategories.put("Компрессор высокого давления", "Компрессор высокого давления");
      typesCategories.put("Пневматичный инструмент", "Пневматичный инструмент");
      typesCategories.put("Гвоздезабивной инструмент", "Гвоздезабивной инструмент");
      typesCategories.put("Воздушный компрессор", "Воздушный компрессор");
      typesCategories.put("Пневматичные стеллеры", "Пневматичные стеллеры");
      
      typesCategories.put("Пылесосы", "Пылесосы");
      typesCategories.put("Термодувки", "Термодувки");
      typesCategories.put("Воздуходувки", "Воздуходувки");
      
      
      typesCategories.put("Пилы", "Пилы");
      typesCategories.put("Газонокосилки", "Газонокосилки");
      typesCategories.put("Аераторы", "Аераторы");
      typesCategories.put("Косыs", "Косы");
      typesCategories.put("Насосы", "Насосы");
      typesCategories.put("Резаки", "Резаки");
      typesCategories.put("Опрыскиватели", "Опрыскиватели");
      typesCategories.put("Мойки высокого давления", "Мойки высокого давления");
      typesCategories.put("Измельчители", "Измельчители");
      typesCategories.put("Генераторы", "Генераторы");
      typesCategories.put("Ножницы для газона", "Ножницы для газона");

      
      //....
      return (HashMap<String, String>) typesCategories;
		
	}
	


}
