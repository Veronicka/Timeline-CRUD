package br.com.timelinecrud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 193842L;
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	
	@Column(name = "nome", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "senha", length = 45, nullable = false)
	private String senha;
	
	@Column(name = "email", length = 45, nullable = false)
	private String email;
	
	@Column(name = "telefone", length = 45, nullable = false)
	private String telefone;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<LogOperacoes> logOperacoesList;
				
	public Usuario() { }
	
	public Usuario(Long id, String nome, String senha, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
	}
		
	public Usuario(String nome, String senha, String email, String telefone) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", telefone="
				+ telefone + "]";
	}
}
