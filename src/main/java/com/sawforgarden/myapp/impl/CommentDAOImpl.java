package com.sawforgarden.myapp.impl;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sawforgarden.myapp.POJO.POJO;
import com.sawforgarden.myapp.POJO.VariableValidator;
import com.sawforgarden.myapp.controller.HomeController;
import com.sawforgarden.myapp.dao.CommentDAO;
import com.sawforgarden.myapp.entity.Comment;

import com.sawforgarden.myapp.model.CommentInfo;
import com.sawforgarden.myapp.model.PaginationResult;

@Transactional
public class CommentDAOImpl implements CommentDAO {

	private static final Logger logger = Logger
			.getLogger(CommentDAOImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;
	
	 @Override
	    public Comment findProduct(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Comment.class);
	        crit.add(Restrictions.eq("product_id", code));
	        return (Comment) crit.uniqueResult();
	    }
	 
	 @Override
	    public Comment findComment(String id) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Comment.class);
	        crit.add(Restrictions.eq("id", id));
	        return (Comment) crit.uniqueResult();
	    }
	
	
	public CommentInfo queryCommentsByProduct_Id(String code) {
		
		
		Comment comment = this.findProduct(code);
	        if (comment == null) {
	            return null;
	        }
		
        return new CommentInfo(comment.getProduct_id(),comment.getCommentText(),comment.getDateTime(),comment.getId(),comment.getModifiedDateTime(), comment.getTitle(),comment.getNameOfUser(), comment.getWouldRecommendThisToAFriend(),comment.getRating(), comment.isDeleted(), comment.isThatWasModified());

	}


	@Override
	public void saveComment(CommentInfo commentinfo,String code) {
		
		 Comment comment = new Comment();
		 
		 try {
				comment.setDateTime(new Date());
			} catch (ParseException e) {

				e.printStackTrace();
			}				
			
			
			comment.setCommentText(commentinfo.getCommentText());
		 	comment.setNameOfUser(commentinfo.getNameOfUser());
		 	comment.setProduct_id(commentinfo.getProduct_id());
		 	comment.setRating(commentinfo.getRating());
		 	comment.setTitle(commentinfo.getTitle());
		 	comment.setWouldRecommendThisToAFriend(Boolean.parseBoolean(commentinfo.getRecommend()));	 	

	        this.sessionFactory.getCurrentSession().persist(comment);

	        // If error in DB, Exceptions will be thrown out immediately
	        this.sessionFactory.getCurrentSession().flush();
		
	}
	
	

    @Override
    public PaginationResult<CommentInfo> queryComments(int page, int maxResult, int maxNavigationPage,
            String likeName, String TransitedTypeOfSorting,String code) {
        String sql = "Select new " + CommentInfo.class.getName() //
                + "(p.Id, p.commentText, p.dateTime, p.deleted, p.modifiedDateTime, p.product_id, p.title, p.nameOfUser,p.rating, p.thatWasModified,p.wouldRecommendThisToAFriend) " + " from "//
                + Comment.class.getName() + " p "+ " Where p.product_id = '"+code+"'";

        
//        Sorting
        	if(TransitedTypeOfSorting.equals("Oldest")) {
            sql += " order by dateTime ";
            }
            
            if(TransitedTypeOfSorting.equals("HigherRating")) {
            sql += " order by rating desc";
            }
            
            if(TransitedTypeOfSorting.equals("LowestRating")) {
                sql += " order by rating";
            }
            
        	if(TransitedTypeOfSorting.equals("Newest")) {
                sql += " order by dateTime desc";
            }
            
  
                
//            Sorting
       
        Session session = sessionFactory.getCurrentSession();
 
        
        Query query = session.createQuery(sql);

        
        logger.info(query+"--list");
        
        return new PaginationResult<CommentInfo>(query, page, maxResult, maxNavigationPage);
    }


	@Override
	public CommentInfo findCommentInfo(String code) {
		
		 Comment comment = this.findComment(code);
	        if (comment == null) {
	            return null;
	        }
	        return new CommentInfo(comment.getCommentText(),comment.getTitle(),comment.getRating(),comment.getWouldRecommendThisToAFriend());
	  
	}
	
	public void deleteComment(String id) {
        Session session = sessionFactory.getCurrentSession();

		Comment comment = this.findComment(id);
		comment.setDeleted(true);
		comment.setModifiedDateTime(new Date());
		
        session.saveOrUpdate(comment);       

		
	}

	@Override
	public Object queryComments(String id) {
		return null;
	}

	@Override
	public void updateComment(CommentInfo commentinfo) {
			Session session = sessionFactory.getCurrentSession();

		  	Comment comment = this.findComment(commentinfo.getId());
			comment.setCommentText(commentinfo.getCommentText());
			comment.setTitle(commentinfo.getTitle());
			comment.setRating(commentinfo.getRating());
			comment.setWouldRecommendThisToAFriend(VariableValidator.checkRadio(commentinfo.getRecommend()) );
		  			
	        session.saveOrUpdate(comment);       
	
	}


	
}
