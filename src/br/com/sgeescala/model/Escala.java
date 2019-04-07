package br.com.sgeescala.model;


import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Escala extends Model<Escala>{

	private static final long serialVersionUID = -3906275387415336590L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidescala")
	@SequenceGenerator(name = "seqidescala", sequenceName = "seqidescala", allocationSize = 1)

	private Integer id;
	private Evento evento;
	private CorEquipes corE;
	private Voluntario voluntario; 
	
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	public Voluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
	public CorEquipes getCorE() {
		return corE;
	}

	public void setCorE(CorEquipes corE) {
		this.corE = corE;
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
