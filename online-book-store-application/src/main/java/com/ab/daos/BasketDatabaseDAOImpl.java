package com.ab.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ab.models.Basket;
import com.ab.models.Book;
import com.ab.utilities.BSFactory;
import com.ab.utilities.DatabaseConnection;

public class BasketDatabaseDAOImpl implements BasketDAO {

    private Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
		
	@Override
	public Basket addBook(String bookTitle) {
		
		con = DatabaseConnection.getConnection();
		
		 String query = "INSERT INTO basket (bookTitle) VALUES(?) ";
		 
		// System.out.println(bookTitle);
		 
		 Basket basket = new Basket(bookTitle);
			
		 try {
			 			 
			    pst = con.prepareStatement(query);
				pst.setString(1, basket.getBookTitle());
				
				int i = pst.executeUpdate();
				
				//System.out.println(i);
				
				if (i >0) {
					
					return basket;
				} 
			 
		        }catch (SQLException e) {
			  
			 System.out.println(e);
		       }
			
		      return basket;
	}
		
	@Override
	public List<Basket> viewBasket() {

		con = DatabaseConnection.getConnection();
	       
	       String query = "SELECT bookTitle FROM basket";
	       
	       List<Basket> bList = new ArrayList<>();
	       
	       try {
	      
	    	   pst = con.prepareStatement(query);
	    	   
	    	   rs = pst.executeQuery();
	    	   	   
	    	   while(rs.next()) {
	    		   		  
	    		   Basket b = new Basket(rs.getString("bookTitle"));
	    		   bList.add(b);
	    		       		   
	    	    } 
	    	   
	       
	           }catch(SQLException e) {
	    	   
	    	   System.out.println(e);
	         }	
	      
	       return bList;
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
