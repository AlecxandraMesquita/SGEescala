package br.com.sgeescala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Turma extends Model<Turma>{

	private static final long serialVersionUID = 6855011554434601547L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidturma")
	@SequenceGenerator(name = "seqidturma", sequenceName = "seqidturma", allocationSize = 1)
	private Integer id;
	private String nome;
	private String cor;
	
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


}
