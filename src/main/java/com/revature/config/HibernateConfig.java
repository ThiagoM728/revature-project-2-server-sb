package com.revature.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.models.Job;
import com.revature.models.Student;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		System.out.println("Configuring session factory");
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		
		// Set annotated classes
		factoryBean.setAnnotatedClasses(Student.class);
		factoryBean.setAnnotatedClasses(Job.class);
		factoryBean.setDataSource(getDataSource());
		return factoryBean;
	}
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("Configuring data source");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("Tony1988");
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		System.out.println("Configuring transaction manager");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
