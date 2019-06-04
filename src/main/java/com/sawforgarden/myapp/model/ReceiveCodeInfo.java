package com.sawforgarden.myapp.model;

public class ReceiveCodeInfo {

	private String emailcode;
    private boolean newProduct=false;


	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	public String getEmailcode() {
		return emailcode;
	}

	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}
	
}
