package dongduk.cs.ssd.dao.mybatis;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.AccountDao;
import dongduk.cs.ssd.dao.mybatis.mapper.AccountMapper;
import dongduk.cs.ssd.model.Account;

@Repository
public class MybatisAccountDao implements AccountDao{
	
	@Autowired
	private AccountMapper accountMapper;
	
	public Account getAccount(String username) throws DataAccessException {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccount(String username, String password) 
			throws DataAccessException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		
		return accountMapper.getAccountByUsernameAndPassword(map);
	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
	}

	@Override
	public void removeAccount(String username) throws DataAccessException {
		accountMapper.removeAccount(username);
	}

}
