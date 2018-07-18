package br.com.timelinecrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.timelinecrud.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	public Usuario findById(Long id);
	public Usuario findByNome(String nome);
	public List<Usuario> findUsuarioById(Long id);
	
	@Query("select u from Usuario u where u.nome like %?1%")
	public List<Usuario> listaUsuariosNome(String nome);
	
}
