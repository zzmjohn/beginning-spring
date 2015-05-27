package com.wiley.beginningspring.ch6;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
    public void transferMoney(
        long sourceAccountId, long targetAccountId, double amount) {
        //...
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void depositMoney(long accountId, double amount) throws Exception {
    	Account account = entityManager.find(Account.class, 100L);
    	account.setBalance(account.getBalance() + amount);
    }

    @Override
    @Transactional(readOnly=true)
    public Account getAccount(long accountId) {
    	return null;
    }
}
