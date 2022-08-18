package com.ab.services;
import java.util.List;
import com.ab.daos.BasketDAO;
import com.ab.models.Book;

public class BasketServiceImpl implements BasketService {

	private BasketDAO basketDAO;
	
	
	public BasketServiceImpl(BasketDAO basketDAO) {
		super();
		this.basketDAO = basketDAO;
	}

	@Override
	public Book addBook(String bookTitle) {
		
		return this.basketDAO.addBook(bookTitle);
	}

	@Override
	public List<Book> viewBasket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book modifyBasket(int bookISBN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkout(boolean status) {
		// TODO Auto-generated method stub
		return false;
	}

}
