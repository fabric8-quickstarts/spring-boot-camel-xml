package com.ilink.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
		@Bean(name = "dataSource")
	    @ConfigurationProperties(prefix = "spring.datasource")
	    public DataSource dataSource(){
	        DataSource ds = DataSourceBuilder.create().build();
	        return ds;
	    }
}
