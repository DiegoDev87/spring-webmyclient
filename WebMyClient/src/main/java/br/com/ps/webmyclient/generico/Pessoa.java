package br.com.ps.webmyclient.generico;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import br.com.ps.webmyclient.cliente.Endereco;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Pessoa extends EntidadeBase {

	private String nome; // nome ou razão social
	private TipoPessoa tipoPessoa;
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

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", nullable = false, length = 15)
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
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
