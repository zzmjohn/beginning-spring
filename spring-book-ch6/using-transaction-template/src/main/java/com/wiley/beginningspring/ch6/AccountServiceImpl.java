package com.wiley.beginningspring.ch6;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.wiley.beginningspring.ch4.Account;
import com.wiley.beginningspring.ch4.AccountDao;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionTemplate transactionTemplate;
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

    @Override
    public void transferMoney(final long sourceAccountId, final long targetAccountId,
            final double amount) {
    	transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				Account sourceAccount = accountDao.find(sourceAccountId);
				Account targetAccount = accountDao.find(targetAccountId);
				sourceAccount.setBalance(sourceAccount.getBalance() - amount);
				targetAccount.setBalance(targetAccount.getBalance() + amount);
				accountDao.update(sourceAccount);
				accountDao.update(targetAccount);				
			}
		});
    }
}
