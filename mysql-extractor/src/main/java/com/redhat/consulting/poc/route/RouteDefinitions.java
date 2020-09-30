package com.redhat.consulting.poc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteDefinitions extends RouteBuilder {

	@Override
	public void configure() throws Exception {		
		
		from("timer://foo?fixedRate=true&period=1000")
		.log("EXECUTANDO");
		
	}
	
}
