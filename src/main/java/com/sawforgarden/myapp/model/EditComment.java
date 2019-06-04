package com.sawforgarden.myapp.model;

public class EditComment {

	private String id;
	private String textarea;
	private String rating;
	private String lastModified;
	private String title;
	private String recommendToAFriend;
	private String name;
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTextarea() {
		return textarea;
	}
	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRecommendToAFriend() {
		return recommendToAFriend;
	}
	public void setRecommendToAFriend(String recommendToAFriend) {
		this.recommendToAFriend = recommendToAFriend;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
