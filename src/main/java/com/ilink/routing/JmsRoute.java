package com.ilink.routing;

import javax.sql.DataSource;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ilink.email.Email;
import com.ilink.exception.DataException;




@Component
public class JmsRoute extends RouteBuilder{
	
	
	 @Autowired
	    Environment environment;

	    @Qualifier("dataSource")
	    @Autowired
	    DataSource dataSource;

	    @Autowired
	    Email mailProcessor;


	    @SuppressWarnings("unchecked")
		public void configure() throws Exception {

	        onException(PSQLException.class).log(LoggingLevel.ERROR,"PSQLException in the route ${body}")
	                .maximumRedeliveries(3).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.ERROR);

	        onException(DataException.class,RuntimeException.class).log(LoggingLevel.ERROR, "DataException in the route ${body}")
	                .process(mailProcessor);


	        from("{{fromJmsRoute}}").startupOrder(1)
	                    .log("Read Message from activemQ ${body}")
	                    
	                //.to("{{toJmsRoute}}");
	                    .to("{{fromKafkaRoute}}");
	                    

	        }

}
