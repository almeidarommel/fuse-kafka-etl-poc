package com.redhat.consulting.poc;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
@ConfigurationProperties
public class DataSourceMySQl {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DataSourceMySQl.class);
		
 	@Value("${database.mysql.url}")
 	private String dataBaseUrl;
 	
 	@Value("${database.mysql.username}")
 	private String dataBaseUsername;
 	
 	@Value("${database.mysql.password}")
 	private String dataBasePassword;

	@Bean
	public DataSource getDataSource() {
		 		 
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setUrl(this.dataBaseUrl);
			dataSource.setUsername(this.dataBaseUsername);
			dataSource.setPassword(this.dataBasePassword);
			return dataSource;
		}
}