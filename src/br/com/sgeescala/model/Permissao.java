package br.com.sgeescala.model;

public enum Permissao {
	ROLE_COODENADOR("Administrador"),
	ROLE_CLIENTE("Cliente");
	
	private String nome;
	
	private Permissao(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
