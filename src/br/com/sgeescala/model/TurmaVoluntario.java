package br.com.sgeescala.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class TurmaVoluntario extends Model<TurmaVoluntario>{

	private static final long serialVersionUID = 6855011554434601547L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidturmavoluntario")
	@SequenceGenerator(name = "seqidturmavoluntario", sequenceName = "seqidturmavoluntario", allocationSize = 1)
	private Integer id;
	private String nome;
	
	private CorEquipes cor;
	
	private Voluntario voluntario;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CorEquipes getCor() {
		return cor;
	}
	
	public void setCor(CorEquipes cor) {
		this.cor = cor;
	}

	public Voluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
	
}
