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
import br.com.timelinecrud.repository.LogOperacoesRepository;

@Controller
@RequestMapping(value = "/log")
public class LogOperacoesController {
	
	@Autowired
	private LogOperacoesRepository logOperacoesRepo;
	
	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody LogOperacoes salvar(@RequestBody LogOperacoes logOperacoes) {
		try {
			logOperacoes.setDataHora(Calendar.getInstance());
			return logOperacoesRepo.save(logOperacoes);

		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll() {
		return new ResponseEntity<List<LogOperacoes>>((List<LogOperacoes>) logOperacoesRepo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByUserId", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getByUsuarioId(Long id) {
		return new ResponseEntity<List<LogOperacoes>>((List<LogOperacoes>) logOperacoesRepo.findByUsuarioId(id), HttpStatus.OK);
	}

	public void setLogOperacoesRepo(LogOperacoesRepository logOperacoesRepo) {
		this.logOperacoesRepo = logOperacoesRepo;
	}
}
