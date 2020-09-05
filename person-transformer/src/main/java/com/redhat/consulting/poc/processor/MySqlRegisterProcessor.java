package com.redhat.consulting.poc.processor;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.consulting.poc.entity.PessoaModel;
import com.redhat.consulting.poc.entity.UniquePersonEntity;

public class MySqlRegisterProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {

		PessoaModel model = (PessoaModel) exchange.getIn().getHeader("MySqlPerson");
		UniquePersonEntity entity = null;

		java.util.List<UniquePersonEntity> list =  (List<UniquePersonEntity>) exchange.getIn().getBody();
		
		if (null == list || list.isEmpty()) {
			
			entity = new UniquePersonEntity();
			
		} else {
			
			entity = list.get(0);
			
		}

		entity.setName(model.getNome());
		entity.setSocialSecurity(model.getCpf());

		if (null != model.getMysqlId()) {
			entity.setIdMysql(model.getMysqlId());
			entity.setBirthDate(model.getAniversario());
			entity.setCellPhone(model.getCelular());
		}

		if (null != model.getPostgresId()) {

			entity.setIdPostgres(model.getPostgresId());
		}

		exchange.getIn().setBody(entity);
	}

}
