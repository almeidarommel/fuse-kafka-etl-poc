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
public class DataSourceInst1 {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DataSourceInst1.class);
		
 	@Value("${database.inst1.url}")
 	private String dataBaseUrl;
 	
 	@Value("${database.inst1.username}")
 	private String dataBaseUsername;
 	
 	@Value("${database.inst1.password}")
 	private String dataBasePassword;

	@Bean
	public DataSource getDataSource() {
		 
			LOGGER.info("*** DataSourceInst1 ****************");			
		 	LOGGER.info("*** dataBaseUrl: " + dataBaseUrl);
		 	LOGGER.info("*** dataBaseUsername: " + dataBaseUsername);
		 	LOGGER.info("*** dataBasePassword: " + dataBasePassword);
		 
		 
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl(this.dataBaseUrl);
			dataSource.setUsername(this.dataBaseUsername);
			dataSource.setPassword(this.dataBasePassword);
			return dataSource;
		}
}