package com.wiley.beginningspring.ch6;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceJdbcTxImpl();
        accountService.transferMoney(100L,101L, 5.0d);
	}

}
