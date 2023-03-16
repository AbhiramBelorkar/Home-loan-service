package com.app.service;

import com.app.pojos.AccountDetails;

public interface AccountDetailsServiceI 
{

	public AccountDetails SaveAccountDetails(AccountDetails ad);

	public Iterable<AccountDetails> getAllAccountDetails();
	
    public void deleteAccountDetails(Integer accountId);

	public AccountDetails getSingleAccountDetails(Integer accountId);

	public AccountDetails updateAccountDetails(Integer accountId, AccountDetails a);

	
	

}
