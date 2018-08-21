package br.com.sgeescala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Pessoa extends Model<Pessoa>{

	private static final long serialVersionUID = 3038686429527619531L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidpessoa")
	@SequenceGenerator(name = "seqidpessoa", sequenceName = "seqidpessoa", allocationSize = 1)
	private Integer id;
	
	private String nome;
	private String telefone;
	private String gmail;
	private String cpf;
	private int codIgreja;
	//private DATE dtcadastro;
	
	public Integer getId() {
		return id;
	}
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
	public int getCodIgreja() {
		return codIgreja;
	}
	public void setCodIgreja(int codIgreja) {
		this.codIgreja = codIgreja;
	}
	
	
}
