package br.com.sgeescala.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import br.unitins.frame.model.Model;

@Entity
public class Evento extends	Model<Evento> {

	private static final long serialVersionUID = -2529121672105222312L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidevento")
	@SequenceGenerator(name = "seqidevento", sequenceName = "seqidevento", allocationSize = 1)
	private Integer id;
	
	//@Temporal(TemporalType.DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	private String nome;
	
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stubLocalTime
		return id;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
