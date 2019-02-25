package br.com.ps.webmyclient.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	boolean existsByEmail(String email);

	Usuario findById(int id);

	Usuario findByNome(String nome);

	Usuario findBySobrenome(String sobrenome);

	Usuario findByNomeAndSobrenome(String nome, String sobrenome);

	Usuario findByNomeOrSobrenome(String nome, String sobrenome);

	List<Usuario> findByNomeAndSobrenomeAndEmail(String nome, String sobrenome, String email);

}
