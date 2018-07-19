package br.com.timelinecrud.util;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.timelinecrud.model.JacksonView;

public class UsuarioLogadoJson implements Serializable{
	
	private static final long serialVersionUID = 88120397L;
	
	@JsonView(JacksonView.Eager.class)
	public String nome;
	@JsonView(JacksonView.Eager.class)
	public String email;
	@JsonView(JacksonView.Eager.class)
	public boolean flag;
	
	public UsuarioLogadoJson() {}
	
	public UsuarioLogadoJson(String nome, String email, boolean flag) {
		super();
		this.nome = nome;
		this.email = email;
		this.flag = flag;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "UsuarioLogadoJson [nome=" + nome + ", email=" + email + ", flag=" + flag + "]";
	}
}
