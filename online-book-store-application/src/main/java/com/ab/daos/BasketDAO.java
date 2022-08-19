package com.ab.daos;
import java.util.List;
import com.ab.models.Basket;
import com.ab.models.Book;

public interface BasketDAO {
	
	public Basket addBook(String bookTitle); //check isbn is already in the store
	public List<Basket> viewBasket();
	public Book modifyBasket(int bookISBN);
	public boolean checkout(boolean status);

}
