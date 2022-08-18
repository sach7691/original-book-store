package com.ab.services;
import java.util.List;
import com.ab.models.Book;

public interface BasketService {
	
	public Book addBook(String bookTitle); //check isbn is already in the store
	public List<Book> viewBasket();
	public Book modifyBasket(int bookISBN);
	public boolean checkout(boolean status);

}
