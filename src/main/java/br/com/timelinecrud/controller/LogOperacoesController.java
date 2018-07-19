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

import com.fasterxml.jackson.annotation.JsonView;

import br.com.timelinecrud.model.JacksonView;
import br.com.timelinecrud.model.LogOperacoes;
import br.com.timelinecrud.model.Usuario;
import br.com.timelinecrud.repository.LogOperacoesRepository;
import br.com.timelinecrud.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/log")
public class LogOperacoesController {
	
	@Autowired
	private LogOperacoesRepository logOperacoesRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Transactional
	@JsonView(JacksonView.Eager.class)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody LogOperacoes salvar(@RequestBody LogOperacoes logOperacoes) {
		try {
			logOperacoes.setDataHora(Calendar.getInstance());
			return logOperacoesRepo.save(logOperacoes);

		} catch (Exception e) {
			return null;
		}
	}
	
	@JsonView(JacksonView.Eager.class)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		return new ResponseEntity<List<LogOperacoes>>((List<LogOperacoes>) logOperacoesRepo.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JacksonView.Eager.class)
	@RequestMapping(value = "/getByUserId", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getByUsuarioId(Long id) {
		Usuario u = usuarioRepo.findById(id);
		LogOperacoes logOperacoes = new LogOperacoes();
		logOperacoes.setDataHora(Calendar.getInstance());
		logOperacoes.setDetalhe("Usuario Visualizado");
		logOperacoes.setUsuario(u);
		logOperacoesRepo.save(logOperacoes);
		return new ResponseEntity<List<LogOperacoes>>((List<LogOperacoes>) logOperacoesRepo.findByUsuarioId(id), HttpStatus.OK);
	}
	
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	public void setLogOperacoesRepo(LogOperacoesRepository logOperacoesRepo) {
		this.logOperacoesRepo = logOperacoesRepo;
	}
}
