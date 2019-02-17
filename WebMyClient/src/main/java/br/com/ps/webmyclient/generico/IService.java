package br.com.ps.webmyclient.generico;

import java.util.List;

public interface IService<T> {

	T buscarPorId(int id);

	T salvar(T t);

	boolean excluir(T t);

	boolean excluirPorId(int id);
	
	List<T> todos();
}
