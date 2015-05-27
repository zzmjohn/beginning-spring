package com.wiley.beginningspring.ch4;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

@Configuration
public class Ch4Configuration {
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
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public AccountDao accountDao() {
        AccountDaoJdbcImpl accountDao = new AccountDaoJdbcImpl();
        accountDao.setJdbcTemplate(jdbcTemplate());
        accountDao.setAccountByIdQuery(accountByIdQuery());
        accountDao.setAccountInsert(accountInsert());
        accountDao.setAccountUpdate(accountUpdate());
        accountDao.setAccountDelete(accountDelete());
        return accountDao;
    }
    
    @Bean
    public MappingSqlQuery<Account> accountByIdQuery() {
        AccountByIdQuery query = new AccountByIdQuery(dataSource());
        return query;
    }
    
    @Bean
    public SqlUpdate accountInsert() {
    	AccountInsert accountInsert = new AccountInsert(dataSource());
    	return accountInsert;
    }
    
    @Bean
    public SqlUpdate accountUpdate() {
    	AccountUpdate accountUpdate = new AccountUpdate(dataSource());
    	return accountUpdate;
    }
    
    @Bean
    public SqlUpdate accountDelete() {
    	AccountDelete accountDelete = new AccountDelete(dataSource());
    	return accountDelete;
    }
}
