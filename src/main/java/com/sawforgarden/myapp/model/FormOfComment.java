package com.sawforgarden.myapp.model;

public class FormOfComment {

	
	private String username;
	private String email;
	private String star;
	private String textArea;

 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getTextArea() {
		return (String) textArea;
	}
	public void setTextArea(String textArea) {
		textArea = (String) this.textArea;
	}
	
	
	
}
