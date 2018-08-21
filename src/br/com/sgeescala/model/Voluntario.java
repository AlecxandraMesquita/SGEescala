package br.com.sgeescala.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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
	
	private String nome;
	private String telefone;
	private String gmail;
	private String cpf;
	private String senha;
	private int codIgreja;
//	private String permissao;
	private String tipo;
	private Turma turma;
	
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getCodIgreja() {
		return codIgreja;
	}

	public void setCodIgreja(int codIgreja) {
		this.codIgreja = codIgreja;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

//	public String getPermissao() {
//		return permissao;
//	}
//
//	public void setPermissao(String permissao) {
//		this.permissao = permissao;
//	}


}
