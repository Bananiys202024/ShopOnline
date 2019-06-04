package com.sawforgarden.myapp.jdbc;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class GetQuery {
	
	public static void ReturnCount(double newRating) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
		   tx = session.beginTransaction();
		 
		   //do some work
		   Query querySum = session.createQuery("select SUM(rating) from com.sawforgarden.myapp.entity.Comment");
		   List<?> resultSum = querySum.list();
			
		   Query queryCount = session.createQuery("SELECT COUNT(rating) FROM com.sawforgarden.myapp.entity.Comment");
		   List<?> resultCount = queryCount.list();
	
	       Double result=(newRating+(Double.parseDouble((String) resultSum.get(0))/Double.parseDouble((String) resultCount.get(0)) ) )/2;
	       //.....
		   
		   tx.commit();
		   
//		   return result;
		   
		}

		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		} finally {
		   session.close();
		}
		
//		return 0.0;
	}	
}
