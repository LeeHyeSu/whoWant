package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.HashMap;

import dongduk.cs.ssd.model.Account;

public interface AccountMapper {
	Account getAccountByUsername(String username);
	
	Account getAccountByUsernameAndPassword(HashMap<String, Object> map);
	  
	void insertAccount(Account account);

	void updateAccount(Account account);
	
	void removeAccount(String username);
}
