package com.sawforgarden.myapp.model;


import com.fasterxml.jackson.annotation.JsonView;


public class AjaxResponseBody {

	
	
	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	@JsonView(Views.Public.class)
	String quantity;
	@JsonView(Views.Public.class)
	String page;
	@JsonView(Views.Public.class)
	String AmountItemsOfCartForTopMenu;
	
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	
	

	public String getAmountItemsOfCartForTopMenu() {
		return AmountItemsOfCartForTopMenu;
	}

	public void setAmountItemsOfCartForTopMenu(String amountItemsOfCartForTopMenu) {
		AmountItemsOfCartForTopMenu = amountItemsOfCartForTopMenu;
	}
	
	public void PlusOneToAmountItemsOfCartForTopMenu(String amountItemsOfCartForTopMenu) {
		this.AmountItemsOfCartForTopMenu=String.valueOf(Integer.parseInt(amountItemsOfCartForTopMenu.trim())+1);
	}


	
	
	public String getValue() {
		return "1";
	}
	
	
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity=quantity;
	}
	
	public void plusOneToQuantity(String quantity) {
		this.quantity=String.valueOf(Integer.parseInt(quantity)+1);
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "AjaxResponseResult [msg=" + msg + ", code=" + code + "]";
	}

	public void MinusOneToQuantity(String quantity) {
		this.quantity=String.valueOf(Integer.parseInt(quantity)-1);

		
	}

	public void MinusOneToAmountItemsOfCartForTopMenu(String amountItemsOfCartForTopMenu) {
		this.AmountItemsOfCartForTopMenu=String.valueOf(Integer.parseInt(amountItemsOfCartForTopMenu.trim())-1);
	}

}
