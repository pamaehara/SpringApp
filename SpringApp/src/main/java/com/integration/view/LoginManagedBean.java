package com.integration.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.integration.model.Usuario;
import com.integration.service.UsuarioService;

@Component("LoginMB")
@Scope("session")
public class LoginManagedBean {

	@Autowired
	private UsuarioService usuarioService;
	private Usuario usuario = new Usuario();

	public String envia() {
		usuario = usuarioService.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/cadastro_usuario";
		}
	}

	public String inserirUsuario() {
		List<String> msgs = usuarioService.inserirUsuario(usuario);
		if (msgs != null) {
			msgs.forEach(erro -> 
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, "Erro no cadastro!")));
			return null;
		} else {
			return "/cadastro_usuario";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}