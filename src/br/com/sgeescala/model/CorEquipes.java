package br.com.sgeescala.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class CorEquipes extends Model<CorEquipes>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static final long serialVersionUID = -7478099533422424215L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidcorequipes")
	@SequenceGenerator(name = "seqidcorequipes", sequenceName = "seqidcorequipes", allocationSize = 1)
	
	private Integer id;
	private String nome;
	private String descricao;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
