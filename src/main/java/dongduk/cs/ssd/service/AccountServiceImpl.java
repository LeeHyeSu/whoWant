package dongduk.cs.ssd.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.AccountDao;
import dongduk.cs.ssd.model.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account getAccount(String username) {
		return accountDao.getAccount(username);
	}
	
	@Override
	public Account getAccount(String username, String password) {
		return accountDao.getAccount(username, password);
	}
	
	@Override
	public void insertAccount(Account account) {
		account.setJoindate(new Date());
		account.setIsadmin(false);
		accountDao.insertAccount(account);
	}
	
	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}
	
	@Override
	public void removeAccount(String username) {
		accountDao.removeAccount(username);
	}
}
