package com.ilink.persistance;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.ilink.domain.Alien;

@Component
public class DmlCrud  implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
	    Alien alien = (Alien) exchange.getIn().getBody();
	   
	    System.out.println(" Alien in Processor is : " + alien);
        String tableName ="alien";
        StringBuilder query = new StringBuilder();

        if(alien.getTransactionType().equals("ADD")){
            query.append("INSERT INTO "+tableName+ "(alien_id, first_name,last_name,address,email) VALUES (");
            query.append(alien.getAlien_id()+",'"+alien.getFirstName()+"','"+alien.getLastName()+"','"+alien.getAddress()+"','"+alien.getEmail()+"'"+")");

        }else if(alien.getTransactionType().equals("UPDATE")){
            query.append("UPDATE "+tableName+" SET email =");
            query.append(alien.getEmail()+" where alien_id = '"+alien.getAlien_id()+"'");

        }else if(alien.getTransactionType().equals("DELETE")){
            query.append("DELETE FROM " + tableName + " where alien_id = '"+alien.getAlien_id()+"'");
        }
        System.out.println("Final Query is : " + query);
        exchange.getIn().setBody(query.toString());
        exchange.getIn().setHeader("alien_id",alien.getAlien_id());		
	}

}
