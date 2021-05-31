package com.pojo;

public class UserStock {
	
	private String savedStockSymbol;
	private int quantity;
	
	public UserStock(String savedStockSymbol, int quantity) {
		super();
		this.savedStockSymbol = savedStockSymbol;
		this.quantity = quantity;
	}


	public UserStock(String savedStockSymbol) {
		super();
		this.savedStockSymbol = savedStockSymbol;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	

	public String getSavedStockSymbol() {
		return savedStockSymbol;
	}


	public void setSavedStockSymbol(String savedStockSymbol) {
		this.savedStockSymbol = savedStockSymbol;
	}


	@Override
	public String toString() {
		return "UserStock [savedStockSymbol=" + savedStockSymbol + ", quantity=" + quantity + "]";
	}


	
}
