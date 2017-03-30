package com.integration.dao;

import com.integration.model.Usuario;

public interface UsuarioDAO {

	public Usuario getUsuario(String nomeUsuario, String senha);

	public void inserirUsuario(Usuario usuario);

	public void deletarUsuario(Usuario usuario);

}