package br.com.ps.webmyclient.cliente;

import br.com.ps.webmyclient.generico.IService;

public interface ClienteService extends IService<Cliente> {

	Cliente buscarPorCpf(String cpf);

	Cliente buscarPorCnpj(String cnpj);

}
