package com.redhat.consulting.poc.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.consulting.poc.entity.PessoaEntity;
import com.redhat.consulting.poc.entity.PessoaModel;

public class ExtractorProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		//GEt Entity
		PessoaEntity entity = exchange.getIn().getBody(PessoaEntity.class);			
		
		//TODO Cast to Model Objecta, maybe can used a Dozer		
		PessoaModel model = new PessoaModel();
		model.setPostgresId(entity.getId());
		model.setNome(entity.getNome());		
		model.setCpf(entity.getCpf());
		
		
		exchange.getIn().setBody(model);
		
		
	}

}
