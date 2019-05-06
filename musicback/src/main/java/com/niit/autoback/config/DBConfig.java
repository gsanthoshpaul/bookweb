package com.niit.autoback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.autoback.model.CartItems;
import com.niit.autoback.model.Category;
import com.niit.autoback.model.OrderDetails;
import com.niit.autoback.model.Product;
import com.niit.autoback.model.Suppliers;
import com.niit.autoback.model.User;

@Configuration
@ComponentScan
@EnableTransactionManagement

public class DBConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/automobiledb");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		System.out.println("database started");
		return datasource;

	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("hibernate properties");
		return prop;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		
		  builder.addAnnotatedClass(User.class);
		  builder.addAnnotatedClass(Category.class);
		  builder.addAnnotatedClass(Suppliers.class);
		  builder.addAnnotatedClass(Product.class);
		  builder.addAnnotatedClass(OrderDetails.class);
		  builder.addAnnotatedClass(CartItems.class);
		 
		// builder.scanPackages("com.niit.autoback");
		return builder.buildSessionFactory();

	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		System.out.println("=======================HibernateTransactionManager Object Created=======================");
		return new HibernateTransactionManager(sessionFactory);
	}
}
