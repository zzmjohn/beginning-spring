package com.wiley.beginningspring.ch6;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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
    	TransactionSynchronizationManager.registerSynchronization(new MyTxSync());
    	
    	Account account = entityManager.find(Account.class, 100L);
    	account.setBalance(account.getBalance() + amount);
    	
    	if(true) throw new RuntimeException("thrown to test tx sync");
    }

    @Override
    @Transactional(readOnly=true)
    public Account getAccount(long accountId) {
    	return null;
    }
}
