package com.wiley.beginningspring.ch6;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wiley.beginningspring.ch4.AccountDao;
import com.wiley.beginningspring.ch4.Ch4Configuration;

@Configuration
//@EnableTransactionManagement
@Import(Ch4Configuration.class)
@ImportResource("classpath:/beans-tx.xml")
public class Ch6Configuration {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
    @Bean
    @Autowired
    public AccountService accountService(AccountDao accountDao) {
        AccountServiceImpl bean = new AccountServiceImpl();
        bean.setAccountDao(accountDao);
        return bean;
    }
}
