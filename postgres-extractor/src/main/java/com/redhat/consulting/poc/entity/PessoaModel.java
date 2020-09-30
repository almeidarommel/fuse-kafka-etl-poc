package com.redhat.consulting.poc.entity;

import java.io.Serializable;

public class PessoaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3357004496001517295L;
	
	private Integer postgresId;
	private Integer mysqlId;
	private String nome;
	private String cpf;

	public PessoaModel() {
		super();
	}
	
	public PessoaModel(Integer mysqlId, Integer postgresId, String nome, String cpf) {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PessoaModel [postgresId=" + postgresId + ", mysqlId=" + mysqlId + ", nome=" + nome + ", cpf=" + cpf
				+ "]";
	}
			
	
	
	
	
}
