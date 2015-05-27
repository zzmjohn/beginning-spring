package com.wiley.beginningspring.ch6;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.wiley.beginningspring.ch4.Account;
import com.wiley.beginningspring.ch4.AccountDao;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private PlatformTransactionManager transactionManager;
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId,
            double amount) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            Account sourceAccount = accountDao.find(sourceAccountId);
            Account targetAccount = accountDao.find(targetAccountId);
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);
            accountDao.update(sourceAccount);
            accountDao.update(targetAccount);
            transactionManager.commit(status);
        } catch (Exception e) {
        	transactionManager.rollback(status);
            throw new RuntimeException(e);
        }
    }
}
