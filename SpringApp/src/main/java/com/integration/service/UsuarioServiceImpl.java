package com.integration.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integration.dao.UsuarioDAO;
import com.integration.model.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario getUsuario(String nomeUsuario, String senha) {
		return usuarioDAO.getUsuario(nomeUsuario, senha);
	}

	@Override
	public List<String> inserirUsuario(Usuario usuario) {
		// validacao
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

		if(constraintViolations != null && constraintViolations.size() > 0) {
			List<String> erros = new ArrayList<String>();
			constraintViolations.forEach(erro -> erros.add(erro.getMessage()));
			return erros;
		}
		
		// insert
		usuario.setUltimoAcesso(new Date());
		usuarioDAO.inserirUsuario(usuario);
		
		return null;
	}

	@Override
	public List<String> deletarUsuario(Usuario usuario) {
		// TODO: implementar
		return null;
	}

}
