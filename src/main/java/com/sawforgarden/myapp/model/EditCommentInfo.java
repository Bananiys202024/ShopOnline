package com.sawforgarden.myapp.model;



import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EditCommentInfo {
	
	private String brand;
	private int revises;
	
	private String product_id;
	private String commentText;
	private Date dateTime;
	private Date modifiedDateTime;
	private String id;
	private String title;
	private String nameOfUser;
	private boolean wouldRecommendThisToAFriend;
	private double rating;
	private boolean deleted;
	private boolean thatWasModified;
	private boolean checkmarkNo;
	private String Recommend;
	private String ratingAddComment;
	private String starsErrors;
	
	private String ItForTesting;
	
	private Double ThatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable;
	
	
	public EditCommentInfo() {	
	}
	
	
	public EditCommentInfo(String commentText, String title, double rating, boolean wouldRecommendThisToAFriend) {
		this.commentText=commentText;
		this.title=title;
		this.rating=rating;
		this.wouldRecommendThisToAFriend=wouldRecommendThisToAFriend;
	}
	
	public EditCommentInfo(String commentText, Date dateTime, boolean deleted,Date modifiedDateTime, String product_id, String title, String nameOfUser,Double rating, boolean thatWasModified, boolean wouldRecommendThisToAFriend) {
		this.setProduct_id(product_id);
		this.setCommentText(commentText);
		this.setModifiedDateTime(modifiedDateTime);
		this.setDateTime(dateTime);	
		this.setTitle(title);
		this.setWouldRecommendThisToAFriend(wouldRecommendThisToAFriend);
		this.setRating(rating);
		this.setNameOfUser(nameOfUser);	
		this.setDeleted(deleted);
		this.setThatWasModified(thatWasModified);
		this.setThatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable(rating);
	}
	
	public EditCommentInfo(String product_id, String commentText, Date dateTime, String id, Date modifiedDateTime, String title, String nameOfUser, boolean WouldRecommendThisToAFriend, double rating, boolean deleted, boolean ThatWasModified) {
		this.setProduct_id(product_id);
		this.setCommentText(commentText);
		this.setModifiedDateTime(modifiedDateTime);
		this.setId(id);
		this.setDateTime(modifiedDateTime);	
		this.setTitle(title);
		this.setWouldRecommendThisToAFriend(WouldRecommendThisToAFriend);
		this.setRating(rating);
		this.setNameOfUser(nameOfUser);	
		this.setDeleted(deleted);
		this.setThatWasModified(ThatWasModified);
	}
	
	public EditCommentInfo(String Id, String commentText, Date dateTime, boolean deleted,Date modifiedDateTime, String product_id, String title, String nameOfUser,Double rating, boolean thatWasModified, boolean wouldRecommendThisToAFriend) {
		this.setProduct_id(product_id);
		this.setCommentText(commentText);
		this.setModifiedDateTime(modifiedDateTime);
		this.setDateTime(dateTime);	
		this.setTitle(title);
		this.setWouldRecommendThisToAFriend(wouldRecommendThisToAFriend);
		this.setRating(rating);
		this.setNameOfUser(nameOfUser);	
		this.setDeleted(deleted);
		this.setThatWasModified(thatWasModified);
		this.setThatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable(rating);
		this.id=Id;
	}
	
	public EditCommentInfo(String Id,String product_id, String commentText, Date dateTime, String id, Date modifiedDateTime, String title, String nameOfUser, boolean WouldRecommendThisToAFriend, double rating, boolean deleted, boolean ThatWasModified) {
		this.setProduct_id(product_id);
		this.setCommentText(commentText);
		this.setModifiedDateTime(modifiedDateTime);
		this.setId(id);
		this.setDateTime(modifiedDateTime);	
		this.setTitle(title);
		this.setWouldRecommendThisToAFriend(WouldRecommendThisToAFriend);
		this.setRating(rating);
		this.setNameOfUser(nameOfUser);	
		this.setDeleted(deleted);
		this.setThatWasModified(ThatWasModified);
		this.id=Id;
	}
	
	public int getRevises() {
		return revises;
	}

	public void setRevises(int revises) {
		this.revises = revises;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public boolean isWouldRecommendThisToAFriend() {
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public String getRecommend() {
		return Recommend;
	}

	public void setRecommend(String recommend) {
		Recommend = recommend;
	}

	public boolean isThatWasModified() {
		return thatWasModified;
	}

	public void setThatWasModified(boolean thatWasModified) {
		this.thatWasModified = thatWasModified;
	}

	public boolean isCheckmarkNo() {
		return checkmarkNo;
	}

	public void setCheckmarkNo(boolean checkmarkNo) {
		this.checkmarkNo = checkmarkNo;
	}

	public String getRatingAddComment() {
		return ratingAddComment;
	}

	public void setRatingAddComment(String ratingAddComment) {
		this.ratingAddComment = ratingAddComment;
	}

	public String getStarsErrors() {
		return starsErrors;
	}

	public void setStarsErrors(String starsErrors) {
		this.starsErrors = starsErrors;
	}

	public String getItForTesting() {
		return ItForTesting;
	}

	public void setItForTesting(String itForTesting) {
		ItForTesting = itForTesting;
	}

	public Double getThatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable() {
		return ThatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable;
	}

	public void setThatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable(
			Double thatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable) {
		ThatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable = thatVeryStrangeVariableYouShouldNotTryUnderstandThatvariableThatVariableForStarYouShouldNotTryUnderstandThisVariable;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}




}
