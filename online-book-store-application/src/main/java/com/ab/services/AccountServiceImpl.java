package com.ab.services;

import com.ab.daos.AccountDAO;
import com.ab.models.Customer;

public class AccountServiceImpl implements AccountService {

	
	private AccountDAO accountDAO;
	
	
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	@Override
	public Customer viewAccountDetails(String customerEmail) {
		
		return accountDAO.viewAccountDetails(customerEmail);
	}

	@Override
	public Customer modifyAccountDetails(Customer customer) {
		
		return accountDAO.modifyAccountDetails(customer);
	}

}
