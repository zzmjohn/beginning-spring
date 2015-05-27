package com.wiley.beginningspring.ch6;

public interface AccountService {
	public void transferMoney(long sourceAccountId, long targetAccountId,
			double amount);
}
