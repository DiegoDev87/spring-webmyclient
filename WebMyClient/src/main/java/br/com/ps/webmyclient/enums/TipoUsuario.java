package br.com.ps.webmyclient.enums;

public enum TipoUsuario {

	USUARIO("Usuário"), 
	ADMINISTRADO("Administrador");

	private String descricao;

	private TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
