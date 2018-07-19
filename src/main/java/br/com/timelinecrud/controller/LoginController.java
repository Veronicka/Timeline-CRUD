package br.com.timelinecrud.controller;

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
import br.com.timelinecrud.model.Usuario;
import br.com.timelinecrud.repository.UsuarioRepository;
import br.com.timelinecrud.util.UsuarioJson;
import br.com.timelinecrud.util.UsuarioLogadoJson;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Transactional
	@JsonView(JacksonView.Eager.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody UsuarioJson usuario) {
		Usuario user = null;
		try {
			user = usuarioRepo.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
			System.out.println(user);
			if(user == null) 
				return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
			else {
				UsuarioLogadoJson usuarioLogado = new UsuarioLogadoJson(user.getNome(), user.getEmail(), true);
				return new ResponseEntity<>(usuarioLogado, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao logar usuario "+ e);
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
	
	}

}
