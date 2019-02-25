package br.com.ps.webmyclient.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ps.webmyclient.exception.EmailExisteException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Usuario salvar(Usuario usuario) throws EmailExisteException {
		if (usuario != null) {
			if (usuario.getEmail() != null && !usuario.getEmail().isEmpty()) {
				if (usuarioRepository.existsByEmail(usuario.getEmail().trim())) {
					throw new EmailExisteException("E-mail: ".concat(usuario.getEmail().toLowerCase()).concat(" já cadastrado."));
				} else {
					usuario.setSenhaVisivel(usuario.getSenha());
					usuario.setEmail(usuario.getEmail().trim().toLowerCase());
					Usuario usuarioSalvo = usuarioRepository.save(usuario);
					if (usuarioSalvo != null) {
						return usuarioSalvo;
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<Usuario> buscarPorFiltros(UsuarioFiltros filtros) {

		if (filtros != null) {
			List<Usuario> usuarios = usuarioRepository.findByNomeAndSobrenomeAndEmail(filtros.getNome().trim(),
					filtros.getSobrenome().trim(), filtros.getEmail().trim());

			if (usuarios != null && !usuarios.isEmpty()) {
				return usuarios;
			}
		}
		return null;
	}

}
