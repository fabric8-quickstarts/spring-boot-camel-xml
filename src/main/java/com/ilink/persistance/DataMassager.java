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
		Alien alien= (Alien)	exchange.getIn().getBody()	;
	
	 System.out.println("DataMassager--->"+alien);
//	 
//	 if(ObjectUtils.isEmpty(alien.getAlien_id())){
//		 throw new DataException("Alien ID is null for " + alien.getFirstName());
//     }
//	
	}

}
