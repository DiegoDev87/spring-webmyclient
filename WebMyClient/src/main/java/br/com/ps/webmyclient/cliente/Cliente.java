package br.com.ps.webmyclient.cliente;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.ps.webmyclient.generico.Pessoa;

@SuppressWarnings("serial")
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

	private String cpfOuCnpj;
	private String rg;
	private String nomeFantasia;
	private String inscricaoEstadual;
	private String email;
	private LocalDate dataNascimento;

	public Cliente() {
	}

	@Column(name = "cpf_cnpj", length = 20)
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	@Column(name = "rg", length = 10)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "nome_fantasia", length = 200)
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Column(name = "inscricao_estadual", length = 20)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "data_nascimento", length = 10, columnDefinition = "DATE")
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
