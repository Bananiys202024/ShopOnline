package com.sawforgarden.myapp.jdbc;

import java.sql.*;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 * 
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class ExistingQueryParmeters
{

  public static boolean checkForUniqueName(String name)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/SawForGarden";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "202024");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT USERNAME FROM USERS WHERE USERNAME = '"+name+"'";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        String firstName = rs.getString("USERNAME");

        System.out.format("%s\n",firstName);
     
        if(firstName.trim().equals(name.trim())) {
      	  return true;
        }
        
      }
      
    
      
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    
	return false;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  public static boolean checkForUniqueEmail(String email)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/SawForGarden";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "202024");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT EMAIL FROM USERS WHERE EMAIL = '"+email+"'";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        String firstName = rs.getString("EMAIL");

        System.out.format("%s\n",firstName);
       
        if(firstName.trim().equals(email.trim())) {
      	  return true;
        }
        
      }
      
    
      
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    
	return false;
  }
  
  
  
  public static boolean checkForUniqueEmailForRestorePassword(String email)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/SawForGarden";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "202024");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT EMAIL FROM USERS WHERE EMAIL = '"+email+"'";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      
      
      // iterate through the java resultset
      while (rs.next())
      {
    	  
    	
        String firstName = rs.getString("EMAIL");

      
        if(firstName.trim().equals(email.trim())) {
      	  return false;
        }
        
      }
      
    
      
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    
	return true;
  }
  
  
  
//  public static boolean checkForUniquePhone(String phone)
//  {
//    try
//    {
//      // create our mysql database connection
//      String myDriver = "org.gjt.mm.mysql.Driver";
//      String myUrl = "jdbc:mysql://localhost/SawForGarden";
//      Class.forName(myDriver);
//      Connection conn = DriverManager.getConnection(myUrl, "root", "202024");
//      
//      // our SQL SELECT query. 
//      // if you only need a few columns, specify them by name instead of using "*"
//      String query = "SELECT EMAIL FROM USERS WHERE PHONE = '"+email+"'";
//
//      // create the java statement
//      Statement st = conn.createStatement();
//      
//      // execute the query, and get a java resultset
//      ResultSet rs = st.executeQuery(query);
//      
//      // iterate through the java resultset
//      while (rs.next())
//      {
//        String firstName = rs.getString("EMAIL");
//

//        if(firstName.trim().equals(email.trim())) {
//      	  return true;
//        }
//        
//      }
//      
//    
//      
//      st.close();
//    }
//    catch (Exception e)
//    {
//      System.err.println("Got an exception! ");
//      System.err.println(e.getMessage());
//    }
//    
//	return false;
//  }
//  
  
  
  
  
  public static String findName(String email)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/SawForGarden";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "202024");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT USERNAME FROM USER_ROLES WHERE EMAIL='"+email+"';";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        String firstName = rs.getString("USERNAME");
        return firstName;
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    
	return "Wow. What's from shit";
  }
  
//  public static void defaultImage() throws IOException {
//	 
//	 String path = "resources/images/DefaultImages/defaultImage.png";

	 // read image from folder(computer/server)
//     File folderInput = new File(path);
//     BufferedImage folderImage = ImageIO.read(folderInput);

//     // read image from url
//     URL urlInput = new URL("https://memorynotfound.com/wp-content/uploads/java-duke.png");
//     BufferedImage urlImage = ImageIO.read(urlInput);

     // read image from class-path
//     File classPathInput = new File(ExistingQueryParmeters.class.getResource(path).getFile());
//     BufferedImage classpathImage = ImageIO.read(classPathInput);

//     // read image from inputstream
//     InputStream isInput = new FileInputStream(path);
//     BufferedImage inputStreamImage = ImageIO.read(isInput);
	 
// }
  
 
}
