package com.redhat.consulting.poc.entity;

import java.io.Serializable;

public class PessoaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3357004496001517295L;
	
	private Integer integraId;
	private Integer sigesId;
	private String nome;
	private String cpf;

	public PessoaModel() {
		super();
	}
	
	public PessoaModel(Integer integraId, Integer sigesId, String nome, String cpf) {
		super();
		this.integraId = integraId;
		this.sigesId = sigesId;
		this.nome = nome;
		this.cpf = cpf;
	}
		
	public Integer getIntegraId() {
		return integraId;
	}
	public void setIntegraId(Integer integraId) {
		this.integraId = integraId;
	}
	public Integer getSigesId() {
		return sigesId;
	}
	public void setSigesId(Integer sigesId) {
		this.sigesId = sigesId;
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

	@Override
	public String toString() {
		return "PessoaModel [integraId=" + integraId + ", sigesId=" + sigesId + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	
	
}
