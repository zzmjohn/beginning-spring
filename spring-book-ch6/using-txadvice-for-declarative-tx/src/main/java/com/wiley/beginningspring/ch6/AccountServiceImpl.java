package com.wiley.beginningspring.ch6;

import org.springframework.transaction.annotation.Transactional;

import com.wiley.beginningspring.ch4.Account;
import com.wiley.beginningspring.ch4.AccountDao;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    //@Transactional
    public void transferMoney(long sourceAccountId, long targetAccountId,
            double amount) {
        Account sourceAccount = accountDao.find(sourceAccountId);
        Account targetAccount = accountDao.find(targetAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountDao.update(sourceAccount);
        accountDao.update(targetAccount);
    }
}
