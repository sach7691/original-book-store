package com.ab.services;

import com.ab.models.Customer;

public interface AccountService {
	
	public Customer viewAccountDetails(String customerEmail);
	public Customer modifyAccountDetails(Customer customer);


}
