package br.com.timelinecrud.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.timelinecrud.model.LogOperacoes;
import br.com.timelinecrud.model.Usuario;
import br.com.timelinecrud.repository.LogOperacoesRepository;
import br.com.timelinecrud.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private LogOperacoesRepository logOperacoesRepo;

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Usuario salvar(@RequestBody Usuario usuario) {
		System.out.println(usuario);
		LogOperacoes logOperacoes = new LogOperacoes();
		if(usuario.getId() == 0) logOperacoes.setDetalhe("Usuario criado");
		else logOperacoes.setDetalhe("Usuario modificado");
		
		Usuario user = null;
		try {
			user = usuarioRepo.save(usuario);
		} catch (Exception e) {
			System.err.println("Erro ao salvar usuario");
			return null;
		}
				
		try {
			logOperacoes.setDataHora(Calendar.getInstance());
			logOperacoes.setUsuario(user);
			logOperacoesRepo.save(logOperacoes);
			return user;

		} catch (Exception e) {
			System.err.println("Erro ao salvar log de operacoes");
			return null;
		}
	}
	
	@Transactional
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> remove(@RequestBody Long id) {
		Usuario user = usuarioRepo.findById(id);
		try {
			usuarioRepo.delete(id);
			logOperacoesRepo.save(new LogOperacoes("Usuario deletado", Calendar.getInstance(), user));
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public @ResponseBody Usuario buscarId(Long id) {
		return usuarioRepo.findById(id);
	}

	@RequestMapping(value = "/getByName", method = RequestMethod.GET)
	public @ResponseBody Usuario buscarNome(String nome) {
		return usuarioRepo.findByNome(nome);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Usuario>>((List<Usuario>) usuarioRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getByNames", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> buscarNomes(String nome) {
		return usuarioRepo.listaUsuariosNome(nome);
	}

	@RequestMapping(value = "/getByIds", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> buscarListaId(Long id) {
		return usuarioRepo.findUsuarioById(id);
	}

	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}
	
	public void setLogOperacoesRepo(LogOperacoesRepository logOperacoesRepo) {
		this.logOperacoesRepo = logOperacoesRepo;
	}
}
