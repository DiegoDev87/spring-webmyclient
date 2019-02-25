package br.com.ps.webmyclient.enums;

public enum TipoPerfil {

	ROLE_ADMIN("Perfil Administrado"), ROLE_USUARIO("Pefil Usuário");

	private String descricao;

	private TipoPerfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
