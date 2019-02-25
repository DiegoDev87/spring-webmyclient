package br.com.ps.webmyclient.usuario;

import java.util.List;

import br.com.ps.webmyclient.exception.EmailExisteException;

public interface UsuarioService {

	Usuario salvar(Usuario usuario) throws EmailExisteException;

	List<Usuario> buscarPorFiltros(UsuarioFiltros filtros);
}
