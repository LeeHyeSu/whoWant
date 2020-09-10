package dongduk.cs.ssd.service;

import dongduk.cs.ssd.model.Account;

public interface AccountService {
	
	Account getAccount(String username);
	
	Account getAccount(String username, String password);
	
	void insertAccount(Account account);
	
	void updateAccount(Account account);
	
	void removeAccount(String username);

}
