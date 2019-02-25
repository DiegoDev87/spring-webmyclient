package br.com.ps.webmyclient.generico;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.ps.webmyclient.cliente.Endereco;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Pessoa extends EntidadeBase {

	private String nome; // nome ou razão social
	private String tipoPessoa; // F = FISICA; J = JURIDICA
	private Endereco endereco;
	private String sexo;

	public Pessoa() {
	}
	
	@NotBlank(message="Informe o Nome/Razão Social")
	@Size(min=3,max=200,message="O Nome/Razão Social deve ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false, length = 200)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "tipo_pessoa", nullable = false, length = 1)
	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Endereco getEndereco() {
		if(this.endereco == null) {
			this.endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Column(name = "sexo", length = 1)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
