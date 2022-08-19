package com.ab.models;


public class Basket {
	
	private int basketId;
	
	private String  bookTitle;

	public Basket(int basketId, String bookTitle) {
		super();
		this.basketId = basketId;
		this.bookTitle = bookTitle;
	}
	
	public Basket(String bookTitle) {
		super();
		this.bookTitle = bookTitle;
	}
	
	public Basket() {
		super();
		
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getBasketId() {
		return basketId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	@Override
	public String toString() {
		return "Basket [basketId=" + basketId + ", bookTitle=" + bookTitle + "]";
	}
		
	
}
