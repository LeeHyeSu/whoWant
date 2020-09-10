package dongduk.cs.ssd.controller;

import dongduk.cs.ssd.model.Account;

public class UserSession {
	private Account account;

	public UserSession(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}
	
}
