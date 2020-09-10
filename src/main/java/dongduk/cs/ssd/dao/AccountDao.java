package dongduk.cs.ssd.dao;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.model.Account;

public interface AccountDao {
	
	Account getAccount(String username) throws DataAccessException;

	Account getAccount(String username, String password) throws DataAccessException;

	void insertAccount(Account account) throws DataAccessException;

	void updateAccount(Account account) throws DataAccessException;

	void removeAccount(String username) throws DataAccessException;

}
