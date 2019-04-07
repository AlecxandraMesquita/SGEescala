package br.com.sgeescala.model;

public enum TipoEvento {

	PADRAO(0,"Padrao"),
	EXTRA(1,"Extra");
	
	
	private Integer valor;
	private String nome;
	
	private TipoEvento(Integer valor, String nome) {
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
