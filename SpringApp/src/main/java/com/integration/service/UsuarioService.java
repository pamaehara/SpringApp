package com.integration.service;

import java.util.List;

import com.integration.model.Usuario;

public interface UsuarioService {

	public Usuario getUsuario(String nomeUsuario, String senha);
	public List<String> inserirUsuario(Usuario usuario);
	public List<String> deletarUsuario(Usuario usuario);
}
