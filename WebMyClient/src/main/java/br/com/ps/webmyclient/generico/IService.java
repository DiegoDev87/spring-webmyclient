package br.com.ps.webmyclient.generico;

public interface IService<T> {

	T buscarPorId(int id);

	T salvar(T t);

	boolean excluir(T t);

	boolean excluirPorId(int id);
}
