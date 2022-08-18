package com.ab.services;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ab.daos.CustomerDAO;
import com.ab.models.Customer;
import com.ab.utilities.BSFactory;
import com.ab.utilities.DataValidation;

public class CustomerServiceImpl implements CustomerService{

	
	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		
		super();
		this.customerDAO = customerDAO;
		
	}
	
	@Override
	public Customer registerCustomer(Customer customer) {
		
		String password = customer.getCustomerPassword();
		String email = customer.getCustomerEmail();
		
		String encryptedPassword = DataValidation.encryptPassword(password);
		
		String validatedEmail = DataValidation.validateEmail(email);
		     
	    Customer cus = BSFactory.getCustomer(customer.getFirstName(), customer.getLastName(), validatedEmail, encryptedPassword);
	        
	    return BSFactory.getCustomerDAO().registerCustomer(cus);
	        		
	}

	@Override
	public Customer loginCustomer(String customerEmail, String customerPassword) {
		
		String password = customerPassword;
		String email = customerEmail;
		
		String encryptedPassword = DataValidation.encryptPassword(password);
		
		String validatedEmail = DataValidation.validateEmail(email);
		
		return BSFactory.getCustomerDAO().loginCustomer(validatedEmail, encryptedPassword);
	
	}


}
