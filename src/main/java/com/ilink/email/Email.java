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
		  helper.setSubject("User Data persited in DB please see attached encrypted data ");
		  helper.setText("Hello Yogi");
		  helper.addAttachment("myattachement-SpringFileAttached",new File("/Users/yogarajkhanal/iyogi/README.md"));
		  emailSender.send((javax.mail.internet.MimeMessage) messageMime);
		 

    }

}
