package br.com.ps.webmyclient.generico;

public enum TipoPessoa {

	PESSOA_JURIDICA(1, "Pessoa Jurídica"), 
	PESSOA_FISICA(2, "Pessoa Física");

	private int valor;
	private String descricao;

	private TipoPessoa(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public TipoPessoa descobrePessoa(int valor) {
		if (valor == 2) {
			return TipoPessoa.PESSOA_JURIDICA;
		}
		return TipoPessoa.PESSOA_FISICA;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

}
