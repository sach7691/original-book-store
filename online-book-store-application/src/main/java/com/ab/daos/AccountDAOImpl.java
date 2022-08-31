package com.ab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ab.models.Book;
import com.ab.models.Customer;
import com.ab.utilities.BSFactory;
import com.ab.utilities.DatabaseConnection;

public class AccountDAOImpl implements AccountDAO {
	
    private static Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;

	@Override
	public Customer viewAccountDetails(String customerEmail) {
		
		con = DatabaseConnection.getConnection();
		
		String query = "SELECT * FROM customer WHERE customerEmail = ?";
		
		Customer cus = null;
		
		try {
		      
	    	   pst = con.prepareStatement(query);
	    	   
	    	   pst.setString(1,customerEmail);
	    	   
	    	   rs = pst.executeQuery();
	    	   	   
	    	   while(rs.next()) {
	    		   		  
	    		  cus = new Customer(rs.getInt("customerId"),rs.getString("firstName"),rs.getString("lastName"),customerEmail);  				 
	    		       		   
	    	    } 
	    	   
	       
	           }catch(SQLException e) {
	    	   
	    	   System.out.println(e);
	         }		
		
		  return cus;
	}	
	
	@Override
	public Customer modifyAccountDetails(Customer customer) {
		
		con = DatabaseConnection.getConnection();
		
		String query = "UPDATE customer SET firstName = ?, lastName = ?, customerPassword =? WHERE customerEmail = ? ";
		
		
		try {
		      
	    	   pst = con.prepareStatement(query);
	    	   
	    	   pst.setString(1,customer.getFirstName());
	    	   pst.setString(2,customer.getLastName());
	    	   pst.setString(3,customer.getCustomerPassword());
	    	   pst.setString(4,customer.getCustomerEmail());
	    	   
	    	   int i = pst.executeUpdate();
	    	   	   
	    	  if(i>0) {
	    		   		  
	    		  return customer;			 
	    		       		   
	    	    } 
	    	   
	       
	           }catch(SQLException e) {
	    	   
	    	   System.out.println(e);
	         }
		return customer;		
				
	}

}