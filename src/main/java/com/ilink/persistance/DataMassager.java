package com.ilink.persistance;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ilink.domain.Alien;
import com.ilink.exception.DataException;



@Component

public class DataMassager implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Alien alien= (Alien)	exchange.getOut().getBody()	;
//	
//	 System.out.println("DataMassager--->"+alien);
//	 System.out.println("DataMassager--->"+alien.getAlien_id());
//	 System.out.println("DataMassager--->"+alien.getFirstName());
//
//	 System.out.println("DataMassager--->"+alien.getLastName());
//	 System.out.println("DataMassager--->"+alien.getAddress());
//	 System.out.println("DataMassager--->"+alien.getEmail());

	 
	 
//	 
//	 if(ObjectUtils.isEmpty(alien.getAlien_id())){
//		 throw new DataException("Alien ID is null for " + alien.getFirstName());
//     }
//	
	}

}
