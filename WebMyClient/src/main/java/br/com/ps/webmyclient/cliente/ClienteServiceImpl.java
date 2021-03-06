package br.com.ps.webmyclient.cliente;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	@Override
	public Cliente buscarPorId(int id) {
		if (id > 0) {
			Cliente cliente = repository.findById(id);
			if (cliente != null) {
				return cliente;
			}
		}
		return null;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Cliente salvar(Cliente cliente) {

		if (cliente != null) {
			if (cliente.getEndereco() != null) {
				cliente.getEndereco().setCliente(cliente);
				if (cliente.getEndereco().getCep() == null || cliente.getEndereco().getCep().trim().equals("")) {
					cliente.setEndereco(null);
				}
			}
			Cliente clienteSalvo = repository.save(cliente);
			if (clienteSalvo != null) {
				return clienteSalvo;
			}
		}

		return null;
	}

	@Override
	public boolean excluir(Cliente t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorCnpj(String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<Cliente> todos() {
		List<Cliente> clientes = repository.findAll();
		if (clientes != null && !clientes.isEmpty()) {
			Comparator<Cliente> comparator = (c1, c2) -> (c1.getId() - c2.getId());
			clientes.sort(comparator);
			return clientes;
		}
		return null;
	}

}
