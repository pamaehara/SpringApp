package com.integration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {

	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="userName", nullable=false, unique=true)
	@NotEmpty
	@Size(min=3, max=255)
	private String nomeUsuario;

	@Column(name="password", nullable=false, unique=false)
	@NotEmpty
	@Size(min=3, max=255)
	private String senha;

	@Column(name="lastAccess", unique=false)
	@Temporal(TemporalType.DATE)
	private Date ultimoAcesso;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nomeUsuario, String senha, Date ultimoAcesso) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
}