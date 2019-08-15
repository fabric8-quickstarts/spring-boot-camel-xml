package com.ilink.email;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class Email implements Processor {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    Environment environment;

    @Override
    public void process(Exchange exchange) throws Exception {

       // Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
       // String messageBody = "Exception happened in the route and the exception is  " + e.getMessage();
		  MimeMessage messageMime =  emailSender.createMimeMessage();
		  MimeMessageHelper helper = new
		  MimeMessageHelper((javax.mail.internet.MimeMessage) messageMime, true);
		  helper.setFrom(environment.getProperty("mailFrom"));
		  helper.setTo(environment.getProperty("mailto"));
		  //helper.setSubject("Exception in Camel Route with data attachement encrypted "
		  //); 
		  File file = new File(
					getClass().getClassLoader().getResource("application.yml").getFile()
				);
		  helper.setSubject("Congratulations Your visa has been approved !!!!! Have a Safe Journey !!! ");
		  helper.setText("Data persisted in postgreSQL DB.");
		  helper.addAttachment("myattachement-SpringFileAttached",file);
		  emailSender.send((javax.mail.internet.MimeMessage) messageMime);
		 

    }

}
