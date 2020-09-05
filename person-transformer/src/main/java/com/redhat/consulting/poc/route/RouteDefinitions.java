package com.redhat.consulting.poc.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.consulting.poc.entity.PessoaModel;
import com.redhat.consulting.poc.processor.MySqlRegisterProcessor;

@Component
public class RouteDefinitions extends RouteBuilder {

	//@Autowired
	//private MySqlRegisterProcessor mySqlRegisterProcessor;
	
	@Override
	public void configure() throws Exception {		
		
		from("kafka:person_topic?brokers={{kafka.bootstrap.server}}&groupId=groupOne")
			.unmarshal().json(JsonLibrary.Jackson, PessoaModel.class)
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					
					PessoaModel model = exchange.getIn().getBody(PessoaModel.class);
					exchange.getIn().setHeader("MySqlPerson", model);
					exchange.getIn().setHeader("socialSecurity", model.getCpf());
					
				}
			})
			
			.toD("jpa://com.redhat.consulting.poc.entity.UniquePersonEntity?query=SELECT c FROM UniquePersonEntity c WHERE socialSecurity = ${headers.socialSecurity}")			
			.process(new MySqlRegisterProcessor())
			.toD("jpa://com.redhat.consulting.poc.entity.UniquePersonEntity")
			;	
			
						
	}
	
}
