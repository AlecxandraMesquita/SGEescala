package br.com.sgeescala.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.ObjectTypeConverter;

import br.unitins.frame.model.Model;

@Entity
public class Voluntario extends Model<Voluntario>{

	private static final long serialVersionUID = -8471667187890042726L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidvoluntario")
	@SequenceGenerator(name = "seqidvoluntario", sequenceName = "seqidvoluntario", allocationSize = 1)
	private Integer id;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "idEchurch_mcv", nullable = false, unique = true)
	private Pessoa pessoa;

	
	private TipoVoluntario tipo;
	private Disponibilidade opcao;
	private String senha;
	private String nome;	

	@ObjectTypeConverter( name = "permissao" , objectType = Permissao.class , dataType = String.class, conversionValues = {
			 @ConversionValue( objectValue = "ROLE_COORDENADOR" , dataValue = "Administrador" ) ,
			 @ConversionValue ( objectValue = "ROLE_CLIENTE" , dataValue = "Cliente" ) } ) 
	
	@Basic
	@Convert  
	@Enumerated(value = EnumType.STRING)
	private Permissao permissao;
	private Status status;
	
	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

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

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoVoluntario getTipo() {
		return tipo;
	}

	public void setTipo(TipoVoluntario tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

//	public int getCodIgreja() {
//		return codIgreja;
//	}
//
//	public void setCodIgreja(int codIgreja) {
//		this.codIgreja = codIgreja;
//	}

	public Disponibilidade getOpcao() {
		return opcao;
	}

	public void setOpcao(Disponibilidade opcao) {
		this.opcao = opcao;
	}

	

}
