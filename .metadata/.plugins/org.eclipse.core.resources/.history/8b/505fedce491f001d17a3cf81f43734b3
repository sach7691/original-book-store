package com.ab.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ab.models.Book;
import com.ab.utilities.DatabaseConnection;

public class BasketDatabaseDAOImpl implements BasketDAO {

    private Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
		
	@Override
	public Book addBook(String bookTitle) {
		
		con = DatabaseConnection.getConnection();
		
		 String query = "SELECT * FROM book WHERE bookTitle = ?";
		
		 Book book = new Book();
			
		 try {
		      
	    	   pst = con.prepareStatement(query);
	    	   
	    	   pst.setString(1,bookTitle);
	    	   
	    	   rs = pst.executeQuery();
				
				if (rs.next()) {
						
					book.setBookISBN(rs.getInt("bookISBN"));
					book.setBookTitle(rs.getString("bookTitle"));
					book.setBookAuthor(rs.getString("bookAuthor"));
					book.setBookPrice(rs.getDouble("bookPrice"));
					book.setQuantity(rs.getInt("quantity"));
		        
				return book;
				}
	    	   
		  }catch (SQLException e) {
			  
			 System.out.println(e);
		  }
			
		return book;
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
