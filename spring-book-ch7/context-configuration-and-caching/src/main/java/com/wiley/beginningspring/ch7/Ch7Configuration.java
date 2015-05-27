package com.wiley.beginningspring.ch7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.beginningspring.ch7.AccountDao;
import com.wiley.beginningspring.ch7.AccountDaoInMemoryImpl;
import com.wiley.beginningspring.ch7.AccountService;
import com.wiley.beginningspring.ch7.AccountServiceImpl;

@Configuration
public class Ch7Configuration {
	@Bean
	public AccountService accountService() {
		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao());
		return bean;
	}
	
	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//depedencies of accountDao bean will be injected here...
		return bean;
	}
}
