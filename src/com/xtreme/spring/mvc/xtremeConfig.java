package com.xtreme.spring.mvc;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.xtreme.*"})
@EnableTransactionManagement
@Import ({SecuritConfig.class})
public class xtremeConfig {
	
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.scanPackages("com.xtreme.user.hibernate");
		builder.addProperties(getHibernateProperties());
		return builder.buildSessionFactory();		
	}
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/xtremefitness");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("ram");
		return driverManagerDataSource;	
	}
	
	private Properties getHibernateProperties(){
		Properties prop = new Properties();
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return prop;
	}
	
	@Bean
	public HibernateTransactionManager txManger(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}