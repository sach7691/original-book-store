package com.ab.daos;
import com.ab.models.Customer;

public interface AccountDAO {
	
	
	public Customer viewAccountDetails(String customerEmail);
	public Customer modifyAccountDetails(Customer customer);

}
