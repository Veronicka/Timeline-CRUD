package br.com.timelinecrud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.timelinecrud.model.LogOperacoes;

public interface LogOperacoesRepository extends CrudRepository<LogOperacoes, Long>{
	
	public LogOperacoes findById(Long id);
	public List<LogOperacoes> findByUsuarioId(Long id);
	
	//@Query("select l from LogOperacoes l where l.usuarioId = :id")
	//public List<LogOperacoes> logOperacoesByNome(String nome);

}
