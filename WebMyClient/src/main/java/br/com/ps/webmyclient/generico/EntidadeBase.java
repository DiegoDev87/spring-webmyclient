package br.com.ps.webmyclient.generico;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class EntidadeBase implements Serializable {

	private int id;
	private LocalDate dataCadastro;
	private LocalDate horaCadastro;
	private LocalDate dataAlteracao;
	private LocalDate horaAlteracao;

	public EntidadeBase() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "data_cadastro", nullable = false, updatable = false, columnDefinition = "DATE")
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "hora_cadastro", nullable = false, updatable = false, columnDefinition = "TIME")
	public LocalDate getHoraCadastro() {
		return horaCadastro;
	}

	public void setHoraCadastro(LocalDate horaCadastro) {
		this.horaCadastro = horaCadastro;
	}

	@Column(name = "data_alteracao", nullable = true, updatable = true, columnDefinition = "DATE")
	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Column(name = "hora_alteracao", nullable = true, updatable = true, columnDefinition = "TIME")
	public LocalDate getHoraAlteracao() {
		return horaAlteracao;
	}

	public void setHoraAlteracao(LocalDate horaAlteracao) {
		this.horaAlteracao = horaAlteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeBase other = (EntidadeBase) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
