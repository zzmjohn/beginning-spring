package com.wiley.beginningspring.ch5;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class Ch5Configuration {

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
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean factoryBean = 
	        new LocalContainerEntityManagerFactoryBean();
	    factoryBean.setDataSource(dataSource());
	    //factoryBean.setJpaPropertyMap(jpaProperties());
	    //factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	    //factoryBean.setJpaDialect(new HibernateJpaDialect());

	    factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
	    return factoryBean;
	}


	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	    jpaVendorAdapter.setGenerateDdl(true);
	    jpaVendorAdapter.setDatabase(Database.H2);
	    return jpaVendorAdapter;
	}



}
