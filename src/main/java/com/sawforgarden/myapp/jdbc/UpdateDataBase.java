package com.sawforgarden.myapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDataBase {

	public static void UpdateRatingOfTableProduct(Double evaluatedBothRating, String code) {
		
        
		
		
		
		try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/SawForGarden";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "202024");
	      
	   // create the java mysql update preparedstatement
	      
//	      String JDBCUpdate = "update Products c set c.rating = "+evaluatedBothRating+"where c.code = "+code;
	        
	      String query = "update Products set rating = ? where code = ?";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setDouble(1, evaluatedBothRating);
	      preparedStmt.setString(2, code);

	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      conn.close();
	      
	    }
	    catch (Exception e)
	    {
	    	System.err.println("Got an exception! Insert to database. ");
	        System.err.println(e.getMessage());

	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
