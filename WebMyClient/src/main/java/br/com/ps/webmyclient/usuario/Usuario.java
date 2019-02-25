package br.com.ps.webmyclient.usuario;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.ps.webmyclient.generico.EntidadeBase;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeBase implements Serializable {

	private String nome;
	private String sobrenome;
	private String celular;
	private String email;
	private String sexo;
	private Date dataNascimento;
	private boolean ativo = true;
	private String senha;
	private String senhaConfima;
	private String senhaVisivel;

	public Usuario() {
	}

	@NotBlank(message = "Informe o nome.")
	@Column(name = "nome", nullable = false, length = 50)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotBlank(message = "Informe o sobrenome.")
	@Column(name = "sobrenome", nullable = false, length = 50)
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(name = "celular", length = 15)
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@NotBlank(message = "Informe o email.")
	@Email(message="Inform um email valído.")
	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "sexo", length = 1)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", length = 10)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "is_ativo", nullable = false, columnDefinition = "boolean default true")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@NotBlank(message = "Informe a senha.")
	@Size(min = 8, max = 10, message = "A senha deve conter entre {min} e {max} caracteres.")
	@Column(name = "senha", nullable = false, length = 10)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Transient
	public String getSenhaConfima() {
		return senhaConfima;
	}

	public void setSenhaConfima(String senhaConfima) {
		this.senhaConfima = senhaConfima;
	}

	@Column(name = "senha_visivel", nullable = false, length = 10)
	public String getSenhaVisivel() {
		return senhaVisivel;
	}

	public void setSenhaVisivel(String senhaVisivel) {
		this.senhaVisivel = senhaVisivel;
	}

}
