package com.ilink.routing;
import javax.sql.DataSource;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ilink.domain.Alien;
import com.ilink.exception.DataException;
import com.ilink.email.Email;
import com.ilink.persistance.DataMassager;
import com.ilink.persistance.DmlCrud;




@Component
public class KafkaRoute extends RouteBuilder{
	
    @Autowired
    Environment environment;

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    Email mailProcessor;
    
    @Autowired
    DataMassager validateDataProcessor;
    
    @Autowired
    DmlCrud dmlCrud;

	@SuppressWarnings("unchecked")
	@Override
	public void configure() throws Exception {
		//from("quartz2://logMessageGroup/logMessageTimer?cron=0/30+*+*+*+*+?")
       // .log("How are you doing guys today!");
		
		GsonDataFormat alien = new GsonDataFormat(Alien.class);
		
		
	    onException(PSQLException.class).log(LoggingLevel.ERROR,"PSQLException in the route ${body}")
        .maximumRedeliveries(3).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.ERROR);

        onException(DataException.class,RuntimeException.class).log(LoggingLevel.ERROR, "DataException in the route ${body}")
        .process(mailProcessor)
        .to("{{errorRoute}}");


		from("{{fromRoute}}")
		            .log("Current Environment is "+ environment.getProperty("message"))
		            .unmarshal(alien)
		            .log("From Kafka-----------> ${body}")
		            .process(validateDataProcessor)
		            .process(dmlCrud)
		        .to("{{toRoute}}");
		
		}
		
	

}
