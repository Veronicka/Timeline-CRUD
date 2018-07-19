package br.com.timelinecrud.util;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.timelinecrud.model.JacksonView;

public class UsuarioJson {
	
	@JsonView(JacksonView.Eager.class)
	public String email;
	
	@JsonView(JacksonView.Eager.class)
	public String senha;
	
	public UsuarioJson() {}
	
	public UsuarioJson(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioJson [email=" + email + ", senha=" + senha + "]";
	}
}
