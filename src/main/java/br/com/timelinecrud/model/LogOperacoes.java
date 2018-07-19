package br.com.timelinecrud.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "LOG_OPERACOES")
public class LogOperacoes implements Serializable{
	
	private static final long serialVersionUID = 7832837L;
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "log_id")
	@JsonView(JacksonView.Eager.class)
	private Long id;
	
	@Column(name = "detalhe", length = 45, nullable = false)
	@JsonView(JacksonView.Eager.class)
	private String detalhe;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora", nullable = false)
	@JsonView(JacksonView.Eager.class)
	private Calendar dataHora;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "usuario_id", nullable = true)
	@JsonView(JacksonView.Eager.class)
	@JsonIgnore
	private Usuario usuario;
	
	public LogOperacoes() {	}

	public LogOperacoes(String detalhe, Calendar dataHora, Usuario usuario) {
		this.detalhe = detalhe;
		this.dataHora = dataHora;
		this.usuario = usuario;
	}
	
	public LogOperacoes(String detalhe, Usuario usuario) {
		this.detalhe = detalhe;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "LogOperacoes [id=" + id + ", detalhe=" + detalhe + ", dataHora=" + dataHora + ", usuario=" + usuario
				+ "]";
	}	
}
