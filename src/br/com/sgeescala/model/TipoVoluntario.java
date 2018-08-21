package br.com.sgeescala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



public enum TipoVoluntario{

	COORDENADOR(0,"Coordenador"),
	VOLUNTARIO(1,"Voluntario");
	
	
	private Integer valor;
	private String nome;
	
	private TipoVoluntario(Integer valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
}
