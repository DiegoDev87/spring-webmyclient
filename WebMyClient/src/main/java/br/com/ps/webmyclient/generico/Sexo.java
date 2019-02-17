package br.com.ps.webmyclient.generico;

public enum Sexo {

	FEMININO("F", "Feminino"), MASCULINO("M", "Masculino");

	private String valor;
	private String descricao;

	private Sexo(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

}
