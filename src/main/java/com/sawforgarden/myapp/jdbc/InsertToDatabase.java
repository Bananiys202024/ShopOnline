package com.sawforgarden.myapp.jdbc;

import java.sql.*;

public class InsertToDatabase {

	
	public static void insertToDatabase(String email, String password) {
		
		try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/SawForGarden";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "202024");
	      
	   // create the java mysql update preparedstatement
	      String query = "update USERS set PASSWORD = ? where EMAIL = ?";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString   (1, password);
	      preparedStmt.setString(2, email);

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
