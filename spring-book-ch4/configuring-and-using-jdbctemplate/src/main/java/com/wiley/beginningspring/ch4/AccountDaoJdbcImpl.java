package com.wiley.beginningspring.ch4;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoJdbcImpl implements AccountDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	public void insert(Account account) {
		// TODO Auto-generated method stub
		
	}

	public void update(Account account) {
		// TODO Auto-generated method stub
		
	}

	public void update(List<Account> accounts) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long accountId) {
		// TODO Auto-generated method stub
		
	}

	public Account find(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(List<Long> accountIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(String ownerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> find(boolean locked) {
		// TODO Auto-generated method stub
		return null;
	}

    //method implementations...
}
