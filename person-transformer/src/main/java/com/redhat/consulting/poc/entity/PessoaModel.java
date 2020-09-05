package com.redhat.consulting.poc.entity;

import java.io.Serializable;
import java.util.Date;

public class PessoaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3357004496001517295L;
	
	private Integer postgresId;
	private Integer mysqlId;
	private String nome;
	private Date aniversario;
	private String celular;
	private String cpf;

	public PessoaModel() {
		super();
	}
	
	public PessoaModel(Integer postgresId, Integer mysqlId, String nome, String cpf) {
		super();
		this.postgresId = postgresId;
		this.mysqlId = mysqlId;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getPostgresId() {
		return postgresId;
	}

	public void setPostgresId(Integer postgresId) {
		this.postgresId = postgresId;
	}

	public Integer getMysqlId() {
		return mysqlId;
	}

	public void setMysqlId(Integer mysqlId) {
		this.mysqlId = mysqlId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
			
}
