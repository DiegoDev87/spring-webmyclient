package br.com.ps.webmyclient.generico;

public enum TipoPessoa {
	
	PESSOA_FISICA('F', "Pessoa Física"),
	PESSOA_JURIDICA('J', "Pessoa Jurídica"); 

	private char valor;
	private String descricao;

	private TipoPessoa(char valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public TipoPessoa descobrePessoa(char valor) {
		if (valor == 'J') {
			return TipoPessoa.PESSOA_JURIDICA;
		}
		return TipoPessoa.PESSOA_FISICA;
	}

	public char getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

}
