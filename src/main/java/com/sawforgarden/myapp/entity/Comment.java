package com.sawforgarden.myapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import java.util.Date;



//@Entity
//@Table(name = "comments")
@javax.persistence.Entity
	
@Table(name = "comments")
public class Comment implements Serializable{

    private static final long serialVersionUID = -1000119078147252957L;
 	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "BIGINT(20)", nullable = false)
	private String Id;
	
	@Column(name = "commentText", length = 2000, nullable = false)
	private String commentText;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateTime", nullable = false)
	private Date dateTime;
    
    @Column(name = "deleted",columnDefinition = "tinyint(1) default 0")
	private boolean deleted;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedDateTime")
	private Date modifiedDateTime;
	
	
    @Column(name = "product_id", length = 60)
	private String product_id;
	
	@Column(name = "title", length=60)
	private String title;
	
	@Column(name = "nameOfUser", length=50)
	private String nameOfUser;
	
	@Column(name = "wouldRecommendThisToAFriend", columnDefinition = "tinyint(1) default 0")
	private boolean wouldRecommendThisToAFriend;
	
	@Column(name="rating", columnDefinition="Decimal(40,2)")
	private double rating;
    
    @Column(name = "ThatWasModified", columnDefinition = "tinyint(1) default 0")
	private boolean thatWasModified;
	
	
			public Comment() {
			}
	 
		    
		    public String getProduct_id() {
		        return product_id;
		    }
			
			 public void setProduct_id(String product_id) {
			        this.product_id = product_id;
			}
			
			public String getCommentText() {
				return commentText;
			}

			public void setCommentText(String commentText) {
				this.commentText = commentText;
			}
		
			public String getId() {
				return Id;
			}

			public void setId(String id) {
				Id = id;
			}
					
			public Date getDateTime() {
				return dateTime;
			}

		    
			public void setDateTime(Date dateTime) throws ParseException {
				this.dateTime = dateTime;
			}

			
			public boolean isDeleted() {
				return deleted;
			}

			public void setDeleted(boolean deleted) {
				this.deleted = deleted;
			}

//			@Temporal(TemporalType.TIMESTAMP)
		    
			public Date getModifiedDateTime() {
				return modifiedDateTime;
			}

			public void setModifiedDateTime(Date modifiedDateTime) {
				this.modifiedDateTime = modifiedDateTime;
			}
			
			
			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			@Column(name = "nameOfUser")
			public String getNameOfUser() {
				return nameOfUser;
			}

			public void setNameOfUser(String nameOfUser) {
				this.nameOfUser = nameOfUser;
			}

			
			public boolean getWouldRecommendThisToAFriend() {
				return wouldRecommendThisToAFriend;
			}

			public void setWouldRecommendThisToAFriend(boolean wouldRecommendThisToAFriend) {
				this.wouldRecommendThisToAFriend = wouldRecommendThisToAFriend;
			}

			
			public double getRating() {
				return rating;
			}

			public void setRating(double rating) {
				this.rating = rating;
			}

			
			public boolean isThatWasModified() {
				return thatWasModified;
			}

			public void setThatWasModified(boolean thatWasModified) {
				this.thatWasModified = thatWasModified;
			}

			
	
}
