package com.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springsecurity.demo")
@PropertySource("classpath:persistence-msql.properties")
public class DemoAppConfig {

	// SET UP A VARIBALE TO HOLD PROPERTIES
	
	@Autowired
	private Environment env;
	
	// SET UO A LOGGER FOR DIAGNOSTIC
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//DEFINE BEAN FOR VIEWRESOLVER
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	// DEFINE A BEAN FOR SECURE DATASOURCE
	
	@Bean
	public DataSource securityDataSource() {
		
		//CREATE CONNECTION POOL
		ComboPooledDataSource securityDataSource =
				new ComboPooledDataSource();
		
		//SET THE JDBC DRIVER CLASS
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException (exc);
			
		}
		
		// LOG THE COONECTION PROPS
		logger.info(">>>jdbc.url = " + env.getProperty("jdbc.driver"));
		logger.info(">>>jdbc.user = " + env.getProperty("jdbc.user"));
		
		//SET DATABASE CONNECTION PROPS
		
		// SET CONNECTION POOL PROPS
		
		
		
		
		return securityDataSource;
	}
	
	
	
	
}
