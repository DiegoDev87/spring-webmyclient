package br.com.ps.webmyclient.generico;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import br.com.ps.webmyclient.cliente.Endereco;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Pessoa extends EntidadeBase {

	private String nome; // nome ou razão social
	private char tipoPessoa; // F = FISICA; J = JURIDICA
	private Endereco endereco;

	public Pessoa() {
	}

	@Column(name = "nome", nullable = false, length = 200)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "tipo_pessoa", nullable = false, length = 1)
	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
